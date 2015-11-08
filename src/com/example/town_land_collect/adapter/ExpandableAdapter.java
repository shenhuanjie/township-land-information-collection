package com.example.town_land_collect.adapter;

import java.util.List;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

//ExpandableListViewµÄAdapter   
public class ExpandableAdapter extends BaseExpandableListAdapter {
	Context context;

	private List<String> groupArray;
	private List<List<String>> childArray;

	public ExpandableAdapter(Context mContext, List<String> groupArray,
			List<List<String>> childArray) {
		context = mContext;
		this.groupArray=groupArray;
		this.childArray=childArray;
	}

	public Object getChild(int groupPosition, int childPosition) {
		return childArray.get(groupPosition).get(childPosition);
	}

	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	public int getChildrenCount(int groupPosition) {
		return childArray.get(groupPosition).size();
	}

	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		String string = childArray.get(groupPosition).get(childPosition);
		return getGenericView(string,1);
	}

	// group method stub
	public Object getGroup(int groupPosition) {
		return groupArray.get(groupPosition);
	}

	public int getGroupCount() {
		return groupArray.size();
	}

	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		String string = groupArray.get(groupPosition);
		return getGenericView(string,0);
	}

	// View stub to create Group/Children 's View
	public TextView getGenericView(String string,int type) {
		TextView text = new TextView(context);
		if (type==0) {
			// Layout parameters for the ExpandableListView
			AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(
					ViewGroup.LayoutParams.MATCH_PARENT, 85);
			text.setLayoutParams(layoutParams);
			// Center the text vertically
			text.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
			// Set the text starting position
			text.setPadding(50, 15, 0, 15);
			text.setTextSize(18);
			text.setText(string);
		}else {
			// Layout parameters for the ExpandableListView
			AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(
					ViewGroup.LayoutParams.MATCH_PARENT, 75);
			text.setLayoutParams(layoutParams);
			// Center the text vertically
			text.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
			// Set the text starting position
			text.setPadding(75, 10, 0, 10);
			text.setTextSize(15);
			text.setText(string);
		}
		
		return text;
	}

	public boolean hasStableIds() {
		return false;
	}

	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}
}
