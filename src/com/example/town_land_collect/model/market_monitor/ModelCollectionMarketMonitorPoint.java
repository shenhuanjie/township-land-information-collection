/**
 * 
 */
package com.example.town_land_collect.model.market_monitor;

import java.io.Serializable;

import org.litepal.crud.DataSupport;

/**
 * @Title ModelCollectionMarketMonitorPoint.java
 * @Package com.example.town_land_collect.model.market_monitor
 * @Description 土地市场监控点信息
 * @author Shen.dev
 * @date 2015-10-14 下午6:02:11
 * @version V1.0
 */
public class ModelCollectionMarketMonitorPoint extends DataSupport implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 基本信息 **/
	private int ID;// 标记号
	private String THENAME;// 记录名称
	private String THECODE;// 记录代码

	/** 土地市场监控点信息 **/
	private String JCDMC;// 监测点名称
	private String TDZL;// 土地坐落
	private String TDZSH;// 土地证书号
	private String QSXZ;// 权属性质
	private String GZQ;// 工作期
	private String TDYT;// 土地用途
	private String TDMJ;// 土地面积
	private String TDSYZ;// 土地所有者
	private String TDSHYZ;// 土地使用者
	private String RJL;// 容积率
	private String JZMJ;// 建筑密度
	private String JZXS;// 建筑系数
	private String LDL;// 绿地率
	private String TDSYNQ;// 土地使用年期
	private String ZDNKFSP;// 宗地内开发水平
	private String ZSWKFSP;// 宗地外开发水平
	private String XZL;// 土地闲置率（房屋空置率）
	private String SCJG;// 市场价格
	private String SCZJ;// 市场租金
	private String DJTZ;// 地均累计固定资产投资
	private String DJCZ;// 地均产值
	private String DJSS;// 地均税收
	private String DJCYRY;// 地均从业人员（常住人口）
	private String SDRJL;// 设定容积率
	private String SDSYNQ;// 设定使用年期
	private String SDKFSP;// 设定开发水平
	private String PGJG;// 评估价格
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
	/** 土地市场监控点信息 **/
	private int index_qsxz = 0;// 权属性质
	private int index_tdyt = 0;// 土地用途
	private int index_zdnkfsp = 0;// 宗地内开发水平
	private int index_zswkfsp = 0;// 宗地外开发水平
	private int index_sdkfsp = 0;// 设定开发水平
	private int index_tdjb = 0;// 所在土地级别

	public int getIndex_qsxz() {
		return index_qsxz;
	}

	public void setIndex_qsxz(int index_qsxz) {
		this.index_qsxz = index_qsxz;
	}

	public int getIndex_tdyt() {
		return index_tdyt;
	}

	public void setIndex_tdyt(int index_tdyt) {
		this.index_tdyt = index_tdyt;
	}

	public int getIndex_zdnkfsp() {
		return index_zdnkfsp;
	}

	public void setIndex_zdnkfsp(int index_zdnkfsp) {
		this.index_zdnkfsp = index_zdnkfsp;
	}

	public int getIndex_zswkfsp() {
		return index_zswkfsp;
	}

	public void setIndex_zswkfsp(int index_zswkfsp) {
		this.index_zswkfsp = index_zswkfsp;
	}

	public int getIndex_sdkfsp() {
		return index_sdkfsp;
	}

	public void setIndex_sdkfsp(int index_sdkfsp) {
		this.index_sdkfsp = index_sdkfsp;
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
	 * @return the jCDMC
	 */
	public String getJCDMC() {
		return JCDMC;
	}

	/**
	 * @param jCDMC
	 *            the jCDMC to set
	 */
	public void setJCDMC(String jCDMC) {
		JCDMC = jCDMC;
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
	 * @return the gZQ
	 */
	public String getGZQ() {
		return GZQ;
	}

	/**
	 * @param gZQ
	 *            the gZQ to set
	 */
	public void setGZQ(String gZQ) {
		GZQ = gZQ;
	}

	/**
	 * @return the tDYT
	 */
	public String getTDYT() {
		return TDYT;
	}

	/**
	 * @param tDYT
	 *            the tDYT to set
	 */
	public void setTDYT(String tDYT) {
		TDYT = tDYT;
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
	 * @return the tDSHYZ
	 */
	public String getTDSHYZ() {
		return TDSHYZ;
	}

	/**
	 * @param tDSHYZ
	 *            the tDSHYZ to set
	 */
	public void setTDSHYZ(String tDSHYZ) {
		TDSHYZ = tDSHYZ;
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
	 * @return the jZMJ
	 */
	public String getJZMJ() {
		return JZMJ;
	}

	/**
	 * @param jZMJ
	 *            the jZMJ to set
	 */
	public void setJZMJ(String jZMJ) {
		JZMJ = jZMJ;
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
	 * @return the lDL
	 */
	public String getLDL() {
		return LDL;
	}

	/**
	 * @param lDL
	 *            the lDL to set
	 */
	public void setLDL(String lDL) {
		LDL = lDL;
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
	 * @return the zDNKFSP
	 */
	public String getZDNKFSP() {
		return ZDNKFSP;
	}

	/**
	 * @param zDNKFSP
	 *            the zDNKFSP to set
	 */
	public void setZDNKFSP(String zDNKFSP) {
		ZDNKFSP = zDNKFSP;
	}

	/**
	 * @return the zSWKFSP
	 */
	public String getZSWKFSP() {
		return ZSWKFSP;
	}

	/**
	 * @param zSWKFSP
	 *            the zSWKFSP to set
	 */
	public void setZSWKFSP(String zSWKFSP) {
		ZSWKFSP = zSWKFSP;
	}

	/**
	 * @return the xZL
	 */
	public String getXZL() {
		return XZL;
	}

	/**
	 * @param xZL
	 *            the xZL to set
	 */
	public void setXZL(String xZL) {
		XZL = xZL;
	}

	/**
	 * @return the sCJG
	 */
	public String getSCJG() {
		return SCJG;
	}

	/**
	 * @param sCJG
	 *            the sCJG to set
	 */
	public void setSCJG(String sCJG) {
		SCJG = sCJG;
	}

	/**
	 * @return the sCZJ
	 */
	public String getSCZJ() {
		return SCZJ;
	}

	/**
	 * @param sCZJ
	 *            the sCZJ to set
	 */
	public void setSCZJ(String sCZJ) {
		SCZJ = sCZJ;
	}

	/**
	 * @return the dJTZ
	 */
	public String getDJTZ() {
		return DJTZ;
	}

	/**
	 * @param dJTZ
	 *            the dJTZ to set
	 */
	public void setDJTZ(String dJTZ) {
		DJTZ = dJTZ;
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
	 * @return the sDRJL
	 */
	public String getSDRJL() {
		return SDRJL;
	}

	/**
	 * @param sDRJL
	 *            the sDRJL to set
	 */
	public void setSDRJL(String sDRJL) {
		SDRJL = sDRJL;
	}

	/**
	 * @return the sDSYNQ
	 */
	public String getSDSYNQ() {
		return SDSYNQ;
	}

	/**
	 * @param sDSYNQ
	 *            the sDSYNQ to set
	 */
	public void setSDSYNQ(String sDSYNQ) {
		SDSYNQ = sDSYNQ;
	}

	/**
	 * @return the sDKFSP
	 */
	public String getSDKFSP() {
		return SDKFSP;
	}

	/**
	 * @param sDKFSP
	 *            the sDKFSP to set
	 */
	public void setSDKFSP(String sDKFSP) {
		SDKFSP = sDKFSP;
	}

	/**
	 * @return the pGJG
	 */
	public String getPGJG() {
		return PGJG;
	}

	/**
	 * @param pGJG
	 *            the pGJG to set
	 */
	public void setPGJG(String pGJG) {
		PGJG = pGJG;
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
