package zhk;

import java.util.HashMap;
import java.util.Map;

//具体的创建工厂类
public class FontFactory {
	//此处还使用的单例模式，保证工厂在内存中的唯一性
	private FontFactory(){}
	private final static FontFactory fontFactory =new FontFactory();
	public static FontFactory getInstance(){
		return fontFactory;
	} 
	private Map<String, FontBase> fonts = new HashMap<String,FontBase>();

	public FontBase Crete(String name){
		FontBase fontBase = fonts.get(name);
		// 判断如果已经存在就不再重新生成，而是使用原来的，否则就重新生成
		if(fontBase!=null){
			return fontBase;
		}
		
		if(name=="ChineseFont"){
			fontBase =(FontBase)new ChineseFont();
			fonts.put("ChineseFont", fontBase);
		}else if(name=="EnglishFont"){
			fontBase =(FontBase)new EnglishFont();
			fonts.put("EnglishFont", fontBase);
		}
		return fontBase;
	}
}
