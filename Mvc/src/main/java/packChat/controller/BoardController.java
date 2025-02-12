package packChat.controller;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import packChat.model.BoardVO;
import packChat.service.IBoard;

@Controller
public class BoardController {

    private final IBoard boardService;

    @Autowired
    public BoardController(IBoard boardService) {
        this.boardService = boardService;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. 게시글 등록");
            System.out.println("2. 모든 게시글 조회");
            System.out.println("3. 게시글 상세 조회");
            System.out.println("4. 게시글 삭제");
            System.out.println("5. 게시글 수정");
            System.out.println("0. 종료");
            System.out.print("메뉴를 선택하세요: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // 개행 문자 처리

            switch (choice) {
                case 1:
                    // 게시글 등록
                    System.out.print("게시글 번호를 입력하세요: ");
                    int boNum = scanner.nextInt();
                    scanner.nextLine();  // 개행 문자 처리
                    System.out.print("작성자를 입력하세요: ");
                    String boWriter = scanner.nextLine();
                    System.out.print("제목을 입력하세요: ");
                    String boTitle = scanner.nextLine();
                    System.out.print("내용을 입력하세요: ");
                    String boContent = scanner.nextLine();

                    BoardVO board = new BoardVO(boNum, boWriter, boTitle, boContent);
                    int insertResult = boardService.insertBoard(board);
                    if (insertResult == 1) {
                        System.out.println("게시글이 성공적으로 등록되었습니다.");
                    } else {
                        System.out.println("게시글 등록에 실패하였습니다.");
                    }
                    break;

                case 2:
                    // 모든 게시글 조회
                    BoardVO[] boardList = boardService.getBoardList().toArray(new BoardVO[0]);
                    System.out.println("=== 모든 게시글 ===");
                    for (BoardVO b : boardList) {
                        System.out.println("게시글 번호: " + b.getBoNum() + ", 제목: " + b.getBoTitle() +
                                           ", 작성자: " + b.getBoWriter() + ", 조회수: " + b.getCnt());
                    }
                    break;

                case 3:
                    // 게시글 상세 조회
                    System.out.print("조회할 게시글 번호를 입력하세요: ");
                    int viewNum = scanner.nextInt();
                    BoardVO viewBoard = boardService.getBoard(viewNum);
                    if (viewBoard != null) {
                        System.out.println("게시글 번호: " + viewBoard.getBoNum());
                        System.out.println("제목: " + viewBoard.getBoTitle());
                        System.out.println("작성자: " + viewBoard.getBoWriter());
                        System.out.println("내용: " + viewBoard.getBoContent());
                        System.out.println("조회수: " + viewBoard.getCnt());
                    } else {
                        System.out.println("해당 게시글을 찾을 수 없습니다.");
                    }
                    break;

                case 4:
                    // 게시글 삭제
                    System.out.print("삭제할 게시글 번호를 입력하세요: ");
                    int deleteNum = scanner.nextInt();
                    int deleteResult = boardService.deleteBoard(deleteNum);
                    if (deleteResult == 1) {
                        System.out.println("게시글이 성공적으로 삭제되었습니다.");
                    } else {
                        System.out.println("게시글 삭제에 실패하였습니다.");
                    }
                    break;

                case 5:
                    // 게시글 수정
                    System.out.print("수정할 게시글 번호를 입력하세요: ");
                    int editNum = scanner.nextInt();
                    scanner.nextLine();  // 개행 문자 처리
                    System.out.print("새로운 제목을 입력하세요: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("새로운 내용을 입력하세요: ");
                    String newContent = scanner.nextLine();

                    BoardVO updatedBoard = new BoardVO(editNum, null, newTitle, newContent); // 작성자는 변경하지 않음
                    int updateResult = boardService.updateBoard(updatedBoard);
                    if (updateResult == 1) {
                        System.out.println("게시글이 성공적으로 수정되었습니다.");
                    } else {
                        System.out.println("게시글 수정에 실패하였습니다.");
                    }
                    break;

                case 0:
                    // 프로그램 종료
                    System.out.println("프로그램을 종료합니다.");
                    break;

                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
            }
        } while (choice != 0);

        scanner.close();
    }
}