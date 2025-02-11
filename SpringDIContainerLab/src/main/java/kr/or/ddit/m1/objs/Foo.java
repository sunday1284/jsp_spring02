package kr.or.ddit.m1.objs;


import lombok.Data;
import lombok.ToString;

@Data
public class Foo {
	private final Bar bar;
	private Baz baz;
	
//	//필수 의존객체
//	public Foo(Bar bar) {
//		super();
//		this.bar = bar;
//    }
//	
//	//setter 객체
//	
//	public void setBaz(Baz baz) {
//        this.baz = baz;
//    }
	
}
