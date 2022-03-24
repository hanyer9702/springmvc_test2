<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="rb" uri="http://www.springframework.org/tags" %>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<form id="formList" name="formList" method="post" action="codeList">
<input type="hidden" id="thisPage" name="thisPage" value="<c:out value="${vo.thisPage}" default="1"/>">
<input type="hidden" id="ifcdSeq" name="ifcdSeq">


<select name="shIfcdDelNy">
	<option value="2">::삭제여부:: 
	<option value="1" <c:if test="${vo.shIfcdDelNy eq 1}">selected</c:if>>Y
	<option value="0" <c:if test="${vo.shIfcdDelNy eq 0}">selected</c:if>>N 
</select>
<select name="shIfcgSeq">
	<option value="">::코드그룹::
	<c:forEach items="${list2}" var="item" varStatus="status">
		<option value="${item.ifcgSeq}" <c:if test="${param.shIfcgSeq eq item.ifcgSeq}">selected</c:if>> <c:out value="${item.ifcgName}"/></option>
	</c:forEach>
</select>

회원이름 : <input type="text" name="shIfcdName" <c:if test="${vo.shIfcdName ne null}">value="${vo.shIfcdName}"</c:if>>
<input type="submit" name="search">

<br>
<c:choose>
	<c:when test="${fn:length(list) eq 0}">
		<tr>
			<td class="text-center" colspan="9">There is no data!</td>
		</tr>	
	</c:when>
	<c:otherwise>
		<c:forEach items="${list}" var="item" varStatus="status">	
		
		<c:out value="${item.ifcdSeq}"/> | <a href="javascript:goForm(${item.ifcdSeq})"><c:out value="${item.ifcdName}"/></a> | <c:out value="${item.ifcgName}"/> | <c:out value="${item.ifcdDelNy}"/> <br>
		
		</c:forEach>
	</c:otherwise>
</c:choose>	 
</form>

<%-- <nav aria-label="...">
  <ul class="pagination">
    <c:if test="${vo.startPage gt vo.pageNumToShow}">
		<li class="page-item"><a class="page-link" href="/infra/code/codeList?thisPage=${vo.startPage - 1}&shOption=${vo.shOption}&shValue=${vo.shValue}">Previous</a></li>
	</c:if>
	<c:forEach begin="${vo.startPage}" end="${vo.endPage}" varStatus="i">
		<c:choose>
			<c:when test="${i.index eq vo.thisPage}">
	                <li class="page-item active"><a class="page-link" href="/infra/code/codeList?thisPage=${i.index}&shOption=${vo.shOption}&shValue=${vo.shValue}">${i.index}</a></li>
			</c:when>
			<c:otherwise>             
	                <li class="page-item"><a class="page-link" href="/infra/code/codeList?thisPage=${i.index}&shOption=${vo.shOption}&shValue=${vo.shValue}">${i.index}</a></li>
			</c:otherwise>
		</c:choose>
	</c:forEach>      
	<c:if test="${vo.endPage ne vo.totalPages}">                
	                <li class="page-item"><a class="page-link" href="/infra/code/codeList?thisPage=${vo.endPage + 1}&shOption=${vo.shOption}&shValue=${vo.shValue}">Next</a></li>
	</c:if>
  </ul>
</nav>  --%>

<nav aria-label="...">
  <ul class="pagination">
    <c:if test="${vo.startPage gt vo.pageNumToShow}">
		<li class="page-item"><a class="page-link" href="javascript:goList(${vo.startPage - 1})">Previous</a></li>
	</c:if>
	<c:forEach begin="${vo.startPage}" end="${vo.endPage}" varStatus="i">
		<c:choose>
			<c:when test="${i.index eq vo.thisPage}">
	                <li class="page-item active"><a class="page-link" href="javascript:goList(${i.index})">${i.index}</a></li>
			</c:when>
			<c:otherwise>             
	                <li class="page-item"><a class="page-link" href="javascript:goList(${i.index})">${i.index}</a></li>
			</c:otherwise>
		</c:choose>
	</c:forEach>      
	<c:if test="${vo.endPage ne vo.totalPages}">                
	                <li class="page-item"><a class="page-link" href="javascript:goList(${vo.endPage + 1})">Next</a></li>
	</c:if>
  </ul>
</nav> 
 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> 

<script type="text/javascript">
	goList = function(seq){
		$("#thisPage").val(seq);
		$("#formList").submit();
	} 
	
	goForm = function(seq){
		$("#ifcdSeq").val(seq);
		$("#formList").attr("action","codeView");
		$("#formList").submit();
	} 
</script>