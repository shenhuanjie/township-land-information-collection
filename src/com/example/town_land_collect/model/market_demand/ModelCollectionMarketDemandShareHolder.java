/**
 * 
 */
package com.example.town_land_collect.model.market_demand;

import java.io.Serializable;

import org.litepal.crud.DataSupport;

/**
 * @Title ModelCollectionMarketDemandShareHolder.java
 * @Package com.example.town_land_collect.model.market_demand
 * @Description 土地联营入股需求信息
 * @author Shen.dev
 * @date 2015-10-14 下午6:00:14
 * @version V1.0
 */
public class ModelCollectionMarketDemandShareHolder extends DataSupport implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 基本信息 **/
	private int ID;// 标记号
	private String THENAME;// 记录名称
	private String THECODE;// 记录代码

	/** 土地联营入股需求信息 **/
	private String XQCZF;// 需求出资方
	private String XQCZFZTXZ;// 需求出资方主体性质
	private String NTDZL;// 拟土地坐落
	private String NQSXZ;// 拟权属性质
	private String XQXZTDTJ;// 需求现状土地条件
	private String XQLYSJ;// 需求联营时间
	private String XQLYQ;// 需求联营期
	private String XQCDMJ;// 需求出地方投入土地面积
	private String XQCZZE;// 需求出资方投入资金总额
	private String XQCDFFCBL;// 需求出地方利润分成比例
	private String NTDNCSR;// 拟单位面积土地年纯收入
	private String NCDFNCSR;// 拟出地方土地年纯收入
	private String LYQYT;// 联营前用途
	private String NLYHYT;// 拟联营后用途

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
	/** 土地联营入股需求信息 **/
	private int index_xqczfztxz;// 需求出资方主体性质
	private int index_lyqyt;// 联营前用途
	private int index_nlyhyt;// 拟联营后用途
	/** 其他信息.控件 **/
	private int index_nqsxz;// 拟权属性质

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

	private int index_tdjb = 0;// 所在土地级别

	/**
	 * @return the index_xqczfztxz
	 */
	public int getIndex_xqczfztxz() {
		return index_xqczfztxz;
	}

	/**
	 * @param index_xqczfztxz
	 *            the index_xqczfztxz to set
	 */
	public void setIndex_xqczfztxz(int index_xqczfztxz) {
		this.index_xqczfztxz = index_xqczfztxz;
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
	 * @return the index_nlyhyt
	 */
	public int getIndex_nlyhyt() {
		return index_nlyhyt;
	}

	/**
	 * @param index_nlyhyt
	 *            the index_nlyhyt to set
	 */
	public void setIndex_nlyhyt(int index_nlyhyt) {
		this.index_nlyhyt = index_nlyhyt;
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
	 * @return the xQCZF
	 */
	public String getXQCZF() {
		return XQCZF;
	}

	/**
	 * @param xQCZF
	 *            the xQCZF to set
	 */
	public void setXQCZF(String xQCZF) {
		XQCZF = xQCZF;
	}

	/**
	 * @return the xQCZFZTXZ
	 */
	public String getXQCZFZTXZ() {
		return XQCZFZTXZ;
	}

	/**
	 * @param xQCZFZTXZ
	 *            the xQCZFZTXZ to set
	 */
	public void setXQCZFZTXZ(String xQCZFZTXZ) {
		XQCZFZTXZ = xQCZFZTXZ;
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

	/**
	 * @return the xQLYSJ
	 */
	public String getXQLYSJ() {
		return XQLYSJ;
	}

	/**
	 * @param xQLYSJ
	 *            the xQLYSJ to set
	 */
	public void setXQLYSJ(String xQLYSJ) {
		XQLYSJ = xQLYSJ;
	}

	/**
	 * @return the xQLYQ
	 */
	public String getXQLYQ() {
		return XQLYQ;
	}

	/**
	 * @param xQLYQ
	 *            the xQLYQ to set
	 */
	public void setXQLYQ(String xQLYQ) {
		XQLYQ = xQLYQ;
	}

	/**
	 * @return the xQCDMJ
	 */
	public String getXQCDMJ() {
		return XQCDMJ;
	}

	/**
	 * @param xQCDMJ
	 *            the xQCDMJ to set
	 */
	public void setXQCDMJ(String xQCDMJ) {
		XQCDMJ = xQCDMJ;
	}

	/**
	 * @return the xQCZZE
	 */
	public String getXQCZZE() {
		return XQCZZE;
	}

	/**
	 * @param xQCZZE
	 *            the xQCZZE to set
	 */
	public void setXQCZZE(String xQCZZE) {
		XQCZZE = xQCZZE;
	}

	/**
	 * @return the xQCDFFCBL
	 */
	public String getXQCDFFCBL() {
		return XQCDFFCBL;
	}

	/**
	 * @param xQCDFFCBL
	 *            the xQCDFFCBL to set
	 */
	public void setXQCDFFCBL(String xQCDFFCBL) {
		XQCDFFCBL = xQCDFFCBL;
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
	 * @return the nLYHYT
	 */
	public String getNLYHYT() {
		return NLYHYT;
	}

	/**
	 * @param nLYHYT
	 *            the nLYHYT to set
	 */
	public void setNLYHYT(String nLYHYT) {
		NLYHYT = nLYHYT;
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
