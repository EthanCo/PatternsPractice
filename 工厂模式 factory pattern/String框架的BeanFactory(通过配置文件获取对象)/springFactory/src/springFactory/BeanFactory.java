package springFactory;

import java.util.Properties;

public class BeanFactory {
	public static void main(String[] args) throws Exception
	{
		Properties props = new Properties(); //properties�����������ļ���
		/*
		վ��java������ĽǶ�,ÿһ��class����load���ڴ�֮��,���ᱻ����class����
		getClassLoader() �õ�װ���Ǹ�����������
		getResourceAsStream �������һ���ļ�����inputstream
		��spring.properties����ļ�����һ��inputsream��ȡ��֮��,����ת���Ϊһ��Properties����
		ת����Properties����֮��,�������ļ�����д����Ϣ�����Լ�ֵ�Ե���ʽ����
		*/
		props.load(BeanFactory.class.getClassLoader().
				getResourceAsStream("springFactory/spring.properties"));//���������ļ�
		String VehicleTypeName = props.getProperty("VehicleType");
		System.out.println(VehicleTypeName); //˵���Ѿ�����VehicleType��ֵ��
		/*
		����
		������ַ�����������Ǹ���load���ڴ�(Java�ĳ�����Ҫ����,���ȻὫclass�ļ�load���ڴ�)
		���������Ķ�����ҪnewInstance();
		*/
		Object obj = Class.forName(VehicleTypeName).newInstance();
		dirveable d = (dirveable)obj;
		d.drive();
	}
}
