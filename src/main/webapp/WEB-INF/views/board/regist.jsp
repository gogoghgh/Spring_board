<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>

<title>views/board/regist.jsp</title>

<h1>
	WEB-INF/views/ <span style="color: white; background-color: skyblue; font-size: 2em">
		ππκΈμ°κΈ°β¨β¨ </span>.jsp
</h1>


<div class="box box-primary">
	<div class="box-header with-border">
		<h3 class="box-title">π±πΆκ°νμ€λ€ κ²μνπ±πΆ </h3>
	</div>


<!-- 	<form role="form" action="/board/regist" method="post"> 
                          γ΄action μμ± μλ΅ μ, λ€μ! μμ μ μ£Όμλ₯Ό νΈμΆνλ κ±°μ~~ 
                          	κ°μ μ£Όμλ‘ κ°λ κ±°λ©΄,, κ΅³μ΄ μ μ μ΄λ γ±γ^^ -->
	<form role="form"  method="post"> 
		<div class="box-body">
			<div class="form-group">
				<label for="exampleInputEmail1">πμ λͺ©π </label> 
					<input
					type="text" class="form-control" id="exampleInputEmail1"
					name="title"
					placeholder="μ λͺ©μ μλ ₯ν΄μ£ΌμΈμ μ λ°,,">
			</div>

			<div class="form-group">
				<label for="exampleInputEmail1">πμμ±μπ </label> 
					<input type="text"
					class="form-control" id="exampleInputEmail1"
					name="writer"
					placeholder="μ΄λ¦μ μλ ₯ν΄μ£ΌμΈμ μ λ°,,">
			</div>


			<div class="form-group">
				<label>πλ΄μ©π</label>
				<textarea class="form-control" rows="5" placeholder="μ±μκΈ λΆνλ€λ¦Ό^_^"
							name="content"></textarea>
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
			<button type="submit" class="btn btn-primary">κΈμ°κΈ°</button>
		</div>
	</form>
</div>



<%@ include file="../include/footer.jsp"%>