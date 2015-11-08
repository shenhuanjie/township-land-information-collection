/**
 * 
 */
package com.example.town_land_collect.model.market_redevelopment;

import java.io.Serializable;

import org.litepal.crud.DataSupport;

/**
 * @Title ModelCollectionMarketRedevelopmentImpose.java
 * @Package com.example.town_land_collect.model.market_redevelopment
 * @Description 再开发实施项目信息
 * @author Shen.dev
 * @date 2015-10-14 下午6:02:43
 * @version V1.0
 */
public class ModelCollectionMarketRedevelopmentImpose extends DataSupport implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 基本信息 **/
	private int ID;// 标记号
	private String THENAME;// 记录名称
	private String THECODE;// 记录代码

	/** 再开发实施项目信息 **/
	private String BH;// 编号
	private String XMMC;// 项目名称
	private String XMLX;// 项目类型
	private String TDZL;// 土地坐落
	private String TDMJ;// 土地面积
	private String RJL;// 容积率
	private String JZXS;// 建筑系数
	private String JZMD;// 建筑密度
	private String LVH;// 绿化率
	private String KFMS;// 开发模式
	private String ZTZ;// 总投资
	private String ZJLY;// 资金来源
	private String GDFS;// 供地方式
	private String KFQYT;// 开发前用途
	private String KFHYT;// 开发后用途
	private String CYLX;// 产业类型
	private String QYZDCY;// 区域主导产业类型
	private String QYGYJZDJ;// 区域国有建设用地基准地价
	private String QYJTJZDJ;// 区域集体建设用地基准地价
	private String DJCZ;// 地均产值
	private String DJSS;// 地均税收
	private String DJCYRY;// 地均从业人员数

	/** 其他信息 **/
	private String TDJB;// 所在土地级别
	private String DJQD;// 所在地价区段
	private String XZQDM;// 行政区代码
	private String REMARK;// 备注

	/** 系统信息 **/
	private String INPUTUSERID;// 创建用户
	private String CREATETIME;// 创建时间
	private String LASTUPDATEUSERID;// 修改用户
	private String UPDATETIME;// 修改时间
	private String ISDELETE;// 是否删除
	private String SHOWSEQ;// 显示顺序
	/** 再开发实施项目信息 **/
	private int index_xmlx = 0;// 项目类型
	private int index_kfms = 0;// 开发模式
	private int index_zjly = 0;// 资金来源
	private int index_gdfs = 0;// 供地方式
	private int index_kfqyt = 0;// 开发前用途
	private int index_kfhyt = 0;// 开发后用途
	private int index_cylx = 0;// 产业类型
	private int index_qyzdcy = 0;// 区域主导产业类型
	/** 其他信息.控件 **/
	private int index_tdjb = 0;// 所在土地级别

	/**
	 * @return the index_xmlx
	 */
	public int getIndex_xmlx() {
		return index_xmlx;
	}

	/**
	 * @param index_xmlx
	 *            the index_xmlx to set
	 */
	public void setIndex_xmlx(int index_xmlx) {
		this.index_xmlx = index_xmlx;
	}

	/**
	 * @return the index_kfms
	 */
	public int getIndex_kfms() {
		return index_kfms;
	}

	/**
	 * @param index_kfms
	 *            the index_kfms to set
	 */
	public void setIndex_kfms(int index_kfms) {
		this.index_kfms = index_kfms;
	}

	/**
	 * @return the index_zjly
	 */
	public int getIndex_zjly() {
		return index_zjly;
	}

	/**
	 * @param index_zjly
	 *            the index_zjly to set
	 */
	public void setIndex_zjly(int index_zjly) {
		this.index_zjly = index_zjly;
	}

	/**
	 * @return the index_gdfs
	 */
	public int getIndex_gdfs() {
		return index_gdfs;
	}

	/**
	 * @param index_gdfs
	 *            the index_gdfs to set
	 */
	public void setIndex_gdfs(int index_gdfs) {
		this.index_gdfs = index_gdfs;
	}

	/**
	 * @return the index_kfqyt
	 */
	public int getIndex_kfqyt() {
		return index_kfqyt;
	}

	/**
	 * @param index_kfqyt
	 *            the index_kfqyt to set
	 */
	public void setIndex_kfqyt(int index_kfqyt) {
		this.index_kfqyt = index_kfqyt;
	}

	/**
	 * @return the index_kfhyt
	 */
	public int getIndex_kfhyt() {
		return index_kfhyt;
	}

	/**
	 * @param index_kfhyt
	 *            the index_kfhyt to set
	 */
	public void setIndex_kfhyt(int index_kfhyt) {
		this.index_kfhyt = index_kfhyt;
	}

	/**
	 * @return the index_cylx
	 */
	public int getIndex_cylx() {
		return index_cylx;
	}

	/**
	 * @param index_cylx
	 *            the index_cylx to set
	 */
	public void setIndex_cylx(int index_cylx) {
		this.index_cylx = index_cylx;
	}

	/**
	 * @return the index_qyzdcy
	 */
	public int getIndex_qyzdcy() {
		return index_qyzdcy;
	}

	/**
	 * @param index_qyzdcy
	 *            the index_qyzdcy to set
	 */
	public void setIndex_qyzdcy(int index_qyzdcy) {
		this.index_qyzdcy = index_qyzdcy;
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
	 * @return the bH
	 */
	public String getBH() {
		return BH;
	}

	/**
	 * @param bH
	 *            the bH to set
	 */
	public void setBH(String bH) {
		BH = bH;
	}

	/**
	 * @return the xMMC
	 */
	public String getXMMC() {
		return XMMC;
	}

	/**
	 * @param xMMC
	 *            the xMMC to set
	 */
	public void setXMMC(String xMMC) {
		XMMC = xMMC;
	}

	/**
	 * @return the xMLX
	 */
	public String getXMLX() {
		return XMLX;
	}

	/**
	 * @param xMLX
	 *            the xMLX to set
	 */
	public void setXMLX(String xMLX) {
		XMLX = xMLX;
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
	 * @return the tDMJ
	 */
	public String getTDMJ() {
		return TDMJ;
	}

	/**
	 * @param tDMJ
	 *            the tDMJ to set
	 */
	public void setTDMJ(String tDMJ) {
		TDMJ = tDMJ;
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
	 * @return the jZXS
	 */
	public String getJZXS() {
		return JZXS;
	}

	/**
	 * @param jZXS
	 *            the jZXS to set
	 */
	public void setJZXS(String jZXS) {
		JZXS = jZXS;
	}

	/**
	 * @return the jZMD
	 */
	public String getJZMD() {
		return JZMD;
	}

	/**
	 * @param jZMD
	 *            the jZMD to set
	 */
	public void setJZMD(String jZMD) {
		JZMD = jZMD;
	}

	/**
	 * @return the lVH
	 */
	public String getLVH() {
		return LVH;
	}

	/**
	 * @param lVH
	 *            the lVH to set
	 */
	public void setLVH(String lVH) {
		LVH = lVH;
	}

	/**
	 * @return the kFMS
	 */
	public String getKFMS() {
		return KFMS;
	}

	/**
	 * @param kFMS
	 *            the kFMS to set
	 */
	public void setKFMS(String kFMS) {
		KFMS = kFMS;
	}

	/**
	 * @return the zTZ
	 */
	public String getZTZ() {
		return ZTZ;
	}

	/**
	 * @param zTZ
	 *            the zTZ to set
	 */
	public void setZTZ(String zTZ) {
		ZTZ = zTZ;
	}

	/**
	 * @return the zJLY
	 */
	public String getZJLY() {
		return ZJLY;
	}

	/**
	 * @param zJLY
	 *            the zJLY to set
	 */
	public void setZJLY(String zJLY) {
		ZJLY = zJLY;
	}

	/**
	 * @return the gDFS
	 */
	public String getGDFS() {
		return GDFS;
	}

	/**
	 * @param gDFS
	 *            the gDFS to set
	 */
	public void setGDFS(String gDFS) {
		GDFS = gDFS;
	}

	/**
	 * @return the kFQYT
	 */
	public String getKFQYT() {
		return KFQYT;
	}

	/**
	 * @param kFQYT
	 *            the kFQYT to set
	 */
	public void setKFQYT(String kFQYT) {
		KFQYT = kFQYT;
	}

	/**
	 * @return the kFHYT
	 */
	public String getKFHYT() {
		return KFHYT;
	}

	/**
	 * @param kFHYT
	 *            the kFHYT to set
	 */
	public void setKFHYT(String kFHYT) {
		KFHYT = kFHYT;
	}

	/**
	 * @return the cYLX
	 */
	public String getCYLX() {
		return CYLX;
	}

	/**
	 * @param cYLX
	 *            the cYLX to set
	 */
	public void setCYLX(String cYLX) {
		CYLX = cYLX;
	}

	/**
	 * @return the qYZDCY
	 */
	public String getQYZDCY() {
		return QYZDCY;
	}

	/**
	 * @param qYZDCY
	 *            the qYZDCY to set
	 */
	public void setQYZDCY(String qYZDCY) {
		QYZDCY = qYZDCY;
	}

	/**
	 * @return the qYGYJZDJ
	 */
	public String getQYGYJZDJ() {
		return QYGYJZDJ;
	}

	/**
	 * @param qYGYJZDJ
	 *            the qYGYJZDJ to set
	 */
	public void setQYGYJZDJ(String qYGYJZDJ) {
		QYGYJZDJ = qYGYJZDJ;
	}

	/**
	 * @return the qYJTJZDJ
	 */
	public String getQYJTJZDJ() {
		return QYJTJZDJ;
	}

	/**
	 * @param qYJTJZDJ
	 *            the qYJTJZDJ to set
	 */
	public void setQYJTJZDJ(String qYJTJZDJ) {
		QYJTJZDJ = qYJTJZDJ;
	}

	/**
	 * @return the dJCZ
	 */
	public String getDJCZ() {
		return DJCZ;
	}

	/**
	 * @param dJCZ
	 *            the dJCZ to set
	 */
	public void setDJCZ(String dJCZ) {
		DJCZ = dJCZ;
	}

	/**
	 * @return the dJSS
	 */
	public String getDJSS() {
		return DJSS;
	}

	/**
	 * @param dJSS
	 *            the dJSS to set
	 */
	public void setDJSS(String dJSS) {
		DJSS = dJSS;
	}

	/**
	 * @return the dJCYRY
	 */
	public String getDJCYRY() {
		return DJCYRY;
	}

	/**
	 * @param dJCYRY
	 *            the dJCYRY to set
	 */
	public void setDJCYRY(String dJCYRY) {
		DJCYRY = dJCYRY;
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
