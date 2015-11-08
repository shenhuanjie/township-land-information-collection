/**
 * 
 */
package com.example.town_land_collect.model.market_demand;

import java.io.Serializable;

import org.litepal.crud.DataSupport;

/**
 * @Title ModelCollectionMarketDemandTransfer.java
 * @Package com.example.town_land_collect.model.market_demand
 * @Description 土地使用权转让需求信息
 * @author Shen.dev
 * @date 2015-10-14 下午6:00:35
 * @version V1.0
 */
public class ModelCollectionMarketDemandTransfer extends DataSupport implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 基本信息 **/
	private int ID;// 标记号
	private String THENAME;// 记录名称
	private String THECODE;// 记录代码

	/** 土地使用权转让需求信息 **/
	private String XQF;// 需求方
	private String XQFZTXZ;// 需求方主体性质
	private String NTDZL;// 拟土地坐落
	private String NQSXZ;// 拟权属性质
	private String XQZRSJ;// 需求转让时间
	private String XQZRFS;// 需求转让方式
	private String NXQZRMJ;// 拟需求土地转让面积
	private String XQXZTDTJ;// 需求现状土地条件
	private String ZRQYT;// 转让前用途
	private String NZRHYT;// 拟转让后用途
	private String TDSYNQ;// 土地剩余使用年期
	private String GHRJL;// 规划宗地容积率
	private String XQZRDJ;// 需求土地转让单价
	private String XQZRZJ;// 需求土地转让总价

	/**
	 * @return the xQXZTDTJ
	 */
	public String getXQXZTDTJ() {
		return XQXZTDTJ;
	}

	/**
	 * @param xQXZTDTJ
	 *            the xQXZTDTJ to set
	 */
	public void setXQXZTDTJ(String xQXZTDTJ) {
		XQXZTDTJ = xQXZTDTJ;
	}

	/** 其他信息 **/
	private String TDJB;// 所在土地级别
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

	private int index_xqfztxz;// 需求方主体性质
	private int index_nqsxz;// 拟权属性质
	private int index_xqzrfs;// 需求转让方式
	private int index_zrqyt;// 转让前用途
	private int index_nzrhyt;// 拟转让后用途
	/** 其他信息.控件 **/
	private int index_tdjb = 0;// 所在土地级别

	/**
	 * @return the index_xqfztxz
	 */
	public int getIndex_xqfztxz() {
		return index_xqfztxz;
	}

	/**
	 * @param index_xqfztxz
	 *            the index_xqfztxz to set
	 */
	public void setIndex_xqfztxz(int index_xqfztxz) {
		this.index_xqfztxz = index_xqfztxz;
	}

	/**
	 * @return the index_nqsxz
	 */
	public int getIndex_nqsxz() {
		return index_nqsxz;
	}

	/**
	 * @param index_nqsxz
	 *            the index_nqsxz to set
	 */
	public void setIndex_nqsxz(int index_nqsxz) {
		this.index_nqsxz = index_nqsxz;
	}

	/**
	 * @return the index_xqzrfs
	 */
	public int getIndex_xqzrfs() {
		return index_xqzrfs;
	}

	/**
	 * @param index_xqzrfs
	 *            the index_xqzrfs to set
	 */
	public void setIndex_xqzrfs(int index_xqzrfs) {
		this.index_xqzrfs = index_xqzrfs;
	}

	/**
	 * @return the index_zrqyt
	 */
	public int getIndex_zrqyt() {
		return index_zrqyt;
	}

	/**
	 * @param index_zrqyt
	 *            the index_zrqyt to set
	 */
	public void setIndex_zrqyt(int index_zrqyt) {
		this.index_zrqyt = index_zrqyt;
	}

	/**
	 * @return the index_nzrhyt
	 */
	public int getIndex_nzrhyt() {
		return index_nzrhyt;
	}

	/**
	 * @param index_nzrhyt
	 *            the index_nzrhyt to set
	 */
	public void setIndex_nzrhyt(int index_nzrhyt) {
		this.index_nzrhyt = index_nzrhyt;
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
	 * @return the xQF
	 */
	public String getXQF() {
		return XQF;
	}

	/**
	 * @param xQF
	 *            the xQF to set
	 */
	public void setXQF(String xQF) {
		XQF = xQF;
	}

	/**
	 * @return the xQFZTXZ
	 */
	public String getXQFZTXZ() {
		return XQFZTXZ;
	}

	/**
	 * @param xQFZTXZ
	 *            the xQFZTXZ to set
	 */
	public void setXQFZTXZ(String xQFZTXZ) {
		XQFZTXZ = xQFZTXZ;
	}

	/**
	 * @return the nTDZL
	 */
	public String getNTDZL() {
		return NTDZL;
	}

	/**
	 * @param nTDZL
	 *            the nTDZL to set
	 */
	public void setNTDZL(String nTDZL) {
		NTDZL = nTDZL;
	}

	/**
	 * @return the nQSXZ
	 */
	public String getNQSXZ() {
		return NQSXZ;
	}

	/**
	 * @param nQSXZ
	 *            the nQSXZ to set
	 */
	public void setNQSXZ(String nQSXZ) {
		NQSXZ = nQSXZ;
	}

	/**
	 * @return the xQZRSJ
	 */
	public String getXQZRSJ() {
		return XQZRSJ;
	}

	/**
	 * @param xQZRSJ
	 *            the xQZRSJ to set
	 */
	public void setXQZRSJ(String xQZRSJ) {
		XQZRSJ = xQZRSJ;
	}

	/**
	 * @return the xQZRFS
	 */
	public String getXQZRFS() {
		return XQZRFS;
	}

	/**
	 * @param xQZRFS
	 *            the xQZRFS to set
	 */
	public void setXQZRFS(String xQZRFS) {
		XQZRFS = xQZRFS;
	}

	/**
	 * @return the nXQZRMJ
	 */
	public String getNXQZRMJ() {
		return NXQZRMJ;
	}

	/**
	 * @param nXQZRMJ
	 *            the nXQZRMJ to set
	 */
	public void setNXQZRMJ(String nXQZRMJ) {
		NXQZRMJ = nXQZRMJ;
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
	 * @return the nZRHYT
	 */
	public String getNZRHYT() {
		return NZRHYT;
	}

	/**
	 * @param nZRHYT
	 *            the nZRHYT to set
	 */
	public void setNZRHYT(String nZRHYT) {
		NZRHYT = nZRHYT;
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
	 * @return the xQZRDJ
	 */
	public String getXQZRDJ() {
		return XQZRDJ;
	}

	/**
	 * @param xQZRDJ
	 *            the xQZRDJ to set
	 */
	public void setXQZRDJ(String xQZRDJ) {
		XQZRDJ = xQZRDJ;
	}

	/**
	 * @return the xQZRZJ
	 */
	public String getXQZRZJ() {
		return XQZRZJ;
	}

	/**
	 * @param xQZRZJ
	 *            the xQZRZJ to set
	 */
	public void setXQZRZJ(String xQZRZJ) {
		XQZRZJ = xQZRZJ;
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
