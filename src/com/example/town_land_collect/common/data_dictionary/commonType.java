/**
 * 
 */
package com.example.town_land_collect.common.data_dictionary;

/**
 * @Title dataDicType.java
 * @Package com.example.town_land_collect.common
 * @Description TODO(用一句话描述该文件做什么)
 * @author Shen.dev
 * @date 2015-10-16 上午10:14:29
 * @version V1.0
 */
public enum commonType {
	APPRAISAL("考评标准", "appraisal"), 
	DEPARTMENT("部门", "department"),
	USER("人员", "user"), 
	COMMUNITY("社区", "community"), 
	COMPONENTTYPE("部件类型", "componentType"),
	ROAD("道路", "road"), 
	COMMON("公共数据", "commonType");

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
