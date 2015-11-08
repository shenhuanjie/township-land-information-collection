package com.example.town_land_collect.model;

import java.io.Serializable;

import android.widget.TextView;

import com.example.town_land_collect.R;

public class Task_Introduce implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int task_Id;
	private String task_Name;
	private String task_Time;
	private String task_State;
	private String task_UploadTime;
	private String task_TimeConsuming;
	private String task_Attachment;

	public int getTask_Id() {
		return task_Id;
	}

	public void setTask_Id(int task_Id) {
		this.task_Id = task_Id;
	}

	public String getTask_Name() {
		return task_Name;
	}

	public void setTask_Name(String task_Name) {
		this.task_Name = task_Name;
	}

	public String getTask_Time() {
		return task_Time;
	}

	public void setTask_Time(String task_Time) {
		this.task_Time = task_Time;
	}

	public String getTask_State() {
		return task_State;
	}

	public void setTask_State(String task_State) {
		this.task_State = task_State;
	}


	/**
	 * @return the task_UploadTime
	 */
	public String getTask_UploadTime() {
		return task_UploadTime;
	}

	/**
	 * @param task_UploadTime the task_UploadTime to set
	 */
	public void setTask_UploadTime(String task_UploadTime) {
		this.task_UploadTime = task_UploadTime;
	}

	/**
	 * @return the task_TimeConsuming
	 */
	public String getTask_TimeConsuming() {
		return task_TimeConsuming;
	}

	/**
	 * @param task_TimeConsuming
	 *            the task_TimeConsuming to set
	 */
	public void setTask_TimeConsuming(String task_TimeConsuming) {
		this.task_TimeConsuming = task_TimeConsuming;
	}

	/**
	 * @return the task_Attachment
	 */
	public String getTask_Attachment() {
		return task_Attachment;
	}

	/**
	 * @param task_Attachment
	 *            the task_Attachment to set
	 */
	public void setTask_Attachment(String task_Attachment) {
		this.task_Attachment = task_Attachment;
	}

}
