package Visitor;

import java.util.ArrayList;
import java.util.List;

public class Memebers {
	private List<Object> list = new ArrayList<Object>();
	//添加成员
	public void add(Object obj){
		list.add(obj);
	}
	//移除成员
	public void remove(Object obj){
		list.remove(obj);
	}
	//获取所有成员
	public List<Object> getList(){
		return list;
	}
}
