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

import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class BestSellerAdapter extends RecyclerView.Adapter<BestSellViewHolder> {
    private ArrayList<BestSellerItem> bestSellerList;
    private Context context;
    private String radValue;
    private ArrayList<String> customValuesList = new ArrayList<>();
    private int clickedRadPos = 0;
    private String selectedRad;

    public BestSellerAdapter(Context context, ArrayList<BestSellerItem> bestSellerList) {

        this.context = context;
        this.bestSellerList = bestSellerList;
    }

    @NonNull
    @Override
    public BestSellViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowlayout = inflater.inflate(R.layout.best_seller_item_layout, parent, false);
        return new BestSellViewHolder(rowlayout);
    }

    @Override
    public void onBindViewHolder(@NonNull BestSellViewHolder holder, int position) {
        final BestSellerItem currentItem = bestSellerList.get(position);
        //  holder.imageView1.setImageResource(currentItem.getBackDropId());
        Glide.with(holder.imageView1.getContext()).load(currentItem.getBackDropId()).into(holder.imageView1);
        holder.textView1.setText(currentItem.getItemName());
        if (currentItem.getItemDescription().equals("null") || currentItem.getItemDescription().equals("")) {
            holder.textView3.setVisibility(View.GONE);
        } else {
            holder.textView3.setText(currentItem.getItemDescription());
        }
        holder.textView2.setText("₹ " + currentItem.getItemPrice());
        if (currentItem.getItemCategory() == 0) {
            holder.imageView2.setImageResource(R.drawable.veg_icon);
            holder.imageView3.setVisibility(View.INVISIBLE);
        } else if (currentItem.getItemCategory() == 1) {
            holder.imageView2.setImageResource(R.drawable.non_veg_icon);
            holder.imageView3.setVisibility(View.INVISIBLE);
        } else if (currentItem.getItemCategory() == 2) {
            holder.imageView2.setImageResource(R.drawable.veg_icon);
            holder.imageView3.setImageResource((R.drawable.non_veg_icon));
        }

        holder.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (currentItem.getCustomizable() == 1) {
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
                            cartItem.setCartItemType(CartActivity.ORDER_KEY);
                            CartHelper.addItemToCart(context, cartItem);
                        }
                    });

                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //TODO
                        }
                    });

                    builder.show();
                    Snackbar.make(view, "Added To Cart", Snackbar.LENGTH_SHORT)
                            .setAction("Action", null).show();
                    //Toast.makeText(context, "ADDED TO CART", Toast.LENGTH_LONG).show();
                } else {
                    Snackbar.make(view, "Added To Cart", Snackbar.LENGTH_SHORT)
                            .setAction("Action", null).show();
                    //    Toast.makeText(context, "Added to cart", Toast.LENGTH_LONG).show();

                    Cart cartItem = new Cart(currentItem.getItemName(), 1, currentItem.getItemPrice());
                    cartItem.setCustom(null);
                    cartItem.setCustomPrice(0.0);
                    cartItem.setCartItemCategory(currentItem.getItemCategory());
                    cartItem.setCartItemType(CartActivity.ORDER_KEY);
                    CartHelper.addItemToCart(context, cartItem);

                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return bestSellerList.size();
    }
}
