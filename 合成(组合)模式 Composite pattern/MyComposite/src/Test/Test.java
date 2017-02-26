package Test;

import java.util.ArrayList;
import java.util.List;
/*
 * ��ȫģʽ
 * */
//�ϳ� �ӿ�
interface Component{
	public void copy();
}
//�ļ�
class File implements Component{

	private String name ;
	public File(String name){
		this.name = name;
	}
	
	@Override
	public void copy() {
		System.out.println("�����ļ�����,�ļ����ƣ�"+name);
	}
}
//�ļ���
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
		System.out.println("�����ļ��еĸ���,�ļ������ƣ�"+name);
		for (Component component : list) {
			component.copy();
		}
	}
}

public class Test {
	public static void main(String[] args){
		Folder folder1 = new Folder("�ļ���1");
		File file1 = new File("�ļ�1");
		Folder folder2 = new Folder("�ļ���2");
		File file2 = new File("�ļ�2");
		File file3 = new File("�ļ�3");
		//�˴����뻹���Խ�һ�����һ����һ��ְ������ʵ��
		folder1.add(file1);
		folder1.add(file2);
		folder1.add(folder2);
		folder2.add(file3);
		folder1.copy();
	}
}
