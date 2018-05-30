package book;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookDAO {
	
	//sqlSEssion = SqlSessionTemplate  (����ȯ ��Ģ�� ���Ͽ� ), book-servlet�� ����� template bean�� �˾Ƽ� sqlsession�� �����ض�! ��� ���=>autowired 
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
	
	//���� bookseq �ִ밪 �˾ƿ���
	public int getMaxBookseq(){
		int maxNum = sqlSession.selectOne("book.maxBookseq");
		return maxNum;
	}
	//�۾���
	public int saveBookInsert(BookVO vo){
		return sqlSession.insert("book.insertBook", vo);
	}
	//����
	public int deleteBook(int bookseq){
		return sqlSession.delete("book.deleteBook", bookseq);
	}
	
	//�ۼ��� �Ϸ�
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