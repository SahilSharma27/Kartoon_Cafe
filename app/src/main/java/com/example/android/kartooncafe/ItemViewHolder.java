package com.example.android.kartooncafe;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView textView;
    View itemView;

    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);
        this.itemView=itemView;
        imageView=itemView.findViewById(R.id.menu_image);
        textView=itemView.findViewById(R.id.menu_text);

    }
}
