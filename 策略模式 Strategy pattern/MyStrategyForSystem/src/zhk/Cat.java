package zhk;

import java.util.Comparator;

public class Cat implements Comparable<Cat> {
	private int height;
	private int width;
	private Comparator<Cat> comparator = new CatHeightComparator(); //默认比较方式
	
	public Cat(int height, int width, Comparator<Cat> comparator) {
		super();
		this.height = height;
		this.width = width;
		this.comparator = comparator;
	}

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
	public int compareTo(Cat o) {
		return comparator.compare(this, o);
	}
}
