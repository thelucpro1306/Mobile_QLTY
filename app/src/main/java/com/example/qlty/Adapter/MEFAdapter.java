package com.example.qlty.Adapter;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qlty.Model.MEF;
import com.example.qlty.R;


import java.util.List;

public class MEFAdapter extends RecyclerView.Adapter<MEFAdapter.MEFViewHolder> {

    public List<MEF> mListMEF;

    public void setData(List<MEF> list){
        this.mListMEF = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MEFViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MEFViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mef,parent,false));
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull MEFViewHolder holder, int position) {
        MEF mef = mListMEF.get(position);
        holder.tvName.setText(new StringBuilder().append("Dịch vụ: ").append(mef.Name).toString());

        holder.tvName1.setText(new StringBuilder().append("Ngày khám: ").append(mef.BookingDate.toString()).toString());


    }

    @Override
    public int getItemCount() {
        if(mListMEF!=null)
        {
            return mListMEF.size();
        }
        return 0;
    }

    public static class  MEFViewHolder extends RecyclerView.ViewHolder{

        TextView tvName,tvName1;

        public MEFViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvName1 = itemView.findViewById(R.id.tv_name1);
        }
    }
}
