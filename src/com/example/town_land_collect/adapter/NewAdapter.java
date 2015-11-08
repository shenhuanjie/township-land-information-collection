package com.example.town_land_collect.adapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.town_land_collect.R;
import com.example.town_land_collect.model.New_Introduce;

@SuppressLint("SimpleDateFormat")
public class NewAdapter extends BaseAdapter {

	private Context context;
	private List<New_Introduce> newList;

	public NewAdapter(Context context, List<New_Introduce> list) {
		this.context = context;
		this.newList = list;
	}

	@Override
	public int getCount() {
		return newList.size();
	}

	@Override
	public Object getItem(int arg0) {
		return newList.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;
		if (convertView == null) {
			LayoutInflater layoutInflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = layoutInflater.inflate(R.layout.list_item_news,
					parent, false);
			viewHolder = new ViewHolder();
			viewHolder.textView_TheName = (TextView) convertView
					.findViewById(R.id.list_item_news_thename);
			viewHolder.textView_ClickCount = (TextView) convertView
					.findViewById(R.id.list_item_news_clickcount);
			viewHolder.textView_CreateTime = (TextView) convertView
					.findViewById(R.id.list_item_news_createtime);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		String newsName=newList.get(position).getTheName();
		if (newsName.length()>12) {
			newsName=newsName.substring(0, 13)+"...";
		}
		viewHolder.textView_TheName.setText(newsName);
		viewHolder.textView_ClickCount.setText(newList.get(position)
				.getActive());
		viewHolder.textView_CreateTime.setText(newList.get(position)
				.getCreateTime());
		return convertView;
	}

	public static String DealStr_Date(String str) {

		String date = "";
		try {
			SimpleDateFormat formatter = new SimpleDateFormat(
					"yyyy/MM/dd HH:mm:ss");
			Date d;
			d = formatter.parse(str);
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
			date = format.format(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	private class ViewHolder {
		private TextView textView_TheName;
		private TextView textView_ClickCount;
		private TextView textView_CreateTime;
	}

}
