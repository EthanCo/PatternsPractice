package Test;

import Visitor.ComputerMemeber;
import Visitor.Memebers;
import domain.EightAbateMemeber;
import domain.NineAbateMemeber;
import domain.NoAbateMemeber;
import domain.SevenAbateMemeber;
/*
 * ������ģʽ���ŵ�
�����񡡡��õ���չ��
�����ܹ��ڲ��޸Ķ���ṹ�е�Ԫ�ص�����£�Ϊ����ṹ�е�Ԫ������µĹ��ܡ�
�����񡡡��õĸ�����
��������ͨ����������������������ṹͨ�õĹ��ܣ��Ӷ���߸��ó̶ȡ�
�����񡡡������޹���Ϊ
��������ͨ���������������޹ص���Ϊ������ص���Ϊ��װ��һ�𣬹���һ�������ߣ�����ÿһ�������ߵĹ��ܶ��Ƚϵ�һ��
������ģʽ��ȱ��
�����񡡡�����ṹ�仯������
�����������ڶ���ṹ�е��ྭ���仯���������Ϊ����ṹ�����˸ı䣬�����ߵĽӿںͷ����ߵ�ʵ�ֶ�Ҫ������Ӧ�ĸı䣬����̫�ߡ�
�����񡡡��ƻ���װ
����������ģʽͨ����Ҫ����ṹ�����ڲ����ݸ������ߺ�ObjectStructrue�����ƻ��˶���ķ�װ�ԡ�
������ģʽ�����ó���
       ����һ�������д�����һЩ�뱾������ɣ����߹�ϵ�������Ĳ�����Ϊ�˱�����Щ������Ⱦ������������ʹ�÷�����ģʽ������Щ������װ����������ȥ��
       ����һ������У����������ƵĲ�����Ϊ�˱�����ִ����ظ��Ĵ��룬Ҳ���Խ���Щ�ظ��Ĳ�����װ����������ȥ��
       ���ǣ�������ģʽ��������ô��������Ҳ����������ȱ�ݣ������µ�Ԫ����Ƚ����ѡ�ͨ��������ģʽ�Ĵ�����Կ������ڷ��������У�ÿһ��Ԫ���඼������Ӧ�Ĵ�������Ҳ����˵��ÿ����һ��Ԫ���඼��Ҫ�޸ķ������ࣨҲ��������������������ʵ���ࣩ���޸������൱�鷳��Ҳ����˵����Ԫ������Ŀ��ȷ��������£�Ӧ�����÷�����ģʽ�����ԣ�������ģʽ�Ƚ������ڶ����й��ܵ��ع�������˵��һ����Ŀ�Ļ��������Ѿ�ȷ��������Ԫ����������Ѿ�����ȷ������������ˣ�����ֻ����ЩԪ���ڵ���ز�������ʱ�����ǿ���ʹ�÷�����ģʽ��ԭ�еĴ�������ع�һ�飬����һ�����Ϳ����ڲ��޸ĸ���Ԫ���������£���ԭ�й��ܽ����޸ġ�
 * */
public class Test {
	public static void main(String[] args){
		NoAbateMemeber noAbateMemeber = new NoAbateMemeber();
		NineAbateMemeber nineAbateMemeber = new NineAbateMemeber();
		EightAbateMemeber eightAbateMemeber = new EightAbateMemeber();
		SevenAbateMemeber sevenAbateMemeber = new SevenAbateMemeber();
		
		noAbateMemeber.setCount(10);
		noAbateMemeber.setPrivce(10);
		nineAbateMemeber.setCount(10);
		nineAbateMemeber.setPrivce(10);
		eightAbateMemeber.setCount(10);
		eightAbateMemeber.setPrivce(10);
		sevenAbateMemeber.setPrivce(10);
		sevenAbateMemeber.setCount(10);
		
		Memebers memebers = new Memebers();
		memebers.add(noAbateMemeber);
		memebers.add(nineAbateMemeber);
		memebers.add(eightAbateMemeber);
		memebers.add(sevenAbateMemeber);
		
		ComputerMemeber computerMemeber = new ComputerMemeber();
		computerMemeber.account(memebers.getList());
	}
}
