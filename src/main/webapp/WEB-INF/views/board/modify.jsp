<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>

<title>views/board/regist.jsp</title>

<h1>
	WEB-INF/views/ <span style="color: white; background-color: salmon; font-size: 2em">
		ππ κΈ μ μ ππ </span>.jsp
</h1>


<div class="box box-primary">
	<div class="with-border">
		<h1 class="box-title">π±πΆ κΈ μμ νκΈ° νμ΄μ₯ π­π­  </h1>
	</div>


<!-- 	<form role="form" action="/board/regist" method="post"> 
                          γ΄action μμ± μλ΅ μ, λ€μ! μμ μ μ£Όμλ₯Ό νΈμΆνλ κ±°μ~~ 
                          	κ°μ μ£Όμλ‘ κ°λ κ±°λ©΄,, κ΅³μ΄ μ μ μ΄λ γ±γ^^ -->
	<form role="form" method="post">
<!-- 	<form role="form" action="/board/modify" method="post"> -->
	 
		<div class="box-body">
			<div class="form-group">
				<label for="exampleInputEmail1">πκΈλ²νΈπ </label> 
					<input
					type="text" class="form-control" id="exampleInputEmail1"
					name="bno" value="${vo.bno}" readonly>
			</div>
			
			<div class="form-group">
				<label for="exampleInputEmail1">πμ λͺ©π </label> 
					<input
					type="text" class="form-control" id="exampleInputEmail1"
					name="title"
					value="${vo.title}">
			</div>

			<div class="form-group">
				<label for="exampleInputEmail1">πμμ±μπ </label> 
					<input type="text"
					class="form-control" id="exampleInputEmail1"
					name="writer"
					value="${vo.writer}">
			</div>


			<div class="form-group">
				<label>πλ΄μ©π</label>
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
			<button type="submit" class="btn btn-primary">κΈ μμ νκΈ°</button>
		</div>
	</form>
</div>



<%@ include file="../include/footer.jsp"%>