package com.example.town_land_collect.fragment;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;

import com.example.town_land_collect.R;
import com.example.town_land_collect.adapter.ExpandableAdapter;
import com.example.town_land_collect.fragment_market_business.Collection_Market_Business_House_Rent;
import com.example.town_land_collect.fragment_market_business.Collection_Market_Business_House_Sell;
import com.example.town_land_collect.fragment_market_business.Collection_Market_Business_Rent_Out;
import com.example.town_land_collect.fragment_market_business.Collection_Market_Business_Sell;
import com.example.town_land_collect.fragment_market_business.Collection_Market_Business_ShareHolder;
import com.example.town_land_collect.fragment_market_business.Collection_Market_Business_Transfer;
import com.example.town_land_collect.fragment_market_demand.Collection_Market_Demand_House_Rent;
import com.example.town_land_collect.fragment_market_demand.Collection_Market_Demand_House_Sell;
import com.example.town_land_collect.fragment_market_demand.Collection_Market_Demand_Rent;
import com.example.town_land_collect.fragment_market_demand.Collection_Market_Demand_Sell;
import com.example.town_land_collect.fragment_market_demand.Collection_Market_Demand_ShareHolder;
import com.example.town_land_collect.fragment_market_demand.Collection_Market_Demand_Transfer;
import com.example.town_land_collect.fragment_market_development.Collection_Market_Development_Township;
import com.example.town_land_collect.fragment_market_development.Collection_Market_Development_Village;
import com.example.town_land_collect.fragment_market_monitor.Collection_Market_Monitor_Land_Level;
import com.example.town_land_collect.fragment_market_monitor.Collection_Market_Monitor_Land_Value;
import com.example.town_land_collect.fragment_market_monitor.Collection_Market_Monitor_Point;
import com.example.town_land_collect.fragment_market_redevelopment.Collection_Market_Redevelopment_Impose;
import com.example.town_land_collect.fragment_market_redevelopment.Collection_Market_Redevelopment_Plan;
import com.example.town_land_collect.fragment_market_supply.Collection_Market_Supply_House_Rent;
import com.example.town_land_collect.fragment_market_supply.Collection_Market_Supply_House_Sell;
import com.example.town_land_collect.fragment_market_supply.Collection_Market_Supply_Rent;
import com.example.town_land_collect.fragment_market_supply.Collection_Market_Supply_Sell;
import com.example.town_land_collect.fragment_market_supply.Collection_Market_Supply_ShareHolder;
import com.example.town_land_collect.fragment_market_supply.Collection_Market_Supply_Transfer;
import com.example.town_land_collect.util.ComUtil;
import com.example.town_land_collect.view.CustomExpandableListView;

public class CollectionFragment extends Fragment implements OnClickListener, OnChildClickListener {
	public FragmentTransaction mFragmentTransaction;
	public FragmentManager fragmentManager;
	public List<Fragment> fragmentList;
	public Fragment fragment;
	public Integer curFragmentParent = 0;
	public Integer curFragmentChildren = 0;

	private List<String> groupArray;
	private List<List<String>> childArray;

	private ImageButton imageButton_Expand;

	private ExpandableAdapter mAdapter;

	private LinearLayout layout;
	private CustomExpandableListView expandableListView;
	private RelativeLayout relativeLayout_Expand;
	private View mMainView;

	private Collection_Market_Business_Sell collection_Market_Business_Sell;
	private Collection_Market_Business_Transfer collection_Market_Business_Transfer;
	private Collection_Market_Business_Rent_Out collection_Market_Business_Rent_Out;
	private Collection_Market_Business_ShareHolder collection_Market_Business_ShareHolder;
	private Collection_Market_Business_House_Sell collection_Marker_Business_House_Sell;
	private Collection_Market_Business_House_Rent collection_Market_Business_House_Rent;

	private Collection_Market_Supply_Transfer collection_Market_Supply_Transfer;
	private Collection_Market_Supply_House_Rent collection_Market_Supply_House_Rent;
	private Collection_Market_Supply_House_Sell collection_Market_Supply_House_Sell;
	private Collection_Market_Supply_Rent collection_Market_Supply_Rent;
	private Collection_Market_Supply_Sell collection_Market_Supply_Sell;
	private Collection_Market_Supply_ShareHolder collection_Market_Supply_ShareHolder;

	private Collection_Market_Demand_Transfer collection_Market_Demand_Transfer;
	private Collection_Market_Demand_House_Rent collection_Market_Demand_House_Rent;
	private Collection_Market_Demand_House_Sell collection_Market_Demand_House_Sell;
	private Collection_Market_Demand_Rent collection_Market_Demand_Rent;
	private Collection_Market_Demand_Sell collection_Market_Demand_Sell;
	private Collection_Market_Demand_ShareHolder collection_Market_Demand_ShareHolder;

	private Collection_Market_Monitor_Land_Level collection_Market_Monitor_Land_Level;
	private Collection_Market_Monitor_Land_Value collection_Market_Monitor_Land_Value;
	private Collection_Market_Monitor_Point collection_Market_Monitor_Point;

	private Collection_Market_Development_Township collection_Market_Development_Township;
	private Collection_Market_Development_Village collection_Market_Development_Village;

	private Collection_Market_Redevelopment_Impose collection_Market_Redevelopment_Impose;
	private Collection_Market_Redevelopment_Plan collection_Market_Redevelopment_Plan;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		mMainView = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_collection, null);
		initLayout(mMainView);
		setDefaultFragment();
		return mMainView;
	}

	private void initLayout(View view) {
		layout = (LinearLayout) view.findViewById(R.id.fragment_collection_ll_expand);
		expandableListView = (CustomExpandableListView) view.findViewById(R.id.fragment_collection_elv1);
		initListView();
		initButton(view);
		mAdapter = new ExpandableAdapter(getActivity(), groupArray, childArray);
		expandableListView.setAdapter(mAdapter);
		setListViewHeightBasedOnChildren(expandableListView);
		expandableListView.setOnChildClickListener(this);
		relativeLayout_Expand = (RelativeLayout) view.findViewById(R.id.fragment_collection_rl_expand);
		relativeLayout_Expand.setTag(2);
		relativeLayout_Expand.setOnClickListener(this);
	}

	private void initButton(View view) {
		imageButton_Expand = (ImageButton) view.findViewById(R.id.fragment_collection_ibtn_expand);
		imageButton_Expand.setTag(2);
		imageButton_Expand.setOnClickListener(this);
	}

	public static void setListViewHeightBasedOnChildren(CustomExpandableListView listView) {
		// 获取ListView对应的Adapter
		ListAdapter listAdapter = listView.getAdapter();
		if (listAdapter == null) {
			return;
		}

		int totalHeight = 0;
		for (int i = 0, len = listAdapter.getCount(); i < len; i++) { // listAdapter.getCount()返回数据项的数目
			View listItem = listAdapter.getView(i, null, listView);
			listItem.measure(0, 0); // 计算子项View 的宽高
			totalHeight += listItem.getMeasuredHeight(); // 统计所有子项的总高度
		}

		ViewGroup.LayoutParams params = listView.getLayoutParams();
		params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
		// listView.getDividerHeight()获取子项间分隔符占用的高度
		// params.height最后得到整个ListView完整显示需要的高度
		listView.setLayoutParams(params);
	}

	private void initListView() {
		groupArray = new ArrayList<String>();
		childArray = new ArrayList<List<String>>();
		groupArray.add("建设用地市场交易信息");
		groupArray.add("建设用地市场供应信息");
		groupArray.add("建设用地市场需求信息");
		groupArray.add("建设用地市场监测信息");
		groupArray.add("建设用地再开发项目信息");
		// groupArray.add("社会经济发展信息");

		List<String> tempArray = new ArrayList<String>();
		tempArray.add("土地使用权出让交易信息");
		tempArray.add("土地使用权转让交易信息");
		tempArray.add("土地使用权出租交易信息");
		tempArray.add("土地联营入股交易信息");
		tempArray.add("房地出租交易信息");
		tempArray.add("房地出售交易信息");
		childArray.add(tempArray);

		tempArray = new ArrayList<String>();
		tempArray.add("土地使用权出让供应信息");
		tempArray.add("土地使用权转让供应信息");
		tempArray.add("土地使用权出租供应信息");
		tempArray.add("土地联营入股供应信息");
		tempArray.add("房地出租供应信息");
		tempArray.add("房地出售供应信息");
		childArray.add(tempArray);

		tempArray = new ArrayList<String>();
		tempArray.add("土地使用权出让需求信息");
		tempArray.add("土地使用权转让需求信息");
		tempArray.add("土地使用权出租需求信息");
		tempArray.add("土地联营入股需求信息");
		tempArray.add("房地出租需求信息");
		tempArray.add("房地出售需求信息");
		childArray.add(tempArray);

		tempArray = new ArrayList<String>();
		tempArray.add("土地市场监测点信息");
		tempArray.add("土地级别信息");
		tempArray.add("土地区段信息");
		childArray.add(tempArray);

		tempArray = new ArrayList<String>();
		tempArray.add("再开发实施项目信息");
		tempArray.add("再开发计划项目信息");
		childArray.add(tempArray);

		// tempArray = new ArrayList<String>();
		// tempArray.add("行政村社会经济发展信息");
		// tempArray.add("乡镇社会经济发展信息");
		childArray.add(tempArray);
	}

	@SuppressLint("SimpleDateFormat")
	@Override
	public void onClick(View arg0) {
		int id = arg0.getId();
		switch (id) {
		case R.id.fragment_collection_rl_expand:
			int tag = (Integer) relativeLayout_Expand.getTag();
			if (tag > 1) {
				layout.setVisibility(View.VISIBLE);
				relativeLayout_Expand.setTag(1);
				imageButton_Expand.setBackgroundResource(R.drawable.arrow_up);
			} else {
				layout.setVisibility(View.GONE);
				relativeLayout_Expand.setTag(2);
				imageButton_Expand.setBackgroundResource(R.drawable.arrow_down);
			}
			break;
		case R.id.fragment_collection_ibtn_expand:
			tag = (Integer) imageButton_Expand.getTag();
			if (tag > 1) {
				layout.setVisibility(View.VISIBLE);
				imageButton_Expand.setTag(1);
				imageButton_Expand.setBackgroundResource(R.drawable.arrow_up);
			} else {
				layout.setVisibility(View.GONE);
				imageButton_Expand.setTag(2);
				imageButton_Expand.setBackgroundResource(R.drawable.arrow_down);
			}
			break;

		default:
			break;
		}

	}

	/**
	 * 
	 * 说明：收起选项卡
	 * 
	 * @param
	 * @return void
	 */
	private void hideFragmentCollectionRlExpand() {
		layout.setVisibility(View.GONE);
		relativeLayout_Expand.setTag(2);
		imageButton_Expand.setBackgroundResource(R.drawable.arrow_down);
	}

	/**
	 * 
	 * 说明：设置默认Fragment
	 * 
	 * @param
	 * @return void
	 */
	private void setDefaultFragment() {
		FragmentManager fm = getChildFragmentManager();
		FragmentTransaction transaction = fm.beginTransaction();
		collection_Market_Business_Sell = new Collection_Market_Business_Sell();
		transaction.replace(R.id.fragment_collection_tab, collection_Market_Business_Sell);
		transaction.commit();
	}

	@Override
	public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
		FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
		try {
			switch (groupPosition) {
			case 0:
				switch (childPosition) {
				case 0:
					if (collection_Market_Business_Sell == null) {
						collection_Market_Business_Sell = new Collection_Market_Business_Sell();// 土地使用权出让交易信息
					}
					transaction.replace(R.id.fragment_collection_tab, collection_Market_Business_Sell);
					transaction.commit();
					hideFragmentCollectionRlExpand();
					break;
				case 1:
					if (collection_Market_Business_Transfer == null) {
						collection_Market_Business_Transfer = new Collection_Market_Business_Transfer();
					}
					transaction.replace(R.id.fragment_collection_tab, collection_Market_Business_Transfer);
					transaction.commit();
					hideFragmentCollectionRlExpand();
					break;
				case 2:
					if (collection_Market_Business_Rent_Out == null) {
						collection_Market_Business_Rent_Out = new Collection_Market_Business_Rent_Out();
					}
					transaction.replace(R.id.fragment_collection_tab, collection_Market_Business_Rent_Out);
					transaction.commit();
					hideFragmentCollectionRlExpand();
					break;
				case 3:
					if (collection_Market_Business_ShareHolder == null) {
						collection_Market_Business_ShareHolder = new Collection_Market_Business_ShareHolder();
					}
					transaction.replace(R.id.fragment_collection_tab, collection_Market_Business_ShareHolder);
					transaction.commit();
					hideFragmentCollectionRlExpand();
					break;
				case 4:
					if (collection_Market_Business_House_Rent == null) {
						collection_Market_Business_House_Rent = new Collection_Market_Business_House_Rent();
					}
					transaction.replace(R.id.fragment_collection_tab, collection_Market_Business_House_Rent);
					transaction.commit();
					hideFragmentCollectionRlExpand();
					break;
				case 5:
					if (collection_Marker_Business_House_Sell == null) {
						collection_Marker_Business_House_Sell = new Collection_Market_Business_House_Sell();
					}
					transaction.replace(R.id.fragment_collection_tab, collection_Marker_Business_House_Sell);
					transaction.commit();
					hideFragmentCollectionRlExpand();
					break;
				default:
					break;
				}
				break;

			case 1:
				switch (childPosition) {
				case 0:
					if (collection_Market_Supply_Sell == null) {
						collection_Market_Supply_Sell = new Collection_Market_Supply_Sell();
					}
					transaction.replace(R.id.fragment_collection_tab, collection_Market_Supply_Sell);
					transaction.commit();
					hideFragmentCollectionRlExpand();
					break;
				case 1:
					if (collection_Market_Supply_Transfer == null) {
						collection_Market_Supply_Transfer = new Collection_Market_Supply_Transfer();
					}
					transaction.replace(R.id.fragment_collection_tab, collection_Market_Supply_Transfer);
					transaction.commit();
					hideFragmentCollectionRlExpand();
					break;
				case 2:
					if (collection_Market_Supply_Rent == null) {
						collection_Market_Supply_Rent = new Collection_Market_Supply_Rent();
					}
					transaction.replace(R.id.fragment_collection_tab, collection_Market_Supply_Rent);
					transaction.commit();
					hideFragmentCollectionRlExpand();
					break;
				case 3:
					if (collection_Market_Supply_ShareHolder == null) {
						collection_Market_Supply_ShareHolder = new Collection_Market_Supply_ShareHolder();
					}
					transaction.replace(R.id.fragment_collection_tab, collection_Market_Supply_ShareHolder);
					transaction.commit();
					hideFragmentCollectionRlExpand();
					break;
				case 4:
					if (collection_Market_Supply_House_Rent == null) {
						collection_Market_Supply_House_Rent = new Collection_Market_Supply_House_Rent();
					}
					transaction.replace(R.id.fragment_collection_tab, collection_Market_Supply_House_Rent);
					transaction.commit();
					hideFragmentCollectionRlExpand();
					break;
				case 5:
					if (collection_Market_Supply_House_Sell == null) {
						collection_Market_Supply_House_Sell = new Collection_Market_Supply_House_Sell();
					}
					transaction.replace(R.id.fragment_collection_tab, collection_Market_Supply_House_Sell);
					transaction.commit();
					hideFragmentCollectionRlExpand();
					break;
				default:
					break;
				}
				break;
			case 2:
				switch (childPosition) {
				case 0:
					if (collection_Market_Demand_Sell == null) {
						collection_Market_Demand_Sell = new Collection_Market_Demand_Sell();
					}
					transaction.replace(R.id.fragment_collection_tab, collection_Market_Demand_Sell);
					transaction.commit();
					hideFragmentCollectionRlExpand();
					break;
				case 1:
					if (collection_Market_Demand_Transfer == null) {
						collection_Market_Demand_Transfer = new Collection_Market_Demand_Transfer();
					}
					transaction.replace(R.id.fragment_collection_tab, collection_Market_Demand_Transfer);
					transaction.commit();
					hideFragmentCollectionRlExpand();
					break;
				case 2:
					if (collection_Market_Demand_Rent == null) {
						collection_Market_Demand_Rent = new Collection_Market_Demand_Rent();
					}
					transaction.replace(R.id.fragment_collection_tab, collection_Market_Demand_Rent);
					transaction.commit();
					hideFragmentCollectionRlExpand();
					break;
				case 3:
					if (collection_Market_Demand_ShareHolder == null) {
						collection_Market_Demand_ShareHolder = new Collection_Market_Demand_ShareHolder();
					}
					transaction.replace(R.id.fragment_collection_tab, collection_Market_Demand_ShareHolder);
					transaction.commit();
					hideFragmentCollectionRlExpand();
					break;
				case 4:
					if (collection_Market_Demand_House_Rent == null) {
						collection_Market_Demand_House_Rent = new Collection_Market_Demand_House_Rent();
					}
					transaction.replace(R.id.fragment_collection_tab, collection_Market_Demand_House_Rent);
					transaction.commit();
					hideFragmentCollectionRlExpand();
					break;
				case 5:
					if (collection_Market_Demand_House_Sell == null) {
						collection_Market_Demand_House_Sell = new Collection_Market_Demand_House_Sell();
					}
					transaction.replace(R.id.fragment_collection_tab, collection_Market_Demand_House_Sell);
					transaction.commit();
					hideFragmentCollectionRlExpand();
					break;
				default:
					break;
				}
				break;
			case 3:
				switch (childPosition) {
				case 0:
					if (collection_Market_Monitor_Point == null) {
						collection_Market_Monitor_Point = new Collection_Market_Monitor_Point();
					}
					transaction.replace(R.id.fragment_collection_tab, collection_Market_Monitor_Point);
					transaction.commit();
					hideFragmentCollectionRlExpand();
					break;

				case 1:
					if (collection_Market_Monitor_Land_Level == null) {
						collection_Market_Monitor_Land_Level = new Collection_Market_Monitor_Land_Level();
					}
					transaction.replace(R.id.fragment_collection_tab, collection_Market_Monitor_Land_Level);
					transaction.commit();
					hideFragmentCollectionRlExpand();
					break;
				case 2:
					if (collection_Market_Monitor_Land_Value == null) {
						collection_Market_Monitor_Land_Value = new Collection_Market_Monitor_Land_Value();
					}
					transaction.replace(R.id.fragment_collection_tab, collection_Market_Monitor_Land_Value);
					transaction.commit();
					hideFragmentCollectionRlExpand();
					break;
				default:
					break;
				}
				break;
			case 4:
				switch (childPosition) {
				case 0:
					if (collection_Market_Redevelopment_Impose == null) {
						collection_Market_Redevelopment_Impose = new Collection_Market_Redevelopment_Impose();
					}
					transaction.replace(R.id.fragment_collection_tab, collection_Market_Redevelopment_Impose);
					transaction.commit();
					hideFragmentCollectionRlExpand();
					break;

				case 1:
					if (collection_Market_Redevelopment_Plan == null) {
						collection_Market_Redevelopment_Plan = new Collection_Market_Redevelopment_Plan();
					}
					transaction.replace(R.id.fragment_collection_tab, collection_Market_Redevelopment_Plan);
					transaction.commit();
					hideFragmentCollectionRlExpand();
					break;
				default:
					break;
				}
				break;
			case 5:
				switch (childPosition) {
				case 0:
					if (collection_Market_Development_Village == null) {
						collection_Market_Development_Village = new Collection_Market_Development_Village();
					}
					transaction.replace(R.id.fragment_collection_tab, collection_Market_Development_Village);
					transaction.commit();
					hideFragmentCollectionRlExpand();
					break;

				case 1:
					if (collection_Market_Development_Township == null) {
						collection_Market_Development_Township = new Collection_Market_Development_Township();
					}
					transaction.replace(R.id.fragment_collection_tab, collection_Market_Development_Township);
					transaction.commit();
					hideFragmentCollectionRlExpand();
					break;
				default:
					break;
				}
				break;

			default:
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (data != null) {
			curFragmentChildren = data.getIntExtra("curFragmentChildren", 0);
		}
		fragmentManager = getChildFragmentManager();
		/* 在这里，我们通过碎片管理器中的Tag，就是每个碎片的名称，来获取对应的fragment */
		fragmentList = fragmentManager.getFragments();
		fragment = fragmentList.get(curFragmentChildren);
		/* 然后在碎片中调用重写的onActivityResult方法 */
		fragment.onActivityResult(requestCode, resultCode, data);
	}
}
