package kr.or.ddit.prod.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.mybatis.mappers.LprodMapper;
import kr.or.ddit.vo.LprodVO;
import lombok.Data;



@Service
@Data
public class lprodServiceImpl implements LprodService{

	@Inject
	private final LprodMapper dao;
	@Override
	public List<LprodVO> readLprodList() {
		return dao.selectLprodList();
	}

	@Override
	public LprodVO readLprod(String lprodGu) {
		return dao.selectLprod(lprodGu);
	}

	@Override
	public void createLprod(LprodVO lprod) {
		dao.insertLprod(lprod);
	}

	@Override
	public void modifyLprod(LprodVO lprod) {
		dao.updateLprod(lprod);
	}
	
}
