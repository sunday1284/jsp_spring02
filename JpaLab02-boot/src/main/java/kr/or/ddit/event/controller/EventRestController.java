package kr.or.ddit.event.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import kr.or.ddit.event.dto.EventDTO;
import kr.or.ddit.event.service.EventService;

@RestController
@RequestMapping("/api/events")
public class EventRestController {
	@Autowired
	private EventService service;
	
	/**
	 * 전체 조회
	 * @return
	 */
	@GetMapping
	public List<EventDTO> eventList(){
		return service.readAll();
	}
	/**
	 * 단건 조회
	 * @param id
	 * @return
	 */
	@GetMapping("{id}")
	public EventDTO eventDetail(@PathVariable("id") long id){
	
		try {
			return service.readOne(id);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatusCode.valueOf(404));
		}
	}
	
	/**
	 * 이벤트 추가 
	 * @param dto
	 * @return
	 */
	@PostMapping
	public ResponseEntity<?> eventInsert(@RequestBody EventDTO dto){
		
		service.create(dto);
		
		//204 상태 코드 만듦
		return ResponseEntity.noContent().build();
	}
	
	
	/**
	 * 업데이트
	 * @param id
	 * @param dto
	 * @return
	 */
	@PutMapping("{id}")
	public ResponseEntity<?> eventUpdate(@PathVariable("id") long id, @RequestBody EventDTO dto) {
		try {
			service.update(id, dto);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatusCode.valueOf(404), "Not found");
		}
		
	}
	
	/**
	 * 삭제
	 * @param id
	 * @return
	 */
	@DeleteMapping("{id}")
	public ResponseEntity<?> eventDelete(@PathVariable("id") long id){
		try {
			service.delete(id);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatusCode.valueOf(404), "Not found");
		}
	}
	
}
