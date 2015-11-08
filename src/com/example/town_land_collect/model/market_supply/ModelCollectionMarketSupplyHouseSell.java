/**
 * 
 */
package com.example.town_land_collect.model.market_supply;

import java.io.Serializable;

import org.litepal.crud.DataSupport;

/**
 * @Title ModelCollectionMarketSupplyHouseSell.java
 * @Package com.example.town_land_collect.model.market_supply
 * @Description ���س��۹�Ӧ��Ϣ
 * @author Shen.dev
 * @date 2015-10-14 ����6:04:02
 * @version V1.0
 */
public class ModelCollectionMarketSupplyHouseSell extends DataSupport implements Serializable {
	private static final long serialVersionUID = 1L;
	/** ������Ϣ **/
	private int ID;// ��Ǻ�
	private String THENAME;// ��¼����
	private String THECODE;// ��¼����

	/** ���س��۹�Ӧ��Ϣ **/
	private String TDSYZ;// ����ʹ����
	private String FWSYQR;// ��������Ȩ��
	private String TDZSH;// ����֤���
	private String YSZSH;// Ԥ��֤���
	private String TDZL;// ��������
	private String QSXZ;// Ȩ������
	private String FDSYNQ;// ����ʣ��ʹ������
	private String SFESF;// �Ƿ���ַ�
	private String SFZAJ;// �Ƿ�ת����
	private String CCZT;// ����״̬
	private String DYZT;// ��Ѻ״̬
	private String TDYT;// ������;
	private String LJKD;// �ٽֿ��
	private String LJSD;// �ٽ����
	private String JZLX;// ��������
	private String JZCS;// ��������
	private String FWJG;// ���ݽṹ
	private String JGSJ;// ����ʱ��
	private String FWCXD;// ���ݳ��¶�
	private String ZXSJ;// װ��ʱ��
	private String ZXCD;// װ�޳̶�
	private String ZZHX;// סլ����
	private String PTSS;// ������ʩ
	private String ZBJT;// �ܱ߽�ͨ
	private String NCSLC;// �����¥��
	private String NCSYT;// �������;
	private String NCSMJ;// ����۽������
	private String NCSSJ;// �����ʱ��
	private String NDWMJSJ;// �ⵥλ����ۼ�
	private String NSJ;// ���ۼ�
	private String NSF;// ��˰��

	/** ������Ϣ **/
	private String RJL;// �ݻ���
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

	private int index_qsxz = 0;// Ȩ������
	/** ���س��⹩Ӧ��Ϣ **/
	private int index_sfesf = 0;// �Ƿ���ַ�
	private int index_sfzaj = 0;// �Ƿ�ת����
	private int index_tdyt = 0;// ������;
	private int index_jzlx = 0;// ��������
	private int index_fwjg = 0;// ���ݽṹ
	private int index_fwcxd = 0;// ���ݳ��¶�
	private int index_zxcd = 0;// װ�޳̶�
	private int index_zzhx = 0;// סլ����
	private int index_ptss = 0;// ������ʩ
	private int index_ncsyt = 0;// �������;
	/** ������Ϣ **/
	private int index_hxwkfsp = 0;// �����⿪��ˮƽ
	private int index_hxnkfsp = 0;// �����ڿ���ˮƽ
	private int index_tdjb = 0;// �������ؼ���

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
	 * @return the fWSYQR
	 */
	public String getFWSYQR() {
		return FWSYQR;
	}

	/**
	 * @param fWSYQR
	 *            the fWSYQR to set
	 */
	public void setFWSYQR(String fWSYQR) {
		FWSYQR = fWSYQR;
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
	 * @return the ySZSH
	 */
	public String getYSZSH() {
		return YSZSH;
	}

	/**
	 * @param ySZSH
	 *            the ySZSH to set
	 */
	public void setYSZSH(String ySZSH) {
		YSZSH = ySZSH;
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
	 * @return the fDSYNQ
	 */
	public String getFDSYNQ() {
		return FDSYNQ;
	}

	/**
	 * @param fDSYNQ
	 *            the fDSYNQ to set
	 */
	public void setFDSYNQ(String fDSYNQ) {
		FDSYNQ = fDSYNQ;
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
	 * @return the sFZAJ
	 */
	public String getSFZAJ() {
		return SFZAJ;
	}

	/**
	 * @param sFZAJ
	 *            the sFZAJ to set
	 */
	public void setSFZAJ(String sFZAJ) {
		SFZAJ = sFZAJ;
	}

	/**
	 * @return the cCZT
	 */
	public String getCCZT() {
		return CCZT;
	}

	/**
	 * @param cCZT
	 *            the cCZT to set
	 */
	public void setCCZT(String cCZT) {
		CCZT = cCZT;
	}

	/**
	 * @return the dYZT
	 */
	public String getDYZT() {
		return DYZT;
	}

	/**
	 * @param dYZT
	 *            the dYZT to set
	 */
	public void setDYZT(String dYZT) {
		DYZT = dYZT;
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
	 * @return the lJKD
	 */
	public String getLJKD() {
		return LJKD;
	}

	/**
	 * @param lJKD
	 *            the lJKD to set
	 */
	public void setLJKD(String lJKD) {
		LJKD = lJKD;
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
	 * @return the jZLX
	 */
	public String getJZLX() {
		return JZLX;
	}

	/**
	 * @param jZLX
	 *            the jZLX to set
	 */
	public void setJZLX(String jZLX) {
		JZLX = jZLX;
	}

	/**
	 * @return the jZCS
	 */
	public String getJZCS() {
		return JZCS;
	}

	/**
	 * @param jZCS
	 *            the jZCS to set
	 */
	public void setJZCS(String jZCS) {
		JZCS = jZCS;
	}

	/**
	 * @return the fWJG
	 */
	public String getFWJG() {
		return FWJG;
	}

	/**
	 * @param fWJG
	 *            the fWJG to set
	 */
	public void setFWJG(String fWJG) {
		FWJG = fWJG;
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
	 * @return the fWCXD
	 */
	public String getFWCXD() {
		return FWCXD;
	}

	/**
	 * @param fWCXD
	 *            the fWCXD to set
	 */
	public void setFWCXD(String fWCXD) {
		FWCXD = fWCXD;
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
	 * @return the zXCD
	 */
	public String getZXCD() {
		return ZXCD;
	}

	/**
	 * @param zXCD
	 *            the zXCD to set
	 */
	public void setZXCD(String zXCD) {
		ZXCD = zXCD;
	}

	/**
	 * @return the zZHX
	 */
	public String getZZHX() {
		return ZZHX;
	}

	/**
	 * @param zZHX
	 *            the zZHX to set
	 */
	public void setZZHX(String zZHX) {
		ZZHX = zZHX;
	}

	/**
	 * @return the pTSS
	 */
	public String getPTSS() {
		return PTSS;
	}

	/**
	 * @param pTSS
	 *            the pTSS to set
	 */
	public void setPTSS(String pTSS) {
		PTSS = pTSS;
	}

	/**
	 * @return the zBJT
	 */
	public String getZBJT() {
		return ZBJT;
	}

	/**
	 * @param zBJT
	 *            the zBJT to set
	 */
	public void setZBJT(String zBJT) {
		ZBJT = zBJT;
	}

	/**
	 * @return the nCSLC
	 */
	public String getNCSLC() {
		return NCSLC;
	}

	/**
	 * @param nCSLC
	 *            the nCSLC to set
	 */
	public void setNCSLC(String nCSLC) {
		NCSLC = nCSLC;
	}

	/**
	 * @return the nCSYT
	 */
	public String getNCSYT() {
		return NCSYT;
	}

	/**
	 * @param nCSYT
	 *            the nCSYT to set
	 */
	public void setNCSYT(String nCSYT) {
		NCSYT = nCSYT;
	}

	/**
	 * @return the nCSMJ
	 */
	public String getNCSMJ() {
		return NCSMJ;
	}

	/**
	 * @param nCSMJ
	 *            the nCSMJ to set
	 */
	public void setNCSMJ(String nCSMJ) {
		NCSMJ = nCSMJ;
	}

	/**
	 * @return the nCSSJ
	 */
	public String getNCSSJ() {
		return NCSSJ;
	}

	/**
	 * @param nCSSJ
	 *            the nCSSJ to set
	 */
	public void setNCSSJ(String nCSSJ) {
		NCSSJ = nCSSJ;
	}

	/**
	 * @return the nDWMJSJ
	 */
	public String getNDWMJSJ() {
		return NDWMJSJ;
	}

	/**
	 * @param nDWMJSJ
	 *            the nDWMJSJ to set
	 */
	public void setNDWMJSJ(String nDWMJSJ) {
		NDWMJSJ = nDWMJSJ;
	}

	/**
	 * @return the nSJ
	 */
	public String getNSJ() {
		return NSJ;
	}

	/**
	 * @param nSJ
	 *            the nSJ to set
	 */
	public void setNSJ(String nSJ) {
		NSJ = nSJ;
	}

	/**
	 * @return the nSF
	 */
	public String getNSF() {
		return NSF;
	}

	/**
	 * @param nSF
	 *            the nSF to set
	 */
	public void setNSF(String nSF) {
		NSF = nSF;
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
	 * @return the index_qsxz
	 */
	public int getIndex_qsxz() {
		return index_qsxz;
	}

	/**
	 * @param index_qsxz
	 *            the index_qsxz to set
	 */
	public void setIndex_qsxz(int index_qsxz) {
		this.index_qsxz = index_qsxz;
	}

	/**
	 * @return the index_sfesf
	 */
	public int getIndex_sfesf() {
		return index_sfesf;
	}

	/**
	 * @param index_sfesf
	 *            the index_sfesf to set
	 */
	public void setIndex_sfesf(int index_sfesf) {
		this.index_sfesf = index_sfesf;
	}

	/**
	 * @return the index_sfzaj
	 */
	public int getIndex_sfzaj() {
		return index_sfzaj;
	}

	/**
	 * @param index_sfzaj
	 *            the index_sfzaj to set
	 */
	public void setIndex_sfzaj(int index_sfzaj) {
		this.index_sfzaj = index_sfzaj;
	}

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
	 * @return the index_jzlx
	 */
	public int getIndex_jzlx() {
		return index_jzlx;
	}

	/**
	 * @param index_jzlx
	 *            the index_jzlx to set
	 */
	public void setIndex_jzlx(int index_jzlx) {
		this.index_jzlx = index_jzlx;
	}

	/**
	 * @return the index_fwjg
	 */
	public int getIndex_fwjg() {
		return index_fwjg;
	}

	/**
	 * @param index_fwjg
	 *            the index_fwjg to set
	 */
	public void setIndex_fwjg(int index_fwjg) {
		this.index_fwjg = index_fwjg;
	}

	/**
	 * @return the index_fwcxd
	 */
	public int getIndex_fwcxd() {
		return index_fwcxd;
	}

	/**
	 * @param index_fwcxd
	 *            the index_fwcxd to set
	 */
	public void setIndex_fwcxd(int index_fwcxd) {
		this.index_fwcxd = index_fwcxd;
	}

	/**
	 * @return the index_zxcd
	 */
	public int getIndex_zxcd() {
		return index_zxcd;
	}

	/**
	 * @param index_zxcd
	 *            the index_zxcd to set
	 */
	public void setIndex_zxcd(int index_zxcd) {
		this.index_zxcd = index_zxcd;
	}

	/**
	 * @return the index_zzhx
	 */
	public int getIndex_zzhx() {
		return index_zzhx;
	}

	/**
	 * @param index_zzhx
	 *            the index_zzhx to set
	 */
	public void setIndex_zzhx(int index_zzhx) {
		this.index_zzhx = index_zzhx;
	}

	/**
	 * @return the index_ptss
	 */
	public int getIndex_ptss() {
		return index_ptss;
	}

	/**
	 * @param index_ptss
	 *            the index_ptss to set
	 */
	public void setIndex_ptss(int index_ptss) {
		this.index_ptss = index_ptss;
	}

	/**
	 * @return the index_ncsyt
	 */
	public int getIndex_ncsyt() {
		return index_ncsyt;
	}

	/**
	 * @param index_ncsyt
	 *            the index_ncsyt to set
	 */
	public void setIndex_ncsyt(int index_ncsyt) {
		this.index_ncsyt = index_ncsyt;
	}

	/**
	 * @return the index_hxwkfsp
	 */
	public int getIndex_hxwkfsp() {
		return index_hxwkfsp;
	}

	/**
	 * @param index_hxwkfsp
	 *            the index_hxwkfsp to set
	 */
	public void setIndex_hxwkfsp(int index_hxwkfsp) {
		this.index_hxwkfsp = index_hxwkfsp;
	}

	/**
	 * @return the index_hxnkfsp
	 */
	public int getIndex_hxnkfsp() {
		return index_hxnkfsp;
	}

	/**
	 * @param index_hxnkfsp
	 *            the index_hxnkfsp to set
	 */
	public void setIndex_hxnkfsp(int index_hxnkfsp) {
		this.index_hxnkfsp = index_hxnkfsp;
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

}
