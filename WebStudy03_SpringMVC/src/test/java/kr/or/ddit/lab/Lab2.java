package kr.or.ddit.lab;

public class Lab2 {

	public static void main(String[] args) {
		String nameA = "홍길동";
		String nameB = "홍길동";
		String nameC = new String("홍길동");
		String nameD = new String("홍길동");
		
		nameC = null;

		System.out.println("nameA == nameB: " + (nameA == nameB));
		System.out.println("nameA == nameC: " + (nameA == nameC));
		System.out.println("nameC == nameD: " + (nameC == nameD));
		
		//& -> 앞에꺼가 null 떨어져도 그냥 감
		
		//1
		if(nameC != null && nameC.equals("홍길동")) {
			System.out.println("홍길동 입니다.");
		}else {
			System.out.println("홍길동 아닌데요.");
		}
		
		//2 -> 함수 equals 
		if(nameC != null && "홍길동".equals(nameC)) {
			System.out.println("홍길동 입니다.");
		}else {
			System.out.println("홍길동 아닌데요.");
		}

	}
}
