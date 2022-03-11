<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="rb" uri="http://www.springframework.org/tags" %>

<form id="" name="" method="get" action="codeList">
<select name="shIfcdDelNy">
	<option value="2">::삭제여부::
	<option value="1">Y
	<option value="0">N
</select>
<select name="shIfcgSeq">
	<option value="">::코드그룹::
	<c:forEach items="${list2}" var="item" varStatus="status">
		<option value="${item.ifcgSeq}" <c:if test="${param.shIfcgSeq eq item.ifcgSeq}">selected</c:if>> <c:out value="${item.ifcgName}"/></option>
	</c:forEach>
</select>

회원이름 : <input type="text" name="shIfcdName">
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
		
		<c:out value="${item.ifcdSeq}"/> | <a href="/infra/code/codeView?ifcdSeq=${item.ifcdSeq}"><c:out value="${item.ifcdName}"/></a> | <c:out value="${item.ifcgName}"/> | <c:out value="${item.ifcdDelNy}"/> <br>
		
		</c:forEach>
	</c:otherwise>
</c:choose>	 
</form>