package kr.or.ddit.event.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

// jpa
@Entity 
@Table(name = "EVENTS")
@Data
@NoArgsConstructor 
public class Event {
	@Id // PK
	@GeneratedValue //시퀀스 , mysql -> 오토인크리던스(identity) , 신경 x -> auto
	private Long id;
	private String title;
	@Column(name = "EVENTDATE")
	private LocalDateTime date;
	
	public Event(String title, LocalDateTime date) {
		super();
		this.title = title;
		this.date = date;
	}
	
	
}
