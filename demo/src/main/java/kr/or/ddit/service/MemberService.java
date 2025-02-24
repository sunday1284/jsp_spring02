package kr.or.ddit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.ddit.mapper.MemberMapper;
import kr.or.ddit.vo.MemberVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	
	private final MemberMapper mapper;
	
	public List<MemberVO> readAll(){
		return mapper.selectAll();
	}
	public MemberVO readOne(String memId){
		return mapper.selectOne(memId);
	}
	public void create(MemberVO member){
		mapper.insert(member);
	}
	public void modify(MemberVO member){
		mapper.update(member);
	}
	public void remove(String memId){
		mapper.delete(memId);
	}
}
