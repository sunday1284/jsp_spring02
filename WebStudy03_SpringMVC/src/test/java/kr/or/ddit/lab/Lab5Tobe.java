package kr.or.ddit.lab;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class Lab5Tobe {
   
   public static void main(String[] args) {
      List<String> lines = new ArrayList<String>();

      for (int i = 0; i < 10; i++) {
         lines.add("홍길동" + (i + 1) + "\n");
      }

      try {
          File file= new File("c:/ddit/fileUtils.txt");
          FileUtils.writeLines(file, lines);
          } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
          }

   }

}
