package kr.or.ddit.case08.objs;

import org.springframework.core.io.Resource;

import lombok.Data;

@Data
public class Case08CopiedObj {
	private String str;
	private int num;
	private boolean flag;
	
	private Resource webRes;
	
}
