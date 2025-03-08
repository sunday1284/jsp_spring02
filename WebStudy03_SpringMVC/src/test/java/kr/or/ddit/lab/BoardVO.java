package kr.or.ddit.lab;

import lombok.Data;

@Data
public class BoardVO {
	 private String seqNo;
	 private String title;
	 private String contents;
	 private String writer;
	 private String createdDate;
	 private String readCnt;
	 
	 public static void main(String[] args) {
		 BoardVO boardVO= new BoardVO();
		 boardVO.setSeqNo("1");
		 boardVO.setTitle("게시판 제목");
		 boardVO.setContents("게시판 내용");
		 boardVO.setCreatedDate("2015-12-25");
		 boardVO.setWriter("작성자");
//		 BeanUtils.copyProperties(noticeVO, boardVO);

		
	}
}
