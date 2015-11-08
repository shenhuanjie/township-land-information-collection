/**
 * 
 */
package com.example.town_land_collect.model.market_demand;

import java.io.Serializable;

import org.litepal.crud.DataSupport;

/**
 * @Title ModelCollectionMarketDemandSell.java
 * @Package com.example.town_land_collect.model.market_demand
 * @Description ����ʹ��Ȩ����������Ϣ
 * @author Shen.dev
 * @date 2015-10-14 ����6:00:01
 * @version V1.0
 */
public class ModelCollectionMarketDemandSell extends DataSupport implements Serializable {
	private static final long serialVersionUID = 1L;
	/** ������Ϣ **/
	private int ID;// ��Ǻ�
	private String THENAME;// ��¼����
	private String THECODE;// ��¼����

	/** ����ʹ��Ȩ����������Ϣ **/
	private String XQF;// ����
	private String XQFZTXZ;// ������������
	private String NTDZL;// ����������
	private String NQSXZ;// ��Ȩ������
	private String XQCRSJ;// �������ʱ��
	private String XQCRFS;// ������÷�ʽ
	private String NXQCRMJ;// ������������
	private String CRQYT;// ����ǰ��;
	private String NCRHYT;// ����ú���;
	private String XQCRNQ;// �����������
	private String GHRJL;// �滮�ڵ��ݻ���
	private String XQXZTDTJ;// ������״��������
	private String XQCRDJ;// ����λ������س��ü�
	private String XQCRZJ;// �������س����ܼ�
	private String NTZQD;// ��Ͷ��ǿ��
	private String NKFTZZE;// �⿪��Ͷ���ܶ�

	/** ������Ϣ **/
	private String TDJB;// �������ؼ���
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
	/** ���س���������Ϣ **/
	private int index_xqfztxz = 0;// ������������
	private int index_nqsxz = 0;// ��Ȩ������
	private int index_xqcrfs = 0;// ������÷�ʽ
	private int index_crqyt = 0;// ����ǰ��;
	private int index_ncrhyt = 0;// ����ú���;
	/** ������Ϣ.�ؼ� **/
	private int index_tdjb = 0;// �������ؼ���

	/**
	 * @return the index_xqfztxz
	 */
	public int getIndex_xqfztxz() {
		return index_xqfztxz;
	}

	/**
	 * @param index_xqfztxz
	 *            the index_xqfztxz to set
	 */
	public void setIndex_xqfztxz(int index_xqfztxz) {
		this.index_xqfztxz = index_xqfztxz;
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
	 * @return the index_xqcrfs
	 */
	public int getIndex_xqcrfs() {
		return index_xqcrfs;
	}

	/**
	 * @param index_xqcrfs
	 *            the index_xqcrfs to set
	 */
	public void setIndex_xqcrfs(int index_xqcrfs) {
		this.index_xqcrfs = index_xqcrfs;
	}

	/**
	 * @return the index_crqyt
	 */
	public int getIndex_crqyt() {
		return index_crqyt;
	}

	/**
	 * @param index_crqyt
	 *            the index_crqyt to set
	 */
	public void setIndex_crqyt(int index_crqyt) {
		this.index_crqyt = index_crqyt;
	}

	/**
	 * @return the index_ncrhyt
	 */
	public int getIndex_ncrhyt() {
		return index_ncrhyt;
	}

	/**
	 * @param index_ncrhyt
	 *            the index_ncrhyt to set
	 */
	public void setIndex_ncrhyt(int index_ncrhyt) {
		this.index_ncrhyt = index_ncrhyt;
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
	 * @return the xQF
	 */
	public String getXQF() {
		return XQF;
	}

	/**
	 * @param xQF
	 *            the xQF to set
	 */
	public void setXQF(String xQF) {
		XQF = xQF;
	}

	/**
	 * @return the xQFZTXZ
	 */
	public String getXQFZTXZ() {
		return XQFZTXZ;
	}

	/**
	 * @param xQFZTXZ
	 *            the xQFZTXZ to set
	 */
	public void setXQFZTXZ(String xQFZTXZ) {
		XQFZTXZ = xQFZTXZ;
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
	 * @return the xQCRSJ
	 */
	public String getXQCRSJ() {
		return XQCRSJ;
	}

	/**
	 * @param xQCRSJ
	 *            the xQCRSJ to set
	 */
	public void setXQCRSJ(String xQCRSJ) {
		XQCRSJ = xQCRSJ;
	}

	/**
	 * @return the xQCRFS
	 */
	public String getXQCRFS() {
		return XQCRFS;
	}

	/**
	 * @param xQCRFS
	 *            the xQCRFS to set
	 */
	public void setXQCRFS(String xQCRFS) {
		XQCRFS = xQCRFS;
	}

	/**
	 * @return the nXQCRMJ
	 */
	public String getNXQCRMJ() {
		return NXQCRMJ;
	}

	/**
	 * @param nXQCRMJ
	 *            the nXQCRMJ to set
	 */
	public void setNXQCRMJ(String nXQCRMJ) {
		NXQCRMJ = nXQCRMJ;
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
	 * @return the nCRHYT
	 */
	public String getNCRHYT() {
		return NCRHYT;
	}

	/**
	 * @param nCRHYT
	 *            the nCRHYT to set
	 */
	public void setNCRHYT(String nCRHYT) {
		NCRHYT = nCRHYT;
	}

	/**
	 * @return the xQCRNQ
	 */
	public String getXQCRNQ() {
		return XQCRNQ;
	}

	/**
	 * @param xQCRNQ
	 *            the xQCRNQ to set
	 */
	public void setXQCRNQ(String xQCRNQ) {
		XQCRNQ = xQCRNQ;
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
	 * @return the xQCRDJ
	 */
	public String getXQCRDJ() {
		return XQCRDJ;
	}

	/**
	 * @param xQCRDJ
	 *            the xQCRDJ to set
	 */
	public void setXQCRDJ(String xQCRDJ) {
		XQCRDJ = xQCRDJ;
	}

	/**
	 * @return the xQCRZJ
	 */
	public String getXQCRZJ() {
		return XQCRZJ;
	}

	/**
	 * @param xQCRZJ
	 *            the xQCRZJ to set
	 */
	public void setXQCRZJ(String xQCRZJ) {
		XQCRZJ = xQCRZJ;
	}

	/**
	 * @return the nTZQD
	 */
	public String getNTZQD() {
		return NTZQD;
	}

	/**
	 * @param nTZQD
	 *            the nTZQD to set
	 */
	public void setNTZQD(String nTZQD) {
		NTZQD = nTZQD;
	}

	/**
	 * @return the nKFTZZE
	 */
	public String getNKFTZZE() {
		return NKFTZZE;
	}

	/**
	 * @param nKFTZZE
	 *            the nKFTZZE to set
	 */
	public void setNKFTZZE(String nKFTZZE) {
		NKFTZZE = nKFTZZE;
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
