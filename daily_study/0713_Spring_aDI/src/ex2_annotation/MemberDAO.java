package ex2_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("dao") //객체 생성 해달라고 스티커 붙임
public class MemberDAO {
	
	@Autowired
	private MemberBean member; //private인데도 들어옴
		
	public void insert() {
		member.output(); 
		}
	/*
	 * //1) setter 이용 public void setMember(MemberBean member) { this.member=
	 * member; }
	 * 
	 * //2)생성자 이용
	 * 
	 * public MemberDAO() {}
	 * 
	 * 
	 * public MemberDAO(MemberBean member) { this.member =member; }
	 */ 
	 
	
}
