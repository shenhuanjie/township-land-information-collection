/**
 * 
 */
package com.example.town_land_collect.util;

/**
 * @Title CollectType.java
 * @Package com.example.town_land_collect.util
 * @Description 用于显示采集类型
 * @author Shen.dev
 * @date 2015-10-14 上午3:01:44
 * @version V1.0
 */
public class CollectType {

	public final static int Business = 10;
	public final static int Collection_Market_Business_House_Rent = 10;
	public final static int Collection_Market_Business_House_Sell = 11;
	public final static int Collection_Market_Business_Rent_Out = 12;
	public final static int Collection_Market_Business_Sell = 13;
	public final static int Collection_Market_Business_ShareHolder = 14;
	public final static int Collection_Market_Business_Transfer = 15;

	public final static int Demand = 20;
	public final static int Collection_Market_Demand_House_Rent = 20;
	public final static int Collection_Market_Demand_House_Sell = 21;
	public final static int Collection_Market_Demand_Rent = 22;
	public final static int Collection_Market_Demand_Sell = 23;
	public final static int Collection_Market_Demand_ShareHolder = 24;
	public final static int Collection_Market_Demand_Transfer = 25;

	public final static int Monitor = 30;
	public final static int Collection_Market_Monitor_Land_Level = 30;
	public final static int Collection_Market_Monitor_Land_Value = 31;
	public final static int Collection_Market_Monitor_Point = 32;

	public final static int Supply = 40;
	public final static int Collection_Market_Supply_House_Rent = 40;
	public final static int Collection_Market_Supply_House_Sell = 41;
	public final static int Collection_Market_Supply_Rent = 42;
	public final static int Collection_Market_Supply_Sell = 43;
	public final static int Collection_Market_Supply_ShareHolder = 44;
	public final static int Collection_Market_Supply_Transfer = 45;

	public final static int Redevelopment = 50;
	public final static int Collection_Market_Redevelopment_Impose = 50;
	public final static int Collection_Market_Redevelopment_Plan = 51;

	public final static int Development = 60;
	public final static int Collection_Market_Development_Township = 60;
	public final static int Collection_Market_Development_Village = 61;

	public final static String Collection_Market_Business_Sell_Tablename = "Tdcrjy";
	public final static String Collection_Market_Business_Transfer_Tablename = "Tdzrjy";
	public final static String Collection_Market_Business_Rent_Out_Tablename = "Tdczjy";
	public final static String Collection_Market_Business_ShareHolder_Tablename = "Tdlyrgjy";
	public final static String Collection_Market_Business_House_Rent_Tablename = "Fdczjy";
	public final static String Collection_Market_Business_House_Sell_Tablename = "Fdcsjy";

	public final static String Collection_Market_Supply_Sell_Tablename = "Tdcrgy";
	public final static String Collection_Market_Supply_Transfer_Tablename = "Tdzrgy";
	public final static String Collection_Market_Supply_Rent_Tablename = "Tdczgy";
	public final static String Collection_Market_Supply_ShareHolder_Tablename = "Tdlyrggy";
	public final static String Collection_Market_Supply_House_Rent_Tablename = "Fdczgy";
	public final static String Collection_Market_Supply_House_Sell_Tablename = "Fdcsgy";

	public final static String Collection_Market_Demand_Sell_Tablename = "Tdcrxq";
	public final static String Collection_Market_Demand_Transfer_Tablename = "Tdzrxq";
	public final static String Collection_Market_Demand_Rent_Tablename = "Tdczxq";
	public final static String Collection_Market_Demand_ShareHolder_Tablename = "Tdlyrgxq";
	public final static String Collection_Market_Demand_House_Rent_Tablename = "Fdczxq";
	public final static String Collection_Market_Demand_House_Sell_Tablename = "Fdcsxq";

	public final static String Collection_Market_Monitor_Point_Tablename = "Jcd";
	public final static String Collection_Market_Monitor_Land_Level_Tablename = "Tdjb";
	public final static String Collection_Market_Monitor_Land_Value_Tablename = "Djqd";

	public final static String Collection_Market_Redevelopment_Impose_Tablename = "Zkfssxm";
	public final static String Collection_Market_Redevelopment_Plan_Tablename = "Zkfjhxm";

	public final static String Collection_Market_Development_Township_Tablename = "Xzshjj";
	public final static String Collection_Market_Development_Village_Tablename = "Xzcshjj";

	public final static int State_Code_Not_Yet_Upload = 0;
	public final static int State_Code_Uploaded = 1;
	public final static int State_Code_Expired = 2;

	public final static int State_Image_Code_Not_Yet_Upload = 1;
	public final static int State_Image_Code_Uploaded = 2;
}
