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

import com.turbo.app.turbovpnpro.R;

import java.util.ArrayList;

public class AppListAdapter extends RecyclerView.Adapter<AppListAdapter.ViewHolder> {
    ArrayList<String> sectionList;
    Context mcontext;
    AppListAdapter.OnItemClickListener itemClickListener;

    public AppListAdapter(Activity ctx, ArrayList<String> sectionList, AppListAdapter.OnItemClickListener clickListener) {
        this.sectionList = sectionList;
        this.mcontext = ctx;
        this.itemClickListener = clickListener;
    }

    @NonNull
    @Override
    public AppListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.app_list_item, parent, false);
        return new AppListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final AppListAdapter.ViewHolder holder, int position) {

        String section = sectionList.get(position);

        holder.country_name.setText(section);


        holder.main.setOnClickListener(v -> {


            itemClickListener.onItemClicked(section, position, false);
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
        void onItemClicked(String server, int postion, boolean status);
    }
}



