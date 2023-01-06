package com.turbo.app.turbovpnpro.Adapter;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
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
    private List<String> expandableTitleList;
    private HashMap<String, List<String>> expandableDetailList;

    // constructor
    public CustomExpandableListAdapter(Context context, List<String> expandableListTitle,
                                           HashMap<String, List<String>> expandableListDetail) {
        this.context = context;
        this.expandableTitleList = expandableListTitle;
        this.expandableDetailList = expandableListDetail;
    }

    @Override
    // Gets the data associated with the given child within the given group.
    public Object getChild(int lstPosn, int expanded_ListPosition) {
        return this.expandableDetailList.get(this.expandableTitleList.get(lstPosn)).get(expanded_ListPosition);
    }

    @Override
    // Gets the ID for the given child within the given group.
    // This ID must be unique across all children within the group. Hence we can pick the child uniquely
    public long getChildId(int listPosition, int expanded_ListPosition) {
        return expanded_ListPosition;
    }

    @Override
    // Gets a View that displays the data for the given child within the given group.
    public View getChildView(int lstPosn, final int expanded_ListPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        final String expandedListText = (String) getChild(lstPosn, expanded_ListPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_detail, null);
        }
        TextView expandedListTextView = (TextView) convertView.findViewById(R.id.city_name);
        expandedListTextView.setText(expandedListText);
        return convertView;
    }

    @Override
    // Gets the number of children in a specified group.
    public int getChildrenCount(int listPosition) {
        return this.expandableDetailList.get(this.expandableTitleList.get(listPosition)).size();
    }

    @Override
    // Gets the data associated with the given group.
    public Object getGroup(int listPosition) {
        return this.expandableTitleList.get(listPosition);
    }

    @Override
    // Gets the number of groups.
    public int getGroupCount() {
        return this.expandableTitleList.size();
    }

    @Override
    // Gets the ID for the group at the given position. This group ID must be unique across groups.
    public long getGroupId(int listPosition) {
        return listPosition;
    }

    @Override
    // Gets a View that displays the given group.
    // This View is only for the group--the Views for the group's children
    // will be fetched using getChildView()
    public View getGroupView(int listPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String listTitle = (String) getGroup(listPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_group, null);
        }
        TextView listTitleTextView = (TextView) convertView.findViewById(R.id.lblListHeader);
        listTitleTextView.setTypeface(null, Typeface.BOLD);
        listTitleTextView.setText(listTitle);
        return convertView;
    }

    @Override
    // Indicates whether the child and group IDs are stable across changes to the underlying data.
    public boolean hasStableIds() {
        return false;
    }

    @Override
    // Whether the child at the specified position is selectable.
    public boolean isChildSelectable(int listPosition, int expandedListPosition) {
        return true;
    }
}
//        extends BaseExpandableListAdapter {
//
//    private Context context;
//    private ArrayList<CountryParentModel> expandableListTitle;
//    private HashMap<String, List<CountryChildModel>> expandableListDetail;
//
//
//    private ChildClick childClick;
//    private HeaderClick headerClick;
//
//
//    public CustomExpandableListAdapter(Context context, ArrayList<CountryParentModel> expandableListTitle,
//                                       HashMap<String, List<CountryChildModel>> expandableListDetail, ChildClick childClick
//            , HeaderClick headerClick) {
//        this.context = context;
//        this.expandableListTitle = expandableListTitle;
//        this.expandableListDetail = expandableListDetail;
//        this.childClick = childClick;
//        this.headerClick = headerClick;
//    }
//
//    @Override
//    public Object getChild(int listPosition, int expandedListPosition) {
//        return this.expandableListDetail.get(this.expandableListTitle.get(listPosition))
//                .get(expandedListPosition);
//    }
//
//    @Override
//    public long getChildId(int listPosition, int expandedListPosition) {
//        return expandedListPosition;
//    }
//
//    @Override
//    public View getChildView(int listPosition, final int expandedListPosition,
//                             boolean isLastChild, View convertView, ViewGroup parent) {
//        final CountryChildModel expandedListText = (CountryChildModel) getChild(listPosition, expandedListPosition);
//        if (convertView == null) {
//            LayoutInflater layoutInflater = (LayoutInflater) this.context
//                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView = layoutInflater.inflate(R.layout.list_detail, null);
//        }
//        TextView city_name = (TextView) convertView.findViewById(R.id.city_name);
//        ImageView ivSelect = convertView.findViewById(R.id.ivSelect);
//        city_name.setText(expandedListText.getCityname());
//
//
//        if (expandedListText.isChecked()) {
//            ivSelect.setImageResource(R.drawable.download_ic);
//        } else {
//            ivSelect.setImageResource(R.drawable.circle_unselect);
//        }
//
//        ivSelect.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                childClick.UserClick(expandedListText);
//                notifyDataSetChanged();
//            }
//        });
//
//        return convertView;
//    }
//
//    @Override
//    public int getChildrenCount(int listPosition) {
//        return this.expandableListDetail.get(this.expandableListTitle.get(listPosition)).size();
//    }
//
//    @Override
//    public Object getGroup(int listPosition) {
//        return this.expandableListTitle.get(listPosition);
//    }
//
//    @Override
//    public int getGroupCount() {
//        return this.expandableListTitle.size();
//    }
//
//    @Override
//    public long getGroupId(int listPosition) {
//        return listPosition;
//    }
//    @Override
//    public View getGroupView(int listPosition, boolean isExpanded, View convertView, ViewGroup parent) {
//        CountryParentModel listTitle = (CountryParentModel) getGroup(listPosition);
//
//        if (convertView == null) {
//            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView = layoutInflater.inflate(R.layout.list_group, null);
//        }
//        TextView listTitleTextView = (TextView) convertView.findViewById(R.id.lblListHeader);
////        ImageView icons = convertView.findViewById(R.id.ivIcon);
//        ImageView arrow = convertView.findViewById(R.id.arrow);
//        LinearLayout parent_main = convertView.findViewById(R.id.parent_main);
//        listTitleTextView.setText(listTitle.getCountryName());
//
//        parent_main.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                headerClick.UserHeaderClick(listTitle.getCountryName());
//                notifyDataSetChanged();
//            }
//        });
//
//
//
//
//
//
//
//        if (isExpanded) {
//            arrow.setImageResource(R.drawable.arrow_up);
//        } else {
//            arrow.setImageResource(R.drawable.arrow_down);
//        }
//
//        return convertView;
//    }
//
//    @Override
//    public boolean hasStableIds() {
//        return false;
//    }
//
//    @Override
//    public boolean isChildSelectable(int listPosition, int expandedListPosition) {
//        return true;
//    }
//}
