<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>

<title>views/board/regist.jsp</title>

<h1>
	WEB-INF/views/ <span style="color: white; background-color: skyblue; font-size: 2em">
		 📝📝read✨✨ </span>.jsp
</h1>


<div class="box box-primary">
	<div class="box-header with-border">
		<h3 class="box-title">${vo.bno }번 글 🐱🐶 본문 🐱🐶 </h3>
	</div>


		<div class="box-body">
			<div class="form-group">
				<label for="exampleInputEmail1">💖제목💖 </label> 
					<input
					type="text" class="form-control" id="exampleInputEmail1"
					name="title"
					value="${vo.title }" readonly>
			</div>

			<div class="form-group">
				<label for="exampleInputEmail1">💖작성자💖 </label> 
					<input type="text"
					class="form-control" id="exampleInputEmail1"
					name="writer"
					value="${vo.writer }" readonly>
			</div>


			<div class="form-group">
				<label>💖내용💖</label>
				<textarea class="form-control" rows="5" name="content" readonly>${vo.content }</textarea>
			</div>



			<div class="form-group">
				<label for="exampleInputFile">File inpu
				t</label> <input type="file"
					id="exampleInputFile">
				<p class="help-block">Example block-level help text here.</p>
			</div>
			
			<div class="checkbox">
				<label> <input type="checkbox"> Check me out
				</label>
			</div>
		</div>


		<div class="box-footer">
			<button type="submit" class="btn btn-primary">글쓰기</button>
		</div>
</div>



<%@ include file="../include/footer.jsp"%>