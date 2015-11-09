package com.example.town_land_collect.fragment;

import java.util.ArrayList;
import java.util.List;

import org.litepal.crud.DataSupport;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;

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
import com.example.town_land_collect.adapter.TaskAdapter;
import com.example.town_land_collect.model.LocationInfo;
import com.example.town_land_collect.model.Task_Introduce;
import com.example.town_land_collect.util.CollectType;
import com.example.town_land_collect.view.XListView;
import com.example.town_land_collect.view.XListView.IXListViewListener;

public class TaskFragment extends Fragment implements IXListViewListener, OnItemClickListener {
	Resources resources;
	private XListView xListView;
	private ImageView ivBottomLine;
	private TextView tvTab2, tvTab3;
	private List<Task_Introduce> lisTask_Introduces = new ArrayList<Task_Introduce>();
	private Handler mHandler;
	private int state = 0;
	private TaskAdapter taskAdapter;

	private int currIndex = 0;
	private int bottomLineWidth;
	private int offset = 0;
	private int position_one;
	private int position_two;
	public final static int num = 3;

	private List<LocationInfo> locatinoInfos;

	private int unsync_start = 0;
	private int unsync_limit = 10;

	private int sync_start = 0;
	private int sync_limit = 10;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_task, container, false);
		xListView = (XListView) view.findViewById(R.id.fragment_task_xlistview);
		this.resources = getResources();

		tvTab2 = (TextView) view.findViewById(R.id.fragment_task_tv_tab_2);
		tvTab3 = (TextView) view.findViewById(R.id.fragment_task_tv_tab_3);

		initWidth(view);
		initTextView();

		iniTask_Introduces(0);
		taskAdapter = new TaskAdapter(getActivity(), lisTask_Introduces, 0);
		xListView.setAdapter(taskAdapter);
		xListView.setOnItemClickListener(this);
		xListView.setPullLoadEnable(true);
		xListView.setXListViewListener(this);
		mHandler = new Handler();
		TranslateAnimation animation = new TranslateAnimation(offset, position_two, 0, 0);

		animation.setFillAfter(true);
		animation.setDuration(30);
		ivBottomLine.startAnimation(animation);

		return view;
	}

	private void loadData(int state) {
		int start = state == 0 ? unsync_start : sync_start;
		int limit = state == 0 ? unsync_limit : sync_limit;

		// Records in descending order
		locatinoInfos = DataSupport.where("stateCode = ?", String.valueOf(state)).offset(start).limit(limit).order("date desc").find(LocationInfo.class);

		for (LocationInfo locationInfo : locatinoInfos) {
			Task_Introduce task_Introduce = new Task_Introduce();
			task_Introduce.setTask_Id(locationInfo.getId());
			task_Introduce.setTask_Name(locationInfo.getName());
			task_Introduce.setTask_Time(locationInfo.getDate());
			String[] attList;
			int num = 0;
			if (locationInfo.getImageUri() != null) {
				attList = locationInfo.getImageUri().split(",");
				num = attList.length;
			}
			if (state == 0) {
				task_Introduce.setTask_State("状态：未同步");
				task_Introduce.setTask_Attachment("待上传图片：" + num + "张");
			} else {
				task_Introduce.setTask_State("状态：已同步");
				task_Introduce.setTask_Attachment("已上传图片：" + num + "张");
				task_Introduce.setTask_UploadTime(locationInfo.getUploaddate());
				task_Introduce.setTask_TimeConsuming(locationInfo.getTimeconsuming());

			}
			lisTask_Introduces.add(task_Introduce);
		}
	}

	private void iniTask_Introduces(int state) {
		lisTask_Introduces.clear();
		loadData(state);
	}

	public void initTextView() {

		tvTab2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				state = 0;
				unsync_start = 0;
				unsync_limit = 10;

				iniTask_Introduces(state);
				taskAdapter = new TaskAdapter(getActivity(), lisTask_Introduces, state);
				xListView.setAdapter(taskAdapter);
			}
		});
		tvTab3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				state = 1;

				sync_start = 0;
				sync_limit = 10;
				iniTask_Introduces(state);
				taskAdapter = new TaskAdapter(getActivity(), lisTask_Introduces, state);
				xListView.setAdapter(taskAdapter);
			}
		});
	}

	private void initWidth(View parentView) {
		ivBottomLine = (ImageView) parentView.findViewById(R.id.iv_bottom_line);
		bottomLineWidth = ivBottomLine.getLayoutParams().width;
		DisplayMetrics dm = new DisplayMetrics();
		getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
		int screenW = dm.widthPixels;
		offset = (int) ((screenW / num - bottomLineWidth) / 2);
		int avg = (int) (screenW / num);
		position_one = avg + offset - 8;
		position_two = 2 * avg + offset - 18;
	}

	public class MyOnPageChangeListener implements OnPageChangeListener {

		@Override
		public void onPageSelected(int arg0) {
			Animation animation = null;
			switch (arg0) {
			case 0:
				if (currIndex == 1) {
					animation = new TranslateAnimation(position_one, offset, 0, 0);
				}
				if (currIndex == 2) {
					animation = new TranslateAnimation(position_two, offset, 0, 0);
				}
				break;
			case 1:
				if (currIndex == 0) {
					animation = new TranslateAnimation(offset, position_one, 0, 0);
				}
				if (currIndex == 2) {
					animation = new TranslateAnimation(position_two, position_one, 0, 0);
				}
				break;
			case 2:
				if (currIndex == 1) {
					animation = new TranslateAnimation(position_one, position_two, 0, 0);
				}
				if (currIndex == 0) {
					animation = new TranslateAnimation(offset, position_two, 0, 0);
				}
				break;

			default:
				break;
			}

			currIndex = arg0;
			animation.setFillAfter(true);
			animation.setDuration(30);
			ivBottomLine.startAnimation(animation);
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}

		@Override
		public void onPageScrollStateChanged(int arg0) {
		}
	}

	@Override
	public void onRefresh() {
		loadMoreData();
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
		xListView.stopRefresh();
		xListView.stopLoadMore();
		xListView.setRefreshTime("刚刚");
	}

	private void loadMoreData() {
		if (state == 0) {
			unsync_start = unsync_start + unsync_limit;
		} else if (state == 1) {
			sync_start = sync_start + sync_limit;
		}
		loadData(state);
	}

	@Override
	public void onLoadMore() {

		loadMoreData();

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
		Task_Introduce task = lisTask_Introduces.get(position - 1);
		if (task != null) {
			LocationInfo locationInfo = DataSupport.find(LocationInfo.class, task.getTask_Id());
			if (locationInfo != null) {
				int collectionType = locationInfo.getCollectionType();
				switch (collectionType) {
				case CollectType.Collection_Market_Business_House_Rent:
					intent = new Intent(getActivity(), EditCollectionMarketBusinessHouseRentActivity.class);
					intent.putExtra("locationInfo", locationInfo);
					startActivity(intent);
					break;
				case CollectType.Collection_Market_Business_House_Sell:
					intent = new Intent(getActivity(), EditCollectionMarketBusinessHouseSellActivity.class);
					intent.putExtra("locationInfo", locationInfo);
					startActivity(intent);
					break;
				case CollectType.Collection_Market_Business_Rent_Out:
					intent = new Intent(getActivity(), EditCollectionMarketBusinessRentOutActivity.class);
					intent.putExtra("locationInfo", locationInfo);
					startActivity(intent);
					break;
				case CollectType.Collection_Market_Business_Sell:
					intent = new Intent(getActivity(), EditCollectionMarketBusinessSellActivity.class);
					intent.putExtra("locationInfo", locationInfo);
					startActivity(intent);
					break;
				case CollectType.Collection_Market_Business_ShareHolder:
					intent = new Intent(getActivity(), EditCollectionMarketBusinessShareHolderActivity.class);
					intent.putExtra("locationInfo", locationInfo);
					startActivity(intent);
					break;
				case CollectType.Collection_Market_Business_Transfer:
					intent = new Intent(getActivity(), EditCollectionMarketBusinessTransferActivity.class);
					intent.putExtra("locationInfo", locationInfo);
					startActivity(intent);
					break;

				case CollectType.Collection_Market_Demand_House_Rent:
					intent = new Intent(getActivity(), EditCollectionMarketDemandHouseRentActivity.class);
					intent.putExtra("locationInfo", locationInfo);
					startActivity(intent);
					break;
				case CollectType.Collection_Market_Demand_House_Sell:
					intent = new Intent(getActivity(), EditCollectionMarketDemandHouseSellActivity.class);
					intent.putExtra("locationInfo", locationInfo);
					startActivity(intent);
					break;
				case CollectType.Collection_Market_Demand_Rent:
					intent = new Intent(getActivity(), EditCollectionMarketDemandRentActivity.class);
					intent.putExtra("locationInfo", locationInfo);
					startActivity(intent);
					break;
				case CollectType.Collection_Market_Demand_Sell:
					intent = new Intent(getActivity(), EditCollectionMarketDemandSellActivity.class);
					intent.putExtra("locationInfo", locationInfo);
					startActivity(intent);
					break;
				case CollectType.Collection_Market_Demand_ShareHolder:
					intent = new Intent(getActivity(), EditCollectionMarketDemandShareHolderActivity.class);
					intent.putExtra("locationInfo", locationInfo);
					startActivity(intent);
					break;
				case CollectType.Collection_Market_Demand_Transfer:
					intent = new Intent(getActivity(), EditCollectionMarketDemandTransferActivity.class);
					intent.putExtra("locationInfo", locationInfo);
					startActivity(intent);
					break;

				case CollectType.Collection_Market_Monitor_Land_Level:
					intent = new Intent(getActivity(), EditCollectionMarketMonitorLandLevelActivity.class);
					intent.putExtra("locationInfo", locationInfo);
					startActivity(intent);
					break;
				case CollectType.Collection_Market_Monitor_Land_Value:
					intent = new Intent(getActivity(), EditCollectionMarketMonitorLandValueActivity.class);
					intent.putExtra("locationInfo", locationInfo);
					startActivity(intent);
					break;
				case CollectType.Collection_Market_Monitor_Point:
					intent = new Intent(getActivity(), EditCollectionMarketMonitorPointActivity.class);
					intent.putExtra("locationInfo", locationInfo);
					startActivity(intent);
					break;

				case CollectType.Collection_Market_Supply_House_Rent:
					intent = new Intent(getActivity(), EditCollectionMarketSupplyHouseRentActivity.class);
					intent.putExtra("locationInfo", locationInfo);
					startActivity(intent);
					break;
				case CollectType.Collection_Market_Supply_House_Sell:
					intent = new Intent(getActivity(), EditCollectionMarketSupplyHouseSellActivity.class);
					intent.putExtra("locationInfo", locationInfo);
					startActivity(intent);
					break;
				case CollectType.Collection_Market_Supply_Rent:
					intent = new Intent(getActivity(), EditCollectionMarketSupplyRentActivity.class);
					intent.putExtra("locationInfo", locationInfo);
					startActivity(intent);
					break;
				case CollectType.Collection_Market_Supply_Sell:
					intent = new Intent(getActivity(), EditCollectionMarketSupplySellActivity.class);
					intent.putExtra("locationInfo", locationInfo);
					startActivity(intent);
					break;
				case CollectType.Collection_Market_Supply_ShareHolder:
					intent = new Intent(getActivity(), EditCollectionMarketSupplyShareHolderActivity.class);
					intent.putExtra("locationInfo", locationInfo);
					startActivity(intent);
					break;
				case CollectType.Collection_Market_Development_Township:
					intent = new Intent(getActivity(), EditCollectionMarketDevelopmentTownshipActivity.class);
					intent.putExtra("locationInfo", locationInfo);
					startActivity(intent);
					break;
				case CollectType.Collection_Market_Development_Village:
					intent = new Intent(getActivity(), EditCollectionMarketDevelopmentVillageActivity.class);
					intent.putExtra("locationInfo", locationInfo);
					startActivity(intent);
					break;
				case CollectType.Collection_Market_Redevelopment_Impose:
					intent = new Intent(getActivity(), EditCollectionMarketRedevelopmentImposeActivity.class);
					intent.putExtra("locationInfo", locationInfo);
					startActivity(intent);
					break;
				case CollectType.Collection_Market_Redevelopment_Plan:
					intent = new Intent(getActivity(), EditCollectionMarketRedevelopmentPlanActivity.class);
					intent.putExtra("locationInfo", locationInfo);
					startActivity(intent);
					break;
				case CollectType.Collection_Market_Supply_Transfer:
					intent = new Intent(getActivity(), EditCollectionMarketSupplyTransferActivity.class);
					intent.putExtra("locationInfo", locationInfo);
					startActivity(intent);
					break;
				case -1:
					break;
				default:
					intent = new Intent(getActivity(), EditCollectionMarketBusinessSellActivity.class);
					intent.putExtra("locationInfo", locationInfo);
					startActivity(intent);
					break;
				}
			}
		}
	}
}
