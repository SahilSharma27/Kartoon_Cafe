package com.example.android.kartooncafe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartViewHolder> {
    private Context context;
   private ArrayList<Cart> finalCartItemsList;


    public CartAdapter(Context context, ArrayList<Cart> cartList) {

        this.context = context;
        this.finalCartItemsList = cartList;

    }


    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowlayout = inflater.inflate(R.layout.cart_item_layout, parent, false);
        return new CartViewHolder(rowlayout);

    }

    @Override
    public void onBindViewHolder(@NonNull final CartViewHolder holder, int position) {
        final Cart currentCartItem = finalCartItemsList.get(position);

        final int pos = position;
        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (context instanceof CartActivity) {
                    SubMenuActivity.cartItems.remove(pos);
                    CartActivity.cartItemPrices.remove(pos);
                    notifyDataSetChanged();
                } else {
                    OrderAheadSubMenu.reservationCart.remove(pos);
                    notifyDataSetChanged();
                }


            }

        });
        if (currentCartItem.getCustom() != null) {
            holder.cartItemCutsomize.setVisibility(View.VISIBLE);
            holder.cartItemCutsomize.setText(currentCartItem.getCustom().getCustomName());
        } else holder.cartItemCutsomize.setVisibility(View.GONE);

        holder.cartItemPrice.setText("₹ " + currentCartItem.getCartItem().getItemPrice());

        holder.cartItemQty.setText(String.valueOf(currentCartItem.getQuantity()));

        holder.plusbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentQty = Integer.valueOf(holder.cartItemQty.getText().toString());
                if (currentQty == 1) {
                    holder.minusButton.setClickable(true);

                }
                int newQty = currentQty + 1;
                holder.cartItemQty.setText(String.valueOf(newQty));
                holder.cartItemPrice.setText("₹ " + newQty * currentCartItem.getCartItem().getItemPrice());

            }
        });
        holder.minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentQty = Integer.valueOf(holder.cartItemQty.getText().toString());
                if (currentQty == 1) {
                    holder.minusButton.setClickable(false);
                    return;
                }
                int newQty = currentQty - 1;
                holder.cartItemQty.setText(String.valueOf(newQty));
                holder.cartItemPrice.setText("₹ " + newQty * currentCartItem.getCartItem().getItemPrice());
            }
        });


        holder.cartItemName.setText(currentCartItem.getCartItem().getItemName());

        // if item is pure veg(0) then type is veg(0), if item is non-veg(1) then type is also non-veg(1)
        // if item has options(2) then it depends on customs type if custom is 0 then type is 0 if custom
        // is 1 then type is 1
        if (currentCartItem.getCartItem().getItemCategory()==0){
            holder.cartItemType.setImageResource(R.drawable.veg_icon);
        }
        else if(currentCartItem.getCartItem().getItemCategory()==1) {
            holder.cartItemType.setImageResource(R.drawable.non_veg_icon);
        } else if (currentCartItem.getCartItem().getItemCategory() == 3) {
            holder.cartItemType.setImageResource(R.drawable.egg_icon);
        } else if (currentCartItem.getCartItem().getItemCategory() == 2) {
            if(currentCartItem.getCustom().getCustType()==0){
                holder.cartItemType.setImageResource(R.drawable.veg_icon);
            } else if (currentCartItem.getCustom().getCustType() == 1) {
                holder.cartItemType.setImageResource(R.drawable.non_veg_icon);
            }
        }

//        if(currentCartItem.getCustom()!=null){
//            holder.cartItemCutsomize.setText(currentCartItem.getCustom().getCustomName());
//        }
//        else holder.cartItemCutsomize.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return finalCartItemsList.size();
    }
}


