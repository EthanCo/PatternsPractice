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

	/*
	������ȳ�ʼ������ ��������ʽ ����һ������� (��Ϊ��ȫ�ͼ�)
	Single��һ���ڴ�,���Ѿ��������˶���
	private Single(){} //��1��
	
	private static Single s = new Single(); //�ڶ���
	
	public static Single getInstance() //������ ֻ��һ������,ֻ��get����set
	{
		//���ø÷��� 1.���� 2.���� 
		//����û�ж����� ���������ñ���static Ȼ����Ϊ��̬��������Single����,����SingleҪstatic
		//(ֻ�к�����Ŀ��Է����ȳ�����)
		return s;
	}
	*/
	
	//����������ʱ�ų�ʼ��(Ҳ����������ӳټ���) ��Ϊ����ʽ ��Ϊ���˷���ʱ���ܳ������� ����Ҫ��synchronized ������Ч�ʾͱ���� ����Ҫ˫���ж�
	//Single����ڴ�,����û�д���,ֻ�е�����getInstance����ʱ,�Ž�������
	/*
	private Single(){}
	
	private static Single s = null;
	
	public static Single getInstance()
	{
		if(s == null)			//������ֻ�ᴴ��һ��
			s = new Single();
		return s;
	}
	*/
	private Single(){}
	
	private static Single s = null;
	
	public static Single getInstance()
	{
		if(s==null)
		{
			synchronized(Single.class)
			{
				if(s==null)
					s = new Single();
			}
		}
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