package kr.or.ddit.lab;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 구시대
 */
public class Lab5AsIs {
	
	private void testCreateFile() throws IOException {
		List<String> lines = new ArrayList<String>();

		for (int i = 0; i < 10; i++) {
			lines.add("홍길동" + (i + 1)+"\n");
		}

		File file = new File("c:/ddit/simple.txt");
		
		File directory = new File("c:/ddit/");
		
		
		directory.mkdirs();
//		file.createNewFile();
		
		BufferedWriter write = null;
		try {
			System.out.println("1.try 시작");
			
			write = new BufferedWriter(new FileWriter(file));
			for (String line : lines) {
				write.write(line);
			}
			
			if(true)
				throw new IOException("Exception Test!!");
			
			System.out.println("2.try 종료");
		} catch (IOException e) {
			System.out.println("3.catch 시작");
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(true)
				throw e;
			System.out.println("4.catch 종료");
		} finally {
			System.out.println("5.finally 시작");
			if (write != null) {
				try {
					write.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("6.finally 종료");
		}
	}
	
	public void launch() {
		try {
			this.testCreateFile();
		} catch (IOException e) {
			System.out.println("88. launch() IOException");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		Lab5AsIs lab5AsIs = new Lab5AsIs();
		lab5AsIs.launch();
		
		System.out.println("99. 프로그램 종료");
	}
}

