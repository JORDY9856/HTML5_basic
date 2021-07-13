package ex1_xml1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		
		//------------------------------------
		// 0. POJO(순수 자바)
//		MessageBean bean1= new MessageBeanKoImpl();
//		bean1.sayHello("홍길동");
//		
//		MessageBean bean2 = new MessageBeanEnImpl();
//		bean2.sayHello("John");

		//**********************************
		// 1. DI
		ApplicationContext context = 
		new ClassPathXmlApplicationContext("ex1_xml1/applicationContext.xml"); //스프링컨테이너한테 의뢰
		
		System.out.println("------------start----------");
		//MessageBean b1 = (MessageBean)context.getBean("ko"); //너무 자바방식이라서 아래로 표현
		MessageBean b1 = context.getBean("ko", MessageBean.class);
		b1.sayHello("홍길자");

		System.out.println("------------start----------");
		MessageBean b2 = context.getBean("en", MessageBean.class); 
		b1.sayHello("John");
		
		MessageBean b3 = context.getBean("en", MessageBean.class);
		b1.sayHello("Ann");  //하나의 함수가 객체만 바꿔서 써주고 있다
		
		
		
		
		
		
		
	}

}
