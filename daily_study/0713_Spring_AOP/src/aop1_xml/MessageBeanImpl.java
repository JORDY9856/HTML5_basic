package aop1_xml;

public class MessageBeanImpl implements MessageBean {

	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		
		System.out.println("안녕하세요");
		
	}

	@Override
	public void engSayHello() {
		System.out.println("hi");

	}

	@Override
	public void test() {
		System.out.println("테스트");

	}

	

}
