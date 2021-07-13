package ex3_autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context =
				new ClassPathXmlApplicationContext(
						"ex3_autowiring/applicationContext.xml"); //콩주머니 가져옵니다

		MessageBean bean = context.getBean("message", MessageBean.class);
		//콩주머니에서 message라는 콩을 쓰겠습니다
		
		bean.sayHello();
		//message라는 콩을 sayHello(); 메서드에서 실행하겠습니다
	}

}