package com.example.town_land_collect.fragment_market_supply;

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
import com.example.town_land_collect.model.market_supply.ModelCollectionMarketSupplyHouseSell;
import com.example.town_land_collect.util.AttachmentUtil;
import com.example.town_land_collect.util.CollectType;
import com.example.town_land_collect.util.ComUtil;
import com.example.town_land_collect.util.CommonTypeUtil;
import com.example.town_land_collect.util.ImageUtil;
import com.example.town_land_collect.util.ToastUtil;

/**
 * 
 * @Title Collection_Market_Supply_House_Sell.java
 * @Package com.example.town_land_collect.fragment_market_supply
 * @Description ���س��۹�Ӧ��Ϣ
 * @author Shen.dev
 * @date 2015-10-14 ����5:20:24
 * @version V1.0
 */
@SuppressLint({ "CutPasteId", "ClickableViewAccessibility" })
public class Collection_Market_Supply_House_Sell extends Fragment implements OnClickListener, OnTouchListener {
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
	private int index_qsxz = 0;// Ȩ������
	/** ���س��⹩Ӧ��Ϣ **/
	private int index_sfesf = 0;// �Ƿ���ַ�
	private int index_sfzaj = 0;// �Ƿ�ת����
	private int index_tdyt = 0;// ������;
	private int index_jzlx = 0;// ��������
	private int index_fwjg = 0;// ���ݽṹ
	private int index_fwcxd = 0;// ���ݳ��¶�
	private int index_zxcd = 0;// װ�޳̶�
	private int index_zzhx = 0;// סլ����
	private int index_ptss = 0;// ������ʩ
	private int index_ncsyt = 0;// �������;
	/** ������Ϣ **/
	private int index_hxwkfsp = 0;// �����⿪��ˮƽ
	private int index_hxnkfsp = 0;// �����ڿ���ˮƽ
	private int index_tdjb = 0;// �������ؼ���

	/** ͨ�ò���.�ؼ� **/
	private ImageView image_photo;// ͼƬ��Ϣ
	private ImageButton imageButton_Location;// ѡ�����꣨��ͼ��
	private ImageButton imageButton_Save;// ������
	private ImageButton imageButton_Clear;// ��ձ�
	private TextView textView_Tips;// ��ʾ��Ϣ

	/** ������Ϣ.�ؼ� **/
	private EditText edit_the_name;// ��¼����
	private EditText edit_the_code;// ��¼����

	// ** ���س��۹�Ӧ��Ϣ **/
	private EditText edit_tdsyz;// ����ʹ����
	private EditText edit_fwsyqr;// ��������Ȩ��
	private EditText edit_tdzsh;// ����֤���
	private EditText edit_yszsh;// Ԥ��֤���
	private EditText edit_tdzl;// ��������
	private Spinner edit_qsxz;// Ȩ������
	private EditText edit_fdsynq;// ����ʣ��ʹ������
	private Spinner edit_sfesf;// �Ƿ���ַ�
	private Spinner edit_sfzaj;// �Ƿ�ת����
	private EditText edit_cczt;// ����״̬
	private EditText edit_dyzt;// ��Ѻ״̬
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
	private Spinner edit_zzhx;// סլ����
	private Spinner edit_ptss;// ������ʩ
	private EditText edit_zbjt;// �ܱ߽�ͨ
	private EditText edit_ncslc;// �����¥��
	private Spinner edit_ncsyt;// �������;
	private EditText edit_ncsmj;// ����۽������
	private EditText edit_ncssj;// �����ʱ��
	private EditText edit_ndwmjsj;// �ⵥλ����ۼ�
	private EditText edit_nsj;// ���ۼ�
	private EditText edit_nsf;// ��˰��
	/** ������Ϣ.�ؼ� **/
	private EditText edit_rjl;// �ݻ���
	private Spinner edit_hxwkfsp;// �����⿪��ˮƽ
	private Spinner edit_hxnkfsp;// �����ڿ���ˮƽ
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

	// ** ���س��۹�Ӧ��Ϣ **/
	private String value_tdsyz;// ����ʹ����
	private String value_fwsyqr;// ��������Ȩ��
	private String value_tdzsh;// ����֤���
	private String value_yszsh;// Ԥ��֤���
	private String value_tdzl;// ��������
	private String value_qsxz;// Ȩ������
	private String value_fdsynq;// ����ʣ��ʹ������
	private String value_sfesf;// �Ƿ���ַ�
	private String value_sfzaj;// �Ƿ�ת����
	private String value_cczt;// ����״̬
	private String value_dyzt;// ��Ѻ״̬
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
	private String value_zzhx;// סլ����
	private String value_ptss;// ������ʩ
	private String value_zbjt;// �ܱ߽�ͨ
	private String value_ncslc;// �����¥��
	private String value_ncsyt;// �������;
	private String value_ncsmj;// ����۽������
	private String value_ncssj;// �����ʱ��
	private String value_ndwmjsj;// �ⵥλ����ۼ�
	private String value_nsj;// ���ۼ�
	private String value_nsf;// ��˰��

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
	private String value_zbxt;// ����ϵͳ
	private String value_remark;// ��ע

	/** Spinner Dict **/
	/** ������Ϣ .Spinner **/
	private ArrayList<String> list_qsxz = new ArrayList<String>();// Ȩ������

	/** ���س��⹩Ӧ��Ϣ **/
	private ArrayList<String> list_sfesf = new ArrayList<String>();// �Ƿ���ַ�
	private ArrayList<String> list_sfzaj = new ArrayList<String>();// �Ƿ�ת����
	private ArrayList<String> list_tdyt = new ArrayList<String>();// ������;
	private ArrayList<String> list_jzlx = new ArrayList<String>();// ��������
	private ArrayList<String> list_fwjg = new ArrayList<String>();// ���ݽṹ
	private ArrayList<String> list_fwcxd = new ArrayList<String>();// ���ݳ��¶�
	private ArrayList<String> list_zxcd = new ArrayList<String>();// װ�޳̶�
	private ArrayList<String> list_zzhx = new ArrayList<String>();// סլ����
	private ArrayList<String> list_ptss = new ArrayList<String>();// ������ʩ
	private ArrayList<String> list_ncsyt = new ArrayList<String>();// �������;

	/** ������Ϣ .Spinner **/
	private ArrayList<String> list_hxwkfsp = new ArrayList<String>();// �����⿪��ˮƽ
	private ArrayList<String> list_hxnkfsp = new ArrayList<String>();// �����ڿ���ˮƽ
	private ArrayList<String> list_tdjb = new ArrayList<String>();// �������ؼ���

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = (View) inflater.inflate(R.layout.collection_market_supply_house_sell_frame, container, false);
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
		textView_Tips.setText("���س��۹�Ӧ��Ϣ");
	}

	/**
	 * 
	 * ˵������ʼ������ؼ�
	 * 
	 * @param view
	 * @return void
	 */
	private void initEditText(View view) {

		/** ������Ϣ.�ؼ� **/
		edit_the_name = (EditText) view.findViewById(R.id.edit_the_name);// ��¼����
		edit_the_code = (EditText) view.findViewById(R.id.edit_the_code);// ��¼����

		// ** ���س��۹�Ӧ��Ϣ **/
		edit_tdsyz = (EditText) view.findViewById(R.id.edit_tdsyz);// ����ʹ����
		edit_fwsyqr = (EditText) view.findViewById(R.id.edit_fwsyqr);// ��������Ȩ��
		edit_tdzsh = (EditText) view.findViewById(R.id.edit_tdzsh);// ����֤���
		edit_yszsh = (EditText) view.findViewById(R.id.edit_yszsh);// Ԥ��֤���
		edit_tdzl = (EditText) view.findViewById(R.id.edit_tdzl);// ��������
		edit_qsxz = (Spinner) view.findViewById(R.id.edit_qsxz);// Ȩ������
		edit_fdsynq = (EditText) view.findViewById(R.id.edit_fdsynq);// ����ʣ��ʹ������
		edit_sfesf = (Spinner) view.findViewById(R.id.edit_sfesf);// �Ƿ���ַ�
		edit_sfzaj = (Spinner) view.findViewById(R.id.edit_sfzaj);// �Ƿ�ת����
		edit_cczt = (EditText) view.findViewById(R.id.edit_cczt);// ����״̬
		edit_dyzt = (EditText) view.findViewById(R.id.edit_dyzt);// ��Ѻ״̬
		edit_tdyt = (Spinner) view.findViewById(R.id.edit_tdyt);// ������;
		edit_ljkd = (EditText) view.findViewById(R.id.edit_ljkd);// �ٽֿ��
		edit_ljsd = (EditText) view.findViewById(R.id.edit_ljsd);// �ٽ����
		edit_jzlx = (Spinner) view.findViewById(R.id.edit_jzlx);// ��������
		edit_jzcs = (EditText) view.findViewById(R.id.edit_jzcs);// ��������
		edit_fwjg = (Spinner) view.findViewById(R.id.edit_fwjg);// ���ݽṹ
		edit_jgsj = (EditText) view.findViewById(R.id.edit_jgsj);// ����ʱ��
		edit_fwcxd = (Spinner) view.findViewById(R.id.edit_fwcxd);// ���ݳ��¶�
		edit_zxsj = (EditText) view.findViewById(R.id.edit_zxsj);// װ��ʱ��
		edit_zxcd = (Spinner) view.findViewById(R.id.edit_zxcd);// װ�޳̶�
		edit_zzhx = (Spinner) view.findViewById(R.id.edit_zzhx);// סլ����
		edit_ptss = (Spinner) view.findViewById(R.id.edit_ptss);// ������ʩ
		edit_zbjt = (EditText) view.findViewById(R.id.edit_zbjt);// �ܱ߽�ͨ
		edit_ncslc = (EditText) view.findViewById(R.id.edit_ncslc);// �����¥��
		edit_ncsyt = (Spinner) view.findViewById(R.id.edit_ncsyt);// �������;
		edit_ncsmj = (EditText) view.findViewById(R.id.edit_ncsmj);// ����۽������
		edit_ncssj = (EditText) view.findViewById(R.id.edit_ncssj);// �����ʱ��
		edit_ndwmjsj = (EditText) view.findViewById(R.id.edit_ndwmjsj);// �ⵥλ����ۼ�
		edit_nsj = (EditText) view.findViewById(R.id.edit_nsj);// ���ۼ�
		edit_nsf = (EditText) view.findViewById(R.id.edit_nsf);// ��˰��
		/** ������Ϣ.�ؼ� **/
		edit_rjl = (EditText) view.findViewById(R.id.edit_rjl);// �ݻ���
		edit_hxwkfsp = (Spinner) view.findViewById(R.id.edit_hxwkfsp);// �����⿪��ˮƽ
		edit_hxnkfsp = (Spinner) view.findViewById(R.id.edit_hxnkfsp);// �����ڿ���ˮƽ
		edit_tdjb = (Spinner) view.findViewById(R.id.edit_tdjb);// �������ؼ���
		edit_djqd = (EditText) view.findViewById(R.id.edit_djqd);// ���ڵؼ�����
		edit_xzqdm = (EditText) view.findViewById(R.id.edit_xzqdm);// ����������

		/** λ����Ϣ.�ؼ� **/
		edit_x = (EditText) view.findViewById(R.id.location_info_lon);// X����
		edit_y = (EditText) view.findViewById(R.id.location_info_lat);// Y����
		edit_zbxt = (EditText) view.findViewById(R.id.location_info_zbxt);// ����ϵͳ
		edit_remark = (EditText) view.findViewById(R.id.location_info_remark);// ��ע\

		/** �󶨿ؼ��¼� **/
		edit_jgsj.setOnTouchListener(this);
		edit_zxsj.setOnTouchListener(this);
		edit_ncssj.setOnTouchListener(this);
	}

	/**
	 * ˵������ʼ��Spinner �ֵ��б�
	 * 
	 * @return void
	 */
	private void initSpinnerDict() {
		CommonTypeUtil typeUtil = new CommonTypeUtil();
		list_qsxz = typeUtil.initList("qsxz");// Ȩ������
		list_sfesf = typeUtil.initList("yesno");// �Ƿ���ַ�
		list_sfzaj = typeUtil.initList("yesno");// �Ƿ�ת����
		list_tdyt = typeUtil.initList("tdyt");// ������;
		list_jzlx = typeUtil.initList("jzlx");// ��������
		list_fwjg = typeUtil.initList("fwjg");// ���ݽṹ
		list_fwcxd = typeUtil.initList("fwcxd");// ���ݳ��¶�
		list_zxcd = typeUtil.initList("zxcd");// װ�޳̶�
		list_zzhx = typeUtil.initList("zzhx");// סլ����
		list_ptss = typeUtil.initList("ptss");// ������ʩ
		list_ncsyt = typeUtil.initList("ytlx");// �������;
		list_hxwkfsp = typeUtil.initList("hxwkfsp");// �����⿪��ˮƽ
		list_hxnkfsp = typeUtil.initList("hxnkfsp");// �����ڿ���ˮƽ
		list_tdjb = typeUtil.initList("tdjb");// �������ؼ���

		value_qsxz = list_qsxz.get(0);
		value_sfesf = list_sfesf.get(0);
		value_sfzaj = list_sfzaj.get(0);
		value_tdyt = list_tdyt.get(0);
		value_jzlx = list_jzlx.get(0);
		value_fwjg = list_fwjg.get(0);
		value_fwcxd = list_fwcxd.get(0);
		value_zxcd = list_zxcd.get(0);
		value_zzhx = list_zzhx.get(0);
		value_ptss = list_ptss.get(0);
		value_ncsyt = list_ncsyt.get(0);
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

		/** �Ƿ���ַ� **/
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

		/** �Ƿ�ת���� **/
		edit_sfzaj.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_sfzaj = list_sfzaj.get(index);
				index_sfzaj = index;
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

		/** סլ���� **/
		edit_zzhx.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_zzhx = list_zzhx.get(index);
				index_zzhx = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});

		/** ������ʩ **/
		edit_ptss.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_ptss = list_ptss.get(index);
				index_ptss = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});

		/** �������; **/
		edit_ncsyt.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_ncsyt = list_ncsyt.get(index);
				index_ncsyt = index;
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

	@SuppressLint("SimpleDateFormat")
	@Override
	public void onClick(View arg0) {
		// TODO
		// ��ȡ��Ļ����
		DisplayMetrics metric = new DisplayMetrics();
		getParentFragment().getActivity().getWindowManager().getDefaultDisplay().getMetrics(metric);
		int width = metric.widthPixels; // ��Ļ��ȣ����أ�
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
			// ����Ϣ�ı��ش洢
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
				locationInfo.setCollectionType(CollectType.Collection_Market_Supply_House_Sell);
				// ����ID
				locationInfo.setCollectionMainType(CollectType.Supply);
				locationInfo.setCollectionTableName(CollectType.Collection_Market_Supply_House_Sell_Tablename);// ����
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
		// ��ձ�
		case R.id.fragment_collection_ibtn_clear:
			break;
		}
	}

	// TODO ������
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
				image_photo.setImageBitmap(camorabitmap);// TODO
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
				image_photo.setImageBitmap(camorabitmap);// TODO
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
						}// TODO
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
		/** ���س��۹�Ӧ��Ϣ **/
		value_tdsyz = edit_tdsyz.getText().toString();// ����ʹ����
		value_fwsyqr = edit_fwsyqr.getText().toString();// ��������Ȩ��
		value_tdzsh = edit_tdzsh.getText().toString();// ����֤���
		value_yszsh = edit_yszsh.getText().toString();// Ԥ��֤���
		value_tdzl = edit_tdzl.getText().toString();// ��������
		value_fdsynq = edit_fdsynq.getText().toString();// ����ʣ��ʹ������
		value_cczt = edit_cczt.getText().toString();// ����״̬
		value_dyzt = edit_dyzt.getText().toString();// ��Ѻ״̬
		value_ljkd = edit_ljkd.getText().toString();// �ٽֿ��
		value_ljsd = edit_ljsd.getText().toString();// �ٽ����
		value_jzcs = edit_jzcs.getText().toString();// ��������
		value_jgsj = edit_jgsj.getText().toString();// ����ʱ��
		value_zxsj = edit_zxsj.getText().toString();// װ��ʱ��
		value_zbjt = edit_zbjt.getText().toString();// �ܱ߽�ͨ
		value_ncslc = edit_ncslc.getText().toString();// �����¥��
		value_ncsmj = edit_ncsmj.getText().toString();// ����۽������
		value_ncssj = edit_ncssj.getText().toString();// �����ʱ��
		value_ndwmjsj = edit_ndwmjsj.getText().toString();// �ⵥλ����ۼ�
		value_nsj = edit_nsj.getText().toString();// ���ۼ�
		value_nsf = edit_nsf.getText().toString();// ��˰��

		/** λ����Ϣ.���� **/
		value_x = edit_x.getText().toString();// ����
		value_y = edit_y.getText().toString();// γ��
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
		ModelCollectionMarketSupplyHouseSell model = new ModelCollectionMarketSupplyHouseSell();
		/** ������Ϣ **/
		try {
			model.setTHENAME(value_the_name);// ��¼����
			model.setTHECODE(value_the_code);// ��¼����
			/** ���س��۹�Ӧ��Ϣ **/
			model.setTDSYZ(value_tdsyz);// ����ʹ����
			model.setFWSYQR(value_fwsyqr);// ��������Ȩ��
			model.setTDZSH(value_tdzsh);// ����֤���
			model.setYSZSH(value_yszsh);// Ԥ��֤���
			model.setTDZL(value_tdzl);// ��������
			model.setQSXZ(value_qsxz);// Ȩ������
			model.setFDSYNQ(value_fdsynq);// ����ʣ��ʹ������
			model.setSFESF(value_sfesf);// �Ƿ���ַ�
			model.setSFZAJ(value_sfzaj);// �Ƿ�ת����
			model.setCCZT(value_cczt);// ����״̬
			model.setDYZT(value_dyzt);// ��Ѻ״̬
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
			model.setZZHX(value_zzhx);// סլ����
			model.setPTSS(value_ptss);// ������ʩ
			model.setZBJT(value_zbjt);// �ܱ߽�ͨ
			model.setNCSLC(value_ncslc);// �����¥��
			model.setNCSYT(value_ncsyt);// �������;
			model.setNCSMJ(value_ncsmj);// ����۽������
			model.setNCSSJ(value_ncssj);// �����ʱ��
			model.setNDWMJSJ(value_ndwmjsj);// �ⵥλ����ۼ�
			model.setNSJ(value_nsj);// ���ۼ�
			model.setNSF(value_nsf);// ��˰��

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
			model.setXZQDM(value_xzqdm);// ����������

			/** ��ֵ�����ֶ� **/
			model.setIndex_qsxz(index_qsxz);
			model.setIndex_sfesf(index_sfesf);
			model.setIndex_sfzaj(index_sfzaj);
			model.setIndex_tdyt(index_tdyt);
			model.setIndex_jzlx(index_jzlx);
			model.setIndex_fwjg(index_fwjg);
			model.setIndex_fwcxd(index_fwcxd);
			model.setIndex_zxcd(index_zxcd);
			model.setIndex_zzhx(index_zzhx);// סլ����
			model.setIndex_ptss(index_ptss);// ������ʩ
			model.setIndex_ncsyt(index_ncsyt);// �������;
			model.setIndex_hxwkfsp(index_hxwkfsp);
			model.setIndex_tdjb(index_tdjb);
			model.setIndex_hxnkfsp(index_hxnkfsp);

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

			if (v.getId() == R.id.edit_jgsj) {
				final int inType = edit_jgsj.getInputType();
				edit_jgsj.setInputType(InputType.TYPE_NULL);
				edit_jgsj.onTouchEvent(event);
				edit_jgsj.setInputType(inType);
				edit_jgsj.setSelection(edit_jgsj.getText().length());

				builder.setTitle("ѡȡʱ��");
				builder.setPositiveButton("ȷ  ��", new DialogInterface.OnClickListener() {

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
			if (v.getId() == R.id.edit_zxsj) {
				final int inType = edit_zxsj.getInputType();
				edit_zxsj.setInputType(InputType.TYPE_NULL);
				edit_zxsj.onTouchEvent(event);
				edit_zxsj.setInputType(inType);
				edit_zxsj.setSelection(edit_zxsj.getText().length());

				builder.setTitle("ѡȡʱ��");
				builder.setPositiveButton("ȷ  ��", new DialogInterface.OnClickListener() {

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
			if (v.getId() == R.id.edit_ncssj) {
				final int inType = edit_ncssj.getInputType();
				edit_ncssj.setInputType(InputType.TYPE_NULL);
				edit_ncssj.onTouchEvent(event);
				edit_ncssj.setInputType(inType);
				edit_ncssj.setSelection(edit_ncssj.getText().length());

				builder.setTitle("ѡȡʱ��");
				builder.setPositiveButton("ȷ  ��", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

						StringBuffer sb = new StringBuffer();
						sb.append(String.format("%d-%02d-%02d", datePicker.getYear(), datePicker.getMonth() + 1, datePicker.getDayOfMonth()));
						sb.append("  00:00:00");

						edit_ncssj.setText(sb);
						edit_ncssj.requestFocus();

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
				String filePath = ImageUtil.copyFile(Environment.getExternalStorageDirectory() + "/temp.jpg",
						Environment.getExternalStorageDirectory() + "/");
				imagePathList.add(filePath);
				imagePathListIndex = imagePathList.size() - 1;// TODO
				text_page.setText("��" + (imagePathListIndex + 1) + "��");
				text_total.setText(",��" + imagePathList.size() + "��");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (requestCode == ComUtil.RequestCode_Album) {
			DisplayMetrics metric = new DisplayMetrics();
			getParentFragment().getActivity().getWindowManager().getDefaultDisplay().getMetrics(metric);
			int width = metric.widthPixels; // ��Ļ��ȣ����أ�
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
				imagePathListIndex = imagePathList.size() - 1;// TODO
				text_page.setText("��" + (imagePathListIndex + 1) + "��");
				text_total.setText(",��" + imagePathList.size() + "��");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}