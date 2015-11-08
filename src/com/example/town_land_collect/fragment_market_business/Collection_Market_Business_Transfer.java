package com.example.town_land_collect.fragment_market_business;

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
import com.example.town_land_collect.model.LocationInfo;
import com.example.town_land_collect.model.market_business.ModelCollectionMarketBusinessTransfer;
import com.example.town_land_collect.util.AttachmentUtil;
import com.example.town_land_collect.util.CollectType;
import com.example.town_land_collect.util.ComUtil;
import com.example.town_land_collect.util.CommonTypeUtil;
import com.example.town_land_collect.util.ImageUtil;
import com.example.town_land_collect.util.ToastUtil;
import com.example.town_land_collect.util.layout.FragmentUtil;

/**
 * 
 * @Title Collection_Market_Business_Transfer.java
 * @Package com.example.town_land_collect.fragment_market_business
 * @Description 土地使用权转让交易信息
 * @author Shen.dev
 * @date 2015-10-14 下午3:10:00
 * @version V1.0
 */
@SuppressLint({ "CutPasteId", "ClickableViewAccessibility" })
public class Collection_Market_Business_Transfer extends Fragment implements OnClickListener, OnTouchListener {
	private String imagePathString = null;
	// TODO 图片相关
	private final String IMAGE_TYPE = "image/*";
	private final int IMAGE_CODE = 0; // 这里的IMAGE_CODE是自己任意定义的
	private List<String> imagePathList = new ArrayList<String>();
	private int imagePathListIndex = 0;
	private Bitmap camorabitmap = null;

	// TODO 图片选择按钮
	private Button image_left;// 图片上一张
	private Button image_right;// 图片下一张
	// TODO
	private TextView text_page;
	private TextView text_total;
	private View tView;
	private FragmentUtil fragmentUtil = new FragmentUtil();
	private Integer curFragmentParent = 1;// fragment父级
	private Integer curFragmentChildren = 0;// frament子级

	CommonTypeUtil typeUtil = new CommonTypeUtil();

	/** 基础信息.控件 **/
	private int index_qsxz = 0;// 权属性质
	/** 土地使用权转让交易信息 **/
	private int index_zrfs = 0;// 转让方式
	private int index_zrqyt = 0;// 转让前用途
	private int index_zrhyt = 0;// 转让后用途
	/** 其他信息.控件 **/
	private int index_hxwkfsp = 0;// 红线外开发水平
	private int index_hxnkfsp = 0;// 红线内开发水平
	private int index_tdjb = 0;// 所在土地级别

	/** 通用部分.控件 **/
	private ImageView image_photo;// 图片信息
	private ImageButton imageButton_Location;// 选择坐标（地图）
	private ImageButton imageButton_Save;// 表单保存
	private ImageButton imageButton_Clear;// 清空表单
	private TextView textView_Tips;// 提示信息

	/** 基础信息.控件 **/
	private EditText edit_the_name;// 记录名称
	private EditText edit_the_code;// 记录代码
	private EditText edit_tdsyz;// 土地使用者
	private EditText edit_tdzsh;// 土地证书号
	private EditText edit_tdzl;// 土地坐落
	private Spinner edit_qsxz;// 权属性质

	/** 土地使用权转让交易信息 **/
	private EditText edit_zrf;// 转让方
	private EditText edit_srf;// 受让方
	private EditText edit_zrsj;// 转让时间
	private Spinner edit_zrfs;// 转让方式
	private EditText edit_zrmj;// 土地转让面积
	private Spinner edit_zrqyt;// 转让前用途
	private Spinner edit_zrhyt;// 转让后用途
	private EditText edit_tdsynq;// 土地剩余使用年期
	private EditText edit_zrdj;// 土地转让单价
	private EditText edit_zrzj;// 土地转让总价

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

	/** 土地使用权转让交易信息 **/
	private String value_zrf;// 转让方
	private String value_srf;// 受让方
	private String value_zrsj;// 转让时间
	private String value_zrfs;// 转让方式
	private String value_zrmj;// 土地转让面积
	private String value_zrqyt;// 转让前用途
	private String value_zrhyt;// 转让后用途
	private String value_tdsynq;// 土地剩余使用年期
	private String value_zrdj;// 土地转让单价
	private String value_zrzj;// 土地转让总价

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
	private String value_zbxt;// 坐标系统
	private String value_remark;// 备注

	/** Spinner Dict **/
	private ArrayList<String> list_qsxz = new ArrayList<String>();// 权属性质
	private ArrayList<String> list_zrfs = new ArrayList<String>();
	private ArrayList<String> list_zrqyt = new ArrayList<String>();
	private ArrayList<String> list_zrhyt = new ArrayList<String>();
	private ArrayList<String> list_hxwkfsp = new ArrayList<String>();// 红线外开发水平
	private ArrayList<String> list_hxnkfsp = new ArrayList<String>();// 红线内开发水平
	private ArrayList<String> list_tdjb = new ArrayList<String>();// 所在土地级别

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = (View) inflater.inflate(R.layout.collection_market_business_transfer_frame, container, false);
		tView = view;
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
		// TODO 图片选择按钮控件
		image_left = (Button) view.findViewById(R.id.fragment_collection_left);
		image_left.setOnClickListener(this);
		image_right = (Button) view.findViewById(R.id.fragment_collection_right);
		image_right.setOnClickListener(this);
		// TODO
		text_page = (TextView) view.findViewById(R.id.textViewPage);
		text_total = (TextView) view.findViewById(R.id.textViewTotal);
		imageButton_Location = (ImageButton) view.findViewById(R.id.fragment_collection_ibtn_location);
		imageButton_Location.setOnClickListener(this);
		imageButton_Save = (ImageButton) view.findViewById(R.id.fragment_collection_ibtn_save);
		imageButton_Clear = (ImageButton) view.findViewById(R.id.fragment_collection_ibtn_clear);
		imageButton_Clear.setOnClickListener(this);
		imageButton_Save.setOnClickListener(this);
		textView_Tips = (TextView) view.findViewById(R.id.fragment_collection_tv_tips);
		textView_Tips.setText("土地使用权转让交易信息");
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
		/** 土地使用权转让交易信息 **/
		edit_zrf = (EditText) view.findViewById(R.id.edit_zrf);// 转让方
		edit_srf = (EditText) view.findViewById(R.id.edit_srf);// 受让方
		edit_zrsj = (EditText) view.findViewById(R.id.edit_zrsj);// 转让时间
		edit_zrfs = (Spinner) view.findViewById(R.id.edit_zrfs);// 转让方式
		edit_zrmj = (EditText) view.findViewById(R.id.edit_zrmj);// 土地转让面积
		edit_zrqyt = (Spinner) view.findViewById(R.id.edit_zrqyt);// 转让前用途
		edit_zrhyt = (Spinner) view.findViewById(R.id.edit_zrhyt);// 转让后用途
		edit_tdsynq = (EditText) view.findViewById(R.id.edit_tdsynq);// 土地剩余使用年期
		edit_zrdj = (EditText) view.findViewById(R.id.edit_zrdj);// 土地转让单价
		edit_zrzj = (EditText) view.findViewById(R.id.edit_zrdj);// 土地转让总价
		/** 位置信息 **/
		edit_x = (EditText) view.findViewById(R.id.location_info_lon);
		edit_y = (EditText) view.findViewById(R.id.location_info_lat);
		edit_zbxt = (EditText) view.findViewById(R.id.location_info_zbxt);
		edit_remark = (EditText) view.findViewById(R.id.location_info_remark);
		/** 其他信息 **/
		edit_rjl = (EditText) view.findViewById(R.id.edit_rjl);
		edit_hxwkfsp = (Spinner) view.findViewById(R.id.edit_hxwkfsp);// spinner
		edit_hxnkfsp = (Spinner) view.findViewById(R.id.edit_hxnkfsp);// spinner
		edit_tdjb = (Spinner) view.findViewById(R.id.edit_tdjb);// spinner
		edit_djqd = (EditText) view.findViewById(R.id.edit_djqd);
		edit_xzqdm = (EditText) view.findViewById(R.id.edit_xzqdm);

		edit_zrsj = (EditText) view.findViewById(R.id.edit_zrsj);
		edit_zrsj.setOnTouchListener(this);
		edit_tdsynq = (EditText) view.findViewById(R.id.edit_tdsynq);
		edit_tdsynq.setOnTouchListener(this);

	}

	/**
	 * 说明：初始化Spinner 字典列表
	 * 
	 * @return void
	 */
	private void initSpinnerDict() {
		CommonTypeUtil typeUtil = new CommonTypeUtil();

		list_qsxz = typeUtil.initList("qsxz");// 权属性质
		list_zrfs = typeUtil.initList("zrfs");// 转让方式
		list_zrqyt = typeUtil.initList("ytlx");// 出租前用途
		list_zrhyt = typeUtil.initList("ytlx");// 出租后用途
		list_hxwkfsp = typeUtil.initList("hxwkfsp");// 红线外开发水平
		list_hxnkfsp = typeUtil.initList("hxnkfsp");// 红线内开发水平
		list_tdjb = typeUtil.initList("tdjb");// 所在土地级别

		value_qsxz = list_qsxz.get(0);
		value_zrfs = list_zrfs.get(0);
		value_zrqyt = list_zrqyt.get(0);
		value_zrhyt = list_zrhyt.get(0);
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

		edit_zrfs.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_zrfs = typeUtil.initList("zrfs").get(index);
				index_zrfs = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		edit_zrqyt.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				CommonTypeUtil typeUtil = new CommonTypeUtil();
				ArrayList<String> list = typeUtil.initList("tdyt");
				value_zrqyt = list.get(index);
				index_zrqyt = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		edit_zrhyt.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				CommonTypeUtil typeUtil = new CommonTypeUtil();
				ArrayList<String> list = typeUtil.initList("tdyt");
				value_zrhyt = list.get(index);
				index_zrhyt = index;
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

	private void initTextChangedListener() {
		final int MIN_MARK = 0;
		final int MAX_MARK = 100;
		if (edit_rjl != null)
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
				locationInfo.setCollectionType(CollectType.Collection_Market_Business_Transfer);// TODO
																								// 类型ID
				locationInfo.setCollectionMainType(CollectType.Business);// TODO
				locationInfo.setCollectionTableName(CollectType.Collection_Market_Business_Transfer_Tablename);// 表名
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
		/** 土地使用权转让交易信息 **/
		value_zrf = edit_zrf.getText().toString();// 转让方
		value_srf = edit_srf.getText().toString();// 受让方
		value_zrsj = edit_zrsj.getText().toString();// 转让时间
		value_zrmj = edit_zrmj.getText().toString();// 土地转让面积
		value_tdsynq = edit_tdsynq.getText().toString();// 土地剩余使用年期
		value_zrdj = edit_zrdj.getText().toString();// 土地转让单价
		value_zrzj = edit_zrzj.getText().toString();// 土地转让总价
		/** 位置信息.变量 **/
		value_x = edit_x.getText().toString();// 经度
		value_y = edit_y.getText().toString();// 纬度
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
		ModelCollectionMarketBusinessTransfer model = new ModelCollectionMarketBusinessTransfer();
		/** 基本信息 **/
		model.setTHENAME(value_the_name);// 记录名称
		model.setTHECODE(value_the_code);// 记录代码
		model.setTDSYZ(value_tdsyz);// 土地所有者
		model.setTDZSH(value_tdzsh);// 土地证书号
		model.setTDZL(value_tdzl);// 土地坐落
		model.setQSXZ(value_qsxz);// 权属性质

		// TODO 构造实体数据
		model.setZRF(fragmentUtil.getEditText(tView, R.id.edit_zrf, "edit_zrf"));// 转让方
		model.setSRF(fragmentUtil.getEditText(tView, R.id.edit_srf, "edit_srf"));
		model.setZRSJ(fragmentUtil.getEditText(tView, R.id.edit_zrsj, "edit_zrsj"));
		model.setZRFS(value_zrfs);
		model.setZRMJ(fragmentUtil.getEditText(tView, R.id.edit_zrmj, "edit_zrmj"));
		model.setZRQYT(value_zrqyt);
		model.setZRHYT(value_zrhyt);
		model.setTDSYNQ(fragmentUtil.getEditText(tView, R.id.edit_tdsynq, "edit_tdsynq"));
		model.setZRDJ(fragmentUtil.getEditText(tView, R.id.edit_zrdj, "edit_zrdj"));
		model.setZRZJ(fragmentUtil.getEditText(tView, R.id.edit_zrzj, "edit_zrzj"));

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
		model.setINDEX_ZRFS(index_zrfs);
		model.setINDEX_ZRQYT(index_zrqyt);
		model.setINDEX_ZRHYT(index_zrhyt);
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

			// TODO 实现点击时间事件
			if (v.getId() == R.id.edit_zrsj) {
				final int inType = edit_zrsj.getInputType();
				edit_zrsj.setInputType(InputType.TYPE_NULL);
				edit_zrsj.onTouchEvent(event);
				edit_zrsj.setInputType(inType);
				edit_zrsj.setSelection(edit_zrsj.getText().length());

				builder.setTitle("选取时间");
				builder.setPositiveButton("确  定", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

						StringBuffer sb = new StringBuffer();
						sb.append(String.format("%d-%02d-%02d", datePicker.getYear(), datePicker.getMonth() + 1, datePicker.getDayOfMonth()));
						sb.append("  00:00:00");

						edit_zrsj.setText(sb);
						edit_zrsj.requestFocus();

						dialog.cancel();
					}
				});

			} else if (v.getId() == R.id.edit_tdsynq) {
				final int inType = edit_tdsynq.getInputType();
				edit_tdsynq.setInputType(InputType.TYPE_NULL);
				edit_tdsynq.onTouchEvent(event);
				edit_tdsynq.setInputType(inType);
				edit_tdsynq.setSelection(edit_tdsynq.getText().length());

				builder.setTitle("选取时间");
				builder.setPositiveButton("确  定", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

						StringBuffer sb = new StringBuffer();
						sb.append(String.format("%d-%02d-%02d", datePicker.getYear(), datePicker.getMonth() + 1, datePicker.getDayOfMonth()));
						sb.append("  00:00:00");

						edit_tdsynq.setText(sb);
						edit_tdsynq.requestFocus();

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
		// TODO 应该加入 REQUEST_CODE,而不是用其他判断
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
