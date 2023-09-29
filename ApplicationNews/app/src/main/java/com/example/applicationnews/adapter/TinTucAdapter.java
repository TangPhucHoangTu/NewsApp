package com.example.applicationnews.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.applicationnews.R;
import com.example.applicationnews.activities.TinTucActivity;
import com.example.applicationnews.models.TinTuc;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TinTucAdapter extends RecyclerView.Adapter<TinTucAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<TinTuc> mListTinTuc;

    public TinTucAdapter(Context mContext, ArrayList<TinTuc> mListTinTuc) {
        this.mContext = mContext;
        this.mListTinTuc = mListTinTuc;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_tin_tuc, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TinTuc tinTuc = mListTinTuc.get(position);
        holder.txtTitle.setText(tinTuc.getTitle());

        if (tinTuc.getImg().isEmpty())
            holder.image.setImageResource(R.drawable.ic_image);
        else
            Picasso.get().load(tinTuc.getImg()).into(holder.image);
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, TinTucActivity.class);
                intent.putExtra("link", tinTuc.getLink());
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mListTinTuc.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView txtTitle;
        LinearLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.itemTinTuc_img);
            txtTitle = itemView.findViewById(R.id.itemTinTuc_title);
            layout = itemView.findViewById(R.id.itemTinTuc_layout);
        }
    }
}
