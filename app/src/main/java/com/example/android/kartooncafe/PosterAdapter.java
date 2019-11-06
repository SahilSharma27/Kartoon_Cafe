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

public class PosterAdapter extends RecyclerView.Adapter<PosterViewHolder> {
    ArrayList<Poster> posters;
    Context context;
    PosterItemClickListener listener;
    public PosterAdapter(Context context,ArrayList<Poster> posters,PosterItemClickListener listener) {
        this.listener=listener;
        this.context=context;
        this.posters=posters;
    }

    @NonNull
    @Override
    public PosterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowlayout = inflater.inflate(R.layout.top_poster_item_layout, parent, false);
        return new PosterViewHolder(rowlayout);

    }

    @Override
    public void onBindViewHolder(@NonNull final PosterViewHolder holder, int position) {
        final Poster currentPost = posters.get(position);
        // holder.imageView.setImageResource(currentMenu.getMenuBackDrop());
        Glide.with(holder.posterImg.getContext()).load(currentPost.getPosterBackDrop()).into(holder.posterImg);

        holder.posterTitle.setText(currentPost.getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //    Toast.makeText(context,"Do Action If Needed",Toast.LENGTH_LONG).show();

                listener.onPosterItemClicked((view),holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return posters.size();
    }
}
