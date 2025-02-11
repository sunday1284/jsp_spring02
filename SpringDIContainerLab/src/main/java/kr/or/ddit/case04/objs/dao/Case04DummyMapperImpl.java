package kr.or.ddit.case04.objs.dao;

import org.springframework.stereotype.Repository;

import lombok.ToString;


/**
 * @Repository 이걸로 매핑함 -> "mapper"-> value값이 바뀜
 */
@Repository("mapper")
@ToString
public class Case04DummyMapperImpl implements Case04DummyMapper {

}
