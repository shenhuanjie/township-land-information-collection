package com.example.town_land_collect.adapter;

import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.town_land_collect.R;
import com.example.town_land_collect.model.LocationInfo;

public class LocationMarkAdapter extends BaseAdapter {

	private Context mContext;
	// 判断任务状态，0表示未采集、1表示未上传、2表示已完成
	private List<LocationInfo> mList;

	public LocationMarkAdapter(Context context, List<LocationInfo> list) {
		mContext = context;
		mList = list;
	}

	@Override
	public int getCount() {
		return mList.size();
	}

	@Override
	public Object getItem(int arg0) {
		return mList.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = null;
		if (convertView == null) {
			LayoutInflater layoutInflater = (LayoutInflater) mContext
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			viewHolder = new ViewHolder();
			convertView = layoutInflater.inflate(R.layout.list_item_collection,
					parent, false);
			viewHolder = new ViewHolder();
			viewHolder.textView_Name = (TextView) convertView
					.findViewById(R.id.list_item_collection_thename);
			viewHolder.textView_Time = (TextView) convertView
					.findViewById(R.id.list_item_collection_createtime);
			viewHolder.imageView_Icon = (ImageView) convertView
					.findViewById(R.id.list_item_collection_icon);
			viewHolder.textView_State = (TextView) convertView
					.findViewById(R.id.list_item_collection_state);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		viewHolder.textView_Name.setText(mList.get(position).getName());

		String str_Time =  mList.get(position).getDate();
		viewHolder.textView_Time.setText(changeTextStyle_Time(str_Time));

		String str_State = mList.get(position).getState();
		viewHolder.textView_State.setText(changeTextStyle_State(str_State));// 将其添加到tv中

		viewHolder.imageView_Icon
				.setBackgroundResource(R.drawable.icon_list_mark);
		return convertView;
	}

	private SpannableStringBuilder changeTextStyle_State(String str) {
		SpannableStringBuilder style = new SpannableStringBuilder(str);
		style.setSpan(new ForegroundColorSpan(Color.BLACK), 0, 5,
				Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		style.setSpan(new ForegroundColorSpan(Color.RED), 5, 8,
				Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		return style;
	}

	private SpannableStringBuilder changeTextStyle_Time(String str) {
		SpannableStringBuilder style = new SpannableStringBuilder(str);
		style.setSpan(new ForegroundColorSpan(Color.BLACK), 0, 5,
				Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		style.setSpan(new ForegroundColorSpan(Color.BLACK), 5, str.length(),
				Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		return style;
	}

	private class ViewHolder {
		private TextView textView_Name;
		private TextView textView_Time;
		private TextView textView_State;
		private ImageView imageView_Icon;
	}
}
