package kr.or.ddit.case11.objs.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.case11.objs.dao.PersonMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Data
public class Case11PersonService {
	@Autowired
	private final PersonMapper mapper;
	
	@PostConstruct
	public void init() {
		log.info("주입된 mapper : {}", mapper);
	}
}
