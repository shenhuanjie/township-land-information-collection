package com.example.town_land_collect.fragment_market_demand;

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
import com.example.town_land_collect.model.market_demand.ModelCollectionMarketDemandHouseSell;
import com.example.town_land_collect.util.AttachmentUtil;
import com.example.town_land_collect.util.CollectType;
import com.example.town_land_collect.util.ComUtil;
import com.example.town_land_collect.util.CommonTypeUtil;
import com.example.town_land_collect.util.ImageUtil;
import com.example.town_land_collect.util.ToastUtil;

/**
 * 
 * @Title Collection_Market_Demand_House_Sell.java
 * @Package com.example.town_land_collect.fragment_market_demand
 * @Description ���س���������Ϣ
 * @author Shen.dev
 * @date 2015-10-14 ����5:13:56
 * @version V1.0
 */
@SuppressLint({ "CutPasteId", "ClickableViewAccessibility" })
public class Collection_Market_Demand_House_Sell extends Fragment implements OnClickListener, OnTouchListener {
	private String imagePathString = null;
	// TODO ͼƬ���
	private final String IMAGE_TYPE = "image/*";
	private final int IMAGE_CODE = 0; // �����IMAGE_CODE���Լ����ⶨ���
	private List<String> imagePathList = new ArrayList<String>();
	private int imagePathListIndex = 0;
	private Bitmap camorabitmap = null;
	private Button image_left;// ͼƬ��һ��
	private Button image_right;// ͼƬ��һ��
	// TODO
	private TextView text_page;
	private TextView text_total;
	private Integer curFragmentParent = 1;// fragment����
	private Integer curFragmentChildren = 0;// frament�Ӽ�

	/** ������Ϣ.�ؼ� **/
	private int index_nqsxz = 0;// ��Ȩ������
	private int index_sfesf = 0;// �Ƿ���ַ�
	private int index_sfzajf = 0;// �Ƿ�ת���ҷ�
	private int index_ntdyt = 0;// ��������;
	private int index_xqjzlx = 0;// ����������
	private int index_xqfwjg = 0;// �����ݽṹ
	private int index_xqfwcxd = 0;// �����ݳ��¶�
	private int index_xqzxcd = 0;// ����װ�޳̶�
	private int index_xqzzhx = 0;// ����סլ����
	private int index_xqptss = 0;// ����������ʩ

	/** ������Ϣ.�ؼ� **/
	private int index_tdjb = 0;// �������ؼ���

	/** ͨ�ò���.�ؼ� **/
	private ImageView image_photo;// ͼƬ��Ϣ
	private ImageButton imageButton_Location;// ѡ�����꣨��ͼ��
	private ImageButton imageButton_Save;// ��������
	private ImageButton imageButton_Clear;// ��ձ���
	private TextView textView_Tips;// ��ʾ��Ϣ

	/** ������Ϣ.�ؼ� **/
	private EditText edit_the_name;// ��¼����
	private EditText edit_the_code;// ��¼����
	/** ���س���������Ϣ **/
	private EditText edit_xqgmf;// ������
	private EditText edit_ntdzl;// ����������
	private Spinner edit_nqsxz;// ��Ȩ������
	private Spinner edit_sfesf;// �Ƿ���ַ�
	private Spinner edit_sfzajf;// �Ƿ�ת���ҷ�
	private EditText edit_tdsyknq;// ����ʣ��ʹ������
	private Spinner edit_ntdyt;// ��������;
	private EditText edit_xqgmsj;// ������ʱ��
	private EditText edit_xqcsmj;// �����������
	private EditText edit_xqksymjyq;// �����ʹ�����
	private EditText edit_xqrjl;// �����ݻ���
	private EditText edit_xqljkd;// �����ٽֿ���
	private EditText edit_xqljsd;// �����ٽ����
	private Spinner edit_xqjzlx;// ����������
	private EditText edit_xqjzcs;// ����������
	private Spinner edit_xqfwjg;// �����ݽṹ
	private EditText edit_xqjgsj;// ���󿢹�ʱ��
	private Spinner edit_xqfwcxd;// �����ݳ��¶�
	private EditText edit_xqzxsj;// ����װ��ʱ��
	private Spinner edit_xqzxcd;// ����װ�޳̶�
	private Spinner edit_xqzzhx;// ����סլ����
	private Spinner edit_xqptss;// ����������ʩ
	private EditText edit_xqzbjt;// �����ܱ߽�ͨ
	private EditText edit_xqdwmjsj;// ����λ����ۼ�
	private EditText edit_xqzsj;// �������ۼ�
	/** ������Ϣ.�ؼ� **/
	private Spinner edit_tdjb;// �������ؼ���
	private EditText edit_djqd;// ���ڵؼ�����
	private EditText edit_xzqdm;// ����������

	/** λ����Ϣ.�ؼ� **/
	private EditText edit_x;// X����
	private EditText edit_y;// Y����
	private EditText edit_zbxt;// ����ϵͳ
	private EditText edit_remark;// ��ע

	/** ȫ�ֱ��� **/
	private double lat;
	private double lon;

	/** ������Ϣ.���� **/
	private String value_the_name;// ��¼����
	private String value_the_code;// ��¼����
	/** ���س���������Ϣ **/
	private String value_xqgmf;// ������
	private String value_ntdzl;// ����������
	private String value_nqsxz;// ��Ȩ������
	private String value_sfesf;// �Ƿ���ַ�
	private String value_sfzajf;// �Ƿ�ת���ҷ�
	private String value_tdsyknq;// ����ʣ��ʹ������
	private String value_ntdyt;// ��������;
	private String value_xqgmsj;// ������ʱ��
	private String value_xqcsmj;// �����������
	private String value_xqksymjyq;// �����ʹ�����
	private String value_xqrjl;// �����ݻ���
	private String value_xqljkd;// �����ٽֿ���
	private String value_xqljsd;// �����ٽ����
	private String value_xqjzlx;// ����������
	private String value_xqjzcs;// ����������
	private String value_xqfwjg;// �����ݽṹ
	private String value_xqjgsj;// ���󿢹�ʱ��
	private String value_xqfwcxd;// �����ݳ��¶�
	private String value_xqzxsj;// ����װ��ʱ��
	private String value_xqzxcd;// ����װ�޳̶�
	private String value_xqzzhx;// ����סլ����
	private String value_xqptss;// ����������ʩ
	private String value_xqzbjt;// �����ܱ߽�ͨ
	private String value_xqdwmjsj;// ����λ����ۼ�
	private String value_xqzsj;// �������ۼ�

	/** ������Ϣ **/
	private String value_tdjb;// �������ؼ���
	private String value_djqd;// ���ڵؼ�����
	private String value_xzqdm;// ����������

	/** λ����Ϣ.���� **/
	private String value_x;// X����
	private String value_y;// Y����
	private String value_zbxt;// ����ϵͳ
	private String value_remark;// ��ע

	/** Spinner Dict **/
	private ArrayList<String> list_nqsxz = new ArrayList<String>();// ��Ȩ������
	private ArrayList<String> list_sfesf = new ArrayList<String>();// �Ƿ���ַ�
	private ArrayList<String> list_sfzajf = new ArrayList<String>();// �Ƿ�ת���ҷ�
	private ArrayList<String> list_ntdyt = new ArrayList<String>();// ��������;
	private ArrayList<String> list_xqjzlx = new ArrayList<String>();// ����������
	private ArrayList<String> list_xqfwjg = new ArrayList<String>();// �����ݽṹ
	private ArrayList<String> list_xqfwcxd = new ArrayList<String>();// �����ݳ��¶�
	private ArrayList<String> list_xqzxcd = new ArrayList<String>();// ����װ�޳̶�
	private ArrayList<String> list_xqzzhx = new ArrayList<String>();// ����סլ����
	private ArrayList<String> list_xqptss = new ArrayList<String>();// ����������ʩ
	private ArrayList<String> list_tdjb = new ArrayList<String>();// �������ؼ���

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = (View) inflater.inflate(R.layout.collection_market_demand_house_sell_frame, container, false);
		initView(view);
		initEditText(view);
		initSpinnerDict();
		initOnItemSelectedListener();
		return view;
	}

	/**
	 * 
	 * ˵������ʼ����ͼ
	 * 
	 * @param view
	 * @return void
	 */
	private void initView(View view) {
		image_photo = (ImageView) view.findViewById(R.id.fragment_collection_photo);
		image_photo.setOnClickListener(this);
		// TODO ͼƬѡ��ť�ؼ�
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
		textView_Tips.setText("���س���������Ϣ");
	}

	/**
	 * 
	 * ˵������ʼ������ؼ�
	 * 
	 * @param view
	 * @return void
	 */
	private void initEditText(View view) {

		/** ������Ϣ **/
		edit_the_name = (EditText) view.findViewById(R.id.edit_the_name);
		edit_the_code = (EditText) view.findViewById(R.id.edit_the_code);
		/** ���س���������Ϣ **/
		edit_xqgmf = (EditText) view.findViewById(R.id.edit_xqgmf);// ������
		edit_ntdzl = (EditText) view.findViewById(R.id.edit_ntdzl);// ����������
		edit_nqsxz = (Spinner) view.findViewById(R.id.edit_nqsxz);// ��Ȩ������
		edit_sfesf = (Spinner) view.findViewById(R.id.edit_sfesf);// �Ƿ���ַ�
		edit_sfzajf = (Spinner) view.findViewById(R.id.edit_sfzajf);// �Ƿ�ת���ҷ�
		edit_tdsyknq = (EditText) view.findViewById(R.id.edit_tdsyknq);// ����ʣ��ʹ������
		edit_ntdyt = (Spinner) view.findViewById(R.id.edit_ntdyt);// ��������;
		edit_xqgmsj = (EditText) view.findViewById(R.id.edit_xqgmsj);// ������ʱ��
		edit_xqcsmj = (EditText) view.findViewById(R.id.edit_xqcsmj);// �����������
		edit_xqksymjyq = (EditText) view.findViewById(R.id.edit_xqksymjyq);// �����ʹ�����
		edit_xqrjl = (EditText) view.findViewById(R.id.edit_xqrjl);// �����ݻ���
		edit_xqljkd = (EditText) view.findViewById(R.id.edit_xqljkd);// �����ٽֿ���
		edit_xqljsd = (EditText) view.findViewById(R.id.edit_xqljsd);// �����ٽ����
		edit_xqjzlx = (Spinner) view.findViewById(R.id.edit_xqjzlx);// ����������
		edit_xqjzcs = (EditText) view.findViewById(R.id.edit_xqjzcs);// ����������
		edit_xqfwjg = (Spinner) view.findViewById(R.id.edit_xqfwjg);// �����ݽṹ
		edit_xqjgsj = (EditText) view.findViewById(R.id.edit_xqjgsj);// ���󿢹�ʱ��
		edit_xqfwcxd = (Spinner) view.findViewById(R.id.edit_xqfwcxd);// �����ݳ��¶�
		edit_xqzxsj = (EditText) view.findViewById(R.id.edit_xqzxsj);// ����װ��ʱ��
		edit_xqzxcd = (Spinner) view.findViewById(R.id.edit_xqzxcd);// ����װ�޳̶�
		edit_xqzzhx = (Spinner) view.findViewById(R.id.edit_xqzzhx);// ����סլ����
		edit_xqptss = (Spinner) view.findViewById(R.id.edit_xqptss);// ����������ʩ
		edit_xqzbjt = (EditText) view.findViewById(R.id.edit_xqzbjt);// �����ܱ߽�ͨ
		edit_xqdwmjsj = (EditText) view.findViewById(R.id.edit_xqdwmjsj);// ����λ����ۼ�
		edit_xqzsj = (EditText) view.findViewById(R.id.edit_xqzsj);// �������ۼ�
		/** λ����Ϣ **/
		edit_x = (EditText) view.findViewById(R.id.location_info_lon);
		edit_y = (EditText) view.findViewById(R.id.location_info_lat);
		edit_zbxt = (EditText) view.findViewById(R.id.location_info_zbxt);
		edit_remark = (EditText) view.findViewById(R.id.location_info_remark);
		/** ������Ϣ **/
		edit_tdjb = (Spinner) view.findViewById(R.id.edit_tdjb);// spinner
		edit_djqd = (EditText) view.findViewById(R.id.edit_djqd);
		edit_xzqdm = (EditText) view.findViewById(R.id.edit_xzqdm);

		edit_xqjgsj.setOnTouchListener(this);
		edit_xqzxsj.setOnTouchListener(this);
	}

	/**
	 * ˵������ʼ��Spinner �ֵ��б�
	 * 
	 * @return void
	 */
	private void initSpinnerDict() {
		CommonTypeUtil typeUtil = new CommonTypeUtil();

		list_nqsxz = typeUtil.initList("qsxz");// ��Ȩ������
		list_sfesf = typeUtil.initList("yesno");// �Ƿ���ַ�
		list_sfzajf = typeUtil.initList("yesno");// �Ƿ�ת���ҷ�
		list_ntdyt = typeUtil.initList("tdyt");// ��������;
		list_xqjzlx = typeUtil.initList("jzlx");// ����������
		list_xqfwjg = typeUtil.initList("fwjg");// �����ݽṹ
		list_xqfwcxd = typeUtil.initList("fwcxd");// �����ݳ��¶�
		list_xqzxcd = typeUtil.initList("zxcd");// ����װ�޳̶�
		list_xqzzhx = typeUtil.initList("zzhx");// ����סլ����
		list_xqptss = typeUtil.initList("ptss");// ����������ʩ
		list_tdjb = typeUtil.initList("tdjb");// �������ؼ���

		value_nqsxz = list_nqsxz.get(0);
		value_sfesf = list_sfesf.get(0);
		value_sfzajf = list_sfzajf.get(0);
		value_ntdyt = list_ntdyt.get(0);
		value_xqjzlx = list_xqjzlx.get(0);
		value_xqfwjg = list_xqfwjg.get(0);
		value_xqfwcxd = list_xqfwcxd.get(0);
		value_xqzxcd = list_xqzxcd.get(0);
		value_xqzzhx = list_xqzzhx.get(0);
		value_xqptss = list_xqptss.get(0);
		value_tdjb = list_tdjb.get(0);
	}

	/**
	 * ˵������ʼ��������Ŀѡ���¼�
	 * 
	 * ����Spinner�¼�����
	 * 
	 * @return void
	 */
	private void initOnItemSelectedListener() {
		edit_nqsxz.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_nqsxz = list_nqsxz.get(index);
				index_nqsxz = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		edit_sfesf.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_sfesf = list_sfesf.get(index);
				index_sfesf = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		edit_sfzajf.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_sfzajf = list_sfzajf.get(index);
				index_sfzajf = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		edit_ntdyt.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_ntdyt = list_ntdyt.get(index);
				index_ntdyt = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		edit_xqjzlx.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_xqjzlx = list_xqjzlx.get(index);
				index_xqjzlx = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		edit_xqfwjg.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_xqfwjg = list_xqfwjg.get(index);
				index_xqfwjg = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		edit_xqfwcxd.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_xqfwcxd = list_xqfwcxd.get(index);
				index_xqfwcxd = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		edit_xqzxcd.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_xqzxcd = list_xqzxcd.get(index);
				index_xqzxcd = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		edit_xqzzhx.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_xqzzhx = list_xqzzhx.get(index);
				index_xqzzhx = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		edit_xqptss.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_xqptss = list_xqptss.get(index);
				index_xqptss = index;
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
	}

	@SuppressLint("SimpleDateFormat")
	@Override
	public void onClick(View arg0) {
		// TODO
		// ��ȡ��Ļ����
		DisplayMetrics metric = new DisplayMetrics();
		getParentFragment().getActivity().getWindowManager().getDefaultDisplay().getMetrics(metric);
		int width = metric.widthPixels; // ��Ļ���ȣ����أ�
		int height = metric.heightPixels; // ��Ļ�߶ȣ����أ�

		int id = arg0.getId();
		Uri imageUri = null;
		switch (id) {
		case R.id.fragment_collection_ibtn_location:
			// �򿪵�ͼλ��ѡ��
			Intent intent = new Intent(getActivity(), MyMapActivity.class);
			LocationInfo locationInfo = null;
			intent.putExtra("curFragmentParent", curFragmentParent);
			intent.putExtra("curFragmentChildren", curFragmentChildren);
			intent.putExtra("rCode", 1);
			startActivityForResult(intent, ComUtil.RequestCode_Map);
			break;
		// TODO ͼƬ��ؿؼ�
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
			// ������Ϣ�ı��ش洢
			if (edit_x.getText().toString().equals("") || edit_y.getText().toString().equals("")) {
				ToastUtil.ToastStr(getActivity(), "�벹��������γ����Ϣ", 2000);
			} else {
				locationInfo = new LocationInfo();
				locationInfo.setLat(lat);
				locationInfo.setLon(lon);
				locationInfo.setName(edit_the_name.getText().toString());
				locationInfo.setMark(edit_remark.getText().toString());
				try {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");// �������ڸ�ʽ
					locationInfo.setDate("����ʱ�䣺" + df.format(new Date()));
				} catch (Exception e) {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// �������ڸ�ʽ
					locationInfo.setDate("����ʱ�䣺" + df.format(new Date()));
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
				locationInfo.setState("����״̬�����ϴ�");
				locationInfo.setStateCode(CollectType.State_Code_Not_Yet_Upload);// ���ϴ�
				locationInfo.setCollectionType(CollectType.Collection_Market_Demand_House_Sell);
				// ����ID
				locationInfo.setCollectionMainType(CollectType.Demand);
				locationInfo.setCollectionTableName(CollectType.Collection_Market_Demand_House_Sell_Tablename);// ����
				// �洢��ʵ������
				int collectionId = saveCollectionInfo();
				if (collectionId != 0) {
					locationInfo.setCollectionId(collectionId);
					try {
						locationInfo.saveThrows();// ����LogCat��׽�쳣��Ϣ
					} catch (DataSupportException e) {
						Log.d("TAG", e.toString());
						ToastUtil.ToastStr(getActivity(), e.toString(), 2000);
					}
					if (locationInfo.save()) {
						ToastUtil.ToastStr(getActivity(), "�洢�ɹ�", 2000);
						// �������������Ϣ
						AttachmentUtil attachmentUtil = new AttachmentUtil();
						attachmentUtil.saveAttachmentInfo(locationInfo);
					} else {
						ToastUtil.ToastStr(getActivity(), "�洢ʧ��", 2000);
					}
				} else {
					ToastUtil.ToastStr(getActivity(), "�洢ʧ��", 2000);
				}
			}
			break;
		// ��ձ���
		case R.id.fragment_collection_ibtn_clear:
			break;
		}
	}

	// TODO ��������
	private void getPhotoRight(int width, int height) {
		if (imagePathList.size() != 0) {
			if (imagePathListIndex != imagePathList.size() - 1) {
				// ���ж��Ƿ��Ѿ�����
				if (camorabitmap != null && !camorabitmap.isRecycled()) {
					camorabitmap.recycle();
					camorabitmap = null;
				}
				imagePathListIndex = imagePathListIndex + 1;
				String filePath = imagePathList.get(imagePathListIndex);
				camorabitmap = ImageUtil.getImageThumbnail(filePath, width, height);
				image_photo.setImageBitmap(camorabitmap);
				// TODO
				text_page.setText("��" + (imagePathListIndex + 1) + "��");
				text_total.setText(",��" + imagePathList.size() + "��");
			}
		}
	}

	private void getPhotoLeft(int width, int height) {
		if (imagePathList.size() != 0) {
			if (imagePathListIndex != 0) {
				// ���ж��Ƿ��Ѿ�����
				if (camorabitmap != null && !camorabitmap.isRecycled()) {
					camorabitmap.recycle();
					camorabitmap = null;
				}
				imagePathListIndex = imagePathListIndex - 1;
				String filePath = imagePathList.get(imagePathListIndex);
				camorabitmap = ImageUtil.getImageThumbnail(filePath, width, height);
				image_photo.setImageBitmap(camorabitmap);
				// TODO
				text_page.setText("��" + (imagePathListIndex + 1) + "��");
				text_total.setText(",��" + imagePathList.size() + "��");
			}
		}
	}

	private void getPhotoImage() {
		String[] items = { "����", "ѡ��ͼƬ", "ɾ��" };
		new AlertDialog.Builder(getActivity()).setTitle("ѡ�����").setItems(items, new DialogInterface.OnClickListener() {
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
					// ʹ��intent����ϵͳ�ṩ����Ṧ�ܣ�ʹ��startActivityForResult��Ϊ�˻�ȡ�û�ѡ���ͼƬ
					Intent getAlbum = new Intent(Intent.ACTION_GET_CONTENT);
					getAlbum.setType(IMAGE_TYPE);
					startActivityForResult(getAlbum, IMAGE_CODE);
				} else if (which == 2) {
					DisplayMetrics metric = new DisplayMetrics();
					getParentFragment().getActivity().getWindowManager().getDefaultDisplay().getMetrics(metric);
					int width = metric.widthPixels; // ��Ļ���ȣ����أ�
					int height = metric.heightPixels; // ��Ļ�߶ȣ����أ�
					if (imagePathList.size() != 0) {
						// ���ж��Ƿ��Ѿ�����
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
						text_page.setText("��" + (imagePathListIndex + 1) + "��");
						text_total.setText(",��" + imagePathList.size() + "��");
					}
				}
			}
		}).show();
	}

	/**
	 * ˵��������ؼ�ֵ�����������ڱ���ʵ��
	 * 
	 * @return void
	 */
	private void setCollectionInfo() {
		/** ������Ϣ.���� **/
		value_the_name = edit_the_name.getText().toString();// ��¼����
		value_the_code = edit_the_code.getText().toString();// ��¼����
		/** ���س���������Ϣ **/
		value_xqgmf = edit_xqgmf.getText().toString();// ������
		value_ntdzl = edit_ntdzl.getText().toString();// ����������
		value_tdsyknq = edit_tdsyknq.getText().toString();// ����ʣ��ʹ������
		value_xqgmsj = edit_xqgmsj.getText().toString();// ������ʱ��
		value_xqcsmj = edit_xqcsmj.getText().toString();// �����������
		value_xqksymjyq = edit_xqksymjyq.getText().toString();// �����ʹ�����
		value_xqrjl = edit_xqrjl.getText().toString();// �����ݻ���
		value_xqljkd = edit_xqljkd.getText().toString();// �����ٽֿ���
		value_xqljsd = edit_xqljsd.getText().toString();// �����ٽ����
		value_xqjzcs = edit_xqjzcs.getText().toString();// ����������
		value_xqjgsj = edit_xqjgsj.getText().toString();// ���󿢹�ʱ��
		value_xqzxsj = edit_xqzxsj.getText().toString();// ����װ��ʱ��
		value_xqzbjt = edit_xqzbjt.getText().toString();// �����ܱ߽�ͨ
		value_xqdwmjsj = edit_xqdwmjsj.getText().toString();// ����λ����ۼ�
		value_xqzsj = edit_xqzsj.getText().toString();// �������ۼ�

		/** λ����Ϣ.���� **/
		value_x = edit_x.getText().toString();// ����
		value_y = edit_y.getText().toString();// γ��
		value_zbxt = edit_zbxt.getText().toString();// ����ϵͳ
		value_remark = edit_remark.getText().toString();// ��ע
		/** ������Ϣ **/
		value_djqd = edit_djqd.getText().toString();// ���ڵؼ�����
		value_xzqdm = edit_xzqdm.getText().toString();// ���������루�弶��������
	}

	/**
	 * ˵��������ɼ���Ϣ���ֱ�
	 * 
	 * @return id
	 */
	private int saveCollectionInfo() {
		int result = 0;
		setCollectionInfo();
		ModelCollectionMarketDemandHouseSell model = new ModelCollectionMarketDemandHouseSell();
		/** ������Ϣ **/
		model.setTHENAME(value_the_name);// ��¼����
		model.setTHECODE(value_the_code);// ��¼����
		/** ���س���������Ϣ **/
		model.setXQGMF(value_xqgmf);// ������
		model.setNTDZL(value_ntdzl);// ����������
		model.setNQSXZ(value_nqsxz);// ��Ȩ������
		model.setSFESF(value_sfesf);// �Ƿ���ַ�
		model.setSFZAJF(value_sfzajf);// �Ƿ�ת���ҷ�
		model.setTDSYKNQ(value_tdsyknq);// ����ʣ��ʹ������
		model.setNTDYT(value_ntdyt);// ��������;
		model.setXQGMSJ(value_xqgmsj);// ������ʱ��
		model.setXQCSMJ(value_xqcsmj);// �����������
		model.setXQKSYMJYQ(value_xqksymjyq);// �����ʹ�����
		model.setXQRJL(value_xqrjl);// �����ݻ���
		model.setXQLJKD(value_xqljkd);// �����ٽֿ���
		model.setXQLJSD(value_xqljsd);// �����ٽ����
		model.setXQJZLX(value_xqjzlx);// ����������
		model.setXQJZCS(value_xqjzcs);// ����������
		model.setXQFWJG(value_xqfwjg);// �����ݽṹ
		model.setXQJGSJ(value_xqjgsj);// ���󿢹�ʱ��
		model.setXQFWCXD(value_xqfwcxd);// �����ݳ��¶�
		model.setXQZXSJ(value_xqzxsj);// ����װ��ʱ��
		model.setXQZXCD(value_xqzxcd);// ����װ�޳̶�
		model.setXQZZHX(value_xqzzhx);// ����סլ����
		model.setXQPTSS(value_xqptss);// ����������ʩ
		model.setXQZBJT(value_xqzbjt);// �����ܱ߽�ͨ
		model.setXQDWMJSJ(value_xqdwmjsj);// ����λ����ۼ�
		model.setXQZSJ(value_xqzsj);// �������ۼ�
		/** λ����Ϣ **/
		model.setX(value_x);// ����
		model.setY(value_y);// γ��
		model.setZBXT(value_zbxt);// ����ϵͳ
		model.setREMARK(value_remark);// ��ע

		/** ������Ϣ **/
		model.setTDJB(value_tdjb); // �������ؼ���
		model.setDJQD(value_djqd);// ���ڵؼ�����
		model.setXZQDM(value_xzqdm);// ���������루�弶��������

		/** ��ֵ�����ֶ� **/
		model.setIndex_nqsxz(index_nqsxz);// ��Ȩ������
		model.setIndex_sfesf(index_sfesf);// �Ƿ���ַ�
		model.setIndex_sfzajf(index_sfzajf);// �Ƿ�ת���ҷ�
		model.setIndex_ntdyt(index_ntdyt);// ��������;
		model.setIndex_xqjzlx(index_xqjzlx);// ����������
		model.setIndex_xqfwjg(index_xqfwjg);// �����ݽṹ
		model.setIndex_xqfwcxd(index_xqfwcxd);// �����ݳ��¶�
		model.setIndex_xqzxcd(index_xqzxcd);// ����װ�޳̶�
		model.setIndex_xqzzhx(index_xqzzhx);// ����סլ����
		model.setIndex_xqptss(index_xqptss);// ����������ʩ
		model.setIndex_tdjb(index_tdjb);// �������ؼ���
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

			if (v.getId() == R.id.edit_xqjgsj) {
				final int inType = edit_xqjgsj.getInputType();
				edit_xqjgsj.setInputType(InputType.TYPE_NULL);
				edit_xqjgsj.onTouchEvent(event);
				edit_xqjgsj.setInputType(inType);
				edit_xqjgsj.setSelection(edit_xqjgsj.getText().length());

				builder.setTitle("ѡȡ����ʱ��");
				builder.setPositiveButton("ȷ  ��", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

						StringBuffer sb = new StringBuffer();
						sb.append(String.format("%d-%02d-%02d", datePicker.getYear(), datePicker.getMonth() + 1, datePicker.getDayOfMonth()));
						sb.append("  00:00:00");

						edit_xqjgsj.setText(sb);
						edit_xqjgsj.requestFocus();

						dialog.cancel();
					}
				});

			} else if (v.getId() == R.id.edit_xqzxsj) {
				final int inType = edit_xqzxsj.getInputType();
				edit_xqzxsj.setInputType(InputType.TYPE_NULL);
				edit_xqzxsj.onTouchEvent(event);
				edit_xqzxsj.setInputType(inType);
				edit_xqzxsj.setSelection(edit_xqzxsj.getText().length());

				builder.setTitle("ѡȡ����ʱ��");
				builder.setPositiveButton("ȷ  ��", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

						StringBuffer sb = new StringBuffer();
						sb.append(String.format("%d-%02d-%02d", datePicker.getYear(), datePicker.getMonth() + 1, datePicker.getDayOfMonth()));
						sb.append("  00:00:00");

						edit_xqzxsj.setText(sb);
						edit_xqzxsj.requestFocus();

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
	 * ��ȡ��������
	 */
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (resultCode != Activity.RESULT_OK) {
			// result is not correct
			// return;
		}

		// ��ȡ���ص�������Ϣ
		if (data != null) {
			if (data.getIntExtra("rCode", 0) == 1) {
				lat = data.getIntExtra("lat", 0) / 1E6;
				lon = data.getIntExtra("long", 0) / 1E6;
				edit_x.setText(lon + "");
				edit_y.setText(lat + "");
			}
		}

		// TODO
		// ��ȡ���ص�ͼƬ����
		if (requestCode == ComUtil.RequestCode_Photo_Value) {

			DisplayMetrics metric = new DisplayMetrics();
			getParentFragment().getActivity().getWindowManager().getDefaultDisplay().getMetrics(metric);
			int width = metric.widthPixels; // ��Ļ���ȣ����أ�
			int height = metric.heightPixels; // ��Ļ�߶ȣ����أ�

			try {
				// ���ж��Ƿ��Ѿ�����
				if (camorabitmap != null && !camorabitmap.isRecycled()) {
					camorabitmap.recycle();
					camorabitmap = null;
				}
				// �������ڱ��ص�ͼƬȡ������������С����ʾ�ڽ�����
				camorabitmap = ImageUtil.getImageThumbnail(Environment.getExternalStorageDirectory() + "/temp.jpg", width, height);
				image_photo.setImageBitmap(camorabitmap);
				String filePath = ImageUtil.copyFile(Environment.getExternalStorageDirectory() + "/temp.jpg",
						Environment.getExternalStorageDirectory() + "/");
				imagePathList.add(filePath);
				imagePathListIndex = imagePathList.size() - 1;
				// TODO
				text_page.setText("��" + (imagePathListIndex + 1) + "��");
				text_total.setText(",��" + imagePathList.size() + "��");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (requestCode == ComUtil.RequestCode_Album) {
			DisplayMetrics metric = new DisplayMetrics();
			getParentFragment().getActivity().getWindowManager().getDefaultDisplay().getMetrics(metric);
			int width = metric.widthPixels; // ��Ļ���ȣ����أ�
			int height = metric.heightPixels; // ��Ļ�߶ȣ����أ�
			try {
				// ���ж��Ƿ��Ѿ�����
				if (camorabitmap != null && !camorabitmap.isRecycled()) {
					camorabitmap.recycle();
					camorabitmap = null;
				}
				Uri originalUri = data.getData(); // ���ͼƬ��uri
				String filePath = ImageUtil.getImageAbsolutePath(getActivity(), originalUri);
				// �������ڱ��ص�ͼƬȡ������������С����ʾ�ڽ�����
				camorabitmap = ImageUtil.getImageThumbnail(filePath, width, height);
				image_photo.setImageBitmap(camorabitmap);
				imagePathList.add(filePath);
				imagePathListIndex = imagePathList.size() - 1;
				// TODO
				text_page.setText("��" + (imagePathListIndex + 1) + "��");
				text_total.setText(",��" + imagePathList.size() + "��");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}