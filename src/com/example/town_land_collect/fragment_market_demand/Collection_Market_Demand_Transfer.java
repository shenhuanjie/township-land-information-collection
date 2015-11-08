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
import com.example.town_land_collect.model.market_demand.ModelCollectionMarketDemandTransfer;
import com.example.town_land_collect.util.AttachmentUtil;
import com.example.town_land_collect.util.CollectType;
import com.example.town_land_collect.util.ComUtil;
import com.example.town_land_collect.util.CommonTypeUtil;
import com.example.town_land_collect.util.ImageUtil;
import com.example.town_land_collect.util.ToastUtil;

/**
 * 
 * @Title Collection_Market_Demand_Transfer.java
 * @Package com.example.town_land_collect.fragment_market_demand
 * @Description ����ʹ��Ȩת��������Ϣ
 * @author Shen.dev
 * @date 2015-10-14 ����5:15:49
 * @version V1.0
 */
@SuppressLint({ "CutPasteId", "ClickableViewAccessibility" })
public class Collection_Market_Demand_Transfer extends Fragment implements OnClickListener, OnTouchListener {
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

	/** ����ʹ��Ȩת��������Ϣ **/
	private int index_xqfztxz;// ������������
	private int index_nqsxz;// ��Ȩ������
	private int index_xqzrfs;// ����ת�÷�ʽ
	private int index_zrqyt;// ת��ǰ��;
	private int index_nzrhyt;// ��ת�ú���;
	/** ������Ϣ.�ؼ� **/
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
	/** ����ʹ��Ȩת��������Ϣ **/
	private EditText edit_xqf;// ����
	private EditText edit_xqxztdtj;// ������״��������
	private Spinner edit_xqfztxz;// ������������
	private EditText edit_ntdzl;// ����������
	private Spinner edit_nqsxz;// ��Ȩ������
	private EditText edit_xqzrsj;// ����ת��ʱ��
	private Spinner edit_xqzrfs;// ����ת�÷�ʽ
	private EditText edit_nxqzrmj;// ����������ת�����
	private Spinner edit_zrqyt;// ת��ǰ��;
	private Spinner edit_nzrhyt;// ��ת�ú���;
	private EditText edit_tdsynq;// ����ʣ��ʹ������
	private EditText edit_ghrjl;// �滮�ڵ��ݻ���
	private EditText edit_xqzrdj;// ��������ת�õ���
	private EditText edit_xqzrzj;// ��������ת���ܼ�
	/** ������Ϣ.�ؼ� **/
	private Spinner edit_tdjb;// �������ؼ���
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
	/** ����ʹ��Ȩת��������Ϣ **/
	private String value_xqf;// ����
	private String value_xqfztxz;// ������������
	private String value_ntdzl;// ����������
	private String value_nqsxz;// ��Ȩ������
	private String value_xqzrsj;// ����ת��ʱ��
	private String value_xqzrfs;// ����ת�÷�ʽ
	private String value_nxqzrmj;// ����������ת�����
	private String value_zrqyt;// ת��ǰ��;
	private String value_nzrhyt;// ��ת�ú���;
	private String value_tdsynq;// ����ʣ��ʹ������
	private String value_ghrjl;// �滮�ڵ��ݻ���
	private String value_xqzrdj;// ��������ת�õ���
	private String value_xqzrzj;// ��������ת���ܼ�
	private String value_xqxztdtj;
	/** ������Ϣ **/
	private String value_tdjb;// �������ؼ���
	private String value_xzqdm;// ����������

	/** λ����Ϣ.���� **/
	private String value_x;// X����
	private String value_y;// Y����
	private String value_zbxt;// ����ϵͳ
	private String value_remark;// ��ע

	/** Spinner Dict **/
	/** ����ʹ��Ȩת��������Ϣ **/
	private ArrayList<String> list_xqfztxz = new ArrayList<String>();// ������������
	private ArrayList<String> list_nqsxz = new ArrayList<String>();// ��Ȩ������
	private ArrayList<String> list_xqzrfs = new ArrayList<String>();// ����ת�÷�ʽ
	private ArrayList<String> list_zrqyt = new ArrayList<String>();// ת��ǰ��;
	private ArrayList<String> list_nzrhyt = new ArrayList<String>();// ��ת�ú���;
	/** ������Ϣ .Spinner **/
	private ArrayList<String> list_tdjb = new ArrayList<String>();// �������ؼ���

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = (View) inflater.inflate(R.layout.collection_market_demand_transfer_frame, container, false);
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
		textView_Tips.setText("����ʹ��Ȩת��������Ϣ");
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
		/** ����ʹ��Ȩת��������Ϣ **/
		edit_xqf = (EditText) view.findViewById(R.id.edit_xqf);// ����
		edit_xqfztxz = (Spinner) view.findViewById(R.id.edit_xqfztxz);// ������������
		edit_ntdzl = (EditText) view.findViewById(R.id.edit_ntdzl);// ����������
		edit_nqsxz = (Spinner) view.findViewById(R.id.edit_nqsxz);// ��Ȩ������
		edit_xqzrsj = (EditText) view.findViewById(R.id.edit_xqzrsj);// ����ת��ʱ��
		edit_xqzrfs = (Spinner) view.findViewById(R.id.edit_xqzrfs);// ����ת�÷�ʽ
		edit_nxqzrmj = (EditText) view.findViewById(R.id.edit_nxqzrmj);// ����������ת�����
		edit_zrqyt = (Spinner) view.findViewById(R.id.edit_zrqyt);// ת��ǰ��;
		edit_nzrhyt = (Spinner) view.findViewById(R.id.edit_nzrhyt);// ��ת�ú���;
		edit_tdsynq = (EditText) view.findViewById(R.id.edit_tdsynq);// ����ʣ��ʹ������
		edit_ghrjl = (EditText) view.findViewById(R.id.edit_ghrjl);// �滮�ڵ��ݻ���
		edit_xqzrdj = (EditText) view.findViewById(R.id.edit_xqzrdj);// ��������ת�õ���
		edit_xqzrzj = (EditText) view.findViewById(R.id.edit_xqzrzj);// ��������ת���ܼ�
		edit_xqxztdtj = (EditText) view.findViewById(R.id.edit_xqxztdtj);
		/** λ����Ϣ **/
		edit_x = (EditText) view.findViewById(R.id.location_info_lon);
		edit_y = (EditText) view.findViewById(R.id.location_info_lat);
		edit_zbxt = (EditText) view.findViewById(R.id.location_info_zbxt);
		edit_remark = (EditText) view.findViewById(R.id.location_info_remark);
		/** ������Ϣ **/
		edit_tdjb = (Spinner) view.findViewById(R.id.edit_tdjb);// spinner
		edit_xzqdm = (EditText) view.findViewById(R.id.edit_xzqdm);
		edit_xqzrsj.setOnTouchListener(this);

	}

	/**
	 * ˵������ʼ��Spinner �ֵ��б�
	 * 
	 * @return void
	 */
	private void initSpinnerDict() {
		CommonTypeUtil typeUtil = new CommonTypeUtil();
		list_xqfztxz = typeUtil.initList("tzztxz");// ������������
		list_nqsxz = typeUtil.initList("qsxz");// ��Ȩ������
		list_xqzrfs = typeUtil.initList("zrfs");// ����ת�÷�ʽ
		list_zrqyt = typeUtil.initList("ytlx");// ת��ǰ��;
		list_nzrhyt = typeUtil.initList("ytlx");// ��ת�ú���;
		list_tdjb = typeUtil.initList("tdjb");// �������ؼ���

		value_xqfztxz = list_xqfztxz.get(0);
		value_nqsxz = list_nqsxz.get(0);
		value_xqzrfs = list_xqzrfs.get(0);
		value_zrqyt = list_zrqyt.get(0);
		value_nzrhyt = list_nzrhyt.get(0);
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
		edit_xqfztxz.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_xqfztxz = list_xqfztxz.get(index);
				index_xqfztxz = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
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
		edit_xqzrfs.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_xqzrfs = list_xqzrfs.get(index);
				index_xqzrfs = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		edit_zrqyt.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_zrqyt = list_zrqyt.get(index);
				index_zrqyt = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		edit_nzrhyt.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_nzrhyt = list_nzrhyt.get(index);
				index_nzrhyt = index;
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
				locationInfo.setCollectionType(CollectType.Collection_Market_Demand_Transfer);
				// ����ID
				locationInfo.setCollectionMainType(CollectType.Demand);
				locationInfo.setCollectionTableName(CollectType.Collection_Market_Demand_Transfer_Tablename);// ����
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
		/** ����ʹ��Ȩת��������Ϣ **/
		value_xqf = edit_xqf.getText().toString();// ����
		value_ntdzl = edit_ntdzl.getText().toString();// ����������
		value_xqzrsj = edit_xqzrsj.getText().toString();// ����ת��ʱ��
		value_nxqzrmj = edit_nxqzrmj.getText().toString();// ����������ת�����
		value_tdsynq = edit_tdsynq.getText().toString();// ����ʣ��ʹ������
		value_ghrjl = edit_ghrjl.getText().toString();// �滮�ڵ��ݻ���
		value_xqzrdj = edit_xqzrdj.getText().toString();// ��������ת�õ���
		value_xqzrzj = edit_xqzrzj.getText().toString();// ��������ת���ܼ�
		value_xqxztdtj = edit_xqxztdtj.getText().toString();
		/** λ����Ϣ.���� **/
		value_x = edit_x.getText().toString();// ����
		value_y = edit_y.getText().toString();// γ��
		value_zbxt = edit_zbxt.getText().toString();// ����ϵͳ
		value_remark = edit_remark.getText().toString();// ��ע
		/** ������Ϣ **/
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
		ModelCollectionMarketDemandTransfer model = new ModelCollectionMarketDemandTransfer();
		/** ������Ϣ **/
		model.setTHENAME(value_the_name);// ��¼����
		model.setTHECODE(value_the_code);// ��¼����

		/** λ����Ϣ **/
		model.setX(value_x);// ����
		model.setY(value_y);// γ��
		model.setZBXT(value_zbxt);// ����ϵͳ
		model.setREMARK(value_remark);// ��ע
		/** ����ʹ��Ȩת��������Ϣ **/
		model.setXQF(value_xqf);// ����
		model.setXQFZTXZ(value_xqfztxz);// ������������
		model.setNTDZL(value_ntdzl);// ����������
		model.setNQSXZ(value_nqsxz);// ��Ȩ������
		model.setXQZRSJ(value_xqzrsj);// ����ת��ʱ��
		model.setXQZRFS(value_xqzrfs);// ����ת�÷�ʽ
		model.setNXQZRMJ(value_nxqzrmj);// ����������ת�����
		model.setZRQYT(value_zrqyt);// ת��ǰ��;
		model.setNZRHYT(value_nzrhyt);// ��ת�ú���;
		model.setTDSYNQ(value_tdsynq);// ����ʣ��ʹ������
		model.setGHRJL(value_ghrjl);// �滮�ڵ��ݻ���
		model.setXQZRDJ(value_xqzrdj);// ��������ת�õ���
		model.setXQZRZJ(value_xqzrzj);// ��������ת���ܼ�
		model.setXQXZTDTJ(value_xqxztdtj);
		/** ������Ϣ **/
		model.setTDJB(value_tdjb); // �������ؼ���
		model.setXZQDM(value_xzqdm);// ���������루�弶��������

		/** ��ֵ�����ֶ� **/
		model.setIndex_xqfztxz(index_xqfztxz);
		model.setIndex_nqsxz(index_nqsxz);
		model.setIndex_xqzrfs(index_xqzrfs);
		model.setIndex_zrqyt(index_zrqyt);
		model.setIndex_nzrhyt(index_nzrhyt);
		model.setIndex_tdjb(index_tdjb);
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

			if (v.getId() == R.id.edit_xqzrsj) {
				final int inType = edit_xqzrsj.getInputType();
				edit_xqzrsj.setInputType(InputType.TYPE_NULL);
				edit_xqzrsj.onTouchEvent(event);
				edit_xqzrsj.setInputType(inType);
				edit_xqzrsj.setSelection(edit_xqzrsj.getText().length());

				builder.setTitle("ѡȡʱ��");
				builder.setPositiveButton("ȷ  ��", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

						StringBuffer sb = new StringBuffer();
						sb.append(String.format("%d-%02d-%02d", datePicker.getYear(), datePicker.getMonth() + 1, datePicker.getDayOfMonth()));
						sb.append("  00:00:00");
						edit_xqzrsj.setText(sb);
						edit_xqzrsj.requestFocus();

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
