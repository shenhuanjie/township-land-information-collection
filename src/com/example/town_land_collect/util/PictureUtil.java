package com.example.town_land_collect.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.util.Base64;

/**
 * @Title PictureUtil.java
 * @Package com.example.town_land_collect.util
 * @Description Compressed images below 100 k and keep do not break really high
 *              efficient method
 * @author Shen.HuanJie
 * @date 2015-11-9 ����11:46:32
 * @version V1.0
 * @ref https://github.com/feicien/StudyDemo/tree/master/FileUploadDemo/src/com/
 *      loveplusplus/demo/fileupload/PictureUtil.java
 */
public class PictureUtil {

	/**
	 * ��bitmapת����String
	 * 
	 * @param filePath
	 * @return
	 */
	public static String bitmapToString(String filePath) {

		Bitmap bm = getSmallBitmap(filePath);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		bm.compress(Bitmap.CompressFormat.JPEG, 40, baos);
		byte[] b = baos.toByteArray();

		return Base64.encodeToString(b, Base64.DEFAULT);

	}

	/**
	 * ����ͼƬ������ֵ
	 * 
	 * @param options
	 * @param reqWidth
	 * @param reqHeight
	 * @return
	 */
	public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
		// ԭʼͼ��ĸ߶ȺͿ��
		final int height = options.outHeight;
		final int width = options.outWidth;
		int inSampleSize = 1;

		if (height > reqHeight || width > reqWidth) {

			// �߶ȺͿ�ȵļ������Ҫ��߶ȺͿ��
			final int heightRatio = Math.round((float) height / (float) reqHeight);
			final int widthRatio = Math.round((float) width / (float) reqWidth);

			// ѡ����С�ı�����ΪinSampleSizeֵ,�⽫��֤һ�����յ�ͼ��ߴ���ڻ��������ĸ߶ȺͿ�ȡ�
			inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
		}

		return inSampleSize;
	}

	/**
	 * ����·�����ͼƬ��ѹ��������bitmap������ʾ
	 * 
	 * @param filePath
	 * @return
	 */
	public static Bitmap getSmallBitmap(String filePath) {
		final BitmapFactory.Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;
		BitmapFactory.decodeFile(filePath, options);

		// ����inSampleSize
		options.inSampleSize = calculateInSampleSize(options, 480, 800);

		// ������inSampleSize����λͼ
		options.inJustDecodeBounds = false;

		return BitmapFactory.decodeFile(filePath, options);
	}

	/**
	 * ����·�����ͼƬ��ѹ��������bitmap�����ϴ�������
	 * 
	 * @param filePath
	 * @return
	 */
	public static Bitmap getSmallUploadBitmap(String filePath) {
		final BitmapFactory.Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;
		BitmapFactory.decodeFile(filePath, options);

		// ����inSampleSize
		options.inSampleSize = calculateInSampleSize(options, 480, 800);

		// ������inSampleSize����λͼ
		options.inJustDecodeBounds = false;

		Bitmap bitmap = BitmapFactory.decodeFile(filePath, options);
		return compressImage(bitmap);
	}

	/**
	 * 
	 * ˵����ͼƬ����ѹ������
	 * 
	 * @param image
	 * @return
	 * @return Bitmap
	 */
	private static Bitmap compressImage(Bitmap image) {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		image.compress(Bitmap.CompressFormat.JPEG, 100, baos);// ����ѹ������������100��ʾ��ѹ������ѹ��������ݴ�ŵ�baos��
		int options = 100;
		while (baos.toByteArray().length / 1024 > 100) { // ѭ���ж����ѹ����ͼƬ�Ƿ����100kb,���ڼ���ѹ��
			baos.reset();// ����baos�����baos
			image.compress(Bitmap.CompressFormat.JPEG, options, baos);// ����ѹ��options%����ѹ��������ݴ�ŵ�baos��
			options -= 10;// ÿ�ζ�����10
		}
		ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());// ��ѹ���������baos��ŵ�ByteArrayInputStream��
		Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);// ��ByteArrayInputStream��������ͼƬ
		return bitmap;
	}

	/**
	 * ����·��ɾ��ͼƬ
	 * 
	 * @param path
	 */
	public static void deleteTempFile(String path) {
		File file = new File(path);
		if (file.exists()) {
			file.delete();
		}
	}

	/**
	 * 
	 * ˵������ӵ�ͼ��
	 * 
	 * @param context
	 * @param path
	 * @return void
	 */
	public static void galleryAddPic(Context context, String path) {
		Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
		File f = new File(path);
		Uri contentUri = Uri.fromFile(f);
		mediaScanIntent.setData(contentUri);
		context.sendBroadcast(mediaScanIntent);
	}

	/**
	 * ��ȡ����ͼƬ��Ŀ¼
	 * 
	 * @return
	 */
	public static File getAlbumDir() {
		File dir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), getAlbumName());
		if (!dir.exists()) {
			dir.mkdirs();
		}
		return dir;
	}

	/**
	 * ��ȡ���� ��������ͼƬ�ļ�������
	 * 
	 * @return
	 */
	public static String getAlbumName() {
		return "upload";
	}
}

