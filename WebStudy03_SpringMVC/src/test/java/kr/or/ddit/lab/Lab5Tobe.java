package kr.or.ddit.lab;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

public class Lab5Tobe {
	public static void main(String[] args) throws IOException {
		List<String> lines = new ArrayList<String>();
		
		
		for (int i = 0; i < 10; i++) {
			lines.add("홍길동" + (i + 1)+"\n");
		}
		
		File file = new File("c:/ddit/fileUtil/live.txt");
		String fullFileName= "c:/ddit/test/simple.txt";
		 System.out.println("파일명확장자포함:“ "+ FilenameUtils.getName(fullFileName));
		 System.out.println("파일명:“ "+FilenameUtils.getBaseName(fullFileName));
		 System.out.println("확장자:“ "+FilenameUtils.getExtension(fullFileName));
		 System.out.println("파일경로:“ "+FilenameUtils.getFullPath(fullFileName));
		//파일 라이브러리에서 자동 폴더+ 파일까지 생성
		FileUtils.writeLines(file, lines);
		
	}
}
