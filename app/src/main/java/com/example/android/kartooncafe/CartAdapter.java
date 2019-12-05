package com.example.android.kartooncafe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.kartooncafe.ui.tableReservation.ReservationFragment;

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

                CartHelper.removeItemFromCart(context, currentCartItem);
                finalCartItemsList.remove(pos);

                if (context instanceof CartActivity) {
                    CartActivity.Refresh();
                } else {
                    ReservationFragment.Refresh();
                }
                notifyDataSetChanged();


            }

        });
        if (currentCartItem.getCustom() != null) {
            holder.cartItemCutsomize.setVisibility(View.VISIBLE);
            holder.cartItemCutsomize.setText(currentCartItem.getCustom());
        } else holder.cartItemCutsomize.setVisibility(View.GONE);

        holder.cartItemPrice.setText("₹ " + currentCartItem.getPrice() * currentCartItem.getQuantity());

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
                holder.cartItemPrice.setText("₹ " + newQty * currentCartItem.getPrice());
                currentCartItem.setQuantity(newQty);
                int id = currentCartItem.getCartItemId();
                CartHelper.updateCartItemQty(context, id, newQty);
                if (context instanceof CartActivity)
                    CartActivity.Refresh();
                else {
                    ReservationFragment.Refresh();
                }
                notifyDataSetChanged();
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
                holder.cartItemPrice.setText("₹ " + newQty * currentCartItem.getPrice());
                currentCartItem.setQuantity(newQty);
                int id = currentCartItem.getCartItemId();
                CartHelper.updateCartItemQty(context, id, newQty);

                if (context instanceof CartActivity)
                    CartActivity.Refresh();
                else {
                    ReservationFragment.Refresh();
                }


                notifyDataSetChanged();

            }
        });


        holder.cartItemName.setText(currentCartItem.getCartItemName());

        if (currentCartItem.getCartItemCategory() == 0) {
            holder.cartItemType.setImageResource(R.drawable.veg_icon);
        } else if (currentCartItem.getCartItemCategory() == 3) {
            holder.cartItemType.setImageResource(R.drawable.egg_icon);
        } else if (currentCartItem.getCartItemCategory() == 1) {
            holder.cartItemType.setImageResource(R.drawable.non_veg_icon);
        }

        if (currentCartItem.getCustom() != null) {
            holder.cartItemCutsomize.setText(currentCartItem.getCustom());
        } else holder.cartItemCutsomize.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return finalCartItemsList.size();
    }
}


