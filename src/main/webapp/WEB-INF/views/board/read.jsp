<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>

<title>views/board/regist.jsp</title>

<h1>
	WEB-INF/views/ <span style="color: white; background-color: skyblue; font-size: 2em">
		 ππreadβ¨β¨ </span>.jsp
</h1>


<div class="box box-primary">
	<div class="with-border">
		<h1 class="box-title">${vo.bno }λ² κΈ π±πΆ μμΈ λ³΄κΈ° π±πΆ </h1>
	</div>
	
		<!-- μμ , μ­μ  μ νμν κΈ λ²νΈ(bno) μ μ₯νλ νΌνκ·Έ =====================-->
		<form role="form" method="post">
			<input type="hidden" name="bno" value="${vo.bno }">
		</form>
		<!-- μμ , μ­μ  μ νμν κΈ λ²νΈ(bno) μ μ₯νλ νΌνκ·Έ κ» =====================-->

		<div class="box-body">
			<div class="form-group">
				<label for="exampleInputEmail1">πμ λͺ©π </label> 
					<input
					type="text" class="form-control" id="exampleInputEmail1"
					name="title"
					value="${vo.title }" readonly>
			</div>

			<div class="form-group">
				<label for="exampleInputEmail1">πμμ±μπ </label> 
					<input type="text"
					class="form-control" id="exampleInputEmail1"
					name="writer"
					value="${vo.writer }" readonly>
			</div>


			<div class="form-group">
				<label>πλ΄μ©π</label>
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
			<button type="submit" class="btn btn-warning">μμ νκΈ°</button>
			<button type="submit" class="btn btn-danger">μ­μ νκΈ°</button>
			<button type="button" class="btn btn-success">λͺ©λ‘μΌλ‘</button>
		</div>
</div>

<script type="text/javascript">
// jQuery κ΅¬κ° μμ~ =================================================
	// jQuery λΌμ΄λΈλ¬λ¦¬λ,, μΆκ° μ ν΄λ λλμ©? 
	// λ΅^^ includeλ header μμ λΌμ΄λΈλ¬λ¦¬ μ΄λ―Έ ν¬ν¨λμ΄ μμ!!
  $(document).ready(function(){
// 	  alert('jQuery μ€νππ');
	  // λ²ν΄λ€ μ μ΄ν  κ±°!!!!!!!!!!!!
	  
	  // κΈλ²νΈ μ λ³΄λ₯Ό ν¬ν¨νλ νΌνκ·Έμ μ κ·Ό
	  var fr = $('form[role="form"]'); // roleμ΄ formμΈ νΌνκ·Έμ μ κ·Όν΄μ κ·Έκ±Έ fr λ³μμ λ΄κΈ°
// 	  console.log("@@@@@ fr: " + fr);  // μ΄λ¬λκΉ μ λμ€κ³ 
	  console.log(fr);                 // μ΄λ¬λκΉ νΌνκ·Έ μ λ³΄ λμ€λ€~
	  
	  
	  
	  
	  $(".btn-warning").click(function(){
		  alert('μ μ λμ μ€');
		  // νΌνκ·Έ μμ± λ°κΏ κ±°!!
		  fr.attr("action", "/board/modify");
		  fr.attr("method", "get"); // getλ°©μμΌλ‘ λ°κΏμ μ λ¬ 
		  fr.submit(); // ν΄λ¦­νλ©΄? μμ± λ°κΎΈκ³  -> submit λκ²~~
	  });// μμ  λ²ν΄ click
	  
	  
	  $(".btn-success").click(function(){
		  // λͺ©λ‘ λ²ν΄ ν΄λ¦­νμ λ
		  location.href = "/board/listPage?page=${page}";
	  });// λͺ©λ‘ λ²ν΄ click
	  
	  
	  $(".btn-danger").click(function(){
		  // μ­μ  λ²ν΄ ν΄λ¦­νμ λ~~
		  alert('μ­μ  λ²ν΄ ν΄λ¦­λ¨');
		  fr.attr("action", "/board/remove");
		  fr.submit(); // ν΄λ¦­νλ©΄? μμ± λ°κΎΈκ³  -> submit λκ²~~
		  
	  });// μ­μ  λ²νΌ click
	  
	  
	  
  });// jQuery ready

</script>

<%@ include file="../include/footer.jsp"%>