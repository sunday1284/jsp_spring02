package kr.or.ddit.prod.vo.fullcalendar;

import kr.or.ddit.prod.vo.ProdVO;
import lombok.RequiredArgsConstructor;

/**
 * Adapter Pattern (Wrapper Pattern)
 *  : 기존의 객체가 새로운 서비스 환경에서 사용해야하는 경우,
 *    해당 객체가 서비스 내에서 사용되는 구조와 일치하지 않는 경우,
 *    기존 객체를 변경하지 않고, adapter 를 통해 기존 객체의 인터페이스를 확장하는 방식.
 *  
 * 
 */
@RequiredArgsConstructor
public class ProdFCEvent implements FullCalendarEvent<ProdVO> {

	private final ProdVO adaptee;
	
	@Override
	public String getId() {
		return adaptee.getProdId();
	}

	@Override
	public boolean isAllDay() {
		return true;
	}

	@Override
	public String getStart() {
		return adaptee.getProdInsdate().toString();
	}

	@Override
	public String getEnd() {
		return adaptee.getProdInsdate().toString();
	}

	@Override
	public String getTitle() {
		return adaptee.getProdName();
	}

	@Override
	public String getTextColor() {
//		return adaptee.getProdColor();
		return "blue";
	}

	@Override
	public ProdVO getExtendedProps() {	
		return adaptee;
	}

}
