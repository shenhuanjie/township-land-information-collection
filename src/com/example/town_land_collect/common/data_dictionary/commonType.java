/**
 * 
 */
package com.example.town_land_collect.common.data_dictionary;

/**
 * @Title dataDicType.java
 * @Package com.example.town_land_collect.common
 * @Description TODO(��һ�仰�������ļ���ʲô)
 * @author Shen.dev
 * @date 2015-10-16 ����10:14:29
 * @version V1.0
 */
public enum commonType {
	APPRAISAL("������׼", "appraisal"), 
	DEPARTMENT("����", "department"),
	USER("��Ա", "user"), 
	COMMUNITY("����", "community"), 
	COMPONENTTYPE("��������", "componentType"),
	ROAD("��·", "road"), 
	COMMON("��������", "commonType");

	private String name;
	private String val;

	private commonType(String name, String val) {
		this.name = name;
		this.val = val;
	}

	public String getName() {
		return this.name;
	}

	public String getVal() {
		return this.val;
	}
}
