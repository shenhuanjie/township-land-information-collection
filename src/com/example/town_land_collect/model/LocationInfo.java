package com.example.town_land_collect.model;

import java.io.Serializable;

import org.litepal.crud.DataSupport;

public class LocationInfo extends DataSupport implements Serializable {
	/**
	 * 本地位置信息
	 */
	private static final long serialVersionUID = 1L;

	/** 基本信息 **/
	private int id;
	private double lat;// 经度
	private double lon;// 纬度
	private String name;// 标记点名称
	private String mark;// 备注
	private String state;// 上传状态
	private String date;// 创建时间
	private String uploaddate;// 上传时间
	private String timeconsuming;// 上传耗时
	private String attachment;// 附件(图片)数量

	/** 关联信息 **/
	private int collectionType;// 采集类型
	private String collectionTableName;// 表单名称
	private int collectionMainType;// 采集类型
	private int collectionId;// 采集记录ID
	private int stateCode;// 上传状态（0:未同步，1:已同步，2:已失效）
	private int imageStateCode;// 图片上传状态（0:待同步，1:已同步，2:已失效）
	private String imageUri;// 图片路径(SD卡)
	private int uploadId;// 记录对象ID

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUploadId() {
		return uploadId;
	}

	public void setUploadId(int uploadId) {
		this.uploadId = uploadId;
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
	 * @return the timeconsuming
	 */
	public String getTimeconsuming() {
		return timeconsuming;
	}

	/**
	 * @param timeconsuming
	 *            the timeconsuming to set
	 */
	public void setTimeconsuming(String timeconsuming) {
		this.timeconsuming = timeconsuming;
	}

	/**
	 * @return the attachment
	 */
	public String getAttachment() {
		return attachment;
	}

	/**
	 * @param attachment
	 *            the attachment to set
	 */
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	/**
	 * @return the imageUri
	 */
	public String getImageUri() {
		return imageUri;
	}

	public int getImageStateCode() {
		return imageStateCode;
	}

	public void setImageStateCode(int imageStateCode) {
		this.imageStateCode = imageStateCode;
	}

	/**
	 * @param imageUri
	 *            the imageUri to set
	 */
	public void setImageUri(String imageUri) {
		this.imageUri = imageUri;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getCollectionMainType() {
		return collectionMainType;
	}

	public void setCollectionMainType(int collectionMainType) {
		this.collectionMainType = collectionMainType;
	}

	/**
	 * @return the collectionType
	 */
	public int getCollectionType() {
		return collectionType;
	}

	/**
	 * 采集类型
	 * 
	 * @param collectionType
	 *            the collectionType to set
	 */
	public void setCollectionType(int collectionType) {
		this.collectionType = collectionType;
	}

	/**
	 * @return the collectionId
	 */
	public int getCollectionId() {
		return collectionId;
	}

	/**
	 * @param collectionId
	 *            the collectionId to set
	 */
	public void setCollectionId(int collectionId) {
		this.collectionId = collectionId;
	}

	public String getCollectionTableName() {
		return collectionTableName;
	}

	public void setCollectionTableName(String collectionTableName) {
		this.collectionTableName = collectionTableName;
	}

	/**
	 * @return the stateCode
	 */
	public int getStateCode() {
		return stateCode;
	}

	/**
	 * 上传状态（0:未同步，1:已同步，2:已失效）
	 * 
	 * @param stateCode
	 *            the stateCode to set
	 */
	public void setStateCode(int stateCode) {
		this.stateCode = stateCode;
	}

}
