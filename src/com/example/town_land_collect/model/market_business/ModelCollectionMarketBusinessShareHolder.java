package com.example.town_land_collect.model.market_business;

import java.io.Serializable;

import org.litepal.crud.DataSupport;

/**
 * 
 * @Title ModelCollectionMarketBusinessShareHolder.java
 * @Package com.example.town_land_collect.model.market_business
 * @Description ������Ӫ��ɽ�����Ϣ
 * @author Shen.dev
 * @date 2015-10-15 ����12:51:53
 * @version V1.0
 */
public class ModelCollectionMarketBusinessShareHolder extends DataSupport implements Serializable {
	private static final long serialVersionUID = 1L;
	/** ������Ϣ **/
	private int ID;// ��Ǻ�
	private String THENAME;// ��¼����
	private String THECODE;// ��¼����
	private String TDSYZ;// ����������
	private String TDZSH;// ����֤���
	private String TDZL;// ��������
	private String QSXZ;// Ȩ������

	/** ������Ӫ��ɽ�����Ϣ **/
	private String CDF;// ���ط�
	private String CZF;// ���ʷ�
	private String LYSJ;// ��Ӫʱ��
	private String LYQ;// ��Ӫ��
	private String CDMJ;// ���ط�Ͷ���������
	private String CZZE;// ���ʷ�Ͷ���ʽ��ܶ�
	private String CDFFCBL;// ���ط�����ֳɱ���
	private String TDNCSR;// ��λ��������괿����
	private String CDFNCSR;// ���ط������괿����
	private String LYQYT;// ��Ӫǰ��;
	private String LYHYT;// ��Ӫ����;

	/** ������Ϣ **/
	private String RJL;// �ڵ��ݻ���
	private String HXWKFSP;// �����⿪��ˮƽ
	private String HXNKFSP;// �����ڿ���ˮƽ
	private String TDJB;// �������ؼ���
	private String DJQD;// ���ڵؼ�����
	private String XZQDM;// ����������

	/** λ����Ϣ **/
	private String X;// X����
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

	private int INDEX_LYQYT;// ��Ӫǰ��;
	private int INDEX_LYHYT;// ��Ӫ����;

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
	 * @return the cZF
	 */
	public String getCZF() {
		return CZF;
	}

	/**
	 * @param cZF
	 *            the cZF to set
	 */
	public void setCZF(String cZF) {
		CZF = cZF;
	}

	/**
	 * @return the lYSJ
	 */
	public String getLYSJ() {
		return LYSJ;
	}

	/**
	 * @param lYSJ
	 *            the lYSJ to set
	 */
	public void setLYSJ(String lYSJ) {
		LYSJ = lYSJ;
	}

	/**
	 * @return the lYQ
	 */
	public String getLYQ() {
		return LYQ;
	}

	/**
	 * @param lYQ
	 *            the lYQ to set
	 */
	public void setLYQ(String lYQ) {
		LYQ = lYQ;
	}

	/**
	 * @return the cDMJ
	 */
	public String getCDMJ() {
		return CDMJ;
	}

	/**
	 * @param cDMJ
	 *            the cDMJ to set
	 */
	public void setCDMJ(String cDMJ) {
		CDMJ = cDMJ;
	}

	/**
	 * @return the cZZE
	 */
	public String getCZZE() {
		return CZZE;
	}

	/**
	 * @param cZZE
	 *            the cZZE to set
	 */
	public void setCZZE(String cZZE) {
		CZZE = cZZE;
	}

	/**
	 * @return the cDFFCBL
	 */
	public String getCDFFCBL() {
		return CDFFCBL;
	}

	/**
	 * @param cDFFCBL
	 *            the cDFFCBL to set
	 */
	public void setCDFFCBL(String cDFFCBL) {
		CDFFCBL = cDFFCBL;
	}

	/**
	 * @return the tDNCSR
	 */
	public String getTDNCSR() {
		return TDNCSR;
	}

	/**
	 * @param tDNCSR
	 *            the tDNCSR to set
	 */
	public void setTDNCSR(String tDNCSR) {
		TDNCSR = tDNCSR;
	}

	/**
	 * @return the cDFNCSR
	 */
	public String getCDFNCSR() {
		return CDFNCSR;
	}

	/**
	 * @param cDFNCSR
	 *            the cDFNCSR to set
	 */
	public void setCDFNCSR(String cDFNCSR) {
		CDFNCSR = cDFNCSR;
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
	 * @return the lYHYT
	 */
	public String getLYHYT() {
		return LYHYT;
	}

	/**
	 * @param lYHYT
	 *            the lYHYT to set
	 */
	public void setLYHYT(String lYHYT) {
		LYHYT = lYHYT;
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

	public int getINDEX_LYQYT() {
		return INDEX_LYQYT;
	}

	public void setINDEX_LYQYT(int iNDEX_LYQYT) {
		INDEX_LYQYT = iNDEX_LYQYT;
	}

	public int getINDEX_LYHYT() {
		return INDEX_LYHYT;
	}

	public void setINDEX_LYHYT(int iNDEX_LYHYT) {
		INDEX_LYHYT = iNDEX_LYHYT;
	}

}
