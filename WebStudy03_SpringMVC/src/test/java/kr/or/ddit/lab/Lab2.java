package kr.or.ddit.lab;

public class Lab2 {

	public static void main(String[] args) {
		String nameA = "홍길동";
		String nameB = "홍길동";
		String nameC = new String("홍길동");
		String nameD = new String("홍길동");
		System.out.println("nameA== nameB: " + (nameA == nameB));
		System.out.println("nameA == nameC: " + (nameA == nameC));
		System.out.println("nameC== nameD: " + (nameC == nameD));
	}
}
