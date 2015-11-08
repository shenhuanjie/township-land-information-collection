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
import com.example.town_land_collect.model.market_supply.ModelCollectionMarketSupplyShareHolder;
import com.example.town_land_collect.util.AttachmentUtil;
import com.example.town_land_collect.util.CollectType;
import com.example.town_land_collect.util.ComUtil;
import com.example.town_land_collect.util.CommonTypeUtil;
import com.example.town_land_collect.util.ImageUtil;
import com.example.town_land_collect.util.ToastUtil;

/**
 * 
 * @Title Collection_Market_Supply_ShareHolder.java
 * @Package com.example.town_land_collect.fragment_market_supply
 * @Description ������Ӫ��ɹ�Ӧ��Ϣ
 * @author Shen.dev
 * @date 2015-10-14 ����5:22:38
 * @version V1.0
 */
@SuppressLint({ "CutPasteId", "ClickableViewAccessibility" })
public class Collection_Market_Supply_ShareHolder extends Fragment implements OnClickListener, OnTouchListener {
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
	private int index_lyqyt = 0;// ��Ӫǰ��;
	private int index_lyhghyt = 0;// ��Ӫ��滮��;
	/** ������Ϣ.�ؼ� **/
	private int index_ghhxwkfsp = 0;// �����⿪��ˮƽ
	private int index_ghhxnkfsp = 0;// �����ڿ���ˮƽ
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
	/** ������Ӫ��ɹ�Ӧ��Ϣ **/
	private EditText edit_tdsyz;// ����ʹ����
	private EditText edit_tdzsh;// ����֤���
	private EditText edit_tdzl;// ��������
	private Spinner edit_qsxz;// Ȩ������
	private EditText edit_cdf;// ���ط�
	private EditText edit_nlysj;// ����Ӫʱ��
	private EditText edit_nlyq;// ����Ӫ��
	private EditText edit_ncdmj;// ����ط�Ͷ���������
	private EditText edit_nczze;// ����ʷ�Ͷ���ʽ��ܶ�
	private EditText edit_ncdffcbl;// ����ط�����ֳɱ���
	private EditText edit_ntdncsr;// �ⵥλ��������괿����
	private EditText edit_ncdfncsr;// ����ط������괿����
	private Spinner edit_lyqyt;// ��Ӫǰ��;
	private Spinner edit_lyhghyt;// ��Ӫ��滮��;

	/** ������Ϣ.�ؼ� **/
	private EditText edit_ghrjl;// �ݻ���
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
	/** ������Ӫ��ɹ�Ӧ��Ϣ **/
	private String value_tdsyz;// ����ʹ����
	private String value_tdzsh;// ����֤���
	private String value_tdzl;// ��������
	private String value_qsxz;// Ȩ������
	private String value_cdf;// ���ط�
	private String value_nlysj;// ����Ӫʱ��
	private String value_nlyq;// ����Ӫ��
	private String value_ncdmj;// ����ط�Ͷ���������
	private String value_nczze;// ����ʷ�Ͷ���ʽ��ܶ�
	private String value_ncdffcbl;// ����ط�����ֳɱ���
	private String value_ntdncsr;// �ⵥλ��������괿����
	private String value_ncdfncsr;// ����ط������괿����
	private String value_lyqyt;// ��Ӫǰ��;
	private String value_lyhghyt;// ��Ӫ��滮��;
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
	/** ������Ӫ��ɹ�Ӧ��Ϣ **/
	private ArrayList<String> list_lyqyt = new ArrayList<String>();// ����ǰ��;
	private ArrayList<String> list_lyhghyt = new ArrayList<String>();// ���ú�滮��;
	/** ������Ϣ .Spinner **/
	private ArrayList<String> list_hxwkfsp = new ArrayList<String>();// �����⿪��ˮƽ
	private ArrayList<String> list_hxnkfsp = new ArrayList<String>();// �����ڿ���ˮƽ
	private ArrayList<String> list_tdjb = new ArrayList<String>();// �������ؼ���

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = (View) inflater.inflate(R.layout.collection_market_supply_share_holder_frame, container, false);
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
		textView_Tips.setText("������Ӫ��ɹ�Ӧ��Ϣ");
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
		/** ������Ӫ��ɹ�Ӧ��Ϣ **/
		edit_tdsyz = (EditText) view.findViewById(R.id.edit_tdsyz);// ����ʹ����
		edit_tdzsh = (EditText) view.findViewById(R.id.edit_tdzsh);// ����֤���
		edit_tdzl = (EditText) view.findViewById(R.id.edit_tdzl);// ��������
		edit_qsxz = (Spinner) view.findViewById(R.id.edit_qsxz);// Ȩ������
		edit_cdf = (EditText) view.findViewById(R.id.edit_cdf);// ���ط�
		edit_nlysj = (EditText) view.findViewById(R.id.edit_nlysj);// ����Ӫʱ��
		edit_nlyq = (EditText) view.findViewById(R.id.edit_nlyq);// ����Ӫ��
		edit_ncdmj = (EditText) view.findViewById(R.id.edit_ncdmj);// ����ط�Ͷ���������
		edit_nczze = (EditText) view.findViewById(R.id.edit_nczze);// ����ʷ�Ͷ���ʽ��ܶ�
		edit_ncdffcbl = (EditText) view.findViewById(R.id.edit_ncdffcbl);// ����ط�����ֳɱ���
		edit_ntdncsr = (EditText) view.findViewById(R.id.edit_ntdncsr);// �ⵥλ��������괿����
		edit_ncdfncsr = (EditText) view.findViewById(R.id.edit_ncdfncsr);// ����ط������괿����
		edit_lyqyt = (Spinner) view.findViewById(R.id.edit_lyqyt);// ��Ӫǰ��;
		edit_lyhghyt = (Spinner) view.findViewById(R.id.edit_lyhghyt);// ��Ӫ��滮��;
		/** λ����Ϣ **/
		edit_x = (EditText) view.findViewById(R.id.location_info_lon);
		edit_y = (EditText) view.findViewById(R.id.location_info_lat);
		edit_zbxt = (EditText) view.findViewById(R.id.location_info_zbxt);
		edit_remark = (EditText) view.findViewById(R.id.location_info_remark);
		/** ������Ϣ **/
		edit_ghrjl = (EditText) view.findViewById(R.id.edit_rjl);
		edit_hxwkfsp = (Spinner) view.findViewById(R.id.edit_hxwkfsp);// spinner
		edit_hxnkfsp = (Spinner) view.findViewById(R.id.edit_hxnkfsp);// spinner
		edit_tdjb = (Spinner) view.findViewById(R.id.edit_tdjb);// spinner
		edit_djqd = (EditText) view.findViewById(R.id.edit_djqd);
		edit_xzqdm = (EditText) view.findViewById(R.id.edit_xzqdm);

		/** �󶨿ؼ��¼� **/
		edit_nlysj.setOnTouchListener(this);
		edit_nlyq.setOnTouchListener(this);
	}

	/**
	 * ˵������ʼ��Spinner �ֵ��б�
	 * 
	 * @return void
	 */
	private void initSpinnerDict() {
		CommonTypeUtil typeUtil = new CommonTypeUtil();
		list_qsxz = typeUtil.initList("qsxz");// Ȩ������
		list_lyqyt = typeUtil.initList("ytlx");// ��Ӫǰ��;
		list_lyhghyt = typeUtil.initList("ytlx");// ��Ӫ��滮��;
		list_hxwkfsp = typeUtil.initList("hxwkfsp");// �����⿪��ˮƽ
		list_hxnkfsp = typeUtil.initList("hxnkfsp");// �����ڿ���ˮƽ
		list_tdjb = typeUtil.initList("tdjb");// �������ؼ���

		value_qsxz = list_qsxz.get(0);
		value_lyqyt = list_lyqyt.get(0);
		value_lyhghyt = list_lyhghyt.get(0);
		value_ghhxwkfsp = list_hxwkfsp.get(0);
		value_ghhxnkfsp = list_hxnkfsp.get(0);
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
		/** ��Ӫǰ��; **/
		edit_lyqyt.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_lyqyt = list_lyqyt.get(index);
				index_lyqyt = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		/** ��Ӫ��滮��; **/
		edit_lyhghyt.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_lyhghyt = list_lyhghyt.get(index);
				index_lyhghyt = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});

		/** �����⿪��ˮƽ **/
		edit_hxwkfsp.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_ghhxwkfsp = list_hxwkfsp.get(index);
				index_ghhxwkfsp = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		/** �����ڿ���ˮƽ **/
		edit_hxnkfsp.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_ghhxnkfsp = list_hxnkfsp.get(index);
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
				locationInfo.setCollectionType(CollectType.Collection_Market_Supply_ShareHolder);
				// ����ID
				locationInfo.setCollectionMainType(CollectType.Supply);
				locationInfo.setCollectionTableName(CollectType.Collection_Market_Supply_ShareHolder_Tablename);// ����
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
		/** ������Ӫ��ɹ�Ӧ��Ϣ **/
		value_tdsyz = edit_tdsyz.getText().toString();// ����������
		value_tdzsh = edit_tdzsh.getText().toString();// ����֤���
		value_tdzl = edit_tdzl.getText().toString();// ��������
		value_cdf = edit_cdf.getText().toString();// ���ط�
		value_nlysj = edit_nlysj.getText().toString();// ����Ӫʱ��
		value_nlyq = edit_nlyq.getText().toString();// ����Ӫ��
		value_ncdmj = edit_ncdmj.getText().toString();// ����ط�Ͷ���������
		value_nczze = edit_nczze.getText().toString();// ����ʷ�Ͷ���ʽ��ܶ�
		value_ncdffcbl = edit_ncdffcbl.getText().toString();// ����ط�����ֳɱ���
		value_ntdncsr = edit_ntdncsr.getText().toString();// �ⵥλ��������괿����
		value_ncdfncsr = edit_ncdfncsr.getText().toString();// ����ط������괿����
		/** λ����Ϣ.���� **/
		value_x = edit_x.getText().toString();// ����
		value_y = edit_y.getText().toString();// γ��
		value_zbxt = edit_zbxt.getText().toString();// ����ϵͳ
		value_remark = edit_remark.getText().toString();// ��ע
		/** ������Ϣ **/
		value_ghrjl = edit_ghrjl.getText().toString();// �ݻ���
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
		ModelCollectionMarketSupplyShareHolder model = new ModelCollectionMarketSupplyShareHolder();
		/** ������Ϣ **/
		model.setTHENAME(value_the_name);// ��¼����
		model.setTHECODE(value_the_code);// ��¼����
		/** ������Ӫ��ɹ�Ӧ��Ϣ **/
		model.setTDSYZ(value_tdsyz);// ����������
		model.setTDZSH(value_tdzsh);// ����֤���
		model.setTDZL(value_tdzl);// ��������
		model.setQSXZ(value_qsxz);// Ȩ������
		model.setCDF(value_cdf);// ���ط�
		model.setNLYSJ(value_nlysj);// ����Ӫʱ��
		model.setNLYQ(value_nlyq);// ����Ӫ��
		model.setNCDMJ(value_ncdmj);// ����ط�Ͷ���������
		model.setNCZZE(value_nczze);// ����ʷ�Ͷ���ʽ��ܶ�
		model.setNCDFFCBL(value_ncdffcbl);// ����ط�����ֳɱ���
		model.setNTDNCSR(value_ntdncsr);// �ⵥλ��������괿����
		model.setNCDFNCSR(value_ncdfncsr);// ����ط������괿����
		model.setLYQYT(value_lyqyt);// ��Ӫǰ��;
		model.setLYHGHYT(value_lyhghyt);// ��Ӫ��滮��;
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
		/** ������Ϣ.�ؼ� **/
		model.setIndex_qsxz(index_qsxz);// Ȩ������
		model.setIndex_crfs(index_crfs);// ����÷�ʽ
		model.setIndex_lyqyt(index_lyqyt);// ��Ӫǰ��;
		model.setIndex_lyhghyt(index_lyhghyt);// ��Ӫ��滮��;
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

			if (v.getId() == R.id.edit_nlysj) {
				final int inType = edit_nlysj.getInputType();
				edit_nlysj.setInputType(InputType.TYPE_NULL);
				edit_nlysj.onTouchEvent(event);
				edit_nlysj.setInputType(inType);
				edit_nlysj.setSelection(edit_nlysj.getText().length());

				builder.setTitle("ѡȡʱ��");
				builder.setPositiveButton("ȷ  ��", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

						StringBuffer sb = new StringBuffer();
						sb.append(String.format("%d-%02d-%02d", datePicker.getYear(), datePicker.getMonth() + 1,
								datePicker.getDayOfMonth()));
						sb.append("  00:00:00");

						edit_nlysj.setText(sb);
						edit_nlysj.requestFocus();

						dialog.cancel();
					}
				});

			} else if (v.getId() == R.id.edit_nlyq) {
				final int inType = edit_nlysj.getInputType();
				edit_nlyq.setInputType(InputType.TYPE_NULL);
				edit_nlyq.onTouchEvent(event);
				edit_nlyq.setInputType(inType);
				edit_nlyq.setSelection(edit_nlyq.getText().length());

				builder.setTitle("ѡȡʱ��");
				builder.setPositiveButton("ȷ  ��", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

						StringBuffer sb = new StringBuffer();
						sb.append(String.format("%d-%02d-%02d", datePicker.getYear(), datePicker.getMonth() + 1,
								datePicker.getDayOfMonth()));
						sb.append("  00:00:00");

						edit_nlyq.setText(sb);
						edit_nlyq.requestFocus();

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
				camorabitmap = ImageUtil.getImageThumbnail(Environment.getExternalStorageDirectory() + "/temp.jpg",
						width, height);
				image_photo.setImageBitmap(camorabitmap);
				String filePath = ImageUtil.copyFile(Environment.getExternalStorageDirectory() + "/temp.jpg",
						Environment.getExternalStorageDirectory() + "/");
				imagePathList.add(filePath);
				imagePathListIndex = imagePathList.size() -1;// TODO
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
				imagePathListIndex = imagePathList.size() - 1;// TODO
				text_page.setText("��" + (imagePathListIndex + 1) + "��");
				text_total.setText(",��" + imagePathList.size() + "��");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}