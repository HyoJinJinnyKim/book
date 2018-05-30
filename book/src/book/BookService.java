package book;

import java.util.List;

public interface BookService {
	
	public List<BookVO> getBookList();
	public BookVO getDetailBook(int seq);
	public int getBookCount(); //게시물총수
	public List<BookVO> getSearchList(BookVO vo); //검색게시물
	
	public int saveBookInsert(BookVO vo); //글삽입
	public int getMaxBookseq(); //글번호 최대값
	public int deleteBook(int boardseq);//글삭제
	public int updateBook(BookVO vo); //글수정
}
