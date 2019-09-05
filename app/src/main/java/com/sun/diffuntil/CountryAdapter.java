package com.sun.diffuntil;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {
    ArrayList<Country> countries;
    Context context;

    public CountryAdapter(ArrayList<Country> countries, Context context) {
        this.countries = countries;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_country,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.imageView.setImageResource(countries.get(position).getmImageResource());
        holder.textView.setText(countries.get(position).getmCountryName());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, holder.textView.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull List<Object> payloads) {
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads);
        } else {
            Bundle o = (Bundle) payloads.get(0);
            for (String key : o.keySet()) {
                if (key.equals("CountryName")) {
                    holder.imageView.setImageResource(countries.get(position).getmImageResource());
                    holder.textView.setText(countries.get(position).getmCountryName());
                    holder.textView.setTextColor(Color.GREEN);

                }
            }
        }
        super.onBindViewHolder(holder, position, payloads);
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public ArrayList<Country> getCountriesData(){
        return countries;
    }
    public void setCountriesData(ArrayList<Country> newData) {
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new CountryDiffUtil(countries, newData));
        diffResult.dispatchUpdatesTo(this);
        countries.clear();
        this.countries.addAll(newData);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        LinearLayout linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            initView(itemView);
        }

        private void initView(View itemView) {
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
            linearLayout = itemView.findViewById(R.id.item_country);
        }
    }
}
