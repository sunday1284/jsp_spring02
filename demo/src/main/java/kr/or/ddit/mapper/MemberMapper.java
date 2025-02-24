package kr.or.ddit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.or.ddit.vo.MemberVO;

@Mapper
public interface MemberMapper {
	//pomenting 문자
	@Select("""
		SELECT MEM_ID
		, MEM_PASS
		, MEM_NAME 
		FROM MEMBER			
	""")
	public List<MemberVO> selectAll();
	@Select("""
		SELECT MEM_ID
		, MEM_PASS
		, MEM_NAME 
		FROM MEMBER	
		WHERE MEM_ID = #{memId}		
	""")
	public MemberVO selectOne(@Param("memId") String memId);
	
	@Insert("""
		INSERT INTO MEMBER(
			MEM_ID
			, MEM_PASS
			, MEM_NAME
		)VALUES(
			#{memId}
			, #{memPass}
			, #{memName}
		)	
	""")
	public int insert(MemberVO member);
	@Update("""
		UPDATE MEMBER
		SET
			MEM_PASS = #{memPass}
			, MEM_NAME = #{memName}
		WHERE MEM_ID = #{memId}
	""")
	public int update(MemberVO member);
	@Delete("""
		DELETE FROM MEMBER
		WHERE MEM_ID = #{memId}	
	""")
	public int delete(String memId);
}
