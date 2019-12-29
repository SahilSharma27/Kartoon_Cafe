package com.example.android.kartooncafe;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.kartooncafe.ui.tableReservation.ReservationFragment;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class CustomAdapter2A extends RecyclerView.Adapter<ItemViewHolder2> {
    private ArrayList<Item> subMenuList;
    private Context context;
    private String radValue;
    private ArrayList<String> customValuesList = new ArrayList<>();
    private int clickedRadPos = 0;
    private String selectedRad;

    public CustomAdapter2A(Context context, ArrayList<Item> SubMenu) {
        this.context = context;
        this.subMenuList = SubMenu;
    }

    @NonNull
    @Override
    public ItemViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowlayout = inflater.inflate(R.layout.sub_menu_list_item, parent, false);
        return new ItemViewHolder2(rowlayout);


    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder2 holder, int position) {
        final Item currentItem = subMenuList.get(position);

        holder.titleView.setText(currentItem.getItemName());
        if (currentItem.getItemDescription().equals("null") || currentItem.getItemDescription().equals("")) {
            holder.descView.setVisibility(View.GONE);
        } else {
            holder.descView.setText(currentItem.getItemDescription());
        }

        holder.priceView.setText("₹ " + currentItem.getItemPrice());

        if (currentItem.getItemCategory() == 0) {
            holder.catgView1.setImageResource(R.drawable.veg_icon);
            holder.catgView2.setVisibility(View.INVISIBLE);
        } else if (currentItem.getItemCategory() == 1) {
            holder.catgView1.setImageResource(R.drawable.non_veg_icon);
            holder.catgView2.setVisibility(View.INVISIBLE);
        } else if (currentItem.getItemCategory() == 2) {
            holder.catgView1.setImageResource(R.drawable.veg_icon);
            holder.catgView2.setImageResource((R.drawable.non_veg_icon));
        } else if (currentItem.getItemCategory() == 3) {
            holder.catgView1.setImageResource(R.drawable.egg_icon);
            holder.catgView2.setVisibility(View.INVISIBLE);
        }
//        if (currentItem.getCustomizable() == 0) {
//            holder.custButton.setVisibility(View.GONE);
//
//        }
        holder.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  Toast.makeText(context, currentItem.getCustomList().get(0).getCustomName() +" to Cart",Toast.LENGTH_LONG).show();
                if (currentItem.getCustomizable() == 0) {
                    Cart cartItem = new Cart(currentItem.getItemName(), 1, currentItem.getItemPrice());
                    cartItem.setCustom(null);
                    cartItem.setCustomPrice(0.0);
                    cartItem.setCartItemCategory(currentItem.getItemCategory());
                    cartItem.setCartItemType(ReservationFragment.TABLE_RESERVATION_KEY);
                    CartHelper.addItemToCart(context, cartItem);
                    // Toast.makeText(context, "ADDED TO CART", Toast.LENGTH_LONG).show();
                    Snackbar.make(view, "Added To Cart", Snackbar.LENGTH_SHORT)
                            .setAction("Action", null).show();


//                    Cart cartItem = new Cart(currentItem, 1, currentItem.getItemPrice());
//                    OrderAheadSubMenu.reservationCart.add(cartItem);
                } else {
                    customValuesList.clear();
                    radValue = "";
                    clickedRadPos = 0;
                    for (int i = 0; i < currentItem.getCustomList().size(); i++) {
                        if (currentItem.getCustomList().get(i).getCustomPrice() == 0.0) {
                            radValue = currentItem.getCustomList().get(i).getCustomName();
                        } else {
                            radValue = currentItem.getCustomList().get(i).getCustomName()
                                    + "  ( + ₹" + currentItem.getCustomList().get(i).getCustomPrice() + ")";
                        }
                        customValuesList.add(radValue);
                    }

                    selectedRad = customValuesList.get(0);
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("Select one(Required)");
                    builder.setSingleChoiceItems(customValuesList.toArray(new String[customValuesList.size()]), 0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            clickedRadPos = i;
                            selectedRad = customValuesList.get(i);
                        }
                    });

                    builder.setPositiveButton("ADD to Cart", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(context, selectedRad, Toast.LENGTH_LONG).show();
                            customValuesList.clear();
                            Cart cartItem = new Cart(currentItem.getItemName(), 1, currentItem.getItemPrice());
                            double customPrice = currentItem.getCustomList().get(clickedRadPos).getCustomPrice();
                            int custType = currentItem.getCustomList().get(clickedRadPos).getCustType();
                            cartItem.setCustom(selectedRad);
                            cartItem.setCustomPrice(customPrice);
                            cartItem.setCartItemCategory(custType);
                            cartItem.setCartItemType(ReservationFragment.TABLE_RESERVATION_KEY);
                            CartHelper.addItemToCart(context, cartItem);
//                            Cart cartItem = new Cart(currentItem, 1, currentItem.getItemPrice());
//                            double customPrice = currentItem.getCustomList().get(clickedRadPos).getCustomPrice();
//                            int custType = currentItem.getCustomList().get(clickedRadPos).getCustType();
//                            cartItem.setCustom(new Customizables(selectedRad, customPrice, custType));
//
//                            OrderAheadSubMenu.reservationCart.add(cartItem);
                            // CartActivity.cartItemPrices.add(currentItem.getItemPrice());
                        }
                    });

                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //TODO
                        }
                    });

                    builder.show();
                }
            }
        });
    }

//        holder.custButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                customValuesList.clear();
//                radValue = "";
//                clickedRadPos = 0;
//                for (int i = 0; i < currentItem.getCustomList().size(); i++) {
//                    if (currentItem.getCustomList().get(i).getCustomPrice() == 0.0) {
//                        radValue = currentItem.getCustomList().get(i).getCustomName();
//                    } else {
//                        radValue = currentItem.getCustomList().get(i).getCustomName()
//                                + "  ( + ₹" + currentItem.getCustomList().get(i).getCustomPrice() + ")";
//                    }
//                    customValuesList.add(radValue);
//                }
//
//                selectedRad = customValuesList.get(0);
//                AlertDialog.Builder builder = new AlertDialog.Builder(context);
//                builder.setTitle("Select one(Required)");
//                builder.setSingleChoiceItems(customValuesList.toArray(new String[customValuesList.size()]), 0, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        clickedRadPos = i;
//                        selectedRad = customValuesList.get(i);
//                    }
//                });
//
//                builder.setPositiveButton("ADD to Cart", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Toast.makeText(context, selectedRad, Toast.LENGTH_LONG).show();
//                        customValuesList.clear();
//
//                        Cart cartItem = new Cart(currentItem, 1, currentItem.getItemPrice());
//                        double customPrice = currentItem.getCustomList().get(clickedRadPos).getCustomPrice();
//                        int custType = currentItem.getCustomList().get(clickedRadPos).getCustType();
//                        cartItem.setCustom(new Customizables(selectedRad, customPrice, custType));
//
//                        OrderAheadSubMenu.reservationCart.add(cartItem);
//                        // CartActivity.cartItemPrices.add(currentItem.getItemPrice());
//                    }
//                });
//
//                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        //TODO
//                    }
//                });
//
//                builder.show();
//            }
//        });
//
//    }

    @Override
    public int getItemCount() {
        return subMenuList.size();
    }
}
