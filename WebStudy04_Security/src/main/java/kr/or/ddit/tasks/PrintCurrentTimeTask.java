package kr.or.ddit.tasks;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@Component
public class PrintCurrentTimeTask {
	//하나의 작업이 끝나면 2초뒤에 시작
//	@Scheduled(initialDelay = 3000, fixedDelay = 2000)
	//Delete 처리할 때 -> 회원 탈퇴 할 떄 유용
//	@Scheduled(cron = "0 0 3 ? * MON")
	@Scheduled(cron = "0/5 * * * * *")
	public void printCurrentTime() {
		LocalDateTime current = LocalDateTime.now();
		log.info("------------------> {}, 탈퇴처리했음", current);
	}
}
