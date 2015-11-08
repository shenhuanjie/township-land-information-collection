/**
 * 
 */
package com.example.town_land_collect.fragment_market_redevelopment;

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
import com.example.town_land_collect.model.market_redevelopment.ModelCollectionMarketRedevelopmentImpose;
import com.example.town_land_collect.util.AttachmentUtil;
import com.example.town_land_collect.util.CollectType;
import com.example.town_land_collect.util.ComUtil;
import com.example.town_land_collect.util.CommonTypeUtil;
import com.example.town_land_collect.util.ImageUtil;
import com.example.town_land_collect.util.ToastUtil;

/**
 * @Title Collection_Market_Redevelopment_Impose.java
 * @Package com.example.town_land_collect.fragment_market_redevelopment
 * @Description �ٿ���ʵʩ��Ŀ��Ϣ
 * @author Shen.dev
 * @date 2015-10-14 ����5:34:24
 * @version V1.0
 */
@SuppressLint({ "CutPasteId", "ClickableViewAccessibility" })
public class Collection_Market_Redevelopment_Impose extends Fragment implements OnClickListener, OnTouchListener {
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

	/** �ٿ���ʵʩ��Ŀ��Ϣ **/
	private int index_xmlx = 0;// ��Ŀ����
	private int index_kfms = 0;// ����ģʽ
	private int index_zjly = 0;// �ʽ���Դ
	private int index_gdfs = 0;// ���ط�ʽ
	private int index_kfqyt = 0;// ����ǰ��;
	private int index_kfhyt = 0;// ��������;
	private int index_cylx = 0;// ��ҵ����
	private int index_qyzdcy = 0;// ����������ҵ����
	/** ������Ϣ.�ؼ� **/
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
	/** �ٿ���ʵʩ��Ŀ��Ϣ **/
	private EditText edit_bh;// ���
	private EditText edit_xmmc;// ��Ŀ����
	private Spinner edit_xmlx;// ��Ŀ����
	private EditText edit_tdzl;// ��������
	private EditText edit_tdmj;// �������
	private EditText edit_rjl;// �ݻ���
	private EditText edit_jzxs;// ����ϵ��
	private EditText edit_jzmd;// �����ܶ�
	private EditText edit_lvh;// �̻���
	private Spinner edit_kfms;// ����ģʽ
	private EditText edit_ztz;// ��Ͷ��
	private Spinner edit_zjly;// �ʽ���Դ
	private Spinner edit_gdfs;// ���ط�ʽ
	private Spinner edit_kfqyt;// ����ǰ��;
	private Spinner edit_kfhyt;// ��������;
	private Spinner edit_cylx;// ��ҵ����
	private Spinner edit_qyzdcy;// ����������ҵ����
	private EditText edit_qygyjzdj;// ������н����õػ�׼�ؼ�
	private EditText edit_qyjtjzdj;// �����彨���õػ�׼�ؼ�
	private EditText edit_djcz;// �ؾ���ֵ
	private EditText edit_djss;// �ؾ�˰��
	private EditText edit_djcyry;// �ؾ���ҵ��Ա��
	/** ������Ϣ.�ؼ� **/
	private Spinner edit_tdjb;// �������ؼ���
	private EditText edit_djqd;// ���ڵؼ�����
	private EditText edit_xzqdm;// ����������

	/** λ����Ϣ.�ؼ� **/
	// private EditText edit_x;// X����
	// private EditText edit_y;// Y����
	// private EditText edit_bjdmc;// ��ǵ�����
	// private EditText edit_zbxt;// ����ϵͳ
	private EditText edit_remark;// ��ע

	/** ȫ�ֱ��� **/
	// private double lat;
	// private double lon;

	/** ������Ϣ.���� **/
	private String value_the_name;// ��¼����
	private String value_the_code;// ��¼����
	/** �ٿ���ʵʩ��Ŀ��Ϣ **/
	private String value_bh;// ���
	private String value_xmmc;// ��Ŀ����
	private String value_xmlx;// ��Ŀ����
	private String value_tdzl;// ��������
	private String value_tdmj;// �������
	private String value_rjl;// �ݻ���
	private String value_jzxs;// ����ϵ��
	private String value_jzmd;// �����ܶ�
	private String value_lvh;// �̻���
	private String value_kfms;// ����ģʽ
	private String value_ztz;// ��Ͷ��
	private String value_zjly;// �ʽ���Դ
	private String value_gdfs;// ���ط�ʽ
	private String value_kfqyt;// ����ǰ��;
	private String value_kfhyt;// ��������;
	private String value_cylx;// ��ҵ����
	private String value_qyzdcy;// ����������ҵ����
	private String value_qygyjzdj;// ������н����õػ�׼�ؼ�
	private String value_qyjtjzdj;// �����彨���õػ�׼�ؼ�
	private String value_djcz;// �ؾ���ֵ
	private String value_djss;// �ؾ�˰��
	private String value_djcyry;// �ؾ���ҵ��Ա��
	/** ������Ϣ **/
	private String value_tdjb;// �������ؼ���
	private String value_djqd;// ���ڵؼ�����
	private String value_xzqdm;// ����������

	/** λ����Ϣ.���� **/
	// private String value_x;// X����
	// private String value_y;// Y����
	// private String value_bjdmc;// ��ǵ�����
	// private String value_zbxt;// ����ϵͳ
	private String value_remark;// ��ע

	/** Spinner Dict **/
	/** �ٿ���ʵʩ��Ŀ��Ϣ **/
	private ArrayList<String> list_xmlx = new ArrayList<String>();// ��Ŀ����
	private ArrayList<String> list_kfms = new ArrayList<String>();// ����ģʽ
	private ArrayList<String> list_zjly = new ArrayList<String>();// �ʽ���Դ
	private ArrayList<String> list_gdfs = new ArrayList<String>();// ���ط�ʽ
	private ArrayList<String> list_kfqyt = new ArrayList<String>();// ����ǰ��;
	private ArrayList<String> list_kfhyt = new ArrayList<String>();// ��������;
	private ArrayList<String> list_cylx = new ArrayList<String>();// ��ҵ����
	private ArrayList<String> list_qyzdcy = new ArrayList<String>();// ����������ҵ����

	/** ������Ϣ .Spinner **/
	private ArrayList<String> list_tdjb = new ArrayList<String>();// �������ؼ���

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = (View) inflater.inflate(R.layout.collection_market_redevelopment_impose_frame, container, false);
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
		textView_Tips.setText("�ٿ���ʵʩ��Ŀ��Ϣ");
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
		/** �ٿ���ʵʩ��Ŀ��Ϣ **/
		edit_bh = (EditText) view.findViewById(R.id.edit_bh);// ���
		edit_xmmc = (EditText) view.findViewById(R.id.edit_xmmc);// ��Ŀ����
		edit_xmlx = (Spinner) view.findViewById(R.id.edit_xmlx);// ��Ŀ����
		edit_tdzl = (EditText) view.findViewById(R.id.edit_tdzl);// ��������
		edit_tdmj = (EditText) view.findViewById(R.id.edit_tdmj);// �������
		edit_rjl = (EditText) view.findViewById(R.id.edit_rjl);// �ݻ���
		edit_jzxs = (EditText) view.findViewById(R.id.edit_jzxs);// ����ϵ��
		edit_jzmd = (EditText) view.findViewById(R.id.edit_jzmd);// �����ܶ�
		edit_lvh = (EditText) view.findViewById(R.id.edit_lvh);// �̻���
		edit_kfms = (Spinner) view.findViewById(R.id.edit_kfms);// ����ģʽ
		edit_ztz = (EditText) view.findViewById(R.id.edit_ztz);// ��Ͷ��
		edit_zjly = (Spinner) view.findViewById(R.id.edit_zjly);// �ʽ���Դ
		edit_gdfs = (Spinner) view.findViewById(R.id.edit_gdfs);// ���ط�ʽ
		edit_kfqyt = (Spinner) view.findViewById(R.id.edit_kfqyt);// ����ǰ��;
		edit_kfhyt = (Spinner) view.findViewById(R.id.edit_kfhyt);// ��������;
		edit_cylx = (Spinner) view.findViewById(R.id.edit_cylx);// ��ҵ����
		edit_qyzdcy = (Spinner) view.findViewById(R.id.edit_qyzdcy);// ����������ҵ����
		edit_qygyjzdj = (EditText) view.findViewById(R.id.edit_qygyjzdj);// ������н����õػ�׼�ؼ�
		edit_qyjtjzdj = (EditText) view.findViewById(R.id.edit_qyjtjzdj);// �����彨���õػ�׼�ؼ�
		edit_djcz = (EditText) view.findViewById(R.id.edit_djcz);// �ؾ���ֵ
		edit_djss = (EditText) view.findViewById(R.id.edit_djss);// �ؾ�˰��
		edit_djcyry = (EditText) view.findViewById(R.id.edit_djcyry);// �ؾ���ҵ��Ա��
		/** λ����Ϣ **/
		// edit_x = (EditText) view.findViewById(R.id.ocation_info_lon);
		// edit_y = (EditText) view.findViewById(R.id.ocation_info_lat);
		// edit_bjdmc = (EditText) view.findViewById(R.id.location_info_bjdmc);
		// edit_zbxt = (EditText) view.findViewById(R.id.location_info_zbxt);
		edit_remark = (EditText) view.findViewById(R.id.edit_remark);
		/** ������Ϣ **/
		edit_tdjb = (Spinner) view.findViewById(R.id.edit_tdjb);// spinner
		edit_djqd = (EditText) view.findViewById(R.id.edit_djqd);
		edit_xzqdm = (EditText) view.findViewById(R.id.edit_xzqdm);

	}

	/**
	 * ˵������ʼ��Spinner �ֵ��б�
	 * 
	 * @return void
	 */
	private void initSpinnerDict() {
		CommonTypeUtil typeUtil = new CommonTypeUtil();
		list_xmlx = typeUtil.initList("zkflx");// ��Ŀ����
		list_kfms = typeUtil.initList("zkfms");// ����ģʽ
		list_zjly = typeUtil.initList("zkfzjly");// �ʽ���Դ
		list_gdfs = typeUtil.initList("tdgyfs");// ���ط�ʽ
		list_kfqyt = typeUtil.initList("tdyt");// ����ǰ��;
		list_kfhyt = typeUtil.initList("tdyt");// ��������;
		list_cylx = typeUtil.initList("cylx");// ��ҵ����
		list_qyzdcy = typeUtil.initList("cylx");// ����������ҵ����
		list_tdjb = typeUtil.initList("tdjb");// �������ؼ���

		value_xmlx = list_xmlx.get(0);
		value_kfms = list_kfms.get(0);
		value_zjly = list_zjly.get(0);
		value_gdfs = list_gdfs.get(0);
		value_kfqyt = list_kfqyt.get(0);
		value_kfhyt = list_kfhyt.get(0);
		value_cylx = list_cylx.get(0);
		value_qyzdcy = list_qyzdcy.get(0);
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
		edit_xmlx.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_xmlx = list_xmlx.get(index);
				index_xmlx = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		edit_kfms.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_kfms = list_kfms.get(index);
				index_kfms = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		/** **/
		edit_zjly.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_zjly = list_zjly.get(index);
				index_zjly = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		/** **/
		edit_gdfs.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_gdfs = list_gdfs.get(index);
				index_gdfs = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		/** **/
		edit_kfqyt.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_kfqyt = list_kfqyt.get(index);
				index_kfqyt = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		/** **/
		edit_kfhyt.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_kfhyt = list_kfhyt.get(index);
				index_kfhyt = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		/** **/
		edit_cylx.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_cylx = list_cylx.get(index);
				index_cylx = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		/** **/
		edit_qyzdcy.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_qyzdcy = list_qyzdcy.get(index);
				index_qyzdcy = index;
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
				// index_tdjb = index;
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
			locationInfo.setCollectionType(CollectType.Collection_Market_Redevelopment_Impose);
			// ����ID
			locationInfo.setCollectionMainType(CollectType.Redevelopment);// TODO
			locationInfo.setCollectionTableName(CollectType.Collection_Market_Redevelopment_Impose_Tablename);// ����
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
		/** �ٿ���ʵʩ��Ŀ��Ϣ **/
		value_bh = edit_bh.getText().toString();// ���
		value_xmmc = edit_xmmc.getText().toString();// ��Ŀ����
		value_tdzl = edit_tdzl.getText().toString();// ��������
		value_tdmj = edit_tdmj.getText().toString();// �������
		value_rjl = edit_rjl.getText().toString();// �ݻ���
		value_jzxs = edit_jzxs.getText().toString();// ����ϵ��
		value_jzmd = edit_jzmd.getText().toString();// �����ܶ�
		value_lvh = edit_lvh.getText().toString();// �̻���
		value_ztz = edit_ztz.getText().toString();// ��Ͷ��
		value_qygyjzdj = edit_qygyjzdj.getText().toString();// ������н����õػ�׼�ؼ�
		value_qyjtjzdj = edit_qyjtjzdj.getText().toString();// �����彨���õػ�׼�ؼ�
		value_djcz = edit_djcz.getText().toString();// �ؾ���ֵ
		value_djss = edit_djss.getText().toString();// �ؾ�˰��
		value_djcyry = edit_djcyry.getText().toString();// �ؾ���ҵ��Ա��
		/** λ����Ϣ.���� **/
		// value_x = edit_x.getText().toString();// ����
		// value_y = edit_y.getText().toString();// γ��
		// value_bjdmc = edit_bjdmc.getText().toString();// ��ǵ�����
		// value_zbxt = edit_zbxt.getText().toString();// ����ϵͳ
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
		ModelCollectionMarketRedevelopmentImpose model = new ModelCollectionMarketRedevelopmentImpose();
		/** ������Ϣ **/
		model.setTHENAME(value_the_name);// ��¼����
		model.setTHECODE(value_the_code);// ��¼����
		/** �ٿ���ʵʩ��Ŀ��Ϣ **/
		model.setBH(value_bh);// ���
		model.setXMMC(value_xmmc);// ��Ŀ����
		model.setXMLX(value_xmlx);// ��Ŀ����
		model.setTDZL(value_tdzl);// ��������
		model.setTDMJ(value_tdmj);// �������
		model.setRJL(value_rjl);// �ݻ���
		model.setJZXS(value_jzxs);// ����ϵ��
		model.setJZMD(value_jzmd);// �����ܶ�
		model.setLVH(value_lvh);// �̻���
		model.setKFMS(value_kfms);// ����ģʽ
		model.setZTZ(value_ztz);// ��Ͷ��
		model.setZJLY(value_zjly);// �ʽ���Դ
		model.setGDFS(value_gdfs);// ���ط�ʽ
		model.setKFQYT(value_kfqyt);// ����ǰ��;
		model.setKFHYT(value_kfhyt);// ��������;
		model.setCYLX(value_cylx);// ��ҵ����
		model.setQYZDCY(value_qyzdcy);// ����������ҵ����
		model.setQYGYJZDJ(value_qygyjzdj);// ������н����õػ�׼�ؼ�
		model.setQYJTJZDJ(value_qyjtjzdj);// �����彨���õػ�׼�ؼ�
		model.setDJCZ(value_djcz);// �ؾ���ֵ
		model.setDJSS(value_djss);// �ؾ�˰��
		model.setDJCYRY(value_djcyry);// �ؾ���ҵ��Ա��
		/** λ����Ϣ **/
		// model.setX(value_x);// ����
		// model.setY(value_y);// γ��
		// model.setZBXT(value_zbxt);// ����ϵͳ
		model.setREMARK(value_remark);// ��ע

		/** ������Ϣ **/
		model.setTDJB(value_tdjb); // �������ؼ���
		model.setDJQD(value_djqd);// ���ڵؼ�����
		model.setXZQDM(value_xzqdm);// ���������루�弶��������

		/** ��ֵ�����ֶ� **/
		/** �ٿ���ʵʩ��Ŀ��Ϣ **/
		model.setIndex_xmlx(index_xmlx);// ��Ŀ����
		model.setIndex_kfms(index_kfms);// ����ģʽ
		model.setIndex_zjly(index_zjly);// �ʽ���Դ
		model.setIndex_gdfs(index_gdfs);// ���ط�ʽ
		model.setIndex_kfqyt(index_kfqyt);// ����ǰ��;
		model.setIndex_kfhyt(index_kfhyt);// ��������;
		model.setIndex_cylx(index_cylx);// ��ҵ����
		model.setIndex_qyzdcy(index_qyzdcy);// ����������ҵ����
		/** ������Ϣ.�ؼ� **/
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
