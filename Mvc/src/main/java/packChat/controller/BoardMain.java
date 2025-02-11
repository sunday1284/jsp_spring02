package packChat.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import packChat.AppConfig;
import packChat.controller.BoardController;

public class BoardMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        BoardController boardController = context.getBean(BoardController.class);
        boardController.run();
    }
}