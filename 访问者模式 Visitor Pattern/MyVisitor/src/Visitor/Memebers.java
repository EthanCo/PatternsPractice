package Visitor;

import java.util.ArrayList;
import java.util.List;

public class Memebers {
	private List<Object> list = new ArrayList<Object>();
	//��ӳ�Ա
	public void add(Object obj){
		list.add(obj);
	}
	//�Ƴ���Ա
	public void remove(Object obj){
		list.remove(obj);
	}
	//��ȡ���г�Ա
	public List<Object> getList(){
		return list;
	}
}
