<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="rb" uri="http://www.springframework.org/tags" %>


<c:out value="${rt.ifcgSeq}"/> | <c:out value="${rt.ifcgName}"/> | <c:out value="${rt.ifcgDelNy}"/> <br>

<a href="codeGroupList?thisPage=${vo.thisPage}&shOption=${vo.shOption}&shValue=${vo.shValue}">목록</a>
<a href="/infra/code/codeGroupForm2?ifcgSeq=<c:out value="${rt.ifcgSeq}&thisPage=${vo.thisPage}&shOption=${vo.shOption}&shValue=${vo.shValue}"/>">수정</a>
<a href="/infra/code/codeGroupDelY?ifcgSeq=<c:out value="${rt.ifcgSeq}&thisPage=${vo.thisPage}&shOption=${vo.shOption}&shValue=${vo.shValue}"/>" id="btnDelete">삭제(DB삭제)</a>
<a href="/infra/code/codeGroupDelN?ifcgSeq=<c:out value="${rt.ifcgSeq}&thisPage=${vo.thisPage}&shOption=${vo.shOption}&shValue=${vo.shValue}"/>" id="btnUpateDel">삭제(delNY 수정)</a>

<%-- <form method="post" action="codeGroupUpdt">
	<input type="text" name="ifcgSeq" value="${rt.ifcgSeq}" style="visibility:hidden;">
	<input type="text" name="ifcgChangeName" placeholder="바꿀NAME">
	<input type="submit" value="제출">
</form> --%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> 
<script src="/infra/resources/js/validation.js"></script>

<script type="text/javascript">
	$("#btnDelete").on("click", function(){
		var num = confirm("진짜 삭제 하시겠습니까?");
		
		if(num){
			
		} else {
			return false;
		}
	})
	
	$("#btnUpateDel").on("click", function(){
		var num = confirm("삭제 하시겠습니까?");
		
		if(num){
			
		} else {
			return false;
		}
	})
	
</script>
