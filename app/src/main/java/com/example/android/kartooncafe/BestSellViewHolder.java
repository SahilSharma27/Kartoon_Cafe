package com.example.android.kartooncafe;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BestSellViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView1, imageView2, imageView3;
    TextView textView1, textView2, textView3;
    Button addButton;
    View itemView;

    public BestSellViewHolder(@NonNull View itemView) {
        super(itemView);
        this.itemView = itemView;
        imageView1 = itemView.findViewById(R.id.best_seller_backdrop);
        imageView2 = itemView.findViewById(R.id.best_seller_type1);
        imageView3 = itemView.findViewById(R.id.best_seller_type2);
        textView1 = itemView.findViewById(R.id.best_seller_title);
        textView2 = itemView.findViewById(R.id.best_seller_price);
        textView3 = itemView.findViewById(R.id.best_seller_desc);
        addButton = itemView.findViewById(R.id.beast_seller_add);

    }
}
