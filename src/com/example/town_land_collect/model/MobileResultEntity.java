package com.example.town_land_collect.model;

/**
 * 传输返回头
 */
public class MobileResultEntity<T> {
	// 错误代码：正常1；错误0
	private Integer ErrorCode;
	// 信息
	private String Msg;
	// 数据
	private T data;
	// 总数
	private Long total;
	// 操作记录Id
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
