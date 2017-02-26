package Test;

import java.util.ArrayList;
import java.util.List;
/*
 * ����ģʽ
 * �����а���ҵ��ʱ,ͨ��Ҫ�ȵ�ȡ�Ż�����ȡ��,Ȼ����Ӧ�Ĵ��ڰ���ҵ��,�����ȡ�Ż����Ǿ���ĳ������ִ��ָ���������
 * ʾ����������VIP���ں���ͨ����,���ݿͻ������������Ⱥ�,ִ����Ӧ�Ĳ���
 * ԭ������ģʽ���ǰ�һ��������߲�����װ��һ�������С�����ģʽ����ϵͳʹ�ò�ͬ������ѿͻ��˲�����,
 * �������Ŷӻ��߼�¼������־,�����ṩ����ĳ����ͻָ�����
 * */
 /*
	����ģʽ���û�ʵ���趨�õ����������,Ȼ����ָ����ʱ���ﰴ��һ����˳������ȡ��ִ��
	��ʵ��Ӧ����,����ģʽ����������ģʽ���Ժܺõؽ������,�����û�������,
	����ͨ������ģʽ���д洢,Ȼ��ͨ��������ģʽ,�ٽ������һ����˳��ִ��
 */
//����ӿ�
interface Command{
	public void execute();//ִ��
}

//������ͨ����
class CommonWindow implements Command{

	@Override
	public void execute() {
		System.out.println("��ͨ����,������ͨҵ��");
	}
}

//����VIP����
class VIPWindow implements Command{

	@Override
	public void execute() {
		System.out.println("VIP����,����VIPҵ��");
	}
}

//ȡ�Ż�
class Lotto{
	List< Command> list = new ArrayList<Command>();
	public void doCommand(){
		for (Command command : list) {
			command.execute();
		}
	}
	//�������
	void addCommand(Command command){
		list.add(command);
	}
}

public class Test {
	public static void main(String[] args){
		Lotto lotto = new Lotto();
		lotto.addCommand(new CommonWindow());
		lotto.addCommand(new VIPWindow());
		lotto.doCommand();
	}
}
