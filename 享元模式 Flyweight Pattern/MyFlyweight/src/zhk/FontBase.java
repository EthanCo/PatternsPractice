package zhk;

import java.util.ArrayList;
import java.util.List;

//������Ļ���
public class FontBase {
	private List<String> font = new ArrayList<String>();
	
	private String fontName;
	
	public FontBase(String fontName) {
		super();
		this.fontName = fontName;
	}

	//��ȡ��������
	public String getFontName() {
		return fontName;
	}

	//�����
	public void AddFont(String font) {
		this.font.add(font);
	}
}
