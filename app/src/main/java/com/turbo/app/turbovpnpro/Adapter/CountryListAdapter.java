package com.turbo.app.turbovpnpro.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.turbo.app.turbovpnpro.Models.CountryListModel;
import com.turbo.app.turbovpnpro.R;

import java.util.ArrayList;
import java.util.Locale;

public class CountryListAdapter extends RecyclerView.Adapter<CountryListAdapter.ViewHolder> {
    ArrayList<CountryListModel> sectionList;
    Context mcontext;
    OnItemClickListener itemClickListener;
    private ArrayList<CountryListModel> arraylist = new ArrayList<>();

    public CountryListAdapter(Activity ctx, ArrayList<CountryListModel> sectionList, OnItemClickListener clickListener) {
        this.sectionList = sectionList;
        this.mcontext = ctx;
        this.itemClickListener = clickListener;
        this.arraylist.addAll(sectionList);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.section_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        CountryListModel section = sectionList.get(position);
        String sectionName = section.getCountry_name();

        holder.country_name.setText(sectionName);


        holder.main.setOnClickListener(v -> {


            itemClickListener.onItemClicked(section, position, section.isSelected());
        });


    }




    @Override
    public int getItemCount() {
        return sectionList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView country_name, speed;
        ImageView selection;
        RelativeLayout main;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            country_name = itemView.findViewById(R.id.country_name);
//            selection = itemView.findViewById(R.id.selection);
            main = itemView.findViewById(R.id.layout);
        }
    }

    public interface OnItemClickListener {
        void onItemClicked(CountryListModel server, int postion, boolean favorite);
    }
}


