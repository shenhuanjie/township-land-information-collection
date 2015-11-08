package com.example.town_land_collect.model;

import java.io.Serializable;

import org.litepal.crud.DataSupport;

import android.R.integer;

public class AttachmentEntity extends DataSupport implements Serializable {
	/**
	 * ������Ϣ
	 */
	private static final long serialVersionUID = 1L;

	/** ������Ϣ **/
	private int id;// ����ID
	private int objId;// ����ID
	private String name;// ����
	private String date;// ����ʱ��
	private String uploaddate;// �ϴ�ʱ��
	private int stateCode;// �ϴ�״̬��0:δ�ϴ���1:���ϴ���2:���ϴ���3:�ϴ�ʧ�ܣ�
	private String imageUri;// ͼƬ·��(SD��)
	private int uploadId;// ��¼����ID

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
