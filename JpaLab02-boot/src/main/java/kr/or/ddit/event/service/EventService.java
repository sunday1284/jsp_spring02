package kr.or.ddit.event.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.management.relation.RelationNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import kr.or.ddit.event.dto.EventDTO;
import kr.or.ddit.event.entity.Event;
import kr.or.ddit.event.repository.EventRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventService {
	private final EventRepository repository;
	
	/**
	 * @param entity 값을 dto에 셋팅
	 * @return
	 */
	private EventDTO entityToDTO(Event entity) {
		EventDTO dto = new EventDTO();
		dto.setId(entity.getId());
		dto.setTitle(entity.getTitle());
		dto.setDate(entity.getDate());
		return dto;
	}
	
	/**
	 * 전체 조회
	 * @return
	 */
	public List<EventDTO> readAll(){
		return repository.findAll()
				.stream()
				//엘리먼트를 dto로 변환
				.map(this::entityToDTO)
				//collect 활용해 리스트로 변환
				.collect(Collectors.toList());
	}
	
	/**
	 * 단건 조회
	 * @param id
	 * @return
	 */
	public EventDTO readOne(long id){
		return repository.findById(id)
					.map(this::entityToDTO)
					.orElseThrow();
	}
	
	/**
	 * 데이터 삽입 -> 스프링의 트랜잭션 관리 
	 * @param dto
	 */
	@Transactional
	public void create(EventDTO dto){
		Event entity = new Event();
		entity.setTitle(dto.getTitle());
		entity.setDate(dto.getDate());
		repository.save(entity); // 영속성 계층에 저장
	}
	
	/**
	 * 데이터 수정 
	 * @param id
	 * @param dto
	 */
	@Transactional
	public void update(long id, EventDTO dto){
		Event entity = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("id값이 존재하지 않습니다 id : " +id));
		entity.setTitle(dto.getTitle());
		entity.setDate(dto.getDate());
	}
	
	/**
	 * 데이터 삭제
	 * @param id
	 */
	@Transactional
	public void delete(long id){
		if(!repository.existsById(id)) {
			throw new EntityNotFoundException("삭제할 id값 존재 x : " +id);
		}
		//존재하면 삭제 작업 수행 
		repository.deleteById(id);
	}
}
