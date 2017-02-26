package zhk;

import java.util.HashMap;
import java.util.Map;

//����Ĵ���������
public class FontFactory {
	//�˴���ʹ�õĵ���ģʽ����֤�������ڴ��е�Ψһ��
	private FontFactory(){}
	private final static FontFactory fontFactory =new FontFactory();
	public static FontFactory getInstance(){
		return fontFactory;
	} 
	private Map<String, FontBase> fonts = new HashMap<String,FontBase>();

	public FontBase Crete(String name){
		FontBase fontBase = fonts.get(name);
		// �ж�����Ѿ����ھͲ����������ɣ�����ʹ��ԭ���ģ��������������
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
