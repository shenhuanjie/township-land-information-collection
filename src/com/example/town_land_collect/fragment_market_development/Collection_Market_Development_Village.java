/**
 * 
 */
package com.example.town_land_collect.fragment_market_development;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.litepal.exceptions.DataSupportException;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.town_land_collect.R;
import com.example.town_land_collect.activity.MyMapActivity;
import com.example.town_land_collect.model.LocationInfo;
import com.example.town_land_collect.model.market_development.ModelCollectionMarketDevelopmentVillage;
import com.example.town_land_collect.util.CollectType;
import com.example.town_land_collect.util.ComUtil;
import com.example.town_land_collect.util.ImageUtil;
import com.example.town_land_collect.util.ToastUtil;

/**
 * @Title Collection_Market_Economic_Development_Administrative_Village.java
 * @Package com.example.town_land_collect.fragment_market_economic_development
 * @Description 行政村社会经济发展信息
 * @author Shen.dev
 * @date 2015-10-14 下午5:38:03
 * @version V1.0
 */
@SuppressLint({ "CutPasteId", "ClickableViewAccessibility" })
public class Collection_Market_Development_Village extends Fragment implements OnClickListener, OnTouchListener {
	private String imagePathString = null;
	private Integer curFragmentParent = 1;// fragment父级
	private Integer curFragmentChildren = 0;// frament子级

	/** 基础信息.控件 **/
	// private int index_qsxz = 0;// 权属性质

	// TODO:加入Index信息
	// /** 转让/受让信息 **/
	// private int index_market_business_transfer_farm_in_zrfs = 0;// 转让方式_Index

	/** 其他信息.控件 **/
	// private int index_hxwkfsp = 0;// 红线外开发水平
	// private int index_hxnkfsp = 0;// 红线内开发水平
	// private int index_tdjb = 0;// 所在土地级别

	/** 通用部分.控件 **/
	private ImageView image_photo;// 图片信息
//	private ImageButton imageButton_Location;// 选择坐标（地图）
	private ImageButton imageButton_Save;// 表单保存
	private ImageButton imageButton_Clear;// 清空表单
	private TextView textView_Tips;// 提示信息

	/** 基础信息.控件 **/
	private EditText edit_the_name;// 记录名称
	private EditText edit_the_code;// 记录代码
	// private EditText edit_tdsyz;// 土地使用者
	// private EditText edit_tdzsh;// 土地证书号
	// private EditText edit_tdzl;// 土地坐落
	// private Spinner edit_qsxz;// 权属性质

	// TODO 加入页面控件
	// /** 转让/受让信息 **/
	// private EditText edit_market_business_transfer_farm_in_zrsj;// 转让时间
	// private EditText edit_market_business_transfer_farm_in_zrf;// 转让方
	// private EditText edit_market_business_transfer_farm_in_srf;// 受让方
	// private Spinner edit_market_business_transfer_farm_in_zrfs;// 转让方式
	// private EditText edit_market_business_transfer_farm_in_tdzrnj;// 土地转让面积
	// private EditText edit_market_business_transfer_farm_in_zrqyt;// 转让前用途
	// private EditText edit_market_business_transfer_farm_in_zrhyt;// 转让后用途
	// private EditText edit_market_business_transfer_farm_in_tdsysynq;//
	// 土地剩余使用年期
	// private EditText edit_market_business_transfer_farm_in_tdzrdj;// 土地转让单价
	// private EditText edit_market_business_transfer_farm_in_tdzrzj;// 土地转让总价

	/** 其他信息.控件 **/
	// private EditText edit_rjl;// 容积率
	// private Spinner edit_hxwkfsp;// 红线外开发水平
	// private Spinner edit_hxnkfsp;// 红线内开发水平
	// private Spinner edit_tdjb;// 所在土地级别
	// private EditText edit_djqd;// 所在地价区段
	// private EditText edit_xzqdm;// 行政区代码

	// /** 位置信息.控件 **/
	// private EditText edit_x;// X坐标
	// private EditText edit_y;// Y坐标
	// private EditText edit_bjdmc;// 标记点名称
	// private EditText edit_zbxt;// 坐标系统
	// private EditText edit_remark;// 备注

	/**
	 * 标注点位置相关
	 */
	// private EditText editText_Location_Latitude;
	// private EditText editText_Location_Longtitude;
	// private EditText editText_Location_BZDMC;// 标注点名称
	// private EditText editText_Location_Mark;
	// private EditText editText_Time_ZRSJ;

	/** 全局变量 **/
	// private double lat;
//	private double lon;

	/** 基本信息.变量 **/
	private String value_the_name;// 记录名称
	private String value_the_code;// 记录代码

	// private String value_tdsyz;// 土地使用者
	// private String value_tdzsh;// 土地证书号
	// private String value_tdzl;// 土地坐落
	// private String value_qsxz;// 权属性质

	// TODO 加入控件变量
	// /** 转让/受让信息.变量 **/
	// private String market_business_transfer_farm_in_zrsj;// 转让时间
	// private String market_business_transfer_farm_in_zrf;// 转让方
	// private String market_business_transfer_farm_in_srf;// 受让方
	// private String market_business_transfer_farm_in_zrfs;// 转让方式
	// private String market_business_transfer_farm_in_tdzrnj;// 土地转让面积
	// private String market_business_transfer_farm_in_zrqyt;// 转让前用途
	// private String market_business_transfer_farm_in_zrhyt;// 转让后用途
	// private String market_business_transfer_farm_in_tdsysynq;// 土地剩余使用年期
	// private String market_business_transfer_farm_in_tdzrdj;// 土地转让单价
	// private String market_business_transfer_farm_in_tdzrzj;// 土地转让总价

	/** 其他信息 **/
	// private String value_rjl;// 容积率
	// private String value_hxwkfsp;// 红线外开发水平
	// private String value_hxnkfsp;// 红线内开发水平
	// private String value_tdjb;// 所在土地级别
	// private String value_djqd;// 所在地价区段
	// private String value_xzqdm;// 行政区代码

	// /** 位置信息.变量 **/
	// private String value_x;// X坐标
	// private String value_y;// Y坐标
	// private String value_bjdmc;// 标记点名称
	// private String value_zbxt;// 坐标系统
	// private String value_remark;// 备注

	/** Spinner Dict **/
	/** 基本信息 .Spinner **/
	// private ArrayList<String> list_qsxz = new ArrayList<String>();// 权属性质

	// TODO 定义下拉列表
	// /** 转让/受让信息 .Spinner **/
	// private ArrayList<String>
	// market_business_transfer_farm_in_zrfs_spinne_array_list = new
	// ArrayList<String>();// 转让方式

	/** 其他信息 .Spinner **/
	// private ArrayList<String> list_hxwkfsp = new ArrayList<String>();//
	// 红线外开发水平
	// private ArrayList<String> list_hxnkfsp = new ArrayList<String>();//
	// 红线内开发水平
	// private ArrayList<String> list_tdjb = new ArrayList<String>();// 所在土地级别

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = (View) inflater.inflate(R.layout.collection_market_development_village_frame, container, false);
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
		// imageButton_Location = (ImageButton)
		// view.findViewById(R.id.fragment_collection_ibtn_location);
		// imageButton_Location.setOnClickListener(this);
		imageButton_Save = (ImageButton) view.findViewById(R.id.fragment_collection_ibtn_save);
		imageButton_Clear = (ImageButton) view.findViewById(R.id.fragment_collection_ibtn_clear);
		imageButton_Clear.setOnClickListener(this);
		imageButton_Save.setOnClickListener(this);
		textView_Tips = (TextView) view.findViewById(R.id.fragment_collection_tv_tips);
		textView_Tips.setText("行政村社会经济发展信息");// TODO 修改提示信息
	}

	/**
	 * 
	 * 说明：初始化输入控件
	 * 
	 * @param view
	 * @return void
	 */
	private void initEditText(View view) {
		// editText_Time_ZRSJ = (EditText)
		// view.findViewById(R.id.transfer_farm_in_ZRSJ);
		// editText_Time_ZRSJ.setOnTouchListener(this);
		// /**
		// * 标注点位置相关
		// */
		// editText_Location_Longtitude = (EditText)
		// view.findViewById(R.id.location_info_Lon);
		// editText_Location_Latitude = (EditText)
		// view.findViewById(R.id.location_info_Lat);
		// editText_Location_BZDMC = (EditText)
		// view.findViewById(R.id.location_info_BJDMC);
		// editText_Location_Mark = (EditText)
		// view.findViewById(R.id.location_info_Mark);

		/** 基础信息 **/
		edit_the_name = (EditText) view.findViewById(R.id.edit_the_name);
		edit_the_code = (EditText) view.findViewById(R.id.edit_the_code);
		// edit_tdsyz = (EditText) view.findViewById(R.id.edit_tdsyz);
		// edit_tdzsh = (EditText) view.findViewById(R.id.edit_tdzsh);
		// edit_tdzl = (EditText) view.findViewById(R.id.edit_tdzl);
		// edit_qsxz = (Spinner) view.findViewById(R.id.edit_qsxz);

		// TODO 绑定控件
		// /** 转让/受让信息 **/
		// edit_market_business_transfer_farm_in_zrsj = (EditText)
		// view.findViewById(R.id.transfer_farm_in_ZRSJ);// 转让时间
		// edit_market_business_transfer_farm_in_zrf = (EditText)
		// view.findViewById(R.id.transfer_farm_in_ZRF);// 转让方
		// edit_market_business_transfer_farm_in_srf = (EditText)
		// view.findViewById(R.id.transfer_farm_in_SRF);// 受让方
		// edit_market_business_transfer_farm_in_zrfs = (Spinner)
		// view.findViewById(R.id.transfer_farm_in_ZRFS);// 转让方式
		// edit_market_business_transfer_farm_in_tdzrnj = (EditText)
		// view.findViewById(R.id.transfer_farm_in_TDZRMJ);// 土地转让面积
		// edit_market_business_transfer_farm_in_zrqyt = (EditText)
		// view.findViewById(R.id.transfer_farm_in_ZRQYT);// 转让前用途
		// edit_market_business_transfer_farm_in_zrhyt = (EditText)
		// view.findViewById(R.id.transfer_farm_in_ZRHYT);// 转让后用途
		// edit_market_business_transfer_farm_in_tdsysynq = (EditText)
		// view.findViewById(R.id.transfer_farm_in_TDSYSYNQ);// 土地剩余使用年期
		// edit_market_business_transfer_farm_in_tdzrdj = (EditText)
		// view.findViewById(R.id.transfer_farm_in_TDZRDJ);// 土地转让单价
		// edit_market_business_transfer_farm_in_tdzrzj = (EditText)
		// view.findViewById(R.id.transfer_farm_in_TDZRZJ);// 土地转让总价

		/** 位置信息 **/
		// edit_x = (EditText) view.findViewById(R.id.ocation_info_lon);
		// edit_y = (EditText) view.findViewById(R.id.ocation_info_lat);
		// edit_bjdmc = (EditText) view.findViewById(R.id.location_info_bjdmc);
		// edit_zbxt = (EditText) view.findViewById(R.id.location_info_zbxt);
		// edit_remark = (EditText)
		// view.findViewById(R.id.location_info_remark);
		/** 其他信息 **/
		// edit_rjl = (EditText) view.findViewById(R.id.edit_rjl);
		// edit_hxwkfsp = (Spinner) view.findViewById(R.id.edit_hxwkfsp);//
		// spinner
		// edit_hxnkfsp = (Spinner) view.findViewById(R.id.edit_hxnkfsp);//
		// spinner
		// edit_tdjb = (Spinner) view.findViewById(R.id.edit_tdjb);// spinner
		// edit_djqd = (EditText) view.findViewById(R.id.edit_djqd);
		// edit_xzqdm = (EditText) view.findViewById(R.id.edit_xzqdm);

	}

	/**
	 * 说明：初始化Spinner 字典列表
	 * 
	 * @return void
	 */
	private void initSpinnerDict() {
		// /** 权属性质 **/
		// value_qsxz = "10";
		// list_qsxz.add("10");// 国有土地所有权
		// list_qsxz.add("20");// 国有土地使用权
		// list_qsxz.add("30");// 集体土地所有权
		// list_qsxz.add("40");// 集体土地使用权
		// list_qsxz.add("31");// 村民小组
		// list_qsxz.add("32");// 村集体经济组织
		// list_qsxz.add("33");// 乡集体经济组织
		// list_qsxz.add("34");// 其他农民集体经济组织

		// TODO 构造下拉列表字典数据
		// /** 转让方式 **/
		// market_business_transfer_farm_in_zrfs = "01";
		// market_business_transfer_farm_in_zrfs_spinne_array_list.add("01");//
		// 招标
		// market_business_transfer_farm_in_zrfs_spinne_array_list.add("02");//
		// 拍卖
		// market_business_transfer_farm_in_zrfs_spinne_array_list.add("03");//
		// 挂牌
		// market_business_transfer_farm_in_zrfs_spinne_array_list.add("04");//
		// 协议

		// /** 红线外开发水平 **/
		// value_hxwkfsp = "3";
		// list_hxwkfsp.add("3");// 三通
		// list_hxwkfsp.add("4");// 四通
		// list_hxwkfsp.add("5");// 五通
		// list_hxwkfsp.add("6");// 六通
		// list_hxwkfsp.add("7");// 七通
		// list_hxwkfsp.add("8");// 八通
		// list_hxwkfsp.add("9");// 九通
		// /** 红线内开发水平 **/
		// value_hxnkfsp = "3";
		// list_hxnkfsp.add("3");// 三通一平
		// list_hxnkfsp.add("4");// 四通一平
		// list_hxnkfsp.add("5");// 五通一平
		// list_hxnkfsp.add("6");// 六通一平
		// list_hxnkfsp.add("7");// 七通一平
		// list_hxnkfsp.add("8");// 八通一平
		// list_hxnkfsp.add("9");// 九通一平
		/** 所在土地级别 **/
		// value_tdjb = "1";
		// list_tdjb.add("1");// 一级
		// list_tdjb.add("2");// 二级
		// list_tdjb.add("3");// 三级
		// list_tdjb.add("4");// 四级
		// list_tdjb.add("5");// 五级
		// list_tdjb.add("6");// 六级
		// list_tdjb.add("7");// 七级
		// list_tdjb.add("8");// 八级
		// list_tdjb.add("9");// 九级
		// list_tdjb.add("10");// 十级
		// list_tdjb.add("11");// 十一级
		// list_tdjb.add("12");// 十二级
		// list_tdjb.add("13");// 十三级
		// list_tdjb.add("14");// 十四级
		// list_tdjb.add("15");// 十五级
		// list_tdjb.add("16");// 十六级
		// list_tdjb.add("17");// 十七级
		// list_tdjb.add("18");// 十八级
		// list_tdjb.add("0");// 未评估地区
	}

	/**
	 * 说明：初始化下拉项目选择事件
	 * 
	 * 添加Spinner事件监听
	 * 
	 * @return void
	 */
	private void initOnItemSelectedListener() {

		// /** 权属性质 **/
		// edit_qsxz.setOnItemSelectedListener(new
		// Spinner.OnItemSelectedListener() {
		// @Override
		// public void onItemSelected(AdapterView<?> arg0, View arg1, int index,
		// long arg3) {
		// value_qsxz = list_qsxz.get(index);
		// index_qsxz = index;
		// }
		//
		// @Override
		// public void onNothingSelected(AdapterView<?> arg0) {
		// }
		// });

		// TODO 实现下拉列表赋值
		// /** 出让方式下拉列表 **/
		// edit_market_business_transfer_farm_in_zrfs.setOnItemSelectedListener(new
		// Spinner.OnItemSelectedListener() {
		// @Override
		// public void onItemSelected(AdapterView<?> arg0, View arg1, int index,
		// long arg3) {
		// market_business_transfer_farm_in_zrfs =
		// market_business_transfer_farm_in_zrfs_spinne_array_list
		// .get(index);
		// index_market_business_transfer_farm_in_zrfs = index;
		// }
		//
		// @Override
		// public void onNothingSelected(AdapterView<?> arg0) {
		// }
		// });

		// /** 红线外开发水平 **/
		// edit_hxwkfsp.setOnItemSelectedListener(new
		// Spinner.OnItemSelectedListener() {
		// @Override
		// public void onItemSelected(AdapterView<?> arg0, View arg1, int index,
		// long arg3) {
		// value_hxwkfsp = list_hxwkfsp.get(index);
		// index_hxwkfsp = index;
		// }
		//
		// @Override
		// public void onNothingSelected(AdapterView<?> arg0) {
		// }
		// });
		// /** 红线内开发水平 **/
		// edit_hxnkfsp.setOnItemSelectedListener(new
		// Spinner.OnItemSelectedListener() {
		// @Override
		// public void onItemSelected(AdapterView<?> arg0, View arg1, int index,
		// long arg3) {
		// value_hxnkfsp = list_hxnkfsp.get(index);
		// index_hxnkfsp = index;
		// }
		//
		// @Override
		// public void onNothingSelected(AdapterView<?> arg0) {
		// }
		// });
		/** 所在土地级别 **/
		// edit_tdjb.setOnItemSelectedListener(new
		// Spinner.OnItemSelectedListener() {
		// @Override
		// public void onItemSelected(AdapterView<?> arg0, View arg1, int index,
		// long arg3) {
		// value_tdjb = list_tdjb.get(index);
		// index_tdjb = index;
		// }
		//
		// @Override
		// public void onNothingSelected(AdapterView<?> arg0) {
		// }
		// });
	}

	@SuppressLint("SimpleDateFormat")
	@Override
	public void onClick(View arg0) {
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
		case R.id.fragment_collection_photo:
			// 1*打开相机拍照,调用系统地拍照:拍照时,将拍得的照片保存到本地(未缩小):
			Intent getImageByCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
			if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
				imageUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), "temp.jpg"));
			} else {
				imageUri = Uri.fromFile(new File(File.separator, "temp.jpg"));
			}

			// 2*指定照片保存路径(SD卡),temp.jpg为一个临时文件,每次拍照后这个图片都会被替换
			getImageByCamera.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
			startActivityForResult(getImageByCamera, ComUtil.RequestCode_Photo);
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
			if (imagePathString != null) {
				locationInfo.setImageUri(imagePathString);// 绑定图片
			}
			locationInfo.setState("任务状态：待上传");
			locationInfo.setStateCode(CollectType.State_Code_Not_Yet_Upload);// 待上传
			locationInfo.setCollectionType(CollectType.Collection_Market_Development_Village);// TODO
																								// 类型ID
			locationInfo.setCollectionMainType(CollectType.Development);// TODO
			locationInfo.setCollectionTableName(CollectType.Collection_Market_Development_Village_Tablename);// 表名
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

	/**
	 * 说明：保存控件值到变量，用于保存实体
	 * 
	 * @return void
	 */
	private void setCollectionInfo() {
		/** 基本信息.变量 **/
		value_the_name = edit_the_name.getText().toString();// 记录名称
		value_the_code = edit_the_code.getText().toString();// 记录代码
		// value_tdsyz = edit_tdsyz.getText().toString();// 土地所有者
		// value_tdzsh = edit_tdzsh.getText().toString();// 土地证书号
		// value_tdzl = edit_tdzl.getText().toString();// 土地坐落

		// TODO 构造实体数据
		// /** 出让/受让信息.变量 **/
		// if (edit_market_business_transfer_farm_in_zrsj != null
		// && edit_market_business_transfer_farm_in_zrsj.getText() != null) {
		// market_business_transfer_farm_in_zrsj =
		// edit_market_business_transfer_farm_in_zrsj.getText().toString();//
		// 转让时间
		// }
		// if (edit_market_business_transfer_farm_in_zrf != null
		// && edit_market_business_transfer_farm_in_zrf.getText() != null) {
		// market_business_transfer_farm_in_zrf =
		// edit_market_business_transfer_farm_in_zrf.getText().toString();// 转让方
		// }
		// if (edit_market_business_transfer_farm_in_srf != null
		// && edit_market_business_transfer_farm_in_srf.getText() != null) {
		// market_business_transfer_farm_in_srf =
		// edit_market_business_transfer_farm_in_srf.getText().toString();// 受让方
		// }
		// if (edit_market_business_transfer_farm_in_tdzrnj != null
		// && edit_market_business_transfer_farm_in_tdzrnj.getText() != null) {
		// market_business_transfer_farm_in_tdzrnj =
		// edit_market_business_transfer_farm_in_tdzrnj.getText().toString();//
		// 土地转让面积
		// }
		// if (edit_market_business_transfer_farm_in_zrqyt != null
		// && edit_market_business_transfer_farm_in_zrqyt.getText() != null) {
		// market_business_transfer_farm_in_zrqyt =
		// edit_market_business_transfer_farm_in_zrqyt.getText().toString();//
		// 转让前用途
		// }
		// if (edit_market_business_transfer_farm_in_zrhyt != null
		// && edit_market_business_transfer_farm_in_zrhyt.getText() != null) {
		// market_business_transfer_farm_in_zrhyt =
		// edit_market_business_transfer_farm_in_zrhyt.getText().toString();//
		// 转让后用途
		// }
		// if (edit_market_business_transfer_farm_in_tdsysynq != null
		// && edit_market_business_transfer_farm_in_tdsysynq.getText() != null)
		// {
		// market_business_transfer_farm_in_tdsysynq =
		// edit_market_business_transfer_farm_in_tdsysynq.getText()
		// .toString();// 土地剩余使用年期
		// }
		// if (edit_market_business_transfer_farm_in_tdzrdj != null
		// && edit_market_business_transfer_farm_in_tdzrdj.getText() != null) {
		// market_business_transfer_farm_in_tdzrdj =
		// edit_market_business_transfer_farm_in_tdzrdj.getText().toString();//
		// 土地转让单价
		// }
		// if (edit_market_business_transfer_farm_in_tdzrzj != null
		// && edit_market_business_transfer_farm_in_tdzrzj.getText() != null) {
		// market_business_transfer_farm_in_tdzrzj =
		// edit_market_business_transfer_farm_in_tdzrzj.getText().toString();//
		// 土地转让总价
		// }

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
		ModelCollectionMarketDevelopmentVillage model = new ModelCollectionMarketDevelopmentVillage();
		/** 基本信息 **/
		model.setTHENAME(value_the_name);// 记录名称
		model.setTHECODE(value_the_code);// 记录代码
		// model.setTDSYZ(value_tdsyz);// 土地所有者
		// model.setTDZSH(value_tdzsh);// 土地证书号
		// model.setTDZL(value_tdzl);// 土地坐落
		// model.setQSXZ(value_qsxz);// 权属性质

		// TODO 构造实体数据
		// /** 出让/受让信息 **/
		// model.setZRSJ(market_business_transfer_farm_in_zrsj);// 转让时间
		// model.setZRF(market_business_transfer_farm_in_zrf);// 转让方
		// model.setSRF(market_business_transfer_farm_in_srf);// 受让方
		// model.setZRFS(market_business_transfer_farm_in_zrfs);// 转让方式
		// model.setIndexZRFS(index_market_business_transfer_farm_in_zrfs);
		// model.setZRMJ(market_business_transfer_farm_in_tdzrnj);// 土地转让面积
		// model.setZRQYT(market_business_transfer_farm_in_zrqyt);// 转让前用途
		// model.setZRHYT(market_business_transfer_farm_in_zrhyt);// 转让后用途
		// model.setTDSYNQ(market_business_transfer_farm_in_tdsysynq);//
		// 土地剩余使用年期
		// model.setZRDJ(market_business_transfer_farm_in_tdzrdj);// 土地转让单价
		// model.setZRZJ(market_business_transfer_farm_in_tdzrzj);// 土地转让总价

		// /** 位置信息 **/
		// model.setX(value_x);// 精度
		// model.setY(value_y);// 纬度
		// model.setZBXT(value_zbxt);// 坐标系统
		// model.setREMARK(value_remark);// 备注

		/** 其他信息 **/
		// model.setRJL(value_rjl);// 宗地容积率
		// model.setHXWKFSP(value_hxwkfsp);// 红线外开发水平
		// model.setHXNKFSP(value_hxnkfsp);// 红线内开发水平
		// model.setTDJB(value_tdjb); // 所在土地级别
		// model.setDJQD(value_djqd);// 所在地价区段
		// model.setXZQDM(value_xzqdm);// 行政区代码（村级行政区）

		/** 赋值下拉字段 **/
		// model.setINDEX_QSXZ(index_qsxz);
		// model.setINDEX_HXWKFSP(index_hxwkfsp);
		// model.setINDEX_HXNKFSP(index_hxnkfsp);
		// model.setINDEX_TDJB(index_tdjb);
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

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// if (event.getAction() == MotionEvent.ACTION_DOWN) {
		//
		// AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		// View view = View.inflate(getActivity(), R.layout.dialog_date_picker,
		// null);
		// final DatePicker datePicker = (DatePicker)
		// view.findViewById(R.id.date_picker);
		// builder.setView(view);
		//
		// Calendar cal = Calendar.getInstance();
		// cal.setTimeInMillis(System.currentTimeMillis());
		// datePicker.init(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
		// cal.get(Calendar.DAY_OF_MONTH), null);
		//
		// // TODO 实现点击时间事件
		// if (v.getId() == R.id.transfer_farm_in_ZRSJ) {
		// final int inType = editText_Time_ZRSJ.getInputType();
		// editText_Time_ZRSJ.setInputType(InputType.TYPE_NULL);
		// editText_Time_ZRSJ.onTouchEvent(event);
		// editText_Time_ZRSJ.setInputType(inType);
		// editText_Time_ZRSJ.setSelection(editText_Time_ZRSJ.getText().length());
		//
		// builder.setTitle("选取出让时间");
		// builder.setPositiveButton("确  定", new
		// DialogInterface.OnClickListener() {
		//
		// @Override
		// public void onClick(DialogInterface dialog, int which) {
		//
		// StringBuffer sb = new StringBuffer();
		// sb.append(String.format("%d-%02d-%02d", datePicker.getYear(),
		// datePicker.getMonth() + 1,
		// datePicker.getDayOfMonth()));
		// sb.append("  ");
		//
		// editText_Time_ZRSJ.setText(sb);
		// editText_Time_ZRSJ.requestFocus();
		//
		// dialog.cancel();
		// }
		// });
		//
		// }
		// Dialog dialog = builder.create();
		// dialog.show();
		// }

		return true;
	}

	/**
	 * 获取返回数据
	 */
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		// TODO 应该加入 REQUEST_CODE,而不是用其他判断
		if (resultCode != Activity.RESULT_OK) {
			// result is not correct
			// return;
		}

		// 获取返回的图片内容
		if (requestCode == ComUtil.RequestCode_Photo_Value) {

			DisplayMetrics metric = new DisplayMetrics();
			getParentFragment().getActivity().getWindowManager().getDefaultDisplay().getMetrics(metric);
			int width = metric.widthPixels; // 屏幕宽度（像素）
			int height = metric.heightPixels; // 屏幕高度（像素）

			try {
				// 将保存在本地的图片取出并按比例缩小后显示在界面上
				Bitmap camorabitmap = ImageUtil.getImageThumbnail(Environment.getExternalStorageDirectory()
						+ "/temp.jpg", width, height);
				image_photo.setImageBitmap(camorabitmap);
				// TODO 保存到本地
				String newFilePath = ImageUtil.copyFile(Environment.getExternalStorageDirectory() + "/temp.jpg",
						Environment.getExternalStorageDirectory() + "/");
				imagePathString = newFilePath;

				// ImageUtil.savaPhotoToLocal(camorabitmap);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
