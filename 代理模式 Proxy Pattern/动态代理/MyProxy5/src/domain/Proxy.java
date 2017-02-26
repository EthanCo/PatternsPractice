package domain;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;

public class Proxy {
	public static Object newProxyInstance(Class infce) throws Exception { 
		String rt ="\r\n";
		String src =
		"package newclass;"+rt+
		"import domain.*;"+rt+
		"public class TankTimeProxy implements "+infce.getName()+"{"+ rt + //��Ҫ������һ��
		"	public TankTimeProxy(Moveable t) {"+ rt +
		"		super();"+ rt +
		"		this.t = t;"+ rt +
		"	}"+ rt +
			
		"	Moveable t ;"+ rt +

		"	@Override"+ rt +
		"	public void move() {"+ rt +
		"		long start = System.currentTimeMillis();"+ rt +
		"		System.out.println(\"��ʼʱ�䣺\"+start);"+ rt +
		"		t.move();"+ rt +
		"		long end = System.currentTimeMillis();"+ rt +
		"		System.out.println(\"����ʱ�䣺\"+(end-start));"+ rt +
		"	}"+ rt +
		"}";
		
		//�����ļ�Ŀ¼
		String fileName = System.getProperty("user.dir") //��ȡ��Ŀ��Ŀ¼
				+"/src/newclass/TankTimeProxy.java";
		File f = new File(fileName);
		FileWriter fw = new FileWriter(f); //д�ļ�
		fw.write(src);
		fw.flush();
		fw.close();
		//����
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler(); //�õ�javaĬ�ϱ����� JavaCompiler��JDK�ṩ����,ֻ��6.0������֧��
		StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);//��ȡ�ļ������� 1.��ϼ�����(����ʱ��ʲô����)
		Iterable units = fileMgr.getJavaFileObjects(fileName);//�����ļ����õ�һϵ�е�javaFile(�˴�ֻ��һ���ļ�)
		CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units); //���ñ�������(һ�ο��Ա���ܶ���ļ�,�˴�ֻ��һ��)
		t.call(); //���б���
		fileMgr.close();
		//load �� �ڴ� ,�������¶��� 
		URL[] urls = new URL[]{new URL("file:/"+System.getProperty("user.dir")+"/src")};
		URLClassLoader ul = new URLClassLoader(urls); //�˴����ʺ�ֱ��ʹ��loader,����ָ��·��,loaderĬ������binĿ¼�µ�,����ǰ���fileName·����Ϊbin
		Class c = ul.loadClass("newclass.TankTimeProxy");

		Constructor ctr = c.getConstructor(Moveable.class);//�õ�public TankTimeProxy(Moveable t)���췽��
		Moveable m = (Moveable)ctr.newInstance(new Tank());
//		m.move();
		return m;
	}
}