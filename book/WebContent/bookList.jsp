<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">	
<link href="bootstrap/css/jumbotron.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<script type="text/javascript">
   window.onload = function() { 
      document.getElementById("searchBtn").onclick = function() {
         location.href = "bookSearchList.do?orderby="+document.getElementById("orderby").value+"&bookprice="+document.getElementById("bookprice").value;
      }
   }
</script>
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
      <a class="navbar-brand" href="#">BookStore</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="bookInsert.do" role=button>Upload your Book <span class="sr-only">(current)</span></a>
          </li>
        </ul>
      </div>
    </nav>
 <main role="main">

      <!-- Main jumbotron for a primary marketing message or call to action -->
      <div class="jumbotron">
        <div class="container">
          <h1 class="display-3">welcome to bookstore</h1>
          <p>filter list by tag, date, or price </p>
				<div align=center>
				List order by : 
				<select name="orderby" id="orderby">
					<option value="bookseq">-select-</option>
					<option value="booktag">tag (A->Z)</option>
					<option value="booktime">latest date</option>
				</select> &nbsp &nbsp &nbsp
				Price Limit: <select name="bookprice" id="bookprice">
					<option value="1000">-select-</option>
					<option value="10">10</option>
					<option value="20">20</option>
					<option value="30">30</option>
					<option value="40">40</option>
				</select>   &nbsp &nbsp &nbsp <a class="btn btn-outline-success my-2 my-sm-0" id="searchBtn"  role="button">Search </a>
				</div> <br>
        </div>
      </div>

      <div class="container">
        <!-- Example row of columns -->
        <div class="row">
	        <c:forEach items="${bookList}" var="bookVO">
	          <div class="col-md-4">
	           	<h2>${bookVO.bookfile }</h2>
				<p>${bookVO.booktag }</p>
				<p>${bookVO.booktime }</p>
				<p><a class="btn btn-secondary" href="detailBook.do?seq=${bookVO.bookseq}" role="button">View details </a></p>
	          </div>
			</c:forEach>
		</div>

        <hr>

      </div> <!-- /container -->

    </main>
	
	
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>