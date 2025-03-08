package kr.or.ddit.lab;


/**
 * 삼각형 만들기 
 * 1 1 4	*
 * 2 3 3   ***
 * 3 5 2  *****
 * 4 7 1 *******
 * 5 9 0*********
 * 
 * *
 * ***
 * *****
 * *******
 * *********
 * 
 * 
 */
public class StartLab {
//	public static void main(String[] args) {
//		for(int i=0; i<9; i=i+2) {
//			for(int j=0; j<i; j++) {
//				System.out.print("*");
//			}
//			System.out.println("*");
//		}
//	}
	
	/**
	 * 삼각형 만들기 
	 * 1 1 4	*
	 * 2 3 3   ***
	 * 3 5 2  *****
	 * 4 7 1 *******
	 * 5 9 0*********
	 * @param args
	 */
	public static void main(String[] args) {
		for(int i=0; i<5; i++) {
			for(int k=0; k<5-i; k++) {
				System.out.print(" ");
			}
			for(int j=0; j<i*2; j++) {
				System.out.print("*");
			}
			System.out.println("*");
		}
	}
}
