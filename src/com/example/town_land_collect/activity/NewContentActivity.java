package com.example.town_land_collect.activity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.town_land_collect.R;
import com.example.town_land_collect.model.New_Introduce;

public class NewContentActivity extends ActionBarActivity {
	private TextView textView_Title;
	private TextView textView_Time;
	private TextView textView_Content;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_content);
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		textView_Title = (TextView) findViewById(R.id.activity_new_content_tv_title);
		textView_Time = (TextView) findViewById(R.id.activity_new_content_tv_time);
		textView_Content = (TextView) findViewById(R.id.activity_new_content_tv_content);

		Intent intent = getIntent();
		if (intent != null) {
			Bundle bundle = intent.getBundleExtra("bundle");

			New_Introduce new_Introduce = (New_Introduce) bundle
					.getSerializable("news");
			textView_Title.setText(new_Introduce.getTheName());
			textView_Time.setText(new_Introduce.getCreateTime());
			textView_Content.setText(new_Introduce.getTheName());
			textView_Content
					.setMovementMethod(LinkMovementMethod.getInstance());
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_content, menu);
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
