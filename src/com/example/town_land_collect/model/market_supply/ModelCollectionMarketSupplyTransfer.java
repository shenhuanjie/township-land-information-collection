/**
 * 
 */
package com.example.town_land_collect.model.market_supply;

import java.io.Serializable;

import org.litepal.crud.DataSupport;

/**
 * @Title ModelCollectionMarketSupplyTransfer.java
 * @Package com.example.town_land_collect.model.market_supply
 * @Description 土地使用权转让供应信息
 * @author Shen.dev
 * @date 2015-10-14 下午6:04:52
 * @version V1.0
 */
public class ModelCollectionMarketSupplyTransfer extends DataSupport implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 基本信息 **/
	private int ID;// 标记号
	private String THENAME;// 记录名称
	private String THECODE;// 记录代码

	/** 土地使用权转让供应信息 **/
	private String TDSYZ;// 土地所有者
	private String TDZSH;// 土地证书号
	private String TDZL;// 土地坐落
	private String QSXZ;// 权属性质
	private String ZRF;// 转让方
	private String NZRSJ;// 拟转让时间
	private String NZRFS;// 拟转让方式
	private String NZRMJ;// 拟土地转让面积
	private String ZRQYT;// 转让前用途
	private String NZRHYT;// 拟转让后用途
	private String TDSYNQ;// 土地剩余使用年期
	private String ZRDJ;// 拟土地转让单价
	private String ZRZJ;// 拟土地转让总价

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
	/** 基础信息.控件 **/
	private int index_qsxz = 0;// 权属性质

	/** 土地使用权出租供应信息 **/
	private int index_nzrfs = 0;// 拟转让方式
	private int index_zrqyt = 0;// 转让前用途
	private int index_nzrhyt = 0;// 拟转让后用途

	/** 其他信息.控件 **/
	private int index_hxwkfsp = 0;// 红线外开发水平
	private int index_hxnkfsp = 0;// 红线内开发水平
	private int index_tdjb = 0;// 所在土地级别

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
	 * @return the index_nzrfs
	 */
	public int getIndex_nzrfs() {
		return index_nzrfs;
	}

	/**
	 * @param index_nzrfs the index_nzrfs to set
	 */
	public void setIndex_nzrfs(int index_nzrfs) {
		this.index_nzrfs = index_nzrfs;
	}

	/**
	 * @return the index_zrqyt
	 */
	public int getIndex_zrqyt() {
		return index_zrqyt;
	}

	/**
	 * @param index_zrqyt the index_zrqyt to set
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
	 * @param index_nzrhyt the index_nzrhyt to set
	 */
	public void setIndex_nzrhyt(int index_nzrhyt) {
		this.index_nzrhyt = index_nzrhyt;
	}

	/**
	 * @return the index_hxwkfsp
	 */
	public int getIndex_hxwkfsp() {
		return index_hxwkfsp;
	}

	/**
	 * @param index_hxwkfsp the index_hxwkfsp to set
	 */
	public void setIndex_hxwkfsp(int index_hxwkfsp) {
		this.index_hxwkfsp = index_hxwkfsp;
	}

	/**
	 * @return the index_hxnkfsp
	 */
	public int getIndex_hxnkfsp() {
		return index_hxnkfsp;
	}

	/**
	 * @param index_hxnkfsp the index_hxnkfsp to set
	 */
	public void setIndex_hxnkfsp(int index_hxnkfsp) {
		this.index_hxnkfsp = index_hxnkfsp;
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
	 * @return the nZRSJ
	 */
	public String getNZRSJ() {
		return NZRSJ;
	}

	/**
	 * @param nZRSJ
	 *            the nZRSJ to set
	 */
	public void setNZRSJ(String nZRSJ) {
		NZRSJ = nZRSJ;
	}

	/**
	 * @return the nZRFS
	 */
	public String getNZRFS() {
		return NZRFS;
	}

	/**
	 * @param nZRFS
	 *            the nZRFS to set
	 */
	public void setNZRFS(String nZRFS) {
		NZRFS = nZRFS;
	}

	/**
	 * @return the nZRMJ
	 */
	public String getNZRMJ() {
		return NZRMJ;
	}

	/**
	 * @param nZRMJ
	 *            the nZRMJ to set
	 */
	public void setNZRMJ(String nZRMJ) {
		NZRMJ = nZRMJ;
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

}
