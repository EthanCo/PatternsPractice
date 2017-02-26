package Visitor;

import java.util.Iterator;
import java.util.List;

import domain.Memeber;

public class ComputerMemeber {
	private double total;
	public double getTotal(){
		return total;
	}
	public void account(List<?> list){
		Iterator<?> iterator=list.iterator();
		while(iterator.hasNext()){
			Object obj = iterator.next();
			Visitor visitor = new Visitor();
			System.out.println("该会员总价："+((Memeber)obj).accpt(visitor));
		}
	}
}
