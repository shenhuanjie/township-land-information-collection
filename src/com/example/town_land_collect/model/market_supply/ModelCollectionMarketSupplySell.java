/**
 * 
 */
package com.example.town_land_collect.model.market_supply;

import java.io.Serializable;

import org.litepal.crud.DataSupport;

/**
 * @Title ModelCollectionMarketSupplySell.java
 * @Package com.example.town_land_collect.model.market_supply
 * @Description 土地使用权出让供应信息
 * @author Shen.dev
 * @date 2015-10-14 下午6:04:24
 * @version V1.0
 */
public class ModelCollectionMarketSupplySell extends DataSupport implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 基本信息 **/
	private int ID;// 标记号
	private String THENAME;// 记录名称
	private String THECODE;// 记录代码

	/** 土地使用权出让供应信息 **/
	private String TDSYZ;// 土地所有者
	private String ZDBH;// 宗地编号
	private String TDZL;// 土地坐落
	private String QSXZ;// 权属性质
	private String NCRSJ;// 拟出让时间
	private String CRFS;// 拟出让方式
	private String NCRNQ;// 拟出让年期
	private String SFZKF;// 是否再开发
	private String SFLYD;// 是否留用地
	private String GHTDMJ;// 规划红线范围土地面积
	private String NDZTDMJ;// 拟代征土地面积
	private String CRQYT;// 出让前用途
	private String CRHGHYT;// 出让后规划用途
	private String NCRDJ;// 拟单位面积土地出让价
	private String NCRZJ;// 拟土地出让总价

	/** 其他信息 **/
	private String GHRJL;// 规划宗地容积率
	private String GHHXWKFSP;// 规划红线外开发水平
	private String GHHXNKFSP;// 规划红线内开发水平
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

	/** 基础信息.控件 **/
	private int index_qsxz = 0;// 权属性质

	/** 土地使用权出让供应信息 **/
	private int index_crfs = 0;// 拟出让方式
	private int index_sfzkf = 0;// 是否再开发
	private int index_sflyd = 0;// 是否留用地
	private int index_crqyt = 0;// 出让前用途
	private int index_crhghyt = 0;// 出让后规划用途
	/** 其他信息.控件 **/
	private int index_ghhxwkfsp = 0;// 红线外开发水平
	private int index_ghhxnkfsp = 0;// 红线内开发水平
	private int index_tdjb = 0;// 所在土地级别

	/**
	 * @return the index_qsxz
	 */
	public int getIndex_qsxz() {
		return index_qsxz;
	}

	/**
	 * @param index_qsxz
	 *            the index_qsxz to set
	 */
	public void setIndex_qsxz(int index_qsxz) {
		this.index_qsxz = index_qsxz;
	}

	/**
	 * @return the index_crfs
	 */
	public int getIndex_crfs() {
		return index_crfs;
	}

	/**
	 * @param index_crfs
	 *            the index_crfs to set
	 */
	public void setIndex_crfs(int index_crfs) {
		this.index_crfs = index_crfs;
	}

	/**
	 * @return the index_sfzkf
	 */
	public int getIndex_sfzkf() {
		return index_sfzkf;
	}

	/**
	 * @param index_sfzkf
	 *            the index_sfzkf to set
	 */
	public void setIndex_sfzkf(int index_sfzkf) {
		this.index_sfzkf = index_sfzkf;
	}

	/**
	 * @return the index_sflyd
	 */
	public int getIndex_sflyd() {
		return index_sflyd;
	}

	/**
	 * @param index_sflyd
	 *            the index_sflyd to set
	 */
	public void setIndex_sflyd(int index_sflyd) {
		this.index_sflyd = index_sflyd;
	}

	/**
	 * @return the index_crqyt
	 */
	public int getIndex_crqyt() {
		return index_crqyt;
	}

	/**
	 * @param index_crqyt
	 *            the index_crqyt to set
	 */
	public void setIndex_crqyt(int index_crqyt) {
		this.index_crqyt = index_crqyt;
	}

	/**
	 * @return the index_crhghyt
	 */
	public int getIndex_crhghyt() {
		return index_crhghyt;
	}

	/**
	 * @param index_crhghyt
	 *            the index_crhghyt to set
	 */
	public void setIndex_crhghyt(int index_crhghyt) {
		this.index_crhghyt = index_crhghyt;
	}

	/**
	 * @return the index_ghhxwkfsp
	 */
	public int getIndex_ghhxwkfsp() {
		return index_ghhxwkfsp;
	}

	/**
	 * @param index_ghhxwkfsp
	 *            the index_ghhxwkfsp to set
	 */
	public void setIndex_ghhxwkfsp(int index_ghhxwkfsp) {
		this.index_ghhxwkfsp = index_ghhxwkfsp;
	}

	/**
	 * @return the index_ghhxnkfsp
	 */
	public int getIndex_ghhxnkfsp() {
		return index_ghhxnkfsp;
	}

	/**
	 * @param index_ghhxnkfsp
	 *            the index_ghhxnkfsp to set
	 */
	public void setIndex_ghhxnkfsp(int index_ghhxnkfsp) {
		this.index_ghhxnkfsp = index_ghhxnkfsp;
	}

	/**
	 * @return the index_tdjb
	 */
	public int getIndex_tdjb() {
		return index_tdjb;
	}

	/**
	 * @param index_tdjb
	 *            the index_tdjb to set
	 */
	public void setIndex_tdjb(int index_tdjb) {
		this.index_tdjb = index_tdjb;
	}

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
	 * @return the zDBH
	 */
	public String getZDBH() {
		return ZDBH;
	}

	/**
	 * @param zDBH
	 *            the zDBH to set
	 */
	public void setZDBH(String zDBH) {
		ZDBH = zDBH;
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
	 * @return the nCRSJ
	 */
	public String getNCRSJ() {
		return NCRSJ;
	}

	/**
	 * @param nCRSJ
	 *            the nCRSJ to set
	 */
	public void setNCRSJ(String nCRSJ) {
		NCRSJ = nCRSJ;
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
	 * @return the nCRNQ
	 */
	public String getNCRNQ() {
		return NCRNQ;
	}

	/**
	 * @param nCRNQ
	 *            the nCRNQ to set
	 */
	public void setNCRNQ(String nCRNQ) {
		NCRNQ = nCRNQ;
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
	 * @return the nDZTDMJ
	 */
	public String getNDZTDMJ() {
		return NDZTDMJ;
	}

	/**
	 * @param nDZTDMJ
	 *            the nDZTDMJ to set
	 */
	public void setNDZTDMJ(String nDZTDMJ) {
		NDZTDMJ = nDZTDMJ;
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
	 * @return the cRHGHYT
	 */
	public String getCRHGHYT() {
		return CRHGHYT;
	}

	/**
	 * @param cRHGHYT
	 *            the cRHGHYT to set
	 */
	public void setCRHGHYT(String cRHGHYT) {
		CRHGHYT = cRHGHYT;
	}

	/**
	 * @return the gHRJL
	 */
	public String getGHRJL() {
		return GHRJL;
	}

	/**
	 * @param gHRJL
	 *            the gHRJL to set
	 */
	public void setGHRJL(String gHRJL) {
		GHRJL = gHRJL;
	}

	/**
	 * @return the gHHXWKFSP
	 */
	public String getGHHXWKFSP() {
		return GHHXWKFSP;
	}

	/**
	 * @param gHHXWKFSP
	 *            the gHHXWKFSP to set
	 */
	public void setGHHXWKFSP(String gHHXWKFSP) {
		GHHXWKFSP = gHHXWKFSP;
	}

	/**
	 * @return the gHHXNKFSP
	 */
	public String getGHHXNKFSP() {
		return GHHXNKFSP;
	}

	/**
	 * @param gHHXNKFSP
	 *            the gHHXNKFSP to set
	 */
	public void setGHHXNKFSP(String gHHXNKFSP) {
		GHHXNKFSP = gHHXNKFSP;
	}

	/**
	 * @return the nCRDJ
	 */
	public String getNCRDJ() {
		return NCRDJ;
	}

	/**
	 * @param nCRDJ
	 *            the nCRDJ to set
	 */
	public void setNCRDJ(String nCRDJ) {
		NCRDJ = nCRDJ;
	}

	/**
	 * @return the nCRZJ
	 */
	public String getNCRZJ() {
		return NCRZJ;
	}

	/**
	 * @param nCRZJ
	 *            the nCRZJ to set
	 */
	public void setNCRZJ(String nCRZJ) {
		NCRZJ = nCRZJ;
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

}
