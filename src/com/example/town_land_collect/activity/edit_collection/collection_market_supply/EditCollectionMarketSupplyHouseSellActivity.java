package com.example.town_land_collect.activity.edit_collection.collection_market_supply;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.litepal.crud.DataSupport;

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
import android.text.InputType;
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
import com.example.town_land_collect.model.market_supply.ModelCollectionMarketSupplyHouseSell;
import com.example.town_land_collect.util.CollectType;
import com.example.town_land_collect.util.ComUtil;
import com.example.town_land_collect.util.CommonTypeUtil;
import com.example.town_land_collect.util.ImageUtil;
import com.example.town_land_collect.util.ToastUtil;

/**
 * ����ʹ��Ȩ���⽻����Ϣ
 * 
 * @author Eric
 * 
 */
public class EditCollectionMarketSupplyHouseSellActivity extends ActionBarActivity implements OnClickListener, OnTouchListener {
	private String imagePathString = null;
	// TODO ͼƬ���
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
	/** ��������Ϣ **/
	private int index_tdyt = 0;// ������;
	private int index_czqyt = 0;// ����ǰ��;
	private int index_czhyt = 0;// �������;
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

	/**
	 * ���س�����Ϣ
	 */
	private EditText edit_chuzf;// ���ⷽ
	private EditText edit_chengzf;// ���ⷽ
	private EditText edit_czsj;// ����ʱ��
	private EditText edit_zq;// ����
	private EditText edit_czmj;// ���س������
	private Spinner edit_czqyt;// ����ǰ��;
	private Spinner edit_czhyt;// �������;
	private EditText edit_tdsynq;// ����ʣ��ʹ������
	private EditText edit_nzj;// �����
	private EditText edit_yj;// Ѻ��
	private EditText edit_sf;// ˰��

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

	private String value_chuzf;
	private String value_chengzf;
	private String value_czsj;
	private String value_zq;
	private String value_czmj;
	private String value_czqyt;
	private String value_czhyt;
	private String value_tdsynq;
	private String value_nzj;
	private String value_yj;
	private String value_sf;

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
	private String value_bjdmc;// ��ǵ�����
	private String value_zbxt;// ����ϵͳ
	private String value_remark;// ��ע

	/** Spinner Dict **/
	/** ������Ϣ .Spinner **/
	private ArrayList<String> list_qsxz = new ArrayList<String>();// Ȩ������

	// TODO ���������б�
	/** ������Ϣ .Spinner **/
	private ArrayList<String> list_tdyt = new ArrayList<String>();// ������;
	private ArrayList<String> list_jzlx = new ArrayList<String>();// ��������
	private ArrayList<String> list_fwjg = new ArrayList<String>();// ���ݽṹ
	private ArrayList<String> list_fwcxd = new ArrayList<String>();// ���ݳ��¶�
	private ArrayList<String> list_zxcd = new ArrayList<String>();// װ�޳̶�
	private ArrayList<String> list_csyt = new ArrayList<String>();// ������;

	/** ������Ϣ .Spinner **/
	private ArrayList<String> list_hxwkfsp = new ArrayList<String>();// �����⿪��ˮƽ
	private ArrayList<String> list_hxnkfsp = new ArrayList<String>();// �����ڿ���ˮƽ
	private ArrayList<String> list_tdjb = new ArrayList<String>();// �������ؼ���

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.collection_market_supply_house_sell_frame_detail);
		/** ��ʼ���ؼ� **/
		initView();
		initEditText();
		/** ��ʼ������ **/
		initLayout();
		initModel();
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
				// TODO
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
		image_photo.setOnClickListener(this); // TODO ͼƬѡ��ť�ؼ�
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
		text_tips.setText("���س��ù�Ӧ��Ϣ");// TODO �޸���ʾ��Ϣ
	}

	/**
	 * ˵������ʼ��ʵ����ʾ
	 * 
	 * @return void
	 */
	private void initModel() {
		ModelCollectionMarketSupplyHouseSell model = DataSupport.find(ModelCollectionMarketSupplyHouseSell.class, locationInfo.getCollectionId());
		if (model != null) {
			/** ������Ϣ **/
			setEditText(R.id.edit_the_name, "THENAME", model.getTHENAME());// ��¼����
			setEditText(R.id.edit_the_code, "THECODE", model.getTHECODE());// ��¼����
			setEditText(R.id.edit_tdsyz, "TDSYZ", model.getTDSYZ());// ����������
			setEditText(R.id.edit_tdzsh, "TDZSH", model.getTDZSH());// ����֤���
			setEditText(R.id.edit_tdzl, "TDZL", model.getTDZL());// ��������
			setEditText(R.id.edit_qsxz, "QSXZ", model.getQSXZ());// Ȩ������

			/** ���س��۹�Ӧ��Ϣ **/
			setEditText(R.id.edit_tdsyz, "TDSYZ", model.getTDSYZ());// ����ʹ����
			setEditText(R.id.edit_fwsyqr, "FWSYQR", model.getFWSYQR());// ��������Ȩ��
			setEditText(R.id.edit_tdzsh, "TDZSH", model.getTDZSH());// ����֤���
			setEditText(R.id.edit_yszsh, "YSZSH", model.getYSZSH());// Ԥ��֤���
			setEditText(R.id.edit_tdzl, "TDZL", model.getTDZL());// ��������
			setEditText(R.id.edit_qsxz, "QSXZ", model.getQSXZ());// Ȩ������
			setEditText(R.id.edit_fdsynq, "FDSYNQ", model.getFDSYNQ());// ����ʣ��ʹ������
			setEditText(R.id.edit_sfesf, "SFESF", model.getSFESF());// �Ƿ���ַ�
			setEditText(R.id.edit_sfzaj, "SFZAJ", model.getSFZAJ());// �Ƿ�ת����
			setEditText(R.id.edit_cczt, "CCZT", model.getCCZT());// ����״̬
			setEditText(R.id.edit_dyzt, "DYZT", model.getDYZT());// ��Ѻ״̬
			setEditText(R.id.edit_tdyt, "TDYT", model.getTDYT());// ������;
			setEditText(R.id.edit_ljkd, "LJKD", model.getLJKD());// �ٽֿ��
			setEditText(R.id.edit_ljsd, "LJSD", model.getLJSD());// �ٽ����
			setEditText(R.id.edit_jzlx, "JZLX", model.getJZLX());// ��������
			setEditText(R.id.edit_jzcs, "JZCS", model.getJZCS());// ��������
			setEditText(R.id.edit_fwjg, "FWJG", model.getFWJG());// ���ݽṹ
			setEditText(R.id.edit_jgsj, "JGSJ", model.getJGSJ());// ����ʱ��
			setEditText(R.id.edit_fwcxd, "FWCXD", model.getFWCXD());// ���ݳ��¶�
			setEditText(R.id.edit_zxsj, "ZXSJ", model.getZXSJ());// װ��ʱ��
			setEditText(R.id.edit_zxcd, "ZXCD", model.getZXCD());// װ�޳̶�
			setEditText(R.id.edit_zzhx, "ZZHX", model.getZZHX());// סլ����
			setEditText(R.id.edit_ptss, "PTSS", model.getPTSS());// ������ʩ
			setEditText(R.id.edit_zbjt, "ZBJT", model.getZBJT());// �ܱ߽�ͨ
			setEditText(R.id.edit_ncslc, "NCSLC", model.getNCSLC());// �����¥��
			setEditText(R.id.edit_ncsyt, "NCSYT", model.getNCSYT());// �������;
			setEditText(R.id.edit_ncsmj, "NCSMJ", model.getNCSMJ());// ����۽������
			setEditText(R.id.edit_ncssj, "NCSSJ", model.getNCSSJ());// �����ʱ��
			setEditText(R.id.edit_ndwmjsj, "NDWMJSJ", model.getNDWMJSJ());// �ⵥλ����ۼ�
			setEditText(R.id.edit_nsj, "NSJ", model.getNSJ());// ���ۼ�
			setEditText(R.id.edit_nsf, "NSF", model.getNSF());// ��˰��

			/** ������Ϣ **/
			setEditText(R.id.edit_rjl, "edit_tdzl", model.getRJL());// �ڵ��ݻ���
			setEditText(R.id.edit_hxwkfsp, "edit_tdzl", model.getHXWKFSP());// �����⿪��ˮƽ
			setEditText(R.id.edit_hxnkfsp, "edit_tdzl", model.getHXNKFSP());// �����ڿ���ˮƽ
			setEditText(R.id.edit_tdjb, "TDJB", model.getTDJB());// �������ؼ���
			setEditText(R.id.edit_djqd, "DJQD", model.getDJQD());// ���ڵؼ�����
			setEditText(R.id.edit_xzqdm, "XZQDM", model.getXZQDM());// ����������

			/** λ����Ϣ **/
			setEditText(R.id.location_info_lon, "X", model.getX());// X����
			setEditText(R.id.location_info_lat, "Y", model.getY());// Y����
			setEditText(R.id.location_info_zbxt, "ZBXT", model.getZBXT());// ����ϵͳ
			setEditText(R.id.location_info_remark, "REMARK", model.getREMARK());// ��ע
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
		// edit_czsj.setOnTouchListener(this);
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
		list_csyt = typeUtil.initList("ytlx");// ������;
		list_hxwkfsp = typeUtil.initList("hxwkfsp");// �����⿪��ˮƽ
		list_hxnkfsp = typeUtil.initList("hxnkfsp");// �����ڿ���ˮƽ
		list_tdjb = typeUtil.initList("tdjb");// �������ؼ���

		value_qsxz = list_qsxz.get(0);
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
		/** ����ǰ��; **/
		edit_czqyt.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_czqyt = list_tdyt.get(index);
				index_tdyt = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		/** �������; **/
		edit_czhyt.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_czhyt = list_tdyt.get(index);
				index_tdyt = index;
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
			if (v.getId() == R.id.edit_czsj) {
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

	@Override
	public void onClick(View arg0) { // TODO
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
		// TODO ͼƬ��ؿؼ�
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
				locationInfo.setCollectionType(CollectType.Collection_Market_Business_House_Rent);// TODO
																									// �洢��ʵ������
				/*
				 * int collectionId = saveCollectionInfo(); if (collectionId !=
				 * 0) { locationInfo.setCollectionId(collectionId); try {
				 * locationInfo.update(locationInfo.getId());// ����LogCat��׽�쳣��Ϣ
				 * ToastUtil.ToastStr(this, "���³ɹ�", 2000); } catch
				 * (DataSupportException e) { Log.d("TAG", e.toString());
				 * ToastUtil.ToastStr(this, e.toString(), 2000);
				 * ToastUtil.ToastStr(this, "����ʧ��", 2000); } } else {
				 * ToastUtil.ToastStr(this, "����ʧ��", 2000); }
				 */
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
						}// TODO
						text_page.setText("��" + (imagePathListIndex + 1) + "��");
						text_total.setText(",��" + imagePathList.size() + "��");
					}
				}
			}
		}).show();
	}

	private void setEditText(int id, String name, String text) {
		try {
			EditText editText = (EditText) findViewById(id);
			if (editText != null) {
				editText.setText(text);
			}
		} catch (Exception e) {
			Log.d("NotFindControl", "������IdΪ��" + name + "��EditText�ؼ�");
			try {
				Spinner spinner = (Spinner) findViewById(id);
				if (spinner != null) {
					Log.d("NotFindControl", "�ؼ�IdΪ��" + name + "����Spinner���ͣ����޸ģ���");
				} else {
					Log.d("NotFindControl", "������IdΪ��" + name + "�Ŀؼ����Ƿ�Ϊȱ��ҳ�涨��");
				}
			} catch (Exception ex) {
				Log.d("NotFindControl", "������IdΪ��" + name + "�Ŀؼ����Ƿ�Ϊȱ��ҳ�涨��");
			}
		}
	}

	private void setSpinnerSelection(int id, String name, int position) {
		try {
			Spinner spinner = (Spinner) findViewById(id);
			if (spinner != null) {
				spinner.setSelection(position);
			}
		} catch (Exception e) {
			Log.d("NotFindControl", "������IdΪ��" + name + "�Ŀؼ����Ƿ�Ϊȱ��ҳ�涨��");
		}
	}

	private void setEditText(int id, String text) {
		try {
			EditText editText = (EditText) findViewById(id);
			if (editText != null) {
				editText.setText(text);
			}
		} catch (Exception e) {
			Log.d("NotFindControl", "�����ڸ�EditText�ؼ�");
			try {
				Spinner spinner = (Spinner) findViewById(id);
				if (spinner != null) {
					Log.d("NotFindControl", "�ÿؼ�ΪSpinner���ͣ����޸ģ���");
				} else {
					Log.d("NotFindControl", "�����ڸÿؼ����Ƿ�Ϊȱ��ҳ�涨��");
				}
			} catch (Exception ex) {
				Log.d("NotFindControl", "�����ڸÿؼ����Ƿ�Ϊȱ��ҳ�涨��");
			}
		}
	}
}
