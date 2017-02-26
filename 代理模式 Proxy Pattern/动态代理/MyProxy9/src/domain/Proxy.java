package domain;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;
/*
 * ����ľ�������,�ɱ���������ָ��
 * */
public class Proxy {
	public static Object newProxyInstance(Class infce,InvocationHandler h) throws Exception { 
		String methodStr = "";
		String rt ="\r\n";
		
		Method[] methods = infce.getMethods();
		/*
		for(Method m : methods) {
			methodStr += "@Override" + rt + 
						 "public void " + m.getName() + "() {" + rt +
						 	"   long start = System.currentTimeMillis();" + rt +
							"   System.out.println(\"starttime:\" + start);" + rt +
							"   t." + m.getName() + "();" + rt +
							"   long end = System.currentTimeMillis();" + rt +
							"   System.out.println(\"time:\" + (end-start));" + rt +
						 "}";
		}
		*/
		for(Method m : methods) {
			methodStr += "@Override" + rt + 
						 "public void " + m.getName() + "() {" + rt +
						 "    try {" + rt +
						 "    Method md = " + infce.getName() + ".class.getMethod(\"" + m.getName() + "\");" + rt +
						 "    h.invoke(this, md);" + rt +
						 "    }catch(Exception e) {e.printStackTrace();}" + rt +
						
						 "}";
		}
		
//		String src =
//		"package newclass;"+rt+
//		"import domain.*;"+rt+
//		"public class TankTimeProxy implements "+infce.getName()+"{"+ rt + //��Ҫ������һ��
//		"	public TankTimeProxy(Moveable t) {"+ rt +
//		"		super();"+ rt +
//		"		this.t = t;"+ rt +
//		"	}"+ rt +
//			
//		"	Moveable t ;"+ rt +
//
//		methodStr+ rt +
//		"}";
		
		String src = 
				"package newclass;" +  rt +
				"import java.lang.reflect.Method;" + rt +
				"import domain.*;"+rt+
				"public class TankTimeProxy implements " + infce.getName() + "{" + rt +
				"    public TankTimeProxy (InvocationHandler h) {" + rt + //TankTimeProxy ��������ʲô���ֶ����Ե�,���ֲ���Ҫ,���ļ�·��ʲô����Ҫ�ĳ�һ����
				"        this.h = h;" + rt +
				"    }" + rt +
				"    domain.InvocationHandler h;" + rt +
				methodStr +
				"}";
		
		//�����ļ�Ŀ¼
		String fileName = System.getProperty("user.dir") //��ȡ��Ŀ��Ŀ¼
				+"/src/newclass/TankTimeProxy.java";
//		String fileName = 
//				"d:/src/newclass/TankTimeProxy.java"; //�ļ�·����ʵ�ǿ��Էŵ�����ط���,���ļ���Ҫ���Ƚ��û��ó���ȥ����
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
//		URL[] urls = new URL[] {new URL("file:/" + "d:/src/")};
		URLClassLoader ul = new URLClassLoader(urls); //�˴����ʺ�ֱ��ʹ��loader,����ָ��·��,loaderĬ������binĿ¼�µ�,����ǰ���fileName·����Ϊbin
		Class c = ul.loadClass("newclass.TankTimeProxy");

//		Constructor ctr = c.getConstructor(Moveable.class);//�õ�public TankTimeProxy(Moveable t)���췽��
		Constructor ctr = c.getConstructor(InvocationHandler.class);
//		Object m = ctr.newInstance(new Tank());
		Object m = ctr.newInstance(h);
		return m;
	}
}