package com.example.shpock.Views.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.shpock.Controller.a_DetialsShips;
import com.example.shpock.Models.ItemClickListener;
import com.example.shpock.Models.ships;
import com.example.shpock.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListShips extends RecyclerView.Adapter<ListShips.ViewHolder> {
    private List<ships> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    Context context;

    // data is passed into the constructor
    public ListShips(Context context, List<ships> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.context = context;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.ship_list_row, parent, false);
        return new ViewHolder(view);
    }




    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.Title.setText(mData.get(position).getTitle());
        holder.Price.setText(String.valueOf(mData.get(position).getPrice()));

       //  imageLoader.displayImage(mData.get(position).getImage(), holder.img);
        Picasso.with(context).load(mData.get(position).getImage()).into(holder.img);

        holder.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Intent i = new Intent(context, a_DetialsShips.class);
                i.putExtra("id", String.valueOf(position));
                context.startActivity(i);
                ((Activity) context).finish();
            }
        });

    }



    @Override
    public int getItemCount() {
        return mData.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView Title, Price, tvMembersName;
        ImageView img;
        boolean showLeaveButton;
        public ItemClickListener clickListener;

        ViewHolder(View itemView) {
            super(itemView);
            Price = itemView.findViewById(R.id.Price);
            Title = itemView.findViewById(R.id.Title);
             img= itemView.findViewById(R.id.img);
            itemView.setOnClickListener(this);



        }

        public void setClickListener(ItemClickListener itemClickListener) {
            this.clickListener = itemClickListener;
        }

        @Override
        public void onClick(View view) {
            clickListener.onClick(view, getPosition(), false);
        }


    }

     public int getItem(int id) {
        return mData.get(id).getId();
    }




}

