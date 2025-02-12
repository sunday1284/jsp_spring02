package kr.or.ddit.m2.objs;


import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;


@Component
@Data
public class HuntingGround {
	private final HuntingDog dog;
	private final Cabin cabin;
	
	//has many 
//	@Autowired
	@Inject
	@Named("hunters")
	private List<Hunter> hunters;
	
	public void enter(Hunter hunter) {
		hunters.add(hunter);
	}
	
}
