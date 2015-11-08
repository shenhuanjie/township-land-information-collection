/**
 * 
 */
package com.example.town_land_collect.model.market_monitor;

import java.io.Serializable;

import org.litepal.crud.DataSupport;

/**
 * @Title ModelCollectionMarketMonitorLandValue.java
 * @Package com.example.town_land_collect.model.market_monitor
 * @Description �ؼ�������Ϣ
 * @author Shen.dev
 * @date 2015-10-14 ����6:02:01
 * @version V1.0
 */
public class ModelCollectionMarketMonitorLandValue extends DataSupport implements Serializable {
	private static final long serialVersionUID = 1L;
	/** ������Ϣ **/
	private int ID;// ��Ǻ�
	private String THENAME;// ��¼����
	private String THECODE;// ��¼����

	/** �ؼ�������Ϣ **/
	private String BSM;// ��ʶ��
	private String QDBH;// ���α��
	private String QDMC;// ��������
	private String QDWZ;// ����λ��
	private String YTLX;// ҵ̬����
	private String TDJB;// ���ؼ���
	private String QDMJ;// �������
	private String XZQDM;
	private String SJYTMJ;// ʵ����;���
	private String QDJCSSZK;// ���λ�����ʩ״��
	private String QDGGSSZK;// ���ι���������ʩ״��
	private String DZ;// ����
	private String NZ;// ����
	private String XZ;// ����
	private String BZ;// ����
	private String QD;// �̷�·�����
	private String ZD;// �̷�·��ֹ��
	private String XZRJL;// ��״�ݻ���
	private String ZYSYLX;// ��Ҫ�̷�����
	private String JCNF;// ������ݼ�������״��
	private String XSZGZJ;// ��ʱ��������
	private String XSPJZJ;// ��ʱƽ�������
	private String XSZDZJ;// ��ʱ��������
	private String XSZGSJ;// ��ʱ����ۼ�
	private String XSPJSJ;// ��ʱƽ���ۼ�
	private String XSZDSJ;// ��ʱ����ۼ�
	private String JZR;// ������׼��
	private String SDNQ;// �趨����
	private String SDRJL;// �趨�ݻ���
	private String SDKFSP;// �趨����ˮƽ
	private String SYLXBZSD;// ��ҵ·�߱�׼���
	private String DMJZDJ;// �����׼�ؼ�
	private String LMJZDJ;// ¥���׼�ؼ�
	private String REMARK;// ��ע

	/** ϵͳ��Ϣ **/
	private String INPUTUSERID;// �����û�
	private String CREATETIME;// ����ʱ��
	private String LASTUPDATEUSERID;// �޸��û�
	private String UPDATETIME;// �޸�ʱ��
	private String ISDELETE;// �Ƿ�ɾ��
	private String SHOWSEQ;// ��ʾ˳��
	private int index_tdjb = 0;// ���ؼ���
	private int index_sdkfsp = 0;// �趨����ˮƽ

	/**
	 * @return the index_tdjb
	 */
	public int getIndex_tdjb() {
		return index_tdjb;
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
	 * @param index_tdjb
	 *            the index_tdjb to set
	 */
	public void setIndex_tdjb(int index_tdjb) {
		this.index_tdjb = index_tdjb;
	}

	/**
	 * @return the index_sdkfsp
	 */
	public int getIndex_sdkfsp() {
		return index_sdkfsp;
	}

	/**
	 * @param index_sdkfsp
	 *            the index_sdkfsp to set
	 */
	public void setIndex_sdkfsp(int index_sdkfsp) {
		this.index_sdkfsp = index_sdkfsp;
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
	 * @return the bSM
	 */
	public String getBSM() {
		return BSM;
	}

	/**
	 * @param bSM
	 *            the bSM to set
	 */
	public void setBSM(String bSM) {
		BSM = bSM;
	}

	/**
	 * @return the qDBH
	 */
	public String getQDBH() {
		return QDBH;
	}

	/**
	 * @param qDBH
	 *            the qDBH to set
	 */
	public void setQDBH(String qDBH) {
		QDBH = qDBH;
	}

	/**
	 * @return the qDMC
	 */
	public String getQDMC() {
		return QDMC;
	}

	/**
	 * @param qDMC
	 *            the qDMC to set
	 */
	public void setQDMC(String qDMC) {
		QDMC = qDMC;
	}

	/**
	 * @return the qDWZ
	 */
	public String getQDWZ() {
		return QDWZ;
	}

	/**
	 * @param qDWZ
	 *            the qDWZ to set
	 */
	public void setQDWZ(String qDWZ) {
		QDWZ = qDWZ;
	}

	/**
	 * @return the yTLX
	 */
	public String getYTLX() {
		return YTLX;
	}

	/**
	 * @param yTLX
	 *            the yTLX to set
	 */
	public void setYTLX(String yTLX) {
		YTLX = yTLX;
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
	 * @return the qDMJ
	 */
	public String getQDMJ() {
		return QDMJ;
	}

	/**
	 * @param qDMJ
	 *            the qDMJ to set
	 */
	public void setQDMJ(String qDMJ) {
		QDMJ = qDMJ;
	}

	/**
	 * @return the sJYTMJ
	 */
	public String getSJYTMJ() {
		return SJYTMJ;
	}

	/**
	 * @param sJYTMJ
	 *            the sJYTMJ to set
	 */
	public void setSJYTMJ(String sJYTMJ) {
		SJYTMJ = sJYTMJ;
	}

	/**
	 * @return the qDJCSSZK
	 */
	public String getQDJCSSZK() {
		return QDJCSSZK;
	}

	/**
	 * @param qDJCSSZK
	 *            the qDJCSSZK to set
	 */
	public void setQDJCSSZK(String qDJCSSZK) {
		QDJCSSZK = qDJCSSZK;
	}

	/**
	 * @return the qDGGSSZK
	 */
	public String getQDGGSSZK() {
		return QDGGSSZK;
	}

	/**
	 * @param qDGGSSZK
	 *            the qDGGSSZK to set
	 */
	public void setQDGGSSZK(String qDGGSSZK) {
		QDGGSSZK = qDGGSSZK;
	}

	/**
	 * @return the dZ
	 */
	public String getDZ() {
		return DZ;
	}

	/**
	 * @param dZ
	 *            the dZ to set
	 */
	public void setDZ(String dZ) {
		DZ = dZ;
	}

	/**
	 * @return the nZ
	 */
	public String getNZ() {
		return NZ;
	}

	/**
	 * @param nZ
	 *            the nZ to set
	 */
	public void setNZ(String nZ) {
		NZ = nZ;
	}

	/**
	 * @return the xZ
	 */
	public String getXZ() {
		return XZ;
	}

	/**
	 * @param xZ
	 *            the xZ to set
	 */
	public void setXZ(String xZ) {
		XZ = xZ;
	}

	/**
	 * @return the bZ
	 */
	public String getBZ() {
		return BZ;
	}

	/**
	 * @param bZ
	 *            the bZ to set
	 */
	public void setBZ(String bZ) {
		BZ = bZ;
	}

	/**
	 * @return the qD
	 */
	public String getQD() {
		return QD;
	}

	/**
	 * @param qD
	 *            the qD to set
	 */
	public void setQD(String qD) {
		QD = qD;
	}

	/**
	 * @return the zD
	 */
	public String getZD() {
		return ZD;
	}

	/**
	 * @param zD
	 *            the zD to set
	 */
	public void setZD(String zD) {
		ZD = zD;
	}

	/**
	 * @return the xZRJL
	 */
	public String getXZRJL() {
		return XZRJL;
	}

	/**
	 * @param xZRJL
	 *            the xZRJL to set
	 */
	public void setXZRJL(String xZRJL) {
		XZRJL = xZRJL;
	}

	/**
	 * @return the zYSYLX
	 */
	public String getZYSYLX() {
		return ZYSYLX;
	}

	/**
	 * @param zYSYLX
	 *            the zYSYLX to set
	 */
	public void setZYSYLX(String zYSYLX) {
		ZYSYLX = zYSYLX;
	}

	/**
	 * @return the jCNF
	 */
	public String getJCNF() {
		return JCNF;
	}

	/**
	 * @param jCNF
	 *            the jCNF to set
	 */
	public void setJCNF(String jCNF) {
		JCNF = jCNF;
	}

	/**
	 * @return the xSZGZJ
	 */
	public String getXSZGZJ() {
		return XSZGZJ;
	}

	/**
	 * @param xSZGZJ
	 *            the xSZGZJ to set
	 */
	public void setXSZGZJ(String xSZGZJ) {
		XSZGZJ = xSZGZJ;
	}

	/**
	 * @return the xSPJZJ
	 */
	public String getXSPJZJ() {
		return XSPJZJ;
	}

	/**
	 * @param xSPJZJ
	 *            the xSPJZJ to set
	 */
	public void setXSPJZJ(String xSPJZJ) {
		XSPJZJ = xSPJZJ;
	}

	/**
	 * @return the xSZDZJ
	 */
	public String getXSZDZJ() {
		return XSZDZJ;
	}

	/**
	 * @param xSZDZJ
	 *            the xSZDZJ to set
	 */
	public void setXSZDZJ(String xSZDZJ) {
		XSZDZJ = xSZDZJ;
	}

	/**
	 * @return the xSZGSJ
	 */
	public String getXSZGSJ() {
		return XSZGSJ;
	}

	/**
	 * @param xSZGSJ
	 *            the xSZGSJ to set
	 */
	public void setXSZGSJ(String xSZGSJ) {
		XSZGSJ = xSZGSJ;
	}

	/**
	 * @return the xSPJSJ
	 */
	public String getXSPJSJ() {
		return XSPJSJ;
	}

	/**
	 * @param xSPJSJ
	 *            the xSPJSJ to set
	 */
	public void setXSPJSJ(String xSPJSJ) {
		XSPJSJ = xSPJSJ;
	}

	/**
	 * @return the xSZDSJ
	 */
	public String getXSZDSJ() {
		return XSZDSJ;
	}

	/**
	 * @param xSZDSJ
	 *            the xSZDSJ to set
	 */
	public void setXSZDSJ(String xSZDSJ) {
		XSZDSJ = xSZDSJ;
	}

	/**
	 * @return the jZR
	 */
	public String getJZR() {
		return JZR;
	}

	/**
	 * @param jZR
	 *            the jZR to set
	 */
	public void setJZR(String jZR) {
		JZR = jZR;
	}

	/**
	 * @return the sDNQ
	 */
	public String getSDNQ() {
		return SDNQ;
	}

	/**
	 * @param sDNQ
	 *            the sDNQ to set
	 */
	public void setSDNQ(String sDNQ) {
		SDNQ = sDNQ;
	}

	/**
	 * @return the sDRJL
	 */
	public String getSDRJL() {
		return SDRJL;
	}

	/**
	 * @param sDRJL
	 *            the sDRJL to set
	 */
	public void setSDRJL(String sDRJL) {
		SDRJL = sDRJL;
	}

	/**
	 * @return the sDKFSP
	 */
	public String getSDKFSP() {
		return SDKFSP;
	}

	/**
	 * @param sDKFSP
	 *            the sDKFSP to set
	 */
	public void setSDKFSP(String sDKFSP) {
		SDKFSP = sDKFSP;
	}

	/**
	 * @return the sYLXBZSD
	 */
	public String getSYLXBZSD() {
		return SYLXBZSD;
	}

	/**
	 * @param sYLXBZSD
	 *            the sYLXBZSD to set
	 */
	public void setSYLXBZSD(String sYLXBZSD) {
		SYLXBZSD = sYLXBZSD;
	}

	/**
	 * @return the dMJZDJ
	 */
	public String getDMJZDJ() {
		return DMJZDJ;
	}

	/**
	 * @param dMJZDJ
	 *            the dMJZDJ to set
	 */
	public void setDMJZDJ(String dMJZDJ) {
		DMJZDJ = dMJZDJ;
	}

	/**
	 * @return the lMJZDJ
	 */
	public String getLMJZDJ() {
		return LMJZDJ;
	}

	/**
	 * @param lMJZDJ
	 *            the lMJZDJ to set
	 */
	public void setLMJZDJ(String lMJZDJ) {
		LMJZDJ = lMJZDJ;
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
