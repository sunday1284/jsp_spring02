package kr.or.ddit.lab;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Lab5AsIs {

	public static void main(String[] args) {

		List<String> lines = new ArrayList<String>();

		for (int i = 0; i < 10; i++) {
			lines.add("홍길동" + (i + 1));
		}

		File file = new File("c:/ddit/simple.txt");
		BufferedWriter write = null;
		try {
			write = new BufferedWriter(new FileWriter(file));
			for (String line : lines) {
				write.write(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (write != null) {
				try {
					write.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
