package kr.or.ddit.case04.objs.service;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.case04.objs.dao.Case04DummyMapper;
import kr.or.ddit.case04.objs.dao.Case04DummyOthers;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
//생성자를 자동 호출해줌
@Slf4j
@Service
@ToString
public class Case04DummyServiceImpl implements Case04DummyService {
	private final Case04DummyMapper case04DummyMapper;
	private Case04DummyOthers others;

	//생성자 주입방식
//	@Autowired
	@Inject //==@AutoWired(required=true)
	@Named("mapper_MariaDB")
//	@Resource(name = "mapper_MariaDB")
	public Case04DummyServiceImpl(Case04DummyMapper case04DummyMapper) {
		super();
		this.case04DummyMapper = case04DummyMapper;
	}
	//setter 주입방식
	@Autowired(required = false)
	public void setOthers(Case04DummyOthers others) {
		this.others = others;
		log.info("{} 주입이 되었음. (setter injection)", others.getClass().getSimpleName());
	}
	
	
}
