package kr.or.ddit.case11.objs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.case11.objs.vo.PersonVO;


@Mapper
public interface PersonMapper {
	public int insertPerson(PersonVO person);
	public List<PersonVO> selectPersonList();
	public PersonVO selectPerson(String id);
	public int updatePerson(PersonVO person);
	public int deletePerson(String id);
}
