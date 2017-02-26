package iterator;

import iterator.Collection;

public class ArrayList implements Collection{
	private Object[] objects = new Object[10];
	private int index =0;
	public void add(Object o){
		if(index==objects.length){
			Object[] newObjects=new Object[objects.length*2]; //此处在实际中不合理，此处为了方便起见
			/*
			 * public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length) 
			 * src:源数组； srcPos:源数组要复制的起始位置； dest:目的数组； destPos:目的数组放置的起始位置； length:复制的长度。 
			 * 注意：src and dest都必须是同类型或者可以进行转换类型的数组．
			 * */
			System.arraycopy(objects, 0, newObjects, 0, objects.length);
			objects=newObjects;

		}
		objects[index]=o;
		index++;
	}
	
	public int size(){
		return index;
	}
	
	@Override
	public Iterator iterator(){
		//如果用单例模式甚至不用new，更好
		return new Iterator() {
			private int currentIndex=0;
			
			@Override
			public Object next() {
				Object o = objects[currentIndex];
				currentIndex++;
				return o;
			}
			
			@Override
			public boolean hasNext() {
				if(currentIndex>=index) return false;
				else return true;
			}
		};
	}
}
