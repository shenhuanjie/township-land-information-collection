/**
 * 
 */
package com.example.town_land_collect.model.market_demand;

import java.io.Serializable;

import org.litepal.crud.DataSupport;

/**
 * @Title ModelCollectionMarketDemand.java
 * @Package com.example.town_land_collect.model.market_demand
 * @Description ���س���������Ϣ
 * @author Shen.dev
 * @date 2015-10-14 ����5:57:34
 * @version V1.0
 */
public class ModelCollectionMarketDemandHouseRent extends DataSupport implements Serializable {
	private static final long serialVersionUID = 1L;
	/** ������Ϣ **/
	private int ID;// ��Ǻ�
	private String THENAME;// ��¼����
	private String THECODE;// ��¼����

	/** ���س���������Ϣ **/
	private String XQCZF;// ������ⷽ
	private String NTDZL;// ����������
	private String NQSXZ;// ��Ȩ������
	private String TDSYNQ;// ����ʣ��ʹ������
	private String NTDYT;// ��������;
	private String XQRJL;// �����ݻ���
	private String XQLJKD;// �����ٽֿ��
	private String LJSD;// �ٽ����
	private String XQJZLX;// ����������
	private String XQJZCS;// ����������
	private String XQFWJG;// �����ݽṹ
	private String JGSJ;// ����ʱ��
	private String XQFWCXD;// �����ݳ��¶�
	private String ZXSJ;// װ��ʱ��
	private String XQZXCD;// ����װ�޳̶�
	private String XQCZLC;// �������¥��
	private String XQCZYT;// ���������;
	private String XQCZMJ;// ������⽨�����
	private String XQCZSJ;// �������ʱ��
	private String XQZQ;// �������ڣ��꣩
	private String XQHX;// ����סլ����
	private String XQPTSS;// ����������ʩ
	private String XQZBJT;// �����ܱ߽�ͨ
	private String XQNZJ;// ���������
	private String NYJ;// ��Ѻ��

	/** ������Ϣ **/
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
	/** ������Ϣ.�ؼ� **/
	private int index_nqsxz = 0;// ��Ȩ������
	private int index_ntdyt = 0;// ��������;
	private int index_xqjzlx = 0;// ����������
	private int index_xqfwjg = 0;// �����ݽṹ
	private int index_xqfwcxd = 0;// �����ݳ��¶�
	private int index_xqzxcd = 0;// ����װ�޳̶�
	private int index_xqczyt = 0;// ���������;
	private int index_xqhx = 0;// ����סլ����
	private int index_xqptss = 0;// ����������ʩ
	/** ������Ϣ.�ؼ� **/
	private int index_tdjb = 0;// �������ؼ���

	public int getIndex_nqsxz() {
		return index_nqsxz;
	}

	public void setIndex_nqsxz(int index_nqsxz) {
		this.index_nqsxz = index_nqsxz;
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

	public int getIndex_xqczyt() {
		return index_xqczyt;
	}

	public void setIndex_xqczyt(int index_xqczyt) {
		this.index_xqczyt = index_xqczyt;
	}

	public int getIndex_xqhx() {
		return index_xqhx;
	}

	public void setIndex_xqhx(int index_xqhx) {
		this.index_xqhx = index_xqhx;
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
	 * @return the lJSD
	 */
	public String getLJSD() {
		return LJSD;
	}

	/**
	 * @param lJSD
	 *            the lJSD to set
	 */
	public void setLJSD(String lJSD) {
		LJSD = lJSD;
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
	 * @return the jGSJ
	 */
	public String getJGSJ() {
		return JGSJ;
	}

	/**
	 * @param jGSJ
	 *            the jGSJ to set
	 */
	public void setJGSJ(String jGSJ) {
		JGSJ = jGSJ;
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
	 * @return the zXSJ
	 */
	public String getZXSJ() {
		return ZXSJ;
	}

	/**
	 * @param zXSJ
	 *            the zXSJ to set
	 */
	public void setZXSJ(String zXSJ) {
		ZXSJ = zXSJ;
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
	 * @return the xQCZLC
	 */
	public String getXQCZLC() {
		return XQCZLC;
	}

	/**
	 * @param xQCZLC
	 *            the xQCZLC to set
	 */
	public void setXQCZLC(String xQCZLC) {
		XQCZLC = xQCZLC;
	}

	/**
	 * @return the xQCZYT
	 */
	public String getXQCZYT() {
		return XQCZYT;
	}

	/**
	 * @param xQCZYT
	 *            the xQCZYT to set
	 */
	public void setXQCZYT(String xQCZYT) {
		XQCZYT = xQCZYT;
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
	 * @return the xQHX
	 */
	public String getXQHX() {
		return XQHX;
	}

	/**
	 * @param xQHX
	 *            the xQHX to set
	 */
	public void setXQHX(String xQHX) {
		XQHX = xQHX;
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
