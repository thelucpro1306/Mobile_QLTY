package com.example.qlty.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.qlty.Model.Services;
import com.example.qlty.R;

import java.util.List;

public class ServicesAdapter extends ArrayAdapter<Services> {
    public ServicesAdapter(@NonNull Context context, int resource, @NonNull List<Services> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_selected,parent,false);
        TextView textViewS = convertView.findViewById(R.id.tvSelected);

        Services services = this.getItem(position);
        if(services!=null)
        {
            textViewS.setText(services.getName());
        }
        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_services,parent,false);
        TextView textView = convertView.findViewById(R.id.tvServices);

        Services services = this.getItem(position);
        if(services!=null)
        {
            textView.setText(services.getName());
        }
        return convertView;
    }
}
