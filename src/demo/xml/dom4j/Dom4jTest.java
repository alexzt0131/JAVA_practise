package demo.xml.dom4j;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4jTest {
	
	
	
	public static void main(String[] args) {
		
//		test1();
		testReflect();
	}
	
	private static void testReflect() {
		/*
		 * 反射技术使得方法更加灵活，可以从properties或者xml
		 * 中获得类名并执行指定方法
		 * 这里假设约定
		 * Method initMethod = clazz.getMethod("init");
			Method serviceMethod = clazz.getMethod("service");
			Method closeMethod = clazz.getMethod("close");
			顺序执行着3个方法
		 */
		//获得saxreader实例
		SAXReader reader = new SAXReader();
		//获得xml文档
		Document document = null;
		String className = null;
		try {
			document = reader.read("src/demo/xml/dom4j/web.xml");
			//获得根元素
			Element rootElement = document.getRootElement();
			//根元素名称
			String nodeName = rootElement.getName();
			System.out.println(nodeName);
			//获得根元素下所有元素的列表
			List<Element> elements = rootElement.elements();
			//
			for (Element e : elements) {
				if("servlet".equals(e.getName())) {
					className = e.elementText("servlet-class");
				}
			}
			Class clazz = Class.forName(className);
			
			Test obj = (Test) clazz.newInstance();
			
			Method initMethod = clazz.getMethod("init");
			Method serviceMethod = clazz.getMethod("service");
			Method closeMethod = clazz.getMethod("close");
			
			initMethod.invoke(obj);
			serviceMethod.invoke(obj);
			closeMethod.invoke(obj);
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}







	private static void test1() {
		//获得saxreader实例
				SAXReader reader = new SAXReader();
				
				try {
					//获得xml文档
					Document document = reader.read("src/demo/xml/dom4j/web.xml");
					//获得根元素
					Element rootElement = document.getRootElement();
					//根元素名称
					String nodeName = rootElement.getName();
					System.out.println(nodeName);
					//获得根元素下所有元素的列表
					List<Element> elements = rootElement.elements();
					//遍历根元素下元素
					for (Element element : elements) {
						String childName = element.getName();
						System.out.println("NodeName："+childName);
						if("servlet".equals(childName)) {
							Element servletName = element.element("servlet-name");
							System.out.println("servletName:"+servletName.getText());
							Element servletClass = element.element("servlet-class");
							System.out.println("servletName:"+servletClass.getText());
						}
					}
					System.out.println("-----------------------------");
					//获得指定元素
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
