package packChat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import packChat.model.BoardVO;
import packChat.repository.BoardRespository;

@Service
public class BoardService implements IBoard {

    private final BoardRespository boardRepository;

    @Autowired
    public BoardService(BoardRespository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public int insertBoard(BoardVO board) {
        return boardRepository.insertBoard(board);
    }

    @Override
    public List<BoardVO> getBoardList() {
        return boardRepository.getBoardList();
    }

    @Override
    public BoardVO getBoard(int boNum) {
        return boardRepository.getBoard(boNum);
    }

    @Override
    public int deleteBoard(int boNum) {
        return boardRepository.deleteBoard(boNum);
    }

    @Override
    public int updateBoard(BoardVO board) {
        return boardRepository.updateBoard(board);
    }
}