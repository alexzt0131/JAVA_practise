package demo.xml.dom4j;

public class Test implements ServletInterface{

	@Override
	public void init() {
		System.out.println("init...");
		
	}

	@Override
	public void service() {
		System.out.println("service...");
		
	}

	@Override
	public void close() {
		System.out.println("cloce...");
	}

	
	
	
}
