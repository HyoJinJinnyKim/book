<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">	
<link href="bootstrap/css/jumbotron.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">

<title>Insert title here</title>
</head>
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
	integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
	crossorigin="anonymous"></script>
	<script type="text/javascript">
   window.onload = function() { 
      document.getElementById("bookList").onclick = function() {
         location.href = "bookList.do";
      }
   }
   </script>
<body>
<main role="main">

      <!-- Main jumbotron for a primary marketing message or call to action -->
      <div class="jumbotron">
        <div class="container">
          <h1 class="display-3">Upload your book!</h1>
          <br>
	<form action="bookInsert.do" method=post> <!-- enctype="multipart/form-data" -->
		<div class="container">
			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text">Upload</span>
				</div>
				<div class="custom-file">
					<input type="file" class="custom-file-input"  id="inputGroupFile01" name="bookfile" > <label class="custom-file-label" for="inputGroupFile01">
						Choose your file
					</label>
				</div>
			</div>
			<div class="input-group">
				<div class="input-group-prepend">
					<span class="input-group-text">tag</span>
				</div>
				<textarea class="form-control" aria-label="please write tag here"
					name="booktag"></textarea>
			</div>
		<br><br>
			<button type="submit" class="btn btn-primary btn-lg">add book</button>
			<button type="button" class="btn btn-secondary btn-lg" id="bookList">go back to list</button>
		</div></form>
	</div></div>
	</main>
</body>
</html>