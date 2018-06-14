package demo.xml.dom4j;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4jTest {
	
	
	
	public static void main(String[] args) {
		//���saxreaderʵ��
		SAXReader reader = new SAXReader();
		
		try {
			//���xml�ĵ�
			Document document = reader.read("src/demo/xml/dom4j/web.xml");
			//��ø�Ԫ��
			Element rootElement = document.getRootElement();
			//��Ԫ������
			String nodeName = rootElement.getName();
			System.out.println(nodeName);
			//��ø�Ԫ��������Ԫ�ص��б�
			List<Element> elements = rootElement.elements();
			//������Ԫ����Ԫ��
			for (Element element : elements) {
				String childName = element.getName();
				System.out.println("NodeName��"+childName);
				if("servlet".equals(childName)) {
					Element servletName = element.element("servlet-name");
					System.out.println("servletName:"+servletName.getText());
					Element servletClass = element.element("servlet-class");
					System.out.println("servletName:"+servletClass.getText());
				}
			}
			System.out.println("-----------------------------");
			//���ָ��Ԫ��
			Element servletMapping = rootElement.element("servlet-mapping");
			System.out.println(servletMapping.getName());
			Element servletName = servletMapping.element("servlet-name");
			System.out.println("servletName:"+servletName.getText());
			Element urlPattern = servletMapping.element("url-pattern");
			System.out.println("urlPattern:"+urlPattern.getText());
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
