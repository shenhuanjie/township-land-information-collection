/**
 * 
 */
package com.example.town_land_collect.model.market_redevelopment;

import java.io.Serializable;

import org.litepal.crud.DataSupport;

/**
 * @Title ModelCollectionMarketRedevelopmentImpose.java
 * @Package com.example.town_land_collect.model.market_redevelopment
 * @Description �ٿ���ʵʩ��Ŀ��Ϣ
 * @author Shen.dev
 * @date 2015-10-14 ����6:02:43
 * @version V1.0
 */
public class ModelCollectionMarketRedevelopmentImpose extends DataSupport implements Serializable {
	private static final long serialVersionUID = 1L;
	/** ������Ϣ **/
	private int ID;// ��Ǻ�
	private String THENAME;// ��¼����
	private String THECODE;// ��¼����

	/** �ٿ���ʵʩ��Ŀ��Ϣ **/
	private String BH;// ���
	private String XMMC;// ��Ŀ����
	private String XMLX;// ��Ŀ����
	private String TDZL;// ��������
	private String TDMJ;// �������
	private String RJL;// �ݻ���
	private String JZXS;// ����ϵ��
	private String JZMD;// �����ܶ�
	private String LVH;// �̻���
	private String KFMS;// ����ģʽ
	private String ZTZ;// ��Ͷ��
	private String ZJLY;// �ʽ���Դ
	private String GDFS;// ���ط�ʽ
	private String KFQYT;// ����ǰ��;
	private String KFHYT;// ��������;
	private String CYLX;// ��ҵ����
	private String QYZDCY;// ����������ҵ����
	private String QYGYJZDJ;// ������н����õػ�׼�ؼ�
	private String QYJTJZDJ;// �����彨���õػ�׼�ؼ�
	private String DJCZ;// �ؾ���ֵ
	private String DJSS;// �ؾ�˰��
	private String DJCYRY;// �ؾ���ҵ��Ա��

	/** ������Ϣ **/
	private String TDJB;// �������ؼ���
	private String DJQD;// ���ڵؼ�����
	private String XZQDM;// ����������
	private String REMARK;// ��ע

	/** ϵͳ��Ϣ **/
	private String INPUTUSERID;// �����û�
	private String CREATETIME;// ����ʱ��
	private String LASTUPDATEUSERID;// �޸��û�
	private String UPDATETIME;// �޸�ʱ��
	private String ISDELETE;// �Ƿ�ɾ��
	private String SHOWSEQ;// ��ʾ˳��
	/** �ٿ���ʵʩ��Ŀ��Ϣ **/
	private int index_xmlx = 0;// ��Ŀ����
	private int index_kfms = 0;// ����ģʽ
	private int index_zjly = 0;// �ʽ���Դ
	private int index_gdfs = 0;// ���ط�ʽ
	private int index_kfqyt = 0;// ����ǰ��;
	private int index_kfhyt = 0;// ��������;
	private int index_cylx = 0;// ��ҵ����
	private int index_qyzdcy = 0;// ����������ҵ����
	/** ������Ϣ.�ؼ� **/
	private int index_tdjb = 0;// �������ؼ���

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
