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
			// ����������view
			mPopView = super.getLayoutInflater().inflate(R.layout.dialog_mark, null);
			mMapView.addView(mPopView, new MapView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
					ViewGroup.LayoutParams.WRAP_CONTENT, null, MapView.LayoutParams.TOP_LEFT));
			mPopView.setVisibility(View.GONE);
		}

	}

	private void initLayout() {
		mMapView = (MapView) findViewById(R.id.activity_map_mapview);
		mMapView.setBuiltInZoomControls(false);
		// �õ� mMapView �Ŀ���Ȩ,�����������ƺ�����ƽ�ƺ�����
		mMapController = mMapView.getController();
		// ���õ�ͼ zoom ����
		mMapController.setZoom(16);

		imageButton_Location = (ImageButton) findViewById(R.id.activity_map_location);
		imageButton_Location.setOnClickListener(this);
		imageButton_Point = (ImageButton) findViewById(R.id.activity_map_point);
		imageButton_Point.setOnClickListener(this);
	}

	private void myLocation(boolean isOpen) {
		if (isOpen) {
			/**
			 * ��ʾ�ҵ�λ��
			 */
			mMyLocation = new MyOverlay(this, mMapView);
			mMyLocation.enableCompass(); // ��ʾָ����
			mMyLocation.enableMyLocation(); // ��ʾ�ҵ�λ��
			mMapView.getOverlays().add(mMyLocation);

			LocationManager m_locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
			if (m_locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
				m_locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 30000, 5000, mMyLocation);
			} else if (!m_locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
				Toast.makeText(this, "���GPS��λ����", Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
				startActivityForResult(intent, 0); // ������ɺ󷵻ص�ԭ���Ľ���

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
		 * ������"�ҵ�λ��"�ϵĵ���¼�
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
			 * ����Ϊ���Ƶ��λ�ü�������
			 */
			Drawable drawable = mContext.getResources().getDrawable(R.drawable.icon_mark);
			Point point = mapView.getProjection().toPixels(mItem.getPoint(), null);

			drawable.setBounds(point.x - drawable.getIntrinsicWidth() / 2, point.y - drawable.getIntrinsicHeight(),
					point.x + drawable.getIntrinsicWidth() / 2, point.y);
			drawable.draw(canvas);
			Rect bounds = new Rect();
			mPaint.getTextBounds(mItem.getSnippet(), 0, mItem.getSnippet().length() - 1, bounds); // ��ʾ�����ı�
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
