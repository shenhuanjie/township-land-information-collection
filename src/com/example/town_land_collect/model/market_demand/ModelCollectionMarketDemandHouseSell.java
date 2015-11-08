/**
 * 
 */
package com.example.town_land_collect.model.market_demand;

import java.io.Serializable;

import org.litepal.crud.DataSupport;

/**
 * @Title ModelCollectionMarketDemandHouseSell.java
 * @Package com.example.town_land_collect.model.market_demand
 * @Description 房地出售需求信息
 * @author Shen.dev
 * @date 2015-10-14 下午5:59:36
 * @version V1.0
 */
public class ModelCollectionMarketDemandHouseSell extends DataSupport implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 基本信息 **/
	private int ID;// 标记号
	private String THENAME;// 记录名称
	private String THECODE;// 记录代码

	/** 房地出售需求信息 **/
	private String XQGMF;// 需求购买方
	private String NTDZL;// 拟土地坐落
	private String NQSXZ;// 拟权属性质
	private String SFESF;// 是否二手房
	private String SFZAJF;// 是否转按揭房
	private String TDSYKNQ;// 土地剩余使用年期
	private String NTDYT;// 拟土地用途
	private String XQGMSJ;// 需求购买时间
	private String XQCSMJ;// 需求购买建筑面积
	private String XQKSYMJYQ;// 需求可使用面积
	private String XQRJL;// 需求容积率
	private String XQLJKD;// 需求临街宽度
	private String XQLJSD;// 需求临街深度
	private String XQJZLX;// 需求建筑类型
	private String XQJZCS;// 需求建筑层数
	private String XQFWJG;// 需求房屋结构
	private String XQJGSJ;// 需求竣工时间
	private String XQFWCXD;// 需求房屋成新度
	private String XQZXSJ;// 需求装修时间
	private String XQZXCD;// 需求装修程度
	private String XQZZHX;// 需求住宅户型
	private String XQPTSS;// 需求配套设施
	private String XQZBJT;// 需求周边交通
	private String XQDWMJSJ;// 需求单位面积售价
	private String XQZSJ;// 需求总售价

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
	private int index_nqsxz = 0;// 拟权属性质
	private int index_sfesf = 0;// 是否二手房
	private int index_sfzajf = 0;// 是否转按揭房
	private int index_ntdyt = 0;// 拟土地用途
	private int index_xqjzlx = 0;// 需求建筑类型
	private int index_xqfwjg = 0;// 需求房屋结构
	private int index_xqfwcxd = 0;// 需求房屋成新度
	private int index_xqzxcd = 0;// 需求装修程度
	private int index_xqzzhx = 0;// 需求住宅户型
	private int index_xqptss = 0;// 需求配套设施

	/** 其他信息.控件 **/
	private int index_tdjb = 0;// 所在土地级别
	public int getIndex_nqsxz() {
		return index_nqsxz;
	}

	public void setIndex_nqsxz(int index_nqsxz) {
		this.index_nqsxz = index_nqsxz;
	}

	public int getIndex_sfesf() {
		return index_sfesf;
	}

	public void setIndex_sfesf(int index_sfesf) {
		this.index_sfesf = index_sfesf;
	}

	public int getIndex_sfzajf() {
		return index_sfzajf;
	}

	public void setIndex_sfzajf(int index_sfzajf) {
		this.index_sfzajf = index_sfzajf;
	}

	public int getIndex_ntdyt() {
		return index_ntdyt;
	}

	public void setIndex_ntdyt(int index_ntdyt) {
		this.index_ntdyt = index_ntdyt;
	}

	public int getIndex_xqjzlx() {
		return index_xqjzlx;
	}

	public void setIndex_xqjzlx(int index_xqjzlx) {
		this.index_xqjzlx = index_xqjzlx;
	}

	public int getIndex_xqfwjg() {
		return index_xqfwjg;
	}

	public void setIndex_xqfwjg(int index_xqfwjg) {
		this.index_xqfwjg = index_xqfwjg;
	}

	public int getIndex_xqfwcxd() {
		return index_xqfwcxd;
	}

	public void setIndex_xqfwcxd(int index_xqfwcxd) {
		this.index_xqfwcxd = index_xqfwcxd;
	}

	public int getIndex_xqzxcd() {
		return index_xqzxcd;
	}

	public void setIndex_xqzxcd(int index_xqzxcd) {
		this.index_xqzxcd = index_xqzxcd;
	}

	public int getIndex_xqzzhx() {
		return index_xqzzhx;
	}

	public void setIndex_xqzzhx(int index_xqzzhx) {
		this.index_xqzzhx = index_xqzzhx;
	}

	public int getIndex_xqptss() {
		return index_xqptss;
	}

	public void setIndex_xqptss(int index_xqptss) {
		this.index_xqptss = index_xqptss;
	}

	public int getIndex_tdjb() {
		return index_tdjb;
	}

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
	 * @return the xQGMF
	 */
	public String getXQGMF() {
		return XQGMF;
	}

	/**
	 * @param xQGMF
	 *            the xQGMF to set
	 */
	public void setXQGMF(String xQGMF) {
		XQGMF = xQGMF;
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
	 * @return the sFESF
	 */
	public String getSFESF() {
		return SFESF;
	}

	/**
	 * @param sFESF
	 *            the sFESF to set
	 */
	public void setSFESF(String sFESF) {
		SFESF = sFESF;
	}

	/**
	 * @return the sFZAJF
	 */
	public String getSFZAJF() {
		return SFZAJF;
	}

	/**
	 * @param sFZAJF
	 *            the sFZAJF to set
	 */
	public void setSFZAJF(String sFZAJF) {
		SFZAJF = sFZAJF;
	}

	/**
	 * @return the tDSYKNQ
	 */
	public String getTDSYKNQ() {
		return TDSYKNQ;
	}

	/**
	 * @param tDSYKNQ
	 *            the tDSYKNQ to set
	 */
	public void setTDSYKNQ(String tDSYKNQ) {
		TDSYKNQ = tDSYKNQ;
	}

	/**
	 * @return the nTDYT
	 */
	public String getNTDYT() {
		return NTDYT;
	}

	/**
	 * @param nTDYT
	 *            the nTDYT to set
	 */
	public void setNTDYT(String nTDYT) {
		NTDYT = nTDYT;
	}

	/**
	 * @return the xQGMSJ
	 */
	public String getXQGMSJ() {
		return XQGMSJ;
	}

	/**
	 * @param xQGMSJ
	 *            the xQGMSJ to set
	 */
	public void setXQGMSJ(String xQGMSJ) {
		XQGMSJ = xQGMSJ;
	}

	/**
	 * @return the xQCSMJ
	 */
	public String getXQCSMJ() {
		return XQCSMJ;
	}

	/**
	 * @param xQCSMJ
	 *            the xQCSMJ to set
	 */
	public void setXQCSMJ(String xQCSMJ) {
		XQCSMJ = xQCSMJ;
	}

	/**
	 * @return the xQKSYMJYQ
	 */
	public String getXQKSYMJYQ() {
		return XQKSYMJYQ;
	}

	/**
	 * @param xQKSYMJYQ
	 *            the xQKSYMJYQ to set
	 */
	public void setXQKSYMJYQ(String xQKSYMJYQ) {
		XQKSYMJYQ = xQKSYMJYQ;
	}

	/**
	 * @return the xQRJL
	 */
	public String getXQRJL() {
		return XQRJL;
	}

	/**
	 * @param xQRJL
	 *            the xQRJL to set
	 */
	public void setXQRJL(String xQRJL) {
		XQRJL = xQRJL;
	}

	/**
	 * @return the xQLJKD
	 */
	public String getXQLJKD() {
		return XQLJKD;
	}

	/**
	 * @param xQLJKD
	 *            the xQLJKD to set
	 */
	public void setXQLJKD(String xQLJKD) {
		XQLJKD = xQLJKD;
	}

	/**
	 * @return the xQLJSD
	 */
	public String getXQLJSD() {
		return XQLJSD;
	}

	/**
	 * @param xQLJSD
	 *            the xQLJSD to set
	 */
	public void setXQLJSD(String xQLJSD) {
		XQLJSD = xQLJSD;
	}

	/**
	 * @return the xQJZLX
	 */
	public String getXQJZLX() {
		return XQJZLX;
	}

	/**
	 * @param xQJZLX
	 *            the xQJZLX to set
	 */
	public void setXQJZLX(String xQJZLX) {
		XQJZLX = xQJZLX;
	}

	/**
	 * @return the xQJZCS
	 */
	public String getXQJZCS() {
		return XQJZCS;
	}

	/**
	 * @param xQJZCS
	 *            the xQJZCS to set
	 */
	public void setXQJZCS(String xQJZCS) {
		XQJZCS = xQJZCS;
	}

	/**
	 * @return the xQFWJG
	 */
	public String getXQFWJG() {
		return XQFWJG;
	}

	/**
	 * @param xQFWJG
	 *            the xQFWJG to set
	 */
	public void setXQFWJG(String xQFWJG) {
		XQFWJG = xQFWJG;
	}

	/**
	 * @return the xQJGSJ
	 */
	public String getXQJGSJ() {
		return XQJGSJ;
	}

	/**
	 * @param xQJGSJ
	 *            the xQJGSJ to set
	 */
	public void setXQJGSJ(String xQJGSJ) {
		XQJGSJ = xQJGSJ;
	}

	/**
	 * @return the xQFWCXD
	 */
	public String getXQFWCXD() {
		return XQFWCXD;
	}

	/**
	 * @param xQFWCXD
	 *            the xQFWCXD to set
	 */
	public void setXQFWCXD(String xQFWCXD) {
		XQFWCXD = xQFWCXD;
	}

	/**
	 * @return the xQZXSJ
	 */
	public String getXQZXSJ() {
		return XQZXSJ;
	}

	/**
	 * @param xQZXSJ
	 *            the xQZXSJ to set
	 */
	public void setXQZXSJ(String xQZXSJ) {
		XQZXSJ = xQZXSJ;
	}

	/**
	 * @return the xQZXCD
	 */
	public String getXQZXCD() {
		return XQZXCD;
	}

	/**
	 * @param xQZXCD
	 *            the xQZXCD to set
	 */
	public void setXQZXCD(String xQZXCD) {
		XQZXCD = xQZXCD;
	}

	/**
	 * @return the xQZZHX
	 */
	public String getXQZZHX() {
		return XQZZHX;
	}

	/**
	 * @param xQZZHX
	 *            the xQZZHX to set
	 */
	public void setXQZZHX(String xQZZHX) {
		XQZZHX = xQZZHX;
	}

	/**
	 * @return the xQPTSS
	 */
	public String getXQPTSS() {
		return XQPTSS;
	}

	/**
	 * @param xQPTSS
	 *            the xQPTSS to set
	 */
	public void setXQPTSS(String xQPTSS) {
		XQPTSS = xQPTSS;
	}

	/**
	 * @return the xQZBJT
	 */
	public String getXQZBJT() {
		return XQZBJT;
	}

	/**
	 * @param xQZBJT
	 *            the xQZBJT to set
	 */
	public void setXQZBJT(String xQZBJT) {
		XQZBJT = xQZBJT;
	}

	/**
	 * @return the xQDWMJSJ
	 */
	public String getXQDWMJSJ() {
		return XQDWMJSJ;
	}

	/**
	 * @param xQDWMJSJ
	 *            the xQDWMJSJ to set
	 */
	public void setXQDWMJSJ(String xQDWMJSJ) {
		XQDWMJSJ = xQDWMJSJ;
	}

	/**
	 * @return the xQZSJ
	 */
	public String getXQZSJ() {
		return XQZSJ;
	}

	/**
	 * @param xQZSJ
	 *            the xQZSJ to set
	 */
	public void setXQZSJ(String xQZSJ) {
		XQZSJ = xQZSJ;
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
