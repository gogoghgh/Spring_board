<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../include/header.jsp"%>

<h1>
	WEB-INF/views/ <span
		style="color: white; background-color: pink; font-size: 2em">
		๐๐listAll๐๐ </span>.jsp
</h1>
<div class="box">
	<div class="with-border">
		<h3 class="box-title">๐ฉ๐ฉ ~~ ๊ฐํ์ค ๊ฒ์ํ ~~ ๐งธ๐งธ</h3>
		<h3>EL{msg} : ${msg }</h3>
		<h3>ํ์ด์ง ์ฒ๋ฆฌ ํ๋จ๋ถ ๊ณ์ฐํ  ๋ ํ์ํ ์ ๋ค ๊ฐ์ง๊ณ  ์๋ ๊ฐ์ฒด PageMaker.. โ  </h3>
				<h4>${pm }</h4>
		<h3><a href="/board/regist">์ฌ๊ธฐ๋ฅผ ๋๋ฌ์ ํธํ๊ฒ ๊ธ์ฐ๊ธฐ ํ์ญ์์ค ^^๐๐ </a></h3>
<%-- 		<h3>EL{boardList} : ${boardList }</h3> --%>
	</div>

	<div class="box-body">
		<table class="table table-bordered">
			<tbody>
				<tr>
					<th style="width: 45px">๋ฒํธ</th>
					<th>์ ๋ชฉ</th>
					<th>์์ฑ์</th>
					<th>์์ฑ์ผ</th>
					<th style="width: 60px">์กฐํ์</th>
				</tr>
				
				
				<c:forEach var="vo" items="${boardList }">
				
					<tr>
						<td><span class="badge bg-blue">${vo.bno}</span></td>
						<%-- <td> <span style="font-weight: bold;">์ ๋ชฉ: </span> ${vo.title} 
							๐ฑ๐ฑ  
							<span style="font-weight: bold;"> ๋ด์ฉ: </span> ${vo.content }  </td>  --%>
						<td> <a href="/board/read?bno=${vo.bno }">${vo.title }</a> </td>
						<td>${vo.writer }</td>
						<td> <fmt:formatDate value="${vo.regdate }" pattern="YYYY๋ MM์ dd์ผ ๐  HH:mm" /> </td>
						<td>${vo.viewcnt }</td>
					</tr>
				
				</c:forEach>
				
				
				
			</tbody>
		</table>
	</div>

	<!-- ===================== ํ์ด์ง ์ฒ๋ฆฌ ๊ตฌ๊ฐ ========================== -->
	<div class="box-footer clearfix">
		<ul class="pagination pagination-sm no-margin pull-right">
			
			<!-- ์ด์  ๋ฒํด================ -->
			<c:if test="${pm.prev }"> 
					<!--      ใดboolean ํ์์ด๋๊น false๋ฉด ๊ฑ ํจ์ค๋๋๊ฑฐ~ ์ ํธํ๊ตฐ  -->
				<li><a href="listPage?page=${pm.startPage - 1 }">&laquo;</a></li>
			</c:if>
			
			<!-- 1 2 3 4 .... ================ -->
			<c:forEach var="index" begin="${pm.startPage }" end="${pm.endPage }"> 
						<!-- ํ์ด์ง ๋ธ๋ญ์์ ๋ด๊ฐ ์ ํํ ํ์ฌ ํ์ด์ง๋ง! active๋๋๋ก -->
				<%-- 
				<li <c:out value="${pm.vo.page == index? 'class=active' : '' }" />>   2.3๋ฒ์  ์ดํ๋ c:out ์จ์ผ ํจ~ --%>
				<li ${pm.vo.page == index? 'class=active' : '' } >
					<a href="listPage?page=${index }">${index}</a>
				</li>
			</c:forEach>
			
			<!-- ๋ค์ ๋ฒํด================ -->
			<c:if test="${pm.next }">
				<li><a href="listPage?page=${pm.endPage + 1 }">&raquo;</a></li>
			</c:if>
		</ul>
	</div>
	<!-- ===================== ํ์ด์ง ์ฒ๋ฆฌ ๊ตฌ๊ฐ ========================== -->
</div>


<script type="text/javascript">
	// alert(${msg});
	var result = "${msg}";
	
	if(result == "OK") {
		alert("๊ธ์ฐ๊ธฐ ์๋ฃ^^ ๊ฐ์ฌํฉใด๋ใ ๐ฅฐ๐ฅฐ");
	}
	
	if(result == "MOD_OK"){
		alert("๊ธ ์์  ์ ๐ฅฐ");
	}
	
	if(result == "DEL_OK"){
		alert("๊ธ ์ญ์  ์ ๐ฅฐ");
	}
</script>

<%@ include file="../include/footer.jsp"%>