package kr.or.ddit.m2.config;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import kr.or.ddit.m2.objs.Hunter;
import kr.or.ddit.m2.objs.HuntingGround;
import lombok.extern.slf4j.Slf4j;


/**
 * 사냥 게임의 모델링 
 * 1. 하나의 사냥터(HuntingGround) - 싱글턴 has many Hunter s, has a HuntingDog, has a Cabin
 * 2. 여러명의 사냥꾼(Hunter) 입장 가능.
 * 3. 각 사냥꾼은 자기만의 총(Gun)을 소유함.
 * 4. 사냥터를 지키는 한마리의 사냥개(HuntingDog)를 사냥꾼들이 공유함. - 싱글턴 
 * 5. 사냥터에는 하나의 오두막(Cabin) 있고, 사냥꾼들이 공유함. - 싱글턴 
 */
@Slf4j
@Configuration
@ComponentScan(basePackages = "kr.or.ddit.m2.objs")
public class Misson02JavaConfig {
	@Autowired
	private ConfigurableApplicationContext context;
	
	@Bean
	public List<Hunter> hunters(){
		return new ArrayList<>();	
	}
	
	@PostConstruct
	public void init() {
		HuntingGround ground = context.getBean(HuntingGround.class);
		log.info("사냥터 개장!!");
		Hunter hunter1 = context.getBean(Hunter.class);
		ground.enter(hunter1);
		Hunter hunter2 = context.getBean(Hunter.class);
		ground.enter(hunter2);
		Hunter hunter3 = context.getBean(Hunter.class);
		ground.enter(hunter3);
		log.info("사냥터에 3명의 헌터 입장!");
	}
}
