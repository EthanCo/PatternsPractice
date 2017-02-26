package zhk;

public class Cat {
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
}
