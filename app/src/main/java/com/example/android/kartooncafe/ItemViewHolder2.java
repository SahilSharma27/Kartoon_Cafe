package com.example.android.kartooncafe;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolder2 extends RecyclerView.ViewHolder {
    TextView titleView;
    TextView descView;
    TextView priceView;
    ImageView catgView1;
    ImageView catgView2;
    Button addButton;
    Button custButton;
    ItemButtonClickListener listener;



    View itemView;


    public ItemViewHolder2(@NonNull View itemView) {
        super(itemView);
        this.itemView = itemView;
//        this.listener=listener;
        //    Context context=itemView.getContext();

        titleView = itemView.findViewById(R.id.item_title);
        descView = itemView.findViewById(R.id.item_description);
        priceView = itemView.findViewById(R.id.item_price);
        catgView1 = itemView.findViewById(R.id.catgView);
        catgView2 = itemView.findViewById(R.id.catgView2);
        addButton = itemView.findViewById(R.id.add_button);
        // custButton = itemView.findViewById(R.id.customize_button);
    }
}

