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
import com.example.town_land_collect.model.market_supply.ModelCollectionMarketSupplySell;
import com.example.town_land_collect.util.AttachmentUtil;
import com.example.town_land_collect.util.CollectType;
import com.example.town_land_collect.util.ComUtil;
import com.example.town_land_collect.util.CommonTypeUtil;
import com.example.town_land_collect.util.ImageUtil;
import com.example.town_land_collect.util.ToastUtil;

/**
 * 
 * @Title Collection_Market_Supply_Sell.java
 * @Package com.example.town_land_collect.fragment_market_supply
 * @Description ����ʹ��Ȩ������Ϣ
 * @author Shen.dev
 * @date 2015-10-14 ����5:22:00
 * @version V1.0
 */
@SuppressLint({ "CutPasteId", "ClickableViewAccessibility" })
public class Collection_Market_Supply_Sell extends Fragment implements OnClickListener, OnTouchListener {
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

	/** ����ʹ��Ȩ���ù�Ӧ��Ϣ **/
	private int index_crfs = 0;// ����÷�ʽ
	private int index_sfzkf = 0;// �Ƿ��ٿ���
	private int index_sflyd = 0;// �Ƿ����õ�
	private int index_crqyt = 0;// ����ǰ��;
	private int index_crhghyt = 0;// ���ú�滮��;
	/** ������Ϣ.�ؼ� **/
	private int index_ghhxwkfsp = 0;// �����⿪��ˮƽ
	private int index_ghhxnkfsp = 0;// �����ڿ���ˮƽ
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
	/** ����ʹ��Ȩ���ù�Ӧ��Ϣ **/
	private EditText edit_tdsyz;// ����ʹ����
	private EditText edit_zdbh;// �ڵر��
	private EditText edit_tdzl;// ��������
	private Spinner edit_qsxz;// Ȩ������
	private EditText edit_ncrsj;// �����ʱ��
	private Spinner edit_crfs;// ����÷�ʽ
	private EditText edit_ncrnq;// ���������
	private Spinner edit_sfzkf;// �Ƿ��ٿ���
	private Spinner edit_sflyd;// �Ƿ����õ�
	private EditText edit_ghtdmj;// �滮���߷�Χ�������
	private EditText edit_ndztdmj;// ������������
	private Spinner edit_crqyt;// ����ǰ��;
	private Spinner edit_crhghyt;// ���ú�滮��;
	private EditText edit_ncrdj;// �ⵥλ������س��ü�
	private EditText edit_ncrzj;// �����س����ܼ�

	/** ������Ϣ.�ؼ� **/
	private EditText edit_ghrjl;// �滮�ڵ��ݻ���
	private Spinner edit_ghhxwkfsp;// �滮�����⿪��ˮƽ
	private Spinner edit_ghhxnkfsp;// �滮�����ڿ���ˮƽ
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
	/** ����ʹ��Ȩ���ù�Ӧ��Ϣ **/
	private String value_tdsyz;// ����ʹ����
	private String value_zdbh;// �ڵر��
	private String value_tdzl;// ��������
	private String value_qsxz;// Ȩ������
	private String value_ncrsj;// �����ʱ��
	private String value_crfs;// ����÷�ʽ
	private String value_ncrnq;// ���������
	private String value_sfzkf;// �Ƿ��ٿ���
	private String value_sflyd;// �Ƿ����õ�
	private String value_ghtdmj;// �滮���߷�Χ�������
	private String value_ndztdmj;// ������������
	private String value_crqyt;// ����ǰ��;
	private String value_crhghyt;// ���ú�滮��;
	private String value_ncrdj;// �ⵥλ������س��ü�
	private String value_ncrzj;// �����س����ܼ�

	/** ������Ϣ **/
	private String value_ghrjl;// �滮�ڵ��ݻ���
	private String value_ghhxwkfsp;// �滮�����⿪��ˮƽ
	private String value_ghhxnkfsp;// �滮�����ڿ���ˮƽ
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
	/** ����ʹ��Ȩ���ù�Ӧ��Ϣ **/
	private ArrayList<String> list_crfs = new ArrayList<String>();// ����÷�ʽ
	private ArrayList<String> list_sfzkf = new ArrayList<String>();// �Ƿ��ٿ���
	private ArrayList<String> list_sflyd = new ArrayList<String>();// �Ƿ����õ�
	private ArrayList<String> list_crqyt = new ArrayList<String>();// ����ǰ��;
	private ArrayList<String> list_crhghyt = new ArrayList<String>();// ���ú�滮��;
	/** ������Ϣ .Spinner **/
	private ArrayList<String> list_ghhxwkfsp = new ArrayList<String>();// �����⿪��ˮƽ
	private ArrayList<String> list_ghhxnkfsp = new ArrayList<String>();// �����ڿ���ˮƽ
	private ArrayList<String> list_tdjb = new ArrayList<String>();// �������ؼ���

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = (View) inflater.inflate(R.layout.collection_market_supply_sell_frame, container, false);
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
		textView_Tips.setText("����ʹ��Ȩ���ù�Ӧ��Ϣ");
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
		/** ����ʹ��Ȩ���ù�Ӧ��Ϣ **/
		edit_tdsyz = (EditText) view.findViewById(R.id.edit_tdsyz);
		edit_zdbh = (EditText) view.findViewById(R.id.edit_zdbh);// �ڵر��
		edit_tdzl = (EditText) view.findViewById(R.id.edit_tdzl);
		edit_qsxz = (Spinner) view.findViewById(R.id.edit_qsxz);
		edit_ncrsj = (EditText) view.findViewById(R.id.edit_ncrsj);// �����ʱ��
		edit_crfs = (Spinner) view.findViewById(R.id.edit_crfs);// ����÷�ʽ
		edit_ncrnq = (EditText) view.findViewById(R.id.edit_ncrnq);// ���������
		edit_sfzkf = (Spinner) view.findViewById(R.id.edit_sfzkf);// �Ƿ��ٿ���
		edit_sflyd = (Spinner) view.findViewById(R.id.edit_sflyd);// �Ƿ����õ�
		edit_ghtdmj = (EditText) view.findViewById(R.id.edit_ghtdmj);// �滮���߷�Χ�������
		edit_ndztdmj = (EditText) view.findViewById(R.id.edit_ndztdmj);// ������������
		edit_crqyt = (Spinner) view.findViewById(R.id.edit_crqyt);// ����ǰ��;
		edit_crhghyt = (Spinner) view.findViewById(R.id.edit_crhghyt);// ���ú�滮��;
		edit_ncrdj = (EditText) view.findViewById(R.id.edit_ncrdj);// �ⵥλ������س��ü�
		edit_ncrzj = (EditText) view.findViewById(R.id.edit_ncrzj);// �����س����ܼ�

		/** λ����Ϣ **/
		edit_x = (EditText) view.findViewById(R.id.location_info_lon);
		edit_y = (EditText) view.findViewById(R.id.location_info_lat);
		edit_zbxt = (EditText) view.findViewById(R.id.location_info_zbxt);
		edit_remark = (EditText) view.findViewById(R.id.location_info_remark);
		/** ������Ϣ **/
		edit_ghrjl = (EditText) view.findViewById(R.id.edit_rjl);
		edit_ghhxwkfsp = (Spinner) view.findViewById(R.id.edit_hxwkfsp);// spinner
		edit_ghhxnkfsp = (Spinner) view.findViewById(R.id.edit_hxnkfsp);// spinner
		edit_tdjb = (Spinner) view.findViewById(R.id.edit_tdjb);// spinner
		edit_djqd = (EditText) view.findViewById(R.id.edit_djqd);
		edit_xzqdm = (EditText) view.findViewById(R.id.edit_xzqdm);
		/** �󶨿ؼ��¼� **/
		edit_ncrsj.setOnTouchListener(this);
	}

	/**
	 * ˵������ʼ��Spinner �ֵ��б�
	 * 
	 * @return void
	 */
	private void initSpinnerDict() {
		CommonTypeUtil typeUtil = new CommonTypeUtil();
		list_qsxz = typeUtil.initList("qsxz");// Ȩ������
		list_crfs = typeUtil.initList("zrfs");// ����÷�ʽ
		list_sfzkf = typeUtil.initList("yesno");// �Ƿ��ٿ���
		list_sflyd = typeUtil.initList("yesno");// �Ƿ����õ�
		list_crqyt = typeUtil.initList("ytlx");// ����ǰ��;
		list_crhghyt = typeUtil.initList("ytlx");// ���ú�滮��;
		list_ghhxwkfsp = typeUtil.initList("hxwkfsp");// �����⿪��ˮƽ
		list_ghhxnkfsp = typeUtil.initList("hxnkfsp");// �����ڿ���ˮƽ
		list_tdjb = typeUtil.initList("tdjb");// �������ؼ���

		value_qsxz = list_qsxz.get(0);
		value_crfs = list_crfs.get(0);
		value_sfzkf = list_sfzkf.get(0);
		value_sflyd = list_sflyd.get(0);
		value_crqyt = list_crqyt.get(0);
		value_crhghyt = list_crhghyt.get(0);
		value_ghhxwkfsp = list_ghhxwkfsp.get(0);
		value_ghhxnkfsp = list_ghhxnkfsp.get(0);
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

		/** ����÷�ʽ **/
		edit_crfs.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_crfs = list_crfs.get(index);
				index_crfs = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		/** �Ƿ��ٿ��� **/
		edit_sfzkf.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_sfzkf = list_sfzkf.get(index);
				index_sfzkf = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		/** �Ƿ����õ� **/
		edit_sflyd.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_sflyd = list_sflyd.get(index);
				index_sflyd = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		/** ����ǰ��; **/
		edit_crqyt.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_crqyt = list_crqyt.get(index);
				index_crqyt = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		/** ���ú�滮��; **/
		edit_crhghyt.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_crhghyt = list_crhghyt.get(index);
				index_crhghyt = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});

		/** �����⿪��ˮƽ **/
		edit_ghhxwkfsp.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_ghhxwkfsp = list_ghhxwkfsp.get(index);
				index_ghhxwkfsp = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		/** �����ڿ���ˮƽ **/
		edit_ghhxnkfsp.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_ghhxnkfsp = list_ghhxnkfsp.get(index);
				index_ghhxnkfsp = index;
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
				locationInfo.setCollectionType(CollectType.Collection_Market_Supply_Sell);
				// ����ID
				locationInfo.setCollectionMainType(CollectType.Supply);
				locationInfo.setCollectionTableName(CollectType.Collection_Market_Supply_Sell_Tablename);// ����
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
		/** ����ʹ��Ȩ���ù�Ӧ��Ϣ **/
		value_tdsyz = edit_tdsyz.getText().toString();// ����������
		value_zdbh = edit_zdbh.getText().toString();// �ڵر��
		value_tdzl = edit_tdzl.getText().toString();// ��������
		value_ncrsj = edit_ncrsj.getText().toString();// �����ʱ��
		value_ncrnq = edit_ncrnq.getText().toString();// ���������
		value_ghtdmj = edit_ghtdmj.getText().toString();// �滮���߷�Χ�������
		value_ndztdmj = edit_ndztdmj.getText().toString();// ������������
		value_ncrdj = edit_ncrdj.getText().toString();// �ⵥλ������س��ü�
		value_ncrzj = edit_ncrzj.getText().toString();// �����س����ܼ�
		/** λ����Ϣ.���� **/
		value_x = edit_x.getText().toString();// ����
		value_y = edit_y.getText().toString();// γ��
		value_zbxt = edit_zbxt.getText().toString();// ����ϵͳ
		value_remark = edit_remark.getText().toString();// ��ע
		/** ������Ϣ **/
		value_ghrjl = edit_ghrjl.getText().toString();// �滮�ڵ��ݻ���
		value_djqd = edit_djqd.getText().toString();// ���ڵ�ַ����
		value_xzqdm = edit_xzqdm.getText().toString();// ����������
	}

	/**
	 * ˵��������ɼ���Ϣ���ֱ�
	 * 
	 * @return id
	 */
	private int saveCollectionInfo() {
		int result = 0;
		setCollectionInfo();
		ModelCollectionMarketSupplySell model = new ModelCollectionMarketSupplySell();
		/** ������Ϣ **/
		model.setTHENAME(value_the_name);// ��¼����
		model.setTHECODE(value_the_code);// ��¼����
		/** ����ʹ��Ȩ���ù�Ӧ��Ϣ **/
		model.setTDSYZ(value_tdsyz);// ����������
		model.setZDBH(value_zdbh);// �ڵر��
		model.setTDZL(value_tdzl);// ��������
		model.setQSXZ(value_qsxz);// Ȩ������
		model.setNCRSJ(value_ncrsj);// �����ʱ��
		model.setCRFS(value_crfs);// ����÷�ʽ
		model.setNCRNQ(value_ncrnq);// ���������
		model.setSFZKF(value_sfzkf);// �Ƿ��ٿ���
		model.setSFLYD(value_sflyd);// �Ƿ����õ�
		model.setGHTDMJ(value_ghtdmj);// �滮���߷�Χ�������
		model.setNDZTDMJ(value_ndztdmj);// ������������
		model.setCRQYT(value_crqyt);// ����ǰ��;
		model.setCRHGHYT(value_crhghyt);// ���ú�滮��;
		model.setNCRDJ(value_ncrdj);// �ⵥλ������س��ü�
		model.setNCRZJ(value_ncrzj);// �����س����ܼ�

		/** λ����Ϣ **/
		model.setX(value_x);// ����
		model.setY(value_y);// γ��
		model.setZBXT(value_zbxt);// ����ϵͳ
		model.setREMARK(value_remark);// ��ע

		/** ������Ϣ **/
		model.setGHRJL(value_ghrjl);// �ڵ��ݻ���
		model.setGHHXWKFSP(value_ghhxwkfsp);// �����⿪��ˮƽ
		model.setGHHXNKFSP(value_ghhxnkfsp);// �����ڿ���ˮƽ
		model.setTDJB(value_tdjb); // �������ؼ���
		model.setDJQD(value_djqd);// ���ڵؼ�����
		model.setXZQDM(value_xzqdm);// ���������루�弶��������

		/** ��ֵ�����ֶ� **/
		model.setIndex_qsxz(index_qsxz);// Ȩ������
		model.setIndex_crfs(index_crfs);// ����÷�ʽ
		model.setIndex_sfzkf(index_sfzkf);// �Ƿ��ٿ���
		model.setIndex_sflyd(index_sflyd);// �Ƿ����õ�
		model.setIndex_crqyt(index_crqyt);// ����ǰ��;
		model.setIndex_crhghyt(index_crhghyt);// ���ú�滮��;
		model.setIndex_ghhxwkfsp(index_ghhxwkfsp);// �����⿪��ˮƽ
		model.setIndex_ghhxnkfsp(index_ghhxnkfsp);// �����ڿ���ˮƽ
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

			if (v.getId() == R.id.edit_ncrsj) {
				final int inType = edit_ncrsj.getInputType();
				edit_ncrsj.setInputType(InputType.TYPE_NULL);
				edit_ncrsj.onTouchEvent(event);
				edit_ncrsj.setInputType(inType);
				edit_ncrsj.setSelection(edit_ncrsj.getText().length());

				builder.setTitle("ѡȡ����ʱ��");
				builder.setPositiveButton("ȷ  ��", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

						StringBuffer sb = new StringBuffer();
						sb.append(String.format("%d-%02d-%02d", datePicker.getYear(), datePicker.getMonth() + 1, datePicker.getDayOfMonth()));
						sb.append("  00:00:00");

						edit_ncrsj.setText(sb);
						edit_ncrsj.requestFocus();

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