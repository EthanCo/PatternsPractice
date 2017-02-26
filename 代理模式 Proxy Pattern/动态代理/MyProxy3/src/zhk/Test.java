package zhk;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import domain.*;
/*
 * 只要是实现了Moveable接口的都可以用,都可以实现代理
 * 动态代理,不需要TankTimeProxy等类了
 * 比如Time计时可以动态代理给Moveable接口
 * 
 * 问题：实际测试中发现,在 设置文件目录 后 要refresh 一下项目 此程序才能执行
 * */
public class Test {
	public static void main(String[] args) throws Exception{
		
//		System.out.println("------ 先打印日志再统计时间 ------");
//		TankTimeProxy ttp = new TankTimeProxy(new Tank());
//		TankLogProxy tlp = new TankLogProxy(ttp);
//		tlp.move();
//		
//		System.out.println("------ 先统计时间再打印日志 ------");
//		TankLogProxy tlp2 = new TankLogProxy(new Tank());
//		TankTimeProxy ttp2 = new TankTimeProxy(tlp2);
//		ttp2.move();
		String rt ="\r\n";
		String src =
		"package newclass;"+rt+
		"import domain.*;"+rt+
		"public class TankTimeProxy implements Moveable{"+ rt +
		"	public TankTimeProxy(Moveable t) {"+ rt +
		"		super();"+ rt +
		"		this.t = t;"+ rt +
		"	}"+ rt +
			
		"	Moveable t ;"+ rt +

		"	@Override"+ rt +
		"	public void move() {"+ rt +
		"		long start = System.currentTimeMillis();"+ rt +
		"		System.out.println(\"开始时间：\"+start);"+ rt +
		"		t.move();"+ rt +
		"		long end = System.currentTimeMillis();"+ rt +
		"		System.out.println(\"运行时间：\"+(end-start));"+ rt +
		"	}"+ rt +
		"}";
		
		//设置文件目录
		String fileName = System.getProperty("user.dir") //获取项目根目录
				+"/src/newclass/TankTimeProxy.java";
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
		URLClassLoader ul = new URLClassLoader(urls); //此处不适合直接使用loader,不能指定路径,loader默认是在bin目录下的,除非前面的fileName路径设为bin
		Class c = ul.loadClass("newclass.TankTimeProxy");

		Constructor ctr = c.getConstructor(Moveable.class);//拿到public TankTimeProxy(Moveable t)构造方法
		Moveable m = (Moveable)ctr.newInstance(new Tank());
		m.move();
	}
}
