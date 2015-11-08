/**
 * 
 */
package com.example.town_land_collect.model.market_development;

import java.io.Serializable;

import org.litepal.crud.DataSupport;

/**
 * @Title ModelCollectionMarketDevelopmentVillage.java
 * @Package com.example.town_land_collect.model.market_development
 * @Description ��������ᾭ�÷�չ��Ϣ
 * @author Shen.dev
 * @date 2015-10-14 ����6:01:13
 * @version V1.0
 */
public class ModelCollectionMarketDevelopmentVillage extends DataSupport implements Serializable {
	private static final long serialVersionUID = 1L;
	/** ������Ϣ **/
	private int ID;// ��Ǻ�
	private String THENAME;// ��¼����
	private String THECODE;// ��¼����

	/** ��������ᾭ�÷�չ��Ϣ **/
	private String BH;// ���
	private String XZQDM;// ����������
	private String CZMC;// ��������
	private String DCND;// �������
	private String ZMJ;// �����
	private String GDMJ;// �������
	private String GYJSYDMJ;// ���н����õ����
	private String JTJSYDMJ;// ���彨���õ����
	private String ZJDMJ;// լ�������
	private String ZSTDMJ;// �����������
	private String LZTDMJ;// ��ת�������
	private String GYGYMJ;// �������ع�Ӧ���
	private String HBMJ;// �����������
	private String CRMJ;// �����������
	private String GYYDGYMJ;// ��ҵ�õع�Ӧ���
	private String JYXYDGYMJ;// ��Ӫ���õع�Ӧ���

	/** ������Ϣ **/
	private String ZHS;// �ܻ���
	private String ZRK;// ���˿�
	private String NYRK;// ũҵ�˿�
	private String FNYRK;// ��ũҵ�˿�
	private String WLRK;// �����˿�
	private String CZCYRYS;// �����ҵ��Ա��
	private String GDZCTZ;// �̶��ʲ�Ͷ��
	private String JCSSTZ;// ������ʩͶ��
	private String YCGDP;// ��һ��ҵ����ֵ
	private String ECGDP;// �ڶ���ҵ����ֵ
	private String SCGDP;// ������ҵ����ֵ
	private String GYZCZ;// ��ҵ�ܲ�ֵ
	private String NYZCZ;// ũҵ�ܲ�ֵ
	private String YBYSSR;// һ��Ԥ������
	private String SSSR;// ˰������
	private String CZRJKZPSR;// ��������˾���֧������
	private String NMRJCSR;// ũ���˾�������
	private String REMARK;// ��ע

	/** ϵͳ��Ϣ **/
	private String INPUTUSERID;// �����û�
	private String CREATETIME;// ����ʱ��
	private String LASTUPDATEUSERID;// �޸��û�
	private String UPDATETIME;// �޸�ʱ��
	private String ISDELETE;// �Ƿ�ɾ��
	private String SHOWSEQ;// ��ʾ˳��

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
	 * @return the cZMC
	 */
	public String getCZMC() {
		return CZMC;
	}

	/**
	 * @param cZMC
	 *            the cZMC to set
	 */
	public void setCZMC(String cZMC) {
		CZMC = cZMC;
	}

	/**
	 * @return the dCND
	 */
	public String getDCND() {
		return DCND;
	}

	/**
	 * @param dCND
	 *            the dCND to set
	 */
	public void setDCND(String dCND) {
		DCND = dCND;
	}

	/**
	 * @return the zMJ
	 */
	public String getZMJ() {
		return ZMJ;
	}

	/**
	 * @param zMJ
	 *            the zMJ to set
	 */
	public void setZMJ(String zMJ) {
		ZMJ = zMJ;
	}

	/**
	 * @return the gDMJ
	 */
	public String getGDMJ() {
		return GDMJ;
	}

	/**
	 * @param gDMJ
	 *            the gDMJ to set
	 */
	public void setGDMJ(String gDMJ) {
		GDMJ = gDMJ;
	}

	/**
	 * @return the gYJSYDMJ
	 */
	public String getGYJSYDMJ() {
		return GYJSYDMJ;
	}

	/**
	 * @param gYJSYDMJ
	 *            the gYJSYDMJ to set
	 */
	public void setGYJSYDMJ(String gYJSYDMJ) {
		GYJSYDMJ = gYJSYDMJ;
	}

	/**
	 * @return the jTJSYDMJ
	 */
	public String getJTJSYDMJ() {
		return JTJSYDMJ;
	}

	/**
	 * @param jTJSYDMJ
	 *            the jTJSYDMJ to set
	 */
	public void setJTJSYDMJ(String jTJSYDMJ) {
		JTJSYDMJ = jTJSYDMJ;
	}

	/**
	 * @return the zJDMJ
	 */
	public String getZJDMJ() {
		return ZJDMJ;
	}

	/**
	 * @param zJDMJ
	 *            the zJDMJ to set
	 */
	public void setZJDMJ(String zJDMJ) {
		ZJDMJ = zJDMJ;
	}

	/**
	 * @return the zSTDMJ
	 */
	public String getZSTDMJ() {
		return ZSTDMJ;
	}

	/**
	 * @param zSTDMJ
	 *            the zSTDMJ to set
	 */
	public void setZSTDMJ(String zSTDMJ) {
		ZSTDMJ = zSTDMJ;
	}

	/**
	 * @return the lZTDMJ
	 */
	public String getLZTDMJ() {
		return LZTDMJ;
	}

	/**
	 * @param lZTDMJ
	 *            the lZTDMJ to set
	 */
	public void setLZTDMJ(String lZTDMJ) {
		LZTDMJ = lZTDMJ;
	}

	/**
	 * @return the gYGYMJ
	 */
	public String getGYGYMJ() {
		return GYGYMJ;
	}

	/**
	 * @param gYGYMJ
	 *            the gYGYMJ to set
	 */
	public void setGYGYMJ(String gYGYMJ) {
		GYGYMJ = gYGYMJ;
	}

	/**
	 * @return the hBMJ
	 */
	public String getHBMJ() {
		return HBMJ;
	}

	/**
	 * @param hBMJ
	 *            the hBMJ to set
	 */
	public void setHBMJ(String hBMJ) {
		HBMJ = hBMJ;
	}

	/**
	 * @return the cRMJ
	 */
	public String getCRMJ() {
		return CRMJ;
	}

	/**
	 * @param cRMJ
	 *            the cRMJ to set
	 */
	public void setCRMJ(String cRMJ) {
		CRMJ = cRMJ;
	}

	/**
	 * @return the gYYDGYMJ
	 */
	public String getGYYDGYMJ() {
		return GYYDGYMJ;
	}

	/**
	 * @param gYYDGYMJ
	 *            the gYYDGYMJ to set
	 */
	public void setGYYDGYMJ(String gYYDGYMJ) {
		GYYDGYMJ = gYYDGYMJ;
	}

	/**
	 * @return the jYXYDGYMJ
	 */
	public String getJYXYDGYMJ() {
		return JYXYDGYMJ;
	}

	/**
	 * @param jYXYDGYMJ
	 *            the jYXYDGYMJ to set
	 */
	public void setJYXYDGYMJ(String jYXYDGYMJ) {
		JYXYDGYMJ = jYXYDGYMJ;
	}

	/**
	 * @return the zHS
	 */
	public String getZHS() {
		return ZHS;
	}

	/**
	 * @param zHS
	 *            the zHS to set
	 */
	public void setZHS(String zHS) {
		ZHS = zHS;
	}

	/**
	 * @return the zRK
	 */
	public String getZRK() {
		return ZRK;
	}

	/**
	 * @param zRK
	 *            the zRK to set
	 */
	public void setZRK(String zRK) {
		ZRK = zRK;
	}

	/**
	 * @return the nYRK
	 */
	public String getNYRK() {
		return NYRK;
	}

	/**
	 * @param nYRK
	 *            the nYRK to set
	 */
	public void setNYRK(String nYRK) {
		NYRK = nYRK;
	}

	/**
	 * @return the fNYRK
	 */
	public String getFNYRK() {
		return FNYRK;
	}

	/**
	 * @param fNYRK
	 *            the fNYRK to set
	 */
	public void setFNYRK(String fNYRK) {
		FNYRK = fNYRK;
	}

	/**
	 * @return the wLRK
	 */
	public String getWLRK() {
		return WLRK;
	}

	/**
	 * @param wLRK
	 *            the wLRK to set
	 */
	public void setWLRK(String wLRK) {
		WLRK = wLRK;
	}

	/**
	 * @return the cZCYRYS
	 */
	public String getCZCYRYS() {
		return CZCYRYS;
	}

	/**
	 * @param cZCYRYS
	 *            the cZCYRYS to set
	 */
	public void setCZCYRYS(String cZCYRYS) {
		CZCYRYS = cZCYRYS;
	}

	/**
	 * @return the gDZCTZ
	 */
	public String getGDZCTZ() {
		return GDZCTZ;
	}

	/**
	 * @param gDZCTZ
	 *            the gDZCTZ to set
	 */
	public void setGDZCTZ(String gDZCTZ) {
		GDZCTZ = gDZCTZ;
	}

	/**
	 * @return the jCSSTZ
	 */
	public String getJCSSTZ() {
		return JCSSTZ;
	}

	/**
	 * @param jCSSTZ
	 *            the jCSSTZ to set
	 */
	public void setJCSSTZ(String jCSSTZ) {
		JCSSTZ = jCSSTZ;
	}

	/**
	 * @return the yCGDP
	 */
	public String getYCGDP() {
		return YCGDP;
	}

	/**
	 * @param yCGDP
	 *            the yCGDP to set
	 */
	public void setYCGDP(String yCGDP) {
		YCGDP = yCGDP;
	}

	/**
	 * @return the eCGDP
	 */
	public String getECGDP() {
		return ECGDP;
	}

	/**
	 * @param eCGDP
	 *            the eCGDP to set
	 */
	public void setECGDP(String eCGDP) {
		ECGDP = eCGDP;
	}

	/**
	 * @return the sCGDP
	 */
	public String getSCGDP() {
		return SCGDP;
	}

	/**
	 * @param sCGDP
	 *            the sCGDP to set
	 */
	public void setSCGDP(String sCGDP) {
		SCGDP = sCGDP;
	}

	/**
	 * @return the gYZCZ
	 */
	public String getGYZCZ() {
		return GYZCZ;
	}

	/**
	 * @param gYZCZ
	 *            the gYZCZ to set
	 */
	public void setGYZCZ(String gYZCZ) {
		GYZCZ = gYZCZ;
	}

	/**
	 * @return the nYZCZ
	 */
	public String getNYZCZ() {
		return NYZCZ;
	}

	/**
	 * @param nYZCZ
	 *            the nYZCZ to set
	 */
	public void setNYZCZ(String nYZCZ) {
		NYZCZ = nYZCZ;
	}

	/**
	 * @return the yBYSSR
	 */
	public String getYBYSSR() {
		return YBYSSR;
	}

	/**
	 * @param yBYSSR
	 *            the yBYSSR to set
	 */
	public void setYBYSSR(String yBYSSR) {
		YBYSSR = yBYSSR;
	}

	/**
	 * @return the sSSR
	 */
	public String getSSSR() {
		return SSSR;
	}

	/**
	 * @param sSSR
	 *            the sSSR to set
	 */
	public void setSSSR(String sSSR) {
		SSSR = sSSR;
	}

	/**
	 * @return the cZRJKZPSR
	 */
	public String getCZRJKZPSR() {
		return CZRJKZPSR;
	}

	/**
	 * @param cZRJKZPSR
	 *            the cZRJKZPSR to set
	 */
	public void setCZRJKZPSR(String cZRJKZPSR) {
		CZRJKZPSR = cZRJKZPSR;
	}

	/**
	 * @return the nMRJCSR
	 */
	public String getNMRJCSR() {
		return NMRJCSR;
	}

	/**
	 * @param nMRJCSR
	 *            the nMRJCSR to set
	 */
	public void setNMRJCSR(String nMRJCSR) {
		NMRJCSR = nMRJCSR;
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
