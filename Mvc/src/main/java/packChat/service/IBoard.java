package packChat.service;

import java.util.List;

import packChat.model.BoardVO;

public interface IBoard {
    int insertBoard(BoardVO board);        // Register a new post
    List<BoardVO> getBoardList();              // Get all posts
    BoardVO getBoard(int boNum);           // View a specific post by post number
    int deleteBoard(int boNum);            // Delete a specific post
    int updateBoard(BoardVO board);        // Update a post
}
