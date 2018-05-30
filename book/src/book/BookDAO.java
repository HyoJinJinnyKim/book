package book;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookDAO {
	
	//sqlSEssion = SqlSessionTemplate  (형변환 규칙에 의하여 ), book-servlet에 선언된 template bean을 알아서 sqlsession에 대입해라! 라는 명령=>autowired 
	@Autowired
	SqlSession sqlSession;
	
	//
	public List<BookVO> getBookList(){
		List<BookVO> list = sqlSession.selectList("book.all");
		return list;
	}
	
	public BookVO getDetailBook(int seq){
		BookVO vo = sqlSession.selectOne("book.one", seq);
		return vo;
	}
	
	public int getBookCount(){
		//book.bookCont int 
		int countresult = sqlSession.selectOne("book.bookCount");
		return countresult;
	}

	public List<BookVO> getSearchList(BookVO vo){
		System.out.println(vo.getOrderby() + " " + vo.getBookprice());
		return sqlSession.selectList("book.bookSearch",  vo);
	}
	
	public int getBookSearchCount(String search){
		int bookSearchCount= sqlSession.selectOne("book.bookSearchCount", "%"+search+"%");
		return bookSearchCount;
	}
	
	//현재 bookseq 최대값 알아오기
	public int getMaxBookseq(){
		int maxNum = sqlSession.selectOne("book.maxBookseq");
		return maxNum;
	}
	//글쓰기
	public int saveBookInsert(BookVO vo){
		return sqlSession.insert("book.insertBook", vo);
	}
	//삭제
	public int deleteBook(int bookseq){
		return sqlSession.delete("book.deleteBook", bookseq);
	}
	
	//글수정 완료
	public int updateBook(BookVO vo){
		int result = sqlSession.update("updateBook", vo);
		return result;
	}
	
	public int writeBookReply(BookVO vo){
		int max = sqlSession.selectOne("maxBookseq");
		System.out.println(max);
		vo.setBookseq(max+1);
		return sqlSession.insert("bookReplyInsert", vo);
	}
}