package packChat.repository;

import packChat.model.BoardVO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class BoardRespository {
    private final List<BoardVO> boardList = new ArrayList<>();

    public int insertBoard(BoardVO board) {
        if (board != null) {
            boardList.add(board);
            return 1;
        }
        return 0;
    }

    public List<BoardVO> getBoardList() {
        return new ArrayList<>(boardList);
    }

    public BoardVO getBoard(int boNum) {
        for (BoardVO board : boardList) {
            if (board.getBoNum() == boNum) {
                board.increaseViewCount();
                return board;
            }
        }
        return null;
    }

    public int deleteBoard(int boNum) {
        for (BoardVO board : boardList) {
            if (board.getBoNum() == boNum) {
                boardList.remove(board);
                return 1;
            }
        }
        return 0;
    }

    public int updateBoard(BoardVO updatedBoard) {
        for (BoardVO board : boardList) {
            if (board.getBoNum() == updatedBoard.getBoNum()) {
                board.setBoTitle(updatedBoard.getBoTitle());
                board.setBoContent(updatedBoard.getBoContent());
                return 1;
            }
        }
        return 0;
    }
}