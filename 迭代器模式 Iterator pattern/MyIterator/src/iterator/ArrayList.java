package iterator;

import iterator.Collection;

public class ArrayList implements Collection{
	private Object[] objects = new Object[10];
	private int index =0;
	public void add(Object o){
		if(index==objects.length){
			Object[] newObjects=new Object[objects.length*2]; //�˴���ʵ���в������˴�Ϊ�˷������
			/*
			 * public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length) 
			 * src:Դ���飻 srcPos:Դ����Ҫ���Ƶ���ʼλ�ã� dest:Ŀ�����飻 destPos:Ŀ��������õ���ʼλ�ã� length:���Ƶĳ��ȡ� 
			 * ע�⣺src and dest��������ͬ���ͻ��߿��Խ���ת�����͵����飮
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
		//����õ���ģʽ��������new������
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
