package com.example.town_land_collect.model.market_business;

import java.io.Serializable;

import org.litepal.crud.DataSupport;

/**
 * 
 * @Title ModelCollectionMarketBusinessTransfer.java
 * @Package com.example.town_land_collect.model.market_business
 * @Description 土地使用权转让交易信息
 * @author Shen.dev
 * @date 2015-10-15 下午12:59:54
 * @version V1.0
 */
public class ModelCollectionMarketBusinessTransfer extends DataSupport implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 基础信息 **/
	private int ID;// 标记号
	private String THENAME;// 记录名称
	private String THECODE;// 记录代码
	private String TDSYZ;// 土地所有者
	private String TDZSH;// 土地证书号
	private String TDZL;// 土地坐落
	private String QSXZ;// 权属性质
	
	/** 土地使用权转让交易信息 **/
	private String ZRF;// 转让方
	private String SRF;// 受让方
	private String ZRSJ;// 转让时间
	private String ZRFS;// 转让方式
	private String ZRMJ;// 土地转让面积
	private String ZRQYT;// 转让前用途
	private String ZRHYT;// 转让后用途
	private String TDSYNQ;// 土地剩余使用年期
	private String ZRDJ;// 土地转让单价
	private String ZRZJ;// 土地转让总价

	/** 其他信息 **/
	private String RJL;// 宗地容积率
	private String HXWKFSP;// 红线外开发水平
	private String HXNKFSP;// 红线内开发水平
	private String TDJB;// 所在土地级别
	private String DJQD;// 所在地价区段
	private String XZQDM;// 行政区代码

	/** 位置信息 **/
	private String X;// X坐标
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
	private int INDEX_ZRFS;// 转让方式
	private int INDEX_ZRQYT;// 转让前用途
	private int INDEX_ZRHYT;// 转让后用途

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
	 * @return the zRF
	 */
	public String getZRF() {
		return ZRF;
	}

	/**
	 * @param zRF
	 *            the zRF to set
	 */
	public void setZRF(String zRF) {
		ZRF = zRF;
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
	 * @return the zRSJ
	 */
	public String getZRSJ() {
		return ZRSJ;
	}

	/**
	 * @param zRSJ
	 *            the zRSJ to set
	 */
	public void setZRSJ(String zRSJ) {
		ZRSJ = zRSJ;
	}

	/**
	 * @return the zRFS
	 */
	public String getZRFS() {
		return ZRFS;
	}

	/**
	 * @param zRFS
	 *            the zRFS to set
	 */
	public void setZRFS(String zRFS) {
		ZRFS = zRFS;
	}

	/**
	 * @return the zRMJ
	 */
	public String getZRMJ() {
		return ZRMJ;
	}

	/**
	 * @param zRMJ
	 *            the zRMJ to set
	 */
	public void setZRMJ(String zRMJ) {
		ZRMJ = zRMJ;
	}

	/**
	 * @return the zRQYT
	 */
	public String getZRQYT() {
		return ZRQYT;
	}

	/**
	 * @param zRQYT
	 *            the zRQYT to set
	 */
	public void setZRQYT(String zRQYT) {
		ZRQYT = zRQYT;
	}

	/**
	 * @return the zRHYT
	 */
	public String getZRHYT() {
		return ZRHYT;
	}

	/**
	 * @param zRHYT
	 *            the zRHYT to set
	 */
	public void setZRHYT(String zRHYT) {
		ZRHYT = zRHYT;
	}

	/**
	 * @return the tDSYNQ
	 */
	public String getTDSYNQ() {
		return TDSYNQ;
	}

	/**
	 * @param tDSYNQ
	 *            the tDSYNQ to set
	 */
	public void setTDSYNQ(String tDSYNQ) {
		TDSYNQ = tDSYNQ;
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
	 * @return the zRDJ
	 */
	public String getZRDJ() {
		return ZRDJ;
	}

	/**
	 * @param zRDJ
	 *            the zRDJ to set
	 */
	public void setZRDJ(String zRDJ) {
		ZRDJ = zRDJ;
	}

	/**
	 * @return the zRZJ
	 */
	public String getZRZJ() {
		return ZRZJ;
	}

	/**
	 * @param zRZJ
	 *            the zRZJ to set
	 */
	public void setZRZJ(String zRZJ) {
		ZRZJ = zRZJ;
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

	public int getINDEX_ZRFS() {
		return INDEX_ZRFS;
	}

	public void setINDEX_ZRFS(int iNDEX_ZRFS) {
		INDEX_ZRFS = iNDEX_ZRFS;
	}

	public int getINDEX_ZRQYT() {
		return INDEX_ZRQYT;
	}

	public void setINDEX_ZRQYT(int iNDEX_ZRQYT) {
		INDEX_ZRQYT = iNDEX_ZRQYT;
	}

	public int getINDEX_ZRHYT() {
		return INDEX_ZRHYT;
	}

	public void setINDEX_ZRHYT(int iNDEX_ZRHYT) {
		INDEX_ZRHYT = iNDEX_ZRHYT;
	}

}
