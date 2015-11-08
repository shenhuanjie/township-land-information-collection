/**
 * 
 */
package com.example.town_land_collect.model.market_supply;

import java.io.Serializable;

import org.litepal.crud.DataSupport;

/**
 * @Title ModelCollectionMarketSupplyShareHolder.java
 * @Package com.example.town_land_collect.model.market_supply
 * @Description 土地联营入股供应信息
 * @author Shen.dev
 * @date 2015-10-14 下午6:04:37
 * @version V1.0
 */
public class ModelCollectionMarketSupplyShareHolder extends DataSupport implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 基本信息 **/
	private int ID;// 标记号
	private String THENAME;// 记录名称
	private String THECODE;// 记录代码

	/** 土地联营入股供应信息 **/
	private String TDSYZ;// 土地所有者
	private String TDZSH;// 土地证书号
	private String TDZL;// 土地坐落
	private String QSXZ;// 权属性质
	private String CDF;// 出地方
	private String NLYSJ;// 拟联营时间
	private String NLYQ;// 拟联营期
	private String NCDMJ;// 拟出地方投入土地面积
	private String NCZZE;// 拟出资方投入资金总额
	private String NCDFFCBL;// 拟出地方利润分成比例
	private String NTDNCSR;// 拟单位面积土地年纯收入
	private String NCDFNCSR;// 拟出地方土地年纯收入
	private String LYQYT;// 联营前用途
	private String LYHGHYT;// 联营后规划用途

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
	private int index_lyqyt = 0;// 联营前用途
	private int index_lyhghyt = 0;// 联营后规划用途
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
	 * @return the index_lyqyt
	 */
	public int getIndex_lyqyt() {
		return index_lyqyt;
	}

	/**
	 * @param index_lyqyt
	 *            the index_lyqyt to set
	 */
	public void setIndex_lyqyt(int index_lyqyt) {
		this.index_lyqyt = index_lyqyt;
	}

	/**
	 * @return the index_lyhghyt
	 */
	public int getIndex_lyhghyt() {
		return index_lyhghyt;
	}

	/**
	 * @param index_lyhghyt
	 *            the index_lyhghyt to set
	 */
	public void setIndex_lyhghyt(int index_lyhghyt) {
		this.index_lyhghyt = index_lyhghyt;
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
	 * @return the cDF
	 */
	public String getCDF() {
		return CDF;
	}

	/**
	 * @param cDF
	 *            the cDF to set
	 */
	public void setCDF(String cDF) {
		CDF = cDF;
	}

	/**
	 * @return the nLYSJ
	 */
	public String getNLYSJ() {
		return NLYSJ;
	}

	/**
	 * @param nLYSJ
	 *            the nLYSJ to set
	 */
	public void setNLYSJ(String nLYSJ) {
		NLYSJ = nLYSJ;
	}

	/**
	 * @return the nLYQ
	 */
	public String getNLYQ() {
		return NLYQ;
	}

	/**
	 * @param nLYQ
	 *            the nLYQ to set
	 */
	public void setNLYQ(String nLYQ) {
		NLYQ = nLYQ;
	}

	/**
	 * @return the nCDMJ
	 */
	public String getNCDMJ() {
		return NCDMJ;
	}

	/**
	 * @param nCDMJ
	 *            the nCDMJ to set
	 */
	public void setNCDMJ(String nCDMJ) {
		NCDMJ = nCDMJ;
	}

	/**
	 * @return the nCZZE
	 */
	public String getNCZZE() {
		return NCZZE;
	}

	/**
	 * @param nCZZE
	 *            the nCZZE to set
	 */
	public void setNCZZE(String nCZZE) {
		NCZZE = nCZZE;
	}

	/**
	 * @return the nCDFFCBL
	 */
	public String getNCDFFCBL() {
		return NCDFFCBL;
	}

	/**
	 * @param nCDFFCBL
	 *            the nCDFFCBL to set
	 */
	public void setNCDFFCBL(String nCDFFCBL) {
		NCDFFCBL = nCDFFCBL;
	}

	/**
	 * @return the nTDNCSR
	 */
	public String getNTDNCSR() {
		return NTDNCSR;
	}

	/**
	 * @param nTDNCSR
	 *            the nTDNCSR to set
	 */
	public void setNTDNCSR(String nTDNCSR) {
		NTDNCSR = nTDNCSR;
	}

	/**
	 * @return the nCDFNCSR
	 */
	public String getNCDFNCSR() {
		return NCDFNCSR;
	}

	/**
	 * @param nCDFNCSR
	 *            the nCDFNCSR to set
	 */
	public void setNCDFNCSR(String nCDFNCSR) {
		NCDFNCSR = nCDFNCSR;
	}

	/**
	 * @return the lYQYT
	 */
	public String getLYQYT() {
		return LYQYT;
	}

	/**
	 * @param lYQYT
	 *            the lYQYT to set
	 */
	public void setLYQYT(String lYQYT) {
		LYQYT = lYQYT;
	}

	/**
	 * @return the lYHGHYT
	 */
	public String getLYHGHYT() {
		return LYHGHYT;
	}

	/**
	 * @param lYHGHYT
	 *            the lYHGHYT to set
	 */
	public void setLYHGHYT(String lYHGHYT) {
		LYHGHYT = lYHGHYT;
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
