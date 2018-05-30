<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">	
<link href="bootstrap/css/jumbotron.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>게시글 상세페이지</title>
<script type="text/javascript">
   window.onload = function() { 
      document.getElementById("bookList").onclick = function() {
         location.href = "bookList.do";
      }
      document.getElementById("bookDelete").onclick = function() {
         location.href = "bookDelete.do?bookseq="+${vo.bookseq};
      }
   }
</script>
</head>
<body>
<main role="main">

      <!-- Main jumbotron for a primary marketing message or call to action -->
      <div class="jumbotron">
        <div class="container">
			         
			<form action="bookUpdate.do" method=post>
			  <div class="form-group row">
			    <label for="staticEmail" class="col-sm-2 col-form-label">Number</label>
			    <div class="col-sm-10">
			      <input type="text"  name="bookseq" readonly class="form-control-plaintext" id="staticEmail" value="${vo.bookseq }">
			    </div>
			  </div>
			  <div class="form-group row">
			    <label for="staticEmail" class="col-sm-2 col-form-label">Author</label>
			    <div class="col-sm-10">
			      <input type="text" name="bookauthor" readonly class="form-control-plaintext" id="staticEmail" value="${vo.bookauthor }">
			    </div>
			  </div>
			  <div class="form-group row">
			    <label for="staticEmail" class="col-sm-2 col-form-label">Title</label>
			    <div class="col-sm-10">
			      <input type="text" name="booktitle" readonly class="form-control-plaintext" id="staticEmail" value="${vo.booktitle }">
			    </div>
			  </div>
			  <div class="form-group row">
			    <label for="staticEmail" class="col-sm-2 col-form-label">Date</label>
			    <div class="col-sm-10">
			      <input type="text" name="booktime" readonly class="form-control-plaintext" id="staticEmail" value="${vo.booktime }">
			    </div>
			  </div>
			  <div class="form-group row">
			    <label for="inputPassword" class="col-sm-2 col-form-label">Tag</label>
			    <div class="col-sm-10">
			      <input type="text" name="booktag" class="form-control" id="inputPassword" value="${vo.booktag}">
			    </div>
        	</div>
			<div align=center>
				<button type="button" class="btn btn-outline-primary" id="bookList" value="List">List</button>
				<input type="submit" class="btn btn-outline-secondary" id="bookUpdate" value="Update"/>
				<button type="button" class="btn btn-outline-success" id="bookDelete" value="Delete">Delete</button>
        	</div>
			</form>
	  </div>
      </div>
      </main>

</body>
</html>