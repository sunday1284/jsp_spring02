package kr.or.ddit.case05.objs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Service
//@RequiredArgsConstructor
@ToString
public class Case05DummyService {
	//1. 주입 방식 설계 -> 생성자
	private final Case05DummyDAO dao;
	//xml에서 설정한 value값 
	
	private final String data;
	public Case05DummyService(@Autowired Case05DummyDAO dao, @Value("DATA_VALUE") String data) {
		super();
		this.dao = dao;
		this.data = data;
	}
	
	
	
	
}
