package kr.or.ddit.prod.vo.fullcalendar;

public interface FullCalendarEvent<T> {
//	private String id;
//	private boolean allDay;
//	private String start;
//	private String end;
//	private String title;
//	private String textColor;
//	//제네릭 타입으로 모든 객체를 넣을 수 있음
//	private T extendedProps;
	public String getId();
	public boolean isAllDay();
	public String getStart();
	public String getEnd();
	public String getTitle();
	public String getTextColor();
	public T getExtendedProps();
	
	
}
