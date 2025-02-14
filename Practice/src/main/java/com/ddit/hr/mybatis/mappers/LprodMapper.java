package com.ddit.hr.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ddit.hr.vo.LprodVO;

@Mapper
public interface LprodMapper {
	public LprodVO selectLprod(String lprodGu);
	
	public List<LprodVO> selectLprodList();
}
