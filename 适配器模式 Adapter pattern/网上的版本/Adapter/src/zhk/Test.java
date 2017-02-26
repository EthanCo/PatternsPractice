package zhk;


    //����ͻ����ڴ��Ľӿڣ������Ǿ���Ļ������࣬Ҳ�����ǽӿ�
    class Target
    {
        public void Request()
        {
        	System.out.println("���ǿͻ����ڴ��Ľӿ�");
        }
    }

    //������Ҫ�������
    class Adaptee
    {
        public void SpecificRequest()
        {
        	System.out.println("������Ҫ�������");
        }
    }

    // ����������
    class Adapter extends Target
    {
        // ����һ��˽�е�Adeptee����
        private Adaptee adaptee = new Adaptee();

        //ͨ����д�������ϵ���Request()�����������ʵ�ʵ���SpecificRequest()
        @Override
        public void Request()
        {
            adaptee.SpecificRequest();
        }
    }
    public class Test {
    	public static void main(String[] args){
            // �Կͻ�����˵�����õľ���Target��Request()
            Target target = new Adapter();
            target.Request();


    	}
}
