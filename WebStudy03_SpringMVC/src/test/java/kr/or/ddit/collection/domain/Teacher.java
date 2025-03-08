package kr.or.ddit.collection.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Teacher extends People {
	
	/**
	 * 정교사, 기간제교사
	 */
	private String managerType;
	
	/**
	 * 담임교사, 일반교사
	 */
	private String operateType;

	
	public Teacher() {
		
	}
	
	public Teacher(String name, int age, String sex, String managerType , String operateType) {
		this.setName(name);
		this.setAge(age);
		this.setSex(sex);
		
		this.managerType = managerType;
		this.operateType = operateType;
	}
	
	@Override
	public String toString() {
		return super.toString()+"Teacher [managerType=" + managerType + ", operateType=" + operateType + "]";
	}
	
	
}
