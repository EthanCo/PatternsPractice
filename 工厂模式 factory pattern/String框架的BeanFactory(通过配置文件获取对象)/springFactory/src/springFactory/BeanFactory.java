package springFactory;

import java.util.Properties;

public class BeanFactory {
	public static void main(String[] args) throws Exception
	{
		Properties props = new Properties(); //properties用来读配置文件的
		/*
		站在java虚拟机的角度,每一个class的类load到内存之后,都会被当成class对象
		getClassLoader() 拿到装在那个类的类加载器
		getResourceAsStream 把里面的一个文件当成inputstream
		把spring.properties这个文件当成一个inputsream读取来之后,把他转后成为一个Properties对象
		转换成Properties对象之后,在配置文件里所写的信息将会以键值对的形式出现
		*/
		props.load(BeanFactory.class.getClassLoader().
				getResourceAsStream("springFactory/spring.properties"));//加载配置文件
		String VehicleTypeName = props.getProperty("VehicleType");
		System.out.println(VehicleTypeName); //说明已经读到VehicleType的值了
		/*
		反射
		把这个字符串所代表的那个类load到内存(Java的程序想要运行,首先会将class文件load到内存)
		产生这个类的对象需要newInstance();
		*/
		Object obj = Class.forName(VehicleTypeName).newInstance();
		dirveable d = (dirveable)obj;
		d.drive();
	}
}
