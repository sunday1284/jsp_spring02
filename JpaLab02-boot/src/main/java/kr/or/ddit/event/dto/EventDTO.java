package kr.or.ddit.event.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

/**
 * 
 * @author CHOI
 * @since 2025. 4. 25.
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      			수정자           수정내용
 *  -----------   	-------------    ---------------------------
 *  2025. 4. 25.     	CHOI	         마샬링 대상 DTO
 *
 * </pre>
 */
@Data
public class EventDTO implements Serializable{
	private Long id;
	private String title;
	private LocalDateTime date;
}
