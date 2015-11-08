package com.example.town_land_collect.model.market_business;

import java.io.Serializable;

import org.litepal.crud.DataSupport;

/**
 * 
 * @Title ModelCollectionMarketBusinessSell.java
 * @Package com.example.town_land_collect.model.market_business
 * @Description ����ʹ��Ȩ���ý�����Ϣ
 * @author Shen.dev
 * @date 2015-10-15 ����12:46:54
 * @version V1.0
 */
public class ModelCollectionMarketBusinessSell extends DataSupport implements Serializable {
	private static final long serialVersionUID = 1L;
	/** ������Ϣ **/
	private int id;// ��Ǻ�
	private String THENAME;// ��¼����
	private String THECODE;// ��¼����
	private String TDSYZ;// ����������
	private String TDZSH;// ����֤���
	private String TDZL;// ��������
	private String QSXZ;// Ȩ������

	/** ����ʹ��Ȩ���ý�����Ϣ **/
	private String CRSJ;// ����ʱ��
	private String SRF;// ���÷�
	private String CRFS;// ���÷�ʽ
	private String SFZKF;// �Ƿ��ٿ���
	private String SFLYD;// �Ƿ����õ�
	private String GHTDMJ;// �滮���߷�Χ�������
	private String DZTDMJ;// �����������
	private String SJCRMJ;// ʵ�ʳ������
	private String CRQYT;// ����ǰ��;
	private String CRHYT;// ���ú���;
	private String CRNQ;// ��������
	private String CRDJ;// ��λ������س��ü�
	private String CRZJ;// ���س����ܼ�

	/** ������Ϣ **/
	private String RJL;// �ڵ��ݻ���
	private String HXWKFSP;// �����⿪��ˮƽ
	private String HXNKFSP;// �����ڿ���ˮƽ
	private String TDJB;// �������ؼ���
	private String DJQD;// ���ڵؼ�����
	private String XZQDM;// ����������

	/** λ����Ϣ **/
	private String X; // x����
	private String Y;// Y����
	private String ZBXT;// ����ϵͳ
	private String REMARK;// ��ע

	/** ϵͳ��Ϣ **/
	private String INPUTUSERID;// �����û�
	private String CREATETIME;// ����ʱ��
	private String LASTUPDATEUSERID;// �޸��û�
	private String UPDATETIME;// �޸�ʱ��
	private String ISDELETE;// �Ƿ�ɾ��
	private String SHOWSEQ;// ��ʾ˳��

	/** ����.�����ֶ� **/
	private int INDEX_QSXZ;
	private int INDEX_HXWKFSP;
	private int INDEX_HXNKFSP;
	private int INDEX_TDJB;
	private int INDEX_CRFS;// ���÷�ʽ
	private int INDEX_CRQYT;
	private int INDEX_CRHYT;
	private int INDEX_SFZKF;
	private int INDEX_SFLYD;

	public int getINDEX_SFZKF() {
		return INDEX_SFZKF;
	}

	public void setINDEX_SFZKF(int iNDEX_SFZKF) {
		INDEX_SFZKF = iNDEX_SFZKF;
	}

	public int getINDEX_SFLYD() {
		return INDEX_SFLYD;
	}

	public void setINDEX_SFLYD(int iNDEX_SFLYD) {
		INDEX_SFLYD = iNDEX_SFLYD;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	 * @return the cRSJ
	 */
	public String getCRSJ() {
		return CRSJ;
	}

	/**
	 * @param cRSJ
	 *            the cRSJ to set
	 */
	public void setCRSJ(String cRSJ) {
		CRSJ = cRSJ;
	}

	/**
	 * @return the sRF
	 */
	public String getSRF() {
		return SRF;
	}

	/**
	 * @param sRF
	 *            the sRF to set
	 */
	public void setSRF(String sRF) {
		SRF = sRF;
	}

	/**
	 * @return the cRFS
	 */
	public String getCRFS() {
		return CRFS;
	}

	/**
	 * @param cRFS
	 *            the cRFS to set
	 */
	public void setCRFS(String cRFS) {
		CRFS = cRFS;
	}

	/**
	 * @return the sFZKF
	 */
	public String getSFZKF() {
		return SFZKF;
	}

	/**
	 * @param sFZKF
	 *            the sFZKF to set
	 */
	public void setSFZKF(String sFZKF) {
		SFZKF = sFZKF;
	}

	/**
	 * @return the sFLYD
	 */
	public String getSFLYD() {
		return SFLYD;
	}

	/**
	 * @param sFLYD
	 *            the sFLYD to set
	 */
	public void setSFLYD(String sFLYD) {
		SFLYD = sFLYD;
	}

	/**
	 * @return the gHTDMJ
	 */
	public String getGHTDMJ() {
		return GHTDMJ;
	}

	/**
	 * @param gHTDMJ
	 *            the gHTDMJ to set
	 */
	public void setGHTDMJ(String gHTDMJ) {
		GHTDMJ = gHTDMJ;
	}

	/**
	 * @return the dZTDMJ
	 */
	public String getDZTDMJ() {
		return DZTDMJ;
	}

	/**
	 * @param dZTDMJ
	 *            the dZTDMJ to set
	 */
	public void setDZTDMJ(String dZTDMJ) {
		DZTDMJ = dZTDMJ;
	}

	/**
	 * @return the sJCRMJ
	 */
	public String getSJCRMJ() {
		return SJCRMJ;
	}

	/**
	 * @param sJCRMJ
	 *            the sJCRMJ to set
	 */
	public void setSJCRMJ(String sJCRMJ) {
		SJCRMJ = sJCRMJ;
	}

	/**
	 * @return the cRQYT
	 */
	public String getCRQYT() {
		return CRQYT;
	}

	/**
	 * @param cRQYT
	 *            the cRQYT to set
	 */
	public void setCRQYT(String cRQYT) {
		CRQYT = cRQYT;
	}

	/**
	 * @return the cRHYT
	 */
	public String getCRHYT() {
		return CRHYT;
	}

	/**
	 * @param cRHYT
	 *            the cRHYT to set
	 */
	public void setCRHYT(String cRHYT) {
		CRHYT = cRHYT;
	}

	/**
	 * @return the cRNQ
	 */
	public String getCRNQ() {
		return CRNQ;
	}

	/**
	 * @param cRNQ
	 *            the cRNQ to set
	 */
	public void setCRNQ(String cRNQ) {
		CRNQ = cRNQ;
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
	 * @return the cRDJ
	 */
	public String getCRDJ() {
		return CRDJ;
	}

	/**
	 * @param cRDJ
	 *            the cRDJ to set
	 */
	public void setCRDJ(String cRDJ) {
		CRDJ = cRDJ;
	}

	/**
	 * @return the cRZJ
	 */
	public String getCRZJ() {
		return CRZJ;
	}

	/**
	 * @param cRZJ
	 *            the cRZJ to set
	 */
	public void setCRZJ(String cRZJ) {
		CRZJ = cRZJ;
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

	/**
	 * @return the iNDEX_QSXZ
	 */
	public int getINDEX_QSXZ() {
		return INDEX_QSXZ;
	}

	/**
	 * @param iNDEX_QSXZ
	 *            the iNDEX_QSXZ to set
	 */
	public void setINDEX_QSXZ(int iNDEX_QSXZ) {
		INDEX_QSXZ = iNDEX_QSXZ;
	}

	/**
	 * @return the iNDEX_HXWKFSP
	 */
	public int getINDEX_HXWKFSP() {
		return INDEX_HXWKFSP;
	}

	/**
	 * @param iNDEX_HXWKFSP
	 *            the iNDEX_HXWKFSP to set
	 */
	public void setINDEX_HXWKFSP(int iNDEX_HXWKFSP) {
		INDEX_HXWKFSP = iNDEX_HXWKFSP;
	}

	/**
	 * @return the iNDEX_HXNKFSP
	 */
	public int getINDEX_HXNKFSP() {
		return INDEX_HXNKFSP;
	}

	/**
	 * @param iNDEX_HXNKFSP
	 *            the iNDEX_HXNKFSP to set
	 */
	public void setINDEX_HXNKFSP(int iNDEX_HXNKFSP) {
		INDEX_HXNKFSP = iNDEX_HXNKFSP;
	}

	/**
	 * @return the iNDEX_TDJB
	 */
	public int getINDEX_TDJB() {
		return INDEX_TDJB;
	}

	/**
	 * @param iNDEX_TDJB
	 *            the iNDEX_TDJB to set
	 */
	public void setINDEX_TDJB(int iNDEX_TDJB) {
		INDEX_TDJB = iNDEX_TDJB;
	}

	public int getINDEX_CRFS() {
		return INDEX_CRFS;
	}

	public void setINDEX_CRFS(int iNDEX_CRFS) {
		INDEX_CRFS = iNDEX_CRFS;
	}

	public int getINDEX_CRQYT() {
		return INDEX_CRQYT;
	}

	public void setINDEX_CRQYT(int iNDEX_CRQYT) {
		INDEX_CRQYT = iNDEX_CRQYT;
	}

	public int getINDEX_CRHYT() {
		return INDEX_CRHYT;
	}

	public void setINDEX_CRHYT(int iNDEX_CRHYT) {
		INDEX_CRHYT = iNDEX_CRHYT;
	}

}
