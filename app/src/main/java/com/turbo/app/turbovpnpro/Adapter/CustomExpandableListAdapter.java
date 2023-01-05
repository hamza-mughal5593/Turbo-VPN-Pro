package com.turbo.app.turbovpnpro.Adapter;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.turbo.app.turbovpnpro.Interface.ChildClick;
import com.turbo.app.turbovpnpro.Interface.HeaderClick;
import com.turbo.app.turbovpnpro.Models.CountryChildModel;
import com.turbo.app.turbovpnpro.Models.CountryParentModel;
import com.turbo.app.turbovpnpro.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private ArrayList<CountryParentModel> expandableListTitle;
    private HashMap<String, List<CountryChildModel>> expandableListDetail;


    private ChildClick childClick;
    private HeaderClick headerClick;


    public CustomExpandableListAdapter(Context context, ArrayList<CountryParentModel> expandableListTitle,
                                       HashMap<String, List<CountryChildModel>> expandableListDetail, ChildClick childClick
            , HeaderClick headerClick) {
        this.context = context;
        this.expandableListTitle = expandableListTitle;
        this.expandableListDetail = expandableListDetail;
        this.childClick = childClick;
        this.headerClick = headerClick;
    }

    @Override
    public Object getChild(int listPosition, int expandedListPosition) {
        return this.expandableListDetail.get(this.expandableListTitle.get(listPosition))
                .get(expandedListPosition);
    }

    @Override
    public long getChildId(int listPosition, int expandedListPosition) {
        return expandedListPosition;
    }

    @Override
    public View getChildView(int listPosition, final int expandedListPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        final CountryChildModel expandedListText = (CountryChildModel) getChild(listPosition, expandedListPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_detail, null);
        }
        TextView city_name = (TextView) convertView.findViewById(R.id.city_name);
        ImageView ivSelect = convertView.findViewById(R.id.ivSelect);
        city_name.setText(expandedListText.getCityname());


        if (expandedListText.isChecked()) {
            ivSelect.setImageResource(R.drawable.download_ic);
        } else {
            ivSelect.setImageResource(R.drawable.circle_unselect);
        }

        ivSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                childClick.UserClick(expandedListText);
                notifyDataSetChanged();
            }
        });

        return convertView;
    }

    @Override
    public int getChildrenCount(int listPosition) {
        return this.expandableListDetail.get(this.expandableListTitle.get(listPosition)).size();
    }

    @Override
    public Object getGroup(int listPosition) {
        return this.expandableListTitle.get(listPosition);
    }

    @Override
    public int getGroupCount() {
        return this.expandableListTitle.size();
    }

    @Override
    public long getGroupId(int listPosition) {
        return listPosition;
    }
    @Override
    public View getGroupView(int listPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        CountryParentModel listTitle = (CountryParentModel) getGroup(listPosition);

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_group, null);
        }
        TextView listTitleTextView = (TextView) convertView.findViewById(R.id.lblListHeader);
//        ImageView icons = convertView.findViewById(R.id.ivIcon);
        ImageView arrow = convertView.findViewById(R.id.arrow);
        LinearLayout parent_main = convertView.findViewById(R.id.parent_main);
        listTitleTextView.setText(listTitle.getCountryName());

        parent_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                headerClick.UserHeaderClick(listTitle.getCountryName());
                notifyDataSetChanged();
            }
        });







        if (isExpanded) {
            arrow.setImageResource(R.drawable.arrow_up);
        } else {
            arrow.setImageResource(R.drawable.arrow_down);
        }

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int listPosition, int expandedListPosition) {
        return true;
    }
}
