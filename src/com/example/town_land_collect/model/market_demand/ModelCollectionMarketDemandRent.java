/**
 * 
 */
package com.example.town_land_collect.model.market_demand;

import java.io.Serializable;

import org.litepal.crud.DataSupport;

/**
 * @Title ModelCollectionMarketDemandRent.java
 * @Package com.example.town_land_collect.model.market_demand
 * @Description 土地使用权出租需求信息
 * @author Shen.dev
 * @date 2015-10-14 下午5:59:51
 * @version V1.0
 */
public class ModelCollectionMarketDemandRent extends DataSupport implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 基本信息 **/
	private int ID;// 标记号
	private String THENAME;// 记录名称
	private String THECODE;// 记录代码

	/** 土地使用权出租需求信息 **/
	private String XQCZF;// 需求承租方
	private String XQCZFZTXZ;// 需求承租方主体性质
	private String NTDZL;// 拟土地坐落
	private String NQSXZ;// 拟权属性质
	private String XQXZTDTJ;// 需求现状土地条件
	private String XQCZSJ;// 需求出租时间
	private String XQZQ;// 需求租期
	private String XQCZMJ;// 需求土地出租面积
	private String CZQYT;// 出租前用途
	private String NCZYT;// 拟出租后用途
	private String TDSYNQ;// 土地剩余使用年期
	private String RJL;// 宗地容积率
	private String XQNZJ;// 需求年租金
	private String NYJ;// 拟押金

	/** 其他信息 **/
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
	private int index_xqczfztxz = 0;// 需求承租方主体性质
	private int index_nqsxz = 0;// 拟权属性质
	private int index_czqyt = 0;// 出租前用途
	private int index_nczyt = 0;// 拟出租后用途
	/** 其他信息.控件 **/
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
	 * @return the index_czqyt
	 */
	public int getIndex_czqyt() {
		return index_czqyt;
	}

	/**
	 * @param index_czqyt
	 *            the index_czqyt to set
	 */
	public void setIndex_czqyt(int index_czqyt) {
		this.index_czqyt = index_czqyt;
	}

	/**
	 * @return the index_nczyt
	 */
	public int getIndex_nczyt() {
		return index_nczyt;
	}

	/**
	 * @param index_nczyt
	 *            the index_nczyt to set
	 */
	public void setIndex_nczyt(int index_nczyt) {
		this.index_nczyt = index_nczyt;
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
	 * @return the xQCZSJ
	 */
	public String getXQCZSJ() {
		return XQCZSJ;
	}

	/**
	 * @param xQCZSJ
	 *            the xQCZSJ to set
	 */
	public void setXQCZSJ(String xQCZSJ) {
		XQCZSJ = xQCZSJ;
	}

	/**
	 * @return the xQZQ
	 */
	public String getXQZQ() {
		return XQZQ;
	}

	/**
	 * @param xQZQ
	 *            the xQZQ to set
	 */
	public void setXQZQ(String xQZQ) {
		XQZQ = xQZQ;
	}

	/**
	 * @return the xQCZMJ
	 */
	public String getXQCZMJ() {
		return XQCZMJ;
	}

	/**
	 * @param xQCZMJ
	 *            the xQCZMJ to set
	 */
	public void setXQCZMJ(String xQCZMJ) {
		XQCZMJ = xQCZMJ;
	}

	/**
	 * @return the cZQYT
	 */
	public String getCZQYT() {
		return CZQYT;
	}

	/**
	 * @param cZQYT
	 *            the cZQYT to set
	 */
	public void setCZQYT(String cZQYT) {
		CZQYT = cZQYT;
	}

	/**
	 * @return the nCZYT
	 */
	public String getNCZYT() {
		return NCZYT;
	}

	/**
	 * @param nCZYT
	 *            the nCZYT to set
	 */
	public void setNCZYT(String nCZYT) {
		NCZYT = nCZYT;
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
	 * @return the xQNZJ
	 */
	public String getXQNZJ() {
		return XQNZJ;
	}

	/**
	 * @param xQNZJ
	 *            the xQNZJ to set
	 */
	public void setXQNZJ(String xQNZJ) {
		XQNZJ = xQNZJ;
	}

	/**
	 * @return the nYJ
	 */
	public String getNYJ() {
		return NYJ;
	}

	/**
	 * @param nYJ
	 *            the nYJ to set
	 */
	public void setNYJ(String nYJ) {
		NYJ = nYJ;
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
