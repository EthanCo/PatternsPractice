package zhk;
//ע������Ķ�������ǲ��ɱ�ģ���Ȼһ����ȫ�䣨���������������⣩��
public class Test {
	//���Կ�������zhk.ChineseFont���ڴ��ַ��һ����
	public static void main(String[] args){
		FontFactory factory = FontFactory.getInstance();
		System.out.println(factory.Crete("ChineseFont"));
		System.out.println(factory.Crete("EnglishFont"));
		System.out.println(factory.Crete("ChineseFont"));
		System.out.println();
	}
}
