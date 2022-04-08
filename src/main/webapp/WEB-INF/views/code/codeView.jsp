<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="rb" uri="http://www.springframework.org/tags" %>

<form id="formView" name="formView" method="post" action="codeList">
	<input type="hidden" id="thisPage" name="thisPage" value="${vo.thisPage}">
	<input type="hidden" id="shIfcdDelNy" name="shIfcdDelNy" value="${vo.shIfcdDelNy}">
	<input type="hidden" id="shIfcdName" name="shIfcdName" value="${vo.shIfcdName}">
	<input type="submit">
</form>


<c:out value="${rt.ifcdSeq}"/> | <c:out value="${rt.ifcdName}"/> | <c:out value="${rt.ifcdDelNy}"/> <br>
<a href="/infra/resources/uploaded/<c:out value="${rt.ifcdUuidFileName}"/>" download="<c:out value="${rt.ifcdOriginalFileName}"/>">다운로드</a> <a href="/infra/resources/uploaded/<c:out value="${rt.ifcdOriginalFileName}"/>">다운로드2</a><img src = "/infra/resources/uploaded/<c:out value="${rt.ifcdUuidFileName}"/>"> <c:out value="${rt.ifcdOriginalFileName}"/>


<a href="javascript:goList()">목록</a>
<a href="/infra/code/codeForm2?ifcdSeq=<c:out value="${rt.ifcdSeq}"/>">수정</a>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> 

<script type="text/javascript">
	goList = function(){
		$("#formView").attr("action","codeList");
		$("#formView").submit();
	} 
	
</script>