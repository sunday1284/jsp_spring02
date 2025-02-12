package kr.or.ddit.m2.objs;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;



/**
 * prototype이면서 lazy
 */
@Data
@Component
@Scope("prototype")
public class Hunter {
	private final Gun gun;
	
	@Autowired
	private HuntingDog dog;
	
	@Inject
	private Cabin cabin;
}
