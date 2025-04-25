package kr.or.ddit.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.or.ddit.event.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long>{ // 테이블명, pk타입 

}
