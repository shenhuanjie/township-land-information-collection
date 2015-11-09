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
		/** 根据表单类型,构造传输参数 **/
		paramsList.add(setNameValuePair("tableName", tablename));
		paramsList.add(setNameValuePair("id", locationInfo.getUploadId() + ""));
		// 压缩图片质量，用于上传服务器
		Bitmap camorabitmap = PictureUtil.getSmallUploadBitmap(info.getImageUri());

		paramsList.add(setNameValuePair("img64Str", Common.bitmapToBase64(camorabitmap)));
		return paramsList;
	}

	private List<NameValuePair> setParamsList(LocationInfo info) {
		List<NameValuePair> paramsList = new ArrayList<NameValuePair>();
		int mainType = info.getCollectionMainType();
		/** 根据表单类型,构造传输参数 **/
		// 分类基础字段
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

	// 分表类型字段
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
	 * 说明：TODO(这里用一句话描述这个方法的作用)
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
			paramsList.add(setNameValuePair("Tdsyz", Common.bindString(model.getTDSYZ())));// 土地使用者
			paramsList.add(setNameValuePair("Tdzsh", Common.bindString(model.getTDZSH())));// 土地证书号
			paramsList.add(setNameValuePair("Tdzl", Common.bindString(model.getTDZL())));// 土地坐落
			paramsList.add(setNameValuePair("Qsxz", Common.bindString(model.getQSXZ())));// 权属性质
			/** 土地使用权转让交易信息 **/
			paramsList.add(setNameValuePair("Zrf", Common.bindString(model.getZRF())));// 转让方
			paramsList.add(setNameValuePair("Srf", Common.bindString(model.getSRF())));// 受让方
			paramsList.add(setNameValuePair("Zrsj", Common.bindString(model.getZRSJ())));// 转让时间
			paramsList.add(setNameValuePair("Zrfs", Common.bindString(model.getZRFS())));// 转让方式
			paramsList.add(setNameValuePair("Zrmj", Common.bindString(model.getZRMJ())));// 土地转让面积
			paramsList.add(setNameValuePair("Zrqyt", Common.bindString(model.getZRQYT())));// 转让前用途
			paramsList.add(setNameValuePair("Zrhyt", Common.bindString(model.getZRHYT())));// 转让后用途
			paramsList.add(setNameValuePair("Tdsynq", Common.bindString(model.getTDSYNQ())));// 土地剩余使用年期
			paramsList.add(setNameValuePair("Zrdj", Common.bindString(model.getZRDJ())));// 土地转让单价
			paramsList.add(setNameValuePair("Zrzj", Common.bindString(model.getZRZJ())));// 土地转让总价
			/** 其他信息 **/
			paramsList.add(setNameValuePair("Rjl", Common.bindString(model.getRJL())));// 容积率
			paramsList.add(setNameValuePair("Hxwkfsp", Common.bindString(model.getHXWKFSP())));// 红线外开发水平
			paramsList.add(setNameValuePair("Hxnkfsp", Common.bindString(model.getHXNKFSP())));// 红线内开发水平
			paramsList.add(setNameValuePair("Tdjb", Common.bindString(model.getTDJB())));// 所在土地级别
			paramsList.add(setNameValuePair("Djqd", Common.bindString(model.getDJQD())));// 所在地价区段
			paramsList.add(setNameValuePair("Xzqdm", Common.bindString(model.getXZQDM())));// 行政区代码

			/** 位置信息 **/
			paramsList.add(setNameValuePair("X", Common.bindString(model.getX())));// X坐标
			paramsList.add(setNameValuePair("Y", Common.bindString(model.getY())));// Y坐标
			paramsList.add(setNameValuePair("Zbxt", Common.bindString(model.getZBXT())));// 坐标系统
			paramsList.add(setNameValuePair("Remark", Common.bindString(model.getREMARK())));// 备注

			/** 系统信息 **/
			paramsList.add(setNameValuePair("Inputuserid", Common.bindString(model.getINPUTUSERID())));// 创建用户
			paramsList.add(setNameValuePair("Createtime", Common.bindString(model.getCREATETIME())));// 创建时间
			paramsList.add(setNameValuePair("Lastupdateuserid", Common.bindString(model.getLASTUPDATEUSERID())));// 修改用户
			paramsList.add(setNameValuePair("Updatetime", Common.bindString(model.getUPDATETIME())));// 修改时间
			paramsList.add(setNameValuePair("Isdelete", Common.bindString(model.getISDELETE())));// 是否删除
			paramsList.add(setNameValuePair("Showseq", Common.bindString(model.getSHOWSEQ())));// 显示顺序
		}
	}

	/**
	 * 说明：TODO(这里用一句话描述这个方法的作用)
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
			paramsList.add(setNameValuePair("Tdsyz", Common.bindString(model.getTDSYZ())));// 土地使用者
			paramsList.add(setNameValuePair("Tdzsh", Common.bindString(model.getTDZSH())));// 土地证书号
			paramsList.add(setNameValuePair("Tdzl", Common.bindString(model.getTDZL())));// 土地坐落
			paramsList.add(setNameValuePair(captureName("Qsxz"), Common.bindString(model.getQSXZ())));// 权属性质
			/** 土地联营入股交易信息 **/
			paramsList.add(setNameValuePair(captureName("CDF"), Common.bindString(model.getCDF())));// 出地方
			paramsList.add(setNameValuePair(captureName("CZF"), Common.bindString(model.getCZF())));// 出资方
			paramsList.add(setNameValuePair(captureName("LYSJ"), Common.bindString(model.getLYSJ())));// 联营时间
			paramsList.add(setNameValuePair(captureName("LYQ"), Common.bindString(model.getLYQ())));// 联营期
			paramsList.add(setNameValuePair(captureName("CDMJ"), Common.bindString(model.getCDMJ())));// 出地方投入土地面积
			paramsList.add(setNameValuePair(captureName("CZZE"), Common.bindString(model.getCZZE())));// 出资方投入资金总额
			paramsList.add(setNameValuePair(captureName("CDFFCBL"), Common.bindString(model.getCDFFCBL())));// 出地方利润分成比例
			paramsList.add(setNameValuePair(captureName("TDNCSR"), Common.bindString(model.getTDNCSR())));// 单位面积土地年纯收入
			paramsList.add(setNameValuePair(captureName("CDFNCSR"), Common.bindString(model.getCDFNCSR())));// 出地方土地年纯收入
			paramsList.add(setNameValuePair(captureName("LYQYT"), Common.bindString(model.getLYQYT())));// 联营前用途
			paramsList.add(setNameValuePair(captureName("LYHYT"), Common.bindString(model.getLYHYT())));// 联营后用途
			/** 其他信息 **/
			paramsList.add(setNameValuePair("Rjl", Common.bindString(model.getRJL())));// 容积率
			paramsList.add(setNameValuePair("Hxwkfsp", Common.bindString(model.getHXWKFSP())));// 红线外开发水平
			paramsList.add(setNameValuePair("Hxnkfsp", Common.bindString(model.getHXNKFSP())));// 红线内开发水平
			paramsList.add(setNameValuePair("Tdjb", Common.bindString(model.getTDJB())));// 所在土地级别
			paramsList.add(setNameValuePair("Djqd", Common.bindString(model.getDJQD())));// 所在地价区段
			paramsList.add(setNameValuePair("Xzqdm", Common.bindString(model.getXZQDM())));// 行政区代码

			/** 位置信息 **/
			paramsList.add(setNameValuePair("X", Common.bindString(model.getX())));// X坐标
			paramsList.add(setNameValuePair("Y", Common.bindString(model.getY())));// Y坐标
			paramsList.add(setNameValuePair("Zbxt", Common.bindString(model.getZBXT())));// 坐标系统
			paramsList.add(setNameValuePair("Remark", Common.bindString(model.getREMARK())));// 备注

			/** 系统信息 **/
			paramsList.add(setNameValuePair("Inputuserid", Common.bindString(model.getINPUTUSERID())));// 创建用户
			paramsList.add(setNameValuePair("Createtime", Common.bindString(model.getCREATETIME())));// 创建时间
			paramsList.add(setNameValuePair("Lastupdateuserid", Common.bindString(model.getLASTUPDATEUSERID())));// 修改用户
			paramsList.add(setNameValuePair("Updatetime", Common.bindString(model.getUPDATETIME())));// 修改时间
			paramsList.add(setNameValuePair("Isdelete", Common.bindString(model.getISDELETE())));// 是否删除
			paramsList.add(setNameValuePair("Showseq", Common.bindString(model.getSHOWSEQ())));// 显示顺序
		}
	}

	/**
	 * 说明：TODO(这里用一句话描述这个方法的作用)
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
			paramsList.add(setNameValuePair("Tdsyz", Common.bindString(model.getTDSYZ())));// 土地使用者
			paramsList.add(setNameValuePair("Tdzsh", Common.bindString(model.getTDZSH())));// 土地证书号
			paramsList.add(setNameValuePair("Tdzl", Common.bindString(model.getTDZL())));// 土地坐落
			paramsList.add(setNameValuePair("Qsxz", Common.bindString(model.getQSXZ())));// 权属性质
			/** 土地使用权出让交易信息 **/
			paramsList.add(setNameValuePair("Crsj", Common.bindString(model.getCRSJ())));// 出让时间
			paramsList.add(setNameValuePair("Srf", Common.bindString(model.getSRF())));// 受让方
			paramsList.add(setNameValuePair("Crfs", Common.bindString(model.getCRFS())));// 出让方式
			paramsList.add(setNameValuePair("Sfzkf", Common.bindString(model.getSFZKF())));// 是否再开发
			paramsList.add(setNameValuePair("Sflyd", Common.bindString(model.getSFLYD())));// 是否留用地
			paramsList.add(setNameValuePair("Ghtdmj", Common.bindString(model.getGHTDMJ())));// 规划红线范围土地面积
			paramsList.add(setNameValuePair("Dztdmj", Common.bindString(model.getDZTDMJ())));// 代征土地面积
			paramsList.add(setNameValuePair("Sjcrmj", Common.bindString(model.getSJCRMJ())));// 实际出让面积
			paramsList.add(setNameValuePair("Crqyt", Common.bindString(model.getCRQYT())));// 出让前用途
			paramsList.add(setNameValuePair("Crhyt", Common.bindString(model.getCRHYT())));// 出让后用途
			paramsList.add(setNameValuePair("Crnq", Common.bindString(model.getCRNQ())));// 出让年期
			paramsList.add(setNameValuePair("Crdj", Common.bindString(model.getCRDJ())));// 单位面积土地出让价
			paramsList.add(setNameValuePair("Crzj", Common.bindString(model.getCRZJ())));// 土地出让总价
			/** 其他信息 **/
			paramsList.add(setNameValuePair("Rjl", Common.bindString(model.getRJL())));// 容积率
			paramsList.add(setNameValuePair("Hxwkfsp", Common.bindString(model.getHXWKFSP())));// 红线外开发水平
			paramsList.add(setNameValuePair("Hxnkfsp", Common.bindString(model.getHXNKFSP())));// 红线内开发水平
			paramsList.add(setNameValuePair("Tdjb", Common.bindString(model.getTDJB())));// 所在土地级别
			paramsList.add(setNameValuePair("Djqd", Common.bindString(model.getDJQD())));// 所在地价区段
			paramsList.add(setNameValuePair("Xzqdm", Common.bindString(model.getXZQDM())));// 行政区代码

			/** 位置信息 **/
			paramsList.add(setNameValuePair("X", Common.bindString(model.getX())));// X坐标
			paramsList.add(setNameValuePair("Y", Common.bindString(model.getY())));// Y坐标
			paramsList.add(setNameValuePair("Zbxt", Common.bindString(model.getZBXT())));// 坐标系统
			paramsList.add(setNameValuePair("Remark", Common.bindString(model.getREMARK())));// 备注

			/** 系统信息 **/
			paramsList.add(setNameValuePair("Inputuserid", Common.bindString(model.getINPUTUSERID())));// 创建用户
			paramsList.add(setNameValuePair("Createtime", Common.bindString(model.getCREATETIME())));// 创建时间
			paramsList.add(setNameValuePair("Lastupdateuserid", Common.bindString(model.getLASTUPDATEUSERID())));// 修改用户
			paramsList.add(setNameValuePair("Updatetime", Common.bindString(model.getUPDATETIME())));// 修改时间
			paramsList.add(setNameValuePair("Isdelete", Common.bindString(model.getISDELETE())));// 是否删除
			paramsList.add(setNameValuePair("Showseq", Common.bindString(model.getSHOWSEQ())));// 显示顺序
		}
	}

	/**
	 * 说明：TODO(这里用一句话描述这个方法的作用)
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
			paramsList.add(setNameValuePair("Tdsyz", Common.bindString(model.getTDSYZ())));// 土地使用者
			paramsList.add(setNameValuePair("Tdzsh", Common.bindString(model.getTDZSH())));// 土地证书号
			paramsList.add(setNameValuePair("Tdzl", Common.bindString(model.getTDZL())));// 土地坐落
			paramsList.add(setNameValuePair("Qsxz", Common.bindString(model.getQSXZ())));// 权属性质
			/** 土地使用权出租交易信息 **/
			paramsList.add(setNameValuePair("Chuzf", Common.bindString(model.getCHUZF())));// 出租方
			paramsList.add(setNameValuePair("Chengzf", Common.bindString(model.getCHENGZF())));// 承租方
			paramsList.add(setNameValuePair("Czsj", Common.bindString(model.getCZSJ())));// 出租时间
			paramsList.add(setNameValuePair("Zq", Common.bindString(model.getZQ())));// 租期
			paramsList.add(setNameValuePair("Czmj", Common.bindString(model.getCZMJ())));// 土地出租面积
			paramsList.add(setNameValuePair("Czqyt", Common.bindString(model.getCZQYT())));// 出租前用途
			paramsList.add(setNameValuePair("Czhyt", Common.bindString(model.getCZHYT())));// 出租后用途
			paramsList.add(setNameValuePair("Tdsynq", Common.bindString(model.getTDSYNQ())));// 土地剩余使用年
			paramsList.add(setNameValuePair("Nzj", Common.bindString(model.getNZJ())));// 年租金
			paramsList.add(setNameValuePair("Yj", Common.bindString(model.getYJ())));// 押金
			paramsList.add(setNameValuePair("Sf", Common.bindString(model.getSF())));// 税费
			/** 其他信息 **/
			paramsList.add(setNameValuePair("Rjl", Common.bindString(model.getRJL())));// 容积率
			paramsList.add(setNameValuePair("Hxwkfsp", Common.bindString(model.getHXWKFSP())));// 红线外开发水平
			paramsList.add(setNameValuePair("Hxnkfsp", Common.bindString(model.getHXNKFSP())));// 红线内开发水平
			paramsList.add(setNameValuePair("Tdjb", Common.bindString(model.getTDJB())));// 所在土地级别
			paramsList.add(setNameValuePair("Djqd", Common.bindString(model.getDJQD())));// 所在地价区段
			paramsList.add(setNameValuePair("Xzqdm", Common.bindString(model.getXZQDM())));// 行政区代码

			/** 位置信息 **/
			paramsList.add(setNameValuePair("X", Common.bindString(model.getX())));// X坐标
			paramsList.add(setNameValuePair("Y", Common.bindString(model.getY())));// Y坐标
			paramsList.add(setNameValuePair("Zbxt", Common.bindString(model.getZBXT())));// 坐标系统
			paramsList.add(setNameValuePair("Remark", Common.bindString(model.getREMARK())));// 备注

			/** 系统信息 **/
			paramsList.add(setNameValuePair("Inputuserid", Common.bindString(model.getINPUTUSERID())));// 创建用户
			paramsList.add(setNameValuePair("Createtime", Common.bindString(model.getCREATETIME())));// 创建时间
			paramsList.add(setNameValuePair("Lastupdateuserid", Common.bindString(model.getLASTUPDATEUSERID())));// 修改用户
			paramsList.add(setNameValuePair("Updatetime", Common.bindString(model.getUPDATETIME())));// 修改时间
			paramsList.add(setNameValuePair("Isdelete", Common.bindString(model.getISDELETE())));// 是否删除
			paramsList.add(setNameValuePair("Showseq", Common.bindString(model.getSHOWSEQ())));// 显示顺序
		}
	}

	/**
	 * 说明：TODO(这里用一句话描述这个方法的作用)
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
			paramsList.add(setNameValuePair("Tdsyz", Common.bindString(model.getTDSYZ())));// 土地使用者
			paramsList.add(setNameValuePair("Tdzsh", Common.bindString(model.getTDZSH())));// 土地证书号
			paramsList.add(setNameValuePair("Tdzl", Common.bindString(model.getTDZL())));// 土地坐落
			paramsList.add(setNameValuePair("Qsxz", Common.bindString(model.getQSXZ())));// 权属性质

			/** 房地出售交易信息 **/
			paramsList.add(setNameValuePair("Fwsyqr", Common.bindString(model.getFWSYQR())));// 房屋所有权人
			paramsList.add(setNameValuePair("Tdyt", Common.bindString(model.getTDYT())));// 土地用途
			paramsList.add(setNameValuePair("Ljkd", Common.bindString(model.getLJKD())));// 临街宽度
			paramsList.add(setNameValuePair("Ljsd", Common.bindString(model.getLJSD())));// 临街深度
			paramsList.add(setNameValuePair("Jzlx", Common.bindString(model.getJZLX())));// 建筑类型
			paramsList.add(setNameValuePair("Jzcs", Common.bindString(model.getJZCS())));// 建筑层数
			paramsList.add(setNameValuePair("Fwjg", Common.bindString(model.getFWJG())));// 房屋结构
			paramsList.add(setNameValuePair("Jgsj", Common.bindString(model.getJGSJ())));// 竣工时间
			paramsList.add(setNameValuePair("Fwcxd", Common.bindString(model.getFWCXD())));// 房屋成新度
			paramsList.add(setNameValuePair("Zxsj", Common.bindString(model.getZXSJ())));// 装修时间
			paramsList.add(setNameValuePair("Zxcd", Common.bindString(model.getZXCD())));// 装修程度
			paramsList.add(setNameValuePair("Cslc", Common.bindString(model.getCSLC())));// 出售楼层
			paramsList.add(setNameValuePair("Csyt", Common.bindString(model.getCSYT())));// 出售用途
			paramsList.add(setNameValuePair("Csmj", Common.bindString(model.getCSMJ())));// 出售建筑面积
			paramsList.add(setNameValuePair("Cssj", Common.bindString(model.getCSSJ())));// 出售时间
			paramsList.add(setNameValuePair("Sj", Common.bindString(model.getSJ())));// 售价
			paramsList.add(setNameValuePair("Sf", Common.bindString(model.getSF())));// 税费

			/** 其他信息 **/
			paramsList.add(setNameValuePair("Rjl", Common.bindString(model.getRJL())));// 容积率
			paramsList.add(setNameValuePair("Hxwkfsp", Common.bindString(model.getHXWKFSP())));// 红线外开发水平
			paramsList.add(setNameValuePair("Hxnkfsp", Common.bindString(model.getHXNKFSP())));// 红线内开发水平
			paramsList.add(setNameValuePair("Tdjb", Common.bindString(model.getTDJB())));// 所在土地级别
			paramsList.add(setNameValuePair("Djqd", Common.bindString(model.getDJQD())));// 所在地价区段
			paramsList.add(setNameValuePair("Xzqdm", Common.bindString(model.getXZQDM())));// 行政区代码

			/** 位置信息 **/
			paramsList.add(setNameValuePair("X", Common.bindString(model.getX())));// X坐标
			paramsList.add(setNameValuePair("Y", Common.bindString(model.getY())));// Y坐标
			paramsList.add(setNameValuePair("Zbxt", Common.bindString(model.getZBXT())));// 坐标系统
			paramsList.add(setNameValuePair("Remark", Common.bindString(model.getREMARK())));// 备注

			/** 系统信息 **/
			paramsList.add(setNameValuePair("Inputuserid", Common.bindString(model.getINPUTUSERID())));// 创建用户
			paramsList.add(setNameValuePair("Createtime", Common.bindString(model.getCREATETIME())));// 创建时间
			paramsList.add(setNameValuePair("Lastupdateuserid", Common.bindString(model.getLASTUPDATEUSERID())));// 修改用户
			paramsList.add(setNameValuePair("Updatetime", Common.bindString(model.getUPDATETIME())));// 修改时间
			paramsList.add(setNameValuePair("Isdelete", Common.bindString(model.getISDELETE())));// 是否删除
			paramsList.add(setNameValuePair("Showseq", Common.bindString(model.getSHOWSEQ())));// 显示顺序
		}
	}

	/**
	 * 说明：TODO(这里用一句话描述这个方法的作用)
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
	 * 说明：TODO(这里用一句话描述这个方法的作用)
	 * 
	 * @param info
	 * @param paramsList
	 * @return void
	 */
	private void setModelCollectionMarketDemandTransfer(LocationInfo info, List<NameValuePair> paramsList) {
		ModelCollectionMarketDemandTransfer model = DataSupport.find(ModelCollectionMarketDemandTransfer.class, info.getCollectionId());
		if (model != null) {
			/** 基本信息 **/
			paramsList.add(setNameValuePair(captureName("THENAME"), Common.bindString(model.getTHENAME())));// 记录名称
			paramsList.add(setNameValuePair(captureName("THECODE"), Common.bindString(model.getTHECODE())));// 记录代码

			/** 土地使用权转让需求信息 **/
			paramsList.add(setNameValuePair(captureName("XQF"), Common.bindString(model.getXQF())));// 需求方
			paramsList.add(setNameValuePair(captureName("XQFZTXZ"), Common.bindString(model.getXQFZTXZ())));// 需求方主体性质
			paramsList.add(setNameValuePair(captureName("NTDZL"), Common.bindString(model.getNTDZL())));// 拟土地坐落
			paramsList.add(setNameValuePair(captureName("NQSXZ"), Common.bindString(model.getNQSXZ())));// 拟权属性质
			paramsList.add(setNameValuePair(captureName("XQZRSJ"), Common.bindString(model.getXQZRSJ())));// 需求转让时间
			paramsList.add(setNameValuePair(captureName("XQZRFS"), Common.bindString(model.getXQZRFS())));// 需求转让方式
			paramsList.add(setNameValuePair(captureName("NXQZRMJ"), Common.bindString(model.getNXQZRMJ())));// 拟需求土地转让面积
			paramsList.add(setNameValuePair(captureName("ZRQYT"), Common.bindString(model.getZRQYT())));// 转让前用途
			paramsList.add(setNameValuePair(captureName("NZRHYT"), Common.bindString(model.getNZRHYT())));// 拟转让后用途
			paramsList.add(setNameValuePair(captureName("TDSYNQ"), Common.bindString(model.getTDSYNQ())));// 土地剩余使用年期
			paramsList.add(setNameValuePair(captureName("GHRJL"), Common.bindString(model.getGHRJL())));// 规划宗地容积率
			paramsList.add(setNameValuePair(captureName("XQZRDJ"), Common.bindString(model.getXQZRDJ())));// 需求土地转让单价
			paramsList.add(setNameValuePair(captureName("XQZRZJ"), Common.bindString(model.getXQZRZJ())));// 需求土地转让总价
			paramsList.add(setNameValuePair(captureName("XQXZTDTJ"), Common.bindString(model.getXQXZTDTJ())));
			/** 其他信息 **/
			paramsList.add(setNameValuePair(captureName("TDJB"), Common.bindString(model.getTDJB())));// 所在土地级别
			paramsList.add(setNameValuePair(captureName("XZQDM"), Common.bindString(model.getXZQDM())));// 行政区代码

			/** 位置信息 **/
			paramsList.add(setNameValuePair(captureName("X"), Common.bindString(model.getX())));// X坐标
			paramsList.add(setNameValuePair(captureName("Y"), Common.bindString(model.getY())));// Y坐标
			paramsList.add(setNameValuePair(captureName("ZBXT"), Common.bindString(model.getZBXT())));// 坐标系统
			paramsList.add(setNameValuePair(captureName("REMARK"), Common.bindString(model.getREMARK())));// 备注

			/** 系统信息 **/
			paramsList.add(setNameValuePair(captureName("INPUTUSERID"), Common.bindString(model.getINPUTUSERID())));// 创建用户
			paramsList.add(setNameValuePair(captureName("CREATETIME"), Common.bindString(model.getCREATETIME())));// 创建时间
			paramsList.add(setNameValuePair(captureName("LASTUPDATEUSERID"), Common.bindString(model.getLASTUPDATEUSERID())));// 修改用户
			paramsList.add(setNameValuePair(captureName("UPDATETIME"), Common.bindString(model.getUPDATETIME())));// 修改时间
			paramsList.add(setNameValuePair(captureName("ISDELETE"), Common.bindString(model.getISDELETE())));// 是否删除
			paramsList.add(setNameValuePair(captureName("SHOWSEQ"), Common.bindString(model.getSHOWSEQ())));// 显示顺序
		}
	}

	/**
	 * 说明：TODO(这里用一句话描述这个方法的作用)
	 * 
	 * @param info
	 * @param paramsList
	 * @return void
	 */
	private void setModelCollectionMarketDemandShareHolder(LocationInfo info, List<NameValuePair> paramsList) {
		ModelCollectionMarketDemandShareHolder model = DataSupport.find(ModelCollectionMarketDemandShareHolder.class, info.getCollectionId());
		if (model != null) {
			/** 基本信息 **/
			paramsList.add(setNameValuePair(captureName("THENAME"), Common.bindString(model.getTHENAME())));// 记录名称
			paramsList.add(setNameValuePair(captureName("THECODE"), Common.bindString(model.getTHECODE())));// 记录代码

			/** 土地联营入股需求信息 **/
			paramsList.add(setNameValuePair(captureName("XQCZF"), Common.bindString(model.getXQCZF())));// 需求出资方
			paramsList.add(setNameValuePair(captureName("XQCZFZTXZ"), Common.bindString(model.getXQCZFZTXZ())));// 需求出资方主体性质
			paramsList.add(setNameValuePair(captureName("NTDZL"), Common.bindString(model.getNTDZL())));// 拟土地坐落
			paramsList.add(setNameValuePair(captureName("NQSXZ"), Common.bindString(model.getNQSXZ())));// 拟权属性质
			paramsList.add(setNameValuePair(captureName("XQXZTDTJ"), Common.bindString(model.getXQXZTDTJ())));// 需求现状土地条件
			paramsList.add(setNameValuePair(captureName("XQLYSJ"), Common.bindString(model.getXQLYSJ())));// 需求联营时间
			paramsList.add(setNameValuePair(captureName("XQLYQ"), Common.bindString(model.getXQLYQ())));// 需求联营期
			paramsList.add(setNameValuePair(captureName("XQCDMJ"), Common.bindString(model.getXQCDMJ())));// 需求出地方投入土地面积
			paramsList.add(setNameValuePair(captureName("XQCZZE"), Common.bindString(model.getXQCZZE())));// 需求出资方投入资金总额
			paramsList.add(setNameValuePair(captureName("XQCDFFCBL"), Common.bindString(model.getXQCDFFCBL())));// 需求出地方利润分成比例
			paramsList.add(setNameValuePair(captureName("NTDNCSR"), Common.bindString(model.getNTDNCSR())));// 拟单位面积土地年纯收入
			paramsList.add(setNameValuePair(captureName("NCDFNCSR"), Common.bindString(model.getNCDFNCSR())));// 拟出地方土地年纯收入
			paramsList.add(setNameValuePair(captureName("LYQYT"), Common.bindString(model.getLYQYT())));// 联营前用途
			paramsList.add(setNameValuePair(captureName("NLYHYT"), Common.bindString(model.getNLYHYT())));// 拟联营后用途

			/** 其他信息 **/
			paramsList.add(setNameValuePair(captureName("TDJB"), Common.bindString(model.getTDJB())));// 所在土地级别
			paramsList.add(setNameValuePair(captureName("XZQDM"), Common.bindString(model.getXZQDM())));// 行政区代码

			/** 位置信息 **/
			paramsList.add(setNameValuePair(captureName("X"), Common.bindString(model.getX())));// X坐标
			paramsList.add(setNameValuePair(captureName("Y"), Common.bindString(model.getY())));// Y坐标
			paramsList.add(setNameValuePair(captureName("ZBXT"), Common.bindString(model.getZBXT())));// 坐标系统
			paramsList.add(setNameValuePair(captureName("REMARK"), Common.bindString(model.getREMARK())));// 备注

			/** 系统信息 **/
			paramsList.add(setNameValuePair(captureName("INPUTUSERID"), Common.bindString(model.getINPUTUSERID())));// 创建用户
			paramsList.add(setNameValuePair(captureName("CREATETIME"), Common.bindString(model.getCREATETIME())));// 创建时间
			paramsList.add(setNameValuePair(captureName("LASTUPDATEUSERID"), Common.bindString(model.getLASTUPDATEUSERID())));// 修改用户
			paramsList.add(setNameValuePair(captureName("UPDATETIME"), Common.bindString(model.getUPDATETIME())));// 修改时间
			paramsList.add(setNameValuePair(captureName("ISDELETE"), Common.bindString(model.getISDELETE())));// 是否删除
			paramsList.add(setNameValuePair(captureName("SHOWSEQ"), Common.bindString(model.getSHOWSEQ())));// 显示顺序
		}
	}

	/**
	 * 说明：TODO(这里用一句话描述这个方法的作用)
	 * 
	 * @param info
	 * @param paramsList
	 * @return void
	 */
	private void setModelCollectionMarketDemandSell(LocationInfo info, List<NameValuePair> paramsList) {
		ModelCollectionMarketDemandSell model = DataSupport.find(ModelCollectionMarketDemandSell.class, info.getCollectionId());
		if (model != null) {
			/** 基本信息 **/
			paramsList.add(setNameValuePair(captureName("THENAME"), Common.bindString(model.getTHENAME())));// 记录名称
			paramsList.add(setNameValuePair(captureName("THECODE"), Common.bindString(model.getTHECODE())));// 记录代码

			/** 房地出租需求信息 **/
			paramsList.add(setNameValuePair(captureName("XQF"), Common.bindString(model.getXQF())));// 需求方
			paramsList.add(setNameValuePair(captureName("XQFZTXZ"), Common.bindString(model.getXQFZTXZ())));// 需求方主体性质
			paramsList.add(setNameValuePair(captureName("NTDZL"), Common.bindString(model.getNTDZL())));// 拟土地坐落
			paramsList.add(setNameValuePair(captureName("NQSXZ"), Common.bindString(model.getNQSXZ())));// 拟权属性质
			paramsList.add(setNameValuePair(captureName("XQCRSJ"), Common.bindString(model.getXQCRSJ())));// 需求出让时间
			paramsList.add(setNameValuePair(captureName("XQCRFS"), Common.bindString(model.getXQCRFS())));// 需求出让方式
			paramsList.add(setNameValuePair(captureName("NXQCRMJ"), Common.bindString(model.getNXQCRMJ())));// 拟需求出让面积
			paramsList.add(setNameValuePair(captureName("CRQYT"), Common.bindString(model.getCRQYT())));// 出让前用途
			paramsList.add(setNameValuePair(captureName("NCRHYT"), Common.bindString(model.getNCRHYT())));// 拟出让后用途
			paramsList.add(setNameValuePair(captureName("XQCRNQ"), Common.bindString(model.getXQCRNQ())));// 需求出让年期
			paramsList.add(setNameValuePair(captureName("GHRJL"), Common.bindString(model.getGHRJL())));// 规划宗地容积率
			paramsList.add(setNameValuePair(captureName("XQXZTDTJ"), Common.bindString(model.getXQXZTDTJ())));// 需求现状土地条件
			paramsList.add(setNameValuePair(captureName("XQCRDJ"), Common.bindString(model.getXQCRDJ())));// 需求单位面积土地出让价
			paramsList.add(setNameValuePair(captureName("XQCRZJ"), Common.bindString(model.getXQCRZJ())));// 需求土地出让总价
			paramsList.add(setNameValuePair(captureName("NTZQD"), Common.bindString(model.getNTZQD())));// 拟投资强度
			paramsList.add(setNameValuePair(captureName("NKFTZZE"), Common.bindString(model.getNKFTZZE())));// 拟开发投资总额

			/** 其他信息 **/
			paramsList.add(setNameValuePair(captureName("TDJB"), Common.bindString(model.getTDJB())));// 所在土地级别
			paramsList.add(setNameValuePair(captureName("XZQDM"), Common.bindString(model.getXZQDM())));// 行政区代码

			/** 位置信息 **/
			paramsList.add(setNameValuePair(captureName("X"), Common.bindString(model.getX())));// X坐标
			paramsList.add(setNameValuePair(captureName("Y"), Common.bindString(model.getY())));// Y坐标
			paramsList.add(setNameValuePair(captureName("ZBXT"), Common.bindString(model.getZBXT())));// 坐标系统
			paramsList.add(setNameValuePair(captureName("REMARK"), Common.bindString(model.getREMARK())));// 备注

			/** 系统信息 **/
			paramsList.add(setNameValuePair(captureName("INPUTUSERID"), Common.bindString(model.getINPUTUSERID())));// 创建用户
			paramsList.add(setNameValuePair(captureName("CREATETIME"), Common.bindString(model.getCREATETIME())));// 创建时间
			paramsList.add(setNameValuePair(captureName("LASTUPDATEUSERID"), Common.bindString(model.getLASTUPDATEUSERID())));// 修改用户
			paramsList.add(setNameValuePair(captureName("UPDATETIME"), Common.bindString(model.getUPDATETIME())));// 修改时间
			paramsList.add(setNameValuePair(captureName("ISDELETE"), Common.bindString(model.getISDELETE())));// 是否删除
			paramsList.add(setNameValuePair(captureName("SHOWSEQ"), Common.bindString(model.getSHOWSEQ())));// 显示顺序
		}
	}

	/**
	 * 说明：TODO(这里用一句话描述这个方法的作用)
	 * 
	 * @param info
	 * @param paramsList
	 * @return void
	 */
	private void setModelCollectionMarketDemandHouseRent(LocationInfo info, List<NameValuePair> paramsList) {
		ModelCollectionMarketDemandHouseRent model = DataSupport.find(ModelCollectionMarketDemandHouseRent.class, info.getCollectionId());
		if (model != null) {
			/** 基本信息 **/
			paramsList.add(setNameValuePair(captureName("THENAME"), Common.bindString(model.getTHENAME())));// 记录名称
			paramsList.add(setNameValuePair(captureName("THECODE"), Common.bindString(model.getTHECODE())));// 记录代码

			/** 房地出租需求信息 **/
			paramsList.add(setNameValuePair(captureName("XQCZF"), Common.bindString(model.getXQCZF())));// 需求承租方
			paramsList.add(setNameValuePair(captureName("NTDZL"), Common.bindString(model.getNTDZL())));// 拟土地坐落
			paramsList.add(setNameValuePair(captureName("NQSXZ"), Common.bindString(model.getNQSXZ())));// 拟权属性质
			paramsList.add(setNameValuePair(captureName("TDSYNQ"), Common.bindString(model.getTDSYNQ())));// 土地剩余使用年期
			paramsList.add(setNameValuePair(captureName("NTDYT"), Common.bindString(model.getNTDYT())));// 拟土地用途
			paramsList.add(setNameValuePair(captureName("XQRJL"), Common.bindString(model.getXQRJL())));// 需求容积率
			paramsList.add(setNameValuePair(captureName("XQLJKD"), Common.bindString(model.getXQLJKD())));// 需求临街宽度
			paramsList.add(setNameValuePair(captureName("LJSD"), Common.bindString(model.getLJSD())));// 临街深度
			paramsList.add(setNameValuePair(captureName("XQJZLX"), Common.bindString(model.getXQJZLX())));// 需求建筑类型
			paramsList.add(setNameValuePair(captureName("XQJZCS"), Common.bindString(model.getXQJZCS())));// 需求建筑层数
			paramsList.add(setNameValuePair(captureName("XQFWJG"), Common.bindString(model.getXQFWJG())));// 需求房屋结构
			paramsList.add(setNameValuePair(captureName("JGSJ"), Common.bindString(model.getJGSJ())));// 竣工时间
			paramsList.add(setNameValuePair(captureName("XQFWCXD"), Common.bindString(model.getXQFWCXD())));// 需求房屋成新度
			paramsList.add(setNameValuePair(captureName("ZXSJ"), Common.bindString(model.getZXSJ())));// 装修时间
			paramsList.add(setNameValuePair(captureName("XQZXCD"), Common.bindString(model.getXQZXCD())));// 需求装修程度
			paramsList.add(setNameValuePair(captureName("XQCZLC"), Common.bindString(model.getXQCZLC())));// 需求出租楼层
			paramsList.add(setNameValuePair(captureName("XQCZYT"), Common.bindString(model.getXQCZYT())));// 需求出租用途
			paramsList.add(setNameValuePair(captureName("XQCZMJ"), Common.bindString(model.getXQCZMJ())));// 需求出租建筑面积
			paramsList.add(setNameValuePair(captureName("XQCZSJ"), Common.bindString(model.getXQCZSJ())));// 需求出租时间
			paramsList.add(setNameValuePair(captureName("XQZQ"), Common.bindString(model.getXQZQ())));// 需求租期（年）
			paramsList.add(setNameValuePair(captureName("XQHX"), Common.bindString(model.getXQHX())));// 需求住宅户型
			paramsList.add(setNameValuePair(captureName("XQPTSS"), Common.bindString(model.getXQPTSS())));// 需求配套设施
			paramsList.add(setNameValuePair(captureName("XQZBJT"), Common.bindString(model.getXQZBJT())));// 需求周边交通
			paramsList.add(setNameValuePair(captureName("XQNZJ"), Common.bindString(model.getXQNZJ())));// 需求年租金
			paramsList.add(setNameValuePair(captureName("NYJ"), Common.bindString(model.getNYJ())));// 拟押金

			/** 其他信息 **/
			paramsList.add(setNameValuePair(captureName("TDJB"), Common.bindString(model.getTDJB())));// 所在土地级别
			paramsList.add(setNameValuePair(captureName("DJQD"), Common.bindString(model.getDJQD())));// 所在地价区段
			paramsList.add(setNameValuePair(captureName("XZQDM"), Common.bindString(model.getXZQDM())));// 行政区代码

			/** 位置信息 **/
			paramsList.add(setNameValuePair(captureName("X"), Common.bindString(model.getX())));// X坐标
			paramsList.add(setNameValuePair(captureName("Y"), Common.bindString(model.getY())));// Y坐标
			paramsList.add(setNameValuePair(captureName("ZBXT"), Common.bindString(model.getZBXT())));// 坐标系统
			paramsList.add(setNameValuePair(captureName("REMARK"), Common.bindString(model.getREMARK())));// 备注

			/** 系统信息 **/
			paramsList.add(setNameValuePair(captureName("INPUTUSERID"), Common.bindString(model.getINPUTUSERID())));// 创建用户
			paramsList.add(setNameValuePair(captureName("CREATETIME"), Common.bindString(model.getCREATETIME())));// 创建时间
			paramsList.add(setNameValuePair(captureName("LASTUPDATEUSERID"), Common.bindString(model.getLASTUPDATEUSERID())));// 修改用户
			paramsList.add(setNameValuePair(captureName("UPDATETIME"), Common.bindString(model.getUPDATETIME())));// 修改时间
			paramsList.add(setNameValuePair(captureName("ISDELETE"), Common.bindString(model.getISDELETE())));// 是否删除
			paramsList.add(setNameValuePair(captureName("SHOWSEQ"), Common.bindString(model.getSHOWSEQ())));// 显示顺序
		}
	}

	/**
	 * 说明：TODO(这里用一句话描述这个方法的作用)
	 * 
	 * @param info
	 * @param paramsList
	 * @return void
	 */
	private void setModelCollectionMarketDemandHouseSell(LocationInfo info, List<NameValuePair> paramsList) {
		ModelCollectionMarketDemandHouseSell model = DataSupport.find(ModelCollectionMarketDemandHouseSell.class, info.getCollectionId());
		if (model != null) {
			/** 基本信息 **/
			paramsList.add(setNameValuePair(captureName("THENAME"), Common.bindString(model.getTHENAME())));// 记录名称
			paramsList.add(setNameValuePair(captureName("THECODE"), Common.bindString(model.getTHECODE())));// 记录代码

			/** 房地出售需求信息 **/
			paramsList.add(setNameValuePair(captureName("XQGMF"), Common.bindString(model.getXQGMF())));// 需求购买方
			paramsList.add(setNameValuePair(captureName("NTDZL"), Common.bindString(model.getNTDZL())));// 拟土地坐落
			paramsList.add(setNameValuePair(captureName("NQSXZ"), Common.bindString(model.getNQSXZ())));// 拟权属性质
			paramsList.add(setNameValuePair(captureName("SFESF"), Common.bindString(model.getSFESF())));// 是否二手房
			paramsList.add(setNameValuePair(captureName("SFZAJF"), Common.bindString(model.getSFZAJF())));// 是否转按揭房
			paramsList.add(setNameValuePair(captureName("TDSYKNQ"), Common.bindString(model.getTDSYKNQ())));// 土地剩余使用年期
			paramsList.add(setNameValuePair(captureName("NTDYT"), Common.bindString(model.getNTDYT())));// 拟土地用途
			paramsList.add(setNameValuePair(captureName("XQGMSJ"), Common.bindString(model.getXQGMSJ())));// 需求购买时间
			paramsList.add(setNameValuePair(captureName("XQCSMJ"), Common.bindString(model.getXQCSMJ())));// 需求购买建筑面积
			paramsList.add(setNameValuePair(captureName("XQKSYMJYQ"), Common.bindString(model.getXQKSYMJYQ())));// 需求可使用面积
			paramsList.add(setNameValuePair(captureName("XQRJL"), Common.bindString(model.getXQRJL())));// 需求容积率
			paramsList.add(setNameValuePair(captureName("XQLJKD"), Common.bindString(model.getXQLJKD())));// 需求临街宽度
			paramsList.add(setNameValuePair(captureName("XQLJSD"), Common.bindString(model.getXQLJSD())));// 需求临街深度
			paramsList.add(setNameValuePair(captureName("XQJZLX"), Common.bindString(model.getXQJZLX())));// 需求建筑类型
			paramsList.add(setNameValuePair(captureName("XQJZCS"), Common.bindString(model.getXQJZCS())));// 需求建筑层数
			paramsList.add(setNameValuePair(captureName("XQFWJG"), Common.bindString(model.getXQFWJG())));// 需求房屋结构
			paramsList.add(setNameValuePair(captureName("XQJGSJ"), Common.bindString(model.getXQJGSJ())));// 需求竣工时间
			paramsList.add(setNameValuePair(captureName("XQFWCXD"), Common.bindString(model.getXQFWCXD())));// 需求房屋成新度
			paramsList.add(setNameValuePair(captureName("XQZXSJ"), Common.bindString(model.getXQZXSJ())));// 需求装修时间
			paramsList.add(setNameValuePair(captureName("XQZXCD"), Common.bindString(model.getXQZXCD())));// 需求装修程度
			paramsList.add(setNameValuePair(captureName("XQZZHX"), Common.bindString(model.getXQZZHX())));// 需求住宅户型
			paramsList.add(setNameValuePair(captureName("XQPTSS"), Common.bindString(model.getXQPTSS())));// 需求配套设施
			paramsList.add(setNameValuePair(captureName("XQZBJT"), Common.bindString(model.getXQZBJT())));// 需求周边交通
			paramsList.add(setNameValuePair(captureName("XQDWMJSJ"), Common.bindString(model.getXQDWMJSJ())));// 需求单位面积售价
			paramsList.add(setNameValuePair(captureName("XQZSJ"), Common.bindString(model.getXQZSJ())));// 需求总售价

			/** 其他信息 **/
			paramsList.add(setNameValuePair(captureName("TDJB"), Common.bindString(model.getTDJB())));// 所在土地级别
			paramsList.add(setNameValuePair(captureName("DJQD"), Common.bindString(model.getDJQD())));// 所在地价区段
			paramsList.add(setNameValuePair(captureName("XZQDM"), Common.bindString(model.getXZQDM())));// 行政区代码

			/** 位置信息 **/
			paramsList.add(setNameValuePair(captureName("X"), Common.bindString(model.getX())));// X坐标
			paramsList.add(setNameValuePair(captureName("Y"), Common.bindString(model.getY())));// Y坐标
			paramsList.add(setNameValuePair(captureName("ZBXT"), Common.bindString(model.getZBXT())));// 坐标系统
			paramsList.add(setNameValuePair(captureName("REMARK"), Common.bindString(model.getREMARK())));// 备注

			/** 系统信息 **/
			paramsList.add(setNameValuePair(captureName("INPUTUSERID"), Common.bindString(model.getINPUTUSERID())));// 创建用户
			paramsList.add(setNameValuePair(captureName("CREATETIME"), Common.bindString(model.getCREATETIME())));// 创建时间
			paramsList.add(setNameValuePair(captureName("LASTUPDATEUSERID"), Common.bindString(model.getLASTUPDATEUSERID())));// 修改用户
			paramsList.add(setNameValuePair(captureName("UPDATETIME"), Common.bindString(model.getUPDATETIME())));// 修改时间
			paramsList.add(setNameValuePair(captureName("ISDELETE"), Common.bindString(model.getISDELETE())));// 是否删除
			paramsList.add(setNameValuePair(captureName("SHOWSEQ"), Common.bindString(model.getSHOWSEQ())));// 显示顺序
		}
	}

	/**
	 * 说明：TODO(这里用一句话描述这个方法的作用)
	 * 
	 * @param info
	 * @param paramsList
	 * @return void
	 */
	private void setModelCollectionMarketDemandRent(LocationInfo info, List<NameValuePair> paramsList) {
		ModelCollectionMarketDemandRent model = DataSupport.find(ModelCollectionMarketDemandRent.class, info.getCollectionId());
		if (model != null) {
			/** 基本信息 **/
			paramsList.add(setNameValuePair(captureName("THENAME"), Common.bindString(model.getTHENAME())));// 记录名称
			paramsList.add(setNameValuePair(captureName("THECODE"), Common.bindString(model.getTHECODE())));// 记录代码

			/** 土地使用权出租需求信息 **/
			paramsList.add(setNameValuePair(captureName("XQCZF"), Common.bindString(model.getXQCZF())));// 需求承租方
			paramsList.add(setNameValuePair(captureName("XQCZFZTXZ"), Common.bindString(model.getXQCZFZTXZ())));// 需求承租方主体性质
			paramsList.add(setNameValuePair(captureName("NTDZL"), Common.bindString(model.getNTDZL())));// 拟土地坐落
			paramsList.add(setNameValuePair(captureName("NQSXZ"), Common.bindString(model.getNQSXZ())));// 拟权属性质
			paramsList.add(setNameValuePair(captureName("XQXZTDTJ"), Common.bindString(model.getXQXZTDTJ())));// 需求现状土地条件
			paramsList.add(setNameValuePair(captureName("XQCZSJ"), Common.bindString(model.getXQCZSJ())));// 需求出租时间
			paramsList.add(setNameValuePair(captureName("XQZQ"), Common.bindString(model.getXQZQ())));// 需求租期
			paramsList.add(setNameValuePair(captureName("XQCZMJ"), Common.bindString(model.getXQCZMJ())));// 需求土地出租面积
			paramsList.add(setNameValuePair(captureName("CZQYT"), Common.bindString(model.getCZQYT())));// 出租前用途
			paramsList.add(setNameValuePair(captureName("NCZYT"), Common.bindString(model.getNCZYT())));// 拟出租后用途
			paramsList.add(setNameValuePair(captureName("TDSYNQ"), Common.bindString(model.getTDSYNQ())));// 土地剩余使用年期
			paramsList.add(setNameValuePair(captureName("RJL"), Common.bindString(model.getRJL())));// 宗地容积率
			paramsList.add(setNameValuePair(captureName("XQNZJ"), Common.bindString(model.getXQNZJ())));// 需求年租金
			paramsList.add(setNameValuePair(captureName("NYJ"), Common.bindString(model.getNYJ())));// 拟押金

			/** 其他信息 **/
			paramsList.add(setNameValuePair(captureName("TDJB"), Common.bindString(model.getTDJB())));// 所在土地级别
			paramsList.add(setNameValuePair(captureName("DJQD"), Common.bindString(model.getDJQD())));// 所在地价区段
			paramsList.add(setNameValuePair(captureName("XZQDM"), Common.bindString(model.getXZQDM())));// 行政区代码

			/** 位置信息 **/
			paramsList.add(setNameValuePair(captureName("X"), Common.bindString(model.getX())));// X坐标
			paramsList.add(setNameValuePair(captureName("Y"), Common.bindString(model.getY())));// Y坐标
			paramsList.add(setNameValuePair(captureName("ZBXT"), Common.bindString(model.getZBXT())));// 坐标系统
			paramsList.add(setNameValuePair(captureName("REMARK"), Common.bindString(model.getREMARK())));// 备注

			/** 系统信息 **/
			paramsList.add(setNameValuePair(captureName("INPUTUSERID"), Common.bindString(model.getINPUTUSERID())));// 创建用户
			paramsList.add(setNameValuePair(captureName("CREATETIME"), Common.bindString(model.getCREATETIME())));// 创建时间
			paramsList.add(setNameValuePair(captureName("LASTUPDATEUSERID"), Common.bindString(model.getLASTUPDATEUSERID())));// 修改用户
			paramsList.add(setNameValuePair(captureName("UPDATETIME"), Common.bindString(model.getUPDATETIME())));// 修改时间
			paramsList.add(setNameValuePair(captureName("ISDELETE"), Common.bindString(model.getISDELETE())));// 是否删除
			paramsList.add(setNameValuePair(captureName("SHOWSEQ"), Common.bindString(model.getSHOWSEQ())));// 显示顺序
		}
	}

	/**
	 * 说明：TODO(这里用一句话描述这个方法的作用)
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
			/** 土地使用权转让供应信息 **/
			paramsList.add(setNameValuePair(captureName("TDSYZ"), Common.bindString(model.getTDSYZ())));// 土地所有者
			paramsList.add(setNameValuePair(captureName("TDZSH"), Common.bindString(model.getTDZSH())));// 土地证书号
			paramsList.add(setNameValuePair(captureName("TDZL"), Common.bindString(model.getTDZL())));// 土地坐落
			paramsList.add(setNameValuePair(captureName("QSXZ"), Common.bindString(model.getQSXZ())));// 权属性质
			paramsList.add(setNameValuePair(captureName("ZRF"), Common.bindString(model.getZRF())));// 转让方
			paramsList.add(setNameValuePair(captureName("NZRSJ"), Common.bindString(model.getNZRSJ())));// 拟转让时间
			paramsList.add(setNameValuePair(captureName("NZRFS"), Common.bindString(model.getNZRFS())));// 拟转让方式
			paramsList.add(setNameValuePair(captureName("NZRMJ"), Common.bindString(model.getNZRMJ())));// 拟土地转让面积
			paramsList.add(setNameValuePair(captureName("ZRQYT"), Common.bindString(model.getZRQYT())));// 转让前用途
			paramsList.add(setNameValuePair(captureName("NZRHYT"), Common.bindString(model.getNZRHYT())));// 拟转让后用途
			paramsList.add(setNameValuePair(captureName("TDSYNQ"), Common.bindString(model.getTDSYNQ())));// 土地剩余使用年期
			paramsList.add(setNameValuePair(captureName("ZRDJ"), Common.bindString(model.getZRDJ())));// 拟土地转让单价
			paramsList.add(setNameValuePair(captureName("ZRZJ"), Common.bindString(model.getZRZJ())));// 拟土地转让总价

			/** 其他信息 **/
			paramsList.add(setNameValuePair(captureName("RJL"), Common.bindString(model.getRJL())));// 容积率
			paramsList.add(setNameValuePair(captureName("HXWKFSP"), Common.bindString(model.getHXWKFSP())));// 红线外开发水平
			paramsList.add(setNameValuePair(captureName("HXNKFSP"), Common.bindString(model.getHXNKFSP())));// 红线内开发水平
			paramsList.add(setNameValuePair(captureName("TDJB"), Common.bindString(model.getTDJB())));// 所在土地级别
			paramsList.add(setNameValuePair(captureName("DJQD"), Common.bindString(model.getDJQD())));// 所在地价区段
			paramsList.add(setNameValuePair(captureName("XZQDM"), Common.bindString(model.getXZQDM())));// 行政区代码

			/** 位置信息 **/
			paramsList.add(setNameValuePair(captureName("X"), Common.bindString(model.getX())));// X坐标
			paramsList.add(setNameValuePair(captureName("Y"), Common.bindString(model.getY())));// Y坐标
			paramsList.add(setNameValuePair(captureName("ZBXT"), Common.bindString(model.getZBXT())));// 坐标系统
			paramsList.add(setNameValuePair(captureName("REMARK"), Common.bindString(model.getREMARK())));// 备注
			/** 系统信息 **/
			paramsList.add(setNameValuePair(captureName("INPUTUSERID"), Common.bindString(model.getINPUTUSERID())));// 创建用户
			paramsList.add(setNameValuePair(captureName("CREATETIME"), Common.bindString(model.getCREATETIME())));// 创建时间
			paramsList.add(setNameValuePair(captureName("LASTUPDATEUSERID"), Common.bindString(model.getLASTUPDATEUSERID())));// 修改用户
			paramsList.add(setNameValuePair(captureName("UPDATETIME"), Common.bindString(model.getUPDATETIME())));// 修改时间
			paramsList.add(setNameValuePair(captureName("ISDELETE"), Common.bindString(model.getISDELETE())));// 是否删除
			paramsList.add(setNameValuePair(captureName("SHOWSEQ"), Common.bindString(model.getSHOWSEQ())));// 显示顺序
		}
	}

	/**
	 * 说明：TODO(这里用一句话描述这个方法的作用)
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
			/** 土地联营入股供应信息 **/
			paramsList.add(setNameValuePair(captureName("TDSYZ"), Common.bindString(model.getTDSYZ())));// 土地所有者
			paramsList.add(setNameValuePair(captureName("TDZSH"), Common.bindString(model.getTDZSH())));// 土地证书号
			paramsList.add(setNameValuePair(captureName("TDZL"), Common.bindString(model.getTDZL())));// 土地坐落
			paramsList.add(setNameValuePair(captureName("QSXZ"), Common.bindString(model.getQSXZ())));// 权属性质
			paramsList.add(setNameValuePair(captureName("CDF"), Common.bindString(model.getCDF())));// 出地方
			paramsList.add(setNameValuePair(captureName("NLYSJ"), Common.bindString(model.getNLYSJ())));// 拟联营时间
			paramsList.add(setNameValuePair(captureName("NLYQ"), Common.bindString(model.getNLYQ())));// 拟联营期
			paramsList.add(setNameValuePair(captureName("NCDMJ"), Common.bindString(model.getNCDMJ())));// 拟出地方投入土地面积
			paramsList.add(setNameValuePair(captureName("NCZZE"), Common.bindString(model.getNCZZE())));// 拟出资方投入资金总额
			paramsList.add(setNameValuePair(captureName("NCDFFCBL"), Common.bindString(model.getNCDFFCBL())));// 拟出地方利润分成比例
			paramsList.add(setNameValuePair(captureName("NTDNCSR"), Common.bindString(model.getNTDNCSR())));// 拟单位面积土地年纯收入
			paramsList.add(setNameValuePair(captureName("NCDFNCSR"), Common.bindString(model.getNCDFNCSR())));// 拟出地方土地年纯收入
			paramsList.add(setNameValuePair(captureName("LYQYT"), Common.bindString(model.getLYQYT())));// 联营前用途
			paramsList.add(setNameValuePair(captureName("LYHGHYT"), Common.bindString(model.getLYHGHYT())));// 联营后规划用途

			/** 其他信息 **/
			paramsList.add(setNameValuePair(captureName("GHRJL"), Common.bindString(model.getGHRJL())));// 规划宗地容积率
			paramsList.add(setNameValuePair(captureName("GHHXWKFSP"), Common.bindString(model.getGHHXWKFSP())));// 规划红线外开发水平
			paramsList.add(setNameValuePair(captureName("GHHXNKFSP"), Common.bindString(model.getGHHXNKFSP())));// 规划红线内开发水平
			paramsList.add(setNameValuePair(captureName("TDJB"), Common.bindString(model.getTDJB())));// 所在土地级别
			paramsList.add(setNameValuePair(captureName("DJQD"), Common.bindString(model.getDJQD())));// 所在地价区段
			paramsList.add(setNameValuePair(captureName("XZQDM"), Common.bindString(model.getXZQDM())));// 行政区代码

			/** 位置信息 **/
			paramsList.add(setNameValuePair(captureName("X"), Common.bindString(model.getX())));// X坐标
			paramsList.add(setNameValuePair(captureName("Y"), Common.bindString(model.getY())));// Y坐标
			paramsList.add(setNameValuePair(captureName("ZBXT"), Common.bindString(model.getZBXT())));// 坐标系统
			paramsList.add(setNameValuePair(captureName("REMARK"), Common.bindString(model.getREMARK())));// 备注
			/** 系统信息 **/
			paramsList.add(setNameValuePair(captureName("INPUTUSERID"), Common.bindString(model.getINPUTUSERID())));// 创建用户
			paramsList.add(setNameValuePair(captureName("CREATETIME"), Common.bindString(model.getCREATETIME())));// 创建时间
			paramsList.add(setNameValuePair(captureName("LASTUPDATEUSERID"), Common.bindString(model.getLASTUPDATEUSERID())));// 修改用户
			paramsList.add(setNameValuePair(captureName("UPDATETIME"), Common.bindString(model.getUPDATETIME())));// 修改时间
			paramsList.add(setNameValuePair(captureName("ISDELETE"), Common.bindString(model.getISDELETE())));// 是否删除
			paramsList.add(setNameValuePair(captureName("SHOWSEQ"), Common.bindString(model.getSHOWSEQ())));// 显示顺序
		}
	}

	/**
	 * 说明：TODO(这里用一句话描述这个方法的作用)
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
			/** 土地使用权出让供应信息 **/
			paramsList.add(setNameValuePair(captureName("TDSYZ"), Common.bindString(model.getTDSYZ())));// 土地所有者
			paramsList.add(setNameValuePair(captureName("ZDBH"), Common.bindString(model.getZDBH())));// 宗地编号
			paramsList.add(setNameValuePair(captureName("TDZL"), Common.bindString(model.getTDZL())));// 土地坐落
			paramsList.add(setNameValuePair(captureName("QSXZ"), Common.bindString(model.getQSXZ())));// 权属性质
			paramsList.add(setNameValuePair(captureName("NCRSJ"), Common.bindString(model.getNCRSJ())));// 拟出让时间
			paramsList.add(setNameValuePair(captureName("CRFS"), Common.bindString(model.getCRFS())));// 拟出让方式
			paramsList.add(setNameValuePair(captureName("NCRNQ"), Common.bindString(model.getNCRNQ())));// 拟出让年期
			paramsList.add(setNameValuePair(captureName("SFZKF"), Common.bindString(model.getSFZKF())));// 是否再开发
			paramsList.add(setNameValuePair(captureName("SFLYD"), Common.bindString(model.getSFLYD())));// 是否留用地
			paramsList.add(setNameValuePair(captureName("GHTDMJ"), Common.bindString(model.getGHTDMJ())));// 规划红线范围土地面积
			paramsList.add(setNameValuePair(captureName("NDZTDMJ"), Common.bindString(model.getNDZTDMJ())));// 拟代征土地面积
			paramsList.add(setNameValuePair(captureName("CRQYT"), Common.bindString(model.getCRQYT())));// 出让前用途
			paramsList.add(setNameValuePair(captureName("CRHGHYT"), Common.bindString(model.getCRHGHYT())));// 出让后规划用途
			paramsList.add(setNameValuePair(captureName("NCRDJ"), Common.bindString(model.getNCRDJ())));// 拟单位面积土地出让价
			paramsList.add(setNameValuePair(captureName("NCRZJ"), Common.bindString(model.getNCRZJ())));// 拟土地出让总价

			/** 其他信息 **/
			paramsList.add(setNameValuePair(captureName("GHRJL"), Common.bindString(model.getGHRJL())));// 规划宗地容积率
			paramsList.add(setNameValuePair(captureName("GHHXWKFSP"), Common.bindString(model.getGHHXWKFSP())));// 规划红线外开发水平
			paramsList.add(setNameValuePair(captureName("GHHXNKFSP"), Common.bindString(model.getGHHXNKFSP())));// 规划红线内开发水平
			paramsList.add(setNameValuePair(captureName("TDJB"), Common.bindString(model.getTDJB())));// 所在土地级别
			paramsList.add(setNameValuePair(captureName("DJQD"), Common.bindString(model.getDJQD())));// 所在地价区段
			paramsList.add(setNameValuePair(captureName("XZQDM"), Common.bindString(model.getXZQDM())));// 行政区代码

			/** 位置信息 **/
			paramsList.add(setNameValuePair(captureName("X"), Common.bindString(model.getX())));// X坐标
			paramsList.add(setNameValuePair(captureName("Y"), Common.bindString(model.getY())));// Y坐标
			paramsList.add(setNameValuePair(captureName("ZBXT"), Common.bindString(model.getZBXT())));// 坐标系统
			paramsList.add(setNameValuePair(captureName("REMARK"), Common.bindString(model.getREMARK())));// 备注
			/** 系统信息 **/
			paramsList.add(setNameValuePair(captureName("INPUTUSERID"), Common.bindString(model.getINPUTUSERID())));// 创建用户
			paramsList.add(setNameValuePair(captureName("CREATETIME"), Common.bindString(model.getCREATETIME())));// 创建时间
			paramsList.add(setNameValuePair(captureName("LASTUPDATEUSERID"), Common.bindString(model.getLASTUPDATEUSERID())));// 修改用户
			paramsList.add(setNameValuePair(captureName("UPDATETIME"), Common.bindString(model.getUPDATETIME())));// 修改时间
			paramsList.add(setNameValuePair(captureName("ISDELETE"), Common.bindString(model.getISDELETE())));// 是否删除
			paramsList.add(setNameValuePair(captureName("SHOWSEQ"), Common.bindString(model.getSHOWSEQ())));// 显示顺序
		}
	}

	/**
	 * 说明：TODO(这里用一句话描述这个方法的作用)
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
			/** 土地使用权出租供应信息 **/
			paramsList.add(setNameValuePair(captureName("TDSYZ"), Common.bindString(model.getTDSYZ())));// 土地使用者
			paramsList.add(setNameValuePair(captureName("TDZSH"), Common.bindString(model.getTDZSH())));// 土地证书号
			paramsList.add(setNameValuePair(captureName("TDZL"), Common.bindString(model.getTDZL())));// 土地坐落
			paramsList.add(setNameValuePair(captureName("QSXZ"), Common.bindString(model.getQSXZ())));// 权属性质
			paramsList.add(setNameValuePair(captureName("CZF"), Common.bindString(model.getCZF())));// 出租方
			paramsList.add(setNameValuePair(captureName("NCZSJ"), Common.bindString(model.getNCZSJ())));// 拟出租时间
			paramsList.add(setNameValuePair(captureName("NZQ"), Common.bindString(model.getNZQ())));// 拟租期
			paramsList.add(setNameValuePair(captureName("NCZMJ"), Common.bindString(model.getNCZMJ())));// 拟土地出租面积
			paramsList.add(setNameValuePair(captureName("CZQYT"), Common.bindString(model.getCZQYT())));// 出租前用途
			paramsList.add(setNameValuePair(captureName("NCZHYT"), Common.bindString(model.getNCZHYT())));// 拟出租后用途
			paramsList.add(setNameValuePair(captureName("TDSYNQ"), Common.bindString(model.getTDSYNQ())));// 土地剩余使用年期
			paramsList.add(setNameValuePair(captureName("NZJ"), Common.bindString(model.getNZJ())));// 拟年租金
			paramsList.add(setNameValuePair(captureName("YJ"), Common.bindString(model.getYJ())));// 拟押金
			paramsList.add(setNameValuePair(captureName("SF"), Common.bindString(model.getSF())));// 拟税费

			/** 其他信息 **/
			paramsList.add(setNameValuePair(captureName("RJL"), Common.bindString(model.getRJL())));// 容积率
			paramsList.add(setNameValuePair(captureName("HXWKFSP"), Common.bindString(model.getHXWKFSP())));// 红线外开发水平
			paramsList.add(setNameValuePair(captureName("HXNKFSP"), Common.bindString(model.getHXNKFSP())));// 红线内开发水平
			paramsList.add(setNameValuePair(captureName("TDJB"), Common.bindString(model.getTDJB())));// 所在土地级别
			paramsList.add(setNameValuePair(captureName("DJQD"), Common.bindString(model.getDJQD())));// 所在地价区段
			paramsList.add(setNameValuePair(captureName("XZQDM"), Common.bindString(model.getXZQDM())));// 行政区代码

			/** 位置信息 **/
			paramsList.add(setNameValuePair(captureName("X"), Common.bindString(model.getX())));// X坐标
			paramsList.add(setNameValuePair(captureName("Y"), Common.bindString(model.getY())));// Y坐标
			paramsList.add(setNameValuePair(captureName("ZBXT"), Common.bindString(model.getZBXT())));// 坐标系统
			paramsList.add(setNameValuePair(captureName("REMARK"), Common.bindString(model.getREMARK())));// 备注
			/** 系统信息 **/
			paramsList.add(setNameValuePair(captureName("INPUTUSERID"), Common.bindString(model.getINPUTUSERID())));// 创建用户
			paramsList.add(setNameValuePair(captureName("CREATETIME"), Common.bindString(model.getCREATETIME())));// 创建时间
			paramsList.add(setNameValuePair(captureName("LASTUPDATEUSERID"), Common.bindString(model.getLASTUPDATEUSERID())));// 修改用户
			paramsList.add(setNameValuePair(captureName("UPDATETIME"), Common.bindString(model.getUPDATETIME())));// 修改时间
			paramsList.add(setNameValuePair(captureName("ISDELETE"), Common.bindString(model.getISDELETE())));// 是否删除
			paramsList.add(setNameValuePair(captureName("SHOWSEQ"), Common.bindString(model.getSHOWSEQ())));// 显示顺序
		}
	}

	/**
	 * 说明：TODO(这里用一句话描述这个方法的作用)
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
			/** 房地出售供应信息 **/
			paramsList.add(setNameValuePair(captureName("TDSYZ"), Common.bindString(model.getTDSYZ())));// 土地使用者
			paramsList.add(setNameValuePair(captureName("FWSYQR"), Common.bindString(model.getFWSYQR())));// 房屋所有权人
			paramsList.add(setNameValuePair(captureName("TDZSH"), Common.bindString(model.getTDZSH())));// 土地证书号
			paramsList.add(setNameValuePair(captureName("YSZSH"), Common.bindString(model.getYSZSH())));// 预售证书号
			paramsList.add(setNameValuePair(captureName("TDZL"), Common.bindString(model.getTDZL())));// 土地坐落
			paramsList.add(setNameValuePair(captureName("QSXZ"), Common.bindString(model.getQSXZ())));// 权属性质
			paramsList.add(setNameValuePair(captureName("FDSYNQ"), Common.bindString(model.getFDSYNQ())));// 房地剩余使用年期
			paramsList.add(setNameValuePair(captureName("SFESF"), Common.bindString(model.getSFESF())));// 是否二手房
			paramsList.add(setNameValuePair(captureName("SFZAJ"), Common.bindString(model.getSFZAJ())));// 是否转按揭
			paramsList.add(setNameValuePair(captureName("CCZT"), Common.bindString(model.getCCZT())));// 出租状态
			paramsList.add(setNameValuePair(captureName("DYZT"), Common.bindString(model.getDYZT())));// 抵押状态
			paramsList.add(setNameValuePair(captureName("TDYT"), Common.bindString(model.getTDYT())));// 土地用途
			paramsList.add(setNameValuePair(captureName("LJKD"), Common.bindString(model.getLJKD())));// 临街宽度
			paramsList.add(setNameValuePair(captureName("LJSD"), Common.bindString(model.getLJSD())));// 临街深度
			paramsList.add(setNameValuePair(captureName("JZLX"), Common.bindString(model.getJZLX())));// 建筑类型
			paramsList.add(setNameValuePair(captureName("JZCS"), Common.bindString(model.getJZCS())));// 建筑层数
			paramsList.add(setNameValuePair(captureName("FWJG"), Common.bindString(model.getFWJG())));// 房屋结构
			paramsList.add(setNameValuePair(captureName("JGSJ"), Common.bindString(model.getJGSJ())));// 竣工时间
			paramsList.add(setNameValuePair(captureName("FWCXD"), Common.bindString(model.getFWCXD())));// 房屋成新度
			paramsList.add(setNameValuePair(captureName("ZXSJ"), Common.bindString(model.getZXSJ())));// 装修时间
			paramsList.add(setNameValuePair(captureName("ZXCD"), Common.bindString(model.getZXCD())));// 装修程度
			paramsList.add(setNameValuePair(captureName("ZZHX"), Common.bindString(model.getZZHX())));// 住宅户型
			paramsList.add(setNameValuePair(captureName("PTSS"), Common.bindString(model.getPTSS())));// 配套设施
			paramsList.add(setNameValuePair(captureName("ZBJT"), Common.bindString(model.getZBJT())));// 周边交通
			paramsList.add(setNameValuePair(captureName("NCSLC"), Common.bindString(model.getNCSLC())));// 拟出售楼层
			paramsList.add(setNameValuePair(captureName("NCSYT"), Common.bindString(model.getNCSYT())));// 拟出售用途
			paramsList.add(setNameValuePair(captureName("NCSMJ"), Common.bindString(model.getNCSMJ())));// 拟出售建筑面积
			paramsList.add(setNameValuePair(captureName("NCSSJ"), Common.bindString(model.getNCSSJ())));// 拟出售时间
			paramsList.add(setNameValuePair(captureName("NDWMJSJ"), Common.bindString(model.getNDWMJSJ())));// 拟单位面积售价
			paramsList.add(setNameValuePair(captureName("NSJ"), Common.bindString(model.getNSJ())));// 拟售价
			paramsList.add(setNameValuePair(captureName("NSF"), Common.bindString(model.getNSF())));// 拟税费

			/** 其他信息 **/
			paramsList.add(setNameValuePair(captureName("RJL"), Common.bindString(model.getRJL())));// 容积率
			paramsList.add(setNameValuePair(captureName("HXWKFSP"), Common.bindString(model.getHXWKFSP())));// 红线外开发水平
			paramsList.add(setNameValuePair(captureName("HXNKFSP"), Common.bindString(model.getHXNKFSP())));// 红线内开发水平
			paramsList.add(setNameValuePair(captureName("TDJB"), Common.bindString(model.getTDJB())));// 所在土地级别
			paramsList.add(setNameValuePair(captureName("DJQD"), Common.bindString(model.getDJQD())));// 所在地价区段
			paramsList.add(setNameValuePair(captureName("XZQDM"), Common.bindString(model.getXZQDM())));// 行政区代码

			/** 位置信息 **/
			paramsList.add(setNameValuePair(captureName("X"), Common.bindString(model.getX())));// X坐标
			paramsList.add(setNameValuePair(captureName("Y"), Common.bindString(model.getY())));// Y坐标
			paramsList.add(setNameValuePair(captureName("ZBXT"), Common.bindString(model.getZBXT())));// 坐标系统
			paramsList.add(setNameValuePair(captureName("REMARK"), Common.bindString(model.getREMARK())));// 备注
			/** 系统信息 **/
			paramsList.add(setNameValuePair(captureName("INPUTUSERID"), Common.bindString(model.getINPUTUSERID())));// 创建用户
			paramsList.add(setNameValuePair(captureName("CREATETIME"), Common.bindString(model.getCREATETIME())));// 创建时间
			paramsList.add(setNameValuePair(captureName("LASTUPDATEUSERID"), Common.bindString(model.getLASTUPDATEUSERID())));// 修改用户
			paramsList.add(setNameValuePair(captureName("UPDATETIME"), Common.bindString(model.getUPDATETIME())));// 修改时间
			paramsList.add(setNameValuePair(captureName("ISDELETE"), Common.bindString(model.getISDELETE())));// 是否删除
			paramsList.add(setNameValuePair(captureName("SHOWSEQ"), Common.bindString(model.getSHOWSEQ())));// 显示顺序
		}
	}

	/**
	 * 说明：TODO(这里用一句话描述这个方法的作用)
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

			/** 房地出租供应信息 **/
			paramsList.add(setNameValuePair(captureName("TDSYZ"), Common.bindString(model.getTDSYZ())));// 土地使用者
			paramsList.add(setNameValuePair(captureName("TDZSH"), Common.bindString(model.getTDZSH())));// 土地证书号
			paramsList.add(setNameValuePair(captureName("TDZL"), Common.bindString(model.getTDZL())));// 土地坐落
			paramsList.add(setNameValuePair(captureName("FWSYQR"), Common.bindString(model.getFWSYQR())));// 房屋所有权人
			paramsList.add(setNameValuePair(captureName("QSXZ"), Common.bindString(model.getQSXZ())));// 权属性质
			paramsList.add(setNameValuePair(captureName("CZF"), Common.bindString(model.getCZF())));// 出租方
			paramsList.add(setNameValuePair(captureName("FDSYNQ"), Common.bindString(model.getFDSYNQ())));// 房地剩余使用年期
			paramsList.add(setNameValuePair(captureName("TDYT"), Common.bindString(model.getTDYT())));// 土地用途
			paramsList.add(setNameValuePair(captureName("LJKD"), Common.bindString(model.getLJKD())));// 临街宽度
			paramsList.add(setNameValuePair(captureName("LJSD"), Common.bindString(model.getLJSD())));// 临街深度
			paramsList.add(setNameValuePair(captureName("JZLX"), Common.bindString(model.getJZLX())));// 建筑类型
			paramsList.add(setNameValuePair(captureName("JZCS"), Common.bindString(model.getJZCS())));// 建筑层数
			paramsList.add(setNameValuePair(captureName("FWJG"), Common.bindString(model.getFWJG())));// 房屋结构
			paramsList.add(setNameValuePair(captureName("JGSJ"), Common.bindString(model.getJGSJ())));// 竣工时间
			paramsList.add(setNameValuePair(captureName("FWCXD"), Common.bindString(model.getFWCXD())));// 房屋成新度
			paramsList.add(setNameValuePair(captureName("ZXSJ"), Common.bindString(model.getZXSJ())));// 装修时间
			paramsList.add(setNameValuePair(captureName("ZXCD"), Common.bindString(model.getZXCD())));// 装修程度
			paramsList.add(setNameValuePair(captureName("ZZHX"), Common.bindString(model.getZZHX())));// 住宅户型
			paramsList.add(setNameValuePair(captureName("PTSS"), Common.bindString(model.getPTSS())));// 配套设施
			paramsList.add(setNameValuePair(captureName("ZBJT"), Common.bindString(model.getZBJT())));// 周边交通
			paramsList.add(setNameValuePair(captureName("NCZLC"), Common.bindString(model.getNCZLC())));// 拟出租楼层
			paramsList.add(setNameValuePair(captureName("NCZHYT"), Common.bindString(model.getNCZHYT())));// 拟出租用途
			paramsList.add(setNameValuePair(captureName("NCZMJ"), Common.bindString(model.getNCZMJ())));// 拟出租建筑面积
			paramsList.add(setNameValuePair(captureName("NCZSJ"), Common.bindString(model.getNCZSJ())));// 拟出租时间
			paramsList.add(setNameValuePair(captureName("NZQ"), Common.bindString(model.getNZQ())));// 拟租期(年)
			paramsList.add(setNameValuePair(captureName("NZJ"), Common.bindString(model.getNZJ())));// 拟年租金
			paramsList.add(setNameValuePair(captureName("NYJ"), Common.bindString(model.getNYJ())));// 拟押金
			paramsList.add(setNameValuePair(captureName("NSF"), Common.bindString(model.getNSF())));// 拟税费

			/** 其他信息 **/
			paramsList.add(setNameValuePair(captureName("RJL"), Common.bindString(model.getRJL())));// 容积率
			paramsList.add(setNameValuePair(captureName("HXWKFSP"), Common.bindString(model.getHXWKFSP())));// 红线外开发水平
			paramsList.add(setNameValuePair(captureName("HXNKFSP"), Common.bindString(model.getHXNKFSP())));// 红线内开发水平
			paramsList.add(setNameValuePair(captureName("TDJB"), Common.bindString(model.getTDJB())));// 所在土地级别
			paramsList.add(setNameValuePair(captureName("DJQD"), Common.bindString(model.getDJQD())));// 所在地价区段
			paramsList.add(setNameValuePair(captureName("XZQDM"), Common.bindString(model.getXZQDM())));// 行政区代码

			/** 位置信息 **/
			paramsList.add(setNameValuePair(captureName("X"), Common.bindString(model.getX())));// X坐标
			paramsList.add(setNameValuePair(captureName("Y"), Common.bindString(model.getY())));// Y坐标
			paramsList.add(setNameValuePair(captureName("ZBXT"), Common.bindString(model.getZBXT())));// 坐标系统
			paramsList.add(setNameValuePair(captureName("REMARK"), Common.bindString(model.getREMARK())));// 备注
			/** 系统信息 **/
			paramsList.add(setNameValuePair(captureName("INPUTUSERID"), Common.bindString(model.getINPUTUSERID())));// 创建用户
			paramsList.add(setNameValuePair(captureName("CREATETIME"), Common.bindString(model.getCREATETIME())));// 创建时间
			paramsList.add(setNameValuePair(captureName("LASTUPDATEUSERID"), Common.bindString(model.getLASTUPDATEUSERID())));// 修改用户
			paramsList.add(setNameValuePair(captureName("UPDATETIME"), Common.bindString(model.getUPDATETIME())));// 修改时间
			paramsList.add(setNameValuePair(captureName("ISDELETE"), Common.bindString(model.getISDELETE())));// 是否删除
			paramsList.add(setNameValuePair(captureName("SHOWSEQ"), Common.bindString(model.getSHOWSEQ())));// 显示顺序
		}
	}

	/**
	 * 说明：TODO(这里用一句话描述这个方法的作用)
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
			/** 土地市场监控点信息 **/
			paramsList.add(setNameValuePair(captureName("JCDMC"), Common.bindString(model.getJCDMC())));// 监测点名称
			paramsList.add(setNameValuePair(captureName("TDZL"), Common.bindString(model.getTDZL())));// 土地坐落
			paramsList.add(setNameValuePair(captureName("TDZSH"), Common.bindString(model.getTDZSH())));// 土地证书号
			paramsList.add(setNameValuePair(captureName("QSXZ"), Common.bindString(model.getQSXZ())));// 权属性质
			paramsList.add(setNameValuePair(captureName("GZQ"), Common.bindString(model.getGZQ())));// 工作期
			paramsList.add(setNameValuePair(captureName("TDYT"), Common.bindString(model.getTDYT())));// 土地用途
			paramsList.add(setNameValuePair(captureName("TDMJ"), Common.bindString(model.getTDMJ())));// 土地面积
			paramsList.add(setNameValuePair(captureName("TDSYZ"), Common.bindString(model.getTDSYZ())));// 土地所有者
			paramsList.add(setNameValuePair(captureName("TDSHYZ"), Common.bindString(model.getTDSHYZ())));// 土地使用者
			paramsList.add(setNameValuePair(captureName("RJL"), Common.bindString(model.getRJL())));// 容积率
			paramsList.add(setNameValuePair(captureName("JZMJ"), Common.bindString(model.getJZMJ())));// 建筑密度
			paramsList.add(setNameValuePair(captureName("JZXS"), Common.bindString(model.getJZXS())));// 建筑系数
			paramsList.add(setNameValuePair(captureName("LDL"), Common.bindString(model.getLDL())));// 绿地率
			paramsList.add(setNameValuePair(captureName("TDSYNQ"), Common.bindString(model.getTDSYNQ())));// 土地使用年期
			paramsList.add(setNameValuePair(captureName("ZDNKFSP"), Common.bindString(model.getZDNKFSP())));// 宗地内开发水平
			paramsList.add(setNameValuePair(captureName("ZSWKFSP"), Common.bindString(model.getZSWKFSP())));// 宗地外开发水平
			paramsList.add(setNameValuePair(captureName("XZL"), Common.bindString(model.getXZL())));// 土地闲置率（房屋空置率）
			paramsList.add(setNameValuePair(captureName("SCJG"), Common.bindString(model.getSCJG())));// 市场价格
			paramsList.add(setNameValuePair(captureName("SCZJ"), Common.bindString(model.getSCZJ())));// 市场租金
			paramsList.add(setNameValuePair(captureName("DJTZ"), Common.bindString(model.getDJTZ())));// 地均累计固定资产投资
			paramsList.add(setNameValuePair(captureName("DJCZ"), Common.bindString(model.getDJCZ())));// 地均产值
			paramsList.add(setNameValuePair(captureName("DJSS"), Common.bindString(model.getDJSS())));// 地均税收
			paramsList.add(setNameValuePair(captureName("DJCYRY"), Common.bindString(model.getDJCYRY())));// 地均从业人员（常住人口）
			paramsList.add(setNameValuePair(captureName("SDRJL"), Common.bindString(model.getSDRJL())));// 设定容积率
			paramsList.add(setNameValuePair(captureName("SDSYNQ"), Common.bindString(model.getSDSYNQ())));// 设定使用年期
			paramsList.add(setNameValuePair(captureName("SDKFSP"), Common.bindString(model.getSDKFSP())));// 设定开发水平
			paramsList.add(setNameValuePair(captureName("PGJG"), Common.bindString(model.getPGJG())));// 评估价格
			paramsList.add(setNameValuePair(captureName("TDJB"), Common.bindString(model.getTDJB())));// 所在土地级别
			paramsList.add(setNameValuePair(captureName("DJQD"), Common.bindString(model.getDJQD())));// 所在地价区段
			paramsList.add(setNameValuePair(captureName("XZQDM"), Common.bindString(model.getXZQDM())));// 行政区代码
			paramsList.add(setNameValuePair(captureName("REMARK"), Common.bindString(model.getREMARK())));// 备注

			/** 系统信息 **/
			paramsList.add(setNameValuePair(captureName("INPUTUSERID"), Common.bindString(model.getINPUTUSERID())));// 创建用户
			paramsList.add(setNameValuePair(captureName("CREATETIME"), Common.bindString(model.getCREATETIME())));// 创建时间
			paramsList.add(setNameValuePair(captureName("LASTUPDATEUSERID"), Common.bindString(model.getLASTUPDATEUSERID())));// 修改用户
			paramsList.add(setNameValuePair(captureName("UPDATETIME"), Common.bindString(model.getUPDATETIME())));// 修改时间
			paramsList.add(setNameValuePair(captureName("ISDELETE"), Common.bindString(model.getISDELETE())));// 是否删除
			paramsList.add(setNameValuePair(captureName("SHOWSEQ"), Common.bindString(model.getSHOWSEQ())));// 显示顺序
		}
	}

	/**
	 * 说明：TODO(这里用一句话描述这个方法的作用)
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
			/** 地价区段信息 **/
			paramsList.add(setNameValuePair(captureName("BSM"), Common.bindString(model.getBSM())));// 标识码
			paramsList.add(setNameValuePair(captureName("QDBH"), Common.bindString(model.getQDBH())));// 区段编号
			paramsList.add(setNameValuePair(captureName("QDMC"), Common.bindString(model.getQDMC())));// 区段名称
			paramsList.add(setNameValuePair(captureName("QDWZ"), Common.bindString(model.getQDWZ())));// 区段位置
			paramsList.add(setNameValuePair(captureName("YTLX"), Common.bindString(model.getYTLX())));// 业态类型
			paramsList.add(setNameValuePair(captureName("TDJB"), Common.bindString(model.getTDJB())));// 土地级别
			paramsList.add(setNameValuePair(captureName("XZQDM"), Common.bindString(model.getXZQDM())));// 土地级别
			paramsList.add(setNameValuePair(captureName("QDMJ"), Common.bindString(model.getQDMJ())));// 区段面积
			paramsList.add(setNameValuePair(captureName("SJYTMJ"), Common.bindString(model.getSJYTMJ())));// 实际用途面积
			paramsList.add(setNameValuePair(captureName("QDJCSSZK"), Common.bindString(model.getQDJCSSZK())));// 区段基础设施状况
			paramsList.add(setNameValuePair(captureName("QDGGSSZK"), Common.bindString(model.getQDGGSSZK())));// 区段公共公用设施状况
			paramsList.add(setNameValuePair(captureName("DZ"), Common.bindString(model.getDZ())));// 东至
			paramsList.add(setNameValuePair(captureName("NZ"), Common.bindString(model.getNZ())));// 南至
			paramsList.add(setNameValuePair(captureName("XZ"), Common.bindString(model.getXZ())));// 西至
			paramsList.add(setNameValuePair(captureName("BZ"), Common.bindString(model.getBZ())));// 北至
			paramsList.add(setNameValuePair(captureName("QD"), Common.bindString(model.getQD())));// 商服路线起点
			paramsList.add(setNameValuePair(captureName("ZD"), Common.bindString(model.getZD())));// 商服路线止点
			paramsList.add(setNameValuePair(captureName("XZRJL"), Common.bindString(model.getXZRJL())));// 现状容积率
			paramsList.add(setNameValuePair(captureName("ZYSYLX"), Common.bindString(model.getZYSYLX())));// 主要商服类型
			paramsList.add(setNameValuePair(captureName("JCNF"), Common.bindString(model.getJCNF())));// 建成年份及建筑物状况
			paramsList.add(setNameValuePair(captureName("XSZGZJ"), Common.bindString(model.getXSZGZJ())));// 现时最高年租金
			paramsList.add(setNameValuePair(captureName("XSPJZJ"), Common.bindString(model.getXSPJZJ())));// 现时平均年租金
			paramsList.add(setNameValuePair(captureName("XSZDZJ"), Common.bindString(model.getXSZDZJ())));// 现时最低年租金
			paramsList.add(setNameValuePair(captureName("XSZGSJ"), Common.bindString(model.getXSZGSJ())));// 现时最高售价
			paramsList.add(setNameValuePair(captureName("XSPJSJ"), Common.bindString(model.getXSPJSJ())));// 现时平均售价
			paramsList.add(setNameValuePair(captureName("XSZDSJ"), Common.bindString(model.getXSZDSJ())));// 现时最低售价
			paramsList.add(setNameValuePair(captureName("JZR"), Common.bindString(model.getJZR())));// 评估基准日
			paramsList.add(setNameValuePair(captureName("SDNQ"), Common.bindString(model.getSDNQ())));// 设定年期
			paramsList.add(setNameValuePair(captureName("SDRJL"), Common.bindString(model.getSDRJL())));// 设定容积率
			paramsList.add(setNameValuePair(captureName("SDKFSP"), Common.bindString(model.getSDKFSP())));// 设定开发水平
			paramsList.add(setNameValuePair(captureName("SYLXBZSD"), Common.bindString(model.getSYLXBZSD())));// 商业路线标准深度
			paramsList.add(setNameValuePair(captureName("DMJZDJ"), Common.bindString(model.getDMJZDJ())));// 地面基准地价
			paramsList.add(setNameValuePair(captureName("LMJZDJ"), Common.bindString(model.getLMJZDJ())));// 楼面基准地价
			paramsList.add(setNameValuePair(captureName("REMARK"), Common.bindString(model.getREMARK())));// 备注

			/** 系统信息 **/
			paramsList.add(setNameValuePair(captureName("INPUTUSERID"), Common.bindString(model.getINPUTUSERID())));// 创建用户
			paramsList.add(setNameValuePair(captureName("CREATETIME"), Common.bindString(model.getCREATETIME())));// 创建时间
			paramsList.add(setNameValuePair(captureName("LASTUPDATEUSERID"), Common.bindString(model.getLASTUPDATEUSERID())));// 修改用户
			paramsList.add(setNameValuePair(captureName("UPDATETIME"), Common.bindString(model.getUPDATETIME())));// 修改时间
			paramsList.add(setNameValuePair(captureName("ISDELETE"), Common.bindString(model.getISDELETE())));// 是否删除
			paramsList.add(setNameValuePair(captureName("SHOWSEQ"), Common.bindString(model.getSHOWSEQ())));// 显示顺序
		}
	}

	/**
	 * 说明：TODO(这里用一句话描述这个方法的作用)
	 * 
	 * @param info
	 * @param paramsList
	 * @return void
	 */
	private void setModelCollectionMarketMonitorLandLevel(LocationInfo info, List<NameValuePair> paramsList) {
		ModelCollectionMarketMonitorLandLevel model = DataSupport.find(ModelCollectionMarketMonitorLandLevel.class, info.getCollectionId());
		if (model != null) {
			/** 基本信息 **/
			paramsList.add(setNameValuePair("Thename", Common.bindString(model.getTHENAME())));
			paramsList.add(setNameValuePair("Thecode", Common.bindString(model.getTHECODE())));
			/** 土地级别信息 **/
			paramsList.add(setNameValuePair(captureName("Bsm"), Common.bindString(model.getBSM())));// 标识码
			paramsList.add(setNameValuePair(captureName("Xzqdm"), Common.bindString(model.getXZQDM())));// 行政区代码
			paramsList.add(setNameValuePair(captureName("Qsxz"), Common.bindString(model.getQSXZ())));// 权属性质
			// paramsList.add(setNameValuePair(captureName("Tdjb"),
			// Common.bindString(model.getTDJB())));// 土地级别
			// TODO 接口.反馈问题字段,在以后的版本中修复
			paramsList.add(setNameValuePair(captureName("Jzr"), Common.bindString(model.getJZR())));// 评估基准日
			paramsList.add(setNameValuePair(captureName("Sdql"), Common.bindString(model.getSDQL())));// 设定权利状况
			paramsList.add(setNameValuePair(captureName("Sdnq"), Common.bindString(model.getSDNQ())));// 设定年期
			paramsList.add(setNameValuePair(captureName("Sdrjl"), Common.bindString(model.getSDRJL())));// 设定容积率
			paramsList.add(setNameValuePair(captureName("Sdkfsp"), Common.bindString(model.getSDKFSP())));// 设定开发水平
			paramsList.add(setNameValuePair(captureName("Dmjzdj"), Common.bindString(model.getDMJZDJ())));// 地面基准地价
			paramsList.add(setNameValuePair(captureName("Lmjzdj"), Common.bindString(model.getLMJZDJ())));// 楼面基准地价
			paramsList.add(setNameValuePair(captureName("Remark"), Common.bindString(model.getREMARK())));// 备注

			/** 系统信息 **/
			paramsList.add(setNameValuePair(captureName("Inputuserid"), Common.bindString(model.getINPUTUSERID())));// 创建用户
			paramsList.add(setNameValuePair(captureName("Createtime"), Common.bindString(model.getCREATETIME())));// 创建时间
			paramsList.add(setNameValuePair(captureName("Lastupdateuserid"), Common.bindString(model.getLASTUPDATEUSERID())));// 修改用户
			paramsList.add(setNameValuePair(captureName("Updatetime"), Common.bindString(model.getUPDATETIME())));// 修改时间
			paramsList.add(setNameValuePair(captureName("Isdelete"), Common.bindString(model.getISDELETE())));// 是否删除
			paramsList.add(setNameValuePair(captureName("Showseq"), Common.bindString(model.getSHOWSEQ())));// 显示顺序
		}
	}

	/**
	 * 说明：TODO(这里用一句话描述这个方法的作用)
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
	 * 说明：TODO(这里用一句话描述这个方法的作用)
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
	 * 说明：TODO(这里用一句话描述这个方法的作用)
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
			/** 再开发计划项目信息 **/
			paramsList.add(setNameValuePair(captureName("BH"), Common.bindString(model.getBH())));// 编号
			paramsList.add(setNameValuePair(captureName("XMMC"), Common.bindString(model.getXMMC())));// 项目名称
			paramsList.add(setNameValuePair(captureName("TDZL"), Common.bindString(model.getTDZL())));// 土地坐落
			paramsList.add(setNameValuePair(captureName("TDSYZ"), Common.bindString(model.getTDSYZ())));// 土地所有者
			paramsList.add(setNameValuePair(captureName("TDSHYZ"), Common.bindString(model.getTDSHYZ())));// 土地使用者
			paramsList.add(setNameValuePair(captureName("TDYT"), Common.bindString(model.getTDYT())));// 土地用途
			paramsList.add(setNameValuePair(captureName("TDMJ"), Common.bindString(model.getTDMJ())));// 土地面积
			paramsList.add(setNameValuePair(captureName("GHYT"), Common.bindString(model.getGHYT())));// 规划用途
			paramsList.add(setNameValuePair(captureName("GHRJL"), Common.bindString(model.getGHRJL())));// 规划容积率
			paramsList.add(setNameValuePair(captureName("GHJZXS"), Common.bindString(model.getGHJZXS())));// 规划建筑系数
			paramsList.add(setNameValuePair(captureName("GHJZMD"), Common.bindString(model.getGHJZMD())));// 规划建筑密度
			paramsList.add(setNameValuePair(captureName("GHLVH"), Common.bindString(model.getGHLVH())));// 规划绿化率
			paramsList.add(setNameValuePair(captureName("NKFMS"), Common.bindString(model.getNKFMS())));// 拟开发模式
			paramsList.add(setNameValuePair(captureName("YJZTZ"), Common.bindString(model.getYJZTZ())));// 预计总投资
			paramsList.add(setNameValuePair(captureName("ZJLY"), Common.bindString(model.getZJLY())));// 资金来源
			paramsList.add(setNameValuePair(captureName("NGDFS"), Common.bindString(model.getNGDFS())));// 拟供地方式
			paramsList.add(setNameValuePair(captureName("CYLX"), Common.bindString(model.getCYLX())));// 规划产业类型
			paramsList.add(setNameValuePair(captureName("QYZDCY"), Common.bindString(model.getQYZDCY())));// 区域主导产业类型
			paramsList.add(setNameValuePair(captureName("QYGYJZDJ"), Common.bindString(model.getQYGYJZDJ())));// 区域国有建设用地基准地价
			paramsList.add(setNameValuePair(captureName("QYJTJZDJ"), Common.bindString(model.getQYJTJZDJ())));// 区域集体建设用地基准地价
			paramsList.add(setNameValuePair(captureName("YJDJCZ"), Common.bindString(model.getYJDJCZ())));// 预计地均产值
			paramsList.add(setNameValuePair(captureName("YJDJSS"), Common.bindString(model.getYJDJSS())));// 预计地均税收
			paramsList.add(setNameValuePair(captureName("YJDJCYRY"), Common.bindString(model.getYJDJCYRY())));// 预计地均从业人员数
			paramsList.add(setNameValuePair(captureName("QTYQYX"), Common.bindString(model.getQTYQYX())));// 其它预期效应
			paramsList.add(setNameValuePair(captureName("ZFYY"), Common.bindString(model.getZFYY())));// 政府意愿
			paramsList.add(setNameValuePair(captureName("KFSYY"), Common.bindString(model.getKFSYY())));// 开发商意愿
			paramsList.add(setNameValuePair(captureName("TDSYZYY"), Common.bindString(model.getTDSYZYY())));// 土地所有者意愿
			paramsList.add(setNameValuePair(captureName("TDSHYZYY"), Common.bindString(model.getTDSHYZYY())));// 土地使用者意愿

			/** 其他信息 **/
			paramsList.add(setNameValuePair(captureName("TDJB"), Common.bindString(model.getTDJB())));// 所在土地级别
			paramsList.add(setNameValuePair(captureName("DJQD"), Common.bindString(model.getDJQD())));// 所在地价区段
			paramsList.add(setNameValuePair(captureName("XZQDM"), Common.bindString(model.getXZQDM())));// 行政区代码
			paramsList.add(setNameValuePair(captureName("REMARK"), Common.bindString(model.getREMARK())));// 备注
			/** 系统信息 **/
			paramsList.add(setNameValuePair(captureName("INPUTUSERID"), Common.bindString(model.getINPUTUSERID())));// 创建用户
			paramsList.add(setNameValuePair(captureName("CREATETIME"), Common.bindString(model.getCREATETIME())));// 创建时间
			paramsList.add(setNameValuePair(captureName("LASTUPDATEUSERID"), Common.bindString(model.getLASTUPDATEUSERID())));// 修改用户
			paramsList.add(setNameValuePair(captureName("UPDATETIME"), Common.bindString(model.getUPDATETIME())));// 修改时间
			paramsList.add(setNameValuePair(captureName("ISDELETE"), Common.bindString(model.getISDELETE())));// 是否删除
			paramsList.add(setNameValuePair(captureName("SHOWSEQ"), Common.bindString(model.getSHOWSEQ())));// 显示顺序
		}
	}

	/**
	 * 说明：TODO(这里用一句话描述这个方法的作用)
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
			/** 再开发实施项目信息 **/
			paramsList.add(setNameValuePair(captureName("BH"), Common.bindString(model.getBH())));// 编号
			paramsList.add(setNameValuePair(captureName("XMMC"), Common.bindString(model.getXMMC())));// 项目名称
			paramsList.add(setNameValuePair(captureName("XMLX"), Common.bindString(model.getXMLX())));// 项目类型
			paramsList.add(setNameValuePair(captureName("TDZL"), Common.bindString(model.getTDZL())));// 土地坐落
			paramsList.add(setNameValuePair(captureName("TDMJ"), Common.bindString(model.getTDMJ())));// 土地面积
			paramsList.add(setNameValuePair(captureName("RJL"), Common.bindString(model.getRJL())));// 容积率
			paramsList.add(setNameValuePair(captureName("JZXS"), Common.bindString(model.getJZXS())));// 建筑系数
			paramsList.add(setNameValuePair(captureName("JZMD"), Common.bindString(model.getJZMD())));// 建筑密度
			paramsList.add(setNameValuePair(captureName("LVH"), Common.bindString(model.getLVH())));// 绿化率
			paramsList.add(setNameValuePair(captureName("KFMS"), Common.bindString(model.getKFMS())));// 开发模式
			paramsList.add(setNameValuePair(captureName("ZTZ"), Common.bindString(model.getZTZ())));// 总投资
			paramsList.add(setNameValuePair(captureName("ZJLY"), Common.bindString(model.getZJLY())));// 资金来源
			paramsList.add(setNameValuePair(captureName("GDFS"), Common.bindString(model.getGDFS())));// 供地方式
			paramsList.add(setNameValuePair(captureName("KFQYT"), Common.bindString(model.getKFQYT())));// 开发前用途
			paramsList.add(setNameValuePair(captureName("KFHYT"), Common.bindString(model.getKFHYT())));// 开发后用途
			paramsList.add(setNameValuePair(captureName("CYLX"), Common.bindString(model.getCYLX())));// 产业类型
			paramsList.add(setNameValuePair(captureName("QYZDCY"), Common.bindString(model.getQYZDCY())));// 区域主导产业类型
			paramsList.add(setNameValuePair(captureName("QYGYJZDJ"), Common.bindString(model.getQYGYJZDJ())));// 区域国有建设用地基准地价
			paramsList.add(setNameValuePair(captureName("QYJTJZDJ"), Common.bindString(model.getQYJTJZDJ())));// 区域集体建设用地基准地价
			paramsList.add(setNameValuePair(captureName("DJCZ"), Common.bindString(model.getDJCZ())));// 地均产值
			paramsList.add(setNameValuePair(captureName("DJSS"), Common.bindString(model.getDJSS())));// 地均税收
			paramsList.add(setNameValuePair(captureName("DJCYRY"), Common.bindString(model.getDJCYRY())));// 地均从业人员数

			/** 其他信息 **/
			paramsList.add(setNameValuePair(captureName("TDJB"), Common.bindString(model.getTDJB())));// 所在土地级别
			paramsList.add(setNameValuePair(captureName("DJQD"), Common.bindString(model.getDJQD())));// 所在地价区段
			paramsList.add(setNameValuePair(captureName("XZQDM"), Common.bindString(model.getXZQDM())));// 行政区代码
			paramsList.add(setNameValuePair(captureName("REMARK"), Common.bindString(model.getREMARK())));// 备注
			/** 系统信息 **/
			paramsList.add(setNameValuePair(captureName("INPUTUSERID"), Common.bindString(model.getINPUTUSERID())));// 创建用户
			paramsList.add(setNameValuePair(captureName("CREATETIME"), Common.bindString(model.getCREATETIME())));// 创建时间
			paramsList.add(setNameValuePair(captureName("LASTUPDATEUSERID"), Common.bindString(model.getLASTUPDATEUSERID())));// 修改用户
			paramsList.add(setNameValuePair(captureName("UPDATETIME"), Common.bindString(model.getUPDATETIME())));// 修改时间
			paramsList.add(setNameValuePair(captureName("ISDELETE"), Common.bindString(model.getISDELETE())));// 是否删除
			paramsList.add(setNameValuePair(captureName("SHOWSEQ"), Common.bindString(model.getSHOWSEQ())));// 显示顺序
		}
	}
}
