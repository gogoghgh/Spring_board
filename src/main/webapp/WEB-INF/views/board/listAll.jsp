<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../include/header.jsp"%>

<h1>
	WEB-INF/views/ <span
		style="color: white; background-color: orange; font-size: 2em">
		💐💐listAll😎😎 </span>.jsp
</h1>
<div class="box">
	<div class="box-header with-border">
		<h3 class="box-title">💩💩 ~~ 가현스 게시판 ~~ 🧸🧸</h3>
		<h3>EL{msg} : ${msg }</h3>
<%-- 		<h3>EL{boardList} : ${boardList }</h3> --%>
	</div>

	<div class="box-body">
		<table class="table table-bordered">
			<tbody>
				<tr>
					<th style="width: 45px">번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th style="width: 60px">조회수</th>
				</tr>
				
				
				<c:forEach var="vo" items="${boardList }">
				
					<tr>
						<td><span class="badge bg-yellow">${vo.bno}</span></td>
						<%-- <td> <span style="font-weight: bold;">제목: </span> ${vo.title} 
							🐱🐱  
							<span style="font-weight: bold;"> 내용: </span> ${vo.content }  </td>  --%>
						<td> <a href="/board/read?bno=${vo.bno }">${vo.title }</a> </td>
						<td>${vo.writer }</td>
						<td> <fmt:formatDate value="${vo.regdate }" pattern="YYYY년 MM월 dd일 🌈  HH:mm" /> </td>
						<td>${vo.viewcnt }</td>
					</tr>
				
				</c:forEach>
				
				
				
			</tbody>
		</table>
	</div>

	<div class="box-footer clearfix">
		<ul class="pagination pagination-sm no-margin pull-right">
			<li><a href="#">«</a></li>
			<li><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">»</a></li>
		</ul>
	</div>
</div>


<script type="text/javascript">
	// alert(${msg});
	var result = "${msg}";
	
	if(result == "OK") {
		alert("글쓰기 완료^^ 감사합ㄴ디ㅏ 🥰🥰");
	}
</script>




<%@ include file="../include/footer.jsp"%>