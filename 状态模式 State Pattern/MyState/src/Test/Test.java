package Test;
/*
 * ״̬ģʽ state
 * һ����Ķ���,�Ǹ����������ڲ�״̬�Ĳ�ͬ���в�ͬ�Ķ���
 * 
������һ�����������״̬�ı�ʱ����ı�����Ϊ����������������Ǹı������ࡣ
2. ���������
������Ҫ������ǵ�����һ������״̬ת�����������ʽ���ڸ���ʱ���������״̬���ж��߼�ת�Ƶ���ʾ��ͬ��һϵ���൱�У����԰Ѹ��ӵ��߼��жϼ򵥻���
3. ģʽ�еĽ�ɫ
����3.1 �����Ļ�����Context�����������˿ͻ�������Ҫ�Ľӿڲ�ά��һ������״̬��ɫ��ʵ��������״̬��صĲ���ί�и���ǰ��Concrete State����������
����3.2 ����״̬��State��������һ���ӿ��Է�װʹ�������Ļ����ĵ�һ���ض�״̬��ص���Ϊ��
����3.3 ����״̬��Concrete State����ʵ�ֳ���״̬����Ľӿڡ�
 * */

//����࣬��Ӧģʽ�е�Context��
class Light{
	private LightState state;

	public Light(LightState state) {
		this.state = state;
	}
	
	public LightState getState() {
		return state;
	}

	public void setState(LightState state) {
		this.state = state;
	}
	//���µ�ƿ���
	public void PressSwich(){
		state.PressSwich(this);
	}
}
//����ĵ��״̬�࣬�൱��State��
interface LightState{
	void PressSwich(Light light);
}
// ����״̬��, ��
class On implements LightState{
	//�ڿ�״̬�£����¿������л����ص�״̬��
	@Override
	public void PressSwich(Light light) {
		System.out.println("�ص�");
		light.setState(new Off());
	}
}  
//��
class Off implements LightState{
	//�ڹ�״̬�£����¿�����򿪵�ơ�
	@Override
	public void PressSwich(Light light) {
		System.out.println("����");
		light.setState(new On());
	}
}

public class Test {
	public static void main(String[] args){
		// ��ʼ����ƣ�ԭʼ״̬Ϊ��
		Light light = new Light(new Off());
		// ��һ�ΰ��¿��أ��򿪵��
		light.PressSwich();
		// �ڶ��ΰ��¿��أ��رյ��
		light.PressSwich();
	}
}
