package book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bookService")
public class BookServiceImpl implements BookService {
 

	@Autowired
	BookDAO bookDAO;
	//XML<bean> or @component, Service, Controller중 같은 이름인거 가져와 => autowired
	
	
	@Override
	public List<BookVO> getBookList() {
		List<BookVO> list = bookDAO.getBookList();
		return list;
	}

	@Override
	public BookVO getDetailBook(int seq) {
		BookVO vo = bookDAO.getDetailBook(seq);
		return vo;
	}

	@Override
	public int getBookCount() {
		int count = bookDAO.getBookCount();
		return count;
	}

	@Override
	public List<BookVO> getSearchList(BookVO vo) {
		List<BookVO> list = bookDAO.getSearchList(vo);
		return list;
	}


	@Override
	public int saveBookInsert(BookVO vo) {
		return bookDAO.saveBookInsert(vo);
	}

	
	@Override
	public int updateBook(BookVO vo) {
		return bookDAO.updateBook(vo);
	}

	@Override
	public int getMaxBookseq() {
		return bookDAO.getMaxBookseq();
	}

	@Override
	public int deleteBook(int bookseq) {
		return bookDAO.deleteBook(bookseq);
	}

}
