/**
 * 
 */
package com.example.town_land_collect.util;

import java.util.ArrayList;

/**
 * @Title commonTypeUtil.java
 * @Package com.example.town_land_collect.util
 * @Description TODO(用一句话描述该文件做什么)
 * @author Shen.dev
 * @date 2015-10-16 上午10:17:15
 * @version V1.0
 */
public class CommonTypeUtil {

	/**
	 * 说明：TODO(这里用一句话描述这个方法的作用)
	 * 
	 * @param name
	 * @return
	 * @return ArrayList<String>
	 */
	public ArrayList<String> initList(String name) {
		ArrayList<String> list = new ArrayList<String>();
		/** 土地使用权出让方式 **/
		if (name.equals("tdsyqcrfs")) {
			list.add("01");// 招标
			list.add("02");// 拍卖
			list.add("03");// 挂牌
			list.add("04");// 协议
		}
		/** 权属性质 **/
		else if (name.equals("qsxz")) {
			list.add("10");// 国有土地所有权
			list.add("20");// 国有土地使用权
			list.add("30");// 集体土地所有权
			list.add("40");// 集体土地使用权
			list.add("31");// 村民小组
			list.add("32");// 村集体经济组织
			list.add("33");// 乡集体经济组织
			list.add("34");// 其他农民集体经济组织
		}
		/** 房屋结构 **/
		else if (name.equals("fwjg")) {
			list.add("1");// 钢结构
			list.add("2");// 钢、钢筋混凝土结构
			list.add("3");// 钢筋混凝土结构
			list.add("4");// 混合结构
			list.add("5");// 砖木结构
			list.add("6");// 简易房
			list.add("9");// 其他结构
		}
		/** 土地用途 **/
		else if (name.equals("tdyt")) {
			list.add("00");// 综合用地
			list.add("05");// 商服用地
			list.add("06");// 工业用地
			list.add("07");// 住宅用地
			list.add("08");// 公共管理与服务用地
			list.add("99");// 其它用地
		}
		/** 转让方式 **/
		else if (name.equals("zrfs")) {
			list.add("1");// 买卖
			list.add("2");// 赠予
			list.add("3");// 作价出资入股
			list.add("4");// 交换
			list.add("5");// 联营
			list.add("6");// 继承
			list.add("7");// 其他
		}
		/** 红线外开发水平 **/
		else if (name.equals("hxwkfsp")) {
			list.add("3");// 三通
			list.add("4");// 四通
			list.add("5");// 五通
			list.add("6");// 六通
			list.add("7");// 七通
			list.add("8");// 八通
			list.add("9");// 九通
		}
		/** 红线内开发水平 **/
		else if (name.equals("hxnkfsp")) {
			list.add("3");// 三通一平
			list.add("4");// 四通一平
			list.add("5");// 五通一平
			list.add("6");// 六通一平
			list.add("7");// 七通一平
			list.add("8");// 八通一平
			list.add("9");// 九通一平
		}
		/** 设定开发水平 **/
		else if (name.equals("sdkfsp")) {
			list.add("3");// 三通一平
			list.add("4");// 四通一平
			list.add("5");// 五通一平
			list.add("6");// 六通一平
			list.add("7");// 七通一平
			list.add("8");// 八通一平
			list.add("9");// 九通一平
		}
		/** 建筑类型 **/
		else if (name.equals("jzlx")) {
			list.add("111");// 普通多层
			list.add("112");// 电梯多层
			list.add("113");// 小高层
			list.add("114");// 高层
			list.add("115");// 叠加
			list.add("116");// 平房
			list.add("121");// 联排
			list.add("122");// 双拼
			list.add("123");// 独栋
			list.add("211");// 商铺
			list.add("212");// 办公
			list.add("213");// 综合
			list.add("221");// 钢结构厂房、仓库
			list.add("222");// 其它厂房、仓库
		}
		/** 再开发资金来源 **/
		else if (name.equals("zkfzjly")) {
			list.add("1");// 土地出让金
			list.add("2");// 政府专项资金
			list.add("3");// 其它政府资金
			list.add("4");// 开发商投资
			list.add("5");// 土地权利人投资
			list.add("6");// 其它社会资金
			list.add("7");// 其它资金
		}
		/** 再开发模式 **/
		else if (name.equals("zkfms")) {
			list.add("1");// 自行开发
			list.add("2");// 土地入股
			list.add("3");// 合作开发
			list.add("4");// 市场主体收购
			list.add("5");// 政府收储
			list.add("6");// 增减挂钩
			list.add("7");// 土地整治
			list.add("99");// 其它
		}
		/** 土地供应方式 **/
		else if (name.equals("tdgyfs")) {
			list.add("1");// 划拨
			list.add("2");// 招拍挂出让
			list.add("21");// 招标出让
			list.add("22");// 拍卖出让
			list.add("23");// 挂牌出让
			list.add("3");// 协议出让
			list.add("4");// 租赁
			list.add("5");// 作价出资或入股
			list.add("6");// 授权经营
		}
		/** 房屋成新度 **/
		else if (name.equals("fwcxd")) {
			list.add("01");// 十、九、八成
			list.add("02");// 七、六成
			list.add("03");// 五、四成
			list.add("04");// 三成以下
		}
		/** 装修程度 **/
		else if (name.equals("zxcd")) {
			list.add("01");// 毛坯房
			list.add("02");// 简装修
			list.add("03");// 全装修
			list.add("04");// 精装修
		}
		/** 出租/出售用途 **/
		else if (name.equals("ytlx")) {
			list.add("01");// 住宅
			list.add("02");// 工业
			list.add("03");// 仓储
			list.add("04");// 商业
			list.add("05");// 金融、信息
			list.add("06");// 其他用途
		}
		/** 土地级别 **/
		else if (name.equals("tdjb")) {
			list.add("1");// 一级
			list.add("2");// 二级
			list.add("3");// 三级
			list.add("4");// 四级
			list.add("5");// 五级
			list.add("6");// 六级
			list.add("7");// 七级
			list.add("8");// 八级
			list.add("9");// 九级
			list.add("10");// 十级
			list.add("11");// 十一级
			list.add("12");// 十二级
			list.add("13");// 十三级
			list.add("14");// 十四级
			list.add("15");// 十五级
			list.add("16");// 十六级
			list.add("17");// 十七级
			list.add("18");// 十八级
			list.add("0");// 未评估地区
		}
		/** 投资主体性质 **/
		else if (name.equals("tzztxz")) {
			list.add("1");// 内资企业
			list.add("11");// 国有企业
			list.add("12");// 集体企业
			list.add("13");// 股份合作企业
			list.add("14");// 联营企业
			list.add("141");// 国有联营企业
			list.add("142");// 集体联营企业
			list.add("143");// 国有与集体联营企业
			list.add("149");// 其他联营企业
			list.add("15");// 有限责任公司
			list.add("151");// 国有独资公司
			list.add("159");// 其他有限责任公司
			list.add("16");// 股份有限公司
			list.add("17");// 私营企业
			list.add("171");// 私营独资企业
			list.add("172");// 私营合伙企业
			list.add("173");// 私营有限责任公司
			list.add("174");// 私营股份有限公司
			list.add("19");// 其他内资企业
			list.add("2");// 港、澳、台商投资企业
			list.add("21");// 合资经营企业
			list.add("22");// 合作经营企业
			list.add("23");// 港、澳、台商独资企业
			list.add("24");// 港、澳、台商投资股份有限公司
			list.add("3");// 外商投资企业
			list.add("31");// 中外合资经营企业
			list.add("32");// 中外合作经营企业
			list.add("33");// 外资（独资）企业
			list.add("34");// 外商投资股份有限公司
			list.add("4");// 机关团体
			list.add("5");// 事业单位
			list.add("6");// 社团(包括村委会)
			list.add("7");// 个人
		}
		/** 产业类型 **/
		else if (name.equals("cylx")) {
			list.add("A");// 农、林、牧、渔业
			list.add("A01");// 农业
			list.add("A02");// 林业
			list.add("A03");// 畜牧业
			list.add("A04");// 渔业
			list.add("A05");// 农、林、牧、渔服务业

			list.add("B");// 采矿业
			list.add("B06");// 煤炭开采和洗选业
			list.add("B07");// 石油和天然气开采业
			list.add("B08");// 黑色金属矿采选业
			list.add("B0810");// 铁矿采选
			list.add("B0890");// 其他黑色金属矿采选
			list.add("B0899");// 其它
			list.add("B09");// 有色金属矿采选业
			list.add("B0911");// 铜矿采选
			list.add("B0912");// 铝矿采选
			list.add("B0919");// 其它
			list.add("B10");// 非金属矿采选业
			list.add("B1011");// 石灰石、石膏开采
			list.add("B1012");// 粘土及其他土砂石开采
			list.add("B1019");// 其它
			list.add("B11");// 其他采矿业

			list.add("C");// 制造业
			list.add("C13");// 农副食品加工业
			list.add("C14");// 食品制造业
			list.add("C15");// 饮料制造业
			list.add("C16");// 烟草制品业
			list.add("C17");// 纺织业
			list.add("C171");// 棉、化纤纺织及印染精加工
			list.add("C179");// 其它
			list.add("C18");// 纺织服装、鞋、帽制造业
			list.add("C19");// 皮革、毛皮、羽毛（绒）及其制造业
			list.add("C20");// 木材加工及木、竹、藤、棕、草制品业
			list.add("C21");// 家具制造业
			list.add("C22");// 造纸及纸质品业
			list.add("C23");// 印刷业和记录媒体的复制
			list.add("C24");// 文教体育用品制造业
			list.add("C25");// 石油加工、炼焦及核燃料加工业
			list.add("C26");// 化学原料及化学制品制造业
			list.add("C27");// 医药制造业
			list.add("C28");// 化学纤维制造业
			list.add("C29");// 橡胶制品业
			list.add("C30");// 塑料制品业
			list.add("C31");// 非金属矿物制品业
			list.add("C311");// 水泥、石灰和石膏的制造
			list.add("C312");// 水泥及石膏制品制造
			list.add("C313");// 砖瓦、石材及其他建筑材料制造
			list.add("C319");// 其它
			list.add("C32");// 黑色金属冶炼及压延加工业
			list.add("C321");// 炼铁
			list.add("C323");// 炼钢
			list.add("C323");// 钢压延加工
			list.add("C324");// 铁合金冶炼
			list.add("C33");// 有色金属冶炼及压延加工业
			list.add("C3311");// 铜冶炼
			list.add("C3316");// 铝冶炼
			list.add("C3319");// 其它
			list.add("C34");// 金属制品业
			list.add("C35");// 通用设备制造业
			list.add("C36");// 专用设备制造业
			list.add("C37");// 交通运输设备制造业
			list.add("C371");// 铁路运输设备制造
			list.add("C372");// 汽车制造
			list.add("C373");// 摩托车制造
			list.add("C374");// 自行车制造
			list.add("C375");// 船舶及浮动装置制造
			list.add("C379");// 其它
			list.add(" C39");// 电气机械及器材制造业
			list.add("C3951");// 家用制冷电器具制造
			list.add("C3952");// 家用空气调节器制造
			list.add("C3959");// 其它
			list.add("C40");// 通讯设备、计算机及其他电子设备制造业
			list.add("C41");// 仪器仪表及文化、办公用机械制造业
			list.add("C42");// 工艺品及其他制造业
			list.add("C43");// 废弃资源和废旧材料回收加工业

			list.add("D");// 电力、燃气及水的生产和供应业
			list.add("D44");// 电力、热力的生产和供应业
			list.add("D4411");// 火力发电
			list.add("D4412");// 水力发电
			list.add("D4413");// 核力发电
			list.add("D4419");// 其它
			list.add("D45");// 燃气生产和供应业
			list.add("D46");// 水的生产和供应业

			list.add("E");// 建筑业
			list.add("E47");// 房屋和土木工程业
			list.add("E48");// 建筑安装业
			list.add("E49");// 建筑装饰业
			list.add("E50");// 其它建筑业
			list.add("E501");// 工程准备
			list.add("E509");// 其它

			list.add("F");// 交通运输、仓储和邮政业
			list.add("F51");// 铁路运输业
			list.add("F52");// 道路运输业
			list.add("F53");// 城市公共交通业
			list.add("F54");// 水上运输业
			list.add("F55");// 航空运输业
			list.add("F56");// 管道运输业
			list.add("F57");// 装卸搬运和其他运输服务业
			list.add("F58");// 仓储业
			list.add("F59");// 邮政业

			list.add("G");// 信息传输、计算机服务和软件业
			list.add("G60");// 电信和其他信息传输服务业
			list.add("G61");// 计算机服务业
			list.add("G62");// 软件业

			list.add("H");// 批发和零售业
			list.add("H63");// 批发业
			list.add("H65");// 零售业

			list.add("I");// 住宿和餐饮业
			list.add("I66");// 住宿业
			list.add("I74");// 餐饮业

			list.add("J");// 金融业
			list.add("J68");// 银行业
			list.add("J69");// 证券业
			list.add("J70");// 保险业
			list.add("J71");// 其他金融服务

			list.add("K");// 房地产业
			list.add("K72");// 房地产业

			list.add("L");// 租赁和商务服务业
			list.add("L73");// 租赁业
			list.add("L74");// 商务服务业

			list.add("M");// 科学研究、技术服务和地质勘查业
			list.add("M75");// 研究与试验发展
			list.add("M76");// 专业技术服务业
			list.add("M77");// 科技交流和推广服务业
			list.add("M78");// 地质勘查业

			list.add("N");// 水利、环境和公共设施管理业
			list.add("N79");// 水利管理业
			list.add("N80");// 环境管理业
			list.add("N81");// 公共设施管理业

			list.add("O");// 居民服务和其他服务业
			list.add("O82");// 居民服务业
			list.add("O83");// 其他服务业
			list.add("P");// 教育
			list.add("P84");// 教育业
			list.add("Q");// 卫生、社会保障和社会福利业
			list.add("Q85");// 卫生
			list.add("Q86");// 社会保障业
			list.add("Q87");// 社会福利业
			list.add("R");// 文化、体育和娱乐业
			list.add("R88");// 新闻出版业
			list.add("R89");// 广播、电视、电影和音像业
			list.add("R90");// 文化艺术业
			list.add("R91");// 体育
			list.add("R92");// 娱乐业
			list.add("S");// 公共管理和社会组织
			list.add("S93");// 中国共产党机关
			list.add("S94");// 国家机构
			list.add("S95");// 人民政协和民主党派
			list.add("S96");// 群众团体、社会团体和宗教组织
			list.add("S97");// 基层群众自治组织
			list.add("T");// 国际组织
			list.add("T98");// 国际组织
		}
		/** 产权性质 **/
		else if (name.equals("cqxz")) {
			list.add("1");// 商品房
			list.add("2");// 经济适用房
			list.add("3");// 回迁房
			list.add("4");// 房改房
			list.add("5");// 集资建房
		}
		/** 土地使用权类型 **/
		else if (name.equals("tdsyqlx")) {
			list.add("1");// 划拨使用权
			list.add("2");// 出让使用权
		}
		/** 住宅户型 **/
		else if (name.equals("zzhx")) {
			list.add("1");// 平层户型
			list.add("2");// 跃层户型
			list.add("3");// 错层户型
			list.add("4");// 复式户型
		}
		/** 配套设施 **/
		else if (name.equals("ptss")) {
			list.add("1");// 供水
			list.add("2");// 供电
			list.add("3");// 供热
			list.add("4");// 燃气
			list.add("5");// 通讯
			list.add("6");// 电视系统
			list.add("7");// 道路
			list.add("8");// 停车设施
			list.add("9");// 娱乐设施
			list.add("10");// 教育
			list.add("11");// 商业
			list.add("12");// 饮食
			list.add("13");// 其他
		}
		/** 再开发类型 **/
		else if (name.equals("zkflx")) {
			list.add("1");// 旧城镇
			list.add("2");// 旧村庄
			list.add("3");// 旧厂房
			list.add("4");// 其他
		}
		/** 逻辑是否 **/
		else if (name.equals("yesno")) {
			list.add("1");// 是
			list.add("0");// 否
		}
		return list;
	}

	public String initValue(ArrayList<String> list) {
		return list.get(0);
	}

}
