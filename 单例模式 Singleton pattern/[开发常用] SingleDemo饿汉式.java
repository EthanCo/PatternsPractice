/*
单例设计模式:让一个类在内存中只存在一个对象

想要保证对象唯一
1.为了避免其他程序过多建立该类对象.先禁止其他程序建立该类对象
2.还为了让其他程序访问到该类对象,只好在本类中,自定义一个对象.
3.为了方便其他程序对自定义对象的访问,可以对外提供一些访问方式.

上面三步用代码的体现
1.将构造函数私有化
2.在类中创建一个本类对象
3.提供一个方法可以获取到该对象

对于事物该怎么描述,还是怎么描述
当需要将该事物的对象保证在内存中唯一时,就将以上的三步加上即可.
*/
class Single
{
	private int num;
	public void setNum(int num)
	{
		this.num=num;
	}
	public int getNum()
	{
		return num;
	}

	private Single(){} //第1步
	
	private static final Single s = new Single(); //第二步 加上final更严谨,不加也可以
	
	public static Single getInstance() //第三步 只有一个对象,只需get不用set
	{
		//调用该方法 1.对象 2.类名 
		//现在没有对象了 用类名调用必须static 然后因为静态变量调用Single变量,所有Single要static
		//(只有后出生的可以访问先出生的)
		return s;
	}
}

class SingleDemo
{
	public static void main(String[] args)
	{
		Single s1 = Single.getInstance();
		Single s2 = Single.getInstance();
		
		s1.setNum(23);
		
		System.out.println(s2.getNum());// 输出结果为23 因为只会有一个对象
	}
}