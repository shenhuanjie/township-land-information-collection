package com.example.town_land_collect.commom.basic;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.R.string;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;
import android.widget.DatePicker;

public class Common {

	/**
	 * ��ת��ҳ��
	 * 
	 * @param context
	 * @param clazz
	 */
	public static void startActivity(Context context, Class clazz) {
		Intent intent = new Intent();
		intent.setClass(context, clazz);
		context.startActivity(intent);
	}

	/**
	 * ��ȡ����ͼƬ
	 * 
	 * @param url
	 */
	public static Bitmap getLoacalBitmap(String url) {
		try {
			FileInputStream fis = new FileInputStream(url);
			return BitmapFactory.decodeStream(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * �汾��ת����double
	 * 
	 * @param version
	 * @return
	 */
	public static double getVersion(String version) {
		if (version != null && !version.equals("")) {
			String[] versionArr = version.split("\\.");
			String result = "";
			if (versionArr.length > 2) {
				for (int i = 0; i < versionArr.length; i++) {
					if (i == 0) {
						result += versionArr[i] + ".";
					} else {
						result += versionArr[i];
					}
				}
			} else {
				result = version;
			}
			return Double.parseDouble(result);
		} else {
			return 0;
		}
	}

	/**
	 * ��ȡ����ͼƬ��Դ
	 * 
	 * @param url
	 * @return
	 */
	public static Bitmap getHttpBitmap(String url) {
		URL myFileURL;
		// url += "?version="+Common.version;//Ϊÿ���������Ӱ汾��,ͼƬ����Ҫ??
		Bitmap bitmap = null;
		try {
			myFileURL = new URL(url);
			// �������
			HttpURLConnection conn = (HttpURLConnection) myFileURL
					.openConnection();
			// ���ó�ʱʱ��Ϊ6000���룬conn.setConnectionTiem(0);��ʾû��ʱ������
			conn.setConnectTimeout(6000);
			// �������û��������
			conn.setDoInput(true);
			// ��ʹ�û���
			conn.setUseCaches(false);
			// �����п��ޣ�û��Ӱ��
			// conn.connect();
			// �õ�������
			InputStream is = conn.getInputStream();
			// �����õ�ͼƬ
			bitmap = BitmapFactory.decodeStream(is);

			// �ر�������
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bitmap;
	}

	/**
	 * ���ڴ���
	 * 
	 * @param context
	 */
	public static void openCalendarWindow(Context context) {
		// ����
		final Calendar cd = Calendar.getInstance();
		Date date = new Date();
		cd.setTime(date);
		final int years = cd.get(Calendar.YEAR);
		final int month = cd.get(Calendar.MONTH) + 1;
		final int day = cd.get(Calendar.DAY_OF_MONTH);

		new DatePickerDialog(context, new OnDateSetListener() {
			public void onDateSet(DatePicker view, int year, int monthOfYear,
					int dayOfMonth) {
				String text = year
						+ "-"
						+ ((monthOfYear + 1) < 10 ? "0" + (monthOfYear + 1)
								: (monthOfYear + 1)) + "-"
						+ (dayOfMonth < 10 ? "0" + dayOfMonth : dayOfMonth);
			}

		}, years, month - 1, day).show();
	}

	// ��ȡR����Դ�ķ��� , paramString1:drawable ���� color �ȣ�paramString2��app_icon
	public static int getItemId(Context paramContext, String paramString1,
			String paramString2) {
		try {
			Class<?> localClass = Class.forName(paramContext.getPackageName()
					+ ".R$" + paramString1);
			Field localField = localClass.getField(paramString2);
			int i = Integer.parseInt(localField.get(localField.getName())
					.toString());
			return i;
		} catch (Exception localException) {
			Log.e("getIdByReflection error", localException.getMessage());
		}

		return 0;
	}

	/**
	 * ��γ�ȱ���6λС��
	 * 
	 * @param cx
	 * @param cy
	 * @return
	 */
	// public static PointData setLatlng(double cx, double cy) {
	// DecimalFormat df = new DecimalFormat(".000000");
	// PointData result = new PointData();
	// PointData point = new PointData();
	// point.longitude = cx;
	// point.latitude = cy;
	// // ����6λС��
	// result.longitude = Double.parseDouble(df.format(point.longitude));
	// result.latitude = Double.parseDouble(df.format(point.latitude));
	// return result;
	// }

	/**
	 * ��double���ͣ��������뱣��countλС��
	 * 
	 * @param dbl
	 * @param count
	 * @return
	 */
	public static double changeDouble(double dbl, int count) {
		BigDecimal b = new BigDecimal(dbl);
		return b.setScale(count, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	public static String bindString(String str) {
		// if (str == null || str.equals("null")) {
		// str = "";
		// } else {
		// try {
		// str = URLEncoder.encode(str, "utf-8");
		// } catch (UnsupportedEncodingException e) {
		// e.printStackTrace();
		// }
		// }
		return str;
	}

	public static String bindString() {
		return "0";
	}

	public static String bindDate() {
		String ctime = bindDate(new Date());
		return ctime;
	}

	public static String bindDate(Date date) {
		SimpleDateFormat formatter;
		formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String ctime = formatter.format(date);
		return ctime;
	}

	public static Integer bindInteger(Integer in) {
		return in == null ? 0 : in;
	}

	public static Double bindDouble(Double dou) {
		return dou == null ? 0 : dou;
	}

	// δʹ�� ----------------------------------------------------------------
	/**
	 * bitmapתΪbase64
	 * 
	 * @param bitmap
	 * @return
	 */
	public static String bitmapToBase64(Bitmap bitmap) {
		String result = null;
		ByteArrayOutputStream baos = null;
		try {
			if (bitmap != null) {
				baos = new ByteArrayOutputStream();
				bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);

				baos.flush();
				baos.close();

				byte[] bitmapBytes = baos.toByteArray();
				result = Base64.encodeToString(bitmapBytes, Base64.DEFAULT);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (baos != null) {
					baos.flush();
					baos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * ��ȡ�������ȼ�������˵��
	 * 
	 * @param priority
	 *            (1-�ͣ�2-�У�3-�ߣ�����-��)
	 * @return
	 */
	public static String getTaskPriority(int priority) {
		String result = "��";
		switch (priority) {
		case 1:
			result = "��";
			break;
		case 2:
			result = "��";
			break;
		case 3:
			result = "��";
			break;
		default:
			result = "��";
			break;
		}
		return result;
	}

}
