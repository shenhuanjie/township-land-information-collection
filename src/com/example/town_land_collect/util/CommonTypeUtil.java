/**
 * 
 */
package com.example.town_land_collect.util;

import java.util.ArrayList;

/**
 * @Title commonTypeUtil.java
 * @Package com.example.town_land_collect.util
 * @Description TODO(��һ�仰�������ļ���ʲô)
 * @author Shen.dev
 * @date 2015-10-16 ����10:17:15
 * @version V1.0
 */
public class CommonTypeUtil {

	/**
	 * ˵����TODO(������һ�仰�����������������)
	 * 
	 * @param name
	 * @return
	 * @return ArrayList<String>
	 */
	public ArrayList<String> initList(String name) {
		ArrayList<String> list = new ArrayList<String>();
		/** ����ʹ��Ȩ���÷�ʽ **/
		if (name.equals("tdsyqcrfs")) {
			list.add("01");// �б�
			list.add("02");// ����
			list.add("03");// ����
			list.add("04");// Э��
		}
		/** Ȩ������ **/
		else if (name.equals("qsxz")) {
			list.add("10");// ������������Ȩ
			list.add("20");// ��������ʹ��Ȩ
			list.add("30");// ������������Ȩ
			list.add("40");// ��������ʹ��Ȩ
			list.add("31");// ����С��
			list.add("32");// �弯�徭����֯
			list.add("33");// �缯�徭����֯
			list.add("34");// ����ũ���徭����֯
		}
		/** ���ݽṹ **/
		else if (name.equals("fwjg")) {
			list.add("1");// �ֽṹ
			list.add("2");// �֡��ֽ�������ṹ
			list.add("3");// �ֽ�������ṹ
			list.add("4");// ��Ͻṹ
			list.add("5");// שľ�ṹ
			list.add("6");// ���׷�
			list.add("9");// �����ṹ
		}
		/** ������; **/
		else if (name.equals("tdyt")) {
			list.add("00");// �ۺ��õ�
			list.add("05");// �̷��õ�
			list.add("06");// ��ҵ�õ�
			list.add("07");// סլ�õ�
			list.add("08");// ��������������õ�
			list.add("99");// �����õ�
		}
		/** ת�÷�ʽ **/
		else if (name.equals("zrfs")) {
			list.add("1");// ����
			list.add("2");// ����
			list.add("3");// ���۳������
			list.add("4");// ����
			list.add("5");// ��Ӫ
			list.add("6");// �̳�
			list.add("7");// ����
		}
		/** �����⿪��ˮƽ **/
		else if (name.equals("hxwkfsp")) {
			list.add("3");// ��ͨ
			list.add("4");// ��ͨ
			list.add("5");// ��ͨ
			list.add("6");// ��ͨ
			list.add("7");// ��ͨ
			list.add("8");// ��ͨ
			list.add("9");// ��ͨ
		}
		/** �����ڿ���ˮƽ **/
		else if (name.equals("hxnkfsp")) {
			list.add("3");// ��ͨһƽ
			list.add("4");// ��ͨһƽ
			list.add("5");// ��ͨһƽ
			list.add("6");// ��ͨһƽ
			list.add("7");// ��ͨһƽ
			list.add("8");// ��ͨһƽ
			list.add("9");// ��ͨһƽ
		}
		/** �趨����ˮƽ **/
		else if (name.equals("sdkfsp")) {
			list.add("3");// ��ͨһƽ
			list.add("4");// ��ͨһƽ
			list.add("5");// ��ͨһƽ
			list.add("6");// ��ͨһƽ
			list.add("7");// ��ͨһƽ
			list.add("8");// ��ͨһƽ
			list.add("9");// ��ͨһƽ
		}
		/** �������� **/
		else if (name.equals("jzlx")) {
			list.add("111");// ��ͨ���
			list.add("112");// ���ݶ��
			list.add("113");// С�߲�
			list.add("114");// �߲�
			list.add("115");// ����
			list.add("116");// ƽ��
			list.add("121");// ����
			list.add("122");// ˫ƴ
			list.add("123");// ����
			list.add("211");// ����
			list.add("212");// �칫
			list.add("213");// �ۺ�
			list.add("221");// �ֽṹ�������ֿ�
			list.add("222");// �����������ֿ�
		}
		/** �ٿ����ʽ���Դ **/
		else if (name.equals("zkfzjly")) {
			list.add("1");// ���س��ý�
			list.add("2");// ����ר���ʽ�
			list.add("3");// ���������ʽ�
			list.add("4");// ������Ͷ��
			list.add("5");// ����Ȩ����Ͷ��
			list.add("6");// ��������ʽ�
			list.add("7");// �����ʽ�
		}
		/** �ٿ���ģʽ **/
		else if (name.equals("zkfms")) {
			list.add("1");// ���п���
			list.add("2");// �������
			list.add("3");// ��������
			list.add("4");// �г������չ�
			list.add("5");// �����մ�
			list.add("6");// �����ҹ�
			list.add("7");// ��������
			list.add("99");// ����
		}
		/** ���ع�Ӧ��ʽ **/
		else if (name.equals("tdgyfs")) {
			list.add("1");// ����
			list.add("2");// ���Ĺҳ���
			list.add("21");// �б����
			list.add("22");// ��������
			list.add("23");// ���Ƴ���
			list.add("3");// Э�����
			list.add("4");// ����
			list.add("5");// ���۳��ʻ����
			list.add("6");// ��Ȩ��Ӫ
		}
		/** ���ݳ��¶� **/
		else if (name.equals("fwcxd")) {
			list.add("01");// ʮ���š��˳�
			list.add("02");// �ߡ�����
			list.add("03");// �塢�ĳ�
			list.add("04");// ��������
		}
		/** װ�޳̶� **/
		else if (name.equals("zxcd")) {
			list.add("01");// ë����
			list.add("02");// ��װ��
			list.add("03");// ȫװ��
			list.add("04");// ��װ��
		}
		/** ����/������; **/
		else if (name.equals("ytlx")) {
			list.add("01");// סլ
			list.add("02");// ��ҵ
			list.add("03");// �ִ�
			list.add("04");// ��ҵ
			list.add("05");// ���ڡ���Ϣ
			list.add("06");// ������;
		}
		/** ���ؼ��� **/
		else if (name.equals("tdjb")) {
			list.add("1");// һ��
			list.add("2");// ����
			list.add("3");// ����
			list.add("4");// �ļ�
			list.add("5");// �弶
			list.add("6");// ����
			list.add("7");// �߼�
			list.add("8");// �˼�
			list.add("9");// �ż�
			list.add("10");// ʮ��
			list.add("11");// ʮһ��
			list.add("12");// ʮ����
			list.add("13");// ʮ����
			list.add("14");// ʮ�ļ�
			list.add("15");// ʮ�弶
			list.add("16");// ʮ����
			list.add("17");// ʮ�߼�
			list.add("18");// ʮ�˼�
			list.add("0");// δ��������
		}
		/** Ͷ���������� **/
		else if (name.equals("tzztxz")) {
			list.add("1");// ������ҵ
			list.add("11");// ������ҵ
			list.add("12");// ������ҵ
			list.add("13");// �ɷݺ�����ҵ
			list.add("14");// ��Ӫ��ҵ
			list.add("141");// ������Ӫ��ҵ
			list.add("142");// ������Ӫ��ҵ
			list.add("143");// �����뼯����Ӫ��ҵ
			list.add("149");// ������Ӫ��ҵ
			list.add("15");// �������ι�˾
			list.add("151");// ���ж��ʹ�˾
			list.add("159");// �����������ι�˾
			list.add("16");// �ɷ����޹�˾
			list.add("17");// ˽Ӫ��ҵ
			list.add("171");// ˽Ӫ������ҵ
			list.add("172");// ˽Ӫ�ϻ���ҵ
			list.add("173");// ˽Ӫ�������ι�˾
			list.add("174");// ˽Ӫ�ɷ����޹�˾
			list.add("19");// ����������ҵ
			list.add("2");// �ۡ��ġ�̨��Ͷ����ҵ
			list.add("21");// ���ʾ�Ӫ��ҵ
			list.add("22");// ������Ӫ��ҵ
			list.add("23");// �ۡ��ġ�̨�̶�����ҵ
			list.add("24");// �ۡ��ġ�̨��Ͷ�ʹɷ����޹�˾
			list.add("3");// ����Ͷ����ҵ
			list.add("31");// ������ʾ�Ӫ��ҵ
			list.add("32");// ���������Ӫ��ҵ
			list.add("33");// ���ʣ����ʣ���ҵ
			list.add("34");// ����Ͷ�ʹɷ����޹�˾
			list.add("4");// ��������
			list.add("5");// ��ҵ��λ
			list.add("6");// ����(������ί��)
			list.add("7");// ����
		}
		/** ��ҵ���� **/
		else if (name.equals("cylx")) {
			list.add("A");// ũ���֡�������ҵ
			list.add("A01");// ũҵ
			list.add("A02");// ��ҵ
			list.add("A03");// ����ҵ
			list.add("A04");// ��ҵ
			list.add("A05");// ũ���֡����������ҵ

			list.add("B");// �ɿ�ҵ
			list.add("B06");// ú̿���ɺ�ϴѡҵ
			list.add("B07");// ʯ�ͺ���Ȼ������ҵ
			list.add("B08");// ��ɫ�������ѡҵ
			list.add("B0810");// �����ѡ
			list.add("B0890");// ������ɫ�������ѡ
			list.add("B0899");// ����
			list.add("B09");// ��ɫ�������ѡҵ
			list.add("B0911");// ͭ���ѡ
			list.add("B0912");// �����ѡ
			list.add("B0919");// ����
			list.add("B10");// �ǽ������ѡҵ
			list.add("B1011");// ʯ��ʯ��ʯ�࿪��
			list.add("B1012");// ճ����������ɰʯ����
			list.add("B1019");// ����
			list.add("B11");// �����ɿ�ҵ

			list.add("C");// ����ҵ
			list.add("C13");// ũ��ʳƷ�ӹ�ҵ
			list.add("C14");// ʳƷ����ҵ
			list.add("C15");// ��������ҵ
			list.add("C16");// �̲���Ʒҵ
			list.add("C17");// ��֯ҵ
			list.add("C171");// �ޡ����˷�֯��ӡȾ���ӹ�
			list.add("C179");// ����
			list.add("C18");// ��֯��װ��Ь��ñ����ҵ
			list.add("C19");// Ƥ�ëƤ����ë���ޣ���������ҵ
			list.add("C20");// ľ�ļӹ���ľ�����١��ء�����Ʒҵ
			list.add("C21");// �Ҿ�����ҵ
			list.add("C22");// ��ֽ��ֽ��Ʒҵ
			list.add("C23");// ӡˢҵ�ͼ�¼ý��ĸ���
			list.add("C24");// �Ľ�������Ʒ����ҵ
			list.add("C25");// ʯ�ͼӹ�����������ȼ�ϼӹ�ҵ
			list.add("C26");// ��ѧԭ�ϼ���ѧ��Ʒ����ҵ
			list.add("C27");// ҽҩ����ҵ
			list.add("C28");// ��ѧ��ά����ҵ
			list.add("C29");// ����Ʒҵ
			list.add("C30");// ������Ʒҵ
			list.add("C31");// �ǽ���������Ʒҵ
			list.add("C311");// ˮ�ࡢʯ�Һ�ʯ�������
			list.add("C312");// ˮ�༰ʯ����Ʒ����
			list.add("C313");// ש�ߡ�ʯ�ļ�����������������
			list.add("C319");// ����
			list.add("C32");// ��ɫ����ұ����ѹ�Ӽӹ�ҵ
			list.add("C321");// ����
			list.add("C323");// ����
			list.add("C323");// ��ѹ�Ӽӹ�
			list.add("C324");// ���Ͻ�ұ��
			list.add("C33");// ��ɫ����ұ����ѹ�Ӽӹ�ҵ
			list.add("C3311");// ͭұ��
			list.add("C3316");// ��ұ��
			list.add("C3319");// ����
			list.add("C34");// ������Ʒҵ
			list.add("C35");// ͨ���豸����ҵ
			list.add("C36");// ר���豸����ҵ
			list.add("C37");// ��ͨ�����豸����ҵ
			list.add("C371");// ��·�����豸����
			list.add("C372");// ��������
			list.add("C373");// Ħ�г�����
			list.add("C374");// ���г�����
			list.add("C375");// ����������װ������
			list.add("C379");// ����
			list.add(" C39");// ������е����������ҵ
			list.add("C3951");// �����������������
			list.add("C3952");// ���ÿ�������������
			list.add("C3959");// ����
			list.add("C40");// ͨѶ�豸������������������豸����ҵ
			list.add("C41");// �����Ǳ��Ļ����칫�û�е����ҵ
			list.add("C42");// ����Ʒ����������ҵ
			list.add("C43");// ������Դ�ͷϾɲ��ϻ��ռӹ�ҵ

			list.add("D");// ������ȼ����ˮ�������͹�Ӧҵ
			list.add("D44");// �����������������͹�Ӧҵ
			list.add("D4411");// ��������
			list.add("D4412");// ˮ������
			list.add("D4413");// ��������
			list.add("D4419");// ����
			list.add("D45");// ȼ�������͹�Ӧҵ
			list.add("D46");// ˮ�������͹�Ӧҵ

			list.add("E");// ����ҵ
			list.add("E47");// ���ݺ���ľ����ҵ
			list.add("E48");// ������װҵ
			list.add("E49");// ����װ��ҵ
			list.add("E50");// ��������ҵ
			list.add("E501");// ����׼��
			list.add("E509");// ����

			list.add("F");// ��ͨ���䡢�ִ�������ҵ
			list.add("F51");// ��·����ҵ
			list.add("F52");// ��·����ҵ
			list.add("F53");// ���й�����ͨҵ
			list.add("F54");// ˮ������ҵ
			list.add("F55");// ��������ҵ
			list.add("F56");// �ܵ�����ҵ
			list.add("F57");// װж���˺������������ҵ
			list.add("F58");// �ִ�ҵ
			list.add("F59");// ����ҵ

			list.add("G");// ��Ϣ���䡢�������������ҵ
			list.add("G60");// ���ź�������Ϣ�������ҵ
			list.add("G61");// ���������ҵ
			list.add("G62");// ���ҵ

			list.add("H");// ����������ҵ
			list.add("H63");// ����ҵ
			list.add("H65");// ����ҵ

			list.add("I");// ס�޺Ͳ���ҵ
			list.add("I66");// ס��ҵ
			list.add("I74");// ����ҵ

			list.add("J");// ����ҵ
			list.add("J68");// ����ҵ
			list.add("J69");// ֤ȯҵ
			list.add("J70");// ����ҵ
			list.add("J71");// �������ڷ���

			list.add("K");// ���ز�ҵ
			list.add("K72");// ���ز�ҵ

			list.add("L");// ���޺��������ҵ
			list.add("L73");// ����ҵ
			list.add("L74");// �������ҵ

			list.add("M");// ��ѧ�о�����������͵��ʿ���ҵ
			list.add("M75");// �о������鷢չ
			list.add("M76");// רҵ��������ҵ
			list.add("M77");// �Ƽ��������ƹ����ҵ
			list.add("M78");// ���ʿ���ҵ

			list.add("N");// ˮ���������͹�����ʩ����ҵ
			list.add("N79");// ˮ������ҵ
			list.add("N80");// ��������ҵ
			list.add("N81");// ������ʩ����ҵ

			list.add("O");// ����������������ҵ
			list.add("O82");// �������ҵ
			list.add("O83");// ��������ҵ
			list.add("P");// ����
			list.add("P84");// ����ҵ
			list.add("Q");// ��������ᱣ�Ϻ���ḣ��ҵ
			list.add("Q85");// ����
			list.add("Q86");// ��ᱣ��ҵ
			list.add("Q87");// ��ḣ��ҵ
			list.add("R");// �Ļ�������������ҵ
			list.add("R88");// ���ų���ҵ
			list.add("R89");// �㲥�����ӡ���Ӱ������ҵ
			list.add("R90");// �Ļ�����ҵ
			list.add("R91");// ����
			list.add("R92");// ����ҵ
			list.add("S");// ��������������֯
			list.add("S93");// �й�����������
			list.add("S94");// ���һ���
			list.add("S95");// ������Э����������
			list.add("S96");// Ⱥ�����塢���������ڽ���֯
			list.add("S97");// ����Ⱥ��������֯
			list.add("T");// ������֯
			list.add("T98");// ������֯
		}
		/** ��Ȩ���� **/
		else if (name.equals("cqxz")) {
			list.add("1");// ��Ʒ��
			list.add("2");// �������÷�
			list.add("3");// ��Ǩ��
			list.add("4");// ���ķ�
			list.add("5");// ���ʽ���
		}
		/** ����ʹ��Ȩ���� **/
		else if (name.equals("tdsyqlx")) {
			list.add("1");// ����ʹ��Ȩ
			list.add("2");// ����ʹ��Ȩ
		}
		/** סլ���� **/
		else if (name.equals("zzhx")) {
			list.add("1");// ƽ�㻧��
			list.add("2");// Ծ�㻧��
			list.add("3");// ��㻧��
			list.add("4");// ��ʽ����
		}
		/** ������ʩ **/
		else if (name.equals("ptss")) {
			list.add("1");// ��ˮ
			list.add("2");// ����
			list.add("3");// ����
			list.add("4");// ȼ��
			list.add("5");// ͨѶ
			list.add("6");// ����ϵͳ
			list.add("7");// ��·
			list.add("8");// ͣ����ʩ
			list.add("9");// ������ʩ
			list.add("10");// ����
			list.add("11");// ��ҵ
			list.add("12");// ��ʳ
			list.add("13");// ����
		}
		/** �ٿ������� **/
		else if (name.equals("zkflx")) {
			list.add("1");// �ɳ���
			list.add("2");// �ɴ�ׯ
			list.add("3");// �ɳ���
			list.add("4");// ����
		}
		/** �߼��Ƿ� **/
		else if (name.equals("yesno")) {
			list.add("1");// ��
			list.add("0");// ��
		}
		return list;
	}

	public String initValue(ArrayList<String> list) {
		return list.get(0);
	}

}
