package com.example.android.kartooncafe;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CartViewHolder extends RecyclerView.ViewHolder {
    View itemVIew;
    ImageView cartItemType;
    TextView cartItemCutsomize;
    TextView cartItemName;
    Button plusbutton;
    Button minusButton;
    TextView cartItemQty;

    TextView cartItemPrice;
    ImageButton deleteButton;
    public CartViewHolder(@NonNull View itemView) {
        super(itemView);
        this.itemVIew=itemView;
        cartItemType=itemView.findViewById(R.id.cart_item_type);

        cartItemCutsomize=itemView.findViewById(R.id.cart_customs);
        cartItemName=itemView.findViewById(R.id.cart_item_name);
        plusbutton=itemView.findViewById(R.id.increase_qty);
        minusButton=itemView.findViewById(R.id.decrease_qty);
        cartItemQty=itemView.findViewById(R.id.cart_item_quantity);
        deleteButton=itemView.findViewById(R.id.delete_cart_item);
        cartItemPrice=itemView.findViewById(R.id.cart_item_price);

    }
}
