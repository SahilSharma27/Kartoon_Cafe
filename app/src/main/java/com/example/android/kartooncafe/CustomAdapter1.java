package com.example.android.kartooncafe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CustomAdapter1 extends RecyclerView.Adapter<ItemViewHolder> {

    ArrayList<Menu> menus;
    Context context;
    MenuImageClickListener listener;

    public CustomAdapter1(Context context, ArrayList<Menu> menus, MenuImageClickListener listener) {
        this.listener = listener;
        this.context = context;
        this.menus = menus;
    }

    @Override
    public int getItemCount() {
        return menus.size();
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemViewHolder holder, int position) {
        final Menu currentMenu = menus.get(position);
        // holder.imageView.setImageResource(currentMenu.getMenuBackDrop());
        Glide.with(holder.imageView.getContext()).load(currentMenu.getMenuBackDrop()).into(holder.imageView);

        holder.textView.setText(currentMenu.getMenuTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Open SubMenu", Toast.LENGTH_LONG).show();
//
                listener.onMenuClicked(view, holder.getAdapterPosition());
            }
        });


    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowlayout = inflater.inflate(R.layout.menu_list_item, parent, false);
        return new ItemViewHolder(rowlayout);
    }
}
