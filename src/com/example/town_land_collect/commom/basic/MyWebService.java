package com.example.town_land_collect.commom.basic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import rmobile.platform.http.AsyncHttpClient;
import rmobile.platform.http.AsyncHttpResponseHandler;
import rmobile.platform.http.RSyncHttpClient;
import rmobile.platform.http.RequestParams;
import android.content.Context;

public class MyWebService {
	// TODO
	// 服务路径
	private String servicePath = "http://14.23.153.52:8090/";
	// token
	private String token = "";

	public String getServicePath() {
		return servicePath;
	}

	public void setServicePath(String servicePath) {
		this.servicePath = servicePath;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	// 必须从Activity中初始化并传进来
	private AsyncHttpClient asyncHttpClient;// 异步
	private RSyncHttpClient syncHttpClient;// 同步，这个必须在不同与UI线程中使用，例如new一新的thread

	public AsyncHttpClient getAsyncHttpClient() {
		return asyncHttpClient;
	}

	public void setAsyncHttpClient(AsyncHttpClient asyncHttpClient) {
		this.asyncHttpClient = asyncHttpClient;
		// this.asynchttpClient.setTimeout(10000);
	}

	public RSyncHttpClient getSyncHttpClient() {
		return syncHttpClient;
	}

	public void setSyncHttpClient(RSyncHttpClient syncHttpClient) {
		this.syncHttpClient = syncHttpClient;
	}

	protected Context context;

	public MyWebService(Context context) {
		this.context = context;
	}

	/**
	 * 设置参数
	 * 
	 * @param name
	 * @param data
	 * @return
	 */
	protected NameValuePair setNameValuePair(String name, String data) {
//		try {
//			data = URLEncoder.encode(data, "utf-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
		NameValuePair nameValuePair = new BasicNameValuePair(name, data);
		return nameValuePair;
	}

	/**
	 * Post，异步请求
	 * 
	 * @param isCode
	 * @param controller
	 * @param action
	 * @param paramsList
	 * @param handler
	 */
	private void asynPost(boolean isCode, String controller, String action,
			List<NameValuePair> paramsList, List<String> filePathList,
			AsyncHttpResponseHandler handler) {

		// 设置参数，发送请求
		RequestParams params = new RequestParams();
		String httpPath = this.servicePath;

		httpPath += controller + ".mobile?" + action;

		if (paramsList != null && paramsList.size() > 0) {
			for (int i = 0; i < paramsList.size(); i++) {
				params.put(paramsList.get(i).getName(), paramsList.get(i)
						.getValue());
			}
		}

		// 添加文件///////////////////////////////////////////////////////
		if (filePathList != null && filePathList.size() > 0) {
			for (int i = 0, len = filePathList.size(); i < len; i++) {
				params.put("file" + (i + 1), filePathList.get(i));
			}
		}

		asyncHttpClient.post(httpPath, params, handler);
	}

	// TODO
	private void asynPost(String controller, String action,
			List<NameValuePair> paramsList, List<String> filePathList,
			AsyncHttpResponseHandler handler) {

		// 设置参数，发送请求
		RequestParams params = new RequestParams();
		String httpPath = this.servicePath;

		httpPath += controller + "/" + action;

		if (paramsList != null && paramsList.size() > 0) {
			for (int i = 0; i < paramsList.size(); i++) {
				params.put(paramsList.get(i).getName(), paramsList.get(i)
						.getValue());
			}
		}
		asyncHttpClient.post(httpPath, params, handler);
	}

	/**
	 * 发送POST请求（加密）
	 * 
	 * @param path
	 * @param controller
	 * @param action
	 * @param paramsList
	 * @param handler
	 */
	protected void asynPost(String controller, String action,
			List<NameValuePair> paramsList, AsyncHttpResponseHandler handler) {
		asynPost(controller, action, paramsList, null, handler);
	}

	/**
	 * 发送POST请求（不加密）
	 * 
	 * @param path
	 * @param controller
	 * @param action
	 * @param paramsList
	 * @param handler
	 */
	protected void asynPostNoCode(String controller, String action,
			List<NameValuePair> paramsList, AsyncHttpResponseHandler handler) {
		asynPost(false, controller, action, paramsList, null, handler);
	}

	// /**
	// * 发送POST请求（不加密）,带文件上传
	// *
	// * @param path
	// * @param controller
	// * @param action
	// * @param paramsList
	// * @param filePathList
	// * @param handler
	// */
	// protected void asynPostNoCode(String controller, String action,
	// List<NameValuePair> paramsList, List<String> filePathList,
	// AsyncHttpResponseHandler handler) {
	// asynPost(false, controller, action, paramsList, filePathList, handler);
	// }

	/**
	 * POST上传文件
	 * 
	 * @param path
	 * @param controller
	 * @param action
	 * @param paramsList
	 * @param filePathList
	 * @param handler
	 */
	protected void asyncPostFile(String controller, String action,
			String md5Code, File file, AsyncHttpResponseHandler handler) {

		// 设置参数，发送请求
		RequestParams params = new RequestParams();
		params.put("token", this.token);
		params.put("md5", md5Code);
		try {
			params.put("file", file);
			// 有三种方式
			// params.put("file1", new File("/mnt/sdcard/testpic.jpg"));// 上传文件
			// params.put("file2", inputStream); // 上传数据流
			// params.put("file3", new ByteArrayInputStream(bytes));
			// // 提交字节流
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// 这个不成功 //synchttpClient.post(this.servicePath + controller +
		// ".mobile?" + action, params);
		asyncHttpClient.post(this.servicePath + controller + ".mobile?"
				+ action, params, handler);
	}

	/*-- 同步请求 ---------------------------------------------------------------------------------------*/
	/**
	 * 同步，POST请求
	 * 
	 * @param isCode
	 * @param controller
	 * @param action
	 * @param paramsList
	 * @param filePathListr
	 * @return
	 */
	private String syncPost(boolean isCode, String controller, String action,
			List<NameValuePair> paramsList, List<String> filePathListr) {
		String result = "";
		// 设置参数，发送请求
		RequestParams params = new RequestParams();
		String httpPath = this.servicePath;

		httpPath += controller + ".mobile?" + action;

		if (paramsList != null && paramsList.size() > 0) {
			for (int i = 0; i < paramsList.size(); i++) {
				params.put(paramsList.get(i).getName(), paramsList.get(i)
						.getValue());
			}
		}

		result = syncHttpClient.post(httpPath, params);
		return result;
	}

	/**
	 * 发送同步POST请求（加密）
	 * 
	 * @param controller
	 * @param action
	 * @param paramsList
	 * @return
	 */
	protected String syncPost(String controller, String action,
			List<NameValuePair> paramsList) {
		return syncPost(true, controller, action, paramsList, null);
	}

	/**
	 * 发送同步POST请求（不加密）
	 * 
	 * @param controller
	 * @param action
	 * @param paramsList
	 * @return
	 */
	protected String syncPostNoCode(String controller, String action,
			List<NameValuePair> paramsList) {
		return syncPost(false, controller, action, paramsList, null);
	}
}
