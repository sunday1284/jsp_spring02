package kr.or.ddit.case07.objs;

import org.springframework.core.io.Resource;

import lombok.Data;

@Data
public class Case07ObjectWithResources {
	private final Resource fsRes;
	private final Resource cpRes;
	private Resource webRes;
}
