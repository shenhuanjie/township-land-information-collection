package com.example.town_land_collect.model;

import java.io.Serializable;

import org.litepal.crud.DataSupport;

import android.R.integer;

public class AttachmentEntity extends DataSupport implements Serializable {
	/**
	 * 附件信息
	 */
	private static final long serialVersionUID = 1L;

	/** 基本信息 **/
	private int id;// 附件ID
	private int objId;// 对象ID
	private String name;// 名称
	private String date;// 创建时间
	private String uploaddate;// 上传时间
	private int stateCode;// 上传状态（0:未上传，1:待上传，2:已上传，3:上传失败）
	private String imageUri;// 图片路径(SD卡)
	private int uploadId;// 记录对象ID

	private int width;
	private int height;

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width
	 *            the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the objId
	 */
	public int getObjId() {
		return objId;
	}

	/**
	 * @param objId
	 *            the objId to set
	 */
	public void setObjId(int objId) {
		this.objId = objId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the uploaddate
	 */
	public String getUploaddate() {
		return uploaddate;
	}

	/**
	 * @param uploaddate
	 *            the uploaddate to set
	 */
	public void setUploaddate(String uploaddate) {
		this.uploaddate = uploaddate;
	}

	/**
	 * @return the stateCode
	 */
	public int getStateCode() {
		return stateCode;
	}

	/**
	 * @param stateCode
	 *            the stateCode to set
	 */
	public void setStateCode(int stateCode) {
		this.stateCode = stateCode;
	}

	/**
	 * @return the imageUri
	 */
	public String getImageUri() {
		return imageUri;
	}

	/**
	 * @param imageUri
	 *            the imageUri to set
	 */
	public void setImageUri(String imageUri) {
		this.imageUri = imageUri;
	}

	/**
	 * @return the uploadId
	 */
	public int getUploadId() {
		return uploadId;
	}

	/**
	 * @param uploadId
	 *            the uploadId to set
	 */
	public void setUploadId(int uploadId) {
		this.uploadId = uploadId;
	}

}
