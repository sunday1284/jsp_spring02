package kr.or.ddit.case04.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service
public class Case04DummyService {
	public LocalDate readToday(){
		return LocalDate.now();
		
	}
}
