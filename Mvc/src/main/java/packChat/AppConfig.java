package packChat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import packChat.controller.BoardController;
import packChat.repository.BoardRespository;
import packChat.service.BoardService;
import packChat.service.IBoard;

@Configuration
@ComponentScan(basePackages = "packChat")
public class AppConfig {
	@Bean
	public IBoard boardService(BoardRespository boardRepository) {
		return new BoardService(boardRepository);
		
	}
	@Bean
	public BoardController boardController() {
		return new BoardController(boardService(null));
	}
}
