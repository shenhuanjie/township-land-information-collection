package com.example.town_land_collect.model;

import java.io.Serializable;

public class New_Introduce implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ID;
	private String TheName;
	private String CreateTime;
	private String Active;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getTheName() {
		return TheName;
	}
	public void setTheName(String theName) {
		TheName = theName;
	}
	public String getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}
	public String getActive() {
		return Active;
	}
	public void setActive(String active) {
		Active = active;
	}
	
}
