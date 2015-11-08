/**
 * 
 */
package com.example.town_land_collect.model.market_demand;

import java.io.Serializable;

import org.litepal.crud.DataSupport;

/**
 * @Title ModelCollectionMarketDemandShareHolder.java
 * @Package com.example.town_land_collect.model.market_demand
 * @Description ������Ӫ���������Ϣ
 * @author Shen.dev
 * @date 2015-10-14 ����6:00:14
 * @version V1.0
 */
public class ModelCollectionMarketDemandShareHolder extends DataSupport implements Serializable {
	private static final long serialVersionUID = 1L;
	/** ������Ϣ **/
	private int ID;// ��Ǻ�
	private String THENAME;// ��¼����
	private String THECODE;// ��¼����

	/** ������Ӫ���������Ϣ **/
	private String XQCZF;// ������ʷ�
	private String XQCZFZTXZ;// ������ʷ���������
	private String NTDZL;// ����������
	private String NQSXZ;// ��Ȩ������
	private String XQXZTDTJ;// ������״��������
	private String XQLYSJ;// ������Ӫʱ��
	private String XQLYQ;// ������Ӫ��
	private String XQCDMJ;// ������ط�Ͷ���������
	private String XQCZZE;// ������ʷ�Ͷ���ʽ��ܶ�
	private String XQCDFFCBL;// ������ط�����ֳɱ���
	private String NTDNCSR;// �ⵥλ��������괿����
	private String NCDFNCSR;// ����ط������괿����
	private String LYQYT;// ��Ӫǰ��;
	private String NLYHYT;// ����Ӫ����;

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
	/** ������Ӫ���������Ϣ **/
	private int index_xqczfztxz;// ������ʷ���������
	private int index_lyqyt;// ��Ӫǰ��;
	private int index_nlyhyt;// ����Ӫ����;
	/** ������Ϣ.�ؼ� **/
	private int index_nqsxz;// ��Ȩ������

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

	private int index_tdjb = 0;// �������ؼ���

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
