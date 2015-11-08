/**
 * 
 */
package com.example.town_land_collect.model.market_redevelopment;

import java.io.Serializable;

import org.litepal.crud.DataSupport;

/**
 * @Title ModelCollectionMarketRedevelopmentPlan.java
 * @Package com.example.town_land_collect.model.market_redevelopment
 * @Description �ٿ����ƻ���Ŀ��Ϣ
 * @author Shen.dev
 * @date 2015-10-14 ����6:02:57
 * @version V1.0
 */
public class ModelCollectionMarketRedevelopmentPlan extends DataSupport implements Serializable {
	private static final long serialVersionUID = 1L;
	/** ������Ϣ **/
	private int ID;// ��Ǻ�
	private String THENAME;// ��¼����
	private String THECODE;// ��¼����

	/** �ٿ����ƻ���Ŀ��Ϣ **/
	private String BH;// ���
	private String XMMC;// ��Ŀ����
	private String TDZL;// ��������
	private String TDSYZ;// ����������
	private String TDSHYZ;// ����ʹ����
	private String TDYT;// ������;
	private String TDMJ;// �������
	private String GHYT;// �滮��;
	private String GHRJL;// �滮�ݻ���
	private String GHJZXS;// �滮����ϵ��
	private String GHJZMD;// �滮�����ܶ�
	private String GHLVH;// �滮�̻���
	private String NKFMS;// �⿪��ģʽ
	private String YJZTZ;// Ԥ����Ͷ��
	private String ZJLY;// �ʽ���Դ
	private String NGDFS;// �⹩�ط�ʽ
	private String CYLX;// �滮��ҵ����
	private String QYZDCY;// ����������ҵ����
	private String QYGYJZDJ;// ������н����õػ�׼�ؼ�
	private String QYJTJZDJ;// �����彨���õػ�׼�ؼ�
	private String YJDJCZ;// Ԥ�Ƶؾ���ֵ
	private String YJDJSS;// Ԥ�Ƶؾ�˰��
	private String YJDJCYRY;// Ԥ�Ƶؾ���ҵ��Ա��
	private String QTYQYX;// ����Ԥ��ЧӦ
	private String ZFYY;// ������Ը
	private String KFSYY;// ��������Ը
	private String TDSYZYY;// ������������Ը
	private String TDSHYZYY;// ����ʹ������Ը

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
	/** �ٿ����ƻ���Ŀ��Ϣ **/
	private int index_tdyt = 0;// ������;
	private int index_ghyt = 0;// �滮��;
	private int index_nkfms = 0;// �⿪��ģʽ
	private int index_zjly = 0;// �ʽ���Դ
	private int index_ngdfs = 0;// �⹩�ط�ʽ
	private int index_cylx = 0;// �滮��ҵ����
	private int index_qyzdcy = 0;// ����������ҵ����
	/** ������Ϣ.�ؼ� **/
	private int index_tdjb = 0;// �������ؼ���

	/**
	 * @return the index_tdyt
	 */
	public int getIndex_tdyt() {
		return index_tdyt;
	}

	/**
	 * @param index_tdyt
	 *            the index_tdyt to set
	 */
	public void setIndex_tdyt(int index_tdyt) {
		this.index_tdyt = index_tdyt;
	}

	/**
	 * @return the index_ghyt
	 */
	public int getIndex_ghyt() {
		return index_ghyt;
	}

	/**
	 * @param index_ghyt
	 *            the index_ghyt to set
	 */
	public void setIndex_ghyt(int index_ghyt) {
		this.index_ghyt = index_ghyt;
	}

	/**
	 * @return the index_nkfms
	 */
	public int getIndex_nkfms() {
		return index_nkfms;
	}

	/**
	 * @param index_nkfms
	 *            the index_nkfms to set
	 */
	public void setIndex_nkfms(int index_nkfms) {
		this.index_nkfms = index_nkfms;
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
	 * @return the index_ngdfs
	 */
	public int getIndex_ngdfs() {
		return index_ngdfs;
	}

	/**
	 * @param index_ngdfs
	 *            the index_ngdfs to set
	 */
	public void setIndex_ngdfs(int index_ngdfs) {
		this.index_ngdfs = index_ngdfs;
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
	 * @return the gHYT
	 */
	public String getGHYT() {
		return GHYT;
	}

	/**
	 * @param gHYT
	 *            the gHYT to set
	 */
	public void setGHYT(String gHYT) {
		GHYT = gHYT;
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
	 * @return the gHJZXS
	 */
	public String getGHJZXS() {
		return GHJZXS;
	}

	/**
	 * @param gHJZXS
	 *            the gHJZXS to set
	 */
	public void setGHJZXS(String gHJZXS) {
		GHJZXS = gHJZXS;
	}

	/**
	 * @return the gHJZMD
	 */
	public String getGHJZMD() {
		return GHJZMD;
	}

	/**
	 * @param gHJZMD
	 *            the gHJZMD to set
	 */
	public void setGHJZMD(String gHJZMD) {
		GHJZMD = gHJZMD;
	}

	/**
	 * @return the gHLVH
	 */
	public String getGHLVH() {
		return GHLVH;
	}

	/**
	 * @param gHLVH
	 *            the gHLVH to set
	 */
	public void setGHLVH(String gHLVH) {
		GHLVH = gHLVH;
	}

	/**
	 * @return the nKFMS
	 */
	public String getNKFMS() {
		return NKFMS;
	}

	/**
	 * @param nKFMS
	 *            the nKFMS to set
	 */
	public void setNKFMS(String nKFMS) {
		NKFMS = nKFMS;
	}

	/**
	 * @return the yJZTZ
	 */
	public String getYJZTZ() {
		return YJZTZ;
	}

	/**
	 * @param yJZTZ
	 *            the yJZTZ to set
	 */
	public void setYJZTZ(String yJZTZ) {
		YJZTZ = yJZTZ;
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
	 * @return the nGDFS
	 */
	public String getNGDFS() {
		return NGDFS;
	}

	/**
	 * @param nGDFS
	 *            the nGDFS to set
	 */
	public void setNGDFS(String nGDFS) {
		NGDFS = nGDFS;
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
	 * @return the yJDJCZ
	 */
	public String getYJDJCZ() {
		return YJDJCZ;
	}

	/**
	 * @param yJDJCZ
	 *            the yJDJCZ to set
	 */
	public void setYJDJCZ(String yJDJCZ) {
		YJDJCZ = yJDJCZ;
	}

	/**
	 * @return the yJDJSS
	 */
	public String getYJDJSS() {
		return YJDJSS;
	}

	/**
	 * @param yJDJSS
	 *            the yJDJSS to set
	 */
	public void setYJDJSS(String yJDJSS) {
		YJDJSS = yJDJSS;
	}

	/**
	 * @return the yJDJCYRY
	 */
	public String getYJDJCYRY() {
		return YJDJCYRY;
	}

	/**
	 * @param yJDJCYRY
	 *            the yJDJCYRY to set
	 */
	public void setYJDJCYRY(String yJDJCYRY) {
		YJDJCYRY = yJDJCYRY;
	}

	/**
	 * @return the qTYQYX
	 */
	public String getQTYQYX() {
		return QTYQYX;
	}

	/**
	 * @param qTYQYX
	 *            the qTYQYX to set
	 */
	public void setQTYQYX(String qTYQYX) {
		QTYQYX = qTYQYX;
	}

	/**
	 * @return the zFYY
	 */
	public String getZFYY() {
		return ZFYY;
	}

	/**
	 * @param zFYY
	 *            the zFYY to set
	 */
	public void setZFYY(String zFYY) {
		ZFYY = zFYY;
	}

	/**
	 * @return the kFSYY
	 */
	public String getKFSYY() {
		return KFSYY;
	}

	/**
	 * @param kFSYY
	 *            the kFSYY to set
	 */
	public void setKFSYY(String kFSYY) {
		KFSYY = kFSYY;
	}

	/**
	 * @return the tDSYZYY
	 */
	public String getTDSYZYY() {
		return TDSYZYY;
	}

	/**
	 * @param tDSYZYY
	 *            the tDSYZYY to set
	 */
	public void setTDSYZYY(String tDSYZYY) {
		TDSYZYY = tDSYZYY;
	}

	/**
	 * @return the tDSHYZYY
	 */
	public String getTDSHYZYY() {
		return TDSHYZYY;
	}

	/**
	 * @param tDSHYZYY
	 *            the tDSHYZYY to set
	 */
	public void setTDSHYZYY(String tDSHYZYY) {
		TDSHYZYY = tDSHYZYY;
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
