package kr.or.ddit.case01.objs;

import lombok.ToString;

@ToString
public class ObjectWithFinalProperty {
	private final String name;
	
	public ObjectWithFinalProperty(String name) {
		this.name = name;
    }
	
	public String getName() {
		return name;
	}
	
}
