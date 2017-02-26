package Facade;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	public static Object getInstance() {
		Object obj = null;
		try {
			Properties p = new Properties();
			InputStream in = null;
			// path���ԡ�/'��ͷʱĬ���ǴӴ������ڵİ���ȡ��Դ���ԡ�/'��ͷ���Ǵ�ClassPath���»�ȡ
			in = Test.class.getResourceAsStream("class.properties");
			try {
				p.load(in);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			obj = Class.forName(p.getProperty("class")).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
