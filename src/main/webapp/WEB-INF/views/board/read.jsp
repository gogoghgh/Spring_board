<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>

<title>views/board/regist.jsp</title>

<h1>
	WEB-INF/views/ <span style="color: white; background-color: skyblue; font-size: 2em">
		 📝📝read✨✨ </span>.jsp
</h1>


<div class="box box-primary">
	<div class="with-border">
		<h1 class="box-title">${vo.bno }번 글 🐱🐶 상세 보기 🐱🐶 </h1>
	</div>
	
		<!-- 수정, 삭제 시 필요한 글 번호(bno) 저장하는 폼태그 =====================-->
		<form role="form" method="post">
			<input type="hidden" name="bno" value="${vo.bno }">
		</form>
		<!-- 수정, 삭제 시 필요한 글 번호(bno) 저장하는 폼태그 껏 =====================-->

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
			<button type="submit" class="btn btn-warning">수정하기</button>
			<button type="submit" class="btn btn-danger">삭제하기</button>
			<button type="button" class="btn btn-success">목록으로</button>
		</div>
</div>

<script type="text/javascript">
// jQuery 구간 시작~ =================================================
	// jQuery 라이브러리는,, 추가 안 해도 되나용? 
	// 넵^^ include된 header 안에 라이브러리 이미 포함되어 있음!!
  $(document).ready(function(){
	  alert('jQuery 실행🎊🎊');
	  // 버턴들 제어할 거!!!!!!!!!!!!
	  
	  // 글번호 정보를 포함하는 폼태그에 접근
	  var fr = $('form[role="form"]'); // role이 form인 폼태그에 접근해서 그걸 fr 변수에 담기
// 	  console.log("@@@@@ fr: " + fr);  // 이러니까 안 나오고
	  console.log(fr);                 // 이러니까 폼태그 정보 나오네~
	  
	  
	  
	  
	  $(".btn-warning").click(function(){
		  alert('정상 동작 중');
		  // 폼태그 속성 바꿀 거!!
		  fr.attr("action", "/board/modify");
		  fr.attr("method", "get");
		  fr.submit();
		  
	  });// 수정 버턴 click
	  
	  
	  $(".btn-success").click(function(){
		  // 목록 버턴 클릭했을 때
		  location.href = "/board/listAll";
	  });// 목록 버턴 click
	  
	  
	  
  });// jQuery ready

</script>

<%@ include file="../include/footer.jsp"%>