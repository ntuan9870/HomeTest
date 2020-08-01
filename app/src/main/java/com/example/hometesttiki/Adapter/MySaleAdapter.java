package com.example.hometesttiki.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.hometesttiki.Model.DataSale;
import com.example.hometesttiki.R;

import java.util.List;

public class MySaleAdapter extends RecyclerView.Adapter<MySaleAdapter.MyViewHolder> {
    private Context context;
    private List<DataSale> dataSales;

    public MySaleAdapter(Context context, List<DataSale> dataSales) {
        this.context = context;
        this.dataSales = dataSales;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.sale_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context).load(dataSales.get(position).getProduct().getThumbnailUrl()).into(holder.img_sale);
        int price = dataSales.get(position).getProduct().getPrice();
        int discount = dataSales.get(position).getProduct().getDiscount();
        int phantram = 100 - discount/price;
        holder.txt_phan_tram_giam_gia.setText("-" + phantram + "%");
        holder.txt_gia_sp.setText(dataSales.get(position).getProduct().getDiscount()+" vnd");
        holder.progress_bar_sale.setMax(dataSales.get(position).getProgress().getQty());
        holder.progress_bar_sale.setProgress(dataSales.get(position).getProgress().getQtyOrdered());
        holder.txt_da_ban.setText("Đã bán "+dataSales.get(position).getProgress().getQtyOrdered()+"/"+dataSales.get(position).getProgress().getQty());
    }

    @Override
    public int getItemCount() {
        return dataSales.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img_sale;
        TextView txt_gia_sp, txt_phan_tram_giam_gia, txt_da_ban;
        ProgressBar progress_bar_sale;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img_sale = itemView.findViewById(R.id.img_sale);
            txt_gia_sp = itemView.findViewById(R.id.txt_gia_sp);
            txt_phan_tram_giam_gia = itemView.findViewById(R.id.txt_phan_tram_sale);
            progress_bar_sale = itemView.findViewById(R.id.progress_bar_sale);
            txt_da_ban = itemView.findViewById(R.id.txt_da_ban);
        }
    }
}
