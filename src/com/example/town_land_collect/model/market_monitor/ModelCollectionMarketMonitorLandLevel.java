/**
 * 
 */
package com.example.town_land_collect.model.market_monitor;

import java.io.Serializable;

import org.litepal.crud.DataSupport;

/**
 * @Title ModelCollectionMarketMonitor_LandLevel.java
 * @Package com.example.town_land_collect.model.market_monitor
 * @Description 土地级别信息
 * @author Shen.dev
 * @date 2015-10-14 下午6:01:45
 * @version V1.0
 */
public class ModelCollectionMarketMonitorLandLevel extends DataSupport implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 基本信息 **/
	private int ID;// 标记号
	private String THENAME;// 记录名称
	private String THECODE;// 记录代码

	/** 土地级别信息 **/
	private String BSM;// 标识码
	private String XZQDM;// 行政区代码
	private String QSXZ;// 权属性质
	private String TDJB;// 土地级别
	private String JZR;// 评估基准日
	private String SDQL;// 设定权利状况
	private String SDNQ;// 设定年期
	private String SDRJL;// 设定容积率
	private String SDKFSP;// 设定开发水平
	private String DMJZDJ;// 地面基准地价
	private String LMJZDJ;// 楼面基准地价
	private String REMARK;// 备注

	/** 系统信息 **/
	private String INPUTUSERID;// 创建用户
	private String CREATETIME;// 创建时间
	private String LASTUPDATEUSERID;// 修改用户
	private String UPDATETIME;// 修改时间
	private String ISDELETE;// 是否删除
	private String SHOWSEQ;// 显示顺序
	
	/** 土地级别信息 **/
	private int index_qsxz = 0;// 权属性质
	/**
	 * @return the index_qsxz
	 */
	public int getIndex_qsxz() {
		return index_qsxz;
	}

	/**
	 * @param index_qsxz the index_qsxz to set
	 */
	public void setIndex_qsxz(int index_qsxz) {
		this.index_qsxz = index_qsxz;
	}

	/**
	 * @return the index_tdjb
	 */
	public int getIndex_tdjb() {
		return index_tdjb;
	}

	/**
	 * @param index_tdjb the index_tdjb to set
	 */
	public void setIndex_tdjb(int index_tdjb) {
		this.index_tdjb = index_tdjb;
	}

	/**
	 * @return the index_sdkfsp
	 */
	public int getIndex_sdkfsp() {
		return index_sdkfsp;
	}

	/**
	 * @param index_sdkfsp the index_sdkfsp to set
	 */
	public void setIndex_sdkfsp(int index_sdkfsp) {
		this.index_sdkfsp = index_sdkfsp;
	}

	private int index_tdjb;// 土地级别
	private int index_sdkfsp;// 设定开发水平

	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}

	/**
	 * @param iD
	 *            the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * @return the tHENAME
	 */
	public String getTHENAME() {
		return THENAME;
	}

	/**
	 * @param tHENAME
	 *            the tHENAME to set
	 */
	public void setTHENAME(String tHENAME) {
		THENAME = tHENAME;
	}

	/**
	 * @return the tHECODE
	 */
	public String getTHECODE() {
		return THECODE;
	}

	/**
	 * @param tHECODE
	 *            the tHECODE to set
	 */
	public void setTHECODE(String tHECODE) {
		THECODE = tHECODE;
	}

	/**
	 * @return the bSM
	 */
	public String getBSM() {
		return BSM;
	}

	/**
	 * @param bSM
	 *            the bSM to set
	 */
	public void setBSM(String bSM) {
		BSM = bSM;
	}

	/**
	 * @return the xZQDM
	 */
	public String getXZQDM() {
		return XZQDM;
	}

	/**
	 * @param xZQDM
	 *            the xZQDM to set
	 */
	public void setXZQDM(String xZQDM) {
		XZQDM = xZQDM;
	}

	/**
	 * @return the qSXZ
	 */
	public String getQSXZ() {
		return QSXZ;
	}

	/**
	 * @param qSXZ
	 *            the qSXZ to set
	 */
	public void setQSXZ(String qSXZ) {
		QSXZ = qSXZ;
	}

	/**
	 * @return the tDJB
	 */
	public String getTDJB() {
		return TDJB;
	}

	/**
	 * @param tDJB
	 *            the tDJB to set
	 */
	public void setTDJB(String tDJB) {
		TDJB = tDJB;
	}

	/**
	 * @return the jZR
	 */
	public String getJZR() {
		return JZR;
	}

	/**
	 * @param jZR
	 *            the jZR to set
	 */
	public void setJZR(String jZR) {
		JZR = jZR;
	}

	/**
	 * @return the sDQL
	 */
	public String getSDQL() {
		return SDQL;
	}

	/**
	 * @param sDQL
	 *            the sDQL to set
	 */
	public void setSDQL(String sDQL) {
		SDQL = sDQL;
	}

	/**
	 * @return the sDNQ
	 */
	public String getSDNQ() {
		return SDNQ;
	}

	/**
	 * @param sDNQ
	 *            the sDNQ to set
	 */
	public void setSDNQ(String sDNQ) {
		SDNQ = sDNQ;
	}

	/**
	 * @return the sDRJL
	 */
	public String getSDRJL() {
		return SDRJL;
	}

	/**
	 * @param sDRJL
	 *            the sDRJL to set
	 */
	public void setSDRJL(String sDRJL) {
		SDRJL = sDRJL;
	}

	/**
	 * @return the sDKFSP
	 */
	public String getSDKFSP() {
		return SDKFSP;
	}

	/**
	 * @param sDKFSP
	 *            the sDKFSP to set
	 */
	public void setSDKFSP(String sDKFSP) {
		SDKFSP = sDKFSP;
	}

	/**
	 * @return the dMJZDJ
	 */
	public String getDMJZDJ() {
		return DMJZDJ;
	}

	/**
	 * @param dMJZDJ
	 *            the dMJZDJ to set
	 */
	public void setDMJZDJ(String dMJZDJ) {
		DMJZDJ = dMJZDJ;
	}

	/**
	 * @return the lMJZDJ
	 */
	public String getLMJZDJ() {
		return LMJZDJ;
	}

	/**
	 * @param lMJZDJ
	 *            the lMJZDJ to set
	 */
	public void setLMJZDJ(String lMJZDJ) {
		LMJZDJ = lMJZDJ;
	}

	/**
	 * @return the rEMARK
	 */
	public String getREMARK() {
		return REMARK;
	}

	/**
	 * @param rEMARK
	 *            the rEMARK to set
	 */
	public void setREMARK(String rEMARK) {
		REMARK = rEMARK;
	}

	/**
	 * @return the iNPUTUSERID
	 */
	public String getINPUTUSERID() {
		return INPUTUSERID;
	}

	/**
	 * @param iNPUTUSERID
	 *            the iNPUTUSERID to set
	 */
	public void setINPUTUSERID(String iNPUTUSERID) {
		INPUTUSERID = iNPUTUSERID;
	}

	/**
	 * @return the cREATETIME
	 */
	public String getCREATETIME() {
		return CREATETIME;
	}

	/**
	 * @param cREATETIME
	 *            the cREATETIME to set
	 */
	public void setCREATETIME(String cREATETIME) {
		CREATETIME = cREATETIME;
	}

	/**
	 * @return the lASTUPDATEUSERID
	 */
	public String getLASTUPDATEUSERID() {
		return LASTUPDATEUSERID;
	}

	/**
	 * @param lASTUPDATEUSERID
	 *            the lASTUPDATEUSERID to set
	 */
	public void setLASTUPDATEUSERID(String lASTUPDATEUSERID) {
		LASTUPDATEUSERID = lASTUPDATEUSERID;
	}

	/**
	 * @return the uPDATETIME
	 */
	public String getUPDATETIME() {
		return UPDATETIME;
	}

	/**
	 * @param uPDATETIME
	 *            the uPDATETIME to set
	 */
	public void setUPDATETIME(String uPDATETIME) {
		UPDATETIME = uPDATETIME;
	}

	/**
	 * @return the iSDELETE
	 */
	public String getISDELETE() {
		return ISDELETE;
	}

	/**
	 * @param iSDELETE
	 *            the iSDELETE to set
	 */
	public void setISDELETE(String iSDELETE) {
		ISDELETE = iSDELETE;
	}

	/**
	 * @return the sHOWSEQ
	 */
	public String getSHOWSEQ() {
		return SHOWSEQ;
	}

	/**
	 * @param sHOWSEQ
	 *            the sHOWSEQ to set
	 */
	public void setSHOWSEQ(String sHOWSEQ) {
		SHOWSEQ = sHOWSEQ;
	}

}
