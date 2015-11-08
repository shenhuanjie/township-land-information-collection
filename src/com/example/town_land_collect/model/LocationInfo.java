package com.example.town_land_collect.model;

import java.io.Serializable;

import org.litepal.crud.DataSupport;

public class LocationInfo extends DataSupport implements Serializable {
	/**
	 * ����λ����Ϣ
	 */
	private static final long serialVersionUID = 1L;

	/** ������Ϣ **/
	private int id;
	private double lat;// ����
	private double lon;// γ��
	private String name;// ��ǵ�����
	private String mark;// ��ע
	private String state;// �ϴ�״̬
	private String date;// ����ʱ��
	private String uploaddate;// �ϴ�ʱ��
	private String timeconsuming;// �ϴ���ʱ
	private String attachment;// ����(ͼƬ)����

	/** ������Ϣ **/
	private int collectionType;// �ɼ�����
	private String collectionTableName;// ������
	private int collectionMainType;// �ɼ�����
	private int collectionId;// �ɼ���¼ID
	private int stateCode;// �ϴ�״̬��0:δͬ����1:��ͬ����2:��ʧЧ��
	private int imageStateCode;// ͼƬ�ϴ�״̬��0:��ͬ����1:��ͬ����2:��ʧЧ��
	private String imageUri;// ͼƬ·��(SD��)
	private int uploadId;// ��¼����ID

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
	 * �ɼ�����
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
	 * �ϴ�״̬��0:δͬ����1:��ͬ����2:��ʧЧ��
	 * 
	 * @param stateCode
	 *            the stateCode to set
	 */
	public void setStateCode(int stateCode) {
		this.stateCode = stateCode;
	}

}
