package com.example.town_land_collect.fragment_market_monitor;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.litepal.exceptions.DataSupportException;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.town_land_collect.R;
import com.example.town_land_collect.activity.MyMapActivity;
import com.example.town_land_collect.model.LocationInfo;
import com.example.town_land_collect.model.market_monitor.ModelCollectionMarketMonitorPoint;
import com.example.town_land_collect.util.AttachmentUtil;
import com.example.town_land_collect.util.CollectType;
import com.example.town_land_collect.util.ComUtil;
import com.example.town_land_collect.util.CommonTypeUtil;
import com.example.town_land_collect.util.ImageUtil;
import com.example.town_land_collect.util.ToastUtil;

/**
 * 
 * @Title Collection_Market_Monitor_Point.java
 * @Package com.example.town_land_collect.fragment_market_monitor
 * @Description �����г���ص���Ϣ
 * @author Shen.dev
 * @date 2015-10-14 ����5:17:23
 * @version V1.0
 */
@SuppressLint({ "CutPasteId", "ClickableViewAccessibility" })
public class Collection_Market_Monitor_Point extends Fragment implements OnClickListener, OnTouchListener {
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

	/** �����г���ص���Ϣ **/
	private int index_qsxz = 0;// Ȩ������
	private int index_tdyt = 0;// ������;
	private int index_zdnkfsp = 0;// �ڵ��ڿ���ˮƽ
	private int index_zswkfsp = 0;// �ڵ��⿪��ˮƽ
	private int index_sdkfsp = 0;// �趨����ˮƽ
	private int index_tdjb = 0;// �������ؼ���

	/** ͨ�ò���.�ؼ� **/
	private ImageView image_photo;// ͼƬ��Ϣ
	// private ImageButton imageButton_Location;// ѡ�����꣨��ͼ��
	private ImageButton imageButton_Save;// ������
	private ImageButton imageButton_Clear;// ��ձ�
	private TextView textView_Tips;// ��ʾ��Ϣ

	/** ������Ϣ.�ؼ� **/
	private EditText edit_the_name;// ��¼����
	private EditText edit_the_code;// ��¼����
	/** �����г���ص���Ϣ **/
	private EditText edit_jcdmc;// ��������
	private EditText edit_tdzl;// ��������
	private EditText edit_tdzsh;// ����֤���
	private Spinner edit_qsxz;// Ȩ������
	private EditText edit_gzq;// ������
	private Spinner edit_tdyt;// ������;
	private EditText edit_tdmj;// �������
	private EditText edit_tdsyz;// ����������
	private EditText edit_tdshyz;// ����ʹ����
	private EditText edit_rjl;// �ݻ���
	private EditText edit_jzmj;// �����ܶ�
	private EditText edit_jzxs;// ����ϵ��
	private EditText edit_ldl;// �̵���
	private EditText edit_tdsynq;// ����ʹ������
	private Spinner edit_zdnkfsp;// �ڵ��ڿ���ˮƽ
	private Spinner edit_zswkfsp;// �ڵ��⿪��ˮƽ
	private EditText edit_xzl;// ���������ʣ����ݿ����ʣ�
	private EditText edit_scjg;// �г��۸�
	private EditText edit_sczj;// �г����
	private EditText edit_djtz;// �ؾ��ۼƹ̶��ʲ�Ͷ��
	private EditText edit_djcz;// �ؾ���ֵ
	private EditText edit_djss;// �ؾ�˰��
	private EditText edit_djcyry;// �ؾ���ҵ��Ա����ס�˿ڣ�
	private EditText edit_sdrjl;// �趨�ݻ���
	private EditText edit_sdsynq;// �趨ʹ������
	private Spinner edit_sdkfsp;// �趨����ˮƽ
	private EditText edit_pgjg;// �����۸�
	private Spinner edit_tdjb;// �������ؼ���
	private EditText edit_djqd;// ���ڵؼ�����
	private EditText edit_xzqdm;// ����������
	private EditText edit_remark;// ��ע

	// /** λ����Ϣ.�ؼ� **/
	// private EditText edit_x;// X����
	// private EditText edit_y;// Y����
	// private EditText edit_bjdmc;// ��ǵ�����
	// private EditText edit_zbxt;// ����ϵͳ
	// private EditText edit_remark;// ��ע

	/** ȫ�ֱ��� **/
	// private double lat;
	// private double lon;

	/** ������Ϣ.���� **/
	private String value_the_name;// ��¼����
	private String value_the_code;// ��¼����

	/** �����г���ص���Ϣ **/
	private String value_jcdmc;// ��������
	private String value_tdzl;// ��������
	private String value_tdzsh;// ����֤���
	private String value_qsxz;// Ȩ������
	private String value_gzq;// ������
	private String value_tdyt;// ������;
	private String value_tdmj;// �������
	private String value_tdsyz;// ����������
	private String value_tdshyz;// ����ʹ����
	private String value_rjl;// �ݻ���
	private String value_jzmj;// �����ܶ�
	private String value_jzxs;// ����ϵ��
	private String value_ldl;// �̵���
	private String value_tdsynq;// ����ʹ������
	private String value_zdnkfsp;// �ڵ��ڿ���ˮƽ
	private String value_zswkfsp;// �ڵ��⿪��ˮƽ
	private String value_xzl;// ���������ʣ����ݿ����ʣ�
	private String value_scjg;// �г��۸�
	private String value_sczj;// �г����
	private String value_djtz;// �ؾ��ۼƹ̶��ʲ�Ͷ��
	private String value_djcz;// �ؾ���ֵ
	private String value_djss;// �ؾ�˰��
	private String value_djcyry;// �ؾ���ҵ��Ա����ס�˿ڣ�
	private String value_sdrjl;// �趨�ݻ���
	private String value_sdsynq;// �趨ʹ������
	private String value_sdkfsp;// �趨����ˮƽ
	private String value_pgjg;// �����۸�
	private String value_tdjb;// �������ؼ���
	private String value_djqd;// ���ڵؼ�����
	private String value_xzqdm;// ����������
	private String value_remark;// ��ע

	// /** λ����Ϣ.���� **/
	// private String value_x;// X����
	// private String value_y;// Y����
	// private String value_bjdmc;// ��ǵ�����
	// private String value_zbxt;// ����ϵͳ
	// private String value_remark;// ��ע

	/** Spinner Dict **/
	/** ������Ϣ .Spinner **/
	private ArrayList<String> list_qsxz = new ArrayList<String>();// Ȩ������
	private ArrayList<String> list_tdyt = new ArrayList<String>();// ������;
	private ArrayList<String> list_zdnkfsp = new ArrayList<String>();// �ڵ��ڿ���ˮƽ
	private ArrayList<String> list_zswkfsp = new ArrayList<String>();// �ڵ��⿪��ˮƽ
	private ArrayList<String> list_sdkfsp = new ArrayList<String>();// �趨����ˮƽ
	private ArrayList<String> list_tdjb = new ArrayList<String>();// �������ؼ���

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = (View) inflater.inflate(R.layout.collection_market_monitor_point_frame, container, false);
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
		// imageButton_Location = (ImageButton)
		// view.findViewById(R.id.fragment_collection_ibtn_location);
		// imageButton_Location.setOnClickListener(this);
		imageButton_Save = (ImageButton) view.findViewById(R.id.fragment_collection_ibtn_save);
		imageButton_Clear = (ImageButton) view.findViewById(R.id.fragment_collection_ibtn_clear);
		imageButton_Clear.setOnClickListener(this);
		imageButton_Save.setOnClickListener(this);
		textView_Tips = (TextView) view.findViewById(R.id.fragment_collection_tv_tips);
		textView_Tips.setText("�����г�������Ϣ");
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
		/** �����г���ص���Ϣ **/
		edit_jcdmc = (EditText) view.findViewById(R.id.edit_jcdmc);// ��������
		edit_tdzl = (EditText) view.findViewById(R.id.edit_tdzl);// ��������
		edit_tdzsh = (EditText) view.findViewById(R.id.edit_tdzsh);// ����֤���
		edit_qsxz = (Spinner) view.findViewById(R.id.edit_qsxz);// Ȩ������
		edit_gzq = (EditText) view.findViewById(R.id.edit_gzq);// ������
		edit_tdyt = (Spinner) view.findViewById(R.id.edit_tdyt);// ������;
		edit_tdmj = (EditText) view.findViewById(R.id.edit_tdmj);// �������
		edit_tdsyz = (EditText) view.findViewById(R.id.edit_tdsyz);// ����������
		edit_tdshyz = (EditText) view.findViewById(R.id.edit_tdshyz);// ����ʹ����
		edit_rjl = (EditText) view.findViewById(R.id.edit_rjl);// �ݻ���
		edit_jzmj = (EditText) view.findViewById(R.id.edit_jzmj);// �����ܶ�
		edit_jzxs = (EditText) view.findViewById(R.id.edit_jzxs);// ����ϵ��
		edit_ldl = (EditText) view.findViewById(R.id.edit_ldl);// �̵���
		edit_tdsynq = (EditText) view.findViewById(R.id.edit_tdsynq);// ����ʹ������
		edit_zdnkfsp = (Spinner) view.findViewById(R.id.edit_zdnkfsp);// �ڵ��ڿ���ˮƽ
		edit_zswkfsp = (Spinner) view.findViewById(R.id.edit_zswkfsp);// �ڵ��⿪��ˮƽ
		edit_xzl = (EditText) view.findViewById(R.id.edit_xzl);// ���������ʣ����ݿ����ʣ�
		edit_scjg = (EditText) view.findViewById(R.id.edit_scjg);// �г��۸�
		edit_sczj = (EditText) view.findViewById(R.id.edit_sczj);// �г����
		edit_djtz = (EditText) view.findViewById(R.id.edit_djtz);// �ؾ��ۼƹ̶��ʲ�Ͷ��
		edit_djcz = (EditText) view.findViewById(R.id.edit_djcz);// �ؾ���ֵ
		edit_djss = (EditText) view.findViewById(R.id.edit_djss);// �ؾ�˰��
		edit_djcyry = (EditText) view.findViewById(R.id.edit_djcyry);// �ؾ���ҵ��Ա����ס�˿ڣ�
		edit_sdrjl = (EditText) view.findViewById(R.id.edit_sdrjl);// �趨�ݻ���
		edit_sdsynq = (EditText) view.findViewById(R.id.edit_sdsynq);// �趨ʹ������
		edit_sdkfsp = (Spinner) view.findViewById(R.id.edit_sdkfsp);// �趨����ˮƽ
		edit_pgjg = (EditText) view.findViewById(R.id.edit_pgjg);// �����۸�
		edit_tdjb = (Spinner) view.findViewById(R.id.edit_tdjb);// �������ؼ���
		edit_djqd = (EditText) view.findViewById(R.id.edit_djqd);// ���ڵؼ�����
		edit_xzqdm = (EditText) view.findViewById(R.id.edit_xzqdm);// ����������
		edit_remark = (EditText) view.findViewById(R.id.edit_remark);// ��ע
		/** λ����Ϣ **/
		// edit_x = (EditText) view.findViewById(R.id.ocation_info_lon);
		// edit_y = (EditText) view.findViewById(R.id.ocation_info_lat);
		// edit_bjdmc = (EditText) view.findViewById(R.id.location_info_bjdmc);
		// edit_zbxt = (EditText) view.findViewById(R.id.location_info_zbxt);
		// edit_remark = (EditText)
		// view.findViewById(R.id.location_info_remark);

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
		list_zdnkfsp = typeUtil.initList("hxnkfsp");// �ڵ��ڿ���ˮƽ
		list_zswkfsp = typeUtil.initList("hxwkfsp");// �ڵ��⿪��ˮƽ
		list_sdkfsp = typeUtil.initList("sdkfsp");// �趨����ˮƽ
		list_tdjb = typeUtil.initList("tdjb");// �������ؼ���

		value_qsxz = list_qsxz.get(0);// Ȩ������
		value_tdyt = list_tdyt.get(0);// ������;
		value_zdnkfsp = list_zdnkfsp.get(0);// �ڵ��ڿ���ˮƽ
		value_zswkfsp = list_zswkfsp.get(0);// �ڵ��⿪��ˮƽ
		value_sdkfsp = list_sdkfsp.get(0);// �趨����ˮƽ
		value_tdjb = list_tdjb.get(0);// �������ؼ���
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
		edit_zdnkfsp.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_zdnkfsp = list_zdnkfsp.get(index);
				index_zdnkfsp = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		edit_zswkfsp.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_zswkfsp = list_zswkfsp.get(index);
				index_zswkfsp = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		edit_sdkfsp.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_sdkfsp = list_sdkfsp.get(index);
				index_sdkfsp = index;
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
			locationInfo.setCollectionType(CollectType.Collection_Market_Monitor_Point);
			// ����ID
			locationInfo.setCollectionMainType(CollectType.Monitor);
			locationInfo.setCollectionTableName(CollectType.Collection_Market_Monitor_Point_Tablename);// ����
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
		/** �����г���ص���Ϣ **/
		value_jcdmc = edit_jcdmc.getText().toString();// ��������
		value_tdzl = edit_tdzl.getText().toString();// ��������
		value_tdzsh = edit_tdzsh.getText().toString();// ����֤���
		value_gzq = edit_gzq.getText().toString();// ������
		value_tdmj = edit_tdmj.getText().toString();// �������
		value_tdsyz = edit_tdsyz.getText().toString();// ����������
		value_tdshyz = edit_tdshyz.getText().toString();// ����ʹ����
		value_rjl = edit_rjl.getText().toString();// �ݻ���
		value_jzmj = edit_jzmj.getText().toString();// �����ܶ�
		value_jzxs = edit_jzxs.getText().toString();// ����ϵ��
		value_ldl = edit_ldl.getText().toString();// �̵���
		value_tdsynq = edit_tdsynq.getText().toString();// ����ʹ������
		value_xzl = edit_xzl.getText().toString();// ���������ʣ����ݿ����ʣ�
		value_scjg = edit_scjg.getText().toString();// �г��۸�
		value_sczj = edit_sczj.getText().toString();// �г����
		value_djtz = edit_djtz.getText().toString();// �ؾ��ۼƹ̶��ʲ�Ͷ��
		value_djcz = edit_djcz.getText().toString();// �ؾ���ֵ
		value_djss = edit_djss.getText().toString();// �ؾ�˰��
		value_djcyry = edit_djcyry.getText().toString();// �ؾ���ҵ��Ա����ס�˿ڣ�
		value_sdrjl = edit_sdrjl.getText().toString();// �趨�ݻ���
		value_sdsynq = edit_sdsynq.getText().toString();// �趨ʹ������
		value_pgjg = edit_pgjg.getText().toString();// �����۸�
		value_djqd = edit_djqd.getText().toString();// ���ڵؼ�����
		value_xzqdm = edit_xzqdm.getText().toString();// ����������
		value_remark = edit_remark.getText().toString();// ��ע
		/** λ����Ϣ.���� **/
		// value_x = edit_x.getText().toString();// ����
		// value_y = edit_y.getText().toString();// γ��
		// value_bjdmc = edit_bjdmc.getText().toString();// ��ǵ�����
		// value_zbxt = edit_zbxt.getText().toString();// ����ϵͳ
		// value_remark = edit_remark.getText().toString();// ��ע
	}

	/**
	 * ˵��������ɼ���Ϣ���ֱ�
	 * 
	 * @return id
	 */
	private int saveCollectionInfo() {
		int result = 0;
		setCollectionInfo();
		ModelCollectionMarketMonitorPoint model = new ModelCollectionMarketMonitorPoint();
		/** ������Ϣ **/
		model.setTHENAME(value_the_name);// ��¼����
		model.setTHECODE(value_the_code);// ��¼����
		/** �����г���ص���Ϣ **/
		model.setJCDMC(value_jcdmc);// ��������
		model.setTDZL(value_tdzl);// ��������
		model.setTDZSH(value_tdzsh);// ����֤���
		model.setQSXZ(value_qsxz);// Ȩ������
		model.setGZQ(value_gzq);// ������
		model.setTDYT(value_tdyt);// ������;
		model.setTDMJ(value_tdmj);// �������
		model.setTDSYZ(value_tdsyz);// ����������
		model.setTDSHYZ(value_tdshyz);// ����ʹ����
		model.setRJL(value_rjl);// �ݻ���
		model.setJZMJ(value_jzmj);// �����ܶ�
		model.setJZXS(value_jzxs);// ����ϵ��
		model.setLDL(value_ldl);// �̵���
		model.setTDSYNQ(value_tdsynq);// ����ʹ������
		model.setZDNKFSP(value_zdnkfsp);// �ڵ��ڿ���ˮƽ
		model.setZSWKFSP(value_zswkfsp);// �ڵ��⿪��ˮƽ
		model.setXZL(value_xzl);// ���������ʣ����ݿ����ʣ�
		model.setSCJG(value_scjg);// �г��۸�
		model.setSCZJ(value_sczj);// �г����
		model.setDJTZ(value_djtz);// �ؾ��ۼƹ̶��ʲ�Ͷ��
		model.setDJCZ(value_djcz);// �ؾ���ֵ
		model.setDJSS(value_djss);// �ؾ�˰��
		model.setDJCYRY(value_djcyry);// �ؾ���ҵ��Ա����ס�˿ڣ�
		model.setSDRJL(value_sdrjl);// �趨�ݻ���
		model.setSDSYNQ(value_sdsynq);// �趨ʹ������
		model.setSDKFSP(value_sdkfsp);// �趨����ˮƽ
		model.setPGJG(value_pgjg);// �����۸�
		model.setTDJB(value_tdjb);// �������ؼ���
		model.setDJQD(value_djqd);// ���ڵؼ�����
		model.setXZQDM(value_xzqdm);// ����������
		model.setREMARK(value_remark);// ��ע

		// /** λ����Ϣ **/
		// model.setX(value_x);// ����
		// model.setY(value_y);// γ��
		// model.setZBXT(value_zbxt);// ����ϵͳ
		// model.setREMARK(value_remark);// ��ע

		/** ��ֵ�����ֶ� **/
		model.setIndex_qsxz(index_qsxz);// Ȩ������
		model.setIndex_tdyt(index_tdyt);// ������;
		model.setIndex_zdnkfsp(index_zdnkfsp);// �ڵ��ڿ���ˮƽ
		model.setIndex_zswkfsp(index_zswkfsp);// �ڵ��⿪��ˮƽ
		model.setIndex_sdkfsp(index_sdkfsp);// �趨����ˮƽ
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

		if (resultCode != Activity.RESULT_OK) {
			// result is not correct
			// return;
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
