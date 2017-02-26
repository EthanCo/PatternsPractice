package zhk;

import java.util.ArrayList;
import java.util.List;

//字体类的基类
public class FontBase {
	private List<String> font = new ArrayList<String>();
	
	private String fontName;
	
	public FontBase(String fontName) {
		super();
		this.fontName = fontName;
	}

	//获取字体名字
	public String getFontName() {
		return fontName;
	}

	//添加字
	public void AddFont(String font) {
		this.font.add(font);
	}
}
