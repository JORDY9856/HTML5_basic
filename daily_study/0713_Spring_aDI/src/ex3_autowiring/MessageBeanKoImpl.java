package ex3_autowiring;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


// VO와 같은 역할을 합니다
//setter을 만들거나 생성자를 생성하여 xml에서 가져다 쓸 수 있습니다

public class MessageBeanKoImpl implements MessageBean {
	
	private String  name; //String 이니까 value로 받는다
	private String  message;
	
	@Autowired //가장 대표적인 DI xml에서 골뱅이 스캔 반드시 필요 . 찾아서 넣어줍니다
	@Qualifier("outputer2")// 뭘 찾을지 정해줍니다
	//(spring에 들어있음)
	
	
	//@Resource(name="outputer2") 
	//Autowired와 Qualifier 합친거, 특정  name을 찾아서 넣어줍니다(java 내장)
	
	private Outputer out;  //얘는 ref로 받는다 
	//setter, constructor 없음
	
	
	public void sayHello() {
		System.out.println(name+"님께"+ message);		
		try {
			out.writeMessage(name + "님께" + message);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	

	//setter
	public void setName(String name) {
		this.name = name;
	}

	public void setMessage(String message) {
		this.message = message;
	}





}
