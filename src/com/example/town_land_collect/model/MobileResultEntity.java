package com.example.town_land_collect.model;

/**
 * ���䷵��ͷ
 */
public class MobileResultEntity<T> {
	// ������룺����1������0
	private Integer ErrorCode;
	// ��Ϣ
	private String Msg;
	// ����
	private T data;
	// ����
	private Long total;
	// ������¼Id
	private Integer RecordId;

	/**
	 * @return the recordId
	 */
	public Integer getRecordId() {
		return RecordId;
	}

	/**
	 * @param recordId
	 *            the recordId to set
	 */
	public void setRecordId(Integer recordId) {
		RecordId = recordId;
	}

	public Integer getErrorCode() {
		return ErrorCode;
	}

	public void setErrorCode(Integer errorCode) {
		ErrorCode = errorCode;
	}

	public String getMsg() {
		return Msg;
	}

	public void setMsg(String msg) {
		Msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

}
