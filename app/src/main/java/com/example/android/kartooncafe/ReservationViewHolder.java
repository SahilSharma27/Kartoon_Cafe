package com.example.android.kartooncafe;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


public class ReservationViewHolder extends RecyclerView.ViewHolder {
    View itemView;
    TextView textView;
    CardView layout;
    public ReservationViewHolder(@NonNull View itemView) {
        super(itemView);
        this.itemView=itemView;
        textView=itemView.findViewById(R.id.reservationText);
        layout=itemView.findViewById(R.id.reservationCard);
    }
}
