package com.example.town_land_collect.commom;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.litepal.crud.DataSupport;

import rmobile.platform.http.AsyncHttpClient;
import rmobile.platform.http.AsyncHttpResponseHandler;
import rmobile.platform.http.RSyncHttpClient;
import android.content.Context;
import android.graphics.Bitmap;

import com.example.town_land_collect.commom.basic.Common;
import com.example.town_land_collect.commom.basic.MyWebService;
import com.example.town_land_collect.model.AttachmentEntity;
import com.example.town_land_collect.model.LocationInfo;
import com.example.town_land_collect.model.market_business.ModelCollectionMarketBusinessHouseRent;
import com.example.town_land_collect.model.market_business.ModelCollectionMarketBusinessHouseSell;
import com.example.town_land_collect.model.market_business.ModelCollectionMarketBusinessRentOut;
import com.example.town_land_collect.model.market_business.ModelCollectionMarketBusinessSell;
import com.example.town_land_collect.model.market_business.ModelCollectionMarketBusinessShareHolder;
import com.example.town_land_collect.model.market_business.ModelCollectionMarketBusinessTransfer;
import com.example.town_land_collect.model.market_demand.ModelCollectionMarketDemandHouseRent;
import com.example.town_land_collect.model.market_demand.ModelCollectionMarketDemandHouseSell;
import com.example.town_land_collect.model.market_demand.ModelCollectionMarketDemandRent;
import com.example.town_land_collect.model.market_demand.ModelCollectionMarketDemandSell;
import com.example.town_land_collect.model.market_demand.ModelCollectionMarketDemandShareHolder;
import com.example.town_land_collect.model.market_demand.ModelCollectionMarketDemandTransfer;
import com.example.town_land_collect.model.market_development.ModelCollectionMarketDevelopmentTownship;
import com.example.town_land_collect.model.market_development.ModelCollectionMarketDevelopmentVillage;
import com.example.town_land_collect.model.market_monitor.ModelCollectionMarketMonitorLandLevel;
import com.example.town_land_collect.model.market_monitor.ModelCollectionMarketMonitorLandValue;
import com.example.town_land_collect.model.market_monitor.ModelCollectionMarketMonitorPoint;
import com.example.town_land_collect.model.market_redevelopment.ModelCollectionMarketRedevelopmentImpose;
import com.example.town_land_collect.model.market_redevelopment.ModelCollectionMarketRedevelopmentPlan;
import com.example.town_land_collect.model.market_supply.ModelCollectionMarketSupplyHouseRent;
import com.example.town_land_collect.model.market_supply.ModelCollectionMarketSupplyHouseSell;
import com.example.town_land_collect.model.market_supply.ModelCollectionMarketSupplyRent;
import com.example.town_land_collect.model.market_supply.ModelCollectionMarketSupplySell;
import com.example.town_land_collect.model.market_supply.ModelCollectionMarketSupplyShareHolder;
import com.example.town_land_collect.model.market_supply.ModelCollectionMarketSupplyTransfer;
import com.example.town_land_collect.util.CollectType;
import com.example.town_land_collect.util.PictureUtil;

public class WebService extends MyWebService {
	Common common = new Common();

	public WebService(Context context) {
		super(context);

		this.setAsyncHttpClient(new AsyncHttpClient());
		this.setSyncHttpClient(new RSyncHttpClient());

	}

	public static String captureName(String name) {
		name = name.substring(0, 1).toUpperCase() + name.substring(1);
		return name;

	}

	public void getButtonItemList(String year, String month, String sourceType, String contentType, AsyncHttpResponseHandler handler) {
		List<NameValuePair> paramsList = new ArrayList<NameValuePair>();
		// paramsList.add(setNameValuePair("year", Common.bindString(year))));
		// paramsList.add(setNameValuePair("month", Common.bindString(month)));
		// paramsList.add(setNameValuePair("sourceType",
		// Common.bindString(sourceType)));
		// paramsList.add(setNameValuePair("contentType",
		// Common.bindString(contentType)));
		asynPost("mAppraisal", "getButtonItemDataList", paramsList, handler);
	}

	public void uploadRecordList(LocationInfo info, AsyncHttpResponseHandler handler) {
		try {
			List<NameValuePair> paramsList = setParamsList(info);
			asynPost(info.getCollectionTableName(), "AddOrUpdate", paramsList, handler);
		} catch (Exception ex) {
			handler.onFailure(ex);
		}
	}

	public void uploadImageList(AttachmentEntity info, AsyncHttpResponseHandler handler) {
		try {
			List<NameValuePair> paramsList = setParamsImageList(info);
			asynPost("Attachment", "UploadPic", paramsList, handler);
		} catch (Exception ex) {
			handler.onFailure(ex);
		}
	}

	private List<NameValuePair> setParamsImageList(AttachmentEntity info) {
		List<NameValuePair> paramsList = new ArrayList<NameValuePair>();
		LocationInfo locationInfo = DataSupport.find(LocationInfo.class, info.getObjId());
		String tablename = locationInfo.getCollectionTableName();
		/** ���ݱ�����,���촫����� **/
		paramsList.add(setNameValuePair("tableName", tablename));
		paramsList.add(setNameValuePair("id", locationInfo.getUploadId() + ""));
		// ѹ��ͼƬ�����������ϴ�������
		Bitmap camorabitmap = PictureUtil.getSmallUploadBitmap(info.getImageUri());

		paramsList.add(setNameValuePair("img64Str", Common.bitmapToBase64(camorabitmap)));
		return paramsList;
	}

	private List<NameValuePair> setParamsList(LocationInfo info) {
		List<NameValuePair> paramsList = new ArrayList<NameValuePair>();
		int mainType = info.getCollectionMainType();
		/** ���ݱ�����,���촫����� **/
		// ��������ֶ�
		if (mainType == CollectType.Business) {
			setBusinessParams(info, paramsList);
		} else if (mainType == CollectType.Demand) {
			setDemandParams(info, paramsList);
		} else if (mainType == CollectType.Monitor) {
			setMonitorParams(info, paramsList);
		} else if (mainType == CollectType.Supply) {
			setSupplyParams(info, paramsList);
		} else if (mainType == CollectType.Redevelopment) {
			setRedevelopmentParams(info, paramsList);
		} else if (mainType == CollectType.Development) {
			setDevelopmentParams(info, paramsList);
		}

		return paramsList;
	}

	private void setBusinessParams(LocationInfo info, List<NameValuePair> paramsList) {
		if (info.getCollectionTableName().equals(CollectType.Collection_Market_Business_House_Rent_Tablename)) {
			setModelCollectionMarketBusinessHouseRent(info, paramsList);
		} else if (info.getCollectionTableName().equals(CollectType.Collection_Market_Business_House_Sell_Tablename)) {
			setModelCollectionMarketBusinessHouseSell(info, paramsList);
		} else if (info.getCollectionTableName().equals(CollectType.Collection_Market_Business_Rent_Out_Tablename)) {
			setModelCollectionMarketBusinessRentOut(info, paramsList);
		} else if (info.getCollectionTableName().equals(CollectType.Collection_Market_Business_Sell_Tablename)) {
			setModelCollectionMarketBusinessSell(info, paramsList);
		} else if (info.getCollectionTableName().equals(CollectType.Collection_Market_Business_ShareHolder_Tablename)) {
			setModelCollectionMarketBusinessShareHolder(info, paramsList);
		} else if (info.getCollectionTableName().equals(CollectType.Collection_Market_Business_Transfer_Tablename)) {// TODO
			setModelCollectionMarketBusinessTransfer(info, paramsList);
		}
	}

	private void setDemandParams(LocationInfo info, List<NameValuePair> paramsList) {
		if (info.getCollectionTableName().equals(CollectType.Collection_Market_Demand_House_Rent_Tablename)) {
			setModelCollectionMarketDemandHouseRent(info, paramsList);
		} else if (info.getCollectionTableName().equals(CollectType.Collection_Market_Demand_House_Sell_Tablename)) {
			setModelCollectionMarketDemandHouseSell(info, paramsList);
		} else if (info.getCollectionTableName().equals(CollectType.Collection_Market_Demand_Rent_Tablename)) {
			setModelCollectionMarketDemandRent(info, paramsList);
		} else if (info.getCollectionTableName().equals(CollectType.Collection_Market_Demand_Sell_Tablename)) {
			setModelCollectionMarketDemandSell(info, paramsList);
		} else if (info.getCollectionTableName().equals(CollectType.Collection_Market_Demand_ShareHolder_Tablename)) {
			setModelCollectionMarketDemandShareHolder(info, paramsList);
		} else if (info.getCollectionTableName().equals(CollectType.Collection_Market_Demand_Transfer_Tablename)) {
			setModelCollectionMarketDemandTransfer(info, paramsList);
		}
	}

	// �ֱ������ֶ�
	private void setDevelopmentParams(LocationInfo info, List<NameValuePair> paramsList) {
		if (info.getCollectionTableName().equals(CollectType.Collection_Market_Development_Township_Tablename)) {
			setModelCollectionMarketDevelopmentTownship(info, paramsList);
		} else if (info.getCollectionTableName().equals(CollectType.Collection_Market_Development_Village_Tablename)) {
			setModelCollectionMarketDevelopmentVillage(info, paramsList);
		}
	}

	private void setMonitorParams(LocationInfo info, List<NameValuePair> paramsList) {
		if (info.getCollectionTableName().equals(CollectType.Collection_Market_Monitor_Land_Level_Tablename)) {
			setModelCollectionMarketMonitorLandLevel(info, paramsList);
		} else if (info.getCollectionTableName().equals(CollectType.Collection_Market_Monitor_Land_Value_Tablename)) {
			setModelCollectionMarketMonitorLandValue(info, paramsList);
		} else if (info.getCollectionTableName().equals(CollectType.Collection_Market_Monitor_Point_Tablename)) {
			setModelCollectionMarketMonitorPoint(info, paramsList);
		}
	}

	private void setRedevelopmentParams(LocationInfo info, List<NameValuePair> paramsList) {
		if (info.getCollectionTableName().equals(CollectType.Collection_Market_Redevelopment_Impose_Tablename)) {
			setModelCollectionMarketRedevelopmentImpose(info, paramsList);
		} else if (info.getCollectionTableName().equals(CollectType.Collection_Market_Redevelopment_Plan_Tablename)) {
			setModelCollectionMarketRedevelopmentPlan(info, paramsList);
		}
	}

	private void setSupplyParams(LocationInfo info, List<NameValuePair> paramsList) {
		if (info.getCollectionTableName().equals(CollectType.Collection_Market_Supply_House_Rent_Tablename)) {
			setModelCollectionMarketSupplyHouseRent(info, paramsList);
		} else if (info.getCollectionTableName().equals(CollectType.Collection_Market_Supply_House_Sell_Tablename)) {
			setModelCollectionMarketSupplyHouseSell(info, paramsList);
		} else if (info.getCollectionTableName().equals(CollectType.Collection_Market_Supply_Rent_Tablename)) {
			setModelCollectionMarketSupplyRent(info, paramsList);
		} else if (info.getCollectionTableName().equals(CollectType.Collection_Market_Supply_Sell_Tablename)) {
			setModelCollectionMarketSupplySell(info, paramsList);
		} else if (info.getCollectionTableName().equals(CollectType.Collection_Market_Supply_ShareHolder_Tablename)) {
			setModelCollectionMarketSupplyShareHolder(info, paramsList);
		} else if (info.getCollectionTableName().equals(CollectType.Collection_Market_Supply_Transfer_Tablename)) {
			setModelCollectionMarketSupplyTransfer(info, paramsList);
		}
	}

	/**
	 * ˵����TODO(������һ�仰�����������������)
	 * 
	 * @param info
	 * @param paramsList
	 * @return void
	 */
	private void setModelCollectionMarketBusinessTransfer(LocationInfo info, List<NameValuePair> paramsList) {
		ModelCollectionMarketBusinessTransfer model = DataSupport.find(ModelCollectionMarketBusinessTransfer.class, info.getCollectionId());
		if (model != null) {
			paramsList.add(setNameValuePair("Thename", Common.bindString(model.getTHENAME())));
			paramsList.add(setNameValuePair("Thecode", Common.bindString(model.getTHECODE())));
			paramsList.add(setNameValuePair("Tdsyz", Common.bindString(model.getTDSYZ())));// ����ʹ����
			paramsList.add(setNameValuePair("Tdzsh", Common.bindString(model.getTDZSH())));// ����֤���
			paramsList.add(setNameValuePair("Tdzl", Common.bindString(model.getTDZL())));// ��������
			paramsList.add(setNameValuePair("Qsxz", Common.bindString(model.getQSXZ())));// Ȩ������
			/** ����ʹ��Ȩת�ý�����Ϣ **/
			paramsList.add(setNameValuePair("Zrf", Common.bindString(model.getZRF())));// ת�÷�
			paramsList.add(setNameValuePair("Srf", Common.bindString(model.getSRF())));// ���÷�
			paramsList.add(setNameValuePair("Zrsj", Common.bindString(model.getZRSJ())));// ת��ʱ��
			paramsList.add(setNameValuePair("Zrfs", Common.bindString(model.getZRFS())));// ת�÷�ʽ
			paramsList.add(setNameValuePair("Zrmj", Common.bindString(model.getZRMJ())));// ����ת�����
			paramsList.add(setNameValuePair("Zrqyt", Common.bindString(model.getZRQYT())));// ת��ǰ��;
			paramsList.add(setNameValuePair("Zrhyt", Common.bindString(model.getZRHYT())));// ת�ú���;
			paramsList.add(setNameValuePair("Tdsynq", Common.bindString(model.getTDSYNQ())));// ����ʣ��ʹ������
			paramsList.add(setNameValuePair("Zrdj", Common.bindString(model.getZRDJ())));// ����ת�õ���
			paramsList.add(setNameValuePair("Zrzj", Common.bindString(model.getZRZJ())));// ����ת���ܼ�
			/** ������Ϣ **/
			paramsList.add(setNameValuePair("Rjl", Common.bindString(model.getRJL())));// �ݻ���
			paramsList.add(setNameValuePair("Hxwkfsp", Common.bindString(model.getHXWKFSP())));// �����⿪��ˮƽ
			paramsList.add(setNameValuePair("Hxnkfsp", Common.bindString(model.getHXNKFSP())));// �����ڿ���ˮƽ
			paramsList.add(setNameValuePair("Tdjb", Common.bindString(model.getTDJB())));// �������ؼ���
			paramsList.add(setNameValuePair("Djqd", Common.bindString(model.getDJQD())));// ���ڵؼ�����
			paramsList.add(setNameValuePair("Xzqdm", Common.bindString(model.getXZQDM())));// ����������

			/** λ����Ϣ **/
			paramsList.add(setNameValuePair("X", Common.bindString(model.getX())));// X����
			paramsList.add(setNameValuePair("Y", Common.bindString(model.getY())));// Y����
			paramsList.add(setNameValuePair("Zbxt", Common.bindString(model.getZBXT())));// ����ϵͳ
			paramsList.add(setNameValuePair("Remark", Common.bindString(model.getREMARK())));// ��ע

			/** ϵͳ��Ϣ **/
			paramsList.add(setNameValuePair("Inputuserid", Common.bindString(model.getINPUTUSERID())));// �����û�
			paramsList.add(setNameValuePair("Createtime", Common.bindString(model.getCREATETIME())));// ����ʱ��
			paramsList.add(setNameValuePair("Lastupdateuserid", Common.bindString(model.getLASTUPDATEUSERID())));// �޸��û�
			paramsList.add(setNameValuePair("Updatetime", Common.bindString(model.getUPDATETIME())));// �޸�ʱ��
			paramsList.add(setNameValuePair("Isdelete", Common.bindString(model.getISDELETE())));// �Ƿ�ɾ��
			paramsList.add(setNameValuePair("Showseq", Common.bindString(model.getSHOWSEQ())));// ��ʾ˳��
		}
	}

	/**
	 * ˵����TODO(������һ�仰�����������������)
	 * 
	 * @param info
	 * @param paramsList
	 * @return void
	 */
	private void setModelCollectionMarketBusinessShareHolder(LocationInfo info, List<NameValuePair> paramsList) {
		ModelCollectionMarketBusinessShareHolder model = DataSupport.find(ModelCollectionMarketBusinessShareHolder.class, info.getCollectionId());
		if (model != null) {
			paramsList.add(setNameValuePair("Thename", Common.bindString(model.getTHENAME())));
			paramsList.add(setNameValuePair("Thecode", Common.bindString(model.getTHECODE())));
			paramsList.add(setNameValuePair("Tdsyz", Common.bindString(model.getTDSYZ())));// ����ʹ����
			paramsList.add(setNameValuePair("Tdzsh", Common.bindString(model.getTDZSH())));// ����֤���
			paramsList.add(setNameValuePair("Tdzl", Common.bindString(model.getTDZL())));// ��������
			paramsList.add(setNameValuePair(captureName("Qsxz"), Common.bindString(model.getQSXZ())));// Ȩ������
			/** ������Ӫ��ɽ�����Ϣ **/
			paramsList.add(setNameValuePair(captureName("CDF"), Common.bindString(model.getCDF())));// ���ط�
			paramsList.add(setNameValuePair(captureName("CZF"), Common.bindString(model.getCZF())));// ���ʷ�
			paramsList.add(setNameValuePair(captureName("LYSJ"), Common.bindString(model.getLYSJ())));// ��Ӫʱ��
			paramsList.add(setNameValuePair(captureName("LYQ"), Common.bindString(model.getLYQ())));// ��Ӫ��
			paramsList.add(setNameValuePair(captureName("CDMJ"), Common.bindString(model.getCDMJ())));// ���ط�Ͷ���������
			paramsList.add(setNameValuePair(captureName("CZZE"), Common.bindString(model.getCZZE())));// ���ʷ�Ͷ���ʽ��ܶ�
			paramsList.add(setNameValuePair(captureName("CDFFCBL"), Common.bindString(model.getCDFFCBL())));// ���ط�����ֳɱ���
			paramsList.add(setNameValuePair(captureName("TDNCSR"), Common.bindString(model.getTDNCSR())));// ��λ��������괿����
			paramsList.add(setNameValuePair(captureName("CDFNCSR"), Common.bindString(model.getCDFNCSR())));// ���ط������괿����
			paramsList.add(setNameValuePair(captureName("LYQYT"), Common.bindString(model.getLYQYT())));// ��Ӫǰ��;
			paramsList.add(setNameValuePair(captureName("LYHYT"), Common.bindString(model.getLYHYT())));// ��Ӫ����;
			/** ������Ϣ **/
			paramsList.add(setNameValuePair("Rjl", Common.bindString(model.getRJL())));// �ݻ���
			paramsList.add(setNameValuePair("Hxwkfsp", Common.bindString(model.getHXWKFSP())));// �����⿪��ˮƽ
			paramsList.add(setNameValuePair("Hxnkfsp", Common.bindString(model.getHXNKFSP())));// �����ڿ���ˮƽ
			paramsList.add(setNameValuePair("Tdjb", Common.bindString(model.getTDJB())));// �������ؼ���
			paramsList.add(setNameValuePair("Djqd", Common.bindString(model.getDJQD())));// ���ڵؼ�����
			paramsList.add(setNameValuePair("Xzqdm", Common.bindString(model.getXZQDM())));// ����������

			/** λ����Ϣ **/
			paramsList.add(setNameValuePair("X", Common.bindString(model.getX())));// X����
			paramsList.add(setNameValuePair("Y", Common.bindString(model.getY())));// Y����
			paramsList.add(setNameValuePair("Zbxt", Common.bindString(model.getZBXT())));// ����ϵͳ
			paramsList.add(setNameValuePair("Remark", Common.bindString(model.getREMARK())));// ��ע

			/** ϵͳ��Ϣ **/
			paramsList.add(setNameValuePair("Inputuserid", Common.bindString(model.getINPUTUSERID())));// �����û�
			paramsList.add(setNameValuePair("Createtime", Common.bindString(model.getCREATETIME())));// ����ʱ��
			paramsList.add(setNameValuePair("Lastupdateuserid", Common.bindString(model.getLASTUPDATEUSERID())));// �޸��û�
			paramsList.add(setNameValuePair("Updatetime", Common.bindString(model.getUPDATETIME())));// �޸�ʱ��
			paramsList.add(setNameValuePair("Isdelete", Common.bindString(model.getISDELETE())));// �Ƿ�ɾ��
			paramsList.add(setNameValuePair("Showseq", Common.bindString(model.getSHOWSEQ())));// ��ʾ˳��
		}
	}

	/**
	 * ˵����TODO(������һ�仰�����������������)
	 * 
	 * @param info
	 * @param paramsList
	 * @return void
	 */
	private void setModelCollectionMarketBusinessSell(LocationInfo info, List<NameValuePair> paramsList) {
		ModelCollectionMarketBusinessSell model = DataSupport.find(ModelCollectionMarketBusinessSell.class, info.getCollectionId());
		if (model != null) {
			paramsList.add(setNameValuePair("Thename", Common.bindString(model.getTHENAME())));
			paramsList.add(setNameValuePair("Thecode", Common.bindString(model.getTHECODE())));
			paramsList.add(setNameValuePair("Tdsyz", Common.bindString(model.getTDSYZ())));// ����ʹ����
			paramsList.add(setNameValuePair("Tdzsh", Common.bindString(model.getTDZSH())));// ����֤���
			paramsList.add(setNameValuePair("Tdzl", Common.bindString(model.getTDZL())));// ��������
			paramsList.add(setNameValuePair("Qsxz", Common.bindString(model.getQSXZ())));// Ȩ������
			/** ����ʹ��Ȩ���ý�����Ϣ **/
			paramsList.add(setNameValuePair("Crsj", Common.bindString(model.getCRSJ())));// ����ʱ��
			paramsList.add(setNameValuePair("Srf", Common.bindString(model.getSRF())));// ���÷�
			paramsList.add(setNameValuePair("Crfs", Common.bindString(model.getCRFS())));// ���÷�ʽ
			paramsList.add(setNameValuePair("Sfzkf", Common.bindString(model.getSFZKF())));// �Ƿ��ٿ���
			paramsList.add(setNameValuePair("Sflyd", Common.bindString(model.getSFLYD())));// �Ƿ����õ�
			paramsList.add(setNameValuePair("Ghtdmj", Common.bindString(model.getGHTDMJ())));// �滮���߷�Χ�������
			paramsList.add(setNameValuePair("Dztdmj", Common.bindString(model.getDZTDMJ())));// �����������
			paramsList.add(setNameValuePair("Sjcrmj", Common.bindString(model.getSJCRMJ())));// ʵ�ʳ������
			paramsList.add(setNameValuePair("Crqyt", Common.bindString(model.getCRQYT())));// ����ǰ��;
			paramsList.add(setNameValuePair("Crhyt", Common.bindString(model.getCRHYT())));// ���ú���;
			paramsList.add(setNameValuePair("Crnq", Common.bindString(model.getCRNQ())));// ��������
			paramsList.add(setNameValuePair("Crdj", Common.bindString(model.getCRDJ())));// ��λ������س��ü�
			paramsList.add(setNameValuePair("Crzj", Common.bindString(model.getCRZJ())));// ���س����ܼ�
			/** ������Ϣ **/
			paramsList.add(setNameValuePair("Rjl", Common.bindString(model.getRJL())));// �ݻ���
			paramsList.add(setNameValuePair("Hxwkfsp", Common.bindString(model.getHXWKFSP())));// �����⿪��ˮƽ
			paramsList.add(setNameValuePair("Hxnkfsp", Common.bindString(model.getHXNKFSP())));// �����ڿ���ˮƽ
			paramsList.add(setNameValuePair("Tdjb", Common.bindString(model.getTDJB())));// �������ؼ���
			paramsList.add(setNameValuePair("Djqd", Common.bindString(model.getDJQD())));// ���ڵؼ�����
			paramsList.add(setNameValuePair("Xzqdm", Common.bindString(model.getXZQDM())));// ����������

			/** λ����Ϣ **/
			paramsList.add(setNameValuePair("X", Common.bindString(model.getX())));// X����
			paramsList.add(setNameValuePair("Y", Common.bindString(model.getY())));// Y����
			paramsList.add(setNameValuePair("Zbxt", Common.bindString(model.getZBXT())));// ����ϵͳ
			paramsList.add(setNameValuePair("Remark", Common.bindString(model.getREMARK())));// ��ע

			/** ϵͳ��Ϣ **/
			paramsList.add(setNameValuePair("Inputuserid", Common.bindString(model.getINPUTUSERID())));// �����û�
			paramsList.add(setNameValuePair("Createtime", Common.bindString(model.getCREATETIME())));// ����ʱ��
			paramsList.add(setNameValuePair("Lastupdateuserid", Common.bindString(model.getLASTUPDATEUSERID())));// �޸��û�
			paramsList.add(setNameValuePair("Updatetime", Common.bindString(model.getUPDATETIME())));// �޸�ʱ��
			paramsList.add(setNameValuePair("Isdelete", Common.bindString(model.getISDELETE())));// �Ƿ�ɾ��
			paramsList.add(setNameValuePair("Showseq", Common.bindString(model.getSHOWSEQ())));// ��ʾ˳��
		}
	}

	/**
	 * ˵����TODO(������һ�仰�����������������)
	 * 
	 * @param info
	 * @param paramsList
	 * @return void
	 */
	private void setModelCollectionMarketBusinessRentOut(LocationInfo info, List<NameValuePair> paramsList) {
		ModelCollectionMarketBusinessRentOut model = DataSupport.find(ModelCollectionMarketBusinessRentOut.class, info.getCollectionId());
		if (model != null) {
			paramsList.add(setNameValuePair("Thename", Common.bindString(model.getTHENAME())));
			paramsList.add(setNameValuePair("Thecode", Common.bindString(model.getTHECODE())));
			paramsList.add(setNameValuePair("Tdsyz", Common.bindString(model.getTDSYZ())));// ����ʹ����
			paramsList.add(setNameValuePair("Tdzsh", Common.bindString(model.getTDZSH())));// ����֤���
			paramsList.add(setNameValuePair("Tdzl", Common.bindString(model.getTDZL())));// ��������
			paramsList.add(setNameValuePair("Qsxz", Common.bindString(model.getQSXZ())));// Ȩ������
			/** ����ʹ��Ȩ���⽻����Ϣ **/
			paramsList.add(setNameValuePair("Chuzf", Common.bindString(model.getCHUZF())));// ���ⷽ
			paramsList.add(setNameValuePair("Chengzf", Common.bindString(model.getCHENGZF())));// ���ⷽ
			paramsList.add(setNameValuePair("Czsj", Common.bindString(model.getCZSJ())));// ����ʱ��
			paramsList.add(setNameValuePair("Zq", Common.bindString(model.getZQ())));// ����
			paramsList.add(setNameValuePair("Czmj", Common.bindString(model.getCZMJ())));// ���س������
			paramsList.add(setNameValuePair("Czqyt", Common.bindString(model.getCZQYT())));// ����ǰ��;
			paramsList.add(setNameValuePair("Czhyt", Common.bindString(model.getCZHYT())));// �������;
			paramsList.add(setNameValuePair("Tdsynq", Common.bindString(model.getTDSYNQ())));// ����ʣ��ʹ����
			paramsList.add(setNameValuePair("Nzj", Common.bindString(model.getNZJ())));// �����
			paramsList.add(setNameValuePair("Yj", Common.bindString(model.getYJ())));// Ѻ��
			paramsList.add(setNameValuePair("Sf", Common.bindString(model.getSF())));// ˰��
			/** ������Ϣ **/
			paramsList.add(setNameValuePair("Rjl", Common.bindString(model.getRJL())));// �ݻ���
			paramsList.add(setNameValuePair("Hxwkfsp", Common.bindString(model.getHXWKFSP())));// �����⿪��ˮƽ
			paramsList.add(setNameValuePair("Hxnkfsp", Common.bindString(model.getHXNKFSP())));// �����ڿ���ˮƽ
			paramsList.add(setNameValuePair("Tdjb", Common.bindString(model.getTDJB())));// �������ؼ���
			paramsList.add(setNameValuePair("Djqd", Common.bindString(model.getDJQD())));// ���ڵؼ�����
			paramsList.add(setNameValuePair("Xzqdm", Common.bindString(model.getXZQDM())));// ����������

			/** λ����Ϣ **/
			paramsList.add(setNameValuePair("X", Common.bindString(model.getX())));// X����
			paramsList.add(setNameValuePair("Y", Common.bindString(model.getY())));// Y����
			paramsList.add(setNameValuePair("Zbxt", Common.bindString(model.getZBXT())));// ����ϵͳ
			paramsList.add(setNameValuePair("Remark", Common.bindString(model.getREMARK())));// ��ע

			/** ϵͳ��Ϣ **/
			paramsList.add(setNameValuePair("Inputuserid", Common.bindString(model.getINPUTUSERID())));// �����û�
			paramsList.add(setNameValuePair("Createtime", Common.bindString(model.getCREATETIME())));// ����ʱ��
			paramsList.add(setNameValuePair("Lastupdateuserid", Common.bindString(model.getLASTUPDATEUSERID())));// �޸��û�
			paramsList.add(setNameValuePair("Updatetime", Common.bindString(model.getUPDATETIME())));// �޸�ʱ��
			paramsList.add(setNameValuePair("Isdelete", Common.bindString(model.getISDELETE())));// �Ƿ�ɾ��
			paramsList.add(setNameValuePair("Showseq", Common.bindString(model.getSHOWSEQ())));// ��ʾ˳��
		}
	}

	/**
	 * ˵����TODO(������һ�仰�����������������)
	 * 
	 * @param info
	 * @param paramsList
	 * @return void
	 */
	private void setModelCollectionMarketBusinessHouseSell(LocationInfo info, List<NameValuePair> paramsList) {
		ModelCollectionMarketBusinessHouseSell model = DataSupport.find(ModelCollectionMarketBusinessHouseSell.class, info.getCollectionId());
		if (model != null) {
			paramsList.add(setNameValuePair("Thename", Common.bindString(model.getTHENAME())));
			paramsList.add(setNameValuePair("Thecode", Common.bindString(model.getTHECODE())));
			paramsList.add(setNameValuePair("Tdsyz", Common.bindString(model.getTDSYZ())));// ����ʹ����
			paramsList.add(setNameValuePair("Tdzsh", Common.bindString(model.getTDZSH())));// ����֤���
			paramsList.add(setNameValuePair("Tdzl", Common.bindString(model.getTDZL())));// ��������
			paramsList.add(setNameValuePair("Qsxz", Common.bindString(model.getQSXZ())));// Ȩ������

			/** ���س��۽�����Ϣ **/
			paramsList.add(setNameValuePair("Fwsyqr", Common.bindString(model.getFWSYQR())));// ��������Ȩ��
			paramsList.add(setNameValuePair("Tdyt", Common.bindString(model.getTDYT())));// ������;
			paramsList.add(setNameValuePair("Ljkd", Common.bindString(model.getLJKD())));// �ٽֿ��
			paramsList.add(setNameValuePair("Ljsd", Common.bindString(model.getLJSD())));// �ٽ����
			paramsList.add(setNameValuePair("Jzlx", Common.bindString(model.getJZLX())));// ��������
			paramsList.add(setNameValuePair("Jzcs", Common.bindString(model.getJZCS())));// ��������
			paramsList.add(setNameValuePair("Fwjg", Common.bindString(model.getFWJG())));// ���ݽṹ
			paramsList.add(setNameValuePair("Jgsj", Common.bindString(model.getJGSJ())));// ����ʱ��
			paramsList.add(setNameValuePair("Fwcxd", Common.bindString(model.getFWCXD())));// ���ݳ��¶�
			paramsList.add(setNameValuePair("Zxsj", Common.bindString(model.getZXSJ())));// װ��ʱ��
			paramsList.add(setNameValuePair("Zxcd", Common.bindString(model.getZXCD())));// װ�޳̶�
			paramsList.add(setNameValuePair("Cslc", Common.bindString(model.getCSLC())));// ����¥��
			paramsList.add(setNameValuePair("Csyt", Common.bindString(model.getCSYT())));// ������;
			paramsList.add(setNameValuePair("Csmj", Common.bindString(model.getCSMJ())));// ���۽������
			paramsList.add(setNameValuePair("Cssj", Common.bindString(model.getCSSJ())));// ����ʱ��
			paramsList.add(setNameValuePair("Sj", Common.bindString(model.getSJ())));// �ۼ�
			paramsList.add(setNameValuePair("Sf", Common.bindString(model.getSF())));// ˰��

			/** ������Ϣ **/
			paramsList.add(setNameValuePair("Rjl", Common.bindString(model.getRJL())));// �ݻ���
			paramsList.add(setNameValuePair("Hxwkfsp", Common.bindString(model.getHXWKFSP())));// �����⿪��ˮƽ
			paramsList.add(setNameValuePair("Hxnkfsp", Common.bindString(model.getHXNKFSP())));// �����ڿ���ˮƽ
			paramsList.add(setNameValuePair("Tdjb", Common.bindString(model.getTDJB())));// �������ؼ���
			paramsList.add(setNameValuePair("Djqd", Common.bindString(model.getDJQD())));// ���ڵؼ�����
			paramsList.add(setNameValuePair("Xzqdm", Common.bindString(model.getXZQDM())));// ����������

			/** λ����Ϣ **/
			paramsList.add(setNameValuePair("X", Common.bindString(model.getX())));// X����
			paramsList.add(setNameValuePair("Y", Common.bindString(model.getY())));// Y����
			paramsList.add(setNameValuePair("Zbxt", Common.bindString(model.getZBXT())));// ����ϵͳ
			paramsList.add(setNameValuePair("Remark", Common.bindString(model.getREMARK())));// ��ע

			/** ϵͳ��Ϣ **/
			paramsList.add(setNameValuePair("Inputuserid", Common.bindString(model.getINPUTUSERID())));// �����û�
			paramsList.add(setNameValuePair("Createtime", Common.bindString(model.getCREATETIME())));// ����ʱ��
			paramsList.add(setNameValuePair("Lastupdateuserid", Common.bindString(model.getLASTUPDATEUSERID())));// �޸��û�
			paramsList.add(setNameValuePair("Updatetime", Common.bindString(model.getUPDATETIME())));// �޸�ʱ��
			paramsList.add(setNameValuePair("Isdelete", Common.bindString(model.getISDELETE())));// �Ƿ�ɾ��
			paramsList.add(setNameValuePair("Showseq", Common.bindString(model.getSHOWSEQ())));// ��ʾ˳��
		}
	}

	/**
	 * ˵����TODO(������һ�仰�����������������)
	 * 
	 * @param info
	 * @param paramsList
	 * @return void
	 */
	private void setModelCollectionMarketBusinessHouseRent(LocationInfo info, List<NameValuePair> paramsList) {
		ModelCollectionMarketBusinessHouseRent model = DataSupport.find(ModelCollectionMarketBusinessHouseRent.class, info.getCollectionId());
		if (model != null) {
			paramsList.add(setNameValuePair("Thename", Common.bindString(model.getTHENAME())));
			paramsList.add(setNameValuePair("Thecode", Common.bindString(model.getTHECODE())));
			paramsList.add(setNameValuePair("Tdsyz", Common.bindString(model.getTDSYZ())));
			paramsList.add(setNameValuePair("Tdzsh", Common.bindString(model.getTDZSH())));
			paramsList.add(setNameValuePair("Tdzl", Common.bindString(model.getTDZL())));
			paramsList.add(setNameValuePair("Fwsyqr", Common.bindString(model.getFWSYQR())));
			paramsList.add(setNameValuePair("Qsxz", Common.bindString(model.getQSXZ())));
			paramsList.add(setNameValuePair("Tdyt", Common.bindString(model.getTDYT())));
			paramsList.add(setNameValuePair("Rjl", Common.bindString(model.getRJL())));
			paramsList.add(setNameValuePair("Ljkd", Common.bindString(model.getLJKD())));
			paramsList.add(setNameValuePair("Ljsd", Common.bindString(model.getLJSD())));
			paramsList.add(setNameValuePair("Hxwkfsp", Common.bindString(model.getHXWKFSP())));
			paramsList.add(setNameValuePair("Hxnkfsp", Common.bindString(model.getHXNKFSP())));
			paramsList.add(setNameValuePair("Jzlx", Common.bindString(model.getJZLX())));
			paramsList.add(setNameValuePair("Jzcs", Common.bindString(model.getJZCS())));
			paramsList.add(setNameValuePair("Fwjg", Common.bindString(model.getFWJG())));
			paramsList.add(setNameValuePair("Jgsj", Common.bindString(model.getJGSJ())));
			paramsList.add(setNameValuePair("Fwcxd", Common.bindString(model.getFWCXD())));
			paramsList.add(setNameValuePair("Zxsj", Common.bindString(model.getZXSJ())));
			paramsList.add(setNameValuePair("Zxcd", Common.bindString(model.getZXCD())));
			paramsList.add(setNameValuePair("Czlc", Common.bindString(model.getCZLC())));
			paramsList.add(setNameValuePair("Czyt", Common.bindString(model.getCZYT())));
			paramsList.add(setNameValuePair("Czmj", Common.bindString(model.getCZMJ())));
			paramsList.add(setNameValuePair("Czsj", Common.bindString(model.getCZSJ())));
			paramsList.add(setNameValuePair("Zq", Common.bindString(model.getZQ())));
			paramsList.add(setNameValuePair("Nzj", Common.bindString(model.getNZJ())));
			paramsList.add(setNameValuePair("Yj", Common.bindString(model.getYJ())));
			paramsList.add(setNameValuePair("Sf", Common.bindString(model.getSF())));
			paramsList.add(setNameValuePair("Tdjb", Common.bindString(model.getTDJB())));
			paramsList.add(setNameValuePair("Djqd", Common.bindString(model.getDJQD())));
			paramsList.add(setNameValuePair("Xzqdm", Common.bindString(model.getXZQDM())));
			paramsList.add(setNameValuePair("X", Common.bindString(model.getX())));
			paramsList.add(setNameValuePair("Y", Common.bindString(model.getY())));
			paramsList.add(setNameValuePair("Zbxt", Common.bindString(model.getZBXT())));
			paramsList.add(setNameValuePair("Remark", Common.bindString(model.getREMARK())));
			paramsList.add(setNameValuePair("Inputuserid", Common.bindString()));
			paramsList.add(setNameValuePair("Showseq", Common.bindString(model.getREMARK())));
		}
	}

	/**
	 * ˵����TODO(������һ�仰�����������������)
	 * 
	 * @param info
	 * @param paramsList
	 * @return void
	 */
	private void setModelCollectionMarketDemandTransfer(LocationInfo info, List<NameValuePair> paramsList) {
		ModelCollectionMarketDemandTransfer model = DataSupport.find(ModelCollectionMarketDemandTransfer.class, info.getCollectionId());
		if (model != null) {
			/** ������Ϣ **/
			paramsList.add(setNameValuePair(captureName("THENAME"), Common.bindString(model.getTHENAME())));// ��¼����
			paramsList.add(setNameValuePair(captureName("THECODE"), Common.bindString(model.getTHECODE())));// ��¼����

			/** ����ʹ��Ȩת��������Ϣ **/
			paramsList.add(setNameValuePair(captureName("XQF"), Common.bindString(model.getXQF())));// ����
			paramsList.add(setNameValuePair(captureName("XQFZTXZ"), Common.bindString(model.getXQFZTXZ())));// ������������
			paramsList.add(setNameValuePair(captureName("NTDZL"), Common.bindString(model.getNTDZL())));// ����������
			paramsList.add(setNameValuePair(captureName("NQSXZ"), Common.bindString(model.getNQSXZ())));// ��Ȩ������
			paramsList.add(setNameValuePair(captureName("XQZRSJ"), Common.bindString(model.getXQZRSJ())));// ����ת��ʱ��
			paramsList.add(setNameValuePair(captureName("XQZRFS"), Common.bindString(model.getXQZRFS())));// ����ת�÷�ʽ
			paramsList.add(setNameValuePair(captureName("NXQZRMJ"), Common.bindString(model.getNXQZRMJ())));// ����������ת�����
			paramsList.add(setNameValuePair(captureName("ZRQYT"), Common.bindString(model.getZRQYT())));// ת��ǰ��;
			paramsList.add(setNameValuePair(captureName("NZRHYT"), Common.bindString(model.getNZRHYT())));// ��ת�ú���;
			paramsList.add(setNameValuePair(captureName("TDSYNQ"), Common.bindString(model.getTDSYNQ())));// ����ʣ��ʹ������
			paramsList.add(setNameValuePair(captureName("GHRJL"), Common.bindString(model.getGHRJL())));// �滮�ڵ��ݻ���
			paramsList.add(setNameValuePair(captureName("XQZRDJ"), Common.bindString(model.getXQZRDJ())));// ��������ת�õ���
			paramsList.add(setNameValuePair(captureName("XQZRZJ"), Common.bindString(model.getXQZRZJ())));// ��������ת���ܼ�
			paramsList.add(setNameValuePair(captureName("XQXZTDTJ"), Common.bindString(model.getXQXZTDTJ())));
			/** ������Ϣ **/
			paramsList.add(setNameValuePair(captureName("TDJB"), Common.bindString(model.getTDJB())));// �������ؼ���
			paramsList.add(setNameValuePair(captureName("XZQDM"), Common.bindString(model.getXZQDM())));// ����������

			/** λ����Ϣ **/
			paramsList.add(setNameValuePair(captureName("X"), Common.bindString(model.getX())));// X����
			paramsList.add(setNameValuePair(captureName("Y"), Common.bindString(model.getY())));// Y����
			paramsList.add(setNameValuePair(captureName("ZBXT"), Common.bindString(model.getZBXT())));// ����ϵͳ
			paramsList.add(setNameValuePair(captureName("REMARK"), Common.bindString(model.getREMARK())));// ��ע

			/** ϵͳ��Ϣ **/
			paramsList.add(setNameValuePair(captureName("INPUTUSERID"), Common.bindString(model.getINPUTUSERID())));// �����û�
			paramsList.add(setNameValuePair(captureName("CREATETIME"), Common.bindString(model.getCREATETIME())));// ����ʱ��
			paramsList.add(setNameValuePair(captureName("LASTUPDATEUSERID"), Common.bindString(model.getLASTUPDATEUSERID())));// �޸��û�
			paramsList.add(setNameValuePair(captureName("UPDATETIME"), Common.bindString(model.getUPDATETIME())));// �޸�ʱ��
			paramsList.add(setNameValuePair(captureName("ISDELETE"), Common.bindString(model.getISDELETE())));// �Ƿ�ɾ��
			paramsList.add(setNameValuePair(captureName("SHOWSEQ"), Common.bindString(model.getSHOWSEQ())));// ��ʾ˳��
		}
	}

	/**
	 * ˵����TODO(������һ�仰�����������������)
	 * 
	 * @param info
	 * @param paramsList
	 * @return void
	 */
	private void setModelCollectionMarketDemandShareHolder(LocationInfo info, List<NameValuePair> paramsList) {
		ModelCollectionMarketDemandShareHolder model = DataSupport.find(ModelCollectionMarketDemandShareHolder.class, info.getCollectionId());
		if (model != null) {
			/** ������Ϣ **/
			paramsList.add(setNameValuePair(captureName("THENAME"), Common.bindString(model.getTHENAME())));// ��¼����
			paramsList.add(setNameValuePair(captureName("THECODE"), Common.bindString(model.getTHECODE())));// ��¼����

			/** ������Ӫ���������Ϣ **/
			paramsList.add(setNameValuePair(captureName("XQCZF"), Common.bindString(model.getXQCZF())));// ������ʷ�
			paramsList.add(setNameValuePair(captureName("XQCZFZTXZ"), Common.bindString(model.getXQCZFZTXZ())));// ������ʷ���������
			paramsList.add(setNameValuePair(captureName("NTDZL"), Common.bindString(model.getNTDZL())));// ����������
			paramsList.add(setNameValuePair(captureName("NQSXZ"), Common.bindString(model.getNQSXZ())));// ��Ȩ������
			paramsList.add(setNameValuePair(captureName("XQXZTDTJ"), Common.bindString(model.getXQXZTDTJ())));// ������״��������
			paramsList.add(setNameValuePair(captureName("XQLYSJ"), Common.bindString(model.getXQLYSJ())));// ������Ӫʱ��
			paramsList.add(setNameValuePair(captureName("XQLYQ"), Common.bindString(model.getXQLYQ())));// ������Ӫ��
			paramsList.add(setNameValuePair(captureName("XQCDMJ"), Common.bindString(model.getXQCDMJ())));// ������ط�Ͷ���������
			paramsList.add(setNameValuePair(captureName("XQCZZE"), Common.bindString(model.getXQCZZE())));// ������ʷ�Ͷ���ʽ��ܶ�
			paramsList.add(setNameValuePair(captureName("XQCDFFCBL"), Common.bindString(model.getXQCDFFCBL())));// ������ط�����ֳɱ���
			paramsList.add(setNameValuePair(captureName("NTDNCSR"), Common.bindString(model.getNTDNCSR())));// �ⵥλ��������괿����
			paramsList.add(setNameValuePair(captureName("NCDFNCSR"), Common.bindString(model.getNCDFNCSR())));// ����ط������괿����
			paramsList.add(setNameValuePair(captureName("LYQYT"), Common.bindString(model.getLYQYT())));// ��Ӫǰ��;
			paramsList.add(setNameValuePair(captureName("NLYHYT"), Common.bindString(model.getNLYHYT())));// ����Ӫ����;

			/** ������Ϣ **/
			paramsList.add(setNameValuePair(captureName("TDJB"), Common.bindString(model.getTDJB())));// �������ؼ���
			paramsList.add(setNameValuePair(captureName("XZQDM"), Common.bindString(model.getXZQDM())));// ����������

			/** λ����Ϣ **/
			paramsList.add(setNameValuePair(captureName("X"), Common.bindString(model.getX())));// X����
			paramsList.add(setNameValuePair(captureName("Y"), Common.bindString(model.getY())));// Y����
			paramsList.add(setNameValuePair(captureName("ZBXT"), Common.bindString(model.getZBXT())));// ����ϵͳ
			paramsList.add(setNameValuePair(captureName("REMARK"), Common.bindString(model.getREMARK())));// ��ע

			/** ϵͳ��Ϣ **/
			paramsList.add(setNameValuePair(captureName("INPUTUSERID"), Common.bindString(model.getINPUTUSERID())));// �����û�
			paramsList.add(setNameValuePair(captureName("CREATETIME"), Common.bindString(model.getCREATETIME())));// ����ʱ��
			paramsList.add(setNameValuePair(captureName("LASTUPDATEUSERID"), Common.bindString(model.getLASTUPDATEUSERID())));// �޸��û�
			paramsList.add(setNameValuePair(captureName("UPDATETIME"), Common.bindString(model.getUPDATETIME())));// �޸�ʱ��
			paramsList.add(setNameValuePair(captureName("ISDELETE"), Common.bindString(model.getISDELETE())));// �Ƿ�ɾ��
			paramsList.add(setNameValuePair(captureName("SHOWSEQ"), Common.bindString(model.getSHOWSEQ())));// ��ʾ˳��
		}
	}

	/**
	 * ˵����TODO(������һ�仰�����������������)
	 * 
	 * @param info
	 * @param paramsList
	 * @return void
	 */
	private void setModelCollectionMarketDemandSell(LocationInfo info, List<NameValuePair> paramsList) {
		ModelCollectionMarketDemandSell model = DataSupport.find(ModelCollectionMarketDemandSell.class, info.getCollectionId());
		if (model != null) {
			/** ������Ϣ **/
			paramsList.add(setNameValuePair(captureName("THENAME"), Common.bindString(model.getTHENAME())));// ��¼����
			paramsList.add(setNameValuePair(captureName("THECODE"), Common.bindString(model.getTHECODE())));// ��¼����

			/** ���س���������Ϣ **/
			paramsList.add(setNameValuePair(captureName("XQF"), Common.bindString(model.getXQF())));// ����
			paramsList.add(setNameValuePair(captureName("XQFZTXZ"), Common.bindString(model.getXQFZTXZ())));// ������������
			paramsList.add(setNameValuePair(captureName("NTDZL"), Common.bindString(model.getNTDZL())));// ����������
			paramsList.add(setNameValuePair(captureName("NQSXZ"), Common.bindString(model.getNQSXZ())));// ��Ȩ������
			paramsList.add(setNameValuePair(captureName("XQCRSJ"), Common.bindString(model.getXQCRSJ())));// �������ʱ��
			paramsList.add(setNameValuePair(captureName("XQCRFS"), Common.bindString(model.getXQCRFS())));// ������÷�ʽ
			paramsList.add(setNameValuePair(captureName("NXQCRMJ"), Common.bindString(model.getNXQCRMJ())));// ������������
			paramsList.add(setNameValuePair(captureName("CRQYT"), Common.bindString(model.getCRQYT())));// ����ǰ��;
			paramsList.add(setNameValuePair(captureName("NCRHYT"), Common.bindString(model.getNCRHYT())));// ����ú���;
			paramsList.add(setNameValuePair(captureName("XQCRNQ"), Common.bindString(model.getXQCRNQ())));// �����������
			paramsList.add(setNameValuePair(captureName("GHRJL"), Common.bindString(model.getGHRJL())));// �滮�ڵ��ݻ���
			paramsList.add(setNameValuePair(captureName("XQXZTDTJ"), Common.bindString(model.getXQXZTDTJ())));// ������״��������
			paramsList.add(setNameValuePair(captureName("XQCRDJ"), Common.bindString(model.getXQCRDJ())));// ����λ������س��ü�
			paramsList.add(setNameValuePair(captureName("XQCRZJ"), Common.bindString(model.getXQCRZJ())));// �������س����ܼ�
			paramsList.add(setNameValuePair(captureName("NTZQD"), Common.bindString(model.getNTZQD())));// ��Ͷ��ǿ��
			paramsList.add(setNameValuePair(captureName("NKFTZZE"), Common.bindString(model.getNKFTZZE())));// �⿪��Ͷ���ܶ�

			/** ������Ϣ **/
			paramsList.add(setNameValuePair(captureName("TDJB"), Common.bindString(model.getTDJB())));// �������ؼ���
			paramsList.add(setNameValuePair(captureName("XZQDM"), Common.bindString(model.getXZQDM())));// ����������

			/** λ����Ϣ **/
			paramsList.add(setNameValuePair(captureName("X"), Common.bindString(model.getX())));// X����
			paramsList.add(setNameValuePair(captureName("Y"), Common.bindString(model.getY())));// Y����
			paramsList.add(setNameValuePair(captureName("ZBXT"), Common.bindString(model.getZBXT())));// ����ϵͳ
			paramsList.add(setNameValuePair(captureName("REMARK"), Common.bindString(model.getREMARK())));// ��ע

			/** ϵͳ��Ϣ **/
			paramsList.add(setNameValuePair(captureName("INPUTUSERID"), Common.bindString(model.getINPUTUSERID())));// �����û�
			paramsList.add(setNameValuePair(captureName("CREATETIME"), Common.bindString(model.getCREATETIME())));// ����ʱ��
			paramsList.add(setNameValuePair(captureName("LASTUPDATEUSERID"), Common.bindString(model.getLASTUPDATEUSERID())));// �޸��û�
			paramsList.add(setNameValuePair(captureName("UPDATETIME"), Common.bindString(model.getUPDATETIME())));// �޸�ʱ��
			paramsList.add(setNameValuePair(captureName("ISDELETE"), Common.bindString(model.getISDELETE())));// �Ƿ�ɾ��
			paramsList.add(setNameValuePair(captureName("SHOWSEQ"), Common.bindString(model.getSHOWSEQ())));// ��ʾ˳��
		}
	}

	/**
	 * ˵����TODO(������һ�仰�����������������)
	 * 
	 * @param info
	 * @param paramsList
	 * @return void
	 */
	private void setModelCollectionMarketDemandHouseRent(LocationInfo info, List<NameValuePair> paramsList) {
		ModelCollectionMarketDemandHouseRent model = DataSupport.find(ModelCollectionMarketDemandHouseRent.class, info.getCollectionId());
		if (model != null) {
			/** ������Ϣ **/
			paramsList.add(setNameValuePair(captureName("THENAME"), Common.bindString(model.getTHENAME())));// ��¼����
			paramsList.add(setNameValuePair(captureName("THECODE"), Common.bindString(model.getTHECODE())));// ��¼����

			/** ���س���������Ϣ **/
			paramsList.add(setNameValuePair(captureName("XQCZF"), Common.bindString(model.getXQCZF())));// ������ⷽ
			paramsList.add(setNameValuePair(captureName("NTDZL"), Common.bindString(model.getNTDZL())));// ����������
			paramsList.add(setNameValuePair(captureName("NQSXZ"), Common.bindString(model.getNQSXZ())));// ��Ȩ������
			paramsList.add(setNameValuePair(captureName("TDSYNQ"), Common.bindString(model.getTDSYNQ())));// ����ʣ��ʹ������
			paramsList.add(setNameValuePair(captureName("NTDYT"), Common.bindString(model.getNTDYT())));// ��������;
			paramsList.add(setNameValuePair(captureName("XQRJL"), Common.bindString(model.getXQRJL())));// �����ݻ���
			paramsList.add(setNameValuePair(captureName("XQLJKD"), Common.bindString(model.getXQLJKD())));// �����ٽֿ��
			paramsList.add(setNameValuePair(captureName("LJSD"), Common.bindString(model.getLJSD())));// �ٽ����
			paramsList.add(setNameValuePair(captureName("XQJZLX"), Common.bindString(model.getXQJZLX())));// ����������
			paramsList.add(setNameValuePair(captureName("XQJZCS"), Common.bindString(model.getXQJZCS())));// ����������
			paramsList.add(setNameValuePair(captureName("XQFWJG"), Common.bindString(model.getXQFWJG())));// �����ݽṹ
			paramsList.add(setNameValuePair(captureName("JGSJ"), Common.bindString(model.getJGSJ())));// ����ʱ��
			paramsList.add(setNameValuePair(captureName("XQFWCXD"), Common.bindString(model.getXQFWCXD())));// �����ݳ��¶�
			paramsList.add(setNameValuePair(captureName("ZXSJ"), Common.bindString(model.getZXSJ())));// װ��ʱ��
			paramsList.add(setNameValuePair(captureName("XQZXCD"), Common.bindString(model.getXQZXCD())));// ����װ�޳̶�
			paramsList.add(setNameValuePair(captureName("XQCZLC"), Common.bindString(model.getXQCZLC())));// �������¥��
			paramsList.add(setNameValuePair(captureName("XQCZYT"), Common.bindString(model.getXQCZYT())));// ���������;
			paramsList.add(setNameValuePair(captureName("XQCZMJ"), Common.bindString(model.getXQCZMJ())));// ������⽨�����
			paramsList.add(setNameValuePair(captureName("XQCZSJ"), Common.bindString(model.getXQCZSJ())));// �������ʱ��
			paramsList.add(setNameValuePair(captureName("XQZQ"), Common.bindString(model.getXQZQ())));// �������ڣ��꣩
			paramsList.add(setNameValuePair(captureName("XQHX"), Common.bindString(model.getXQHX())));// ����סլ����
			paramsList.add(setNameValuePair(captureName("XQPTSS"), Common.bindString(model.getXQPTSS())));// ����������ʩ
			paramsList.add(setNameValuePair(captureName("XQZBJT"), Common.bindString(model.getXQZBJT())));// �����ܱ߽�ͨ
			paramsList.add(setNameValuePair(captureName("XQNZJ"), Common.bindString(model.getXQNZJ())));// ���������
			paramsList.add(setNameValuePair(captureName("NYJ"), Common.bindString(model.getNYJ())));// ��Ѻ��

			/** ������Ϣ **/
			paramsList.add(setNameValuePair(captureName("TDJB"), Common.bindString(model.getTDJB())));// �������ؼ���
			paramsList.add(setNameValuePair(captureName("DJQD"), Common.bindString(model.getDJQD())));// ���ڵؼ�����
			paramsList.add(setNameValuePair(captureName("XZQDM"), Common.bindString(model.getXZQDM())));// ����������

			/** λ����Ϣ **/
			paramsList.add(setNameValuePair(captureName("X"), Common.bindString(model.getX())));// X����
			paramsList.add(setNameValuePair(captureName("Y"), Common.bindString(model.getY())));// Y����
			paramsList.add(setNameValuePair(captureName("ZBXT"), Common.bindString(model.getZBXT())));// ����ϵͳ
			paramsList.add(setNameValuePair(captureName("REMARK"), Common.bindString(model.getREMARK())));// ��ע

			/** ϵͳ��Ϣ **/
			paramsList.add(setNameValuePair(captureName("INPUTUSERID"), Common.bindString(model.getINPUTUSERID())));// �����û�
			paramsList.add(setNameValuePair(captureName("CREATETIME"), Common.bindString(model.getCREATETIME())));// ����ʱ��
			paramsList.add(setNameValuePair(captureName("LASTUPDATEUSERID"), Common.bindString(model.getLASTUPDATEUSERID())));// �޸��û�
			paramsList.add(setNameValuePair(captureName("UPDATETIME"), Common.bindString(model.getUPDATETIME())));// �޸�ʱ��
			paramsList.add(setNameValuePair(captureName("ISDELETE"), Common.bindString(model.getISDELETE())));// �Ƿ�ɾ��
			paramsList.add(setNameValuePair(captureName("SHOWSEQ"), Common.bindString(model.getSHOWSEQ())));// ��ʾ˳��
		}
	}

	/**
	 * ˵����TODO(������һ�仰�����������������)
	 * 
	 * @param info
	 * @param paramsList
	 * @return void
	 */
	private void setModelCollectionMarketDemandHouseSell(LocationInfo info, List<NameValuePair> paramsList) {
		ModelCollectionMarketDemandHouseSell model = DataSupport.find(ModelCollectionMarketDemandHouseSell.class, info.getCollectionId());
		if (model != null) {
			/** ������Ϣ **/
			paramsList.add(setNameValuePair(captureName("THENAME"), Common.bindString(model.getTHENAME())));// ��¼����
			paramsList.add(setNameValuePair(captureName("THECODE"), Common.bindString(model.getTHECODE())));// ��¼����

			/** ���س���������Ϣ **/
			paramsList.add(setNameValuePair(captureName("XQGMF"), Common.bindString(model.getXQGMF())));// ������
			paramsList.add(setNameValuePair(captureName("NTDZL"), Common.bindString(model.getNTDZL())));// ����������
			paramsList.add(setNameValuePair(captureName("NQSXZ"), Common.bindString(model.getNQSXZ())));// ��Ȩ������
			paramsList.add(setNameValuePair(captureName("SFESF"), Common.bindString(model.getSFESF())));// �Ƿ���ַ�
			paramsList.add(setNameValuePair(captureName("SFZAJF"), Common.bindString(model.getSFZAJF())));// �Ƿ�ת���ҷ�
			paramsList.add(setNameValuePair(captureName("TDSYKNQ"), Common.bindString(model.getTDSYKNQ())));// ����ʣ��ʹ������
			paramsList.add(setNameValuePair(captureName("NTDYT"), Common.bindString(model.getNTDYT())));// ��������;
			paramsList.add(setNameValuePair(captureName("XQGMSJ"), Common.bindString(model.getXQGMSJ())));// ������ʱ��
			paramsList.add(setNameValuePair(captureName("XQCSMJ"), Common.bindString(model.getXQCSMJ())));// �����������
			paramsList.add(setNameValuePair(captureName("XQKSYMJYQ"), Common.bindString(model.getXQKSYMJYQ())));// �����ʹ�����
			paramsList.add(setNameValuePair(captureName("XQRJL"), Common.bindString(model.getXQRJL())));// �����ݻ���
			paramsList.add(setNameValuePair(captureName("XQLJKD"), Common.bindString(model.getXQLJKD())));// �����ٽֿ��
			paramsList.add(setNameValuePair(captureName("XQLJSD"), Common.bindString(model.getXQLJSD())));// �����ٽ����
			paramsList.add(setNameValuePair(captureName("XQJZLX"), Common.bindString(model.getXQJZLX())));// ����������
			paramsList.add(setNameValuePair(captureName("XQJZCS"), Common.bindString(model.getXQJZCS())));// ����������
			paramsList.add(setNameValuePair(captureName("XQFWJG"), Common.bindString(model.getXQFWJG())));// �����ݽṹ
			paramsList.add(setNameValuePair(captureName("XQJGSJ"), Common.bindString(model.getXQJGSJ())));// ���󿢹�ʱ��
			paramsList.add(setNameValuePair(captureName("XQFWCXD"), Common.bindString(model.getXQFWCXD())));// �����ݳ��¶�
			paramsList.add(setNameValuePair(captureName("XQZXSJ"), Common.bindString(model.getXQZXSJ())));// ����װ��ʱ��
			paramsList.add(setNameValuePair(captureName("XQZXCD"), Common.bindString(model.getXQZXCD())));// ����װ�޳̶�
			paramsList.add(setNameValuePair(captureName("XQZZHX"), Common.bindString(model.getXQZZHX())));// ����סլ����
			paramsList.add(setNameValuePair(captureName("XQPTSS"), Common.bindString(model.getXQPTSS())));// ����������ʩ
			paramsList.add(setNameValuePair(captureName("XQZBJT"), Common.bindString(model.getXQZBJT())));// �����ܱ߽�ͨ
			paramsList.add(setNameValuePair(captureName("XQDWMJSJ"), Common.bindString(model.getXQDWMJSJ())));// ����λ����ۼ�
			paramsList.add(setNameValuePair(captureName("XQZSJ"), Common.bindString(model.getXQZSJ())));// �������ۼ�

			/** ������Ϣ **/
			paramsList.add(setNameValuePair(captureName("TDJB"), Common.bindString(model.getTDJB())));// �������ؼ���
			paramsList.add(setNameValuePair(captureName("DJQD"), Common.bindString(model.getDJQD())));// ���ڵؼ�����
			paramsList.add(setNameValuePair(captureName("XZQDM"), Common.bindString(model.getXZQDM())));// ����������

			/** λ����Ϣ **/
			paramsList.add(setNameValuePair(captureName("X"), Common.bindString(model.getX())));// X����
			paramsList.add(setNameValuePair(captureName("Y"), Common.bindString(model.getY())));// Y����
			paramsList.add(setNameValuePair(captureName("ZBXT"), Common.bindString(model.getZBXT())));// ����ϵͳ
			paramsList.add(setNameValuePair(captureName("REMARK"), Common.bindString(model.getREMARK())));// ��ע

			/** ϵͳ��Ϣ **/
			paramsList.add(setNameValuePair(captureName("INPUTUSERID"), Common.bindString(model.getINPUTUSERID())));// �����û�
			paramsList.add(setNameValuePair(captureName("CREATETIME"), Common.bindString(model.getCREATETIME())));// ����ʱ��
			paramsList.add(setNameValuePair(captureName("LASTUPDATEUSERID"), Common.bindString(model.getLASTUPDATEUSERID())));// �޸��û�
			paramsList.add(setNameValuePair(captureName("UPDATETIME"), Common.bindString(model.getUPDATETIME())));// �޸�ʱ��
			paramsList.add(setNameValuePair(captureName("ISDELETE"), Common.bindString(model.getISDELETE())));// �Ƿ�ɾ��
			paramsList.add(setNameValuePair(captureName("SHOWSEQ"), Common.bindString(model.getSHOWSEQ())));// ��ʾ˳��
		}
	}

	/**
	 * ˵����TODO(������һ�仰�����������������)
	 * 
	 * @param info
	 * @param paramsList
	 * @return void
	 */
	private void setModelCollectionMarketDemandRent(LocationInfo info, List<NameValuePair> paramsList) {
		ModelCollectionMarketDemandRent model = DataSupport.find(ModelCollectionMarketDemandRent.class, info.getCollectionId());
		if (model != null) {
			/** ������Ϣ **/
			paramsList.add(setNameValuePair(captureName("THENAME"), Common.bindString(model.getTHENAME())));// ��¼����
			paramsList.add(setNameValuePair(captureName("THECODE"), Common.bindString(model.getTHECODE())));// ��¼����

			/** ����ʹ��Ȩ����������Ϣ **/
			paramsList.add(setNameValuePair(captureName("XQCZF"), Common.bindString(model.getXQCZF())));// ������ⷽ
			paramsList.add(setNameValuePair(captureName("XQCZFZTXZ"), Common.bindString(model.getXQCZFZTXZ())));// ������ⷽ��������
			paramsList.add(setNameValuePair(captureName("NTDZL"), Common.bindString(model.getNTDZL())));// ����������
			paramsList.add(setNameValuePair(captureName("NQSXZ"), Common.bindString(model.getNQSXZ())));// ��Ȩ������
			paramsList.add(setNameValuePair(captureName("XQXZTDTJ"), Common.bindString(model.getXQXZTDTJ())));// ������״��������
			paramsList.add(setNameValuePair(captureName("XQCZSJ"), Common.bindString(model.getXQCZSJ())));// �������ʱ��
			paramsList.add(setNameValuePair(captureName("XQZQ"), Common.bindString(model.getXQZQ())));// ��������
			paramsList.add(setNameValuePair(captureName("XQCZMJ"), Common.bindString(model.getXQCZMJ())));// �������س������
			paramsList.add(setNameValuePair(captureName("CZQYT"), Common.bindString(model.getCZQYT())));// ����ǰ��;
			paramsList.add(setNameValuePair(captureName("NCZYT"), Common.bindString(model.getNCZYT())));// ��������;
			paramsList.add(setNameValuePair(captureName("TDSYNQ"), Common.bindString(model.getTDSYNQ())));// ����ʣ��ʹ������
			paramsList.add(setNameValuePair(captureName("RJL"), Common.bindString(model.getRJL())));// �ڵ��ݻ���
			paramsList.add(setNameValuePair(captureName("XQNZJ"), Common.bindString(model.getXQNZJ())));// ���������
			paramsList.add(setNameValuePair(captureName("NYJ"), Common.bindString(model.getNYJ())));// ��Ѻ��

			/** ������Ϣ **/
			paramsList.add(setNameValuePair(captureName("TDJB"), Common.bindString(model.getTDJB())));// �������ؼ���
			paramsList.add(setNameValuePair(captureName("DJQD"), Common.bindString(model.getDJQD())));// ���ڵؼ�����
			paramsList.add(setNameValuePair(captureName("XZQDM"), Common.bindString(model.getXZQDM())));// ����������

			/** λ����Ϣ **/
			paramsList.add(setNameValuePair(captureName("X"), Common.bindString(model.getX())));// X����
			paramsList.add(setNameValuePair(captureName("Y"), Common.bindString(model.getY())));// Y����
			paramsList.add(setNameValuePair(captureName("ZBXT"), Common.bindString(model.getZBXT())));// ����ϵͳ
			paramsList.add(setNameValuePair(captureName("REMARK"), Common.bindString(model.getREMARK())));// ��ע

			/** ϵͳ��Ϣ **/
			paramsList.add(setNameValuePair(captureName("INPUTUSERID"), Common.bindString(model.getINPUTUSERID())));// �����û�
			paramsList.add(setNameValuePair(captureName("CREATETIME"), Common.bindString(model.getCREATETIME())));// ����ʱ��
			paramsList.add(setNameValuePair(captureName("LASTUPDATEUSERID"), Common.bindString(model.getLASTUPDATEUSERID())));// �޸��û�
			paramsList.add(setNameValuePair(captureName("UPDATETIME"), Common.bindString(model.getUPDATETIME())));// �޸�ʱ��
			paramsList.add(setNameValuePair(captureName("ISDELETE"), Common.bindString(model.getISDELETE())));// �Ƿ�ɾ��
			paramsList.add(setNameValuePair(captureName("SHOWSEQ"), Common.bindString(model.getSHOWSEQ())));// ��ʾ˳��
		}
	}

	/**
	 * ˵����TODO(������һ�仰�����������������)
	 * 
	 * @param info
	 * @param paramsList
	 * @return void
	 */
	private void setModelCollectionMarketSupplyTransfer(LocationInfo info, List<NameValuePair> paramsList) {
		ModelCollectionMarketSupplyTransfer model = DataSupport.find(ModelCollectionMarketSupplyTransfer.class, info.getCollectionId());
		if (model != null) {
			paramsList.add(setNameValuePair("Thename", Common.bindString(model.getTHENAME())));
			paramsList.add(setNameValuePair("Thecode", Common.bindString(model.getTHECODE())));
			/** ����ʹ��Ȩת�ù�Ӧ��Ϣ **/
			paramsList.add(setNameValuePair(captureName("TDSYZ"), Common.bindString(model.getTDSYZ())));// ����������
			paramsList.add(setNameValuePair(captureName("TDZSH"), Common.bindString(model.getTDZSH())));// ����֤���
			paramsList.add(setNameValuePair(captureName("TDZL"), Common.bindString(model.getTDZL())));// ��������
			paramsList.add(setNameValuePair(captureName("QSXZ"), Common.bindString(model.getQSXZ())));// Ȩ������
			paramsList.add(setNameValuePair(captureName("ZRF"), Common.bindString(model.getZRF())));// ת�÷�
			paramsList.add(setNameValuePair(captureName("NZRSJ"), Common.bindString(model.getNZRSJ())));// ��ת��ʱ��
			paramsList.add(setNameValuePair(captureName("NZRFS"), Common.bindString(model.getNZRFS())));// ��ת�÷�ʽ
			paramsList.add(setNameValuePair(captureName("NZRMJ"), Common.bindString(model.getNZRMJ())));// ������ת�����
			paramsList.add(setNameValuePair(captureName("ZRQYT"), Common.bindString(model.getZRQYT())));// ת��ǰ��;
			paramsList.add(setNameValuePair(captureName("NZRHYT"), Common.bindString(model.getNZRHYT())));// ��ת�ú���;
			paramsList.add(setNameValuePair(captureName("TDSYNQ"), Common.bindString(model.getTDSYNQ())));// ����ʣ��ʹ������
			paramsList.add(setNameValuePair(captureName("ZRDJ"), Common.bindString(model.getZRDJ())));// ������ת�õ���
			paramsList.add(setNameValuePair(captureName("ZRZJ"), Common.bindString(model.getZRZJ())));// ������ת���ܼ�

			/** ������Ϣ **/
			paramsList.add(setNameValuePair(captureName("RJL"), Common.bindString(model.getRJL())));// �ݻ���
			paramsList.add(setNameValuePair(captureName("HXWKFSP"), Common.bindString(model.getHXWKFSP())));// �����⿪��ˮƽ
			paramsList.add(setNameValuePair(captureName("HXNKFSP"), Common.bindString(model.getHXNKFSP())));// �����ڿ���ˮƽ
			paramsList.add(setNameValuePair(captureName("TDJB"), Common.bindString(model.getTDJB())));// �������ؼ���
			paramsList.add(setNameValuePair(captureName("DJQD"), Common.bindString(model.getDJQD())));// ���ڵؼ�����
			paramsList.add(setNameValuePair(captureName("XZQDM"), Common.bindString(model.getXZQDM())));// ����������

			/** λ����Ϣ **/
			paramsList.add(setNameValuePair(captureName("X"), Common.bindString(model.getX())));// X����
			paramsList.add(setNameValuePair(captureName("Y"), Common.bindString(model.getY())));// Y����
			paramsList.add(setNameValuePair(captureName("ZBXT"), Common.bindString(model.getZBXT())));// ����ϵͳ
			paramsList.add(setNameValuePair(captureName("REMARK"), Common.bindString(model.getREMARK())));// ��ע
			/** ϵͳ��Ϣ **/
			paramsList.add(setNameValuePair(captureName("INPUTUSERID"), Common.bindString(model.getINPUTUSERID())));// �����û�
			paramsList.add(setNameValuePair(captureName("CREATETIME"), Common.bindString(model.getCREATETIME())));// ����ʱ��
			paramsList.add(setNameValuePair(captureName("LASTUPDATEUSERID"), Common.bindString(model.getLASTUPDATEUSERID())));// �޸��û�
			paramsList.add(setNameValuePair(captureName("UPDATETIME"), Common.bindString(model.getUPDATETIME())));// �޸�ʱ��
			paramsList.add(setNameValuePair(captureName("ISDELETE"), Common.bindString(model.getISDELETE())));// �Ƿ�ɾ��
			paramsList.add(setNameValuePair(captureName("SHOWSEQ"), Common.bindString(model.getSHOWSEQ())));// ��ʾ˳��
		}
	}

	/**
	 * ˵����TODO(������һ�仰�����������������)
	 * 
	 * @param info
	 * @param paramsList
	 * @return void
	 */
	private void setModelCollectionMarketSupplyShareHolder(LocationInfo info, List<NameValuePair> paramsList) {
		ModelCollectionMarketSupplyShareHolder model = DataSupport.find(ModelCollectionMarketSupplyShareHolder.class, info.getCollectionId());
		if (model != null) {
			paramsList.add(setNameValuePair("Thename", Common.bindString(model.getTHENAME())));
			paramsList.add(setNameValuePair("Thecode", Common.bindString(model.getTHECODE())));
			/** ������Ӫ��ɹ�Ӧ��Ϣ **/
			paramsList.add(setNameValuePair(captureName("TDSYZ"), Common.bindString(model.getTDSYZ())));// ����������
			paramsList.add(setNameValuePair(captureName("TDZSH"), Common.bindString(model.getTDZSH())));// ����֤���
			paramsList.add(setNameValuePair(captureName("TDZL"), Common.bindString(model.getTDZL())));// ��������
			paramsList.add(setNameValuePair(captureName("QSXZ"), Common.bindString(model.getQSXZ())));// Ȩ������
			paramsList.add(setNameValuePair(captureName("CDF"), Common.bindString(model.getCDF())));// ���ط�
			paramsList.add(setNameValuePair(captureName("NLYSJ"), Common.bindString(model.getNLYSJ())));// ����Ӫʱ��
			paramsList.add(setNameValuePair(captureName("NLYQ"), Common.bindString(model.getNLYQ())));// ����Ӫ��
			paramsList.add(setNameValuePair(captureName("NCDMJ"), Common.bindString(model.getNCDMJ())));// ����ط�Ͷ���������
			paramsList.add(setNameValuePair(captureName("NCZZE"), Common.bindString(model.getNCZZE())));// ����ʷ�Ͷ���ʽ��ܶ�
			paramsList.add(setNameValuePair(captureName("NCDFFCBL"), Common.bindString(model.getNCDFFCBL())));// ����ط�����ֳɱ���
			paramsList.add(setNameValuePair(captureName("NTDNCSR"), Common.bindString(model.getNTDNCSR())));// �ⵥλ��������괿����
			paramsList.add(setNameValuePair(captureName("NCDFNCSR"), Common.bindString(model.getNCDFNCSR())));// ����ط������괿����
			paramsList.add(setNameValuePair(captureName("LYQYT"), Common.bindString(model.getLYQYT())));// ��Ӫǰ��;
			paramsList.add(setNameValuePair(captureName("LYHGHYT"), Common.bindString(model.getLYHGHYT())));// ��Ӫ��滮��;

			/** ������Ϣ **/
			paramsList.add(setNameValuePair(captureName("GHRJL"), Common.bindString(model.getGHRJL())));// �滮�ڵ��ݻ���
			paramsList.add(setNameValuePair(captureName("GHHXWKFSP"), Common.bindString(model.getGHHXWKFSP())));// �滮�����⿪��ˮƽ
			paramsList.add(setNameValuePair(captureName("GHHXNKFSP"), Common.bindString(model.getGHHXNKFSP())));// �滮�����ڿ���ˮƽ
			paramsList.add(setNameValuePair(captureName("TDJB"), Common.bindString(model.getTDJB())));// �������ؼ���
			paramsList.add(setNameValuePair(captureName("DJQD"), Common.bindString(model.getDJQD())));// ���ڵؼ�����
			paramsList.add(setNameValuePair(captureName("XZQDM"), Common.bindString(model.getXZQDM())));// ����������

			/** λ����Ϣ **/
			paramsList.add(setNameValuePair(captureName("X"), Common.bindString(model.getX())));// X����
			paramsList.add(setNameValuePair(captureName("Y"), Common.bindString(model.getY())));// Y����
			paramsList.add(setNameValuePair(captureName("ZBXT"), Common.bindString(model.getZBXT())));// ����ϵͳ
			paramsList.add(setNameValuePair(captureName("REMARK"), Common.bindString(model.getREMARK())));// ��ע
			/** ϵͳ��Ϣ **/
			paramsList.add(setNameValuePair(captureName("INPUTUSERID"), Common.bindString(model.getINPUTUSERID())));// �����û�
			paramsList.add(setNameValuePair(captureName("CREATETIME"), Common.bindString(model.getCREATETIME())));// ����ʱ��
			paramsList.add(setNameValuePair(captureName("LASTUPDATEUSERID"), Common.bindString(model.getLASTUPDATEUSERID())));// �޸��û�
			paramsList.add(setNameValuePair(captureName("UPDATETIME"), Common.bindString(model.getUPDATETIME())));// �޸�ʱ��
			paramsList.add(setNameValuePair(captureName("ISDELETE"), Common.bindString(model.getISDELETE())));// �Ƿ�ɾ��
			paramsList.add(setNameValuePair(captureName("SHOWSEQ"), Common.bindString(model.getSHOWSEQ())));// ��ʾ˳��
		}
	}

	/**
	 * ˵����TODO(������һ�仰�����������������)
	 * 
	 * @param info
	 * @param paramsList
	 * @return void
	 */
	private void setModelCollectionMarketSupplySell(LocationInfo info, List<NameValuePair> paramsList) {
		ModelCollectionMarketSupplySell model = DataSupport.find(ModelCollectionMarketSupplySell.class, info.getCollectionId());
		if (model != null) {
			paramsList.add(setNameValuePair("Thename", Common.bindString(model.getTHENAME())));
			paramsList.add(setNameValuePair("Thecode", Common.bindString(model.getTHECODE())));
			/** ����ʹ��Ȩ���ù�Ӧ��Ϣ **/
			paramsList.add(setNameValuePair(captureName("TDSYZ"), Common.bindString(model.getTDSYZ())));// ����������
			paramsList.add(setNameValuePair(captureName("ZDBH"), Common.bindString(model.getZDBH())));// �ڵر��
			paramsList.add(setNameValuePair(captureName("TDZL"), Common.bindString(model.getTDZL())));// ��������
			paramsList.add(setNameValuePair(captureName("QSXZ"), Common.bindString(model.getQSXZ())));// Ȩ������
			paramsList.add(setNameValuePair(captureName("NCRSJ"), Common.bindString(model.getNCRSJ())));// �����ʱ��
			paramsList.add(setNameValuePair(captureName("CRFS"), Common.bindString(model.getCRFS())));// ����÷�ʽ
			paramsList.add(setNameValuePair(captureName("NCRNQ"), Common.bindString(model.getNCRNQ())));// ���������
			paramsList.add(setNameValuePair(captureName("SFZKF"), Common.bindString(model.getSFZKF())));// �Ƿ��ٿ���
			paramsList.add(setNameValuePair(captureName("SFLYD"), Common.bindString(model.getSFLYD())));// �Ƿ����õ�
			paramsList.add(setNameValuePair(captureName("GHTDMJ"), Common.bindString(model.getGHTDMJ())));// �滮���߷�Χ�������
			paramsList.add(setNameValuePair(captureName("NDZTDMJ"), Common.bindString(model.getNDZTDMJ())));// ������������
			paramsList.add(setNameValuePair(captureName("CRQYT"), Common.bindString(model.getCRQYT())));// ����ǰ��;
			paramsList.add(setNameValuePair(captureName("CRHGHYT"), Common.bindString(model.getCRHGHYT())));// ���ú�滮��;
			paramsList.add(setNameValuePair(captureName("NCRDJ"), Common.bindString(model.getNCRDJ())));// �ⵥλ������س��ü�
			paramsList.add(setNameValuePair(captureName("NCRZJ"), Common.bindString(model.getNCRZJ())));// �����س����ܼ�

			/** ������Ϣ **/
			paramsList.add(setNameValuePair(captureName("GHRJL"), Common.bindString(model.getGHRJL())));// �滮�ڵ��ݻ���
			paramsList.add(setNameValuePair(captureName("GHHXWKFSP"), Common.bindString(model.getGHHXWKFSP())));// �滮�����⿪��ˮƽ
			paramsList.add(setNameValuePair(captureName("GHHXNKFSP"), Common.bindString(model.getGHHXNKFSP())));// �滮�����ڿ���ˮƽ
			paramsList.add(setNameValuePair(captureName("TDJB"), Common.bindString(model.getTDJB())));// �������ؼ���
			paramsList.add(setNameValuePair(captureName("DJQD"), Common.bindString(model.getDJQD())));// ���ڵؼ�����
			paramsList.add(setNameValuePair(captureName("XZQDM"), Common.bindString(model.getXZQDM())));// ����������

			/** λ����Ϣ **/
			paramsList.add(setNameValuePair(captureName("X"), Common.bindString(model.getX())));// X����
			paramsList.add(setNameValuePair(captureName("Y"), Common.bindString(model.getY())));// Y����
			paramsList.add(setNameValuePair(captureName("ZBXT"), Common.bindString(model.getZBXT())));// ����ϵͳ
			paramsList.add(setNameValuePair(captureName("REMARK"), Common.bindString(model.getREMARK())));// ��ע
			/** ϵͳ��Ϣ **/
			paramsList.add(setNameValuePair(captureName("INPUTUSERID"), Common.bindString(model.getINPUTUSERID())));// �����û�
			paramsList.add(setNameValuePair(captureName("CREATETIME"), Common.bindString(model.getCREATETIME())));// ����ʱ��
			paramsList.add(setNameValuePair(captureName("LASTUPDATEUSERID"), Common.bindString(model.getLASTUPDATEUSERID())));// �޸��û�
			paramsList.add(setNameValuePair(captureName("UPDATETIME"), Common.bindString(model.getUPDATETIME())));// �޸�ʱ��
			paramsList.add(setNameValuePair(captureName("ISDELETE"), Common.bindString(model.getISDELETE())));// �Ƿ�ɾ��
			paramsList.add(setNameValuePair(captureName("SHOWSEQ"), Common.bindString(model.getSHOWSEQ())));// ��ʾ˳��
		}
	}

	/**
	 * ˵����TODO(������һ�仰�����������������)
	 * 
	 * @param info
	 * @param paramsList
	 * @return void
	 */
	private void setModelCollectionMarketSupplyRent(LocationInfo info, List<NameValuePair> paramsList) {
		ModelCollectionMarketSupplyRent model = DataSupport.find(ModelCollectionMarketSupplyRent.class, info.getCollectionId());
		if (model != null) {
			paramsList.add(setNameValuePair("Thename", Common.bindString(model.getTHENAME())));
			paramsList.add(setNameValuePair("Thecode", Common.bindString(model.getTHECODE())));
			/** ����ʹ��Ȩ���⹩Ӧ��Ϣ **/
			paramsList.add(setNameValuePair(captureName("TDSYZ"), Common.bindString(model.getTDSYZ())));// ����ʹ����
			paramsList.add(setNameValuePair(captureName("TDZSH"), Common.bindString(model.getTDZSH())));// ����֤���
			paramsList.add(setNameValuePair(captureName("TDZL"), Common.bindString(model.getTDZL())));// ��������
			paramsList.add(setNameValuePair(captureName("QSXZ"), Common.bindString(model.getQSXZ())));// Ȩ������
			paramsList.add(setNameValuePair(captureName("CZF"), Common.bindString(model.getCZF())));// ���ⷽ
			paramsList.add(setNameValuePair(captureName("NCZSJ"), Common.bindString(model.getNCZSJ())));// �����ʱ��
			paramsList.add(setNameValuePair(captureName("NZQ"), Common.bindString(model.getNZQ())));// ������
			paramsList.add(setNameValuePair(captureName("NCZMJ"), Common.bindString(model.getNCZMJ())));// �����س������
			paramsList.add(setNameValuePair(captureName("CZQYT"), Common.bindString(model.getCZQYT())));// ����ǰ��;
			paramsList.add(setNameValuePair(captureName("NCZHYT"), Common.bindString(model.getNCZHYT())));// ��������;
			paramsList.add(setNameValuePair(captureName("TDSYNQ"), Common.bindString(model.getTDSYNQ())));// ����ʣ��ʹ������
			paramsList.add(setNameValuePair(captureName("NZJ"), Common.bindString(model.getNZJ())));// �������
			paramsList.add(setNameValuePair(captureName("YJ"), Common.bindString(model.getYJ())));// ��Ѻ��
			paramsList.add(setNameValuePair(captureName("SF"), Common.bindString(model.getSF())));// ��˰��

			/** ������Ϣ **/
			paramsList.add(setNameValuePair(captureName("RJL"), Common.bindString(model.getRJL())));// �ݻ���
			paramsList.add(setNameValuePair(captureName("HXWKFSP"), Common.bindString(model.getHXWKFSP())));// �����⿪��ˮƽ
			paramsList.add(setNameValuePair(captureName("HXNKFSP"), Common.bindString(model.getHXNKFSP())));// �����ڿ���ˮƽ
			paramsList.add(setNameValuePair(captureName("TDJB"), Common.bindString(model.getTDJB())));// �������ؼ���
			paramsList.add(setNameValuePair(captureName("DJQD"), Common.bindString(model.getDJQD())));// ���ڵؼ�����
			paramsList.add(setNameValuePair(captureName("XZQDM"), Common.bindString(model.getXZQDM())));// ����������

			/** λ����Ϣ **/
			paramsList.add(setNameValuePair(captureName("X"), Common.bindString(model.getX())));// X����
			paramsList.add(setNameValuePair(captureName("Y"), Common.bindString(model.getY())));// Y����
			paramsList.add(setNameValuePair(captureName("ZBXT"), Common.bindString(model.getZBXT())));// ����ϵͳ
			paramsList.add(setNameValuePair(captureName("REMARK"), Common.bindString(model.getREMARK())));// ��ע
			/** ϵͳ��Ϣ **/
			paramsList.add(setNameValuePair(captureName("INPUTUSERID"), Common.bindString(model.getINPUTUSERID())));// �����û�
			paramsList.add(setNameValuePair(captureName("CREATETIME"), Common.bindString(model.getCREATETIME())));// ����ʱ��
			paramsList.add(setNameValuePair(captureName("LASTUPDATEUSERID"), Common.bindString(model.getLASTUPDATEUSERID())));// �޸��û�
			paramsList.add(setNameValuePair(captureName("UPDATETIME"), Common.bindString(model.getUPDATETIME())));// �޸�ʱ��
			paramsList.add(setNameValuePair(captureName("ISDELETE"), Common.bindString(model.getISDELETE())));// �Ƿ�ɾ��
			paramsList.add(setNameValuePair(captureName("SHOWSEQ"), Common.bindString(model.getSHOWSEQ())));// ��ʾ˳��
		}
	}

	/**
	 * ˵����TODO(������һ�仰�����������������)
	 * 
	 * @param info
	 * @param paramsList
	 * @return void
	 */
	private void setModelCollectionMarketSupplyHouseSell(LocationInfo info, List<NameValuePair> paramsList) {
		ModelCollectionMarketSupplyHouseSell model = DataSupport.find(ModelCollectionMarketSupplyHouseSell.class, info.getCollectionId());
		if (model != null) {
			paramsList.add(setNameValuePair("Thename", Common.bindString(model.getTHENAME())));
			paramsList.add(setNameValuePair("Thecode", Common.bindString(model.getTHECODE())));
			/** ���س��۹�Ӧ��Ϣ **/
			paramsList.add(setNameValuePair(captureName("TDSYZ"), Common.bindString(model.getTDSYZ())));// ����ʹ����
			paramsList.add(setNameValuePair(captureName("FWSYQR"), Common.bindString(model.getFWSYQR())));// ��������Ȩ��
			paramsList.add(setNameValuePair(captureName("TDZSH"), Common.bindString(model.getTDZSH())));// ����֤���
			paramsList.add(setNameValuePair(captureName("YSZSH"), Common.bindString(model.getYSZSH())));// Ԥ��֤���
			paramsList.add(setNameValuePair(captureName("TDZL"), Common.bindString(model.getTDZL())));// ��������
			paramsList.add(setNameValuePair(captureName("QSXZ"), Common.bindString(model.getQSXZ())));// Ȩ������
			paramsList.add(setNameValuePair(captureName("FDSYNQ"), Common.bindString(model.getFDSYNQ())));// ����ʣ��ʹ������
			paramsList.add(setNameValuePair(captureName("SFESF"), Common.bindString(model.getSFESF())));// �Ƿ���ַ�
			paramsList.add(setNameValuePair(captureName("SFZAJ"), Common.bindString(model.getSFZAJ())));// �Ƿ�ת����
			paramsList.add(setNameValuePair(captureName("CCZT"), Common.bindString(model.getCCZT())));// ����״̬
			paramsList.add(setNameValuePair(captureName("DYZT"), Common.bindString(model.getDYZT())));// ��Ѻ״̬
			paramsList.add(setNameValuePair(captureName("TDYT"), Common.bindString(model.getTDYT())));// ������;
			paramsList.add(setNameValuePair(captureName("LJKD"), Common.bindString(model.getLJKD())));// �ٽֿ��
			paramsList.add(setNameValuePair(captureName("LJSD"), Common.bindString(model.getLJSD())));// �ٽ����
			paramsList.add(setNameValuePair(captureName("JZLX"), Common.bindString(model.getJZLX())));// ��������
			paramsList.add(setNameValuePair(captureName("JZCS"), Common.bindString(model.getJZCS())));// ��������
			paramsList.add(setNameValuePair(captureName("FWJG"), Common.bindString(model.getFWJG())));// ���ݽṹ
			paramsList.add(setNameValuePair(captureName("JGSJ"), Common.bindString(model.getJGSJ())));// ����ʱ��
			paramsList.add(setNameValuePair(captureName("FWCXD"), Common.bindString(model.getFWCXD())));// ���ݳ��¶�
			paramsList.add(setNameValuePair(captureName("ZXSJ"), Common.bindString(model.getZXSJ())));// װ��ʱ��
			paramsList.add(setNameValuePair(captureName("ZXCD"), Common.bindString(model.getZXCD())));// װ�޳̶�
			paramsList.add(setNameValuePair(captureName("ZZHX"), Common.bindString(model.getZZHX())));// סլ����
			paramsList.add(setNameValuePair(captureName("PTSS"), Common.bindString(model.getPTSS())));// ������ʩ
			paramsList.add(setNameValuePair(captureName("ZBJT"), Common.bindString(model.getZBJT())));// �ܱ߽�ͨ
			paramsList.add(setNameValuePair(captureName("NCSLC"), Common.bindString(model.getNCSLC())));// �����¥��
			paramsList.add(setNameValuePair(captureName("NCSYT"), Common.bindString(model.getNCSYT())));// �������;
			paramsList.add(setNameValuePair(captureName("NCSMJ"), Common.bindString(model.getNCSMJ())));// ����۽������
			paramsList.add(setNameValuePair(captureName("NCSSJ"), Common.bindString(model.getNCSSJ())));// �����ʱ��
			paramsList.add(setNameValuePair(captureName("NDWMJSJ"), Common.bindString(model.getNDWMJSJ())));// �ⵥλ����ۼ�
			paramsList.add(setNameValuePair(captureName("NSJ"), Common.bindString(model.getNSJ())));// ���ۼ�
			paramsList.add(setNameValuePair(captureName("NSF"), Common.bindString(model.getNSF())));// ��˰��

			/** ������Ϣ **/
			paramsList.add(setNameValuePair(captureName("RJL"), Common.bindString(model.getRJL())));// �ݻ���
			paramsList.add(setNameValuePair(captureName("HXWKFSP"), Common.bindString(model.getHXWKFSP())));// �����⿪��ˮƽ
			paramsList.add(setNameValuePair(captureName("HXNKFSP"), Common.bindString(model.getHXNKFSP())));// �����ڿ���ˮƽ
			paramsList.add(setNameValuePair(captureName("TDJB"), Common.bindString(model.getTDJB())));// �������ؼ���
			paramsList.add(setNameValuePair(captureName("DJQD"), Common.bindString(model.getDJQD())));// ���ڵؼ�����
			paramsList.add(setNameValuePair(captureName("XZQDM"), Common.bindString(model.getXZQDM())));// ����������

			/** λ����Ϣ **/
			paramsList.add(setNameValuePair(captureName("X"), Common.bindString(model.getX())));// X����
			paramsList.add(setNameValuePair(captureName("Y"), Common.bindString(model.getY())));// Y����
			paramsList.add(setNameValuePair(captureName("ZBXT"), Common.bindString(model.getZBXT())));// ����ϵͳ
			paramsList.add(setNameValuePair(captureName("REMARK"), Common.bindString(model.getREMARK())));// ��ע
			/** ϵͳ��Ϣ **/
			paramsList.add(setNameValuePair(captureName("INPUTUSERID"), Common.bindString(model.getINPUTUSERID())));// �����û�
			paramsList.add(setNameValuePair(captureName("CREATETIME"), Common.bindString(model.getCREATETIME())));// ����ʱ��
			paramsList.add(setNameValuePair(captureName("LASTUPDATEUSERID"), Common.bindString(model.getLASTUPDATEUSERID())));// �޸��û�
			paramsList.add(setNameValuePair(captureName("UPDATETIME"), Common.bindString(model.getUPDATETIME())));// �޸�ʱ��
			paramsList.add(setNameValuePair(captureName("ISDELETE"), Common.bindString(model.getISDELETE())));// �Ƿ�ɾ��
			paramsList.add(setNameValuePair(captureName("SHOWSEQ"), Common.bindString(model.getSHOWSEQ())));// ��ʾ˳��
		}
	}

	/**
	 * ˵����TODO(������һ�仰�����������������)
	 * 
	 * @param info
	 * @param paramsList
	 * @return void
	 */
	private void setModelCollectionMarketSupplyHouseRent(LocationInfo info, List<NameValuePair> paramsList) {
		ModelCollectionMarketSupplyHouseRent model = DataSupport.find(ModelCollectionMarketSupplyHouseRent.class, info.getCollectionId());
		if (model != null) {
			paramsList.add(setNameValuePair("Thename", Common.bindString(model.getTHENAME())));
			paramsList.add(setNameValuePair("Thecode", Common.bindString(model.getTHECODE())));

			/** ���س��⹩Ӧ��Ϣ **/
			paramsList.add(setNameValuePair(captureName("TDSYZ"), Common.bindString(model.getTDSYZ())));// ����ʹ����
			paramsList.add(setNameValuePair(captureName("TDZSH"), Common.bindString(model.getTDZSH())));// ����֤���
			paramsList.add(setNameValuePair(captureName("TDZL"), Common.bindString(model.getTDZL())));// ��������
			paramsList.add(setNameValuePair(captureName("FWSYQR"), Common.bindString(model.getFWSYQR())));// ��������Ȩ��
			paramsList.add(setNameValuePair(captureName("QSXZ"), Common.bindString(model.getQSXZ())));// Ȩ������
			paramsList.add(setNameValuePair(captureName("CZF"), Common.bindString(model.getCZF())));// ���ⷽ
			paramsList.add(setNameValuePair(captureName("FDSYNQ"), Common.bindString(model.getFDSYNQ())));// ����ʣ��ʹ������
			paramsList.add(setNameValuePair(captureName("TDYT"), Common.bindString(model.getTDYT())));// ������;
			paramsList.add(setNameValuePair(captureName("LJKD"), Common.bindString(model.getLJKD())));// �ٽֿ��
			paramsList.add(setNameValuePair(captureName("LJSD"), Common.bindString(model.getLJSD())));// �ٽ����
			paramsList.add(setNameValuePair(captureName("JZLX"), Common.bindString(model.getJZLX())));// ��������
			paramsList.add(setNameValuePair(captureName("JZCS"), Common.bindString(model.getJZCS())));// ��������
			paramsList.add(setNameValuePair(captureName("FWJG"), Common.bindString(model.getFWJG())));// ���ݽṹ
			paramsList.add(setNameValuePair(captureName("JGSJ"), Common.bindString(model.getJGSJ())));// ����ʱ��
			paramsList.add(setNameValuePair(captureName("FWCXD"), Common.bindString(model.getFWCXD())));// ���ݳ��¶�
			paramsList.add(setNameValuePair(captureName("ZXSJ"), Common.bindString(model.getZXSJ())));// װ��ʱ��
			paramsList.add(setNameValuePair(captureName("ZXCD"), Common.bindString(model.getZXCD())));// װ�޳̶�
			paramsList.add(setNameValuePair(captureName("ZZHX"), Common.bindString(model.getZZHX())));// סլ����
			paramsList.add(setNameValuePair(captureName("PTSS"), Common.bindString(model.getPTSS())));// ������ʩ
			paramsList.add(setNameValuePair(captureName("ZBJT"), Common.bindString(model.getZBJT())));// �ܱ߽�ͨ
			paramsList.add(setNameValuePair(captureName("NCZLC"), Common.bindString(model.getNCZLC())));// �����¥��
			paramsList.add(setNameValuePair(captureName("NCZHYT"), Common.bindString(model.getNCZHYT())));// �������;
			paramsList.add(setNameValuePair(captureName("NCZMJ"), Common.bindString(model.getNCZMJ())));// ����⽨�����
			paramsList.add(setNameValuePair(captureName("NCZSJ"), Common.bindString(model.getNCZSJ())));// �����ʱ��
			paramsList.add(setNameValuePair(captureName("NZQ"), Common.bindString(model.getNZQ())));// ������(��)
			paramsList.add(setNameValuePair(captureName("NZJ"), Common.bindString(model.getNZJ())));// �������
			paramsList.add(setNameValuePair(captureName("NYJ"), Common.bindString(model.getNYJ())));// ��Ѻ��
			paramsList.add(setNameValuePair(captureName("NSF"), Common.bindString(model.getNSF())));// ��˰��

			/** ������Ϣ **/
			paramsList.add(setNameValuePair(captureName("RJL"), Common.bindString(model.getRJL())));// �ݻ���
			paramsList.add(setNameValuePair(captureName("HXWKFSP"), Common.bindString(model.getHXWKFSP())));// �����⿪��ˮƽ
			paramsList.add(setNameValuePair(captureName("HXNKFSP"), Common.bindString(model.getHXNKFSP())));// �����ڿ���ˮƽ
			paramsList.add(setNameValuePair(captureName("TDJB"), Common.bindString(model.getTDJB())));// �������ؼ���
			paramsList.add(setNameValuePair(captureName("DJQD"), Common.bindString(model.getDJQD())));// ���ڵؼ�����
			paramsList.add(setNameValuePair(captureName("XZQDM"), Common.bindString(model.getXZQDM())));// ����������

			/** λ����Ϣ **/
			paramsList.add(setNameValuePair(captureName("X"), Common.bindString(model.getX())));// X����
			paramsList.add(setNameValuePair(captureName("Y"), Common.bindString(model.getY())));// Y����
			paramsList.add(setNameValuePair(captureName("ZBXT"), Common.bindString(model.getZBXT())));// ����ϵͳ
			paramsList.add(setNameValuePair(captureName("REMARK"), Common.bindString(model.getREMARK())));// ��ע
			/** ϵͳ��Ϣ **/
			paramsList.add(setNameValuePair(captureName("INPUTUSERID"), Common.bindString(model.getINPUTUSERID())));// �����û�
			paramsList.add(setNameValuePair(captureName("CREATETIME"), Common.bindString(model.getCREATETIME())));// ����ʱ��
			paramsList.add(setNameValuePair(captureName("LASTUPDATEUSERID"), Common.bindString(model.getLASTUPDATEUSERID())));// �޸��û�
			paramsList.add(setNameValuePair(captureName("UPDATETIME"), Common.bindString(model.getUPDATETIME())));// �޸�ʱ��
			paramsList.add(setNameValuePair(captureName("ISDELETE"), Common.bindString(model.getISDELETE())));// �Ƿ�ɾ��
			paramsList.add(setNameValuePair(captureName("SHOWSEQ"), Common.bindString(model.getSHOWSEQ())));// ��ʾ˳��
		}
	}

	/**
	 * ˵����TODO(������һ�仰�����������������)
	 * 
	 * @param info
	 * @param paramsList
	 * @return void
	 */
	private void setModelCollectionMarketMonitorPoint(LocationInfo info, List<NameValuePair> paramsList) {
		ModelCollectionMarketMonitorPoint model = DataSupport.find(ModelCollectionMarketMonitorPoint.class, info.getCollectionId());
		if (model != null) {
			paramsList.add(setNameValuePair("Thename", Common.bindString(model.getTHENAME())));
			paramsList.add(setNameValuePair("Thecode", Common.bindString(model.getTHECODE())));
			/** �����г���ص���Ϣ **/
			paramsList.add(setNameValuePair(captureName("JCDMC"), Common.bindString(model.getJCDMC())));// ��������
			paramsList.add(setNameValuePair(captureName("TDZL"), Common.bindString(model.getTDZL())));// ��������
			paramsList.add(setNameValuePair(captureName("TDZSH"), Common.bindString(model.getTDZSH())));// ����֤���
			paramsList.add(setNameValuePair(captureName("QSXZ"), Common.bindString(model.getQSXZ())));// Ȩ������
			paramsList.add(setNameValuePair(captureName("GZQ"), Common.bindString(model.getGZQ())));// ������
			paramsList.add(setNameValuePair(captureName("TDYT"), Common.bindString(model.getTDYT())));// ������;
			paramsList.add(setNameValuePair(captureName("TDMJ"), Common.bindString(model.getTDMJ())));// �������
			paramsList.add(setNameValuePair(captureName("TDSYZ"), Common.bindString(model.getTDSYZ())));// ����������
			paramsList.add(setNameValuePair(captureName("TDSHYZ"), Common.bindString(model.getTDSHYZ())));// ����ʹ����
			paramsList.add(setNameValuePair(captureName("RJL"), Common.bindString(model.getRJL())));// �ݻ���
			paramsList.add(setNameValuePair(captureName("JZMJ"), Common.bindString(model.getJZMJ())));// �����ܶ�
			paramsList.add(setNameValuePair(captureName("JZXS"), Common.bindString(model.getJZXS())));// ����ϵ��
			paramsList.add(setNameValuePair(captureName("LDL"), Common.bindString(model.getLDL())));// �̵���
			paramsList.add(setNameValuePair(captureName("TDSYNQ"), Common.bindString(model.getTDSYNQ())));// ����ʹ������
			paramsList.add(setNameValuePair(captureName("ZDNKFSP"), Common.bindString(model.getZDNKFSP())));// �ڵ��ڿ���ˮƽ
			paramsList.add(setNameValuePair(captureName("ZSWKFSP"), Common.bindString(model.getZSWKFSP())));// �ڵ��⿪��ˮƽ
			paramsList.add(setNameValuePair(captureName("XZL"), Common.bindString(model.getXZL())));// ���������ʣ����ݿ����ʣ�
			paramsList.add(setNameValuePair(captureName("SCJG"), Common.bindString(model.getSCJG())));// �г��۸�
			paramsList.add(setNameValuePair(captureName("SCZJ"), Common.bindString(model.getSCZJ())));// �г����
			paramsList.add(setNameValuePair(captureName("DJTZ"), Common.bindString(model.getDJTZ())));// �ؾ��ۼƹ̶��ʲ�Ͷ��
			paramsList.add(setNameValuePair(captureName("DJCZ"), Common.bindString(model.getDJCZ())));// �ؾ���ֵ
			paramsList.add(setNameValuePair(captureName("DJSS"), Common.bindString(model.getDJSS())));// �ؾ�˰��
			paramsList.add(setNameValuePair(captureName("DJCYRY"), Common.bindString(model.getDJCYRY())));// �ؾ���ҵ��Ա����ס�˿ڣ�
			paramsList.add(setNameValuePair(captureName("SDRJL"), Common.bindString(model.getSDRJL())));// �趨�ݻ���
			paramsList.add(setNameValuePair(captureName("SDSYNQ"), Common.bindString(model.getSDSYNQ())));// �趨ʹ������
			paramsList.add(setNameValuePair(captureName("SDKFSP"), Common.bindString(model.getSDKFSP())));// �趨����ˮƽ
			paramsList.add(setNameValuePair(captureName("PGJG"), Common.bindString(model.getPGJG())));// �����۸�
			paramsList.add(setNameValuePair(captureName("TDJB"), Common.bindString(model.getTDJB())));// �������ؼ���
			paramsList.add(setNameValuePair(captureName("DJQD"), Common.bindString(model.getDJQD())));// ���ڵؼ�����
			paramsList.add(setNameValuePair(captureName("XZQDM"), Common.bindString(model.getXZQDM())));// ����������
			paramsList.add(setNameValuePair(captureName("REMARK"), Common.bindString(model.getREMARK())));// ��ע

			/** ϵͳ��Ϣ **/
			paramsList.add(setNameValuePair(captureName("INPUTUSERID"), Common.bindString(model.getINPUTUSERID())));// �����û�
			paramsList.add(setNameValuePair(captureName("CREATETIME"), Common.bindString(model.getCREATETIME())));// ����ʱ��
			paramsList.add(setNameValuePair(captureName("LASTUPDATEUSERID"), Common.bindString(model.getLASTUPDATEUSERID())));// �޸��û�
			paramsList.add(setNameValuePair(captureName("UPDATETIME"), Common.bindString(model.getUPDATETIME())));// �޸�ʱ��
			paramsList.add(setNameValuePair(captureName("ISDELETE"), Common.bindString(model.getISDELETE())));// �Ƿ�ɾ��
			paramsList.add(setNameValuePair(captureName("SHOWSEQ"), Common.bindString(model.getSHOWSEQ())));// ��ʾ˳��
		}
	}

	/**
	 * ˵����TODO(������һ�仰�����������������)
	 * 
	 * @param info
	 * @param paramsList
	 * @return void
	 */
	private void setModelCollectionMarketMonitorLandValue(LocationInfo info, List<NameValuePair> paramsList) {
		ModelCollectionMarketMonitorLandValue model = DataSupport.find(ModelCollectionMarketMonitorLandValue.class, info.getCollectionId());
		if (model != null) {
			paramsList.add(setNameValuePair("Thename", Common.bindString(model.getTHENAME())));
			paramsList.add(setNameValuePair("Thecode", Common.bindString(model.getTHECODE())));
			/** �ؼ�������Ϣ **/
			paramsList.add(setNameValuePair(captureName("BSM"), Common.bindString(model.getBSM())));// ��ʶ��
			paramsList.add(setNameValuePair(captureName("QDBH"), Common.bindString(model.getQDBH())));// ���α��
			paramsList.add(setNameValuePair(captureName("QDMC"), Common.bindString(model.getQDMC())));// ��������
			paramsList.add(setNameValuePair(captureName("QDWZ"), Common.bindString(model.getQDWZ())));// ����λ��
			paramsList.add(setNameValuePair(captureName("YTLX"), Common.bindString(model.getYTLX())));// ҵ̬����
			paramsList.add(setNameValuePair(captureName("TDJB"), Common.bindString(model.getTDJB())));// ���ؼ���
			paramsList.add(setNameValuePair(captureName("XZQDM"), Common.bindString(model.getXZQDM())));// ���ؼ���
			paramsList.add(setNameValuePair(captureName("QDMJ"), Common.bindString(model.getQDMJ())));// �������
			paramsList.add(setNameValuePair(captureName("SJYTMJ"), Common.bindString(model.getSJYTMJ())));// ʵ����;���
			paramsList.add(setNameValuePair(captureName("QDJCSSZK"), Common.bindString(model.getQDJCSSZK())));// ���λ�����ʩ״��
			paramsList.add(setNameValuePair(captureName("QDGGSSZK"), Common.bindString(model.getQDGGSSZK())));// ���ι���������ʩ״��
			paramsList.add(setNameValuePair(captureName("DZ"), Common.bindString(model.getDZ())));// ����
			paramsList.add(setNameValuePair(captureName("NZ"), Common.bindString(model.getNZ())));// ����
			paramsList.add(setNameValuePair(captureName("XZ"), Common.bindString(model.getXZ())));// ����
			paramsList.add(setNameValuePair(captureName("BZ"), Common.bindString(model.getBZ())));// ����
			paramsList.add(setNameValuePair(captureName("QD"), Common.bindString(model.getQD())));// �̷�·�����
			paramsList.add(setNameValuePair(captureName("ZD"), Common.bindString(model.getZD())));// �̷�·��ֹ��
			paramsList.add(setNameValuePair(captureName("XZRJL"), Common.bindString(model.getXZRJL())));// ��״�ݻ���
			paramsList.add(setNameValuePair(captureName("ZYSYLX"), Common.bindString(model.getZYSYLX())));// ��Ҫ�̷�����
			paramsList.add(setNameValuePair(captureName("JCNF"), Common.bindString(model.getJCNF())));// ������ݼ�������״��
			paramsList.add(setNameValuePair(captureName("XSZGZJ"), Common.bindString(model.getXSZGZJ())));// ��ʱ��������
			paramsList.add(setNameValuePair(captureName("XSPJZJ"), Common.bindString(model.getXSPJZJ())));// ��ʱƽ�������
			paramsList.add(setNameValuePair(captureName("XSZDZJ"), Common.bindString(model.getXSZDZJ())));// ��ʱ��������
			paramsList.add(setNameValuePair(captureName("XSZGSJ"), Common.bindString(model.getXSZGSJ())));// ��ʱ����ۼ�
			paramsList.add(setNameValuePair(captureName("XSPJSJ"), Common.bindString(model.getXSPJSJ())));// ��ʱƽ���ۼ�
			paramsList.add(setNameValuePair(captureName("XSZDSJ"), Common.bindString(model.getXSZDSJ())));// ��ʱ����ۼ�
			paramsList.add(setNameValuePair(captureName("JZR"), Common.bindString(model.getJZR())));// ������׼��
			paramsList.add(setNameValuePair(captureName("SDNQ"), Common.bindString(model.getSDNQ())));// �趨����
			paramsList.add(setNameValuePair(captureName("SDRJL"), Common.bindString(model.getSDRJL())));// �趨�ݻ���
			paramsList.add(setNameValuePair(captureName("SDKFSP"), Common.bindString(model.getSDKFSP())));// �趨����ˮƽ
			paramsList.add(setNameValuePair(captureName("SYLXBZSD"), Common.bindString(model.getSYLXBZSD())));// ��ҵ·�߱�׼���
			paramsList.add(setNameValuePair(captureName("DMJZDJ"), Common.bindString(model.getDMJZDJ())));// �����׼�ؼ�
			paramsList.add(setNameValuePair(captureName("LMJZDJ"), Common.bindString(model.getLMJZDJ())));// ¥���׼�ؼ�
			paramsList.add(setNameValuePair(captureName("REMARK"), Common.bindString(model.getREMARK())));// ��ע

			/** ϵͳ��Ϣ **/
			paramsList.add(setNameValuePair(captureName("INPUTUSERID"), Common.bindString(model.getINPUTUSERID())));// �����û�
			paramsList.add(setNameValuePair(captureName("CREATETIME"), Common.bindString(model.getCREATETIME())));// ����ʱ��
			paramsList.add(setNameValuePair(captureName("LASTUPDATEUSERID"), Common.bindString(model.getLASTUPDATEUSERID())));// �޸��û�
			paramsList.add(setNameValuePair(captureName("UPDATETIME"), Common.bindString(model.getUPDATETIME())));// �޸�ʱ��
			paramsList.add(setNameValuePair(captureName("ISDELETE"), Common.bindString(model.getISDELETE())));// �Ƿ�ɾ��
			paramsList.add(setNameValuePair(captureName("SHOWSEQ"), Common.bindString(model.getSHOWSEQ())));// ��ʾ˳��
		}
	}

	/**
	 * ˵����TODO(������һ�仰�����������������)
	 * 
	 * @param info
	 * @param paramsList
	 * @return void
	 */
	private void setModelCollectionMarketMonitorLandLevel(LocationInfo info, List<NameValuePair> paramsList) {
		ModelCollectionMarketMonitorLandLevel model = DataSupport.find(ModelCollectionMarketMonitorLandLevel.class, info.getCollectionId());
		if (model != null) {
			/** ������Ϣ **/
			paramsList.add(setNameValuePair("Thename", Common.bindString(model.getTHENAME())));
			paramsList.add(setNameValuePair("Thecode", Common.bindString(model.getTHECODE())));
			/** ���ؼ�����Ϣ **/
			paramsList.add(setNameValuePair(captureName("Bsm"), Common.bindString(model.getBSM())));// ��ʶ��
			paramsList.add(setNameValuePair(captureName("Xzqdm"), Common.bindString(model.getXZQDM())));// ����������
			paramsList.add(setNameValuePair(captureName("Qsxz"), Common.bindString(model.getQSXZ())));// Ȩ������
			// paramsList.add(setNameValuePair(captureName("Tdjb"),
			// Common.bindString(model.getTDJB())));// ���ؼ���
			// TODO �ӿ�.���������ֶ�,���Ժ�İ汾���޸�
			paramsList.add(setNameValuePair(captureName("Jzr"), Common.bindString(model.getJZR())));// ������׼��
			paramsList.add(setNameValuePair(captureName("Sdql"), Common.bindString(model.getSDQL())));// �趨Ȩ��״��
			paramsList.add(setNameValuePair(captureName("Sdnq"), Common.bindString(model.getSDNQ())));// �趨����
			paramsList.add(setNameValuePair(captureName("Sdrjl"), Common.bindString(model.getSDRJL())));// �趨�ݻ���
			paramsList.add(setNameValuePair(captureName("Sdkfsp"), Common.bindString(model.getSDKFSP())));// �趨����ˮƽ
			paramsList.add(setNameValuePair(captureName("Dmjzdj"), Common.bindString(model.getDMJZDJ())));// �����׼�ؼ�
			paramsList.add(setNameValuePair(captureName("Lmjzdj"), Common.bindString(model.getLMJZDJ())));// ¥���׼�ؼ�
			paramsList.add(setNameValuePair(captureName("Remark"), Common.bindString(model.getREMARK())));// ��ע

			/** ϵͳ��Ϣ **/
			paramsList.add(setNameValuePair(captureName("Inputuserid"), Common.bindString(model.getINPUTUSERID())));// �����û�
			paramsList.add(setNameValuePair(captureName("Createtime"), Common.bindString(model.getCREATETIME())));// ����ʱ��
			paramsList.add(setNameValuePair(captureName("Lastupdateuserid"), Common.bindString(model.getLASTUPDATEUSERID())));// �޸��û�
			paramsList.add(setNameValuePair(captureName("Updatetime"), Common.bindString(model.getUPDATETIME())));// �޸�ʱ��
			paramsList.add(setNameValuePair(captureName("Isdelete"), Common.bindString(model.getISDELETE())));// �Ƿ�ɾ��
			paramsList.add(setNameValuePair(captureName("Showseq"), Common.bindString(model.getSHOWSEQ())));// ��ʾ˳��
		}
	}

	/**
	 * ˵����TODO(������һ�仰�����������������)
	 * 
	 * @param info
	 * @param paramsList
	 * @return void
	 */
	private void setModelCollectionMarketDevelopmentVillage(LocationInfo info, List<NameValuePair> paramsList) {
		ModelCollectionMarketDevelopmentVillage model = DataSupport.find(ModelCollectionMarketDevelopmentVillage.class, info.getCollectionId());
		if (model != null) {
			paramsList.add(setNameValuePair("Thename", Common.bindString(model.getTHENAME())));
			paramsList.add(setNameValuePair("Thecode", Common.bindString(model.getTHECODE())));
		}
	}

	/**
	 * ˵����TODO(������һ�仰�����������������)
	 * 
	 * @param info
	 * @param paramsList
	 * @return void
	 */
	private void setModelCollectionMarketDevelopmentTownship(LocationInfo info, List<NameValuePair> paramsList) {
		ModelCollectionMarketDevelopmentTownship model = DataSupport.find(ModelCollectionMarketDevelopmentTownship.class, info.getCollectionId());
		if (model != null) {
			paramsList.add(setNameValuePair("Thename", Common.bindString(model.getTHENAME())));
			paramsList.add(setNameValuePair("Thecode", Common.bindString(model.getTHECODE())));
		}
	}

	/**
	 * ˵����TODO(������һ�仰�����������������)
	 * 
	 * @param info
	 * @param paramsList
	 * @return void
	 */
	private void setModelCollectionMarketRedevelopmentPlan(LocationInfo info, List<NameValuePair> paramsList) {
		ModelCollectionMarketRedevelopmentPlan model = DataSupport.find(ModelCollectionMarketRedevelopmentPlan.class, info.getCollectionId());
		if (model != null) {
			paramsList.add(setNameValuePair("Thename", Common.bindString(model.getTHENAME())));
			paramsList.add(setNameValuePair("Thecode", Common.bindString(model.getTHECODE())));
			/** �ٿ����ƻ���Ŀ��Ϣ **/
			paramsList.add(setNameValuePair(captureName("BH"), Common.bindString(model.getBH())));// ���
			paramsList.add(setNameValuePair(captureName("XMMC"), Common.bindString(model.getXMMC())));// ��Ŀ����
			paramsList.add(setNameValuePair(captureName("TDZL"), Common.bindString(model.getTDZL())));// ��������
			paramsList.add(setNameValuePair(captureName("TDSYZ"), Common.bindString(model.getTDSYZ())));// ����������
			paramsList.add(setNameValuePair(captureName("TDSHYZ"), Common.bindString(model.getTDSHYZ())));// ����ʹ����
			paramsList.add(setNameValuePair(captureName("TDYT"), Common.bindString(model.getTDYT())));// ������;
			paramsList.add(setNameValuePair(captureName("TDMJ"), Common.bindString(model.getTDMJ())));// �������
			paramsList.add(setNameValuePair(captureName("GHYT"), Common.bindString(model.getGHYT())));// �滮��;
			paramsList.add(setNameValuePair(captureName("GHRJL"), Common.bindString(model.getGHRJL())));// �滮�ݻ���
			paramsList.add(setNameValuePair(captureName("GHJZXS"), Common.bindString(model.getGHJZXS())));// �滮����ϵ��
			paramsList.add(setNameValuePair(captureName("GHJZMD"), Common.bindString(model.getGHJZMD())));// �滮�����ܶ�
			paramsList.add(setNameValuePair(captureName("GHLVH"), Common.bindString(model.getGHLVH())));// �滮�̻���
			paramsList.add(setNameValuePair(captureName("NKFMS"), Common.bindString(model.getNKFMS())));// �⿪��ģʽ
			paramsList.add(setNameValuePair(captureName("YJZTZ"), Common.bindString(model.getYJZTZ())));// Ԥ����Ͷ��
			paramsList.add(setNameValuePair(captureName("ZJLY"), Common.bindString(model.getZJLY())));// �ʽ���Դ
			paramsList.add(setNameValuePair(captureName("NGDFS"), Common.bindString(model.getNGDFS())));// �⹩�ط�ʽ
			paramsList.add(setNameValuePair(captureName("CYLX"), Common.bindString(model.getCYLX())));// �滮��ҵ����
			paramsList.add(setNameValuePair(captureName("QYZDCY"), Common.bindString(model.getQYZDCY())));// ����������ҵ����
			paramsList.add(setNameValuePair(captureName("QYGYJZDJ"), Common.bindString(model.getQYGYJZDJ())));// ������н����õػ�׼�ؼ�
			paramsList.add(setNameValuePair(captureName("QYJTJZDJ"), Common.bindString(model.getQYJTJZDJ())));// �����彨���õػ�׼�ؼ�
			paramsList.add(setNameValuePair(captureName("YJDJCZ"), Common.bindString(model.getYJDJCZ())));// Ԥ�Ƶؾ���ֵ
			paramsList.add(setNameValuePair(captureName("YJDJSS"), Common.bindString(model.getYJDJSS())));// Ԥ�Ƶؾ�˰��
			paramsList.add(setNameValuePair(captureName("YJDJCYRY"), Common.bindString(model.getYJDJCYRY())));// Ԥ�Ƶؾ���ҵ��Ա��
			paramsList.add(setNameValuePair(captureName("QTYQYX"), Common.bindString(model.getQTYQYX())));// ����Ԥ��ЧӦ
			paramsList.add(setNameValuePair(captureName("ZFYY"), Common.bindString(model.getZFYY())));// ������Ը
			paramsList.add(setNameValuePair(captureName("KFSYY"), Common.bindString(model.getKFSYY())));// ��������Ը
			paramsList.add(setNameValuePair(captureName("TDSYZYY"), Common.bindString(model.getTDSYZYY())));// ������������Ը
			paramsList.add(setNameValuePair(captureName("TDSHYZYY"), Common.bindString(model.getTDSHYZYY())));// ����ʹ������Ը

			/** ������Ϣ **/
			paramsList.add(setNameValuePair(captureName("TDJB"), Common.bindString(model.getTDJB())));// �������ؼ���
			paramsList.add(setNameValuePair(captureName("DJQD"), Common.bindString(model.getDJQD())));// ���ڵؼ�����
			paramsList.add(setNameValuePair(captureName("XZQDM"), Common.bindString(model.getXZQDM())));// ����������
			paramsList.add(setNameValuePair(captureName("REMARK"), Common.bindString(model.getREMARK())));// ��ע
			/** ϵͳ��Ϣ **/
			paramsList.add(setNameValuePair(captureName("INPUTUSERID"), Common.bindString(model.getINPUTUSERID())));// �����û�
			paramsList.add(setNameValuePair(captureName("CREATETIME"), Common.bindString(model.getCREATETIME())));// ����ʱ��
			paramsList.add(setNameValuePair(captureName("LASTUPDATEUSERID"), Common.bindString(model.getLASTUPDATEUSERID())));// �޸��û�
			paramsList.add(setNameValuePair(captureName("UPDATETIME"), Common.bindString(model.getUPDATETIME())));// �޸�ʱ��
			paramsList.add(setNameValuePair(captureName("ISDELETE"), Common.bindString(model.getISDELETE())));// �Ƿ�ɾ��
			paramsList.add(setNameValuePair(captureName("SHOWSEQ"), Common.bindString(model.getSHOWSEQ())));// ��ʾ˳��
		}
	}

	/**
	 * ˵����TODO(������һ�仰�����������������)
	 * 
	 * @param info
	 * @param paramsList
	 * @return void
	 */
	private void setModelCollectionMarketRedevelopmentImpose(LocationInfo info, List<NameValuePair> paramsList) {
		ModelCollectionMarketRedevelopmentImpose model = DataSupport.find(ModelCollectionMarketRedevelopmentImpose.class, info.getCollectionId());
		if (model != null) {
			paramsList.add(setNameValuePair("Thename", Common.bindString(model.getTHENAME())));
			paramsList.add(setNameValuePair("Thecode", Common.bindString(model.getTHECODE())));
			/** �ٿ���ʵʩ��Ŀ��Ϣ **/
			paramsList.add(setNameValuePair(captureName("BH"), Common.bindString(model.getBH())));// ���
			paramsList.add(setNameValuePair(captureName("XMMC"), Common.bindString(model.getXMMC())));// ��Ŀ����
			paramsList.add(setNameValuePair(captureName("XMLX"), Common.bindString(model.getXMLX())));// ��Ŀ����
			paramsList.add(setNameValuePair(captureName("TDZL"), Common.bindString(model.getTDZL())));// ��������
			paramsList.add(setNameValuePair(captureName("TDMJ"), Common.bindString(model.getTDMJ())));// �������
			paramsList.add(setNameValuePair(captureName("RJL"), Common.bindString(model.getRJL())));// �ݻ���
			paramsList.add(setNameValuePair(captureName("JZXS"), Common.bindString(model.getJZXS())));// ����ϵ��
			paramsList.add(setNameValuePair(captureName("JZMD"), Common.bindString(model.getJZMD())));// �����ܶ�
			paramsList.add(setNameValuePair(captureName("LVH"), Common.bindString(model.getLVH())));// �̻���
			paramsList.add(setNameValuePair(captureName("KFMS"), Common.bindString(model.getKFMS())));// ����ģʽ
			paramsList.add(setNameValuePair(captureName("ZTZ"), Common.bindString(model.getZTZ())));// ��Ͷ��
			paramsList.add(setNameValuePair(captureName("ZJLY"), Common.bindString(model.getZJLY())));// �ʽ���Դ
			paramsList.add(setNameValuePair(captureName("GDFS"), Common.bindString(model.getGDFS())));// ���ط�ʽ
			paramsList.add(setNameValuePair(captureName("KFQYT"), Common.bindString(model.getKFQYT())));// ����ǰ��;
			paramsList.add(setNameValuePair(captureName("KFHYT"), Common.bindString(model.getKFHYT())));// ��������;
			paramsList.add(setNameValuePair(captureName("CYLX"), Common.bindString(model.getCYLX())));// ��ҵ����
			paramsList.add(setNameValuePair(captureName("QYZDCY"), Common.bindString(model.getQYZDCY())));// ����������ҵ����
			paramsList.add(setNameValuePair(captureName("QYGYJZDJ"), Common.bindString(model.getQYGYJZDJ())));// ������н����õػ�׼�ؼ�
			paramsList.add(setNameValuePair(captureName("QYJTJZDJ"), Common.bindString(model.getQYJTJZDJ())));// �����彨���õػ�׼�ؼ�
			paramsList.add(setNameValuePair(captureName("DJCZ"), Common.bindString(model.getDJCZ())));// �ؾ���ֵ
			paramsList.add(setNameValuePair(captureName("DJSS"), Common.bindString(model.getDJSS())));// �ؾ�˰��
			paramsList.add(setNameValuePair(captureName("DJCYRY"), Common.bindString(model.getDJCYRY())));// �ؾ���ҵ��Ա��

			/** ������Ϣ **/
			paramsList.add(setNameValuePair(captureName("TDJB"), Common.bindString(model.getTDJB())));// �������ؼ���
			paramsList.add(setNameValuePair(captureName("DJQD"), Common.bindString(model.getDJQD())));// ���ڵؼ�����
			paramsList.add(setNameValuePair(captureName("XZQDM"), Common.bindString(model.getXZQDM())));// ����������
			paramsList.add(setNameValuePair(captureName("REMARK"), Common.bindString(model.getREMARK())));// ��ע
			/** ϵͳ��Ϣ **/
			paramsList.add(setNameValuePair(captureName("INPUTUSERID"), Common.bindString(model.getINPUTUSERID())));// �����û�
			paramsList.add(setNameValuePair(captureName("CREATETIME"), Common.bindString(model.getCREATETIME())));// ����ʱ��
			paramsList.add(setNameValuePair(captureName("LASTUPDATEUSERID"), Common.bindString(model.getLASTUPDATEUSERID())));// �޸��û�
			paramsList.add(setNameValuePair(captureName("UPDATETIME"), Common.bindString(model.getUPDATETIME())));// �޸�ʱ��
			paramsList.add(setNameValuePair(captureName("ISDELETE"), Common.bindString(model.getISDELETE())));// �Ƿ�ɾ��
			paramsList.add(setNameValuePair(captureName("SHOWSEQ"), Common.bindString(model.getSHOWSEQ())));// ��ʾ˳��
		}
	}
}
