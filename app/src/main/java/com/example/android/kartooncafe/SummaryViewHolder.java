package com.example.android.kartooncafe;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SummaryViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView itemName;
    TextView qtyTextView;
    View itemView;

    public SummaryViewHolder(@NonNull View itemView) {
        super(itemView);
        this.itemView=itemView;
        imageView = itemView.findViewById(R.id.summary_item_icon);
        itemName = itemView.findViewById(R.id.summary_item_name);
        qtyTextView = itemView.findViewById(R.id.summary_item_qty);


    }
}
