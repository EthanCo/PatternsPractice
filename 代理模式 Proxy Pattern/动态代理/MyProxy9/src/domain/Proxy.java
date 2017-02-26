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
 * 代理的具体内容,由别人来具体指定
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
//		"public class TankTimeProxy implements "+infce.getName()+"{"+ rt + //主要改了这一句
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
				"    public TankTimeProxy (InvocationHandler h) {" + rt + //TankTimeProxy 这个是随便什么名字都可以的,名字不重要,但文件路径什么都都要改成一样的
				"        this.h = h;" + rt +
				"    }" + rt +
				"    domain.InvocationHandler h;" + rt +
				methodStr +
				"}";
		
		//设置文件目录
		String fileName = System.getProperty("user.dir") //获取项目根目录
				+"/src/newclass/TankTimeProxy.java";
//		String fileName = 
//				"d:/src/newclass/TankTimeProxy.java"; //文件路径其实是可以放到任意地方的,但文件名要事先建好或用程序去生成
		File f = new File(fileName);
		FileWriter fw = new FileWriter(f); //写文件
		fw.write(src);
		fw.flush();
		fw.close();
		//编译
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler(); //拿到java默认编译器 JavaCompiler是JDK提供的类,只有6.0及以上支持
		StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);//获取文件管理者 1.诊断监听器(编译时有什么错误)
		Iterable units = fileMgr.getJavaFileObjects(fileName);//根据文件名拿到一系列的javaFile(此处只有一个文件)
		CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units); //设置编译任务(一次可以编译很多个文件,此处只有一个)
		t.call(); //进行编译
		fileMgr.close();
		//load 到 内存 ,并生成新对象 
		URL[] urls = new URL[]{new URL("file:/"+System.getProperty("user.dir")+"/src")};
//		URL[] urls = new URL[] {new URL("file:/" + "d:/src/")};
		URLClassLoader ul = new URLClassLoader(urls); //此处不适合直接使用loader,不能指定路径,loader默认是在bin目录下的,除非前面的fileName路径设为bin
		Class c = ul.loadClass("newclass.TankTimeProxy");

//		Constructor ctr = c.getConstructor(Moveable.class);//拿到public TankTimeProxy(Moveable t)构造方法
		Constructor ctr = c.getConstructor(InvocationHandler.class);
//		Object m = ctr.newInstance(new Tank());
		Object m = ctr.newInstance(h);
		return m;
	}
}