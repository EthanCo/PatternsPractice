package zhk;

import iterator.ArrayList;
import iterator.Iterator;
import iterator.LinkedList;
import iterator.Collection;

public class Test {
	public static void main(String[] args){
		Collection c1 = new ArrayList();
		for(int i=0;i<15;i++){
			c1.add(new Cat(i+""));
		}
		System.out.println(c1.size());
		
		Collection c2 = new LinkedList();
		for(int i=0;i<21;i++){
			c2.add(new Cat(i+""));
		}
		System.out.println(c2.size());
		
		Iterator it1 = c1.iterator();
		while(it1.hasNext()){
			Object o = it1.next();
			System.out.println(o+"");
		}
		
		Iterator it2 = c2.iterator();
		while(it2.hasNext()){
			Object o = it2.next();
			System.out.println(o+"");
		}
	}
}
