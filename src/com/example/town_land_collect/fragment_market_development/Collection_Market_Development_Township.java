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
import com.example.town_land_collect.model.market_development.ModelCollectionMarketDevelopmentTownship;
import com.example.town_land_collect.util.CollectType;
import com.example.town_land_collect.util.ComUtil;
import com.example.town_land_collect.util.ImageUtil;
import com.example.town_land_collect.util.ToastUtil;

/**
 * @Title Collection_Market_Economic_Development_Township.java
 * @Package com.example.town_land_collect.fragment_market_economic_development
 * @Description ������ᾭ�÷�չ��Ϣ
 * @author Shen.dev
 * @date 2015-10-14 ����5:39:15
 * @version V1.0
 */
@SuppressLint({ "CutPasteId", "ClickableViewAccessibility" })
public class Collection_Market_Development_Township extends Fragment implements OnClickListener, OnTouchListener {
	private String imagePathString = null;
	private Integer curFragmentParent = 1;// fragment����
	private Integer curFragmentChildren = 0;// frament�Ӽ�

	/** ������Ϣ.�ؼ� **/
	// private int index_qsxz = 0;// Ȩ������

	// TODO:����Index��Ϣ
	// /** ת��/������Ϣ **/
	// private int index_market_business_transfer_farm_in_zrfs = 0;// ת�÷�ʽ_Index

	/** ������Ϣ.�ؼ� **/
	// private int index_hxwkfsp = 0;// �����⿪��ˮƽ
	// private int index_hxnkfsp = 0;// �����ڿ���ˮƽ
	// private int index_tdjb = 0;// �������ؼ���

	/** ͨ�ò���.�ؼ� **/
	private ImageView image_photo;// ͼƬ��Ϣ
//	private ImageButton imageButton_Location;// ѡ�����꣨��ͼ��
	private ImageButton imageButton_Save;// ������
	private ImageButton imageButton_Clear;// ��ձ�
	private TextView textView_Tips;// ��ʾ��Ϣ

	/** ������Ϣ.�ؼ� **/
	private EditText edit_the_name;// ��¼����
	private EditText edit_the_code;// ��¼����
	// private EditText edit_tdsyz;// ����ʹ����
	// private EditText edit_tdzsh;// ����֤���
	// private EditText edit_tdzl;// ��������
	// private Spinner edit_qsxz;// Ȩ������

	// TODO ����ҳ��ؼ�
	// /** ת��/������Ϣ **/
	// private EditText edit_market_business_transfer_farm_in_zrsj;// ת��ʱ��
	// private EditText edit_market_business_transfer_farm_in_zrf;// ת�÷�
	// private EditText edit_market_business_transfer_farm_in_srf;// ���÷�
	// private Spinner edit_market_business_transfer_farm_in_zrfs;// ת�÷�ʽ
	// private EditText edit_market_business_transfer_farm_in_tdzrnj;// ����ת�����
	// private EditText edit_market_business_transfer_farm_in_zrqyt;// ת��ǰ��;
	// private EditText edit_market_business_transfer_farm_in_zrhyt;// ת�ú���;
	// private EditText edit_market_business_transfer_farm_in_tdsysynq;//
	// ����ʣ��ʹ������
	// private EditText edit_market_business_transfer_farm_in_tdzrdj;// ����ת�õ���
	// private EditText edit_market_business_transfer_farm_in_tdzrzj;// ����ת���ܼ�

	/** ������Ϣ.�ؼ� **/
	// private EditText edit_rjl;// �ݻ���
	// private Spinner edit_hxwkfsp;// �����⿪��ˮƽ
	// private Spinner edit_hxnkfsp;// �����ڿ���ˮƽ
	// private Spinner edit_tdjb;// �������ؼ���
	// private EditText edit_djqd;// ���ڵؼ�����
	// private EditText edit_xzqdm;// ����������

	// /** λ����Ϣ.�ؼ� **/
	// private EditText edit_x;// X����
	// private EditText edit_y;// Y����
	// private EditText edit_bjdmc;// ��ǵ�����
	// private EditText edit_zbxt;// ����ϵͳ
	// private EditText edit_remark;// ��ע

	/**
	 * ��ע��λ�����
	 */
	// private EditText editText_Location_Latitude;
	// private EditText editText_Location_Longtitude;
	// private EditText editText_Location_BZDMC;// ��ע������
	// private EditText editText_Location_Mark;
	// private EditText editText_Time_ZRSJ;

	/** ȫ�ֱ��� **/
	// private double lat;
//	private double lon;

	/** ������Ϣ.���� **/
	private String value_the_name;// ��¼����
	private String value_the_code;// ��¼����

	// private String value_tdsyz;// ����ʹ����
	// private String value_tdzsh;// ����֤���
	// private String value_tdzl;// ��������
	// private String value_qsxz;// Ȩ������

	// TODO ����ؼ�����
	// /** ת��/������Ϣ.���� **/
	// private String market_business_transfer_farm_in_zrsj;// ת��ʱ��
	// private String market_business_transfer_farm_in_zrf;// ת�÷�
	// private String market_business_transfer_farm_in_srf;// ���÷�
	// private String market_business_transfer_farm_in_zrfs;// ת�÷�ʽ
	// private String market_business_transfer_farm_in_tdzrnj;// ����ת�����
	// private String market_business_transfer_farm_in_zrqyt;// ת��ǰ��;
	// private String market_business_transfer_farm_in_zrhyt;// ת�ú���;
	// private String market_business_transfer_farm_in_tdsysynq;// ����ʣ��ʹ������
	// private String market_business_transfer_farm_in_tdzrdj;// ����ת�õ���
	// private String market_business_transfer_farm_in_tdzrzj;// ����ת���ܼ�

	/** ������Ϣ **/
	// private String value_rjl;// �ݻ���
	// private String value_hxwkfsp;// �����⿪��ˮƽ
	// private String value_hxnkfsp;// �����ڿ���ˮƽ
	// private String value_tdjb;// �������ؼ���
	// private String value_djqd;// ���ڵؼ�����
	// private String value_xzqdm;// ����������

	// /** λ����Ϣ.���� **/
	// private String value_x;// X����
	// private String value_y;// Y����
	// private String value_bjdmc;// ��ǵ�����
	// private String value_zbxt;// ����ϵͳ
	// private String value_remark;// ��ע

	/** Spinner Dict **/
	/** ������Ϣ .Spinner **/
	// private ArrayList<String> list_qsxz = new ArrayList<String>();// Ȩ������

	// TODO ���������б�
	// /** ת��/������Ϣ .Spinner **/
	// private ArrayList<String>
	// market_business_transfer_farm_in_zrfs_spinne_array_list = new
	// ArrayList<String>();// ת�÷�ʽ

	/** ������Ϣ .Spinner **/
	// private ArrayList<String> list_hxwkfsp = new ArrayList<String>();//
	// �����⿪��ˮƽ
	// private ArrayList<String> list_hxnkfsp = new ArrayList<String>();//
	// �����ڿ���ˮƽ
	// private ArrayList<String> list_tdjb = new ArrayList<String>();// �������ؼ���

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = (View) inflater.inflate(R.layout.collection_market_development_township_frame, container, false);
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
		// imageButton_Location = (ImageButton)
		// view.findViewById(R.id.fragment_collection_ibtn_location);
		// imageButton_Location.setOnClickListener(this);
		imageButton_Save = (ImageButton) view.findViewById(R.id.fragment_collection_ibtn_save);
		imageButton_Clear = (ImageButton) view.findViewById(R.id.fragment_collection_ibtn_clear);
		imageButton_Clear.setOnClickListener(this);
		imageButton_Save.setOnClickListener(this);
		textView_Tips = (TextView) view.findViewById(R.id.fragment_collection_tv_tips);
		textView_Tips.setText("������ᾭ�÷�չ��Ϣ");// TODO �޸���ʾ��Ϣ
	}

	/**
	 * 
	 * ˵������ʼ������ؼ�
	 * 
	 * @param view
	 * @return void
	 */
	private void initEditText(View view) {
		// editText_Time_ZRSJ = (EditText)
		// view.findViewById(R.id.transfer_farm_in_ZRSJ);
		// editText_Time_ZRSJ.setOnTouchListener(this);
		// /**
		// * ��ע��λ�����
		// */
		// editText_Location_Longtitude = (EditText)
		// view.findViewById(R.id.location_info_Lon);
		// editText_Location_Latitude = (EditText)
		// view.findViewById(R.id.location_info_Lat);
		// editText_Location_BZDMC = (EditText)
		// view.findViewById(R.id.location_info_BJDMC);
		// editText_Location_Mark = (EditText)
		// view.findViewById(R.id.location_info_Mark);

		/** ������Ϣ **/
		edit_the_name = (EditText) view.findViewById(R.id.edit_the_name);
		edit_the_code = (EditText) view.findViewById(R.id.edit_the_code);
		// edit_tdsyz = (EditText) view.findViewById(R.id.edit_tdsyz);
		// edit_tdzsh = (EditText) view.findViewById(R.id.edit_tdzsh);
		// edit_tdzl = (EditText) view.findViewById(R.id.edit_tdzl);
		// edit_qsxz = (Spinner) view.findViewById(R.id.edit_qsxz);

		// TODO �󶨿ؼ�
		// /** ת��/������Ϣ **/
		// edit_market_business_transfer_farm_in_zrsj = (EditText)
		// view.findViewById(R.id.transfer_farm_in_ZRSJ);// ת��ʱ��
		// edit_market_business_transfer_farm_in_zrf = (EditText)
		// view.findViewById(R.id.transfer_farm_in_ZRF);// ת�÷�
		// edit_market_business_transfer_farm_in_srf = (EditText)
		// view.findViewById(R.id.transfer_farm_in_SRF);// ���÷�
		// edit_market_business_transfer_farm_in_zrfs = (Spinner)
		// view.findViewById(R.id.transfer_farm_in_ZRFS);// ת�÷�ʽ
		// edit_market_business_transfer_farm_in_tdzrnj = (EditText)
		// view.findViewById(R.id.transfer_farm_in_TDZRMJ);// ����ת�����
		// edit_market_business_transfer_farm_in_zrqyt = (EditText)
		// view.findViewById(R.id.transfer_farm_in_ZRQYT);// ת��ǰ��;
		// edit_market_business_transfer_farm_in_zrhyt = (EditText)
		// view.findViewById(R.id.transfer_farm_in_ZRHYT);// ת�ú���;
		// edit_market_business_transfer_farm_in_tdsysynq = (EditText)
		// view.findViewById(R.id.transfer_farm_in_TDSYSYNQ);// ����ʣ��ʹ������
		// edit_market_business_transfer_farm_in_tdzrdj = (EditText)
		// view.findViewById(R.id.transfer_farm_in_TDZRDJ);// ����ת�õ���
		// edit_market_business_transfer_farm_in_tdzrzj = (EditText)
		// view.findViewById(R.id.transfer_farm_in_TDZRZJ);// ����ת���ܼ�

		/** λ����Ϣ **/
		// edit_x = (EditText) view.findViewById(R.id.ocation_info_lon);
		// edit_y = (EditText) view.findViewById(R.id.ocation_info_lat);
		// edit_bjdmc = (EditText) view.findViewById(R.id.location_info_bjdmc);
		// edit_zbxt = (EditText) view.findViewById(R.id.location_info_zbxt);
		// edit_remark = (EditText)
		// view.findViewById(R.id.location_info_remark);
		/** ������Ϣ **/
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
	 * ˵������ʼ��Spinner �ֵ��б�
	 * 
	 * @return void
	 */
	private void initSpinnerDict() {
		// /** Ȩ������ **/
		// value_qsxz = "10";
		// list_qsxz.add("10");// ������������Ȩ
		// list_qsxz.add("20");// ��������ʹ��Ȩ
		// list_qsxz.add("30");// ������������Ȩ
		// list_qsxz.add("40");// ��������ʹ��Ȩ
		// list_qsxz.add("31");// ����С��
		// list_qsxz.add("32");// �弯�徭����֯
		// list_qsxz.add("33");// �缯�徭����֯
		// list_qsxz.add("34");// ����ũ���徭����֯

		// TODO ���������б��ֵ�����
		// /** ת�÷�ʽ **/
		// market_business_transfer_farm_in_zrfs = "01";
		// market_business_transfer_farm_in_zrfs_spinne_array_list.add("01");//
		// �б�
		// market_business_transfer_farm_in_zrfs_spinne_array_list.add("02");//
		// ����
		// market_business_transfer_farm_in_zrfs_spinne_array_list.add("03");//
		// ����
		// market_business_transfer_farm_in_zrfs_spinne_array_list.add("04");//
		// Э��

		// /** �����⿪��ˮƽ **/
		// value_hxwkfsp = "3";
		// list_hxwkfsp.add("3");// ��ͨ
		// list_hxwkfsp.add("4");// ��ͨ
		// list_hxwkfsp.add("5");// ��ͨ
		// list_hxwkfsp.add("6");// ��ͨ
		// list_hxwkfsp.add("7");// ��ͨ
		// list_hxwkfsp.add("8");// ��ͨ
		// list_hxwkfsp.add("9");// ��ͨ
		// /** �����ڿ���ˮƽ **/
		// value_hxnkfsp = "3";
		// list_hxnkfsp.add("3");// ��ͨһƽ
		// list_hxnkfsp.add("4");// ��ͨһƽ
		// list_hxnkfsp.add("5");// ��ͨһƽ
		// list_hxnkfsp.add("6");// ��ͨһƽ
		// list_hxnkfsp.add("7");// ��ͨһƽ
		// list_hxnkfsp.add("8");// ��ͨһƽ
		// list_hxnkfsp.add("9");// ��ͨһƽ
		/** �������ؼ��� **/
		// value_tdjb = "1";
		// list_tdjb.add("1");// һ��
		// list_tdjb.add("2");// ����
		// list_tdjb.add("3");// ����
		// list_tdjb.add("4");// �ļ�
		// list_tdjb.add("5");// �弶
		// list_tdjb.add("6");// ����
		// list_tdjb.add("7");// �߼�
		// list_tdjb.add("8");// �˼�
		// list_tdjb.add("9");// �ż�
		// list_tdjb.add("10");// ʮ��
		// list_tdjb.add("11");// ʮһ��
		// list_tdjb.add("12");// ʮ����
		// list_tdjb.add("13");// ʮ����
		// list_tdjb.add("14");// ʮ�ļ�
		// list_tdjb.add("15");// ʮ�弶
		// list_tdjb.add("16");// ʮ����
		// list_tdjb.add("17");// ʮ�߼�
		// list_tdjb.add("18");// ʮ�˼�
		// list_tdjb.add("0");// δ��������
	}

	/**
	 * ˵������ʼ��������Ŀѡ���¼�
	 * 
	 * ���Spinner�¼�����
	 * 
	 * @return void
	 */
	private void initOnItemSelectedListener() {

		// /** Ȩ������ **/
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

		// TODO ʵ�������б�ֵ
		// /** ���÷�ʽ�����б� **/
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

		// /** �����⿪��ˮƽ **/
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
		// /** �����ڿ���ˮƽ **/
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
		/** �������ؼ��� **/
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
			// �򿪵�ͼλ��ѡ��
			Intent intent = new Intent(getActivity(), MyMapActivity.class);
			LocationInfo locationInfo = null;
			intent.putExtra("curFragmentParent", curFragmentParent);
			intent.putExtra("curFragmentChildren", curFragmentChildren);
			intent.putExtra("rCode", 1);
			startActivityForResult(intent, ComUtil.RequestCode_Map);
			break;
		case R.id.fragment_collection_photo:
			// 1*���������,����ϵͳ������:����ʱ,���ĵõ���Ƭ���浽����(δ��С):
			Intent getImageByCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
			if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
				imageUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), "temp.jpg"));
			} else {
				imageUri = Uri.fromFile(new File(File.separator, "temp.jpg"));
			}

			// 2*ָ����Ƭ����·��(SD��),temp.jpgΪһ����ʱ�ļ�,ÿ�����պ����ͼƬ���ᱻ�滻
			getImageByCamera.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
			startActivityForResult(getImageByCamera, ComUtil.RequestCode_Photo);
			break;
		case R.id.fragment_collection_ibtn_save:
			// ����Ϣ�ı��ش洢
			locationInfo = new LocationInfo();
			locationInfo.setName(edit_the_name.getText().toString());
			try {
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");// �������ڸ�ʽ
				locationInfo.setDate("����ʱ�䣺" + df.format(new Date()));
			} catch (Exception e) {
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// �������ڸ�ʽ
				locationInfo.setDate("����ʱ�䣺" + df.format(new Date()));
				e.printStackTrace();
			}
			if (imagePathString != null) {
				locationInfo.setImageUri(imagePathString);// ��ͼƬ
			}
			locationInfo.setState("����״̬�����ϴ�");
			locationInfo.setStateCode(CollectType.State_Code_Not_Yet_Upload);// ���ϴ�
			locationInfo.setCollectionType(CollectType.Collection_Market_Development_Township);// TODO
																								// ����ID
			locationInfo.setCollectionMainType(CollectType.Development);// TODO
			locationInfo.setCollectionTableName(CollectType.Collection_Market_Development_Township_Tablename);// ����
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
				} else {
					ToastUtil.ToastStr(getActivity(), "�洢ʧ��", 2000);
				}
			} else {
				ToastUtil.ToastStr(getActivity(), "�洢ʧ��", 2000);
			}
			break;
		// ��ձ�
		case R.id.fragment_collection_ibtn_clear:
			break;
		}
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
		// value_tdsyz = edit_tdsyz.getText().toString();// ����������
		// value_tdzsh = edit_tdzsh.getText().toString();// ����֤���
		// value_tdzl = edit_tdzl.getText().toString();// ��������

		// TODO ����ʵ������
		// /** ����/������Ϣ.���� **/
		// if (edit_market_business_transfer_farm_in_zrsj != null
		// && edit_market_business_transfer_farm_in_zrsj.getText() != null) {
		// market_business_transfer_farm_in_zrsj =
		// edit_market_business_transfer_farm_in_zrsj.getText().toString();//
		// ת��ʱ��
		// }
		// if (edit_market_business_transfer_farm_in_zrf != null
		// && edit_market_business_transfer_farm_in_zrf.getText() != null) {
		// market_business_transfer_farm_in_zrf =
		// edit_market_business_transfer_farm_in_zrf.getText().toString();// ת�÷�
		// }
		// if (edit_market_business_transfer_farm_in_srf != null
		// && edit_market_business_transfer_farm_in_srf.getText() != null) {
		// market_business_transfer_farm_in_srf =
		// edit_market_business_transfer_farm_in_srf.getText().toString();// ���÷�
		// }
		// if (edit_market_business_transfer_farm_in_tdzrnj != null
		// && edit_market_business_transfer_farm_in_tdzrnj.getText() != null) {
		// market_business_transfer_farm_in_tdzrnj =
		// edit_market_business_transfer_farm_in_tdzrnj.getText().toString();//
		// ����ת�����
		// }
		// if (edit_market_business_transfer_farm_in_zrqyt != null
		// && edit_market_business_transfer_farm_in_zrqyt.getText() != null) {
		// market_business_transfer_farm_in_zrqyt =
		// edit_market_business_transfer_farm_in_zrqyt.getText().toString();//
		// ת��ǰ��;
		// }
		// if (edit_market_business_transfer_farm_in_zrhyt != null
		// && edit_market_business_transfer_farm_in_zrhyt.getText() != null) {
		// market_business_transfer_farm_in_zrhyt =
		// edit_market_business_transfer_farm_in_zrhyt.getText().toString();//
		// ת�ú���;
		// }
		// if (edit_market_business_transfer_farm_in_tdsysynq != null
		// && edit_market_business_transfer_farm_in_tdsysynq.getText() != null)
		// {
		// market_business_transfer_farm_in_tdsysynq =
		// edit_market_business_transfer_farm_in_tdsysynq.getText()
		// .toString();// ����ʣ��ʹ������
		// }
		// if (edit_market_business_transfer_farm_in_tdzrdj != null
		// && edit_market_business_transfer_farm_in_tdzrdj.getText() != null) {
		// market_business_transfer_farm_in_tdzrdj =
		// edit_market_business_transfer_farm_in_tdzrdj.getText().toString();//
		// ����ת�õ���
		// }
		// if (edit_market_business_transfer_farm_in_tdzrzj != null
		// && edit_market_business_transfer_farm_in_tdzrzj.getText() != null) {
		// market_business_transfer_farm_in_tdzrzj =
		// edit_market_business_transfer_farm_in_tdzrzj.getText().toString();//
		// ����ת���ܼ�
		// }

		/** λ����Ϣ.���� **/
		// value_x = edit_x.getText().toString();// ����
		// value_y = edit_y.getText().toString();// γ��
		// value_bjdmc = edit_bjdmc.getText().toString();// ��ǵ�����
		// value_zbxt = edit_zbxt.getText().toString();// ����ϵͳ
		// value_remark = edit_remark.getText().toString();// ��ע
		/** ������Ϣ **/
		// value_rjl = edit_rjl.getText().toString();// �ݻ���
		// value_djqd = edit_djqd.getText().toString();// ���ڵؼ�����
		// value_xzqdm = edit_xzqdm.getText().toString();// ���������루�弶��������
	}

	/**
	 * ˵��������ɼ���Ϣ���ֱ�
	 * 
	 * @return id
	 */
	private int saveCollectionInfo() {
		int result = 0;
		setCollectionInfo();
		ModelCollectionMarketDevelopmentTownship model = new ModelCollectionMarketDevelopmentTownship();
		/** ������Ϣ **/
		model.setTHENAME(value_the_name);// ��¼����
		model.setTHECODE(value_the_code);// ��¼����
		// model.setTDSYZ(value_tdsyz);// ����������
		// model.setTDZSH(value_tdzsh);// ����֤���
		// model.setTDZL(value_tdzl);// ��������
		// model.setQSXZ(value_qsxz);// Ȩ������

		// TODO ����ʵ������
		// /** ����/������Ϣ **/
		// model.setZRSJ(market_business_transfer_farm_in_zrsj);// ת��ʱ��
		// model.setZRF(market_business_transfer_farm_in_zrf);// ת�÷�
		// model.setSRF(market_business_transfer_farm_in_srf);// ���÷�
		// model.setZRFS(market_business_transfer_farm_in_zrfs);// ת�÷�ʽ
		// model.setIndexZRFS(index_market_business_transfer_farm_in_zrfs);
		// model.setZRMJ(market_business_transfer_farm_in_tdzrnj);// ����ת�����
		// model.setZRQYT(market_business_transfer_farm_in_zrqyt);// ת��ǰ��;
		// model.setZRHYT(market_business_transfer_farm_in_zrhyt);// ת�ú���;
		// model.setTDSYNQ(market_business_transfer_farm_in_tdsysynq);//
		// ����ʣ��ʹ������
		// model.setZRDJ(market_business_transfer_farm_in_tdzrdj);// ����ת�õ���
		// model.setZRZJ(market_business_transfer_farm_in_tdzrzj);// ����ת���ܼ�

		// /** λ����Ϣ **/
		// model.setX(value_x);// ����
		// model.setY(value_y);// γ��
		// model.setZBXT(value_zbxt);// ����ϵͳ
		// model.setREMARK(value_remark);// ��ע

		/** ������Ϣ **/
		// model.setRJL(value_rjl);// �ڵ��ݻ���
		// model.setHXWKFSP(value_hxwkfsp);// �����⿪��ˮƽ
		// model.setHXNKFSP(value_hxnkfsp);// �����ڿ���ˮƽ
		// model.setTDJB(value_tdjb); // �������ؼ���
		// model.setDJQD(value_djqd);// ���ڵؼ�����
		// model.setXZQDM(value_xzqdm);// ���������루�弶��������

		/** ��ֵ�����ֶ� **/
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
		// // TODO ʵ�ֵ��ʱ���¼�
		// if (v.getId() == R.id.transfer_farm_in_ZRSJ) {
		// final int inType = editText_Time_ZRSJ.getInputType();
		// editText_Time_ZRSJ.setInputType(InputType.TYPE_NULL);
		// editText_Time_ZRSJ.onTouchEvent(event);
		// editText_Time_ZRSJ.setInputType(inType);
		// editText_Time_ZRSJ.setSelection(editText_Time_ZRSJ.getText().length());
		//
		// builder.setTitle("ѡȡ����ʱ��");
		// builder.setPositiveButton("ȷ  ��", new
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
	 * ��ȡ��������
	 */
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		// TODO Ӧ�ü��� REQUEST_CODE,�������������ж�
		if (resultCode != Activity.RESULT_OK) {
			// result is not correct
			// return;
		}

		// ��ȡ���ص�ͼƬ����
		if (requestCode == ComUtil.RequestCode_Photo_Value) {

			DisplayMetrics metric = new DisplayMetrics();
			getParentFragment().getActivity().getWindowManager().getDefaultDisplay().getMetrics(metric);
			int width = metric.widthPixels; // ��Ļ��ȣ����أ�
			int height = metric.heightPixels; // ��Ļ�߶ȣ����أ�

			try {
				// �������ڱ��ص�ͼƬȡ������������С����ʾ�ڽ�����
				Bitmap camorabitmap = ImageUtil.getImageThumbnail(Environment.getExternalStorageDirectory()
						+ "/temp.jpg", width, height);
				image_photo.setImageBitmap(camorabitmap);
				// TODO ���浽����
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
