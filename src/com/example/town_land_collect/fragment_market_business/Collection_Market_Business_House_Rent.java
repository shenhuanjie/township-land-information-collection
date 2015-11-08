package com.example.town_land_collect.fragment_market_business;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.litepal.crud.DataSupport;
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
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
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
import android.widget.Toast;

import com.example.town_land_collect.R;
import com.example.town_land_collect.activity.MyMapActivity;
import com.example.town_land_collect.model.AttachmentEntity;
import com.example.town_land_collect.model.LocationInfo;
import com.example.town_land_collect.model.market_business.ModelCollectionMarketBusinessHouseRent;
import com.example.town_land_collect.util.AttachmentUtil;
import com.example.town_land_collect.util.CollectType;
import com.example.town_land_collect.util.ComUtil;
import com.example.town_land_collect.util.CommonTypeUtil;
import com.example.town_land_collect.util.ImageUtil;
import com.example.town_land_collect.util.ToastUtil;

/**
 * 
 * @Title Collection_Market_Business_House_Rent.java
 * @Package com.example.town_land_collect.fragment_market_business
 * @Description 房地出租交易信息
 * @author Shen.dev
 * @date 2015-10-14 下午4:56:37
 * @version V1.0
 */
@SuppressLint({ "CutPasteId", "ClickableViewAccessibility" })
public class Collection_Market_Business_House_Rent extends Fragment implements OnClickListener, OnTouchListener {
	private String imagePathString = null;

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

	/** Fragment-manager **/
	private Integer curFragmentParent = 1;// fragment父级
	private Integer curFragmentChildren = 0;// frament子级

	/** 基础信息.控件 **/
	private int index_qsxz = 0;// 权属性质

	/** 转让/受让信息 **/
	private int index_tdyt = 0;// 土地用途
	private int index_jzlx = 0;// 建筑类型
	private int index_fwjg = 0;// 房屋结构
	private int index_fwcxd = 0;// 房屋成新度
	private int index_zxcd = 0;// 装修程度
	private int index_czyt = 0;// 出租用途
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
	private EditText edit_tdsyz;// 土地使用者
	private EditText edit_tdzsh;// 土地证书号
	private EditText edit_tdzl;// 土地坐落
	private Spinner edit_qsxz;// 权属性质

	// /** 转让/受让信息 **/
	private EditText edit_fwsyqr;// 房屋所有权人
	private Spinner edit_tdyt;// 土地用途
	private EditText edit_ljkd;// 临街宽度
	private EditText edit_ljsd;// 临街深度
	private Spinner edit_jzlx;// 建筑类型
	private EditText edit_jzcs;// 建筑层数
	private Spinner edit_fwjg;// 房屋结构
	private EditText edit_jgsj;// 竣工时间
	private Spinner edit_fwcxd;// 房屋成新度
	private EditText edit_zxsj;// 装修时间
	private Spinner edit_zxcd;// 装修程度
	private EditText edit_czlc;// 出租楼层
	private Spinner edit_czyt;// 出租用途
	private EditText edit_czmj;// 出租建筑面积
	private EditText edit_czsj;// 出租时间
	private EditText edit_zq;// 租期(年)
	private EditText edit_nzj;// 年租金
	private EditText edit_yj;// 押金
	private EditText edit_sf;// 税费

	/** 其他信息.控件 **/
	private EditText edit_rjl;// 容积率
	private Spinner edit_hxwkfsp;// 红线外开发水平
	private Spinner edit_hxnkfsp;// 红线内开发水平
	private Spinner edit_tdjb;// 所在土地级别
	private EditText edit_djqd;// 所在地价区段
	private EditText edit_xzqdm;// 行政区代码

	/** 位置信息.控件 **/
	private EditText edit_x;// X坐标
	private EditText edit_y;// Y坐标
	// private EditText edit_bjdmc;// 标记点名称
	private EditText edit_zbxt;// 坐标系统
	private EditText edit_remark;// 备注

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

	// /** 转让/受让信息.变量 **/
	private String value_fwsyqr;// 房屋所有权人
	private String value_tdyt;// 土地用途
	private String value_ljkd;// 临街宽度
	private String value_ljsd;// 临街深度
	private String value_jzlx;// 建筑类型
	private String value_jzcs;// 建筑层数
	private String value_fwjg;// 房屋结构
	private String value_jgsj;// 竣工时间
	private String value_fwcxd;// 房屋成新度
	private String value_zxsj;// 装修时间
	private String value_zxcd;// 装修程度
	private String value_czlc;// 出租楼层
	private String value_czyt;// 出租用途
	private String value_czmj;// 出租建筑面积
	private String value_czsj;// 出租时间
	private String value_zq;// 租期(年)
	private String value_nzj;// 年租金
	private String value_yj;// 押金
	private String value_sf;// 税费

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
	// private String value_bjdmc;// 标记点名称
	private String value_zbxt;// 坐标系统
	private String value_remark;// 备注

	/** Spinner Dict **/
	/** 基本信息 .Spinner **/
	private ArrayList<String> list_qsxz = new ArrayList<String>();// 权属性质

	/** 转让/受让信息 .Spinner **/
	private ArrayList<String> list_tdyt = new ArrayList<String>();// 土地用途
	private ArrayList<String> list_jzlx = new ArrayList<String>();// 建筑类型
	private ArrayList<String> list_fwjg = new ArrayList<String>();// 房屋结构
	private ArrayList<String> list_fwcxd = new ArrayList<String>();// 房屋成新度
	private ArrayList<String> list_zxcd = new ArrayList<String>();// 装修程度
	private ArrayList<String> list_czyt = new ArrayList<String>();// 出租用途

	/** 其他信息 .Spinner **/
	private ArrayList<String> list_hxwkfsp = new ArrayList<String>();// 红线外开发水平
	private ArrayList<String> list_hxnkfsp = new ArrayList<String>();// 红线内开发水平
	private ArrayList<String> list_tdjb = new ArrayList<String>();// 所在土地级别

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = (View) inflater.inflate(R.layout.collection_market_business_house_rent_frame, container, false);
		initView(view);
		initEditText(view);
		initSpinnerDict();
		initOnItemSelectedListener();
		initTextChangedListener();
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
		image_left = (Button) view.findViewById(R.id.fragment_collection_left);
		image_left.setOnClickListener(this);
		image_right = (Button) view.findViewById(R.id.fragment_collection_right);
		image_right.setOnClickListener(this);
		// TODO
		text_page = (TextView) view.findViewById(R.id.textViewPage);
		text_total = (TextView) view.findViewById(R.id.textViewTotal);

		button_location = (ImageButton) view.findViewById(R.id.fragment_collection_ibtn_location);
		button_location.setOnClickListener(this);
		button_save = (ImageButton) view.findViewById(R.id.fragment_collection_ibtn_save);
		button_clear = (ImageButton) view.findViewById(R.id.fragment_collection_ibtn_clear);
		button_clear.setOnClickListener(this);
		button_save.setOnClickListener(this);
		text_tips = (TextView) view.findViewById(R.id.fragment_collection_tv_tips);
		text_tips.setText("房地出租交易信息");
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
		edit_tdsyz = (EditText) view.findViewById(R.id.edit_tdsyz);
		edit_tdzsh = (EditText) view.findViewById(R.id.edit_tdzsh);
		edit_tdzl = (EditText) view.findViewById(R.id.edit_tdzl);
		edit_qsxz = (Spinner) view.findViewById(R.id.edit_qsxz);

		/** 转让/受让信息 **/
		edit_fwsyqr = (EditText) view.findViewById(R.id.edit_fwsyqr);// 房屋所有权人
		edit_tdyt = (Spinner) view.findViewById(R.id.edit_tdyt);// 土地用途
		edit_ljkd = (EditText) view.findViewById(R.id.edit_ljkd);// 临街宽度
		edit_ljsd = (EditText) view.findViewById(R.id.edit_ljsd);// 临街深度
		edit_jzlx = (Spinner) view.findViewById(R.id.edit_jzlx);// 建筑类型
		edit_jzcs = (EditText) view.findViewById(R.id.edit_jzcs);// 建筑层数
		edit_fwjg = (Spinner) view.findViewById(R.id.edit_fwjg);// 房屋结构
		edit_jgsj = (EditText) view.findViewById(R.id.edit_jgsj);// 竣工时间
		edit_fwcxd = (Spinner) view.findViewById(R.id.edit_fwcxd);// 房屋成新度
		edit_zxsj = (EditText) view.findViewById(R.id.edit_zxsj);// 装修时间
		edit_zxcd = (Spinner) view.findViewById(R.id.edit_zxcd);// 装修程度
		edit_czlc = (EditText) view.findViewById(R.id.edit_czlc);// 出租楼层
		edit_czyt = (Spinner) view.findViewById(R.id.edit_czyt);// 出租用途
		edit_czmj = (EditText) view.findViewById(R.id.edit_czmj);// 出租建筑面积
		edit_czsj = (EditText) view.findViewById(R.id.edit_czsj);// 出租时间
		edit_zq = (EditText) view.findViewById(R.id.edit_zq);// 租期(年)
		edit_nzj = (EditText) view.findViewById(R.id.edit_nzj);// 年租金
		edit_yj = (EditText) view.findViewById(R.id.edit_yj);// 押金
		edit_sf = (EditText) view.findViewById(R.id.edit_sf);// 税费

		/** 位置信息 **/
		edit_x = (EditText) view.findViewById(R.id.location_info_lon);
		edit_y = (EditText) view.findViewById(R.id.location_info_lat);
		// edit_bjdmc = (EditText) view.findViewById(R.id.location_info_bjdmc);
		edit_zbxt = (EditText) view.findViewById(R.id.location_info_zbxt);
		edit_remark = (EditText) view.findViewById(R.id.location_info_remark);

		/** 其他信息 **/
		edit_rjl = (EditText) view.findViewById(R.id.edit_rjl);
		edit_hxwkfsp = (Spinner) view.findViewById(R.id.edit_hxwkfsp);// spinner
		edit_hxnkfsp = (Spinner) view.findViewById(R.id.edit_hxnkfsp);// spinner
		edit_tdjb = (Spinner) view.findViewById(R.id.edit_tdjb);// spinner
		edit_djqd = (EditText) view.findViewById(R.id.edit_djqd);
		edit_xzqdm = (EditText) view.findViewById(R.id.edit_xzqdm);

		/** 绑定触控事件 **/
		edit_jgsj.setOnTouchListener(this);
		edit_zxsj.setOnTouchListener(this);
		edit_czsj.setOnTouchListener(this);
		edit_zq.setOnTouchListener(this);
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
		list_czyt = typeUtil.initList("ytlx");// 出租用途
		list_hxwkfsp = typeUtil.initList("hxwkfsp");// 红线外开发水平
		list_hxnkfsp = typeUtil.initList("hxnkfsp");// 红线内开发水平
		list_tdjb = typeUtil.initList("tdjb");// 所在土地级别

		value_qsxz = list_qsxz.get(0);
		value_tdyt = list_tdyt.get(0);
		value_jzlx = list_jzlx.get(0);
		value_fwjg = list_fwjg.get(0);
		value_fwcxd = list_fwcxd.get(0);
		value_zxcd = list_zxcd.get(0);
		value_czyt = list_czyt.get(0);
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
		/** 土地用途 **/
		edit_tdyt.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_tdyt = list_tdyt.get(index);
				index_tdyt = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		/** 建筑类型 **/
		edit_jzlx.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_jzlx = list_jzlx.get(index);
				index_jzlx = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});

		/** 房屋结构 **/
		edit_fwjg.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_fwjg = list_fwjg.get(index);
				index_fwjg = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		/** 房屋成新度 **/
		edit_fwcxd.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_fwcxd = list_fwcxd.get(index);
				index_fwcxd = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		/** 装修程度 **/
		edit_zxcd.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_zxcd = list_zxcd.get(index);
				index_zxcd = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		/** 出租用途 **/
		edit_czyt.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_czyt = list_czyt.get(index);
				index_czyt = index;
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

	/**
	 * 监听范围数字输入
	 */
	private void initTextChangedListener() {
		final int MIN_MARK = 0;
		final int MAX_MARK = 100;
		edit_rjl.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				if (start > 1) {
					if (MIN_MARK != -1 && MAX_MARK != -1) {
						int num = Integer.parseInt(s.toString());
						if (num > MAX_MARK) {
							s = String.valueOf(MAX_MARK);
							edit_rjl.setText(s);
						} else if (num < MIN_MARK)
							s = String.valueOf(MIN_MARK);
						return;
					}
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			}

			@Override
			public void afterTextChanged(Editable s) {
				if (s != null && !s.equals("")) {
					if (MIN_MARK != -1 && MAX_MARK != -1) {
						int markVal = 0;
						try {
							markVal = Integer.parseInt(s.toString());
						} catch (NumberFormatException e) {
							markVal = 0;
						}
						if (markVal > MAX_MARK) {
							Toast.makeText(getActivity(), "不能超过100", Toast.LENGTH_SHORT).show();
							edit_rjl.setText(String.valueOf(MAX_MARK));
						}
						return;
					}
				}
			}
		});
		edit_ljsd.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				if (start > 1) {
					if (MIN_MARK != -1 && MAX_MARK != -1) {
						int num = Integer.parseInt(s.toString());
						if (num > MAX_MARK) {
							s = String.valueOf(MAX_MARK);
							edit_ljsd.setText(s);
						} else if (num < MIN_MARK)
							s = String.valueOf(MIN_MARK);
						return;
					}
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			}

			@Override
			public void afterTextChanged(Editable s) {
				if (s != null && !s.equals("")) {
					if (MIN_MARK != -1 && MAX_MARK != -1) {
						int markVal = 0;
						try {
							markVal = Integer.parseInt(s.toString());
						} catch (NumberFormatException e) {
							markVal = 0;
						}
						if (markVal > MAX_MARK) {
							Toast.makeText(getActivity(), "不能超过100", Toast.LENGTH_SHORT).show();
							edit_ljsd.setText(String.valueOf(MAX_MARK));
						}
						return;
					}
				}
			}
		});
		edit_ljkd.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				if (start > 1) {
					if (MIN_MARK != -1 && MAX_MARK != -1) {
						int num = Integer.parseInt(s.toString());
						if (num > MAX_MARK) {
							s = String.valueOf(MAX_MARK);
							edit_ljkd.setText(s);
						} else if (num < MIN_MARK)
							s = String.valueOf(MIN_MARK);
						return;
					}
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			}

			@Override
			public void afterTextChanged(Editable s) {
				if (s != null && !s.equals("")) {
					if (MIN_MARK != -1 && MAX_MARK != -1) {
						int markVal = 0;
						try {
							markVal = Integer.parseInt(s.toString());
						} catch (NumberFormatException e) {
							markVal = 0;
						}
						if (markVal > MAX_MARK) {
							Toast.makeText(getActivity(), "不能超过100", Toast.LENGTH_SHORT).show();
							edit_ljkd.setText(String.valueOf(MAX_MARK));
						}
						return;
					}
				}
			}
		});
		edit_jzcs.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				if (start > 1) {
					if (MIN_MARK != -1 && MAX_MARK != -1) {
						int num = Integer.parseInt(s.toString());
						if (num > MAX_MARK) {
							s = String.valueOf(MAX_MARK);
							edit_jzcs.setText(s);
						} else if (num < MIN_MARK)
							s = String.valueOf(MIN_MARK);
						return;
					}
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			}

			@Override
			public void afterTextChanged(Editable s) {
				if (s != null && !s.equals("")) {
					if (MIN_MARK != -1 && MAX_MARK != -1) {
						int markVal = 0;
						try {
							markVal = Integer.parseInt(s.toString());
						} catch (NumberFormatException e) {
							markVal = 0;
						}
						if (markVal > MAX_MARK) {
							Toast.makeText(getActivity(), "不能超过100", Toast.LENGTH_SHORT).show();
							edit_jzcs.setText(String.valueOf(MAX_MARK));
						}
						return;
					}
				}
			}
		});
		edit_czlc.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				if (start > 1) {
					if (MIN_MARK != -1 && MAX_MARK != -1) {
						int num = Integer.parseInt(s.toString());
						if (num > MAX_MARK) {
							s = String.valueOf(MAX_MARK);
							edit_czlc.setText(s);
						} else if (num < MIN_MARK)
							s = String.valueOf(MIN_MARK);
						return;
					}
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			}

			@Override
			public void afterTextChanged(Editable s) {
				if (s != null && !s.equals("")) {
					if (MIN_MARK != -1 && MAX_MARK != -1) {
						int markVal = 0;
						try {
							markVal = Integer.parseInt(s.toString());
						} catch (NumberFormatException e) {
							markVal = 0;
						}
						if (markVal > MAX_MARK) {
							Toast.makeText(getActivity(), "不能超过100", Toast.LENGTH_SHORT).show();
							edit_czlc.setText(String.valueOf(MAX_MARK));
						}
						return;
					}
				}
			}
		});
	}

	@SuppressLint("SimpleDateFormat")
	@Override
	public void onClick(View arg0) {
		// 获取屏幕参数
		DisplayMetrics metric = new DisplayMetrics();
		getParentFragment().getActivity().getWindowManager().getDefaultDisplay().getMetrics(metric);
		int width = metric.widthPixels; // 屏幕宽度（像素）
		int height = metric.heightPixels; // 屏幕高度（像素）

		int id = arg0.getId();
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
			if (edit_x.getText().toString().equals("") || edit_y.getText().toString().equals("")) {
				ToastUtil.ToastStr(getActivity(), "请补充完整经纬度信息", 2000);
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
				locationInfo.setCollectionType(CollectType.Collection_Market_Business_House_Rent);
				// 类型ID
				locationInfo.setCollectionMainType(CollectType.Business);
				locationInfo.setCollectionTableName(CollectType.Collection_Market_Business_House_Rent_Tablename);// 表名
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
						AttachmentUtil attachmentUtil=new AttachmentUtil();
						attachmentUtil.saveAttachmentInfo(locationInfo);
					} else {
						ToastUtil.ToastStr(getActivity(), "存储失败", 2000);
					}
				} else {
					ToastUtil.ToastStr(getActivity(), "存储失败", 2000);
				}
			}
			break;
		// 清空表单
		case R.id.fragment_collection_ibtn_clear:
			break;
		}
	}

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
				image_photo.setImageBitmap(camorabitmap);

				// TODO
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
				image_photo.setImageBitmap(camorabitmap);
				// TODO
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
						}
						// TODO
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
		value_tdsyz = edit_tdsyz.getText().toString();// 土地所有者
		value_tdzsh = edit_tdzsh.getText().toString();// 土地证书号
		value_tdzl = edit_tdzl.getText().toString();// 土地坐落

		value_fwsyqr = edit_fwsyqr.getText().toString();// 房屋所有权人
		value_ljkd = edit_ljkd.getText().toString();// 临街宽度
		value_ljsd = edit_ljsd.getText().toString();// 临街深度
		value_jzcs = edit_jzcs.getText().toString();// 建筑层数
		value_jgsj = edit_jgsj.getText().toString();// 竣工时间
		value_zxsj = edit_zxsj.getText().toString();// 装修时间
		value_czlc = edit_czlc.getText().toString();// 出租楼层
		value_czmj = edit_czmj.getText().toString();// 出租建筑面积
		value_czsj = edit_czsj.getText().toString();// 出租时间
		value_zq = edit_zq.getText().toString();// 租期(年)
		value_nzj = edit_nzj.getText().toString();// 年租金
		value_yj = edit_yj.getText().toString();// 押金
		value_sf = edit_sf.getText().toString();// 税费

		/** 位置信息.变量 **/
		value_x = edit_x.getText().toString();// 经度
		value_y = edit_y.getText().toString();// 纬度
		// value_bjdmc = edit_bjdmc.getText().toString();// 标记点名称
		value_zbxt = edit_zbxt.getText().toString();// 坐标系统
		value_remark = edit_remark.getText().toString();// 备注
		/** 其他信息 **/
		value_rjl = edit_rjl.getText().toString();// 容积率
		value_djqd = edit_djqd.getText().toString();// 所在地址区段
		value_xzqdm = edit_xzqdm.getText().toString();// 行政区代码（村级行政区）
	}

	/**
	 * 说明：保存采集信息到分表
	 * 
	 * @return id
	 */
	private int saveCollectionInfo() {
		int result = 0;
		setCollectionInfo();
		ModelCollectionMarketBusinessHouseRent model = new ModelCollectionMarketBusinessHouseRent();
		/** 基本信息 **/
		model.setTHENAME(value_the_name);// 记录名称
		model.setTHECODE(value_the_code);// 记录代码
		model.setTDSYZ(value_tdsyz);// 土地所有者
		model.setTDZSH(value_tdzsh);// 土地证书号
		model.setTDZL(value_tdzl);// 土地坐落
		model.setQSXZ(value_qsxz);// 权属性质

		// /** 出让/受让信息 **/
		model.setFWSYQR(value_fwsyqr);// 房屋所有权人
		model.setTDYT(value_tdyt);// 土地用途
		model.setLJKD(value_ljkd);// 临街宽度
		model.setLJSD(value_ljsd);// 临街深度
		model.setJZLX(value_jzlx);// 建筑类型
		model.setJZCS(value_jzcs);// 建筑层数
		model.setFWJG(value_fwjg);// 房屋结构
		if (!value_jgsj.equals("")) {
			model.setJGSJ(value_jgsj);// 竣工时间
		}
		model.setFWCXD(value_fwcxd);// 房屋成新度
		if (!value_zxsj.equals("")) {
			model.setZXSJ(value_zxsj);// 装修时间
		}
		model.setZXCD(value_zxcd);// 装修程度
		model.setCZLC(value_czlc);// 出租楼层
		model.setCZYT(value_czyt);// 出租用途
		model.setCZMJ(value_czmj);// 出租建筑面积
		if (!value_czsj.equals("")) {
			model.setCZSJ(value_czsj);// 出租时间
		}
		if (!value_czsj.equals("")) {
			model.setZQ(value_zq);// 租期（年）
		}
		model.setNZJ(value_nzj);// 年租金
		model.setYJ(value_yj);// 押金
		model.setSF(value_sf);// 税费
		/** 位置信息 **/
		model.setX(value_x);// 精度
		model.setY(value_y);// 纬度
		model.setZBXT(value_zbxt);// 坐标系统
		model.setREMARK(value_remark);// 备注

		/** 其他信息 **/
		model.setRJL(value_rjl);// 宗地容积率
		model.setHXWKFSP(value_hxwkfsp);// 红线外开发水平
		model.setHXNKFSP(value_hxnkfsp);// 红线内开发水平
		model.setTDJB(value_tdjb); // 所在土地级别
		model.setDJQD(value_djqd);// 所在地价区段
		model.setXZQDM(value_xzqdm);// 行政区代码（村级行政区）

		/** 赋值下拉字段 **/
		model.setINDEX_QSXZ(index_qsxz);
		model.setINDEX_TDYT(index_tdyt);
		model.setINDEX_JZLX(index_jzlx);
		model.setINDEX_FWJG(index_fwjg);
		model.setINDEX_FWCXD(index_fwcxd);
		model.setINDEX_ZXCD(index_zxcd);
		model.setINDEX_CZYT(index_czyt);
		model.setINDEX_HXWKFSP(index_hxwkfsp);
		model.setINDEX_HXNKFSP(index_hxnkfsp);
		model.setINDEX_TDJB(index_tdjb);
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
		if (event.getAction() == MotionEvent.ACTION_DOWN) {

			AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
			View view = View.inflate(getActivity(), R.layout.dialog_date_picker, null);
			final DatePicker datePicker = (DatePicker) view.findViewById(R.id.date_picker);
			builder.setView(view);

			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(System.currentTimeMillis());
			datePicker.init(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), null);

			/** 竣工时间 **/
			if (v.getId() == R.id.edit_jgsj) {
				final int inType = edit_jgsj.getInputType();
				edit_jgsj.setInputType(InputType.TYPE_NULL);
				edit_jgsj.onTouchEvent(event);
				edit_jgsj.setInputType(inType);
				// edit_jgsj.setSelection(edit_jgsj.getText().length());

				builder.setTitle("选取竣工时间");
				builder.setPositiveButton("确  定", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

						StringBuffer sb = new StringBuffer();
						sb.append(String.format("%d-%02d-%02d", datePicker.getYear(), datePicker.getMonth() + 1, datePicker.getDayOfMonth()));
						sb.append("  00:00:00");

						edit_jgsj.setText(sb);
						edit_jgsj.requestFocus();

						dialog.cancel();
					}
				});
			}
			/** 装修时间 **/
			else if (v.getId() == R.id.edit_zxsj) {
				final int inType = edit_zxsj.getInputType();
				edit_zxsj.setInputType(InputType.TYPE_NULL);
				edit_zxsj.onTouchEvent(event);
				edit_zxsj.setInputType(inType);
				edit_zxsj.setSelection(edit_zxsj.getText().length());

				builder.setTitle("选取装修时间");
				builder.setPositiveButton("确  定", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

						StringBuffer sb = new StringBuffer();
						sb.append(String.format("%d-%02d-%02d", datePicker.getYear(), datePicker.getMonth() + 1, datePicker.getDayOfMonth()));
						sb.append("  00:00:00");

						edit_zxsj.setText(sb);
						edit_zxsj.requestFocus();

						dialog.cancel();
					}
				});
			}
			/** 出租时间 **/
			else if (v.getId() == R.id.edit_czsj) {
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
						sb.append("  00:00:00");

						edit_czsj.setText(sb);
						edit_czsj.requestFocus();

						dialog.cancel();
					}
				});
			} else if (v.getId() == R.id.edit_zq) {
				final int inType = edit_zq.getInputType();
				edit_zq.setInputType(InputType.TYPE_NULL);
				edit_zq.onTouchEvent(event);
				edit_zq.setInputType(inType);
				edit_zq.setSelection(edit_zq.getText().length());

				builder.setTitle("选取租期");
				builder.setPositiveButton("确  定", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

						StringBuffer sb = new StringBuffer();
						sb.append(String.format("%d-%02d-%02d", datePicker.getYear(), datePicker.getMonth() + 1, datePicker.getDayOfMonth()));
						sb.append("  00:00:00");

						edit_zq.setText(sb);
						edit_zq.requestFocus();

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

		// 获取返回的坐标信息
		if (data != null) {
			if (data.getIntExtra("rCode", 0) == 1) {
				lat = data.getIntExtra("lat", 0) / 1E6;
				lon = data.getIntExtra("long", 0) / 1E6;
				edit_x.setText(lon + "");
				edit_y.setText(lat + "");
			}
		}

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
				imagePathListIndex = imagePathList.size() - 1;
				// TODO
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
				imagePathListIndex = imagePathList.size() - 1;
				// TODO
				text_page.setText("第" + (imagePathListIndex + 1) + "张");
				text_total.setText(",共" + imagePathList.size() + "张");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}