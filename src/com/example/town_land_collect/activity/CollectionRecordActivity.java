package com.example.town_land_collect.activity;

import java.util.List;

import org.litepal.crud.DataSupport;

import rmobile.platform.http.AsyncHttpResponseHandler;
import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

import com.example.town_land_collect.R;
import com.example.town_land_collect.activity.edit_collection.collection_market_business.EditCollectionMarketBusinessHouseRentActivity;
import com.example.town_land_collect.activity.edit_collection.collection_market_business.EditCollectionMarketBusinessHouseSellActivity;
import com.example.town_land_collect.activity.edit_collection.collection_market_business.EditCollectionMarketBusinessRentOutActivity;
import com.example.town_land_collect.activity.edit_collection.collection_market_business.EditCollectionMarketBusinessSellActivity;
import com.example.town_land_collect.activity.edit_collection.collection_market_business.EditCollectionMarketBusinessShareHolderActivity;
import com.example.town_land_collect.activity.edit_collection.collection_market_business.EditCollectionMarketBusinessTransferActivity;
import com.example.town_land_collect.activity.edit_collection.collection_market_demand.EditCollectionMarketDemandHouseRentActivity;
import com.example.town_land_collect.activity.edit_collection.collection_market_demand.EditCollectionMarketDemandHouseSellActivity;
import com.example.town_land_collect.activity.edit_collection.collection_market_demand.EditCollectionMarketDemandRentActivity;
import com.example.town_land_collect.activity.edit_collection.collection_market_demand.EditCollectionMarketDemandSellActivity;
import com.example.town_land_collect.activity.edit_collection.collection_market_demand.EditCollectionMarketDemandShareHolderActivity;
import com.example.town_land_collect.activity.edit_collection.collection_market_demand.EditCollectionMarketDemandTransferActivity;
import com.example.town_land_collect.activity.edit_collection.collection_market_development.EditCollectionMarketDevelopmentTownshipActivity;
import com.example.town_land_collect.activity.edit_collection.collection_market_development.EditCollectionMarketDevelopmentVillageActivity;
import com.example.town_land_collect.activity.edit_collection.collection_market_monitor.EditCollectionMarketMonitorLandLevelActivity;
import com.example.town_land_collect.activity.edit_collection.collection_market_monitor.EditCollectionMarketMonitorLandValueActivity;
import com.example.town_land_collect.activity.edit_collection.collection_market_monitor.EditCollectionMarketMonitorPointActivity;
import com.example.town_land_collect.activity.edit_collection.collection_market_redevelopment.EditCollectionMarketRedevelopmentImposeActivity;
import com.example.town_land_collect.activity.edit_collection.collection_market_redevelopment.EditCollectionMarketRedevelopmentPlanActivity;
import com.example.town_land_collect.activity.edit_collection.collection_market_supply.EditCollectionMarketSupplyHouseRentActivity;
import com.example.town_land_collect.activity.edit_collection.collection_market_supply.EditCollectionMarketSupplyHouseSellActivity;
import com.example.town_land_collect.activity.edit_collection.collection_market_supply.EditCollectionMarketSupplyRentActivity;
import com.example.town_land_collect.activity.edit_collection.collection_market_supply.EditCollectionMarketSupplySellActivity;
import com.example.town_land_collect.activity.edit_collection.collection_market_supply.EditCollectionMarketSupplyShareHolderActivity;
import com.example.town_land_collect.activity.edit_collection.collection_market_supply.EditCollectionMarketSupplyTransferActivity;
import com.example.town_land_collect.adapter.LocationMarkAdapter;
import com.example.town_land_collect.commom.WebService;
import com.example.town_land_collect.model.LocationInfo;
import com.example.town_land_collect.model.MobileResultEntity;
import com.example.town_land_collect.util.CollectType;
import com.example.town_land_collect.util.ToastUtil;
import com.example.town_land_collect.view.XListView;
import com.example.town_land_collect.view.XListView.IXListViewListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class CollectionRecordActivity extends ActionBarActivity implements IXListViewListener, OnItemClickListener {
	public WebService webservice;

	private LocationInfo uploadInfo;// 正在上传的记录
	private LocationInfo uploadImageInfo;

	private List<LocationInfo> locationInfos;
	private List<LocationInfo> uploadInfos;// 本地待上传记录列表
	private List<LocationInfo> uploadImageInfos;// 本地待上传图片记录列表

	private XListView mListView;
	LocationMarkAdapter adapter;
	private Handler mHandler;
	private CollectionRecordActivity that = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		webservice = new WebService(this);
		setContentView(R.layout.activity_collection_record);
		locationInfos = DataSupport.findAll(LocationInfo.class);

		mListView = (XListView) findViewById(R.id.activity_collection_record_xlistview);
		adapter = new LocationMarkAdapter(CollectionRecordActivity.this, locationInfos);
		mHandler = new Handler();
		mListView.setAdapter(adapter);
		mListView.setOnItemClickListener(this);
		mListView.setPullLoadEnable(true);
		mListView.setXListViewListener(this);
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);

		if (checkUploadImageFlag()) {// 开启自动上传
			// TODO 后台服务
			// startUploadImage();
		}
	}

	// 检查待上传图片
	private boolean checkUploadImageFlag() {
		uploadInfos = DataSupport.where("stateCode = ?", "0").find(LocationInfo.class);
		if (uploadInfos != null) {
			if (uploadInfos.size() == 0) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.collection_record, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		switch (id) {
		case android.R.id.home:
			this.finish();
			return true;
		case R.id.action_download_record:
			Toast.makeText(this, "同步记录中,请稍候...", Toast.LENGTH_SHORT).show();
		case R.id.action_upload_record:
			uploadInfos = DataSupport.where("stateCode = ?", "0").find(LocationInfo.class);
			if (uploadInfos != null) {
				if (uploadInfos.size() == 0) {
					Toast.makeText(this, "记录已全部上传...", Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(this, "上传记录中,请稍候...", Toast.LENGTH_SHORT).show();
					// 上传记录
					uploadRecordList();
				}
			}
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * 开始上传图片
	 */
	private void startUploadImage() {
		uploadImageInfos = DataSupport.where("imageStateCode = ?", CollectType.State_Image_Code_Not_Yet_Upload + "").find(LocationInfo.class);
		if (uploadImageInfos != null && uploadImageInfos.size() != 0) {
			if (uploadInfos.size() == 0) {
				ToastUtil.ToastStr(this, "同步成功[1/2],同步本地图片中...", 2000);
			}
			uploadImageList();
		}
	}

	/**
	 * 上传记录列表
	 */
	private void uploadRecordList() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (LocationInfo info : uploadInfos) {
					uploadInfo = info;
					webservice.uploadRecordList(info, uploadRecordListHandler);
				}
			}
		}).start();
	}

	// 上传记录列表返回
	private AsyncHttpResponseHandler uploadRecordListHandler = new AsyncHttpResponseHandler() {
		@Override
		public void onSuccess(final String content) {
			MobileResultEntity<String> mobileResult = new Gson().fromJson(content, new TypeToken<MobileResultEntity<String>>() {
			}.getType());
			if (mobileResult.getErrorCode() == 1) {
				LocationInfo model = DataSupport.find(LocationInfo.class, uploadInfo.getId());
				model.setStateCode(CollectType.State_Code_Uploaded);
				model.setState("任务状态：已上传");
				if (model.getImageUri() != null) {
					model.setImageStateCode(CollectType.State_Image_Code_Not_Yet_Upload);// 待上传
				}
				model.setUploadId(mobileResult.getRecordId());
				model.update(model.getId());
				Toast.makeText(that, "上传成功[1/2],同步本地图片中...", Toast.LENGTH_SHORT).show();

				startUploadImage();
			} else {
				Toast.makeText(that, mobileResult.getMsg(), Toast.LENGTH_SHORT).show();
			}
		}

		@Override
		public void onFailure(Throwable error, String content) {
			Toast.makeText(that, "上传失败，请检查填写数据是否正确", Toast.LENGTH_SHORT).show();
		}
	};

	/**
	 * 上传图片列表
	 */
	private void uploadImageList() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (LocationInfo info : uploadImageInfos) {
					uploadImageInfo = info;
					// webservice.uploadImageList(info, uploadImageListHandler);
				}
			}
		}).start();
	}

	// 上传图片列表返回
	private AsyncHttpResponseHandler uploadImageListHandler = new AsyncHttpResponseHandler() {
		@Override
		public void onSuccess(final String content) {
			MobileResultEntity<String> mobileResult = new Gson().fromJson(content, new TypeToken<MobileResultEntity<String>>() {
			}.getType());
			if (mobileResult.getErrorCode() == 1) {
				LocationInfo model = DataSupport.find(LocationInfo.class, uploadImageInfo.getId());
				model.setImageStateCode(CollectType.State_Image_Code_Uploaded);// 已上传
				model.update(model.getId());
				Toast.makeText(that, "上传成功[2/2],上载图片完毕...", Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(that, mobileResult.getMsg(), Toast.LENGTH_SHORT).show();
			}
		}

		@Override
		public void onFailure(Throwable error, String content) {
			Toast.makeText(that, "上传失败", Toast.LENGTH_SHORT).show();
		}
	};

	@Override
	public void onRefresh() {
		mHandler.postDelayed(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				onLoad();
			}
		}, 2000);
	}

	private void onLoad() {
		mListView.stopRefresh();
		mListView.stopLoadMore();
		mListView.setRefreshTime("刚刚");
	}

	@Override
	public void onLoadMore() {
		mHandler.postDelayed(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				onLoad();
			}
		}, 2000);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Intent intent;
		LocationInfo locationInfo = locationInfos.get(position - 1);
		if (locationInfo != null) {
			int collectionType = locationInfo.getCollectionType();
			switch (collectionType) {
			case CollectType.Collection_Market_Business_House_Rent:
				intent = new Intent(CollectionRecordActivity.this, EditCollectionMarketBusinessHouseRentActivity.class);
				intent.putExtra("locationInfo", locationInfo);
				startActivity(intent);
				break;
			case CollectType.Collection_Market_Business_House_Sell:
				intent = new Intent(CollectionRecordActivity.this, EditCollectionMarketBusinessHouseSellActivity.class);
				intent.putExtra("locationInfo", locationInfo);
				startActivity(intent);
				break;
			case CollectType.Collection_Market_Business_Rent_Out:
				intent = new Intent(CollectionRecordActivity.this, EditCollectionMarketBusinessRentOutActivity.class);
				intent.putExtra("locationInfo", locationInfo);
				startActivity(intent);
				break;
			case CollectType.Collection_Market_Business_Sell:
				intent = new Intent(CollectionRecordActivity.this, EditCollectionMarketBusinessSellActivity.class);
				intent.putExtra("locationInfo", locationInfo);
				startActivity(intent);
				break;
			case CollectType.Collection_Market_Business_ShareHolder:
				intent = new Intent(CollectionRecordActivity.this, EditCollectionMarketBusinessShareHolderActivity.class);
				intent.putExtra("locationInfo", locationInfo);
				startActivity(intent);
				break;
			case CollectType.Collection_Market_Business_Transfer:
				intent = new Intent(CollectionRecordActivity.this, EditCollectionMarketBusinessTransferActivity.class);
				intent.putExtra("locationInfo", locationInfo);
				startActivity(intent);
				break;

			case CollectType.Collection_Market_Demand_House_Rent:
				intent = new Intent(CollectionRecordActivity.this, EditCollectionMarketDemandHouseRentActivity.class);
				intent.putExtra("locationInfo", locationInfo);
				startActivity(intent);
				break;
			case CollectType.Collection_Market_Demand_House_Sell:
				intent = new Intent(CollectionRecordActivity.this, EditCollectionMarketDemandHouseSellActivity.class);
				intent.putExtra("locationInfo", locationInfo);
				startActivity(intent);
				break;
			case CollectType.Collection_Market_Demand_Rent:
				intent = new Intent(CollectionRecordActivity.this, EditCollectionMarketDemandRentActivity.class);
				intent.putExtra("locationInfo", locationInfo);
				startActivity(intent);
				break;
			case CollectType.Collection_Market_Demand_Sell:
				intent = new Intent(CollectionRecordActivity.this, EditCollectionMarketDemandSellActivity.class);
				intent.putExtra("locationInfo", locationInfo);
				startActivity(intent);
				break;
			case CollectType.Collection_Market_Demand_ShareHolder:
				intent = new Intent(CollectionRecordActivity.this, EditCollectionMarketDemandShareHolderActivity.class);
				intent.putExtra("locationInfo", locationInfo);
				startActivity(intent);
				break;
			case CollectType.Collection_Market_Demand_Transfer:
				intent = new Intent(CollectionRecordActivity.this, EditCollectionMarketDemandTransferActivity.class);
				intent.putExtra("locationInfo", locationInfo);
				startActivity(intent);
				break;

			case CollectType.Collection_Market_Monitor_Land_Level:
				intent = new Intent(CollectionRecordActivity.this, EditCollectionMarketMonitorLandLevelActivity.class);
				intent.putExtra("locationInfo", locationInfo);
				startActivity(intent);
				break;
			case CollectType.Collection_Market_Monitor_Land_Value:
				intent = new Intent(CollectionRecordActivity.this, EditCollectionMarketMonitorLandValueActivity.class);
				intent.putExtra("locationInfo", locationInfo);
				startActivity(intent);
				break;
			case CollectType.Collection_Market_Monitor_Point:
				intent = new Intent(CollectionRecordActivity.this, EditCollectionMarketMonitorPointActivity.class);
				intent.putExtra("locationInfo", locationInfo);
				startActivity(intent);
				break;

			case CollectType.Collection_Market_Supply_House_Rent:
				intent = new Intent(CollectionRecordActivity.this, EditCollectionMarketSupplyHouseRentActivity.class);
				intent.putExtra("locationInfo", locationInfo);
				startActivity(intent);
				break;
			case CollectType.Collection_Market_Supply_House_Sell:
				intent = new Intent(CollectionRecordActivity.this, EditCollectionMarketSupplyHouseSellActivity.class);
				intent.putExtra("locationInfo", locationInfo);
				startActivity(intent);
				break;
			case CollectType.Collection_Market_Supply_Rent:
				intent = new Intent(CollectionRecordActivity.this, EditCollectionMarketSupplyRentActivity.class);
				intent.putExtra("locationInfo", locationInfo);
				startActivity(intent);
				break;
			case CollectType.Collection_Market_Supply_Sell:
				intent = new Intent(CollectionRecordActivity.this, EditCollectionMarketSupplySellActivity.class);
				intent.putExtra("locationInfo", locationInfo);
				startActivity(intent);
				break;
			case CollectType.Collection_Market_Supply_ShareHolder:
				intent = new Intent(CollectionRecordActivity.this, EditCollectionMarketSupplyShareHolderActivity.class);
				intent.putExtra("locationInfo", locationInfo);
				startActivity(intent);
				break;
			case CollectType.Collection_Market_Development_Township:
				intent = new Intent(CollectionRecordActivity.this, EditCollectionMarketDevelopmentTownshipActivity.class);
				intent.putExtra("locationInfo", locationInfo);
				startActivity(intent);
				break;
			case CollectType.Collection_Market_Development_Village:
				intent = new Intent(CollectionRecordActivity.this, EditCollectionMarketDevelopmentVillageActivity.class);
				intent.putExtra("locationInfo", locationInfo);
				startActivity(intent);
				break;
			case CollectType.Collection_Market_Redevelopment_Impose:
				intent = new Intent(CollectionRecordActivity.this, EditCollectionMarketRedevelopmentImposeActivity.class);
				intent.putExtra("locationInfo", locationInfo);
				startActivity(intent);
				break;
			case CollectType.Collection_Market_Redevelopment_Plan:
				intent = new Intent(CollectionRecordActivity.this, EditCollectionMarketRedevelopmentPlanActivity.class);
				intent.putExtra("locationInfo", locationInfo);
				startActivity(intent);
				break;
			case CollectType.Collection_Market_Supply_Transfer:
				intent = new Intent(CollectionRecordActivity.this, EditCollectionMarketSupplyTransferActivity.class);
				intent.putExtra("locationInfo", locationInfo);
				startActivity(intent);
				break;
			case -1:
				break;
			default:
				intent = new Intent(CollectionRecordActivity.this, EditCollectionMarketBusinessSellActivity.class);
				intent.putExtra("locationInfo", locationInfo);
				startActivity(intent);
				break;
			}
		}

	}
}
