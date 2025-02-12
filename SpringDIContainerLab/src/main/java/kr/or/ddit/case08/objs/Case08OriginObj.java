package kr.or.ddit.case08.objs;

import org.springframework.core.io.Resource;

import lombok.Data;

@Data
public class Case08OriginObj {
	private String str;
	private String numStr;
	private String flagStr;
	
	private Resource webRes;
	
}
