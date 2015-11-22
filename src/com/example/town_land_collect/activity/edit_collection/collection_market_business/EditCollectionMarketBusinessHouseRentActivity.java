package com.example.town_land_collect.activity.edit_collection.collection_market_business;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.litepal.crud.DataSupport;
import org.litepal.exceptions.DataSupportException;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
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
import com.example.town_land_collect.model.market_business.ModelCollectionMarketBusinessHouseRent;
import com.example.town_land_collect.util.CollectType;
import com.example.town_land_collect.util.ComUtil;
import com.example.town_land_collect.util.CommonTypeUtil;
import com.example.town_land_collect.util.ImageUtil;
import com.example.town_land_collect.util.ToastUtil;

public class EditCollectionMarketBusinessHouseRentActivity extends ActionBarActivity implements OnClickListener, OnTouchListener {
	private String imagePathString = null;
	private final String IMAGE_TYPE = "image/*";
	private final int IMAGE_CODE = 0; // �����IMAGE_CODE���Լ����ⶨ���
	private String[] imagePathTempList = null;
	private List<String> imagePathList = new ArrayList<String>();
	private int imagePathListIndex = 0;
	private Bitmap camorabitmap = null;
	private Button image_left;// ͼƬ��һ��
	private Button image_right;// ͼƬ��һ��
	// TODO
	private TextView text_page;
	private TextView text_total;

	/** Fragment-manager **/
	private Integer curFragmentParent = 1;// fragment����
	private Integer curFragmentChildren = 0;// frament�Ӽ�

	/** ��ע��λ����� **/
	private LocationInfo locationInfo;

	/** ������Ϣ.�ؼ� **/
	private int index_qsxz = 0;// Ȩ������
	/** ת��/������Ϣ **/
	private int index_tdyt = 0;// ������;
	private int index_jzlx = 0;// ��������
	private int index_fwjg = 0;// ���ݽṹ
	private int index_fwcxd = 0;// ���ݳ��¶�
	private int index_zxcd = 0;// װ�޳̶�
	private int index_czyt = 0;// ������;
	/** ������Ϣ.�ؼ� **/
	private int index_hxwkfsp = 0;// �����⿪��ˮƽ
	private int index_hxnkfsp = 0;// �����ڿ���ˮƽ
	private int index_tdjb = 0;// �������ؼ���

	/** ͨ�ò���.�ؼ� **/
	private ImageView image_photo;// ͼƬ��Ϣ
	private ImageButton button_location;// ѡ�����꣨��ͼ��
	private ImageButton button_save;// ������
	private ImageButton button_clear;// ��ձ�
	private TextView text_tips;// ��ʾ��Ϣ

	/** ������Ϣ.�ؼ� **/
	private EditText edit_the_name;// ��¼����
	private EditText edit_the_code;// ��¼����
	private EditText edit_tdsyz;// ����������
	private EditText edit_tdzsh;// ����֤���
	private EditText edit_tdzl;// ��������
	private Spinner edit_qsxz;// Ȩ������

	/** ����/������Ϣ.�ؼ� **/
	private EditText edit_fwsyqr;// ��������Ȩ��
	private Spinner edit_tdyt;// ������;
	private EditText edit_ljkd;// �ٽֿ��
	private EditText edit_ljsd;// �ٽ����
	private Spinner edit_jzlx;// ��������
	private EditText edit_jzcs;// ��������
	private Spinner edit_fwjg;// ���ݽṹ
	private EditText edit_jgsj;// ����ʱ��
	private Spinner edit_fwcxd;// ���ݳ��¶�
	private EditText edit_zxsj;// װ��ʱ��
	private Spinner edit_zxcd;// װ�޳̶�
	private EditText edit_czlc;// ����¥��
	private Spinner edit_czyt;// ������;
	private EditText edit_czmj;// ���⽨�����
	private EditText edit_czsj;// ����ʱ��
	private EditText edit_zq;// ���ڣ��꣩
	private EditText edit_nzj;// �����
	private EditText edit_yj;// Ѻ��
	private EditText edit_sf;// ˰��

	/** λ����Ϣ.�ؼ� **/
	private EditText edit_x;// ����
	private EditText edit_y;// γ��
	private EditText edit_bjdmc;// ��ǵ�����
	private EditText edit_zbxt;// ����ϵͳ
	private EditText edit_remark;// ��ע

	/** ������Ϣ.�ؼ� **/
	private EditText edit_rjl;// �ݻ���
	private Spinner edit_hxwkfsp;// �����⿪��ˮƽ
	private Spinner edit_hxnkfsp;// �����ڿ���ˮƽ
	private Spinner edit_tdjb;// �������ؼ���
	private EditText edit_djqd;// ���ڵ�ַ����
	private EditText edit_xzqdm;// ����������

	/** ȫ�ֱ��� **/
	private double lat;
	private double lon;

	/** ������Ϣ.���� **/
	private String value_the_name;// ��¼����
	private String value_the_code;// ��¼����
	private String value_tdsyz;// ����ʹ����
	private String value_tdzsh;// ����֤���
	private String value_tdzl;// ��������
	private String value_qsxz;// Ȩ������

	// /** ת��/������Ϣ.���� **/
	private String value_fwsyqr;// ��������Ȩ��
	private String value_tdyt;// ������;
	private String value_ljkd;// �ٽֿ��
	private String value_ljsd;// �ٽ����
	private String value_jzlx;// ��������
	private String value_jzcs;// ��������
	private String value_fwjg;// ���ݽṹ
	private String value_jgsj;// ����ʱ��
	private String value_fwcxd;// ���ݳ��¶�
	private String value_zxsj;// װ��ʱ��
	private String value_zxcd;// װ�޳̶�
	private String value_czlc;// ����¥��
	private String value_czyt;// ������;
	private String value_czmj;// ���⽨�����
	private String value_czsj;// ����ʱ��
	private String value_zq;// ����(��)
	private String value_nzj;// �����
	private String value_yj;// Ѻ��
	private String value_sf;// ˰��

	/** ������Ϣ **/
	private String value_rjl;// �ݻ���
	private String value_hxwkfsp;// �����⿪��ˮƽ
	private String value_hxnkfsp;// �����ڿ���ˮƽ
	private String value_tdjb;// �������ؼ���
	private String value_djqd;// ���ڵؼ�����
	private String value_xzqdm;// ����������

	/** λ����Ϣ.���� **/
	private String value_x;// X����
	private String value_y;// Y����
	// private String value_bjdmc;// ��ǵ�����
	private String value_zbxt;// ����ϵͳ
	private String value_remark;// ��ע

	/** Spinner Dict **/
	/** ������Ϣ .Spinner **/
	private ArrayList<String> list_qsxz = new ArrayList<String>();// Ȩ������

	/** ת��/������Ϣ .Spinner **/
	private ArrayList<String> list_tdyt = new ArrayList<String>();// ������;
	private ArrayList<String> list_jzlx = new ArrayList<String>();// ��������
	private ArrayList<String> list_fwjg = new ArrayList<String>();// ���ݽṹ
	private ArrayList<String> list_fwcxd = new ArrayList<String>();// ���ݳ��¶�
	private ArrayList<String> list_zxcd = new ArrayList<String>();// װ�޳̶�
	private ArrayList<String> list_czyt = new ArrayList<String>();// ������;

	/** ������Ϣ .Spinner **/
	private ArrayList<String> list_hxwkfsp = new ArrayList<String>();// �����⿪��ˮƽ
	private ArrayList<String> list_hxnkfsp = new ArrayList<String>();// �����ڿ���ˮƽ
	private ArrayList<String> list_tdjb = new ArrayList<String>();// �������ؼ���

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.collection_market_business_house_rent_frame_detail);
		/** ��ʼ���ؼ� **/
		initView();
		initEditText();
		/** ��ʼ������ **/
		initLayout();
		initModel();
		initSpinnerDict();
		initOnItemSelectedListener();
		initTextChangedListener();
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
	}

	private void initLayout() {
		Intent intent = getIntent();
		if (intent != null) {
			locationInfo = (LocationInfo) intent.getSerializableExtra("locationInfo");
			if (locationInfo != null) {
				edit_bjdmc.setText(locationInfo.getName());
				edit_x.setText(locationInfo.getLon() + "");
				edit_y.setText(locationInfo.getLat() + "");
				edit_remark.setText(locationInfo.getMark());
				lon = Double.valueOf(locationInfo.getLon());
				lat = Double.valueOf(locationInfo.getLat());
				// ��ʾ��ͼƬ
				if (locationInfo.getImageUri() != null) {
					DisplayMetrics metric = new DisplayMetrics();
					getWindowManager().getDefaultDisplay().getMetrics(metric);
					int width = metric.widthPixels; // ��Ļ��ȣ����أ�
					int height = metric.heightPixels; // ��Ļ�߶ȣ����أ�
					// ���ж��Ƿ��Ѿ�����
					if (camorabitmap != null && !camorabitmap.isRecycled()) {
						camorabitmap.recycle();
						camorabitmap = null;
					}
					imagePathString = locationInfo.getImageUri();
					imagePathTempList = imagePathString.split(",");
					for (String item : imagePathTempList) {
						imagePathList.add(item);
					}
					if (imagePathList != null) {
						camorabitmap = ImageUtil.getImageThumbnail(imagePathList.get(0), width, height);
						image_photo.setImageBitmap(camorabitmap);
						// TODO
						text_page.setText("��" + (imagePathListIndex + 1) + "��");
						text_total.setText(",��" + imagePathList.size() + "��");
					}
				}

			}
		}
	}

	/**
	 * 
	 * ˵������ʼ����ͼ
	 * 
	 * @param view
	 * @return void
	 */
	private void initView() {
		/** ͨ�ò��� **/
		image_photo = (ImageView) findViewById(R.id.fragment_collection_photo);
		image_photo.setOnClickListener(this);
		image_left = (Button) findViewById(R.id.fragment_collection_left);
		image_left.setOnClickListener(this);
		image_right = (Button) findViewById(R.id.fragment_collection_right);
		image_right.setOnClickListener(this);
		// TODO
		text_page = (TextView) findViewById(R.id.textViewPage);
		text_total = (TextView) findViewById(R.id.textViewTotal);
		button_location = (ImageButton) findViewById(R.id.fragment_collection_ibtn_location);
		button_location.setOnClickListener(this);
		button_save = (ImageButton) findViewById(R.id.fragment_collection_ibtn_save);
		button_clear = (ImageButton) findViewById(R.id.fragment_collection_ibtn_clear);
		button_clear.setOnClickListener(this);
		button_save.setOnClickListener(this);
		text_tips = (TextView) findViewById(R.id.fragment_collection_tv_tips);
		text_tips.setText("���س��⽻����Ϣ");
	}

	/**
	 * ˵������ʼ��ʵ����ʾ
	 * 
	 * @return void
	 */
	private void initModel() {
		ModelCollectionMarketBusinessHouseRent model = DataSupport.find(ModelCollectionMarketBusinessHouseRent.class, locationInfo.getCollectionId());
		if (model != null) {
			/** ������Ϣ **/
			edit_the_name.setText(model.getTHENAME());// ��¼����
			edit_the_code.setText(model.getTHECODE());// ��¼����
			edit_tdsyz.setText(model.getTDSYZ());// ����������
			edit_tdzsh.setText(model.getTDZSH());// ����֤���
			edit_tdzl.setText(model.getTDZL());// ��������
			edit_qsxz.setSelection(model.getINDEX_QSXZ());// Ȩ������

			/** ���س��⽻����Ϣ **/
			edit_fwsyqr.setText(model.getFWSYQR());// ��������Ȩ��
			edit_tdyt.setSelection(model.getINDEX_TDYT());// ������;
			edit_ljkd.setText(model.getLJKD());// �ٽֿ��
			edit_ljsd.setText(model.getLJSD());// �ٽ����
			edit_jzlx.setSelection(model.getINDEX_JZLX());// ��������
			edit_jzcs.setText(model.getJZCS());// ��������
			edit_fwjg.setSelection(model.getINDEX_FWJG());// ���ݽṹ
			edit_jgsj.setText(model.getJGSJ());// ����ʱ��
			edit_fwcxd.setSelection(model.getINDEX_FWCXD());// ���ݳ��¶�
			edit_zxsj.setText(model.getZXSJ());// װ��ʱ��
			edit_zxcd.setSelection(model.getINDEX_ZXCD());// װ�޳̶�
			edit_czlc.setText(model.getCZLC());// ����¥��
			edit_czyt.setSelection(model.getINDEX_CZYT());// ������;
			edit_czmj.setText(model.getCZMJ());// ���⽨�����
			edit_czsj.setText(model.getCZSJ());// ����ʱ��
			edit_zq.setText(model.getZQ());// ���ڣ��꣩
			edit_nzj.setText(model.getNZJ());// �����
			edit_yj.setText(model.getYJ());// Ѻ��
			edit_sf.setText(model.getSF());// ˰��

			/** λ����Ϣ.�ؼ� **/
			edit_x.setText(model.getX());// ����
			edit_y.setText(model.getY());// γ��
			edit_bjdmc.setText(model.getTHENAME());// ��ǵ�����
			edit_zbxt.setText(model.getZBXT());// ����ϵͳ
			edit_remark.setText(model.getREMARK());// ��ע
			/** ������Ϣ.�ؼ� **/
			edit_rjl.setText(model.getRJL());// �ݻ���
			edit_hxwkfsp.setSelection(model.getINDEX_HXWKFSP());// �����⿪��ˮƽ
			edit_hxnkfsp.setSelection(model.getINDEX_HXNKFSP());// �����ڿ���ˮƽ
			edit_tdjb.setSelection(model.getINDEX_TDJB());// �������ؼ���
			edit_djqd.setText(model.getDJQD());// ���ڵ�ַ����
			edit_xzqdm.setText(model.getXZQDM());// ����������
		}
	}

	/**
	 * 
	 * ˵������ʼ������ؼ�
	 * 
	 * @param view
	 * @return void
	 */
	private void initEditText() {
		/** ������Ϣ **/
		edit_the_name = (EditText) findViewById(R.id.edit_the_name);
		edit_the_code = (EditText) findViewById(R.id.edit_the_code);
		edit_tdsyz = (EditText) findViewById(R.id.edit_tdsyz);
		edit_tdzsh = (EditText) findViewById(R.id.edit_tdzsh);
		edit_tdzl = (EditText) findViewById(R.id.edit_tdzl);
		edit_qsxz = (Spinner) findViewById(R.id.edit_qsxz);// Spinner

		/** ���س��⽻����Ϣ **/
		edit_fwsyqr = (EditText) findViewById(R.id.edit_fwsyqr);// ��������Ȩ��
		edit_tdyt = (Spinner) findViewById(R.id.edit_tdyt);// ������;
		edit_ljkd = (EditText) findViewById(R.id.edit_ljkd);// �ٽֿ��
		edit_ljsd = (EditText) findViewById(R.id.edit_ljsd);// �ٽ����
		edit_jzlx = (Spinner) findViewById(R.id.edit_jzlx);// ��������
		edit_jzcs = (EditText) findViewById(R.id.edit_jzcs);// ��������
		edit_fwjg = (Spinner) findViewById(R.id.edit_fwjg);// ���ݽṹ
		edit_jgsj = (EditText) findViewById(R.id.edit_jgsj);// ����ʱ��
		edit_fwcxd = (Spinner) findViewById(R.id.edit_fwcxd);// ���ݳ��¶�
		edit_zxsj = (EditText) findViewById(R.id.edit_zxsj);// װ��ʱ��
		edit_zxcd = (Spinner) findViewById(R.id.edit_zxcd);// װ�޳̶�
		edit_czlc = (EditText) findViewById(R.id.edit_czlc);// ����¥��
		edit_czyt = (Spinner) findViewById(R.id.edit_czyt);// ������;
		edit_czmj = (EditText) findViewById(R.id.edit_czmj);// ���⽨�����
		edit_czsj = (EditText) findViewById(R.id.edit_czsj);// ����ʱ��
		edit_zq = (EditText) findViewById(R.id.edit_zq);// ����(��)
		edit_nzj = (EditText) findViewById(R.id.edit_nzj);// �����
		edit_yj = (EditText) findViewById(R.id.edit_yj);// Ѻ��
		edit_sf = (EditText) findViewById(R.id.edit_sf);// ˰��

		/** λ����Ϣ **/
		edit_x = (EditText) findViewById(R.id.location_info_lon);
		edit_y = (EditText) findViewById(R.id.location_info_lat);
		edit_bjdmc = (EditText) findViewById(R.id.location_info_bjdmc);
		edit_zbxt = (EditText) findViewById(R.id.location_info_zbxt);
		edit_remark = (EditText) findViewById(R.id.location_info_remark);
		/** ������Ϣ **/
		edit_rjl = (EditText) findViewById(R.id.edit_rjl);
		edit_hxwkfsp = (Spinner) findViewById(R.id.edit_hxwkfsp);// spinner
		edit_hxnkfsp = (Spinner) findViewById(R.id.edit_hxnkfsp);// spinner
		edit_tdjb = (Spinner) findViewById(R.id.edit_tdjb);// spinner
		edit_djqd = (EditText) findViewById(R.id.edit_djqd);
		edit_xzqdm = (EditText) findViewById(R.id.edit_xzqdm);

		/** �󶨴����¼� **/
		edit_jgsj.setOnTouchListener(this);
		edit_zxsj.setOnTouchListener(this);
		edit_czsj.setOnTouchListener(this);
	}

	/**
	 * ˵������ʼ��Spinner �ֵ��б�
	 * 
	 * @return void
	 */
	private void initSpinnerDict() {
		CommonTypeUtil typeUtil = new CommonTypeUtil();

		list_qsxz = typeUtil.initList("qsxz");// Ȩ������
		list_tdyt = typeUtil.initList("tdyt");// ������;
		list_jzlx = typeUtil.initList("jzlx");// ��������
		list_fwjg = typeUtil.initList("fwjg");// ���ݽṹ
		list_fwcxd = typeUtil.initList("fwcxd");// ���ݳ��¶�
		list_zxcd = typeUtil.initList("zxcd");// װ�޳̶�
		list_czyt = typeUtil.initList("ytlx");// ������;
		list_hxwkfsp = typeUtil.initList("hxwkfsp");// �����⿪��ˮƽ
		list_hxnkfsp = typeUtil.initList("hxnkfsp");// �����ڿ���ˮƽ
		list_tdjb = typeUtil.initList("tdjb");// �������ؼ���

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
	 * ˵������ʼ��������Ŀѡ���¼�
	 * 
	 * ���Spinner�¼�����
	 * 
	 * @return void
	 */
	private void initOnItemSelectedListener() {

		/** Ȩ������ **/
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
		/** ������; **/
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
		/** �������� **/
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

		/** ���ݽṹ **/
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
		/** ���ݳ��¶� **/
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
		/** װ�޳̶� **/
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
		/** ������; **/
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

		/** �����⿪��ˮƽ **/
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
		/** �����ڿ���ˮƽ **/
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
		/** �������ؼ��� **/
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
			Toast.makeText(this, "��¼ɾ���ɹ�", Toast.LENGTH_SHORT).show();
			this.finish();
			return true;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
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
								Toast.makeText(null, "���ܳ���100", Toast.LENGTH_SHORT).show();
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
		// ��ȡ��Ļ����
		DisplayMetrics metric = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metric);
		int width = metric.widthPixels; // ��Ļ��ȣ����أ�
		int height = metric.heightPixels; // ��Ļ�߶ȣ����أ�

		int id = arg0.getId();
		switch (id) {
		case R.id.fragment_collection_ibtn_location:
			// �򿪵�ͼλ��ѡ��
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
			// getPhotoImage();
			break;
		case R.id.fragment_collection_left:
			getPhotoLeft(width, height);
			break;
		case R.id.fragment_collection_right:
			getPhotoRight(width, height);
			break;

		case R.id.fragment_collection_ibtn_save:
			// ����Ϣ�ı��ش洢
			if (edit_x.getText().toString().equals("") || edit_y.getText().toString().equals("")) {
				ToastUtil.ToastStr(this, "�벹��������γ����Ϣ", 2000);
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
				locationInfo.setState("����״̬�����ϴ�");
				locationInfo.setStateCode(CollectType.State_Code_Not_Yet_Upload);// ���ϴ�
				locationInfo.setCollectionType(CollectType.Collection_Market_Business_House_Rent);
				// �洢��ʵ������
				int collectionId = saveCollectionInfo();
				if (collectionId != 0) {
					locationInfo.setCollectionId(collectionId);
					try {
						locationInfo.update(locationInfo.getId());// ����LogCat��׽�쳣��Ϣ
						ToastUtil.ToastStr(this, "���³ɹ�", 2000);
					} catch (DataSupportException e) {
						Log.d("TAG", e.toString());
						ToastUtil.ToastStr(this, e.toString(), 2000);
						ToastUtil.ToastStr(this, "����ʧ��", 2000);
					}
				} else {
					ToastUtil.ToastStr(this, "����ʧ��", 2000);
				}
			}
			break;
		// ��ձ�
		case R.id.fragment_collection_ibtn_clear:
			break;
		}
	}

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
		new AlertDialog.Builder(this).setTitle("ѡ�����").setItems(items, new DialogInterface.OnClickListener() {
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
					getWindowManager().getDefaultDisplay().getMetrics(metric);
					int width = metric.widthPixels; // ��Ļ��ȣ����أ�
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
		value_tdsyz = edit_tdsyz.getText().toString();// ����������
		value_tdzsh = edit_tdzsh.getText().toString();// ����֤���
		value_tdzl = edit_tdzl.getText().toString();// ��������

		value_fwsyqr = edit_fwsyqr.getText().toString();// ��������Ȩ��
		value_ljkd = edit_ljkd.getText().toString();// �ٽֿ��
		value_ljsd = edit_ljsd.getText().toString();// �ٽ����
		value_jzcs = edit_jzcs.getText().toString();// ��������
		value_jgsj = edit_jgsj.getText().toString();// ����ʱ��
		value_zxsj = edit_zxsj.getText().toString();// װ��ʱ��
		value_czlc = edit_czlc.getText().toString();// ����¥��
		value_czmj = edit_czmj.getText().toString();// ���⽨�����
		value_czsj = edit_czsj.getText().toString();// ����ʱ��
		value_zq = edit_zq.getText().toString();// ����(��)
		value_nzj = edit_nzj.getText().toString();// �����
		value_yj = edit_yj.getText().toString();// Ѻ��
		value_sf = edit_sf.getText().toString();// ˰��

		/** λ����Ϣ.���� **/
		value_x = edit_x.getText().toString();// ����
		value_y = edit_y.getText().toString();// γ��
		// value_bjdmc = edit_bjdmc.getText().toString();// ��ǵ�����
		value_zbxt = edit_zbxt.getText().toString();// ����ϵͳ
		value_remark = edit_remark.getText().toString();// ��ע
		/** ������Ϣ **/
		value_rjl = edit_rjl.getText().toString();// �ݻ���
		value_djqd = edit_djqd.getText().toString();// ���ڵ�ַ����
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
		ModelCollectionMarketBusinessHouseRent model = DataSupport.find(ModelCollectionMarketBusinessHouseRent.class, locationInfo.getCollectionId());
		/** ������Ϣ **/
		model.setTHENAME(value_the_name);// ��¼����
		model.setTHECODE(value_the_code);// ��¼����
		model.setTDSYZ(value_tdsyz);// ����������
		model.setTDZSH(value_tdzsh);// ����֤���
		model.setTDZL(value_tdzl);// ��������
		model.setQSXZ(value_qsxz);// Ȩ������

		// /** ����/������Ϣ **/
		model.setFWSYQR(value_fwsyqr);// ��������Ȩ��
		model.setTDYT(value_tdyt);// ������;
		model.setLJKD(value_ljkd);// �ٽֿ��
		model.setLJSD(value_ljsd);// �ٽ����
		model.setJZLX(value_jzlx);// ��������
		model.setJZCS(value_jzcs);// ��������
		model.setFWJG(value_fwjg);// ���ݽṹ
		model.setJGSJ(value_jgsj);// ����ʱ��
		model.setFWCXD(value_fwcxd);// ���ݳ��¶�
		model.setZXSJ(value_zxsj);// װ��ʱ��
		model.setZXCD(value_zxcd);// װ�޳̶�
		model.setCZLC(value_czlc);// ����¥��
		model.setCZYT(value_czyt);// ������;
		model.setCZMJ(value_czmj);// ���⽨�����
		model.setCZSJ(value_czsj);// ����ʱ��
		model.setZQ(value_zq);// ���ڣ��꣩
		model.setNZJ(value_nzj);// �����
		model.setYJ(value_yj);// Ѻ��
		model.setSF(value_sf);// ˰��
		/** λ����Ϣ **/
		model.setX(value_x);// ����
		model.setY(value_y);// γ��
		model.setZBXT(value_zbxt);// ����ϵͳ
		model.setREMARK(value_remark);// ��ע

		/** ������Ϣ **/
		model.setRJL(value_rjl);// �ڵ��ݻ���
		model.setHXWKFSP(value_hxwkfsp);// �����⿪��ˮƽ
		model.setHXNKFSP(value_hxnkfsp);// �����ڿ���ˮƽ
		model.setTDJB(value_tdjb); // �������ؼ���
		model.setDJQD(value_djqd);// ���ڵؼ�����
		model.setXZQDM(value_xzqdm);// ���������루�弶��������

		/** ��ֵ�����ֶ� **/
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
			model.update(model.getID());
			result = model.getID();
		} catch (DataSupportException e) {
			Log.d("TAG", e.toString());
			ToastUtil.ToastStr(this, e.toString(), 2000);
		}
		return result;
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (data != null) {
			if (data.getIntExtra("rCode", 0) == 1) {
				lat = data.getIntExtra("lat", 0) / 1E6;
				lon = data.getIntExtra("long", 0) / 1E6;
				edit_x.setText(lon + "");
				edit_y.setText(lat + "");
			}
		}

		// ��ȡ���ص�ͼƬ����
		if (requestCode == ComUtil.RequestCode_Photo_Value) {

			DisplayMetrics metric = new DisplayMetrics();
			getWindowManager().getDefaultDisplay().getMetrics(metric);
			int width = metric.widthPixels; // ��Ļ��ȣ����أ�
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
				String filePath = ImageUtil.copyFile(Environment.getExternalStorageDirectory() + "/temp.jpg", Environment.getExternalStorageDirectory() + "/");
				imagePathList.add(filePath);
				imagePathListIndex = imagePathList.size();
				// TODO
				text_page.setText("��" + (imagePathListIndex + 1) + "��");
				text_total.setText(",��" + imagePathList.size() + "��");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (requestCode == ComUtil.RequestCode_Album) {
			DisplayMetrics metric = new DisplayMetrics();
			getWindowManager().getDefaultDisplay().getMetrics(metric);
			int width = metric.widthPixels; // ��Ļ��ȣ����أ�
			int height = metric.heightPixels; // ��Ļ�߶ȣ����أ�
			try {
				// ���ж��Ƿ��Ѿ�����
				if (camorabitmap != null && !camorabitmap.isRecycled()) {
					camorabitmap.recycle();
					camorabitmap = null;
				}
				Uri originalUri = data.getData(); // ���ͼƬ��uri
				String filePath = ImageUtil.getImageAbsolutePath(this, originalUri);
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

	@SuppressLint("ClickableViewAccessibility")
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

			/** ����ʱ�� **/
			if (v.getId() == R.id.edit_jgsj) {
				final int inType = edit_jgsj.getInputType();
				edit_jgsj.setInputType(InputType.TYPE_NULL);
				edit_jgsj.onTouchEvent(event);
				edit_jgsj.setInputType(inType);
				edit_jgsj.setSelection(edit_jgsj.getText().length());

				builder.setTitle("ѡȡ����ʱ��");
				builder.setPositiveButton("ȷ  ��", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

						StringBuffer sb = new StringBuffer();
						sb.append(String.format("%d-%02d-%02d", datePicker.getYear(), datePicker.getMonth() + 1, datePicker.getDayOfMonth()));
						sb.append("  ");

						edit_jgsj.setText(sb);
						edit_jgsj.requestFocus();

						dialog.cancel();
					}
				});
			}
			/** װ��ʱ�� **/
			else if (v.getId() == R.id.edit_zxsj) {
				final int inType = edit_zxsj.getInputType();
				edit_zxsj.setInputType(InputType.TYPE_NULL);
				edit_zxsj.onTouchEvent(event);
				edit_zxsj.setInputType(inType);
				edit_zxsj.setSelection(edit_zxsj.getText().length());

				builder.setTitle("ѡȡ����ʱ��");
				builder.setPositiveButton("ȷ  ��", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

						StringBuffer sb = new StringBuffer();
						sb.append(String.format("%d-%02d-%02d", datePicker.getYear(), datePicker.getMonth() + 1, datePicker.getDayOfMonth()));
						sb.append("  ");

						edit_zxsj.setText(sb);
						edit_zxsj.requestFocus();

						dialog.cancel();
					}
				});
			}
			/** ����ʱ�� **/
			else if (v.getId() == R.id.edit_czsj) {
				final int inType = edit_czsj.getInputType();
				edit_czsj.setInputType(InputType.TYPE_NULL);
				edit_czsj.onTouchEvent(event);
				edit_czsj.setInputType(inType);
				edit_czsj.setSelection(edit_czsj.getText().length());

				builder.setTitle("ѡȡ����ʱ��");
				builder.setPositiveButton("ȷ  ��", new DialogInterface.OnClickListener() {

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

}
