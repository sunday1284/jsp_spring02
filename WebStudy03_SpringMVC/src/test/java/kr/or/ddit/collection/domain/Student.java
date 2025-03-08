package kr.or.ddit.collection.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student extends People {
	private String gradeNo;
	private String classNo;
	private String no;
	
	//디폴트 생성자 를 하나 만들어 놓는다.
	public Student() {
		
	}
	
	public Student(String name, int age, String sex , String gradeNo, String classNo, String no) {
		this.setName(name);
		this.setAge(age);
		this.setSex(sex);
		
		this.gradeNo = gradeNo;
		this.classNo = classNo;
		this.no = no;
	}
	
	@Override
	public String toString() {
		return super.toString()+"Student [gradeNo=" + gradeNo + ", classNo=" + classNo + ", no=" + no + "]";
	}
	
	
}
