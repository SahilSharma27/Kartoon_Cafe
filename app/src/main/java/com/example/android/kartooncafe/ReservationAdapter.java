package com.example.android.kartooncafe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ReservationAdapter extends RecyclerView.Adapter<ReservationViewHolder> {

    private ArrayList<String> ReserveList ;
    private Context context;
    private ReservationItemClickListener listener;
    private int row_index=-1;
    int pos;
    public ReservationAdapter(Context context,ArrayList<String> ReserveList,ReservationItemClickListener listener) {
        this.listener=listener;
        this.context=context;
        this.ReserveList=ReserveList;
    }
    @NonNull
    @Override
    public ReservationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowlayout=inflater.inflate(R.layout.reservation_item_layout,parent,false);
        return new ReservationViewHolder(rowlayout);

    }

    @Override
    public void onBindViewHolder(@NonNull final ReservationViewHolder holder, final int position) {

            String Reserve=ReserveList.get(position);
            holder.textView.setText(Reserve);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    row_index = position;
                    //                   notifyDataSetChanged();
                    int x = holder.getAdapterPosition();
                    notifyDataSetChanged();
                    listener.onReservationItemClicked(view, x);

                }

            });
            if(row_index==position){
                holder.layout.setBackgroundColor(ContextCompat.getColor(context, R.color.myOrange));
                holder.textView.setBackgroundColor(ContextCompat.getColor(context, R.color.myOrange));
                    holder.textView.setTextColor(ContextCompat.getColor(context,R.color.white));
            }
            else{
                holder.layout.setBackgroundColor(ContextCompat.getColor(context,R.color.white));
                    holder.textView.setBackgroundColor(ContextCompat.getColor(context,R.color.white));
                holder.textView.setTextColor(ContextCompat.getColor(context, R.color.myOrange));
            }
    }

    @Override
    public int getItemCount() {
        return ReserveList.size();
    }
}
