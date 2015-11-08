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
import com.example.town_land_collect.model.market_business.ModelCollectionMarketBusinessSell;
import com.example.town_land_collect.util.AttachmentUtil;
import com.example.town_land_collect.util.CollectType;
import com.example.town_land_collect.util.ComUtil;
import com.example.town_land_collect.util.CommonTypeUtil;
import com.example.town_land_collect.util.ImageUtil;
import com.example.town_land_collect.util.ToastUtil;
import com.example.town_land_collect.util.layout.FragmentUtil;

/**
 * 
 * @Title Collection_Market_Business_Sell.java
 * @Package com.example.town_land_collect.fragment_market_business
 * @Description 土地使用权出让交易信息
 * @author Shen.dev
 * @date 2015-10-13 下午3:45:41
 * @version V1.0
 */
public class Collection_Market_Business_Sell extends Fragment implements OnClickListener, OnTouchListener {
	private FragmentUtil fragmentUtil = new FragmentUtil();
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
	private Integer curFragmentParent = 1;
	private Integer curFragmentChildren = 0;
	private View tView;
	private String imagePath;

	private int collectionMainType = CollectType.Business;
	private int collectionType = CollectType.Collection_Market_Business_Sell;
	private String collectionTableName = CollectType.Collection_Market_Business_Sell_Tablename;

	private ImageView image_photo;
	private ImageButton button_location;
	private ImageButton button_save;
	private ImageButton button_clear;
	private TextView text_tips;

	private TextView edit_lon;
	private TextView edit_lat;

	private String value_qsxz;
	private String value_crfs;
	private String value_sfzkf;
	private String value_sflyd;
	private String value_crqyt;
	private String value_crhyt;
	private String value_hxwkfsp;
	private String value_hxnkfsp;
	private String value_tdjb;
	private int index_qsxz;
	private int index_crfs;
	private int index_sfzkf;
	private int index_sflyd;
	private int index_crqyt;
	private int index_crhyt;
	private int index_hxwkfsp;
	private int index_hxnkfsp;
	private int index_tdjb;

	private EditText edit_rjl;

	private EditText edit_crsj;
	private EditText edit_crnq;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = (View) inflater.inflate(R.layout.collection_market_business_sell_frame, container, false);
		initView(view);
		initOnItemSelectedListener(view);
		initTextChangedListener(view);
		return view;
	}

	private void initView(View view) {
		tView = view;
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
		button_location = (ImageButton) view.findViewById(R.id.fragment_collection_ibtn_location);
		button_location.setOnClickListener(this);
		button_save = (ImageButton) view.findViewById(R.id.fragment_collection_ibtn_save);
		button_clear = (ImageButton) view.findViewById(R.id.fragment_collection_ibtn_clear);
		button_clear.setOnClickListener(this);
		button_save.setOnClickListener(this);
		text_tips = (TextView) view.findViewById(R.id.fragment_collection_tv_tips);
		text_tips.setText("土地使用权出让交易信息");

		edit_crsj = (EditText) view.findViewById(R.id.edit_crsj);
		edit_crsj.setOnTouchListener(this);
		edit_crnq = (EditText) view.findViewById(R.id.edit_crnq);
		edit_crnq.setOnTouchListener(this);
	}

	private void initOnItemSelectedListener(View view) {

		Spinner edit_qsxz = (Spinner) view.findViewById(R.id.edit_qsxz);
		edit_qsxz.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				CommonTypeUtil typeUtil = new CommonTypeUtil();
				ArrayList<String> list = typeUtil.initList("qsxz");
				value_qsxz = list.get(index);
				index_qsxz = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		Spinner edit_crfs = (Spinner) view.findViewById(R.id.edit_crfs);
		edit_crfs.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				CommonTypeUtil typeUtil = new CommonTypeUtil();
				ArrayList<String> list = typeUtil.initList("zrfs");
				value_crfs = list.get(index);
				index_crfs = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		Spinner edit_sfzkf = (Spinner) view.findViewById(R.id.edit_sfzkf);
		edit_sfzkf.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				CommonTypeUtil typeUtil = new CommonTypeUtil();
				ArrayList<String> list = typeUtil.initList("yesno");
				value_sfzkf = list.get(index);
				index_sfzkf = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		Spinner edit_sflyd = (Spinner) view.findViewById(R.id.edit_sflyd);
		edit_sflyd.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				CommonTypeUtil typeUtil = new CommonTypeUtil();
				ArrayList<String> list = typeUtil.initList("yesno");
				value_sflyd = list.get(index);
				index_sflyd = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		Spinner edit_crqyt = (Spinner) view.findViewById(R.id.edit_crqyt);
		edit_crqyt.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				CommonTypeUtil typeUtil = new CommonTypeUtil();
				ArrayList<String> list = typeUtil.initList("tdyt");
				value_crqyt = list.get(index);
				index_crqyt = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		Spinner edit_crhyt = (Spinner) view.findViewById(R.id.edit_crhyt);
		edit_crhyt.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				CommonTypeUtil typeUtil = new CommonTypeUtil();
				ArrayList<String> list = typeUtil.initList("tdyt");
				value_crhyt = list.get(index);
				index_crhyt = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		Spinner edit_hxwkfsp = (Spinner) view.findViewById(R.id.edit_hxwkfsp);
		edit_hxwkfsp.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				CommonTypeUtil typeUtil = new CommonTypeUtil();
				ArrayList<String> list = typeUtil.initList("hxwkfsp");
				value_hxwkfsp = list.get(index);
				index_hxwkfsp = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		Spinner edit_hxnkfsp = (Spinner) view.findViewById(R.id.edit_hxnkfsp);
		edit_hxnkfsp.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				CommonTypeUtil typeUtil = new CommonTypeUtil();
				ArrayList<String> list_qsxz = typeUtil.initList("hxnkfsp");
				value_hxnkfsp = list_qsxz.get(index);
				index_hxnkfsp = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		Spinner edit_tdjb = (Spinner) view.findViewById(R.id.edit_tdjb);
		edit_tdjb.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				CommonTypeUtil typeUtil = new CommonTypeUtil();
				ArrayList<String> list_qsxz = typeUtil.initList("tdjb");
				value_tdjb = list_qsxz.get(index);
				index_tdjb = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});

	}

	private void initTextChangedListener(View view) {
		final int MIN_MARK = 0;
		final int MAX_MARK = 100;
		edit_rjl = (EditText) view.findViewById(R.id.edit_rjl);
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

			if (v.getId() == R.id.edit_crsj) {
				final int inType = edit_crsj.getInputType();
				edit_crsj.setInputType(InputType.TYPE_NULL);
				edit_crsj.onTouchEvent(event);
				edit_crsj.setInputType(inType);

				builder.setTitle("选取时间");
				builder.setPositiveButton("确  定", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

						StringBuffer sb = new StringBuffer();
						sb.append(String.format("%d-%02d-%02d", datePicker.getYear(), datePicker.getMonth() + 1, datePicker.getDayOfMonth()));
						sb.append("  00:00:00");

						edit_crsj.setText(sb);
						edit_crsj.requestFocus();

						dialog.cancel();
					}
				});
			} else if (v.getId() == R.id.edit_crnq) {
				final int inType = edit_crnq.getInputType();
				edit_crnq.setInputType(InputType.TYPE_NULL);
				edit_crnq.onTouchEvent(event);
				edit_crnq.setInputType(inType);

				builder.setTitle("选取时间");
				builder.setPositiveButton("确  定", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

						StringBuffer sb = new StringBuffer();
						sb.append(String.format("%d-%02d-%02d", datePicker.getYear(), datePicker.getMonth() + 1, datePicker.getDayOfMonth()));
						sb.append("  00:00:00");

						edit_crnq.setText(sb);
						edit_crnq.requestFocus();

						dialog.cancel();
					}
				});
			}
			Dialog dialog = builder.create();
			dialog.show();
		}

		return true;
	}

	private int saveModel() {
		int saveId = 0;
		ModelCollectionMarketBusinessSell model = new ModelCollectionMarketBusinessSell();
		model.setTHENAME(fragmentUtil.getEditText(tView, R.id.edit_the_name, "edit_the_name"));// 记录名称
		model.setTHECODE(fragmentUtil.getEditText(tView, R.id.edit_the_code, "edit_the_code"));// 记录代码
		model.setTDSYZ(fragmentUtil.getEditText(tView, R.id.edit_tdsyz, "edit_tdsyz"));// 土地所有者
		model.setTDZSH(fragmentUtil.getEditText(tView, R.id.edit_tdzsh, "edit_tdzsh"));// 土地证书号
		model.setTDZL(fragmentUtil.getEditText(tView, R.id.edit_tdzl, "edit_tdzl"));// 土地坐落
		model.setQSXZ(value_qsxz);// 权属性质
		model.setCRSJ(fragmentUtil.getEditText(tView, R.id.edit_crsj, "edit_crsj"));// 出让时间
		model.setSRF(fragmentUtil.getEditText(tView, R.id.edit_srf, "edit_srf"));// 受让方
		model.setCRFS(value_crfs);// 出让方式
		model.setSFZKF(value_sfzkf);// 是否再开发
		model.setSFLYD(value_sflyd);// 是否留用地
		model.setGHTDMJ(fragmentUtil.getEditText(tView, R.id.edit_ghtdmj, "edit_ghtdmj"));// 规划红线范围土地面积
		model.setDZTDMJ(fragmentUtil.getEditText(tView, R.id.edit_dztdmj, "edit_dztdmj"));// 代征土地面积
		model.setSJCRMJ(fragmentUtil.getEditText(tView, R.id.edit_sjcrmj, "edit_sjcrmj"));// 实际出让面积
		model.setCRQYT(value_crqyt);// 出让前用途
		model.setCRHYT(value_crhyt);// 出让后用途
		model.setCRNQ(fragmentUtil.getEditText(tView, R.id.edit_crnq, "edit_crnq"));// 出让年期
		model.setCRDJ(fragmentUtil.getEditText(tView, R.id.edit_crdj, "edit_crdj"));// 单位面积土地出让价
		model.setCRZJ(fragmentUtil.getEditText(tView, R.id.edit_crzj, "edit_crzj"));// 土地出让总价
		model.setRJL(fragmentUtil.getEditText(tView, R.id.edit_rjl, "edit_rjl"));// 宗地容积率
		model.setHXWKFSP(value_hxwkfsp);// 红线外开发水平
		model.setHXNKFSP(value_hxnkfsp);// 红线内开发水平
		model.setTDJB(value_tdjb);// 所在土地级别
		model.setDJQD(fragmentUtil.getEditText(tView, R.id.edit_djqd, "edit_djqd"));// 所在地价区段
		model.setXZQDM(fragmentUtil.getEditText(tView, R.id.edit_xzqdm, "edit_xzqdm"));// 行政区代码
		model.setX(fragmentUtil.getEditText(tView, R.id.location_info_lon, "location_info_lon")); // x坐标
		model.setY(fragmentUtil.getEditText(tView, R.id.location_info_lat, "location_info_lat"));// Y坐标
		model.setZBXT(fragmentUtil.getEditText(tView, R.id.location_info_zbxt, "location_info_zbxt"));// 坐标系统
		model.setREMARK(fragmentUtil.getEditText(tView, R.id.location_info_remark, "location_info_remark"));// 备注

		model.setINDEX_QSXZ(index_qsxz);
		model.setINDEX_CRFS(index_crfs);
		model.setINDEX_SFZKF(index_sfzkf);
		model.setINDEX_SFLYD(index_sflyd);
		model.setINDEX_CRQYT(index_crqyt);
		model.setINDEX_CRHYT(index_crhyt);
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
			saveId = model.getId();
		}
		return saveId;
	}

	@SuppressLint("SimpleDateFormat")
	@Override
	public void onClick(View view) {
		// TODO
		// 获取屏幕参数
		DisplayMetrics metric = new DisplayMetrics();
		getParentFragment().getActivity().getWindowManager().getDefaultDisplay().getMetrics(metric);
		int width = metric.widthPixels; // 屏幕宽度（像素）
		int height = metric.heightPixels; // 屏幕高度（像素）

		Uri imageUri = null;
		switch (view.getId()) {
		case R.id.fragment_collection_ibtn_location:
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
			String lonString = fragmentUtil.getEditText(tView, R.id.location_info_lon, "location_info_lon");
			String latString = fragmentUtil.getEditText(tView, R.id.location_info_lat, "location_info_lat");
			if (lonString.equals("") || latString.equals("")) {
				ToastUtil.ToastStr(getActivity(), "请补充完整经纬度信息", 2000);
			} else {
				locationInfo = new LocationInfo();
				locationInfo.setLat(Double.valueOf(latString));
				locationInfo.setLon(Double.valueOf(lonString));
				locationInfo.setName(fragmentUtil.getEditText(tView, R.id.edit_the_name, "edit_the_name"));
				locationInfo.setMark(fragmentUtil.getEditText(tView, R.id.location_info_remark, "location_info_remark"));
				try {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
					locationInfo.setDate("创建时间：" + df.format(new Date()));
				} catch (Exception e) {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
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
					imagePath = sb.toString();
					locationInfo.setImageUri(imagePath);
				}
				locationInfo.setState("任务状态：待上传");
				locationInfo.setStateCode(CollectType.State_Code_Not_Yet_Upload);
				locationInfo.setCollectionType(collectionType);
				locationInfo.setCollectionMainType(collectionMainType);
				locationInfo.setCollectionTableName(collectionTableName);
				int collectionId = saveModel();
				if (collectionId != 0) {
					locationInfo.setCollectionId(collectionId);
					try {
						locationInfo.saveThrows();
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
					}
				}
			}
		}).show();
	}

	/**
	 * 获取返回数据
	 */
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode != Activity.RESULT_OK) {
		}

		if (data != null) {
			if (data.getIntExtra("rCode", 0) == 1) {
				edit_lat = (EditText) tView.findViewById(R.id.location_info_lat);
				edit_lon = (EditText) tView.findViewById(R.id.location_info_lon);
				edit_lon.setText(data.getIntExtra("long", 0) / 1E6 + "");
				edit_lat.setText(data.getIntExtra("lat", 0) / 1E6 + "");
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
