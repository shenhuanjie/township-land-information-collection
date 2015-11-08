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
	 * 跳转到页面
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
	 * 获取本地图片
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
	 * 版本号转换成double
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
	 * 获取网络图片资源
	 * 
	 * @param url
	 * @return
	 */
	public static Bitmap getHttpBitmap(String url) {
		URL myFileURL;
		// url += "?version="+Common.version;//为每个请求增加版本号,图片不需要??
		Bitmap bitmap = null;
		try {
			myFileURL = new URL(url);
			// 获得连接
			HttpURLConnection conn = (HttpURLConnection) myFileURL
					.openConnection();
			// 设置超时时间为6000毫秒，conn.setConnectionTiem(0);表示没有时间限制
			conn.setConnectTimeout(6000);
			// 连接设置获得数据流
			conn.setDoInput(true);
			// 不使用缓存
			conn.setUseCaches(false);
			// 这句可有可无，没有影响
			// conn.connect();
			// 得到数据流
			InputStream is = conn.getInputStream();
			// 解析得到图片
			bitmap = BitmapFactory.decodeStream(is);

			// 关闭数据流
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bitmap;
	}

	/**
	 * 日期窗口
	 * 
	 * @param context
	 */
	public static void openCalendarWindow(Context context) {
		// 日期
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

	// 获取R类资源的方法 , paramString1:drawable 或者 color 等，paramString2：app_icon
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
	 * 经纬度保留6位小数
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
	// // 保留6位小数
	// result.longitude = Double.parseDouble(df.format(point.longitude));
	// result.latitude = Double.parseDouble(df.format(point.latitude));
	// return result;
	// }

	/**
	 * 把double类型，四舍五入保留count位小数
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

	// 未使用 ----------------------------------------------------------------
	/**
	 * bitmap转为base64
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
	 * 获取任务优先级的文字说明
	 * 
	 * @param priority
	 *            (1-低；2-中；3-高；其他-低)
	 * @return
	 */
	public static String getTaskPriority(int priority) {
		String result = "低";
		switch (priority) {
		case 1:
			result = "低";
			break;
		case 2:
			result = "中";
			break;
		case 3:
			result = "高";
			break;
		default:
			result = "低";
			break;
		}
		return result;
	}

}
