package com.example.town_land_collect.activity;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import rmobile.platform.http.AsyncHttpResponseHandler;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.Window;
import android.widget.Toast;

import com.example.town_land_collect.R;
import com.example.town_land_collect.commom.WebService;
import com.example.town_land_collect.fragment.CollectionFragment;
import com.example.town_land_collect.fragment.IndexFragment;
import com.example.town_land_collect.fragment.TaskFragment;
import com.example.town_land_collect.fragment.UserFragment;
import com.example.town_land_collect.model.AttachmentEntity;
import com.example.town_land_collect.model.LocationInfo;
import com.example.town_land_collect.model.MobileResultEntity;
import com.example.town_land_collect.util.CollectType;
import com.example.town_land_collect.util.ComUtil;
import com.example.town_land_collect.view.ChangeColorView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tianditu.android.b.m;

public class MainActivity extends FragmentActivity implements OnPageChangeListener, OnClickListener {
	public FragmentTransaction mFragmentTransaction;
	public FragmentManager fragmentManager;
	public List<Fragment> fragmentList;
	public Fragment fragment;
	public Integer curFragmentParent = 0;
	public Integer curFragmentChildren = 0;
	long enterTime = 0;
	long leaveTime = 0;
	long enterTotalTime = 0;
	long leaveTotalTime = 0;
	private String imagePathString = null;
	// TODO 图片相关
	private String[] imagePathTempList = null;
	private List<String> imagePathList = new ArrayList<String>();
	private int imagePathListIndex = 0;

	public WebService webservice;

	private int successNum = 0;
	private int waitNum = 0;
	private int errNum = 0;
	private int totalNum = 0;

	private LocationInfo uploadInfo;// 正在上传的记录
	private AttachmentEntity uploadImageInfo;

	private List<LocationInfo> uploadInfos;// 本地待上传记录列表
	private List<AttachmentEntity> uploadImageInfos;// 本地待上传图片记录列表

	private ViewPager mViewPager;
	private List<Fragment> mTabs = new ArrayList<Fragment>();
	private FragmentPagerAdapter mAdapter;

	private boolean mTab = false;

	private String[] mTitles = new String[] { "主页", "信息采集", "采集记录", "个人设置" };

	private List<ChangeColorView> mTabIndicator = new ArrayList<ChangeColorView>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		webservice = new WebService(this);
		setContentView(R.layout.activity_main);
		setOverflowShowingAlways();
		getActionBar().setDisplayShowHomeEnabled(true); // 使左上角图标是否显示，如果设成false，则没有程序图标，仅仅就个标题，否则，显示应用程序图标，对应id为android.R.id.home，对应ActionBar.DISPLAY_SHOW_HOME
		mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
		@SuppressWarnings("unused")
		SQLiteDatabase db = Connector.getDatabase();
		initDatas();

		mViewPager.setAdapter(mAdapter);
		mViewPager.setOnPageChangeListener(this);
	}

	private void initDatas() {

		for (String title : mTitles) {
			if (title.equals("主页")) {
				IndexFragment indexFragment = new IndexFragment();
				Bundle args = new Bundle();
				args.putString("title", title);
				indexFragment.setArguments(args);
				mTabs.add(indexFragment);
			} else if (title.equals("信息采集")) {
				CollectionFragment collectionFragment = new CollectionFragment();
				Bundle args = new Bundle();
				args.putString("title", title);
				collectionFragment.setArguments(args);
				mTabs.add(collectionFragment);
			} else if (title.equals("采集记录")) {
				TaskFragment taskFragment = new TaskFragment();
				Bundle args = new Bundle();
				args.putString("title", title);
				taskFragment.setArguments(args);
				mTabs.add(taskFragment);
			} else {
				UserFragment tabFragment = new UserFragment();
				Bundle args = new Bundle();
				args.putString("title", title);
				tabFragment.setArguments(args);
				mTabs.add(tabFragment);
			}
		}

		mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

			@Override
			public int getCount() {
				return mTabs.size();
			}

			@Override
			public Fragment getItem(int arg0) {
				return mTabs.get(arg0);
			}
		};

		initTabIndicator();

	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// 有两种情况：1、进入Launcher后第一次点MENU按钮触发onCreateOptionsMenu后调用；2、经过第一步，以后每次点MENU按钮时都会触发
		super.onPrepareOptionsMenu(menu);
		MenuItem actionSettings = menu.findItem(R.id.action_upload_record);
		if (mTab) {
			actionSettings.setVisible(true);
		} else {
			actionSettings.setVisible(false);
		}
		return true;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		switch (id) {
		case R.id.action_quit_record:
			this.finish();
			return true;
		case R.id.action_upload_record:
			uploadInfos = DataSupport.where("stateCode = ?", "0").find(LocationInfo.class);
			if (waitNum != 0) {
				Toast.makeText(this, "重新开始上传,请稍候...", Toast.LENGTH_SHORT).show();
			}
			if (uploadInfos != null) {
				if (uploadInfos.size() == 0) {
					Toast.makeText(this, "记录已全部上传...", Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(this, "上传记录中,请稍候...", Toast.LENGTH_SHORT).show();
					if (uploadInfos != null && uploadInfos.size() != 0) {
						// 上传记录
						uploadRecordList();
					}
				}
			}
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * 
	 * 说明：上传记录
	 * 
	 * @return void
	 */
	private void uploadRecordList() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				if (uploadInfos != null && uploadInfos.size() != 0) {
					totalNum = uploadInfos.size();
					waitNum = totalNum;
					successNum = 0;
					errNum = 0;
					LocationInfo info = uploadInfos.get(0);
					uploadInfo = info;
					enterTime = System.currentTimeMillis();
					enterTotalTime = System.currentTimeMillis();
					webservice.uploadRecordList(info, uploadRecordListHandler);
				}
			}
		}).start();
	}

	/**
	 * 上传记录列表返回
	 */
	private AsyncHttpResponseHandler uploadRecordListHandler = new AsyncHttpResponseHandler() {
		@Override
		public void onSuccess(final String content) {
			MobileResultEntity<String> mobileResult = new Gson().fromJson(content, new TypeToken<MobileResultEntity<String>>() {
			}.getType());
			if (mobileResult.getErrorCode() == 1) {
				uploadRecodeSuccess(mobileResult);
			} else {
				uploadRecodeFailed();
			}
		}

		@Override
		public void onFailure(Throwable error, String content) {
			uploadRecodeFailed();
		}

		/**
		 * 说明：上传失败
		 * 
		 * @return void
		 */
		private void uploadRecodeFailed() {
			if (waitNum != 0) {
				updateFailedLocationInfoModel();
				showUploadTip();
				checkAndUploadNextInfo();
			} else {
				uploadImageFailed();
			}
		}

		/**
		 * 说明：上传成功
		 * 
		 * @param mobileResult
		 * @return void
		 */
		private void uploadRecodeSuccess(MobileResultEntity<String> mobileResult) {
			if (waitNum != 0) {
				updateLocationInfoModel(mobileResult);
				showUploadTip();
				checkAndUploadNextInfo();
			} else {
				uploadImageSuccess(mobileResult);
			}
		}

		/**
		 * 说明：还原上传失败记录状态
		 * 
		 * @return void
		 */
		private void resetExpiredRecode() {
			uploadInfos = DataSupport.where("stateCode = ?", CollectType.State_Code_Expired + "").find(LocationInfo.class);
			for (LocationInfo model : uploadInfos) {
				model.setStateCode(CollectType.State_Code_Not_Yet_Upload);
				model.update(model.getId());
			}
		}

		/**
		 * 说明：检查和上传下一条记录
		 * 
		 * @return void
		 */
		private void checkAndUploadNextInfo() {
			uploadInfos = DataSupport.where("stateCode = ?", CollectType.State_Code_Not_Yet_Upload + "").find(LocationInfo.class);
			if (uploadInfos != null && uploadInfos.size() != 0) {
				LocationInfo info = uploadInfos.get(0);
				uploadInfo = info;
				enterTime = System.currentTimeMillis();
				webservice.uploadRecordList(info, uploadRecordListHandler);
			} else {
				resetExpiredRecode();
				uploadImageInfos = DataSupport.where("stateCode = ?", "1").find(AttachmentEntity.class);
				if (uploadImageInfos != null && uploadImageInfos.size() != 0) {
					AttachmentEntity info = uploadImageInfos.get(0);
					uploadImageInfo = info;
					enterTime = System.currentTimeMillis();
					webservice.uploadImageList(info, uploadRecordListHandler);
				}
			}
		}

		/**
		 * 说明：显示上传提示信息
		 * 
		 * @return void
		 */
		private void showUploadTip() {
			// 更新进度信息
			successNum++;
			waitNum = totalNum - successNum - errNum;
			leaveTime = System.currentTimeMillis();
			double time = (double) leaveTime - enterTotalTime;
			time = time / 1000;
			BigDecimal b = new BigDecimal(time);
			time = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			Toast.makeText(getApplicationContext(), "已上传成功:" + successNum + ",待上传:" + waitNum + ",未成功:" + errNum + ",当前耗时:" + time + "s", Toast.LENGTH_SHORT).show();
		}

		/**
		 * 说明：更新上传成功后的本地记录
		 * 
		 * @param mobileResult
		 * @return void
		 */
		@SuppressLint("SimpleDateFormat")
		private void updateLocationInfoModel(MobileResultEntity<String> mobileResult) {
			leaveTime = System.currentTimeMillis();
			double time = (double) leaveTime - enterTime;
			time = time / 1000;
			BigDecimal b = new BigDecimal(time);
			time = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			LocationInfo model = DataSupport.find(LocationInfo.class, uploadInfo.getId());
			model.setStateCode(CollectType.State_Code_Uploaded);
			model.setState("任务状态：已上传");
			model.setUploadId(mobileResult.getRecordId());
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");// 设置日期格式
			model.setUploaddate("上传时间：" + df.format(new Date()));
			model.setTimeconsuming("上传耗时：" + time + "s");
			model.setAttachment(uploadInfo.getAttachment() + "");
			model.update(model.getId());
			if (model.getImageUri() != null) {
				List<AttachmentEntity> attachmentEntities = DataSupport.where("objId=?", model.getId() + "").find(AttachmentEntity.class);
				if (attachmentEntities != null && attachmentEntities.size() != 0) {
					for (AttachmentEntity attachmentEntity : attachmentEntities) {
						attachmentEntity.setStateCode(1);
						attachmentEntity.update(attachmentEntity.getId());
					}
				}
			}
		}

		private void updateFailedLocationInfoModel() {
			LocationInfo model = DataSupport.find(LocationInfo.class, uploadInfo.getId());
			model.setStateCode(CollectType.State_Code_Expired);
			model.setState("任务状态：上传失败");
			model.update(model.getId());
		}

		private void uploadImageSuccess(MobileResultEntity<String> mobileResult) {
			updateSuccessImageInfo();
			uploadImageInfos = DataSupport.where("stateCode = ?", "1").find(AttachmentEntity.class);
			if (uploadImageInfos != null && uploadImageInfos.size() != 0) {
				AttachmentEntity info = uploadImageInfos.get(0);
				uploadImageInfo = info;
				enterTime = System.currentTimeMillis();
				webservice.uploadImageList(info, uploadRecordListHandler);
			} else {
				resetUploadFailedImageInfo();
			}
		}

		private void uploadImageFailed() {
			updateFailedImageInfo();
			uploadImageInfos = DataSupport.where("stateCode = ?", "1").find(AttachmentEntity.class);
			if (uploadImageInfos != null && uploadImageInfos.size() != 0) {
				AttachmentEntity info = uploadImageInfos.get(0);
				uploadImageInfo = info;
				enterTime = System.currentTimeMillis();
				webservice.uploadImageList(info, uploadRecordListHandler);
			} else {
				resetUploadFailedImageInfo();
			}
		}

		private void resetUploadFailedImageInfo() {
			uploadImageInfos = DataSupport.where("stateCode = ?", "3").find(AttachmentEntity.class);
			for (AttachmentEntity model : uploadImageInfos) {
				model.setStateCode(1);
				model.update(model.getId());
			}
		}

		/**
		 * 说明：上传图片成功
		 * 
		 * @return void
		 */
		private void updateSuccessImageInfo() {
			leaveTime = System.currentTimeMillis();
			double nowtime = (double) leaveTime - enterTime;
			nowtime = nowtime / 1000;
			BigDecimal b = new BigDecimal(nowtime);
			nowtime = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			LocationInfo model = DataSupport.find(LocationInfo.class, uploadImageInfo.getObjId());
			String oldTimeStr = model.getTimeconsuming();
			double oldTime = 0;
			oldTimeStr = oldTimeStr.replace("上传耗时：", "");
			oldTimeStr = oldTimeStr.replace("s", "");
			try {
				oldTime = Double.valueOf(oldTimeStr);
				BigDecimal ob = new BigDecimal(oldTime + nowtime);
				double time = ob.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
				model.setTimeconsuming("上传耗时：" + time + "s");
			} catch (Exception e) {
			}
			model.update(model.getId());
			uploadImageInfo.setStateCode(2);
			uploadImageInfo.update(uploadImageInfo.getId());
		}

		private void updateFailedImageInfo() {
			uploadImageInfo.setStateCode(3);
			uploadImageInfo.update(uploadImageInfo.getId());
		}

	};

	private void initTabIndicator() {
		ChangeColorView one = (ChangeColorView) findViewById(R.id.id_indicator_one);
		ChangeColorView two = (ChangeColorView) findViewById(R.id.id_indicator_two);
		ChangeColorView three = (ChangeColorView) findViewById(R.id.id_indicator_three);
		ChangeColorView four = (ChangeColorView) findViewById(R.id.id_indicator_four);

		mTabIndicator.add(one);
		mTabIndicator.add(two);
		mTabIndicator.add(three);
		mTabIndicator.add(four);

		one.setOnClickListener(this);
		two.setOnClickListener(this);
		three.setOnClickListener(this);
		four.setOnClickListener(this);

		one.setIconAlpha(1.0f);
	}

	@Override
	public void onPageSelected(int arg0) {
	}

	@Override
	public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

		if (positionOffset > 0) {
			ChangeColorView left = mTabIndicator.get(position);
			ChangeColorView right = mTabIndicator.get(position + 1);

			left.setIconAlpha(1 - positionOffset);
			right.setIconAlpha(positionOffset);
		}

	}

	@Override
	public void onPageScrollStateChanged(int state) {

	}

	@Override
	public void onClick(View v) {

		resetOtherTabs();

		switch (v.getId()) {
		case R.id.id_indicator_one:
			mTabIndicator.get(0).setIconAlpha(1.0f);
			mViewPager.setCurrentItem(0, false);
			break;
		case R.id.id_indicator_two:
			mTabIndicator.get(1).setIconAlpha(1.0f);
			mViewPager.setCurrentItem(1, false);
			break;
		case R.id.id_indicator_three:
			mTab = true;
			mTabIndicator.get(2).setIconAlpha(1.0f);
			mViewPager.setCurrentItem(2, false);
			break;
		case R.id.id_indicator_four:
			mTabIndicator.get(3).setIconAlpha(1.0f);
			mViewPager.setCurrentItem(3, false);
			break;

		}

	}

	/**
	 * 重置其他的Tab
	 */
	private void resetOtherTabs() {
		for (int i = 0; i < mTabIndicator.size(); i++) {
			mTabIndicator.get(i).setIconAlpha(0);
		}
		mTab = false;
	}

	@Override
	public boolean onMenuOpened(int featureId, Menu menu) {
		if (featureId == Window.FEATURE_ACTION_BAR && menu != null) {
			if (menu.getClass().getSimpleName().equals("MenuBuilder")) {
				try {
					Method m = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
					m.setAccessible(true);
					m.invoke(menu, true);
				} catch (Exception e) {
				}
			}
		}
		return super.onMenuOpened(featureId, menu);
	}

	private void setOverflowShowingAlways() {
		try {
			// true if a permanent menu key is present, false otherwise.
			ViewConfiguration config = ViewConfiguration.get(this);
			Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
			menuKeyField.setAccessible(true);
			menuKeyField.setBoolean(config, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * 在fragment的管理类中，我们要实现这部操作，而他的主要作用是，当D这个activity回传数据到
	 * 这里碎片管理器下面的fragnment中时，往往会经过这个管理器中的onActivityResult的方法。
	 */
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (data != null) {
			curFragmentParent = data.getIntExtra("curFragmentParent", 0);
		}
		if (requestCode == ComUtil.RequestCode_Photo_Value) {
			curFragmentParent = 1;
		} else if (requestCode == ComUtil.RequestCode_Album) {
			curFragmentParent = 1;
		}
		fragmentManager = getSupportFragmentManager();
		/* 在这里，我们通过碎片管理器中的Tag，就是每个碎片的名称，来获取对应的fragment */
		fragmentList = fragmentManager.getFragments();
		fragment = fragmentList.get(curFragmentParent);
		/* 然后在碎片中调用重写的onActivityResult方法 */
		fragment.onActivityResult(requestCode, resultCode, data);
	}
}
