package com.mimos.amugae;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by jkm50 on 2016-05-12.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    Context context;
    ArrayList<CardviewItem> items;
    int item_cardview;
    RecyclerAdapter(Context context, ArrayList<CardviewItem> items, int item_cardview){
        this.context = context;
        this.items = items;
        this.item_cardview = item_cardview;

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview,null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final CardviewItem item = items.get(position);
        Drawable drawable = context.getResources().getDrawable(item.getImage());
//        holder.image.setBackground(drawable);
        Glide.with(context).load(item.getImage()).into(holder.image);
        holder.content.setText(item.getContent());
        holder.comment.setText(""+item.getComment());
        holder.time.setText(item.getTime()+"분 전");
        holder.like.setText(""+item.getLike());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,item.getContent(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView content;
        TextView comment;
        TextView time;
        TextView like;
        CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.cardImage);
            content = (TextView) itemView.findViewById(R.id.content);
            comment = (TextView) itemView.findViewById(R.id.txtComment);
            time = (TextView) itemView.findViewById(R.id.txtTime);
            like = (TextView) itemView.findViewById(R.id.txtLike);
            cardView = (CardView) itemView.findViewById(R.id.cardview);

        }
    }
}
