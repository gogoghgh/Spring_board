<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>

<title>views/board/regist.jsp</title>

<h1>
	WEB-INF/views/ <span style="color: white; background-color: salmon; font-size: 2em">
		🙀🙀 글 수 정🍒🍒 </span>.jsp
</h1>


<div class="box box-primary">
	<div class="with-border">
		<h1 class="box-title">🐱🐶 글 수정하기 페이쥐 🐭🐭  </h1>
	</div>


<!-- 	<form role="form" action="/board/regist" method="post"> 
                          ㄴaction 속성 생략 시, 다시! 자신의 주소를 호출하는 거임~~ 
                          	같은 주소로 가는 거면,, 굳이 안 적어도 ㄱㅊ^^ -->
	<form role="form" method="post">
<!-- 	<form role="form" action="/board/modify" method="post"> -->
	 
		<div class="box-body">
			<div class="form-group">
				<label for="exampleInputEmail1">💖글번호💖 </label> 
					<input
					type="text" class="form-control" id="exampleInputEmail1"
					name="bno" value="${vo.bno}" readonly>
			</div>
			
			<div class="form-group">
				<label for="exampleInputEmail1">💖제목💖 </label> 
					<input
					type="text" class="form-control" id="exampleInputEmail1"
					name="title"
					value="${vo.title}">
			</div>

			<div class="form-group">
				<label for="exampleInputEmail1">💖작성자💖 </label> 
					<input type="text"
					class="form-control" id="exampleInputEmail1"
					name="writer"
					value="${vo.writer}">
			</div>


			<div class="form-group">
				<label>💖내용💖</label>
				<textarea class="form-control" rows="5" name="content">${vo.content}</textarea>
			</div>



			<div class="form-group">
				<label for="exampleInputFile">File input</label> <input type="file"
					id="exampleInputFile">
				<p class="help-block">Example block-level help text here.</p>
			</div>
			
			<div class="checkbox">
				<label> <input type="checkbox"> Check me out
				</label>
			</div>
		</div>

		<div class="box-footer">
			<button type="submit" class="btn btn-primary">글 수정하기</button>
		</div>
	</form>
</div>



<%@ include file="../include/footer.jsp"%>