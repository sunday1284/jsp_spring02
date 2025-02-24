package com.hr.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hr.ddit.member.vo.MemberVO;
import com.hr.ddit.paging.PaginationInfo;

/** 알트+쉬프트+j ->api - document 
 * 회원관리(CRUD)를 위한 persistence layer 
 */
@Mapper
public interface MemberDAO {
	
	/**
	 * 신규 회원 등록 
	 * @param member 등록할 회원의 정보를 가진 vo 
	 * @return 등록된 레코드 수 
	 */
	public int insertMember(MemberVO member);
	
	/**
	 * 페이징 처리를 위한 전체 레코드수 조회
	 * @param paging
	 * @return
	 */
	public int selectTotalRecord(PaginationInfo<MemberVO> paging);
	/**
	 * 회원 목록 조회
	 * @param paging TODO
	 * @return 등록된 회원이 없는 경우, size == 0 (blank list) 반환
	 */
	public List<MemberVO> selectMemberList(PaginationInfo<MemberVO> paging);
	
	/**
	 * 회원 상세 조회 
	 * @param memId 조회 대상 primary key
	 * @return 해당 회원이 없는 경우, null 반환 
	 */
	public MemberVO selectMember(String memId);
	/**
	 * 회원 정보 수정 
	 * @param member 수정할 대상의 정보와 수정할 값(리터럴)을 가진 객체 
	 * @return 수정된 레코드 수 
	 */
	public int updateMember(MemberVO member);
	/**
	 * 회원 정보 삭제
	 * @param memId 삭제할 대상의 primary key 
	 * @return 삭제된 레코드 수 
	 */
	public int deleteMember(@Param("memId") String memId);
}
