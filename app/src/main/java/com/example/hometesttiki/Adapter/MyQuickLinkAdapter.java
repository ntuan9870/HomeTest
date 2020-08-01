package com.example.hometesttiki.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.hometesttiki.Model.QuickLink;
import com.example.hometesttiki.R;

import java.util.List;

public class MyQuickLinkAdapter extends RecyclerView.Adapter<MyQuickLinkAdapter.MyViewHolder> {
    private Context context;
    private List<QuickLink> quickLinks;

    public MyQuickLinkAdapter(Context context, List<QuickLink> quickLinks) {
        this.context = context;
        this.quickLinks = quickLinks;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.quick_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context).load(quickLinks.get(position).getImageUrl()).into(holder.img_quick_link);
        holder.txt_name_quick_link.setText(quickLinks.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return quickLinks.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img_quick_link;
        TextView txt_name_quick_link;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img_quick_link = itemView.findViewById(R.id.img_quick_link);
            txt_name_quick_link = itemView.findViewById(R.id.txt_name_quick_link);
        }
    }
}
