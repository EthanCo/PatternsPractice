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
			// path不以’/'开头时默认是从此类所在的包下取资源，以’/'开头则是从ClassPath根下获取
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
