package book;

public class BookVO {
	private int bookseq;
	private String bookfile;
	private String booktitle;
	private String bookauthor;
	private String bookprice;
	private String booktag;
	private String booktime;
	private String orderby;
	private String filePath;
	
	
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getOrderby() {
		return orderby;
	}
	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}
	public String getBookfile() {
		return bookfile;
	}
	public void setBookfile(String bookfile) {
		this.bookfile = bookfile;
	}
	private int bookviewcount;
	
	
	public int getBookseq() {
		return bookseq;
	}
	public void setBookseq(int bookseq) {
		this.bookseq = bookseq;
	}
	public String getBooktitle() {
		return booktitle;
	}
	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}
	public String getBookauthor() {
		return bookauthor;
	}
	public void setBookauthor(String bookauthor) {
		this.bookauthor = bookauthor;
	}
	public String getBookprice() {
		return bookprice;
	}
	public void setBookprice(String bookprice) {
		this.bookprice = bookprice;
	}
	public String getBooktag() {
		return booktag;
	}
	public void setBooktag(String booktag) {
		this.booktag = booktag;
	}
	public String getBooktime() {
		return booktime;
	}
	public void setBooktime(String booktime) {
		this.booktime = booktime;
	}
	public int getBookviewcount() {
		return bookviewcount;
	}
	public void setBookviewcount(int boardviewcount) {
		this.bookviewcount = boardviewcount;
	}


}
