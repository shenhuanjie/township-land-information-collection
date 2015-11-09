package com.example.town_land_collect.fragment;

import java.util.ArrayList;
import java.util.List;

import org.litepal.crud.DataSupport;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.example.town_land_collect.R;
import com.example.town_land_collect.activity.NewContentActivity;
import com.example.town_land_collect.adapter.NewAdapter;
import com.example.town_land_collect.model.LocationInfo;
import com.example.town_land_collect.model.New_Introduce;
import com.example.town_land_collect.view.XListView;
import com.example.town_land_collect.view.XListView.IXListViewListener;

public class IndexFragment extends Fragment implements IXListViewListener,
		OnItemClickListener {
	private XListView xListView;
	private NewAdapter adapter;
	private List<New_Introduce> newsList = new ArrayList<New_Introduce>();
	private Handler mHandler;
	private List<LocationInfo> locationInfos; // 上传信息
	private int start = 0;
	private int limit = 10;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = LayoutInflater.from(getActivity()).inflate(
				R.layout.fragment_index, null);
		xListView = (XListView) view
				.findViewById(R.id.fragment_index_xlistview);
		newsList = initData();
		adapter = new NewAdapter(getActivity(), newsList);
		xListView.setAdapter(adapter);
		xListView.setOnItemClickListener(this);
		xListView.setPullLoadEnable(true);
		xListView.setXListViewListener(this);
		mHandler = new Handler();
		return view;
	}

	private List<New_Introduce> getPageList() {
		// Records in descending order
		locationInfos = DataSupport.offset(start).limit(limit).order("date desc").find(LocationInfo.class);

		for (LocationInfo locationInfo : locationInfos) {
			New_Introduce new_Introduce = new New_Introduce();
			new_Introduce.setTheName(locationInfo.getName());
			if (locationInfo.getStateCode() == 0) {
				new_Introduce.setActive("未同步");
			} else {
				new_Introduce.setActive("已同步");
			}
			new_Introduce.setCreateTime(locationInfo.getDate());
			newsList.add(new_Introduce);
		}
		return newsList;
	}

	private List<New_Introduce> initData() {
		newsList.clear();
		return getPageList();
	}

	private List<New_Introduce> addMoreData() {
		start = start + limit;
		return getPageList();
	}

	@Override
	public void onRefresh() {

		newsList = addMoreData();

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
	public void onLoadMore() {

		newsList = addMoreData();

		mHandler.postDelayed(new Runnable() {
			@Override
			public void run() {
				adapter.notifyDataSetChanged();
				onLoad();
			}
		}, 2000);
	}

	private void onLoad() {
		xListView.stopRefresh();
		xListView.stopLoadMore();
		xListView.setRefreshTime("刚刚");
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Intent intent = new Intent(getActivity(), NewContentActivity.class);
		Bundle bundle = new Bundle();
		bundle.putSerializable("news", newsList.get(position - 1));
		intent.putExtra("bundle", bundle);
		startActivity(intent);
	}
}
