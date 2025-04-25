package kr.or.ddit.event.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.event.entity.Event;

@SpringBootTest
//@Transactional
class EventRepositoryTest {

	@Autowired
	EventRepository repository;
	
	/**
	 * 전체 조회
	 */
	@Test
	void testFindAll() {
//		e->System.out.println(e)
		//메소드 레퍼런스
		repository.findAll().forEach(System.out::println); // 추가신턴트 
	}

	/**
	 * 영속성 컨테스트가 있으므로 여기에 저장된다 -> 트랜잭션 처리 시 여기에만 저장 commit, rollback-> x
	 */
	@Test
	void testSave() {
		Event event = new Event();
		event.setTitle("새로 추가한 일정2");
		event.setDate(LocalDateTime.now());
		repository.save(event);
	}
	
	@Test
	void testUpdate() {
		//클라이언트의 적절한 입력값 검증
		//1.단건 조회 -> 없으면 Exception
		Event event = repository.findById(2l).orElseThrow();
		//2. 수정 사항 수정
		event.setTitle("왕창 수정");
		//3. 반영
		repository.save(event);
		
	}

	@Test
	void testFindById() {
//		repository.findById(1l).ifPresent(System.out::println);
		//있으면 이벤트 발생 없으면 ecexption
		Event event = repository.findById(1l).orElseThrow();
		System.out.println(event);
	}

	@Test
	void testDeleteById() {
//		repository.deleteById(152l);
		//안정적인 삭제 방법 -> 해당 id값이 없으면 삭제 x 
		Event event = repository.findById(102l).orElseThrow();
		repository.delete(event);
	}

}
