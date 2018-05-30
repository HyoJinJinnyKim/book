package book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController  {

	@Autowired
	BookServiceImpl bookService;
	

	@RequestMapping("bookList.do")
	public ModelAndView getBookList(){
		List<BookVO> list = bookService.getBookList();
		ModelAndView mav = new ModelAndView();
		mav.addObject("bookList", list);
		mav.setViewName("bookList"); //viewResolver���� /bookList.jsp�� �ٲ��� 
		return mav;
	}
	
	@RequestMapping("detailBook.do")
	public ModelAndView getDetailBook(String seq){
		int seqInt = Integer.parseInt(seq);
		ModelAndView m = new ModelAndView();
		BookVO vo = bookService.getDetailBook(seqInt);
		m.addObject("vo", vo);
		m.setViewName("detailBook");
		return m;
	}
	
	
	
	@RequestMapping("bookSearchList.do")
	public ModelAndView getBookSearchList(BookVO vo){
		
		System.out.println(vo.getBookseq() +"  "+vo.getBookauthor() +"  "+vo.getBookprice() +"  "+vo.getOrderby() );
		
		List<BookVO> list = bookService.getSearchList(vo);

		System.out.println(list.size());
		ModelAndView m = new ModelAndView();
		m.addObject("bookList", list);
		m.setViewName("bookList");
		return m;
	}
	
	@RequestMapping(value="bookInsert.do", method=RequestMethod.GET)
	public String boardWrite(){ //�۾��� �����
		return "bookInsert";
	}
	
	@RequestMapping(value="bookInsert.do", method=RequestMethod.POST)
	public ModelAndView saveBookInsert(BookVO vo) // @RequestParam("uploadFile") MultipartFile uploadFile,
           // MultipartHttpServletRequest request) throws IOException{
	{
		//read File
		ModelAndView m = new ModelAndView();
		InputStream inputStream = null;
/*		
		//file upload
		System.out.println("RewardController reAddProCtrl uploadFile : " + uploadFile);
		
		UtilFile utilFile = new UtilFile();
		
		//      ���� ���ε� ������� path�� �޾ƿ´�(�̹� fileUpload() �޼ҵ忡�� �ش� ��ο� ���ε�� ������)
		String uploadPath = utilFile.fileUpload(request, uploadFile);
		
		//      �ش� ��θ� �޾� db�� ����
		vo.setFilePath(uploadPath);
		
		System.out.println("RewardController reAddProCtrl uploadPath : " + uploadPath);
		*/
//		// ���ϸ� ��������
//				String fileName = request.getParameter("uploadFile");
//				System.out.println(this.getServletContext() );
//				// ��� ��������
//				String saveDir = this.getServletContext().getRealPath("/pj_upload/");
//				File file = new File(saveDir + "/" + fileName);
//				// System.out.println("fileName:"+fileName);
//				// System.out.println("saveDir:"+saveDir);
//
//				// MIME �����ϱ�
//				String mimeType = getServletContext().getMimeType(file.toString());
//				if (mimeType == null) {
//					response.setContentType("application/octet-stream");
//				}
//
//				// �ٿ�ε�� ���ϸ� ����
//				String downName = null;
//				if (request.getHeader("user-agent").indexOf("MSIE") == -1) {
//					downName = new String(fileName.getBytes("UTF-8"), "8859_1");
//				} else {
//					downName = new String(fileName.getBytes("euc-kr"), "8859_1");
//				}
//				// System.out.println("downName:" + downName);
//				// ������ �ٿ�ε��ϵ��� ����
//				response.setHeader("Content-Disposition", "attachment;filename\""
//						+ downName + "\";");
//
//				// ��û�� ������ �о Ŭ���̾�Ʈ������ �����Ѵ�.
//				FileInputStream fileInputStream = new FileInputStream(file);
//				ServletOutputStream servletOutputStream = response.getOutputStream();
//
//				byte b[] = new byte[1024];
//				int data = 0;
//
//				while ((data = (fileInputStream.read(b, 0, b.length))) != -1) {
//					servletOutputStream.write(b, 0, data);
//
//				}
//				servletOutputStream.flush();
//				servletOutputStream.close();
//				fileInputStream.close();
//        try {
//            inputStream = null;//servletContext.getResourceAsStream(uploadPath);
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//            vo.setBooktitle(bufferedReader.readLine());
//            vo.setBookauthor(bufferedReader.readLine());
//            vo.setBookprice(bufferedReader.readLine());
//         
//		} catch (IOException e) {
//			System.out.println("[BookControl] file I/O EXCEPTION!! ");
//			e.printStackTrace();
//		}finally {
//            if (inputStream != null) {
//                inputStream.close();
//             }
//         }
        
		System.out.println( "[BookControl.]::: "+ vo.getBookseq() +"  "+vo.getBookauthor() +"  "+vo.getBookprice() +"  "+vo.getBooktitle() +"  "+ vo.getBookfile()+"  " +vo.getBooktag() );
		vo.setBookauthor("James");
		vo.setBookprice("20");
		vo.setBooktitle("Behind the gate");
		if(bookService.getBookCount() == 0){
			vo.setBookseq(1);
		}else{
			//bring seqNum
			int maxNum = bookService.getMaxBookseq();
			vo.setBookseq(maxNum+1);
		}
		System.out.println(vo.getBookseq() +"  "+vo.getBookauthor() +"  "+vo.getBookprice() +"  "+vo.getBooktitle() +"  "+ vo.getBookfile()+"  " +vo.getBooktag() );
		int success = bookService.saveBookInsert(vo);
		//after success -> show book List
		if(success==1){
//			List<BookVO> list = bookService.getBookList();
//			m.addObject("bookList", list);
			m.addObject("msg", "insert success"); 
			m.addObject("url", "bookList.do"); 
			m.setViewName("redirect");
		}else{
			m.addObject("msg", "insert failed"); 
			m.addObject("url", "bookList.do"); 
			m.setViewName("redirect");
		}
		return m; 
	}
	
	//uuid for file upload
	public static String getUuid() { 
		return UUID.randomUUID().toString().replaceAll("-", ""); 
	}

	
	
	@RequestMapping(value="bookUpdate.do", method=RequestMethod.POST)
	public ModelAndView updateBook(BookVO vo){
		ModelAndView m = new ModelAndView();
		System.out.println(vo.getBookseq() +"  "+vo.getBookauthor() +"  "+vo.getBookprice() +"  "+vo.getBooktitle() +"  "+ vo.getBookfile()+"  " +vo.getBooktag() );
		int result = bookService.updateBook(vo);
		if(result ==1){
			m.addObject("msg", "update success"); 
			m.addObject("url", "bookList.do"); 
		}else{
			m.addObject("msg", "update failed"); 
			m.addObject("url", "detailBook.do?seq="+vo.getBookseq()); 
		}
		m.setViewName("redirect");
		return m;
	}

	@RequestMapping("bookDelete.do")
	public ModelAndView deleteConfirm(int bookseq){
		ModelAndView m = new ModelAndView();
		int result = bookService.deleteBook(bookseq);
		if(result ==1){
			m.addObject("msg", "delete success"); 
			m.addObject("url", "bookList.do"); 
		}else{
			m.addObject("msg", "delete failed"); 
			m.addObject("url", "detailBook.do?seq="+bookseq); 
		}
		m.setViewName("redirect");
		return m;
	}
	
	
	
}
