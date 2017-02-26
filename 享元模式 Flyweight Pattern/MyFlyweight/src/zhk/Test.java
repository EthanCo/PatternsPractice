package zhk;
//注：共享的对象必须是不可变的，不然一变则全变（如果有这种需求除外）。
public class Test {
	//可以看到两个zhk.ChineseFont的内存地址是一样的
	public static void main(String[] args){
		FontFactory factory = FontFactory.getInstance();
		System.out.println(factory.Crete("ChineseFont"));
		System.out.println(factory.Crete("EnglishFont"));
		System.out.println(factory.Crete("ChineseFont"));
		System.out.println();
	}
}
