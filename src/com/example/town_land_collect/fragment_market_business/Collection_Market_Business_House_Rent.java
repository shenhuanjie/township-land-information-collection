package com.example.town_land_collect.fragment_market_business;

import java.io.File;
import java.io.IOException;
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
import com.example.town_land_collect.model.market_business.ModelCollectionMarketBusinessHouseRent;
import com.example.town_land_collect.util.AttachmentUtil;
import com.example.town_land_collect.util.CollectType;
import com.example.town_land_collect.util.ComUtil;
import com.example.town_land_collect.util.CommonTypeUtil;
import com.example.town_land_collect.util.ImageUtil;
import com.example.town_land_collect.util.PictureUtil;
import com.example.town_land_collect.util.ToastUtil;

/**
 * 
 * @Title Collection_Market_Business_House_Rent.java
 * @Package com.example.town_land_collect.fragment_market_business
 * @Description ���س��⽻����Ϣ
 * @author Shen.dev
 * @date 2015-10-14 ����4:56:37
 * @version V1.0
 */
@SuppressLint({ "CutPasteId", "ClickableViewAccessibility" })
public class Collection_Market_Business_House_Rent extends Fragment implements OnClickListener, OnTouchListener {
	// TODO
	private String mCurrentPhotoPath;// ͼƬ·��

	private String imagePathString = null;

	private final String IMAGE_TYPE = "image/*";
	private final int IMAGE_CODE = 0;
	private List<String> imagePathList = new ArrayList<String>();
	private int imagePathListIndex = 0;
	private Bitmap camorabitmap = null;
	private Button image_left;// ͼƬ��һ��
	private Button image_right;// ͼƬ��һ��

	private TextView text_page;
	private TextView text_total;

	/** Fragment-manager **/
	private Integer curFragmentParent = 1;// fragment����
	private Integer curFragmentChildren = 0;// frament�Ӽ�

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
	private EditText edit_tdsyz;// ����ʹ����
	private EditText edit_tdzsh;// ����֤���
	private EditText edit_tdzl;// ��������
	private Spinner edit_qsxz;// Ȩ������

	// /** ת��/������Ϣ **/
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
	private EditText edit_zq;// ����(��)
	private EditText edit_nzj;// �����
	private EditText edit_yj;// Ѻ��
	private EditText edit_sf;// ˰��

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
	// private EditText edit_bjdmc;// ��ǵ�����
	private EditText edit_zbxt;// ����ϵͳ
	private EditText edit_remark;// ��ע

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
	 * ˵������ʼ����ͼ
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

		text_page = (TextView) view.findViewById(R.id.textViewPage);
		text_total = (TextView) view.findViewById(R.id.textViewTotal);

		button_location = (ImageButton) view.findViewById(R.id.fragment_collection_ibtn_location);
		button_location.setOnClickListener(this);
		button_save = (ImageButton) view.findViewById(R.id.fragment_collection_ibtn_save);
		button_clear = (ImageButton) view.findViewById(R.id.fragment_collection_ibtn_clear);
		button_clear.setOnClickListener(this);
		button_save.setOnClickListener(this);
		text_tips = (TextView) view.findViewById(R.id.fragment_collection_tv_tips);
		text_tips.setText("���س��⽻����Ϣ");
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
		edit_tdsyz = (EditText) view.findViewById(R.id.edit_tdsyz);
		edit_tdzsh = (EditText) view.findViewById(R.id.edit_tdzsh);
		edit_tdzl = (EditText) view.findViewById(R.id.edit_tdzl);
		edit_qsxz = (Spinner) view.findViewById(R.id.edit_qsxz);

		/** ת��/������Ϣ **/
		edit_fwsyqr = (EditText) view.findViewById(R.id.edit_fwsyqr);// ��������Ȩ��
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
		edit_czlc = (EditText) view.findViewById(R.id.edit_czlc);// ����¥��
		edit_czyt = (Spinner) view.findViewById(R.id.edit_czyt);// ������;
		edit_czmj = (EditText) view.findViewById(R.id.edit_czmj);// ���⽨�����
		edit_czsj = (EditText) view.findViewById(R.id.edit_czsj);// ����ʱ��
		edit_zq = (EditText) view.findViewById(R.id.edit_zq);// ����(��)
		edit_nzj = (EditText) view.findViewById(R.id.edit_nzj);// �����
		edit_yj = (EditText) view.findViewById(R.id.edit_yj);// Ѻ��
		edit_sf = (EditText) view.findViewById(R.id.edit_sf);// ˰��

		/** λ����Ϣ **/
		edit_x = (EditText) view.findViewById(R.id.location_info_lon);
		edit_y = (EditText) view.findViewById(R.id.location_info_lat);
		// edit_bjdmc = (EditText) view.findViewById(R.id.location_info_bjdmc);
		edit_zbxt = (EditText) view.findViewById(R.id.location_info_zbxt);
		edit_remark = (EditText) view.findViewById(R.id.location_info_remark);

		/** ������Ϣ **/
		edit_rjl = (EditText) view.findViewById(R.id.edit_rjl);
		edit_hxwkfsp = (Spinner) view.findViewById(R.id.edit_hxwkfsp);// spinner
		edit_hxnkfsp = (Spinner) view.findViewById(R.id.edit_hxnkfsp);// spinner
		edit_tdjb = (Spinner) view.findViewById(R.id.edit_tdjb);// spinner
		edit_djqd = (EditText) view.findViewById(R.id.edit_djqd);
		edit_xzqdm = (EditText) view.findViewById(R.id.edit_xzqdm);

		/** �󶨴����¼� **/
		edit_jgsj.setOnTouchListener(this);
		edit_zxsj.setOnTouchListener(this);
		edit_czsj.setOnTouchListener(this);
		edit_zq.setOnTouchListener(this);
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

	/**
	 * ������Χ��������
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
							Toast.makeText(getActivity(), "���ܳ���100", Toast.LENGTH_SHORT).show();
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
							Toast.makeText(getActivity(), "���ܳ���100", Toast.LENGTH_SHORT).show();
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
							Toast.makeText(getActivity(), "���ܳ���100", Toast.LENGTH_SHORT).show();
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
							Toast.makeText(getActivity(), "���ܳ���100", Toast.LENGTH_SHORT).show();
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
							Toast.makeText(getActivity(), "���ܳ���100", Toast.LENGTH_SHORT).show();
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
		// ��ȡ��Ļ����
		DisplayMetrics metric = new DisplayMetrics();
		getParentFragment().getActivity().getWindowManager().getDefaultDisplay().getMetrics(metric);
		int width = metric.widthPixels; // ��Ļ��ȣ����أ�
		int height = metric.heightPixels; // ��Ļ�߶ȣ����أ�

		int id = arg0.getId();
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
				locationInfo.setCollectionType(CollectType.Collection_Market_Business_House_Rent);
				// ����ID
				locationInfo.setCollectionMainType(CollectType.Business);
				locationInfo.setCollectionTableName(CollectType.Collection_Market_Business_House_Rent_Tablename);// ����
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
						AttachmentUtil attachmentUtil=new AttachmentUtil();
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

				text_page.setText("��" + (imagePathListIndex + 1) + "��");
				text_total.setText(",��" + imagePathList.size() + "��");
			}
		}
	}

	/**
	 * �ѳ����������Ƭ�ŵ� SD���� PicturesĿ¼�� upload �ļ�����
	 * ��Ƭ����������Ϊ��image_20130125_173729.jpg
	 * 
	 * @return TODO
	 * @throws IOException
	 */
	@SuppressLint("SimpleDateFormat")
	private File createImageFile() throws IOException {

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd_HHmmss");
		String timeStamp = format.format(new Date());
		String imageFileName = "image_" + timeStamp + ".jpg";

		File image = new File(PictureUtil.getAlbumDir(), imageFileName);
		mCurrentPhotoPath = image.getAbsolutePath();
		return image;
	}

	private void getPhotoImage() {
		String[] items = { "����", "ѡ��ͼƬ", "ɾ��" };
		new AlertDialog.Builder(getActivity()).setTitle("ѡ�����").setItems(items, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				if (which == 0) {
					Intent getImageByCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
					try {
						// ָ�����������Ƭ��λ��
						File f = createImageFile();
						getImageByCamera.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
						startActivityForResult(getImageByCamera, ComUtil.RequestCode_Photo);
					} catch (Exception e) {
						e.printStackTrace();
					}
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
						}

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
		ModelCollectionMarketBusinessHouseRent model = new ModelCollectionMarketBusinessHouseRent();
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
		if (!value_jgsj.equals("")) {
			model.setJGSJ(value_jgsj);// ����ʱ��
		}
		model.setFWCXD(value_fwcxd);// ���ݳ��¶�
		if (!value_zxsj.equals("")) {
			model.setZXSJ(value_zxsj);// װ��ʱ��
		}
		model.setZXCD(value_zxcd);// װ�޳̶�
		model.setCZLC(value_czlc);// ����¥��
		model.setCZYT(value_czyt);// ������;
		model.setCZMJ(value_czmj);// ���⽨�����
		if (!value_czsj.equals("")) {
			model.setCZSJ(value_czsj);// ����ʱ��
		}
		if (!value_czsj.equals("")) {
			model.setZQ(value_zq);// ���ڣ��꣩
		}
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

			/** ����ʱ�� **/
			if (v.getId() == R.id.edit_jgsj) {
				final int inType = edit_jgsj.getInputType();
				edit_jgsj.setInputType(InputType.TYPE_NULL);
				edit_jgsj.onTouchEvent(event);
				edit_jgsj.setInputType(inType);
				// edit_jgsj.setSelection(edit_jgsj.getText().length());

				builder.setTitle("ѡȡ����ʱ��");
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
			/** װ��ʱ�� **/
			else if (v.getId() == R.id.edit_zxsj) {
				final int inType = edit_zxsj.getInputType();
				edit_zxsj.setInputType(InputType.TYPE_NULL);
				edit_zxsj.onTouchEvent(event);
				edit_zxsj.setInputType(inType);
				edit_zxsj.setSelection(edit_zxsj.getText().length());

				builder.setTitle("ѡȡװ��ʱ��");
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

				builder.setTitle("ѡȡ����");
				builder.setPositiveButton("ȷ  ��", new DialogInterface.OnClickListener() {

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

		// TODO:��ȡ���ص�ͼƬ����
		if (requestCode == ComUtil.RequestCode_Photo_Value) {

			try {
				// ���ж��Ƿ��Ѿ�����
				if (camorabitmap != null && !camorabitmap.isRecycled()) {
					camorabitmap.recycle();
					camorabitmap = null;
				}
				// ��ӵ�ͼ��,�����������ֻ���ͼ������п��������������Ƭ
				PictureUtil.galleryAddPic(this.getActivity(), mCurrentPhotoPath);

				camorabitmap = PictureUtil.getSmallBitmap(mCurrentPhotoPath);
				image_photo.setImageBitmap(camorabitmap);
				imagePathList.add(mCurrentPhotoPath);
				imagePathListIndex = imagePathList.size() - 1;

				text_page.setText("��" + (imagePathListIndex + 1) + "��");
				text_total.setText(",��" + imagePathList.size() + "��");

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (requestCode == ComUtil.RequestCode_Album) {
			try {
				// ���ж��Ƿ��Ѿ�����
				if (camorabitmap != null && !camorabitmap.isRecycled()) {
					camorabitmap.recycle();
					camorabitmap = null;
				}
				Uri originalUri = data.getData(); // ���ͼƬ��uri
				mCurrentPhotoPath = ImageUtil.getImageAbsolutePath(getActivity(), originalUri);
				// �������ڱ��ص�ͼƬȡ������������С����ʾ�ڽ�����
				camorabitmap = PictureUtil.getSmallBitmap(mCurrentPhotoPath);

				image_photo.setImageBitmap(camorabitmap);
				imagePathList.add(mCurrentPhotoPath);
				imagePathListIndex = imagePathList.size() - 1;

				text_page.setText("��" + (imagePathListIndex + 1) + "��");
				text_total.setText(",��" + imagePathList.size() + "��");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}