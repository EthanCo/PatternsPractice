package zhk;

/*
���ǹ�˾�Ǹ���Ժܿ��ɵĹ�˾��
�ڹ�˾����������ʱ��С��0.5�죬��ôֻ��Ҫ����Ŀ��������к���OK�ˡ�
���������0.5�죬���ǻ�С��2�죬��ô��Ҫȥ�����²�������Ȼ�����Ҫ�۹����ˡ�
���������2�죬�����Ҫȥ���ܾ����ˣ����ʵ�ȻҲ�����ˡ�
��ô������������˵��������̾��������ġ�
Ҳ��������һ�����̣�����Ҫ�����ֱ���ϼ�������Ŀ����ȥ�򽻵������տ�������Ŀ���������ʼ���
���������²�������ʼ���Ҳ�������ܾ��������ʼ����ڲ��Ĺ�����ʵӦ���Ǹ��ں��ӣ�
�㲢��֪���ڲ�����Ϣ����δ���ġ�����Ҫ�ҵ��ģ�ֻ������Ҫ��һ�������Ķ�����ѡ�
 * */

/*
 * �ɷ����뵽����ְ�����Ķ�������
��ϸ���뷨�����ģ��������̷����������Կ������������ģ�
1. ���*********�����Ծ��۴��֡�
2. ���*********����������ͽ��һ�굽ʮ�ꡣ
3. ���*********����������ͽ��ʮ�����ϡ�
4. ���*********����**********��
5. ������������Բ����㣬��*****************��

��ʵ���һ���ͽ������ɵĶ����������˷��ٺܴ�����ɲ���Ȩ����һ���̶���Ҳ�����˷�������귨�ɿ��ӵĿ����ԡ�
�����ǵ�ְ�����У���������������Ķ��������ô�û���������׽ڵ㿪ʼ���ʣ���ô�ͺܿ��ܳ����쳣�������
��������Ӧ��Ϊְ��������һ��Ĭ�ϵ����
�����Ļ����κ�һ������������η��ʣ����ܵõ�һ�������Ĵ���
 * */

/*
 * ����ְ������ʹ��
ְ����ģʽ�������ã�����ǳ����ױ����Ϊģʽ��ģʽ�ķ�����
�������ҹ��ɳ�����һЩ����ְ���������ʹ�ù���ֻ�Ǹ��˵��������ϣ�����ָ�̡�
1�� �������N��N��������һ��ĳ������Թ�ϵ����ô������ȫ�����ñ�������ȡ��ְ������
2�� ������Ҫ����ʲô������ͨ��ÿ������Ԫ��ͨ������̬�������ģ�������������ȡ���ڶ�������Ի���һЩ��������Ĳ��ԡ�
3�� �û������Ǵ���һ���ڵ���Ϊ��������ͷ�ڵ㣬�����û������Եõ�һ������ķ�����
4�� Ӧ�ֹֽ��飬����ͬ���Ĵ���ְ�����������ϸ�����¼��Ĵ��ݣ�����Ҳ����ͬ���Ĵ��ݣ�ְ����һ��������ͬ��֮�������ݡ�
 * */

//������
class Request {
	private int day;
	private String reson;

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getReson() {
		return reson;
	}

	public void setReson(String reson) {
		this.reson = reson;
	}

	public Request(int day, String reson) {
		super();
		this.day = day;
		this.reson = reson;
	}
}

/*
 * ����������������Ӧ�ߣ��������������ķ����� һ������Ӧ������һ����ѡ������ߡ�
 */

abstract class Boss {
	protected String name;// ����
	protected Boss successor;// ������

	public Boss(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boss getSuccessor() {
		return successor;
	}

	public void setSuccessor(Boss successor) {
		this.successor = successor;
	}

	public abstract boolean PassRequest(Request request);
}

// ǰ̨
class PM extends Boss {
	
	public PM(String name) {
		super(name);
	}

	@Override
	public boolean PassRequest(Request request) {
		if (request.getDay() <= 0.5) {
			return true;
		}
		return successor.PassRequest(request);
	}
}

// HR
class HR extends Boss {
	
	public HR(String name) {
		super(name);
	}

	@Override
	public boolean PassRequest(Request request) {
		if (request.getDay() > 0.5 && request.getDay() <= 2) {
			return true;
		}
		return successor.PassRequest(request);
	}
}

// Manager
class Manager extends Boss {
	
	public Manager(String name) {
		super(name);
	}

	@Override
	public boolean PassRequest(Request request) {
		int day = request.getDay();
		String reason = request.getReson();
		if(reason.equals("��������")){
			return true;
		}
		return false;
	}
}

public class Test {
	public static void main(String[] args) {
		//��ô���ǵ��õ�ʱ��ͺܼ��ˣ�
		Request request = new Request(3, "����������");
		Boss pm = new PM("pm");
		Boss hr = new HR("hr");
		Boss manager = new Manager("manager");
		pm.successor=hr;
		hr.successor=manager;
		boolean pass = pm.PassRequest(request);
		System.out.println(pass);
	}
}
