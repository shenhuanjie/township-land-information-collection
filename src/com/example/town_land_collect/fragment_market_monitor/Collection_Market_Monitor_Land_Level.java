package com.example.town_land_collect.fragment_market_monitor;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.litepal.exceptions.DataSupportException;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.town_land_collect.R;
import com.example.town_land_collect.activity.MyMapActivity;
import com.example.town_land_collect.model.LocationInfo;
import com.example.town_land_collect.model.market_monitor.ModelCollectionMarketMonitorLandLevel;
import com.example.town_land_collect.util.AttachmentUtil;
import com.example.town_land_collect.util.CollectType;
import com.example.town_land_collect.util.ComUtil;
import com.example.town_land_collect.util.CommonTypeUtil;
import com.example.town_land_collect.util.ImageUtil;
import com.example.town_land_collect.util.ToastUtil;

/**
 * 
 * @Title Collection_Market_Monitor_Land_Level.java
 * @Package com.example.town_land_collect.fragment_market_monitor
 * @Description 土地级别信息
 * @author Shen.dev
 * @date 2015-10-14 下午5:18:42
 * @version V1.0
 */
@SuppressLint("CutPasteId")
public class Collection_Market_Monitor_Land_Level extends Fragment implements OnClickListener, OnTouchListener {
	private String imagePathString = null;
	// TODO 图片相关
	private final String IMAGE_TYPE = "image/*";
	private final int IMAGE_CODE = 0; // 这里的IMAGE_CODE是自己任意定义的
	private List<String> imagePathList = new ArrayList<String>();
	private int imagePathListIndex = 0;
	private Bitmap camorabitmap = null;
	private Button image_left;// 图片上一张
	private Button image_right;// 图片下一张
	// TODO
	private TextView text_page;
	private TextView text_total;
	private Integer curFragmentParent = 1;// fragment父级
	private Integer curFragmentChildren = 0;// frament子级

	/** 土地级别信息 **/
	private int index_qsxz = 0;// 权属性质
	private int index_tdjb = 0;// 土地级别
	private int index_sdkfsp = 0;// 设定开发水平

	/** 通用部分.控件 **/
	private ImageView image_photo;// 图片信息
	// private ImageButton imageButton_Location;// 选择坐标（地图）
	private ImageButton imageButton_Save;// 表单保存
	private ImageButton imageButton_Clear;// 清空表单
	private TextView textView_Tips;// 提示信息

	/** 基础信息.控件 **/
	private EditText edit_the_name;// 记录名称
	private EditText edit_the_code;// 记录代码
	/** 土地级别信息 **/
	private EditText edit_bsm;// 标识码
	private EditText edit_xzqdm;// 行政区代码
	private Spinner edit_qsxz;// 权属性质
	private Spinner edit_tdjb;// 土地级别
	private EditText edit_jzr;// 评估基准日
	private EditText edit_sdql;// 设定权利状况
	private EditText edit_sdnq;// 设定年期
	private EditText edit_sdrjl;// 设定容积率
	private Spinner edit_sdkfsp;// 设定开发水平
	private EditText edit_dmjzdj;// 地面基准地价
	private EditText edit_lmjzdj;// 楼面基准地价
	private EditText edit_remark;// 备注

	// /** 位置信息.控件 **/
	// private EditText edit_x;// X坐标
	// private EditText edit_y;// Y坐标
	// private EditText edit_bjdmc;// 标记点名称
	// private EditText edit_zbxt;// 坐标系统
	// private EditText edit_remark;// 备注

	/** 全局变量 **/
	// private double lat;
	// private double lon;

	/** 基本信息.变量 **/
	private String value_the_name;// 记录名称
	private String value_the_code;// 记录代码

	/** 土地级别信息 **/
	private String value_bsm;// 标识码
	private String value_xzqdm;// 行政区代码
	private String value_qsxz;// 权属性质
	private String value_tdjb;// 土地级别
	private String value_jzr;// 评估基准日
	private String value_sdql;// 设定权利状况
	private String value_sdnq;// 设定年期
	private String value_sdrjl;// 设定容积率
	private String value_sdkfsp;// 设定开发水平
	private String value_dmjzdj;// 地面基准地价
	private String value_lmjzdj;// 楼面基准地价
	private String value_remark;// 备注

	// /** 位置信息.变量 **/
	// private String value_x;// X坐标
	// private String value_y;// Y坐标
	// private String value_bjdmc;// 标记点名称
	// private String value_zbxt;// 坐标系统
	// private String value_remark;// 备注

	/** Spinner Dict **/
	/** 土地级别信息 **/
	private ArrayList<String> list_qsxz = new ArrayList<String>();// 权属性质
	private ArrayList<String> list_tdjb = new ArrayList<String>();// 土地级别
	private ArrayList<String> list_sdkfsp = new ArrayList<String>();// 设定开发水平

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = (View) inflater.inflate(R.layout.collection_market_monitor_land_level_frame, container, false);
		initView(view);
		initEditText(view);
		initSpinnerDict();
		initOnItemSelectedListener();
		return view;
	}

	/**
	 * 
	 * 说明：初始化视图
	 * 
	 * @param view
	 * @return void
	 */
	private void initView(View view) {
		image_photo = (ImageView) view.findViewById(R.id.fragment_collection_photo);
		image_photo.setOnClickListener(this);
		// TODO 图片选择按钮控件
		image_left = (Button) view.findViewById(R.id.fragment_collection_left);
		image_left.setOnClickListener(this);
		image_right = (Button) view.findViewById(R.id.fragment_collection_right);
		image_right.setOnClickListener(this);
		// TODO
		text_page = (TextView) view.findViewById(R.id.textViewPage);
		text_total = (TextView) view.findViewById(R.id.textViewTotal);

		// imageButton_Location = (ImageButton)
		// view.findViewById(R.id.fragment_collection_ibtn_location);
		// imageButton_Location.setOnClickListener(this);
		imageButton_Save = (ImageButton) view.findViewById(R.id.fragment_collection_ibtn_save);
		imageButton_Clear = (ImageButton) view.findViewById(R.id.fragment_collection_ibtn_clear);
		imageButton_Clear.setOnClickListener(this);
		imageButton_Save.setOnClickListener(this);
		textView_Tips = (TextView) view.findViewById(R.id.fragment_collection_tv_tips);
		textView_Tips.setText("土地级别信息");
	}

	/**
	 * 
	 * 说明：初始化输入控件
	 * 
	 * @param view
	 * @return void
	 */
	private void initEditText(View view) {

		/** 基础信息 **/
		edit_the_name = (EditText) view.findViewById(R.id.edit_the_name);
		edit_the_code = (EditText) view.findViewById(R.id.edit_the_code);
		/** 土地级别信息 **/
		edit_bsm = (EditText) view.findViewById(R.id.edit_bsm);// 标识码
		edit_xzqdm = (EditText) view.findViewById(R.id.edit_xzqdm);// 行政区代码
		edit_qsxz = (Spinner) view.findViewById(R.id.edit_qsxz);// 权属性质
		edit_tdjb = (Spinner) view.findViewById(R.id.edit_tdjb);// 土地级别
		edit_jzr = (EditText) view.findViewById(R.id.edit_jzr);// 评估基准日
		edit_sdql = (EditText) view.findViewById(R.id.edit_sdql);// 设定权利状况
		edit_sdnq = (EditText) view.findViewById(R.id.edit_sdnq);// 设定年期
		edit_sdrjl = (EditText) view.findViewById(R.id.edit_sdrjl);// 设定容积率
		edit_sdkfsp = (Spinner) view.findViewById(R.id.edit_sdkfsp);// 设定开发水平
		edit_dmjzdj = (EditText) view.findViewById(R.id.edit_dmjzdj);// 地面基准地价
		edit_lmjzdj = (EditText) view.findViewById(R.id.edit_lmjzdj);// 楼面基准地价
		edit_remark = (EditText) view.findViewById(R.id.edit_remark);// 备注

		/** 位置信息 **/
		// edit_x = (EditText) view.findViewById(R.id.ocation_info_lon);
		// edit_y = (EditText) view.findViewById(R.id.ocation_info_lat);
		// edit_bjdmc = (EditText) view.findViewById(R.id.location_info_bjdmc);
		// edit_zbxt = (EditText) view.findViewById(R.id.location_info_zbxt);
		// edit_remark = (EditText)
		// view.findViewById(R.id.location_info_remark);
		edit_jzr.setOnTouchListener(this);
	}

	/**
	 * 说明：初始化Spinner 字典列表
	 * 
	 * @return void
	 */
	private void initSpinnerDict() {
		CommonTypeUtil typeUtil = new CommonTypeUtil();
		list_qsxz = typeUtil.initList("qsxz");// 权属性质
		list_tdjb = typeUtil.initList("tdjb");// 土地级别
		list_sdkfsp = typeUtil.initList("hxwkfsp");// 设定开发水平

		value_qsxz = list_qsxz.get(0);
		value_tdjb = list_tdjb.get(0);
		value_sdkfsp = list_sdkfsp.get(0);
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
		edit_sdkfsp.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_sdkfsp = list_sdkfsp.get(index);
				index_sdkfsp = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}

		});
	}

	@SuppressLint("SimpleDateFormat")
	@Override
	public void onClick(View arg0) {
		// TODO
		// 获取屏幕参数
		DisplayMetrics metric = new DisplayMetrics();
		getParentFragment().getActivity().getWindowManager().getDefaultDisplay().getMetrics(metric);
		int width = metric.widthPixels; // 屏幕宽度（像素）
		int height = metric.heightPixels; // 屏幕高度（像素）

		int id = arg0.getId();
		Uri imageUri = null;
		switch (id) {
		case R.id.fragment_collection_ibtn_location:
			// 打开地图位置选择
			Intent intent = new Intent(getActivity(), MyMapActivity.class);
			LocationInfo locationInfo = null;
			intent.putExtra("curFragmentParent", curFragmentParent);
			intent.putExtra("curFragmentChildren", curFragmentChildren);
			intent.putExtra("rCode", 1);
			startActivityForResult(intent, ComUtil.RequestCode_Map);
			break;
		// TODO 图片相关控件
		case R.id.fragment_collection_photo:
			getPhotoImage();
			break;
		case R.id.fragment_collection_left:
			getPhotoLeft(width, height);
			break;
		case R.id.fragment_collection_right:
			getPhotoRight(width, height);
			break;

		case R.id.fragment_collection_ibtn_save:
			// 表单信息的本地存储
			locationInfo = new LocationInfo();
			locationInfo.setName(edit_the_name.getText().toString());
			try {
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");// 设置日期格式
				locationInfo.setDate("创建时间：" + df.format(new Date()));
			} catch (Exception e) {
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
				locationInfo.setDate("创建时间：" + df.format(new Date()));
				e.printStackTrace();
			}
			// TODO
			if (imagePathList != null && imagePathList.size() != 0) {
				StringBuffer sb = new StringBuffer();
				for (String item : imagePathList) {
					sb.append(item);
					sb.append(",");
				}
				imagePathString = sb.toString();
				locationInfo.setImageUri(imagePathString);
			}
			locationInfo.setState("任务状态：待上传");
			locationInfo.setStateCode(CollectType.State_Code_Not_Yet_Upload);// 待上传
			locationInfo.setCollectionType(CollectType.Collection_Market_Monitor_Land_Level);
			// 类型ID
			locationInfo.setCollectionMainType(CollectType.Monitor);
			locationInfo.setCollectionTableName(CollectType.Collection_Market_Monitor_Land_Level_Tablename);// 表名
			// 存储的实体类型
			int collectionId = saveCollectionInfo();
			if (collectionId != 0) {
				locationInfo.setCollectionId(collectionId);
				try {
					locationInfo.saveThrows();// 利用LogCat捕捉异常信息
				} catch (DataSupportException e) {
					Log.d("TAG", e.toString());
					ToastUtil.ToastStr(getActivity(), e.toString(), 2000);
				}
				if (locationInfo.save()) {
					ToastUtil.ToastStr(getActivity(), "存储成功", 2000);
					// 保存关联附件信息
					AttachmentUtil attachmentUtil = new AttachmentUtil();
					attachmentUtil.saveAttachmentInfo(locationInfo);
				} else {
					ToastUtil.ToastStr(getActivity(), "存储失败", 2000);
				}
			} else {
				ToastUtil.ToastStr(getActivity(), "存储失败", 2000);
			}
			break;
		// 清空表单
		case R.id.fragment_collection_ibtn_clear:
			break;
		}
	}

	// TODO 处理函数
	private void getPhotoRight(int width, int height) {
		if (imagePathList.size() != 0) {
			if (imagePathListIndex != imagePathList.size() - 1) {
				// 先判断是否已经回收
				if (camorabitmap != null && !camorabitmap.isRecycled()) {
					camorabitmap.recycle();
					camorabitmap = null;
				}
				imagePathListIndex = imagePathListIndex + 1;
				String filePath = imagePathList.get(imagePathListIndex);
				camorabitmap = ImageUtil.getImageThumbnail(filePath, width, height);
				image_photo.setImageBitmap(camorabitmap);// TODO
				text_page.setText("第" + (imagePathListIndex + 1) + "张");
				text_total.setText(",共" + imagePathList.size() + "张");
			}
		}
	}

	private void getPhotoLeft(int width, int height) {
		if (imagePathList.size() != 0) {
			if (imagePathListIndex != 0) {
				// 先判断是否已经回收
				if (camorabitmap != null && !camorabitmap.isRecycled()) {
					camorabitmap.recycle();
					camorabitmap = null;
				}
				imagePathListIndex = imagePathListIndex - 1;
				String filePath = imagePathList.get(imagePathListIndex);
				camorabitmap = ImageUtil.getImageThumbnail(filePath, width, height);
				image_photo.setImageBitmap(camorabitmap);// TODO
				text_page.setText("第" + (imagePathListIndex + 1) + "张");
				text_total.setText(",共" + imagePathList.size() + "张");
			}
		}
	}

	private void getPhotoImage() {
		String[] items = { "拍照", "选择图片", "删除" };
		new AlertDialog.Builder(getActivity()).setTitle("选择操作").setItems(items, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Uri imageUri = null;
				if (which == 0) {
					Intent getImageByCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
					if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
						imageUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), "temp.jpg"));
					} else {
						imageUri = Uri.fromFile(new File(File.separator, "temp.jpg"));
					}
					getImageByCamera.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
					startActivityForResult(getImageByCamera, ComUtil.RequestCode_Photo);
				} else if (which == 1) {
					// 使用intent调用系统提供的相册功能，使用startActivityForResult是为了获取用户选择的图片
					Intent getAlbum = new Intent(Intent.ACTION_GET_CONTENT);
					getAlbum.setType(IMAGE_TYPE);
					startActivityForResult(getAlbum, IMAGE_CODE);
				} else if (which == 2) {
					DisplayMetrics metric = new DisplayMetrics();
					getParentFragment().getActivity().getWindowManager().getDefaultDisplay().getMetrics(metric);
					int width = metric.widthPixels; // 屏幕宽度（像素）
					int height = metric.heightPixels; // 屏幕高度（像素）
					if (imagePathList.size() != 0) {
						// 先判断是否已经回收
						if (camorabitmap != null && !camorabitmap.isRecycled()) {
							camorabitmap.recycle();
							camorabitmap = null;
						}
						imagePathList.remove(imagePathListIndex);
						if (imagePathList.size() != 0) {
							imagePathListIndex = imagePathList.size() - 1;
							String filePath = imagePathList.get(imagePathListIndex);
							camorabitmap = ImageUtil.getImageThumbnail(filePath, width, height);
							image_photo.setImageBitmap(camorabitmap);
						} else {
							image_photo.setImageDrawable(getResources().getDrawable(R.drawable.nophoto));
						}// TODO
						text_page.setText("第" + (imagePathListIndex + 1) + "张");
						text_total.setText(",共" + imagePathList.size() + "张");
					}
				}
			}
		}).show();
	}

	/**
	 * 说明：保存控件值到变量，用于保存实体
	 * 
	 * @return void
	 */
	private void setCollectionInfo() {
		/** 基本信息.变量 **/
		value_the_name = edit_the_name.getText().toString();// 记录名称
		value_the_code = edit_the_code.getText().toString();// 记录代码
		/** 土地级别信息 **/
		value_bsm = edit_bsm.getText().toString();// 标识码
		value_xzqdm = edit_xzqdm.getText().toString();// 行政区代码
		value_jzr = edit_jzr.getText().toString();// 评估基准日
		value_sdql = edit_sdql.getText().toString();// 设定权利状况
		value_sdnq = edit_sdnq.getText().toString();// 设定年期
		value_sdrjl = edit_sdrjl.getText().toString();// 设定容积率
		value_dmjzdj = edit_dmjzdj.getText().toString();// 地面基准地价
		value_lmjzdj = edit_lmjzdj.getText().toString();// 楼面基准地价
		value_remark = edit_remark.getText().toString();// 备注

		/** 位置信息.变量 **/
		// value_x = edit_x.getText().toString();// 经度
		// value_y = edit_y.getText().toString();// 纬度
		// value_bjdmc = edit_bjdmc.getText().toString();// 标记点名称
		// value_zbxt = edit_zbxt.getText().toString();// 坐标系统
		// value_remark = edit_remark.getText().toString();// 备注
		/** 其他信息 **/
		// value_rjl = edit_rjl.getText().toString();// 容积率
		// value_djqd = edit_djqd.getText().toString();// 所在地价区段
		// value_xzqdm = edit_xzqdm.getText().toString();// 行政区代码（村级行政区）
	}

	/**
	 * 说明：保存采集信息到分表
	 * 
	 * @return id
	 */
	private int saveCollectionInfo() {
		int result = 0;
		setCollectionInfo();
		ModelCollectionMarketMonitorLandLevel model = new ModelCollectionMarketMonitorLandLevel();
		/** 基本信息 **/
		model.setTHENAME(value_the_name);// 记录名称
		model.setTHECODE(value_the_code);// 记录代码
		/** 土地级别信息 **/
		model.setBSM(value_bsm);// 标识码
		model.setXZQDM(value_xzqdm);// 行政区代码
		model.setQSXZ(value_qsxz);// 权属性质
		model.setTDJB(value_tdjb);// 土地级别
		model.setJZR(value_jzr);// 评估基准日
		model.setSDQL(value_sdql);// 设定权利状况
		model.setSDNQ(value_sdnq);// 设定年期
		model.setSDRJL(value_sdrjl);// 设定容积率
		model.setSDKFSP(value_sdkfsp);// 设定开发水平
		model.setDMJZDJ(value_dmjzdj);// 地面基准地价
		model.setLMJZDJ(value_lmjzdj);// 楼面基准地价
		model.setREMARK(value_remark);// 备注

		// /** 位置信息 **/
		// model.setX(value_x);// 精度
		// model.setY(value_y);// 纬度
		// model.setZBXT(value_zbxt);// 坐标系统
		// model.setREMARK(value_remark);// 备注

		/** 赋值下拉字段 **/
		/** 土地级别信息 **/
		model.setIndex_qsxz(index_qsxz);// 权属性质
		model.setIndex_tdjb(index_tdjb);// 土地级别
		model.setIndex_sdkfsp(index_sdkfsp);// 设定开发水平
		try {
			model.saveThrows();
		} catch (DataSupportException e) {
			Log.d("TAG", e.toString());
			ToastUtil.ToastStr(getActivity(), e.toString(), 2000);
		}
		if (model.save()) {
			result = model.getID();
		}
		return result;
	}

	@SuppressLint("ClickableViewAccessibility")
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN) {

			AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
			View view = View.inflate(getActivity(), R.layout.dialog_date_picker, null);
			final DatePicker datePicker = (DatePicker) view.findViewById(R.id.date_picker);
			builder.setView(view);

			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(System.currentTimeMillis());
			datePicker.init(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), null);

			if (v.getId() == R.id.edit_jzr) {
				final int inType = edit_jzr.getInputType();
				edit_jzr.setInputType(InputType.TYPE_NULL);
				edit_jzr.onTouchEvent(event);
				edit_jzr.setInputType(inType);
				edit_jzr.setSelection(edit_jzr.getText().length());

				builder.setTitle("选取时间");
				builder.setPositiveButton("确  定", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

						StringBuffer sb = new StringBuffer();
						sb.append(String.format("%d-%02d-%02d", datePicker.getYear(), datePicker.getMonth() + 1, datePicker.getDayOfMonth()));
						sb.append("  00:00:00");

						edit_jzr.setText(sb);
						edit_jzr.requestFocus();

						dialog.cancel();
					}
				});

			}
			Dialog dialog = builder.create();
			dialog.show();
		}

		return true;
	}

	/**
	 * 获取返回数据
	 */
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (resultCode != Activity.RESULT_OK) {
			// result is not correct
			// return;
		}

		// TODO
		// 获取返回的图片内容
		if (requestCode == ComUtil.RequestCode_Photo_Value) {

			DisplayMetrics metric = new DisplayMetrics();
			getParentFragment().getActivity().getWindowManager().getDefaultDisplay().getMetrics(metric);
			int width = metric.widthPixels; // 屏幕宽度（像素）
			int height = metric.heightPixels; // 屏幕高度（像素）

			try {
				// 先判断是否已经回收
				if (camorabitmap != null && !camorabitmap.isRecycled()) {
					camorabitmap.recycle();
					camorabitmap = null;
				}
				// 将保存在本地的图片取出并按比例缩小后显示在界面上
				camorabitmap = ImageUtil.getImageThumbnail(Environment.getExternalStorageDirectory() + "/temp.jpg", width, height);
				image_photo.setImageBitmap(camorabitmap);
				String filePath = ImageUtil.copyFile(Environment.getExternalStorageDirectory() + "/temp.jpg",
						Environment.getExternalStorageDirectory() + "/");
				imagePathList.add(filePath);
				imagePathListIndex = imagePathList.size() - 1;// TODO
				text_page.setText("第" + (imagePathListIndex + 1) + "张");
				text_total.setText(",共" + imagePathList.size() + "张");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (requestCode == ComUtil.RequestCode_Album) {
			DisplayMetrics metric = new DisplayMetrics();
			getParentFragment().getActivity().getWindowManager().getDefaultDisplay().getMetrics(metric);
			int width = metric.widthPixels; // 屏幕宽度（像素）
			int height = metric.heightPixels; // 屏幕高度（像素）
			try {
				// 先判断是否已经回收
				if (camorabitmap != null && !camorabitmap.isRecycled()) {
					camorabitmap.recycle();
					camorabitmap = null;
				}
				Uri originalUri = data.getData(); // 获得图片的uri
				String filePath = ImageUtil.getImageAbsolutePath(getActivity(), originalUri);
				// 将保存在本地的图片取出并按比例缩小后显示在界面上
				camorabitmap = ImageUtil.getImageThumbnail(filePath, width, height);
				image_photo.setImageBitmap(camorabitmap);
				imagePathList.add(filePath);
				imagePathListIndex = imagePathList.size() - 1;// TODO
				text_page.setText("第" + (imagePathListIndex + 1) + "张");
				text_total.setText(",共" + imagePathList.size() + "张");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
