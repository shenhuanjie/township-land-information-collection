package com.example.town_land_collect.model.market_business;

import java.io.Serializable;

import org.litepal.crud.DataSupport;

/**
 * 
 * @Title ModelCollectionMarketBusinessSell.java
 * @Package com.example.town_land_collect.model.market_business
 * @Description 土地使用权出让交易信息
 * @author Shen.dev
 * @date 2015-10-15 下午12:46:54
 * @version V1.0
 */
public class ModelCollectionMarketBusinessSell extends DataSupport implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 基础信息 **/
	private int id;// 标记号
	private String THENAME;// 记录名称
	private String THECODE;// 记录代码
	private String TDSYZ;// 土地所有者
	private String TDZSH;// 土地证书号
	private String TDZL;// 土地坐落
	private String QSXZ;// 权属性质

	/** 土地使用权出让交易信息 **/
	private String CRSJ;// 出让时间
	private String SRF;// 受让方
	private String CRFS;// 出让方式
	private String SFZKF;// 是否再开发
	private String SFLYD;// 是否留用地
	private String GHTDMJ;// 规划红线范围土地面积
	private String DZTDMJ;// 代征土地面积
	private String SJCRMJ;// 实际出让面积
	private String CRQYT;// 出让前用途
	private String CRHYT;// 出让后用途
	private String CRNQ;// 出让年期
	private String CRDJ;// 单位面积土地出让价
	private String CRZJ;// 土地出让总价

	/** 其他信息 **/
	private String RJL;// 宗地容积率
	private String HXWKFSP;// 红线外开发水平
	private String HXNKFSP;// 红线内开发水平
	private String TDJB;// 所在土地级别
	private String DJQD;// 所在地价区段
	private String XZQDM;// 行政区代码

	/** 位置信息 **/
	private String X; // x坐标
	private String Y;// Y坐标
	private String ZBXT;// 坐标系统
	private String REMARK;// 备注

	/** 系统信息 **/
	private String INPUTUSERID;// 创建用户
	private String CREATETIME;// 创建时间
	private String LASTUPDATEUSERID;// 修改用户
	private String UPDATETIME;// 修改时间
	private String ISDELETE;// 是否删除
	private String SHOWSEQ;// 显示顺序

	/** 额外.下拉字段 **/
	private int INDEX_QSXZ;
	private int INDEX_HXWKFSP;
	private int INDEX_HXNKFSP;
	private int INDEX_TDJB;
	private int INDEX_CRFS;// 出让方式
	private int INDEX_CRQYT;
	private int INDEX_CRHYT;
	private int INDEX_SFZKF;
	private int INDEX_SFLYD;

	public int getINDEX_SFZKF() {
		return INDEX_SFZKF;
	}

	public void setINDEX_SFZKF(int iNDEX_SFZKF) {
		INDEX_SFZKF = iNDEX_SFZKF;
	}

	public int getINDEX_SFLYD() {
		return INDEX_SFLYD;
	}

	public void setINDEX_SFLYD(int iNDEX_SFLYD) {
		INDEX_SFLYD = iNDEX_SFLYD;
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
	 * @return the tDSYZ
	 */
	public String getTDSYZ() {
		return TDSYZ;
	}

	/**
	 * @param tDSYZ
	 *            the tDSYZ to set
	 */
	public void setTDSYZ(String tDSYZ) {
		TDSYZ = tDSYZ;
	}

	/**
	 * @return the tDZSH
	 */
	public String getTDZSH() {
		return TDZSH;
	}

	/**
	 * @param tDZSH
	 *            the tDZSH to set
	 */
	public void setTDZSH(String tDZSH) {
		TDZSH = tDZSH;
	}

	/**
	 * @return the tDZL
	 */
	public String getTDZL() {
		return TDZL;
	}

	/**
	 * @param tDZL
	 *            the tDZL to set
	 */
	public void setTDZL(String tDZL) {
		TDZL = tDZL;
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
	 * @return the cRSJ
	 */
	public String getCRSJ() {
		return CRSJ;
	}

	/**
	 * @param cRSJ
	 *            the cRSJ to set
	 */
	public void setCRSJ(String cRSJ) {
		CRSJ = cRSJ;
	}

	/**
	 * @return the sRF
	 */
	public String getSRF() {
		return SRF;
	}

	/**
	 * @param sRF
	 *            the sRF to set
	 */
	public void setSRF(String sRF) {
		SRF = sRF;
	}

	/**
	 * @return the cRFS
	 */
	public String getCRFS() {
		return CRFS;
	}

	/**
	 * @param cRFS
	 *            the cRFS to set
	 */
	public void setCRFS(String cRFS) {
		CRFS = cRFS;
	}

	/**
	 * @return the sFZKF
	 */
	public String getSFZKF() {
		return SFZKF;
	}

	/**
	 * @param sFZKF
	 *            the sFZKF to set
	 */
	public void setSFZKF(String sFZKF) {
		SFZKF = sFZKF;
	}

	/**
	 * @return the sFLYD
	 */
	public String getSFLYD() {
		return SFLYD;
	}

	/**
	 * @param sFLYD
	 *            the sFLYD to set
	 */
	public void setSFLYD(String sFLYD) {
		SFLYD = sFLYD;
	}

	/**
	 * @return the gHTDMJ
	 */
	public String getGHTDMJ() {
		return GHTDMJ;
	}

	/**
	 * @param gHTDMJ
	 *            the gHTDMJ to set
	 */
	public void setGHTDMJ(String gHTDMJ) {
		GHTDMJ = gHTDMJ;
	}

	/**
	 * @return the dZTDMJ
	 */
	public String getDZTDMJ() {
		return DZTDMJ;
	}

	/**
	 * @param dZTDMJ
	 *            the dZTDMJ to set
	 */
	public void setDZTDMJ(String dZTDMJ) {
		DZTDMJ = dZTDMJ;
	}

	/**
	 * @return the sJCRMJ
	 */
	public String getSJCRMJ() {
		return SJCRMJ;
	}

	/**
	 * @param sJCRMJ
	 *            the sJCRMJ to set
	 */
	public void setSJCRMJ(String sJCRMJ) {
		SJCRMJ = sJCRMJ;
	}

	/**
	 * @return the cRQYT
	 */
	public String getCRQYT() {
		return CRQYT;
	}

	/**
	 * @param cRQYT
	 *            the cRQYT to set
	 */
	public void setCRQYT(String cRQYT) {
		CRQYT = cRQYT;
	}

	/**
	 * @return the cRHYT
	 */
	public String getCRHYT() {
		return CRHYT;
	}

	/**
	 * @param cRHYT
	 *            the cRHYT to set
	 */
	public void setCRHYT(String cRHYT) {
		CRHYT = cRHYT;
	}

	/**
	 * @return the cRNQ
	 */
	public String getCRNQ() {
		return CRNQ;
	}

	/**
	 * @param cRNQ
	 *            the cRNQ to set
	 */
	public void setCRNQ(String cRNQ) {
		CRNQ = cRNQ;
	}

	/**
	 * @return the rJL
	 */
	public String getRJL() {
		return RJL;
	}

	/**
	 * @param rJL
	 *            the rJL to set
	 */
	public void setRJL(String rJL) {
		RJL = rJL;
	}

	/**
	 * @return the hXWKFSP
	 */
	public String getHXWKFSP() {
		return HXWKFSP;
	}

	/**
	 * @param hXWKFSP
	 *            the hXWKFSP to set
	 */
	public void setHXWKFSP(String hXWKFSP) {
		HXWKFSP = hXWKFSP;
	}

	/**
	 * @return the hXNKFSP
	 */
	public String getHXNKFSP() {
		return HXNKFSP;
	}

	/**
	 * @param hXNKFSP
	 *            the hXNKFSP to set
	 */
	public void setHXNKFSP(String hXNKFSP) {
		HXNKFSP = hXNKFSP;
	}

	/**
	 * @return the cRDJ
	 */
	public String getCRDJ() {
		return CRDJ;
	}

	/**
	 * @param cRDJ
	 *            the cRDJ to set
	 */
	public void setCRDJ(String cRDJ) {
		CRDJ = cRDJ;
	}

	/**
	 * @return the cRZJ
	 */
	public String getCRZJ() {
		return CRZJ;
	}

	/**
	 * @param cRZJ
	 *            the cRZJ to set
	 */
	public void setCRZJ(String cRZJ) {
		CRZJ = cRZJ;
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
	 * @return the dJQD
	 */
	public String getDJQD() {
		return DJQD;
	}

	/**
	 * @param dJQD
	 *            the dJQD to set
	 */
	public void setDJQD(String dJQD) {
		DJQD = dJQD;
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
	 * @return the x
	 */
	public String getX() {
		return X;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(String x) {
		X = x;
	}

	/**
	 * @return the y
	 */
	public String getY() {
		return Y;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public void setY(String y) {
		Y = y;
	}

	/**
	 * @return the zBXT
	 */
	public String getZBXT() {
		return ZBXT;
	}

	/**
	 * @param zBXT
	 *            the zBXT to set
	 */
	public void setZBXT(String zBXT) {
		ZBXT = zBXT;
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

	/**
	 * @return the iNDEX_QSXZ
	 */
	public int getINDEX_QSXZ() {
		return INDEX_QSXZ;
	}

	/**
	 * @param iNDEX_QSXZ
	 *            the iNDEX_QSXZ to set
	 */
	public void setINDEX_QSXZ(int iNDEX_QSXZ) {
		INDEX_QSXZ = iNDEX_QSXZ;
	}

	/**
	 * @return the iNDEX_HXWKFSP
	 */
	public int getINDEX_HXWKFSP() {
		return INDEX_HXWKFSP;
	}

	/**
	 * @param iNDEX_HXWKFSP
	 *            the iNDEX_HXWKFSP to set
	 */
	public void setINDEX_HXWKFSP(int iNDEX_HXWKFSP) {
		INDEX_HXWKFSP = iNDEX_HXWKFSP;
	}

	/**
	 * @return the iNDEX_HXNKFSP
	 */
	public int getINDEX_HXNKFSP() {
		return INDEX_HXNKFSP;
	}

	/**
	 * @param iNDEX_HXNKFSP
	 *            the iNDEX_HXNKFSP to set
	 */
	public void setINDEX_HXNKFSP(int iNDEX_HXNKFSP) {
		INDEX_HXNKFSP = iNDEX_HXNKFSP;
	}

	/**
	 * @return the iNDEX_TDJB
	 */
	public int getINDEX_TDJB() {
		return INDEX_TDJB;
	}

	/**
	 * @param iNDEX_TDJB
	 *            the iNDEX_TDJB to set
	 */
	public void setINDEX_TDJB(int iNDEX_TDJB) {
		INDEX_TDJB = iNDEX_TDJB;
	}

	public int getINDEX_CRFS() {
		return INDEX_CRFS;
	}

	public void setINDEX_CRFS(int iNDEX_CRFS) {
		INDEX_CRFS = iNDEX_CRFS;
	}

	public int getINDEX_CRQYT() {
		return INDEX_CRQYT;
	}

	public void setINDEX_CRQYT(int iNDEX_CRQYT) {
		INDEX_CRQYT = iNDEX_CRQYT;
	}

	public int getINDEX_CRHYT() {
		return INDEX_CRHYT;
	}

	public void setINDEX_CRHYT(int iNDEX_CRHYT) {
		INDEX_CRHYT = iNDEX_CRHYT;
	}

}
