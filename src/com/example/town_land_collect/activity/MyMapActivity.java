package com.example.town_land_collect.activity;

import java.util.List;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.town_land_collect.R;
import com.example.town_land_collect.activity.MapResourcesActivity.OverItemT;
import com.example.town_land_collect.model.LocationInfo;
import com.tianditu.android.maps.GeoPoint;
import com.tianditu.android.maps.MapController;
import com.tianditu.android.maps.MapView;
import com.tianditu.android.maps.MyLocationOverlay;
import com.tianditu.android.maps.Overlay;
import com.tianditu.android.maps.OverlayItem;

public class MyMapActivity extends ActionBarActivity implements OnClickListener {
	private static MapView mMapView;
	private MapController mMapController;
	// private Handler mHandle;
	private MyLocationOverlay mMyLocation = null;
	private ImageButton imageButton_Location;
	private ImageButton imageButton_Point;
	private Button button_Point;
	private Button button_OK;
	private OverlayItem mItem = null;

	private OverItemT mOverlay = null;
	private static View mPopView = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		initActionBar();
		initLayout();
		myLocation(true);
		Intent intent = getIntent();
		LocationInfo locationInfo = (LocationInfo) intent.getSerializableExtra("locationInfo");
		if (locationInfo != null) {
			Resources res = getResources();
			Drawable marker = res.getDrawable(R.drawable.icon_mark);
			List<Overlay> list = mMapView.getOverlays();
			GeoPoint geoPoint = new GeoPoint((int) (locationInfo.getLat() * 1E6), (int) (locationInfo.getLon() * 1E6));
			mOverlay = new OverItemT(marker, this, geoPoint);
			list.add(mOverlay);
			// 创建弹出框view
			mPopView = super.getLayoutInflater().inflate(R.layout.dialog_mark, null);
			mMapView.addView(mPopView, new MapView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
					ViewGroup.LayoutParams.WRAP_CONTENT, null, MapView.LayoutParams.TOP_LEFT));
			mPopView.setVisibility(View.GONE);
		}

	}

	private void initLayout() {
		mMapView = (MapView) findViewById(R.id.activity_map_mapview);
		mMapView.setBuiltInZoomControls(false);
		// 得到 mMapView 的控制权,可以用它控制和驱动平移和缩放
		mMapController = mMapView.getController();
		// 设置地图 zoom 级别
		mMapController.setZoom(16);

		imageButton_Location = (ImageButton) findViewById(R.id.activity_map_location);
		imageButton_Location.setOnClickListener(this);
		imageButton_Point = (ImageButton) findViewById(R.id.activity_map_point);
		imageButton_Point.setOnClickListener(this);
	}

	private void myLocation(boolean isOpen) {
		if (isOpen) {
			/**
			 * 显示我的位置
			 */
			mMyLocation = new MyOverlay(this, mMapView);
			mMyLocation.enableCompass(); // 显示指南针
			mMyLocation.enableMyLocation(); // 显示我的位置
			mMapView.getOverlays().add(mMyLocation);

			LocationManager m_locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
			if (m_locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
				m_locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 30000, 5000, mMyLocation);
			} else if (!m_locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
				Toast.makeText(this, "请打开GPS定位服务", Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
				startActivityForResult(intent, 0); // 设置完成后返回到原来的界面

			} else if (m_locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
				m_locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 30000, 5000, mMyLocation);
			}
		}
	}

	private void initActionBar() {
		ActionBar actionBar = getActionBar();
		View actionBarLayoutView = LayoutInflater.from(this).inflate(R.layout.actionbar, null);
		button_Point = (Button) actionBarLayoutView.findViewById(R.id.actionbar_btn_select_pt);
		button_Point.setOnClickListener(this);
		button_OK = (Button) actionBarLayoutView.findViewById(R.id.actionbar_btn_save);
		button_OK.setOnClickListener(this);
		actionBar.setDisplayShowCustomEnabled(true);
		actionBar.setCustomView(actionBarLayoutView);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		mMapView.getController().stopAnimation(false);
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK)
			System.exit(0);
		return super.onKeyUp(keyCode, event);
	}

	class MyOverlay extends MyLocationOverlay {
		public MyOverlay(Context context, MapView mapView) {
			super(context, mapView);
		}

		/*
		 * 处理在"我的位置"上的点击事件
		 */
		protected boolean dispatchTap() {
			return true;
		}

		@Override
		public void onLocationChanged(Location location) {
			super.onLocationChanged(location);
			GeoPoint point = mMyLocation.getMyLocation();
			if (point != null)
				mMapView.getController().animateTo(point);
		}
	}

	class MarkOverlay extends Overlay {
		private Paint mPaint = null;
		private Context mContext;

		public MarkOverlay(Context context) {
			mContext = context;
			mPaint = new Paint();
		}

		@Override
		public boolean onTap(GeoPoint pt, MapView mapView) {
			mItem = new OverlayItem(pt, "Tap", pt.toString());
			mapView.postInvalidate();
			return true;
		}

		@Override
		public void draw(Canvas canvas, MapView mapView, boolean shadow) {
			super.draw(canvas, mapView, shadow);
			if (mItem == null) {
				return;
			}
			/**
			 * 以下为绘制点击位置及其坐标
			 */
			Drawable drawable = mContext.getResources().getDrawable(R.drawable.icon_mark);
			Point point = mapView.getProjection().toPixels(mItem.getPoint(), null);

			drawable.setBounds(point.x - drawable.getIntrinsicWidth() / 2, point.y - drawable.getIntrinsicHeight(),
					point.x + drawable.getIntrinsicWidth() / 2, point.y);
			drawable.draw(canvas);
			Rect bounds = new Rect();
			mPaint.getTextBounds(mItem.getSnippet(), 0, mItem.getSnippet().length() - 1, bounds); // 显示坐标文本
			canvas.drawText(mItem.getSnippet(), point.x - bounds.width() / 2, point.y - drawable.getIntrinsicHeight(),
					mPaint);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.map, menu);
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
		case R.id.activity_map_location:
			GeoPoint point = mMyLocation.getMyLocation();
			if (point != null)
				mMapView.getController().animateTo(point);
			break;
		case R.id.activity_map_point:
			Overlay markOverlay = new MarkOverlay(MyMapActivity.this);
			mMapView.getOverlays().add(markOverlay);
			break;
		case R.id.actionbar_btn_select_pt:
			button_Point.setClickable(false);
			markOverlay = new MarkOverlay(MyMapActivity.this);
			mMapView.getOverlays().add(markOverlay);
			break;
		case R.id.actionbar_btn_save:
			Intent intent = getIntent();
			if (mItem != null) {
				intent.putExtra("lat", mItem.getPoint().getLatitudeE6());
				intent.putExtra("long", mItem.getPoint().getLongitudeE6());
			}
			setResult(Activity.RESULT_FIRST_USER, intent);
			finish();
			break;
		default:
			break;
		}

	}

}
