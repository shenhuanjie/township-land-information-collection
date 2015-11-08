package com.example.town_land_collect.model.market_business;

import java.io.Serializable;

import org.litepal.crud.DataSupport;

/**
 * 
 * @Title ModelCollectionMarketBusinessHouseRent.java
 * @Package com.example.town_land_collect.model.market_business
 * @Description ���س��⽻����Ϣ
 * @author Shen.dev
 * @date 2015-10-15 ����12:04:10
 * @version V1.0
 */
public class ModelCollectionMarketBusinessHouseRent extends DataSupport implements Serializable {
	private static final long serialVersionUID = 1L;
	/** ������Ϣ **/
	private int ID;// ��Ǻ�
	private String THENAME;// ��¼����
	private String THECODE;// ��¼����
	private String TDSYZ;// ����ʹ����
	private String TDZSH;// ����֤���
	private String TDZL;// ��������
	private String QSXZ;// Ȩ������

	/** ���س��⽻����Ϣ **/
	private String FWSYQR;// ��������Ȩ��
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
	private String CZLC;// ����¥��
	private String CZYT;// ������;
	private String CZMJ;// ���⽨�����
	private String CZSJ;// ����ʱ��
	private String ZQ;// ���ڣ��꣩
	private String NZJ;// �����
	private String YJ;// Ѻ��
	private String SF;// ˰��

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

	/** ����.�����ֶ� **/
	private int INDEX_QSXZ;
	private int INDEX_TDYT;
	private int INDEX_JZLX;
	private int INDEX_FWJG;
	private int INDEX_FWCXD;
	private int INDEX_ZXCD;
	private int INDEX_CZYT;
	private int INDEX_HXWKFSP;
	private int INDEX_HXNKFSP;
	private int INDEX_TDJB;

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
	 * @return the cZLC
	 */
	public String getCZLC() {
		return CZLC;
	}

	/**
	 * @param cZLC
	 *            the cZLC to set
	 */
	public void setCZLC(String cZLC) {
		CZLC = cZLC;
	}

	/**
	 * @return the cZYT
	 */
	public String getCZYT() {
		return CZYT;
	}

	/**
	 * @param cZYT
	 *            the cZYT to set
	 */
	public void setCZYT(String cZYT) {
		CZYT = cZYT;
	}

	/**
	 * @return the cZMJ
	 */
	public String getCZMJ() {
		return CZMJ;
	}

	/**
	 * @param cZMJ
	 *            the cZMJ to set
	 */
	public void setCZMJ(String cZMJ) {
		CZMJ = cZMJ;
	}

	/**
	 * @return the cZSJ
	 */
	public String getCZSJ() {
		return CZSJ;
	}

	/**
	 * @param cZSJ
	 *            the cZSJ to set
	 */
	public void setCZSJ(String cZSJ) {
		CZSJ = cZSJ;
	}

	/**
	 * @return the zQ
	 */
	public String getZQ() {
		return ZQ;
	}

	/**
	 * @param zQ
	 *            the zQ to set
	 */
	public void setZQ(String zQ) {
		ZQ = zQ;
	}

	/**
	 * @return the nZJ
	 */
	public String getNZJ() {
		return NZJ;
	}

	/**
	 * @param nZJ
	 *            the nZJ to set
	 */
	public void setNZJ(String nZJ) {
		NZJ = nZJ;
	}

	/**
	 * @return the yJ
	 */
	public String getYJ() {
		return YJ;
	}

	/**
	 * @param yJ
	 *            the yJ to set
	 */
	public void setYJ(String yJ) {
		YJ = yJ;
	}

	/**
	 * @return the sF
	 */
	public String getSF() {
		return SF;
	}

	/**
	 * @param sF
	 *            the sF to set
	 */
	public void setSF(String sF) {
		SF = sF;
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
	 * @return the iNDEX_TDYT
	 */
	public int getINDEX_TDYT() {
		return INDEX_TDYT;
	}

	/**
	 * @param iNDEX_TDYT
	 *            the iNDEX_TDYT to set
	 */
	public void setINDEX_TDYT(int iNDEX_TDYT) {
		INDEX_TDYT = iNDEX_TDYT;
	}

	/**
	 * @return the iNDEX_JZLX
	 */
	public int getINDEX_JZLX() {
		return INDEX_JZLX;
	}

	/**
	 * @param iNDEX_JZLX
	 *            the iNDEX_JZLX to set
	 */
	public void setINDEX_JZLX(int iNDEX_JZLX) {
		INDEX_JZLX = iNDEX_JZLX;
	}

	/**
	 * @return the iNDEX_FWJG
	 */
	public int getINDEX_FWJG() {
		return INDEX_FWJG;
	}

	/**
	 * @param iNDEX_FWJG
	 *            the iNDEX_FWJG to set
	 */
	public void setINDEX_FWJG(int iNDEX_FWJG) {
		INDEX_FWJG = iNDEX_FWJG;
	}

	/**
	 * @return the iNDEX_FWCXD
	 */
	public int getINDEX_FWCXD() {
		return INDEX_FWCXD;
	}

	/**
	 * @param iNDEX_FWCXD
	 *            the iNDEX_FWCXD to set
	 */
	public void setINDEX_FWCXD(int iNDEX_FWCXD) {
		INDEX_FWCXD = iNDEX_FWCXD;
	}

	/**
	 * @return the iNDEX_ZXCD
	 */
	public int getINDEX_ZXCD() {
		return INDEX_ZXCD;
	}

	/**
	 * @param iNDEX_ZXCD
	 *            the iNDEX_ZXCD to set
	 */
	public void setINDEX_ZXCD(int iNDEX_ZXCD) {
		INDEX_ZXCD = iNDEX_ZXCD;
	}

	/**
	 * @return the iNDEX_CZYT
	 */
	public int getINDEX_CZYT() {
		return INDEX_CZYT;
	}

	/**
	 * @param iNDEX_CZYT
	 *            the iNDEX_CZYT to set
	 */
	public void setINDEX_CZYT(int iNDEX_CZYT) {
		INDEX_CZYT = iNDEX_CZYT;
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

}
