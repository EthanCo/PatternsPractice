/*
�������ģʽ:��һ�������ڴ���ֻ����һ������

��Ҫ��֤����Ψһ
1.Ϊ�˱�������������ཨ���������.�Ƚ�ֹ�����������������
2.��Ϊ��������������ʵ��������,ֻ���ڱ�����,�Զ���һ������.
3.Ϊ�˷�������������Զ������ķ���,���Զ����ṩһЩ���ʷ�ʽ.

���������ô��������
1.�����캯��˽�л�
2.�����д���һ���������
3.�ṩһ���������Ի�ȡ���ö���

�����������ô����,������ô����
����Ҫ��������Ķ���֤���ڴ���Ψһʱ,�ͽ����ϵ��������ϼ���.
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

	private Single(){} //��1��
	
	private static final Single s = new Single(); //�ڶ��� ����final���Ͻ�,����Ҳ����
	
	public static Single getInstance() //������ ֻ��һ������,ֻ��get����set
	{
		//���ø÷��� 1.���� 2.���� 
		//����û�ж����� ���������ñ���static Ȼ����Ϊ��̬��������Single����,����SingleҪstatic
		//(ֻ�к�����Ŀ��Է����ȳ�����)
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
		
		System.out.println(s2.getNum());// ������Ϊ23 ��Ϊֻ����һ������
	}
}