package zhk;

public class Cat implements Comparable {
	private int height;
	private int width;
	
	public Cat(int height, int width) {
		super();
		this.height = height;
		this.width = width;
	}
	
	@Override
	public String toString() {
		return "Cat [height=" + height + ", width=" + width + "]";
	}

	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof Cat){
			Cat c = (Cat)o;
			if(this.height>c.height){
				return 1;
			}else if(this.height<c.height){
				return -1;
			}
			return 0;
		}
		return -100; //理论上应该抛出异常
	}
}
