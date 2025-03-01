package kr.or.ddit.lab;

public class Lab3 {
   
   public static void main(String[] args) {
       String stringValue= "1234567890";
       StringBuffer stringBuffer= new StringBuffer("1234567890");
       
       System.out.println("concat: "+ stringValue.concat("abcd"));
       System.out.println("append: "+ stringBuffer.append("abcd"));
       System.out.println("stringValue: "+stringValue);
       System.out.println("stringBuffer: "+stringBuffer);
   }
}