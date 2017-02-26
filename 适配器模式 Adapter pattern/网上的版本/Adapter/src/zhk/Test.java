package zhk;


    //定义客户端期待的接口，可以是具体的或抽象的类，也可以是接口
    class Target
    {
        public void Request()
        {
        	System.out.println("这是客户端期待的接口");
        }
    }

    //定义需要适配的类
    class Adaptee
    {
        public void SpecificRequest()
        {
        	System.out.println("这是需要适配的类");
        }
    }

    // 定义适配器
    class Adapter extends Target
    {
        // 建立一个私有的Adeptee对象
        private Adaptee adaptee = new Adaptee();

        //通过重写，表面上调用Request()方法，变成了实际调用SpecificRequest()
        @Override
        public void Request()
        {
            adaptee.SpecificRequest();
        }
    }
    public class Test {
    	public static void main(String[] args){
            // 对客户端来说，调用的就是Target的Request()
            Target target = new Adapter();
            target.Request();


    	}
}
