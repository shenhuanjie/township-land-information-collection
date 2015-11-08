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
import com.example.town_land_collect.model.Task_Introduce;

public class TaskAdapter extends BaseAdapter {

	private Context mContext;
	// 判断任务状态，0表示未上传、1表示已上传、2表示已失效
	private int mState;
	private List<Task_Introduce> mList;

	public TaskAdapter(Context context, List<Task_Introduce> list, int state) {
		mContext = context;
		mState = state;
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
			LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			viewHolder = new ViewHolder();
			convertView = layoutInflater.inflate(R.layout.list_item_task, parent, false);
			viewHolder = new ViewHolder();
			viewHolder.textView_Name = (TextView) convertView.findViewById(R.id.list_item_task_thename);
			viewHolder.textView_Time = (TextView) convertView.findViewById(R.id.list_item_task_createtime);
			viewHolder.imageView_Icon = (ImageView) convertView.findViewById(R.id.list_item_task_icon);
			viewHolder.textView_State = (TextView) convertView.findViewById(R.id.list_item_task_state);
			viewHolder.textView_UploadTime = (TextView) convertView.findViewById(R.id.list_item_task_uploadtime);
			viewHolder.textView_TimeConsuming = (TextView) convertView.findViewById(R.id.list_item_task_upload_time_consuming);
			viewHolder.textView_Attachment = (TextView) convertView.findViewById(R.id.list_item_task_attachment);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		viewHolder.textView_Name.setText(mList.get(position).getTask_Name());
		String str_Attachment = mList.get(position).getTask_Attachment();
		viewHolder.textView_Attachment.setText(changeTextStyle_Time(str_Attachment));
		if (mState == 0) {
			String str_Time = mList.get(position).getTask_Time();
			viewHolder.textView_Time.setText(changeTextStyle_Time(str_Time));
			String str_State = mList.get(position).getTask_State();
			viewHolder.textView_State.setText(changeRedStyle_State(str_State));// 将其添加到tv中
			viewHolder.imageView_Icon.setBackgroundResource(R.drawable.task_wait_upload);
			viewHolder.textView_UploadTime.setVisibility(View.GONE);
			viewHolder.textView_TimeConsuming.setVisibility(View.GONE);
		} else if (mState == 1) {
			String str_Time = mList.get(position).getTask_Time();
			viewHolder.textView_Time.setText(changeTextStyle_Time(str_Time));
			String str_UploadTime = mList.get(position).getTask_UploadTime();
			viewHolder.textView_UploadTime.setText(changeTextStyle_Time(str_UploadTime));
			String str_Timeconsuming = mList.get(position).getTask_TimeConsuming();
			viewHolder.textView_TimeConsuming.setText(changeTextStyle_Time(str_Timeconsuming));
			String str_State = mList.get(position).getTask_State();
			viewHolder.textView_State.setText(changeGreen_State(str_State));// 将其添加到tv中
			viewHolder.imageView_Icon.setBackgroundResource(R.drawable.task_over);
		}
		return convertView;
	}

	private SpannableStringBuilder changeRedStyle_State(String str) {
		try {
			SpannableStringBuilder style = new SpannableStringBuilder(str);
			style.setSpan(new ForegroundColorSpan(Color.RED), 0, str.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
			return style;
		} catch (Exception e) {
			return null;
		}

	}

	private SpannableStringBuilder changeGreen_State(String str) {
		try {
			SpannableStringBuilder style = new SpannableStringBuilder(str);
			style.setSpan(new ForegroundColorSpan(Color.GREEN), 0, str.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
			return style;
		} catch (Exception e) {
			return null;
		}

	}

	private SpannableStringBuilder changeTextStyle_Time(String str) {
		try {
			SpannableStringBuilder style = new SpannableStringBuilder(str);
			style.setSpan(new ForegroundColorSpan(Color.BLACK), 0, str.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
			return style;
		} catch (Exception e) {
			return null;
		}
	}

	private class ViewHolder {
		private TextView textView_Name;
		private TextView textView_Time;
		private TextView textView_State;
		private TextView textView_UploadTime;
		private TextView textView_TimeConsuming;
		private TextView textView_Attachment;
		private ImageView imageView_Icon;
	}
}
