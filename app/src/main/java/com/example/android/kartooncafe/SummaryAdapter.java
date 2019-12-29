package com.example.android.kartooncafe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class SummaryAdapter extends RecyclerView.Adapter<SummaryViewHolder> {
    ArrayList<Cart> summaryList;
    Context context;

    public SummaryAdapter(Context context, ArrayList<Cart> summaryList) {
        this.context = context;
        this.summaryList = summaryList;
    }

    @NonNull
    @Override
    public SummaryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowlayout = inflater.inflate(R.layout.summary_item_layout, parent, false);
        return new SummaryViewHolder(rowlayout);

    }

    @Override
    public void onBindViewHolder(@NonNull final SummaryViewHolder holder, int position) {
        final Cart currentItem = summaryList.get(position);
        // holder.imageView.setImageResource(currentMenu.getMenuBackDrop());

        if (currentItem.getCartItemCategory() == 0) {
            Glide.with(holder.imageView.getContext()).load(R.drawable.veg_icon).into(holder.imageView);

        } else if (currentItem.getCartItemCategory() == 3) {
            Glide.with(holder.imageView.getContext()).load(R.drawable.egg_icon).into(holder.imageView);
        } else if (currentItem.getCartItemCategory() == 1) {
            Glide.with(holder.imageView.getContext()).load(R.drawable.non_veg_icon).into(holder.imageView);
        }


        holder.itemName.setText(currentItem.getCartItemName());
        double x = currentItem.getCustomPrice() + currentItem.getPrice();
        holder.qtyTextView.setText(x + " x " + currentItem.getQuantity());
    }

    @Override
    public int getItemCount() {
        return summaryList.size();
    }
}
