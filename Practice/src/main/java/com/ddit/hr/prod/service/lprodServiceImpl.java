package com.ddit.hr.prod.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddit.hr.mybatis.mappers.LprodMapper;
import com.ddit.hr.vo.LprodVO;

import lombok.Data;

@Service
@Data
public class lprodServiceImpl implements LprodService {
	
	@Inject
	private final LprodMapper dao;
	
	
	@Override
	public LprodVO readLprod(String lprodGu) {
		return dao.selectLprod(lprodGu);
	}

	@Override
	public List<LprodVO> readLprodList() {
		return dao.selectLprodList();
	}

}
