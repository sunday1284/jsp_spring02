package kr.or.ddit.case04.objs.dao;

import org.springframework.stereotype.Repository;

import lombok.ToString;


/**
 * @Repository 이걸로 매핑함 -> "mapper"-> 식별자(id)값이 바뀜
 */
@Repository("mapper_MariaDB")
@ToString
public class Case04DummyMapperImpl_MariaDB implements Case04DummyMapper {

}
