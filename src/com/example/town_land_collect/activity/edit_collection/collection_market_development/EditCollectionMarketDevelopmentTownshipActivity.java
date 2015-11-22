package com.example.town_land_collect.activity.edit_collection.collection_market_development;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.litepal.crud.DataSupport;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.InputType;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.town_land_collect.R;
import com.example.town_land_collect.activity.MyMapActivity;
import com.example.town_land_collect.model.LocationInfo;
import com.example.town_land_collect.model.market_development.ModelCollectionMarketDevelopmentTownship;
import com.example.town_land_collect.util.CollectType;
import com.example.town_land_collect.util.ComUtil;
import com.example.town_land_collect.util.CommonTypeUtil;
import com.example.town_land_collect.util.ImageUtil;
import com.example.town_land_collect.util.ToastUtil;

/**
 * 土地使用权出租交易信息
 * 
 * @author Eric
 * 
 */
public class EditCollectionMarketDevelopmentTownshipActivity extends ActionBarActivity implements OnClickListener, OnTouchListener {

	/** Fragment-manager **/
	private Integer curFragmentParent = 1;// fragment父级
	private Integer curFragmentChildren = 0;// frament子级

	/** 标注点位置相关 **/
	private LocationInfo locationInfo;

	/** 基础信息.控件 **/
	private int index_qsxz = 0;// 权属性质
	/** 下拉框信息 **/
	private int index_tdyt = 0;// 土地用途
	private int index_czqyt = 0;// 出租前用途
	private int index_czhyt = 0;// 出租后用途
	/** 其他信息.控件 **/
	private int index_hxwkfsp = 0;// 红线外开发水平
	private int index_hxnkfsp = 0;// 红线内开发水平
	private int index_tdjb = 0;// 所在土地级别

	/** 通用部分.控件 **/
	private ImageView image_photo;// 图片信息
	private ImageButton button_location;// 选择坐标（地图）
	private ImageButton button_save;// 表单保存
	private ImageButton button_clear;// 清空表单
	private TextView text_tips;// 提示信息

	/** 基础信息.控件 **/
	private EditText edit_the_name;// 记录名称
	private EditText edit_the_code;// 记录代码
	private EditText edit_tdsyz;// 土地所有者
	private EditText edit_tdzsh;// 土地证书号
	private EditText edit_tdzl;// 土地坐落
	private Spinner edit_qsxz;// 权属性质

	/** 位置信息.控件 **/
	private EditText edit_x;// 经度
	private EditText edit_y;// 纬度
	private EditText edit_bjdmc;// 标记点名称
	private EditText edit_zbxt;// 坐标系统
	private EditText edit_remark;// 备注

	/** 其他信息.控件 **/
	private EditText edit_rjl;// 容积率
	private Spinner edit_hxwkfsp;// 红线外开发水平
	private Spinner edit_hxnkfsp;// 红线内开发水平
	private Spinner edit_tdjb;// 所在土地级别
	private EditText edit_djqd;// 所在地址区段
	private EditText edit_xzqdm;// 行政区代码

	/**
	 * 土地出租信息
	 */
	private EditText edit_chuzf;// 出租方
	private EditText edit_chengzf;// 承租方
	private EditText edit_czsj;// 出租时间
	private EditText edit_zq;// 租期
	private EditText edit_czmj;// 土地出租面积
	private Spinner edit_czqyt;// 出租前用途
	private Spinner edit_czhyt;// 出租后用途
	private EditText edit_tdsynq;// 土地剩余使用年期
	private EditText edit_nzj;// 年租金
	private EditText edit_yj;// 押金
	private EditText edit_sf;// 税费

	/** 全局变量 **/
	private double lat;
	private double lon;

	/** 基本信息.变量 **/
	private String value_the_name;// 记录名称
	private String value_the_code;// 记录代码
	private String value_tdsyz;// 土地使用者
	private String value_tdzsh;// 土地证书号
	private String value_tdzl;// 土地坐落
	private String value_qsxz;// 权属性质

	private String value_chuzf;
	private String value_chengzf;
	private String value_czsj;
	private String value_zq;
	private String value_czmj;
	private String value_czqyt;
	private String value_czhyt;
	private String value_tdsynq;
	private String value_nzj;
	private String value_yj;
	private String value_sf;

	/** 其他信息 **/
	private String value_rjl;// 容积率
	private String value_hxwkfsp;// 红线外开发水平
	private String value_hxnkfsp;// 红线内开发水平
	private String value_tdjb;// 所在土地级别
	private String value_djqd;// 所在地价区段
	private String value_xzqdm;// 行政区代码

	/** 位置信息.变量 **/
	private String value_x;// X坐标
	private String value_y;// Y坐标
	private String value_bjdmc;// 标记点名称
	private String value_zbxt;// 坐标系统
	private String value_remark;// 备注

	/** Spinner Dict **/
	/** 基本信息 .Spinner **/
	private ArrayList<String> list_qsxz = new ArrayList<String>();// 权属性质

	// TODO 定义下拉列表
	/** 出售信息 .Spinner **/
	private ArrayList<String> list_tdyt = new ArrayList<String>();// 土地用途
	private ArrayList<String> list_jzlx = new ArrayList<String>();// 建筑类型
	private ArrayList<String> list_fwjg = new ArrayList<String>();// 房屋结构
	private ArrayList<String> list_fwcxd = new ArrayList<String>();// 房屋成新度
	private ArrayList<String> list_zxcd = new ArrayList<String>();// 装修程度
	private ArrayList<String> list_csyt = new ArrayList<String>();// 出售用途

	/** 其他信息 .Spinner **/
	private ArrayList<String> list_hxwkfsp = new ArrayList<String>();// 红线外开发水平
	private ArrayList<String> list_hxnkfsp = new ArrayList<String>();// 红线内开发水平
	private ArrayList<String> list_tdjb = new ArrayList<String>();// 所在土地级别

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.collection_market_development_township_frame_detail);
		/** 初始化控件 **/
		initView();
		initEditText();
		/** 初始化变量 **/
		initLayout();
		initModel();
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
	}

	private void initLayout() {
		Intent intent = getIntent();
		if (intent != null) {
			locationInfo = (LocationInfo) intent.getSerializableExtra("locationInfo");
			if (locationInfo != null) {
				// edit_bjdmc.setText(locationInfo.getName());
				// edit_x.setText(locationInfo.getLon() + "");
				// edit_y.setText(locationInfo.getLat() + "");
				// edit_remark.setText(locationInfo.getMark());
				lon = Double.valueOf(locationInfo.getLon());
				lat = Double.valueOf(locationInfo.getLat());
				// 显示绑定图片
				if (locationInfo.getImageUri() != null) {
					DisplayMetrics metric = new DisplayMetrics();
					getWindowManager().getDefaultDisplay().getMetrics(metric);
					int width = metric.widthPixels; // 屏幕宽度（像素）
					int height = metric.heightPixels; // 屏幕高度（像素）
					Bitmap camorabitmap = ImageUtil.getImageThumbnail(locationInfo.getImageUri(), width, height);
					image_photo.setImageBitmap(camorabitmap);
				}
			}
		}
	}

	/**
	 * 
	 * 说明：初始化视图
	 * 
	 * @param view
	 * @return void
	 */
	private void initView() {
		/** 通用部分 **/
		image_photo = (ImageView) findViewById(R.id.fragment_collection_photo);
		image_photo.setOnClickListener(this);
		// button_location = (ImageButton)
		// findViewById(R.id.fragment_collection_ibtn_location);
		// button_location.setOnClickListener(this);
		button_save = (ImageButton) findViewById(R.id.fragment_collection_ibtn_save);
		button_clear = (ImageButton) findViewById(R.id.fragment_collection_ibtn_clear);
		button_clear.setOnClickListener(this);
		button_save.setOnClickListener(this);
		text_tips = (TextView) findViewById(R.id.fragment_collection_tv_tips);
		text_tips.setText("乡镇社会经济发展信息");// TODO 修改提示信息
	}

	/**
	 * 说明：初始化实体显示
	 * 
	 * @return void
	 */
	private void initModel() {
		ModelCollectionMarketDevelopmentTownship model = DataSupport.find(ModelCollectionMarketDevelopmentTownship.class, locationInfo.getCollectionId());
		if (model != null) {
			/** 基本信息 **/
			edit_the_name.setText(model.getTHENAME());// 记录名称
			edit_the_code.setText(model.getTHECODE());// 记录代码
			// edit_tdsyz.setText(model.getTDSYZ());// 土地所有者
			// edit_tdzsh.setText(model.getTDZSH());// 土地证书号
			// edit_tdzl.setText(model.getTDZL());// 土地坐落
			// edit_qsxz.setSelection(model.getINDEX_QSXZ());// 权属性质
			// edit_chuzf.setText(model.getCHUZF()); // 出租方
			// edit_chengzf.setText(model.getCHENGZF()); // 承租方
			// edit_czsj.setText(model.getCZSJ()); // 出租时间
			// edit_zq.setText(model.getZQ());// 租期
			// edit_czmj.setText(model.getCZMJ()); // 出租面积
			// edit_czqyt.setSelection(model.getINDEX_CZQYT());// 出租前用途
			// edit_czhyt.setSelection(model.getINDEX_CZHYT());// 出租后用途

			/** 位置信息.控件 **/
			// edit_x.setText(model.getX());// 经度
			// edit_y.setText(model.getY());// 纬度
			// edit_bjdmc.setText(model.getTHENAME());// 标记点名称
			// edit_zbxt.setText(model.getZBXT());// 坐标系统
			// edit_remark.setText(model.getREMARK());// 备注
			/** 其他信息.控件 **/
			// edit_rjl.setText(model.getRJL());// 容积率
			// edit_hxwkfsp.setSelection(model.getINDEX_HXWKFSP());// 红线外开发水平
			// edit_hxnkfsp.setSelection(model.getINDEX_HXNKFSP());// 红线内开发水平
			// edit_tdjb.setSelection(model.getINDEX_TDJB());// 所在土地级别
			// edit_djqd.setText(model.getDJQD());// 所在地址区段
			// edit_xzqdm.setText(model.getXZQDM());// 行政区代码
		}
	}

	/**
	 * 
	 * 说明：初始化输入控件
	 * 
	 * @param view
	 * @return void
	 */
	private void initEditText() {
		/** 基础信息 **/
		edit_the_name = (EditText) findViewById(R.id.edit_the_name);
		edit_the_code = (EditText) findViewById(R.id.edit_the_code);
		edit_tdsyz = (EditText) findViewById(R.id.edit_tdsyz);
		edit_tdzsh = (EditText) findViewById(R.id.edit_tdzsh);
		edit_tdzl = (EditText) findViewById(R.id.edit_tdzl);
		edit_qsxz = (Spinner) findViewById(R.id.edit_qsxz);// Spinner

		edit_sf = (EditText) findViewById(R.id.edit_sf);// 税费

		/** 位置信息 **/
		edit_x = (EditText) findViewById(R.id.location_info_lon);
		edit_y = (EditText) findViewById(R.id.location_info_lat);
		edit_bjdmc = (EditText) findViewById(R.id.location_info_bjdmc);
		edit_zbxt = (EditText) findViewById(R.id.location_info_zbxt);
		edit_remark = (EditText) findViewById(R.id.location_info_remark);
		/** 其他信息 **/
		edit_rjl = (EditText) findViewById(R.id.edit_rjl);
		edit_hxwkfsp = (Spinner) findViewById(R.id.edit_hxwkfsp);// spinner
		edit_hxnkfsp = (Spinner) findViewById(R.id.edit_hxnkfsp);// spinner
		edit_tdjb = (Spinner) findViewById(R.id.edit_tdjb);// spinner
		edit_djqd = (EditText) findViewById(R.id.edit_djqd);
		edit_xzqdm = (EditText) findViewById(R.id.edit_xzqdm);

		/** 绑定触控事件 **/
		// edit_czsj.setOnTouchListener(this);
	}

	/**
	 * 说明：初始化Spinner 字典列表
	 * 
	 * @return void
	 */
	private void initSpinnerDict() {
		CommonTypeUtil typeUtil = new CommonTypeUtil();

		list_qsxz = typeUtil.initList("qsxz");// 权属性质
		list_tdyt = typeUtil.initList("tdyt");// 土地用途
		list_jzlx = typeUtil.initList("jzlx");// 建筑类型
		list_fwjg = typeUtil.initList("fwjg");// 房屋结构
		list_fwcxd = typeUtil.initList("fwcxd");// 房屋成新度
		list_zxcd = typeUtil.initList("zxcd");// 装修程度
		list_csyt = typeUtil.initList("ytlx");// 出租用途
		list_hxwkfsp = typeUtil.initList("hxwkfsp");// 红线外开发水平
		list_hxnkfsp = typeUtil.initList("hxnkfsp");// 红线内开发水平
		list_tdjb = typeUtil.initList("tdjb");// 所在土地级别

		value_qsxz = list_qsxz.get(0);
		value_hxwkfsp = list_hxwkfsp.get(0);
		value_hxnkfsp = list_hxnkfsp.get(0);
		value_tdjb = list_tdjb.get(0);

	}

	/**
	 * 说明：初始化下拉项目选择事件
	 * 
	 * 添加Spinner事件监听
	 * 
	 * @return void
	 */
	private void initOnItemSelectedListener() {

		/** 权属性质 **/
		edit_qsxz.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_qsxz = list_qsxz.get(index);
				index_qsxz = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		/** 出租前用途 **/
		edit_czqyt.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_czqyt = list_tdyt.get(index);
				index_tdyt = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		/** 出租后用途 **/
		edit_czhyt.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_czhyt = list_tdyt.get(index);
				index_tdyt = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});

		/** 红线外开发水平 **/
		edit_hxwkfsp.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_hxwkfsp = list_hxwkfsp.get(index);
				index_hxwkfsp = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		/** 红线内开发水平 **/
		edit_hxnkfsp.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_hxnkfsp = list_hxnkfsp.get(index);
				index_hxnkfsp = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		/** 所在土地级别 **/
		edit_tdjb.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_tdjb = list_tdjb.get(index);
				index_tdjb = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
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
		case R.id.action_delete_record:
			LocationInfo model = DataSupport.find(LocationInfo.class, locationInfo.getCollectionId());
			model.delete();
			Toast.makeText(this, "记录删除成功", Toast.LENGTH_SHORT).show();
			this.finish();
			return true;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN) {

			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			View view = View.inflate(this, R.layout.dialog_date_picker, null);
			final DatePicker datePicker = (DatePicker) view.findViewById(R.id.date_picker);
			builder.setView(view);

			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(System.currentTimeMillis());
			datePicker.init(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), null);

			/** 出租时间 **/
			if (v.getId() == R.id.edit_czsj) {
				final int inType = edit_czsj.getInputType();
				edit_czsj.setInputType(InputType.TYPE_NULL);
				edit_czsj.onTouchEvent(event);
				edit_czsj.setInputType(inType);
				edit_czsj.setSelection(edit_czsj.getText().length());

				builder.setTitle("选取出租时间");
				builder.setPositiveButton("确  定", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

						StringBuffer sb = new StringBuffer();
						sb.append(String.format("%d-%02d-%02d", datePicker.getYear(), datePicker.getMonth() + 1, datePicker.getDayOfMonth()));
						sb.append("  ");

						edit_czsj.setText(sb);
						edit_czsj.requestFocus();

						dialog.cancel();
					}
				});
			}

			Dialog dialog = builder.create();
			dialog.show();
		}
		return true;
	}

	@Override
	public void onClick(View arg0) {
		int id = arg0.getId();
		switch (id) {
		case R.id.fragment_collection_ibtn_location:
			// 打开地图位置选择
			Intent intent = new Intent(this, MyMapActivity.class);
			LocationInfo locationInfo = new LocationInfo();
			locationInfo.setLat(lat);
			locationInfo.setLon(lon);
			locationInfo.setName(edit_the_name.getText().toString());
			locationInfo.setMark(edit_remark.getText().toString());
			intent.putExtra("curFragmentParent", curFragmentParent);
			intent.putExtra("curFragmentChildren", curFragmentChildren);
			intent.putExtra("rCode", 1);
			intent.putExtra("locationInfo", locationInfo);
			startActivityForResult(intent, ComUtil.RequestCode_Map);
			break;
		case R.id.fragment_collection_photo:
			// TODO 打开相机拍照 未实现
			// Intent getImageByCamera = new
			// Intent(MediaStore.ACTION_IMAGE_CAPTURE);
			// startActivityForResult(getImageByCamera,
			// ComUtil.RequestCode_Photo);
			break;
		case R.id.fragment_collection_ibtn_save:
			// 表单信息的本地存储
			if (edit_x.getText().toString().equals("") || edit_y.getText().toString().equals("")) {
				ToastUtil.ToastStr(this, "请补充完整经纬度信息", 2000);
			} else {
				locationInfo = new LocationInfo();
				locationInfo.setLat(lat);
				locationInfo.setLon(lon);
				locationInfo.setName(edit_the_name.getText().toString());
				locationInfo.setMark(edit_remark.getText().toString());
				try {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");// 设置日期格式
					locationInfo.setDate("创建时间：" + df.format(new Date()));
				} catch (Exception e) {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
					locationInfo.setDate("创建时间：" + df.format(new Date()));
					e.printStackTrace();
				}
				locationInfo.setState("任务状态：待上传");
				locationInfo.setStateCode(CollectType.State_Code_Not_Yet_Upload);// 待上传
				locationInfo.setCollectionType(CollectType.Collection_Market_Development_Township);// TODO
																									// 存储的实体类型
				/*
				 * int collectionId = saveCollectionInfo(); if (collectionId !=
				 * 0) { locationInfo.setCollectionId(collectionId); try {
				 * locationInfo.update(locationInfo.getId());// 利用LogCat捕捉异常信息
				 * ToastUtil.ToastStr(this, "更新成功", 2000); } catch
				 * (DataSupportException e) { Log.d("TAG", e.toString());
				 * ToastUtil.ToastStr(this, e.toString(), 2000);
				 * ToastUtil.ToastStr(this, "更新失败", 2000); } } else {
				 * ToastUtil.ToastStr(this, "更新失败", 2000); }
				 */
			}
			break;
		// 清空表单
		case R.id.fragment_collection_ibtn_clear:
			break;
		}
	}
}
