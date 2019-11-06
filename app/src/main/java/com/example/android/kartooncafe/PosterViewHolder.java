package com.example.android.kartooncafe;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

public class PosterViewHolder extends RecyclerView.ViewHolder {
    ImageView posterImg;
    TextView posterTitle;
    View itemView;
    public PosterViewHolder(@NonNull View itemView) {
        super(itemView);
        this.itemView=itemView;
        posterImg=itemView.findViewById(R.id.poster_img);
        posterTitle=itemView.findViewById(R.id.posterTitle);
    }
}
