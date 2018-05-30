package book;

import java.util.List;

public interface BookService {
	
	public List<BookVO> getBookList();
	public BookVO getDetailBook(int seq);
	public int getBookCount(); //�Խù��Ѽ�
	public List<BookVO> getSearchList(BookVO vo); //�˻��Խù�
	
	public int saveBookInsert(BookVO vo); //�ۻ���
	public int getMaxBookseq(); //�۹�ȣ �ִ밪
	public int deleteBook(int boardseq);//�ۻ���
	public int updateBook(BookVO vo); //�ۼ���
}
