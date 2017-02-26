package Test;

import java.util.ArrayList;
import java.util.List;
/*
 * 安全模式
 * */
//合成 接口
interface Component{
	public void copy();
}
//文件
class File implements Component{

	private String name ;
	public File(String name){
		this.name = name;
	}
	
	@Override
	public void copy() {
		System.out.println("进行文件复制,文件名称："+name);
	}
}
//文件夹
class Folder implements Component{
	private String name;
	private List<Component> list = new ArrayList<Component>();
	public Folder(String name){
		this.name = name;
	}
	public void add(Component component){
		list.add(component);
	}
	public void remove(Component component){
		list.remove(component);
	}
	public int getCount(){
		return list.size();
	}
	@Override
	public void copy() {
		System.out.println("进行文件夹的复制,文件夹名称："+name);
		for (Component component : list) {
			component.copy();
		}
	}
}

public class Test {
	public static void main(String[] args){
		Folder folder1 = new Folder("文件夹1");
		File file1 = new File("文件1");
		Folder folder2 = new Folder("文件夹2");
		File file2 = new File("文件2");
		File file3 = new File("文件3");
		//此处代码还可以进一步抽出一个单一的职责类来实现
		folder1.add(file1);
		folder1.add(file2);
		folder1.add(folder2);
		folder2.add(file3);
		folder1.copy();
	}
}
