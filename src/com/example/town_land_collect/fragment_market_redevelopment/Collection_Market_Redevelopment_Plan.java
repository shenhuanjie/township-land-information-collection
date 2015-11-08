/**
 * 
 */
package com.example.town_land_collect.fragment_market_redevelopment;

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
import com.example.town_land_collect.model.market_redevelopment.ModelCollectionMarketRedevelopmentPlan;
import com.example.town_land_collect.util.AttachmentUtil;
import com.example.town_land_collect.util.CollectType;
import com.example.town_land_collect.util.ComUtil;
import com.example.town_land_collect.util.CommonTypeUtil;
import com.example.town_land_collect.util.ImageUtil;
import com.example.town_land_collect.util.ToastUtil;

/**
 * @Title Collection_Market_Redevelopment_Pain.java
 * @Package com.example.town_land_collect.fragment_market_redevelopment
 * @Description �ٿ����ƻ���Ŀ��Ϣ
 * @author Shen.dev
 * @date 2015-10-14 ����5:34:44
 * @version V1.0
 */
@SuppressLint({ "CutPasteId", "ClickableViewAccessibility" })
public class Collection_Market_Redevelopment_Plan extends Fragment implements OnClickListener, OnTouchListener {
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

	/** �ٿ����ƻ���Ŀ��Ϣ **/
	private int index_tdyt = 0;// ������;
	private int index_ghyt = 0;// �滮��;
	private int index_nkfms = 0;// �⿪��ģʽ
	private int index_zjly = 0;// �ʽ���Դ
	private int index_ngdfs = 0;// �⹩�ط�ʽ
	private int index_cylx = 0;// �滮��ҵ����
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
	/** �ٿ����ƻ���Ŀ��Ϣ **/
	private EditText edit_bh;// ���
	private EditText edit_xmmc;// ��Ŀ����
	private EditText edit_tdzl;// ��������
	private EditText edit_tdsyz;// ����������
	private EditText edit_tdshyz;// ����ʹ����
	private Spinner edit_tdyt;// ������;
	private EditText edit_tdmj;// �������
	private Spinner edit_ghyt;// �滮��;
	private EditText edit_ghrjl;// �滮�ݻ���
	private EditText edit_ghjzxs;// �滮����ϵ��
	private EditText edit_ghjzmd;// �滮�����ܶ�
	private EditText edit_ghlvh;// �滮�̻���
	private Spinner edit_nkfms;// �⿪��ģʽ
	private EditText edit_yjztz;// Ԥ����Ͷ��
	private Spinner edit_zjly;// �ʽ���Դ
	private Spinner edit_ngdfs;// �⹩�ط�ʽ
	private Spinner edit_cylx;// �滮��ҵ����
	private Spinner edit_qyzdcy;// ����������ҵ����
	private EditText edit_qygyjzdj;// ������н����õػ�׼�ؼ�
	private EditText edit_qyjtjzdj;// �����彨���õػ�׼�ؼ�
	private EditText edit_yjdjcz;// Ԥ�Ƶؾ���ֵ
	private EditText edit_yjdjss;// Ԥ�Ƶؾ�˰��
	private EditText edit_yjdjcyry;// Ԥ�Ƶؾ���ҵ��Ա��
	private EditText edit_qtyqyx;// ����Ԥ��ЧӦ
	private EditText edit_zfyy;// ������Ը
	private EditText edit_kfsyy;// ��������Ը
	private EditText edit_tdsyzyy;// ������������Ը
	private EditText edit_tdshyzyy;// ����ʹ������Ը

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
	/** �ٿ����ƻ���Ŀ��Ϣ **/
	private String value_bh;// ���
	private String value_xmmc;// ��Ŀ����
	private String value_tdzl;// ��������
	private String value_tdsyz;// ����������
	private String value_tdshyz;// ����ʹ����
	private String value_tdyt;// ������;
	private String value_tdmj;// �������
	private String value_ghyt;// �滮��;
	private String value_ghrjl;// �滮�ݻ���
	private String value_ghjzxs;// �滮����ϵ��
	private String value_ghjzmd;// �滮�����ܶ�
	private String value_ghlvh;// �滮�̻���
	private String value_nkfms;// �⿪��ģʽ
	private String value_yjztz;// Ԥ����Ͷ��
	private String value_zjly;// �ʽ���Դ
	private String value_ngdfs;// �⹩�ط�ʽ
	private String value_cylx;// �滮��ҵ����
	private String value_qyzdcy;// ����������ҵ����
	private String value_qygyjzdj;// ������н����õػ�׼�ؼ�
	private String value_qyjtjzdj;// �����彨���õػ�׼�ؼ�
	private String value_yjdjcz;// Ԥ�Ƶؾ���ֵ
	private String value_yjdjss;// Ԥ�Ƶؾ�˰��
	private String value_yjdjcyry;// Ԥ�Ƶؾ���ҵ��Ա��
	private String value_qtyqyx;// ����Ԥ��ЧӦ
	private String value_zfyy;// ������Ը
	private String value_kfsyy;// ��������Ը
	private String value_tdsyzyy;// ������������Ը
	private String value_tdshyzyy;// ����ʹ������Ը
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
	/** �ٿ����ƻ���Ŀ��Ϣ **/
	private ArrayList<String> list_tdyt = new ArrayList<String>();// ������;
	private ArrayList<String> list_ghyt = new ArrayList<String>();// �滮��;
	private ArrayList<String> list_nkfms = new ArrayList<String>();// �⿪��ģʽ
	private ArrayList<String> list_zjly = new ArrayList<String>();// �ʽ���Դ
	private ArrayList<String> list_ngdfs = new ArrayList<String>();// �⹩�ط�ʽ
	private ArrayList<String> list_cylx = new ArrayList<String>();// �滮��ҵ����
	private ArrayList<String> list_qyzdcy = new ArrayList<String>();// ����������ҵ����
	/** ������Ϣ.�ؼ� **/
	private ArrayList<String> list_tdjb = new ArrayList<String>();// �������ؼ���

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = (View) inflater.inflate(R.layout.collection_market_redevelopment_plan_frame, container, false);
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
		textView_Tips.setText("�ٿ����ƻ���Ŀ��Ϣ");
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
		/** �ٿ����ƻ���Ŀ��Ϣ **/
		edit_bh = (EditText) view.findViewById(R.id.edit_bh);// ���
		edit_xmmc = (EditText) view.findViewById(R.id.edit_xmmc);// ��Ŀ����
		edit_tdzl = (EditText) view.findViewById(R.id.edit_tdzl);// ��������
		edit_tdsyz = (EditText) view.findViewById(R.id.edit_tdsyz);// ����������
		edit_tdshyz = (EditText) view.findViewById(R.id.edit_tdshyz);// ����ʹ����
		edit_tdyt = (Spinner) view.findViewById(R.id.edit_tdyt);// ������;
		edit_tdmj = (EditText) view.findViewById(R.id.edit_tdmj);// �������
		edit_ghyt = (Spinner) view.findViewById(R.id.edit_ghyt);// �滮��;
		edit_ghrjl = (EditText) view.findViewById(R.id.edit_ghrjl);// �滮�ݻ���
		edit_ghjzxs = (EditText) view.findViewById(R.id.edit_ghjzxs);// �滮����ϵ��
		edit_ghjzmd = (EditText) view.findViewById(R.id.edit_ghjzmd);// �滮�����ܶ�
		edit_ghlvh = (EditText) view.findViewById(R.id.edit_ghlvh);// �滮�̻���
		edit_nkfms = (Spinner) view.findViewById(R.id.edit_nkfms);// �⿪��ģʽ
		edit_yjztz = (EditText) view.findViewById(R.id.edit_yjztz);// Ԥ����Ͷ��
		edit_zjly = (Spinner) view.findViewById(R.id.edit_zjly);// �ʽ���Դ
		edit_ngdfs = (Spinner) view.findViewById(R.id.edit_ngdfs);// �⹩�ط�ʽ
		edit_cylx = (Spinner) view.findViewById(R.id.edit_cylx);// �滮��ҵ����
		edit_qyzdcy = (Spinner) view.findViewById(R.id.edit_qyzdcy);// ����������ҵ����
		edit_qygyjzdj = (EditText) view.findViewById(R.id.edit_qygyjzdj);// ������н����õػ�׼�ؼ�
		edit_qyjtjzdj = (EditText) view.findViewById(R.id.edit_qyjtjzdj);// �����彨���õػ�׼�ؼ�
		edit_yjdjcz = (EditText) view.findViewById(R.id.edit_yjdjcz);// Ԥ�Ƶؾ���ֵ
		edit_yjdjss = (EditText) view.findViewById(R.id.edit_yjdjss);// Ԥ�Ƶؾ�˰��
		edit_yjdjcyry = (EditText) view.findViewById(R.id.edit_yjdjcyry);// Ԥ�Ƶؾ���ҵ��Ա��
		edit_qtyqyx = (EditText) view.findViewById(R.id.edit_qtyqyx);// ����Ԥ��ЧӦ
		edit_zfyy = (EditText) view.findViewById(R.id.edit_zfyy);// ������Ը
		edit_kfsyy = (EditText) view.findViewById(R.id.edit_kfsyy);// ��������Ը
		edit_tdsyzyy = (EditText) view.findViewById(R.id.edit_tdsyzyy);// ������������Ը
		edit_tdshyzyy = (EditText) view.findViewById(R.id.edit_tdshyzyy);// ����ʹ������Ը
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
		list_tdyt = typeUtil.initList("tdyt");// ������;
		list_ghyt = typeUtil.initList("tdyt");// �滮��;
		list_nkfms = typeUtil.initList("zkfms");// �⿪��ģʽ
		list_zjly = typeUtil.initList("zkfzjly");// �ʽ���Դ
		list_ngdfs = typeUtil.initList("tdgyfs");// �⹩�ط�ʽ
		list_cylx = typeUtil.initList("cylx");// �滮��ҵ����
		list_qyzdcy = typeUtil.initList("cylx");// ����������ҵ����
		list_tdjb = typeUtil.initList("tdjb");// �������ؼ���

		value_tdyt = list_tdyt.get(0);
		value_ghyt = list_ghyt.get(0);
		value_nkfms = list_nkfms.get(0);
		value_zjly = list_zjly.get(0);
		value_ngdfs = list_ngdfs.get(0);
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
		edit_ghyt.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_ghyt = list_ghyt.get(index);
				index_ghyt = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		edit_nkfms.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_nkfms = list_nkfms.get(index);
				index_nkfms = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
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
		edit_ngdfs.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) {
				value_ngdfs = list_ngdfs.get(index);
				index_ngdfs = index;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
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
			locationInfo.setCollectionType(CollectType.Collection_Market_Redevelopment_Plan);// TODO
																								// ����ID
			locationInfo.setCollectionMainType(CollectType.Redevelopment);
			locationInfo.setCollectionTableName(CollectType.Collection_Market_Redevelopment_Plan_Tablename);// ����
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
		/** �ٿ����ƻ���Ŀ��Ϣ **/
		value_bh = edit_bh.getText().toString();// ���
		value_xmmc = edit_xmmc.getText().toString();// ��Ŀ����
		value_tdzl = edit_tdzl.getText().toString();// ��������
		value_tdsyz = edit_tdsyz.getText().toString();// ����������
		value_tdshyz = edit_tdshyz.getText().toString();// ����ʹ����
		value_tdmj = edit_tdmj.getText().toString();// �������
		value_ghrjl = edit_ghrjl.getText().toString();// �滮�ݻ���
		value_ghjzxs = edit_ghjzxs.getText().toString();// �滮����ϵ��
		value_ghjzmd = edit_ghjzmd.getText().toString();// �滮�����ܶ�
		value_ghlvh = edit_ghlvh.getText().toString();// �滮�̻���
		value_yjztz = edit_yjztz.getText().toString();// Ԥ����Ͷ��
		value_qygyjzdj = edit_qygyjzdj.getText().toString();// ������н����õػ�׼�ؼ�
		value_qyjtjzdj = edit_qyjtjzdj.getText().toString();// �����彨���õػ�׼�ؼ�
		value_yjdjcz = edit_yjdjcz.getText().toString();// Ԥ�Ƶؾ���ֵ
		value_yjdjss = edit_yjdjss.getText().toString();// Ԥ�Ƶؾ�˰��
		value_yjdjcyry = edit_yjdjcyry.getText().toString();// Ԥ�Ƶؾ���ҵ��Ա��
		value_qtyqyx = edit_qtyqyx.getText().toString();// ����Ԥ��ЧӦ
		value_zfyy = edit_zfyy.getText().toString();// ������Ը
		value_kfsyy = edit_kfsyy.getText().toString();// ��������Ը
		value_tdsyzyy = edit_tdsyzyy.getText().toString();// ������������Ը
		value_tdshyzyy = edit_tdshyzyy.getText().toString();// ����ʹ������Ը
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
		ModelCollectionMarketRedevelopmentPlan model = new ModelCollectionMarketRedevelopmentPlan();
		/** ������Ϣ **/
		model.setTHENAME(value_the_name);// ��¼����
		model.setTHECODE(value_the_code);// ��¼����
		// ** �ٿ����ƻ���Ŀ��Ϣ **/
		model.setBH(value_bh);// ���
		model.setXMMC(value_xmmc);// ��Ŀ����
		model.setTDZL(value_tdzl);// ��������
		model.setTDSYZ(value_tdsyz);// ����������
		model.setTDSHYZ(value_tdshyz);// ����ʹ����
		model.setTDYT(value_tdyt);// ������;
		model.setTDMJ(value_tdmj);// �������
		model.setGHYT(value_ghyt);// �滮��;
		model.setGHRJL(value_ghrjl);// �滮�ݻ���
		model.setGHJZXS(value_ghjzxs);// �滮����ϵ��
		model.setGHJZMD(value_ghjzmd);// �滮�����ܶ�
		model.setGHLVH(value_ghlvh);// �滮�̻���
		model.setNKFMS(value_nkfms);// �⿪��ģʽ
		model.setYJZTZ(value_yjztz);// Ԥ����Ͷ��
		model.setZJLY(value_zjly);// �ʽ���Դ
		model.setNGDFS(value_ngdfs);// �⹩�ط�ʽ
		model.setCYLX(value_cylx);// �滮��ҵ����
		model.setQYZDCY(value_qyzdcy);// ����������ҵ����
		model.setQYGYJZDJ(value_qygyjzdj);// ������н����õػ�׼�ؼ�
		model.setQYJTJZDJ(value_qyjtjzdj);// �����彨���õػ�׼�ؼ�
		model.setYJDJCZ(value_yjdjcz);// Ԥ�Ƶؾ���ֵ
		model.setYJDJSS(value_yjdjss);// Ԥ�Ƶؾ�˰��
		model.setYJDJCYRY(value_yjdjcyry);// Ԥ�Ƶؾ���ҵ��Ա��
		model.setQTYQYX(value_qtyqyx);// ����Ԥ��ЧӦ
		model.setZFYY(value_zfyy);// ������Ը
		model.setKFSYY(value_kfsyy);// ��������Ը
		model.setTDSYZYY(value_tdsyzyy);// ������������Ը
		model.setTDSHYZYY(value_tdshyzyy);// ����ʹ������Ը

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
		/** �ٿ����ƻ���Ŀ��Ϣ **/
		model.setIndex_tdyt(index_tdyt);// ������;
		model.setIndex_ghyt(index_ghyt);// �滮��;
		model.setIndex_nkfms(index_nkfms);// �⿪��ģʽ
		model.setIndex_zjly(index_zjly);// �ʽ���Դ
		model.setIndex_ngdfs(index_ngdfs);// �⹩�ط�ʽ
		model.setIndex_cylx(index_cylx);// �滮��ҵ����
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
