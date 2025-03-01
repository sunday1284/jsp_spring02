package kr.or.ddit.lab;

import org.apache.commons.validator.GenericValidator;

public class Lab4 {
	public static void main(String[] args) {
		 System.out.println(GenericValidator.isDate("2014.03.12", "yyyy.MM.dd", true));
		 System.out.println(GenericValidator.isEmail("test@naver.com"));	
		 System.out.println(GenericValidator.isUrl("http://www.ddit.or.kr"));
		
	}
}
