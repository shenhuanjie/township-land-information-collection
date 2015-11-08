package com.example.town_land_collect.activity;

import java.util.ArrayList;
import java.util.List;

import org.litepal.crud.DataSupport;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

import com.example.town_land_collect.R;
import com.example.town_land_collect.model.LocationInfo;
import com.tianditu.android.maps.GeoPoint;
import com.tianditu.android.maps.ItemizedOverlay;
import com.tianditu.android.maps.MapController;
import com.tianditu.android.maps.MapView;
import com.tianditu.android.maps.MyLocationOverlay;
import com.tianditu.android.maps.Overlay;
import com.tianditu.android.maps.OverlayItem;

public class MapResourcesActivity extends ActionBarActivity {

	private static MapView mMapView;
	private MapController mMapController;
	private MyLocationOverlay mMyLocation;

	private static TextView textView_Title;
	private static TextView textView_Adress;
	private static TextView textView_Mark;
	
	private OverItemT mOverlay = null;
	private static View mPopView = null;
	
	private static List<LocationInfo> locationInfos;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		locationInfos=DataSupport.findAll(LocationInfo.class);
		ActionBar actionBar=getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		initLayout();
		getMyLocation(true);
	}

	/**
	 * 显示我的位置
	 */
	private void getMyLocation(boolean isOpen) {
		if (isOpen) {
			mMyLocation = new MyOverlay(this, mMapView);
			mMyLocation.enableCompass(); // 显示指南针
			mMyLocation.enableMyLocation(); // 显示我的位置
			mMapView.getOverlays().add(mMyLocation);

			LocationManager m_locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
			if (m_locationManager
					.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
				m_locationManager.requestLocationUpdates(
						LocationManager.NETWORK_PROVIDER, 30000, 5000, mMyLocation);
			} else if (!m_locationManager
					.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
				Toast.makeText(this, "请打开GPS定位服务", Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(
						Settings.ACTION_LOCATION_SOURCE_SETTINGS);
				startActivityForResult(intent, 0); // 设置完成后返回到原来的界面

			} else if (m_locationManager
					.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
				m_locationManager.requestLocationUpdates(
						LocationManager.GPS_PROVIDER, 30000, 5000, mMyLocation);
			}
		}
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
	
	private void initLayout() {
		mMapView = (MapView) findViewById(R.id.activity_map_mapview);
		mMapView.setBuiltInZoomControls(false);
		// 得到 mMapView 的控制权,可以用它控制和驱动平移和缩放
		mMapController = mMapView.getController();
		// 设置地图 zoom 级别
		mMapController.setZoom(16);

		Resources res = getResources();
		Drawable marker = res.getDrawable(R.drawable.icon_mark);
		List<Overlay> list = mMapView.getOverlays();
		MyLocationOverlay myLocation = new MyLocationOverlay(this, mMapView);
		myLocation.enableCompass();
		myLocation.enableMyLocation();
		list.add(myLocation);

		mOverlay = new OverItemT(marker, this);
		list.add(mOverlay);
		// 创建弹出框view
		mPopView = super.getLayoutInflater()
				.inflate(R.layout.dialog_mark, null);
		textView_Title=(TextView)mPopView.findViewById(R.id.dialog_mark_tv_title);
		textView_Mark=(TextView)mPopView.findViewById(R.id.dialog_mark_tv_mark);
		textView_Adress=(TextView)mPopView.findViewById(R.id.dialog_mark_tv_adress);
		mMapView.addView(mPopView, new MapView.LayoutParams(
				ViewGroup.LayoutParams.WRAP_CONTENT,
				ViewGroup.LayoutParams.WRAP_CONTENT, null,
				MapView.LayoutParams.TOP_LEFT));
		mPopView.setVisibility(View.GONE);
	}

	static class OverItemT extends ItemizedOverlay<OverlayItem> implements
			Overlay.Snappable {
		private List<OverlayItem> GeoList = new ArrayList<OverlayItem>();
		private static Drawable mMaker = null;

		public OverItemT(Drawable marker, Context context) {
			super((mMaker = boundCenterBottom(marker)));
			for (LocationInfo locationInfo : locationInfos) {
				GeoPoint geoPoint=new GeoPoint((int) (locationInfo.getLat() * 1E6), (int) (locationInfo.getLon() * 1E6));
				GeoList.add(new OverlayItem(geoPoint, "P1", "point1"));
			}
			populate(); // createItem(int)方法构造item。一旦有了数据，在调用其它方法前，首先调用这个方法

		}
		
		public OverItemT(Drawable marker, Context context,GeoPoint geoPoint) {
			super((mMaker = boundCenterBottom(marker)));
			GeoList.add(new OverlayItem(geoPoint, "P1", "point1"));
			populate(); // createItem(int)方法构造item。一旦有了数据，在调用其它方法前，首先调用这个方法

		}

		@Override
		protected OverlayItem createItem(int i) {
			return GeoList.get(i);
		}

		@Override
		public int size() {
			return GeoList.size();
		}

		public void addItem(OverlayItem item) {
			item.setMarker(mMaker);
			GeoList.add(item);
		}

		@Override
		// 处理当点击事件
		protected boolean onTap(int i) {
			GeoPoint pt = GeoList.get(i).getPoint();
			try {
				mMapView.updateViewLayout(mPopView, new MapView.LayoutParams(
						LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, pt,
						MapView.LayoutParams.BOTTOM_CENTER));
				mPopView.setVisibility(View.VISIBLE);
				textView_Title.setText(locationInfos.get(i).getName());
				textView_Adress.setText("坐标："+locationInfos.get(i).getLat()+","+locationInfos.get(i).getLon());
				textView_Mark.setText(locationInfos.get(i).getMark());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}

		@Override
		public boolean onTouchEvent(MotionEvent event, MapView mapView) {
			return super.onTouchEvent(event, mapView);
		}

		@Override
		public boolean onKeyUp(int keyCode, KeyEvent event, MapView mapView) {
			return super.onKeyUp(keyCode, event, mapView);
		}

		@Override
		public boolean onTrackballEvent(MotionEvent event, MapView mapView) {
			return super.onTrackballEvent(event, mapView);
		}

		@Override
		public void draw(Canvas canvas, MapView mapView, boolean shadow) {
			super.draw(canvas, mapView, shadow);
		}

		@Override
		public boolean draw(Canvas canvas, MapView mapView, boolean shadow,
				long when) {
			return super.draw(canvas, mapView, shadow, when);
		}

		@Override
		public boolean onTap(GeoPoint p, MapView mapView) {
			try {
				mPopView.setVisibility(View.GONE);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return super.onTap(p, mapView);
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		getMenuInflater().inflate(R.menu.map_resources, menu);
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
