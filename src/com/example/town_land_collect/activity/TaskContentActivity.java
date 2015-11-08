package com.example.town_land_collect.activity;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.town_land_collect.R;
import com.example.town_land_collect.model.Task_Introduce;

public class TaskContentActivity extends ActionBarActivity {
	private TextView textView_TaskName;
	private TextView textView_TaskTime;
	private TextView textView_TaskState;
	private TextView textView_TaskContent;
	private Task_Introduce task_Introduce;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_task_content);

		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		Intent intent = getIntent();
		if (intent != null) {
			Bundle bundle = intent.getBundleExtra("bundle");
			task_Introduce = (Task_Introduce) bundle.getSerializable("task");
			initLayout();
		}
	}

	private void initLayout() {
		textView_TaskContent = (TextView) findViewById(R.id.activity_task_content_tv_content);
		textView_TaskName = (TextView) findViewById(R.id.activity_task_content_tv_title);
		textView_TaskState = (TextView) findViewById(R.id.activity_task_content_tv_state);
		textView_TaskTime = (TextView) findViewById(R.id.activity_task_content_tv_time);
		String str_Time = task_Introduce.getTask_Time();
		textView_TaskTime.setText(changeTextStyle_Time(str_Time));

		String str_State = task_Introduce.getTask_State();
		textView_TaskState.setText(changeTextStyle_State(str_State));// 将其添加到tv中

		String str_Title = task_Introduce.getTask_Name();
		textView_TaskName.setText(str_Title);

		String str_Content = "全省范围内建设标准统一、流程一致、网络化的机关事业单位人事管理系统，人事管理核心业务全部通过信息系统审批和办理，实现对机关事业单位工作人员全程管理和服务，提升机关事业单位人事管理的科学化、规范化、信息化水平。目前，我县机构树设置、用户分配等前期筹备工作已基本完成，现进入数据采集阶段。";
		textView_TaskContent.setText(Html.fromHtml(str_Content));
		textView_TaskContent.setMovementMethod(LinkMovementMethod.getInstance());
	}

	private SpannableStringBuilder changeTextStyle_State(String str) {
		SpannableStringBuilder style = new SpannableStringBuilder(str);
		style.setSpan(new ForegroundColorSpan(Color.BLACK), 0, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		style.setSpan(new ForegroundColorSpan(Color.RED), 5, str.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		return style;
	}

	private SpannableStringBuilder changeTextStyle_Time(String str) {
		SpannableStringBuilder style = new SpannableStringBuilder(str);
		style.setSpan(new ForegroundColorSpan(Color.BLACK), 0, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		style.setSpan(new ForegroundColorSpan(Color.RED), 5, str.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		return style;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.task_content, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		switch (id) {
		case android.R.id.home:
			this.finish();
			return true;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
