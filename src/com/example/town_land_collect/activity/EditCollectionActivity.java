package com.example.town_land_collect.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.town_land_collect.R;
import com.example.town_land_collect.model.LocationInfo;
import com.example.town_land_collect.util.ComUtil;

public class EditCollectionActivity extends ActionBarActivity implements
		OnClickListener {
	/**
	 * 标注点位置相关
	 */
	private EditText editText_Location_Latitude;
	private EditText editText_Location_Longtitude;
	private EditText editText_Location_BZDMC;// 标注点名称
	private EditText editText_Location_Mark;
	private ImageButton imageButton_Location;
	private LocationInfo locationInfo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_collection);
		initLayout();
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
	}

	private void initLayout() {
		/**
		 * 标注点位置相关
		 */
		editText_Location_Longtitude = (EditText) findViewById(R.id.location_info_Lon);
		editText_Location_Latitude = (EditText) findViewById(R.id.location_info_Lat);
		editText_Location_BZDMC = (EditText) findViewById(R.id.location_info_BJDMC);
		editText_Location_Mark = (EditText) findViewById(R.id.location_info_Mark);

		Intent intent = getIntent();
		if (intent != null) {
			locationInfo = (LocationInfo) intent
					.getSerializableExtra("locationInfo");
			editText_Location_BZDMC.setText(locationInfo.getName());
			editText_Location_Latitude.setText(locationInfo.getLat() + "");
			editText_Location_Longtitude.setText(locationInfo.getLon() + "");
			editText_Location_Mark.setText(locationInfo.getMark());
		}
		imageButton_Location = (ImageButton) findViewById(R.id.activity_edit_collection_ibtn_location);
		imageButton_Location.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.edit_collection, menu);
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

	@Override
	public void onClick(View arg0) {
		int id = arg0.getId();
		switch (id) {
		case R.id.activity_edit_collection_ibtn_location:
			Intent intent = new Intent(EditCollectionActivity.this,
					MyMapActivity.class);
			locationInfo.setLat(Double.parseDouble(editText_Location_Latitude
					.getText().toString()));
			locationInfo.setLon(Double.parseDouble(editText_Location_Longtitude
					.getText().toString()));
			intent.putExtra("locationInfo", locationInfo);
			startActivityForResult(intent, ComUtil.RequestCode_Map);
			break;
		default:
			break;
		}
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == Activity.RESULT_OK) {
			if (requestCode == ComUtil.RequestCode_Map) {
				if (data != null) {
					double lat = data.getIntExtra("lat", 0) / 1E6;
					double lon = data.getIntExtra("long", 0) / 1E6;
					editText_Location_Longtitude.setText(lon + "");
					editText_Location_Latitude.setText(lat + "");
				}
			}
			super.onActivityResult(requestCode, resultCode, data);
		}
	}
}
