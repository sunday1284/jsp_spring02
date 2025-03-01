package kr.or.ddit.lab;

import lombok.Data;

@Data
public class Lab1VO {

	private int intValue;
	private short shortValue;
	private long longValue;
	private float floatValue;
	private double doubleValue;
	private byte byateValue;
	private char charValue;
	private boolean booleanValue;
	private String stringValue;
	private Boolean BooleanValue;

	public static void main(String[] args) {
		Lab1VO lab1VO = new Lab1VO();

		System.out.println(lab1VO);
	}
}
