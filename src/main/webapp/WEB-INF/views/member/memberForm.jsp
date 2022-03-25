<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="rb" uri="http://www.springframework.org/tags" %>


<form method="post" action="memberInst">
	<input type="text" name="ifmmId" placeholder="아이디">
	<input type="text" name="ifmmName" placeholder="이름">
	<input type="submit" value="제출">
</form>

<select class="form-select form-select-sm" id="kbmmGenderCd" name="kbmmGenderCd">
	<option value="">::성별::</option>
		<c:forEach items="${codeGender}" var="itemGender" varStatus="statusGender">
			<option value="<c:out value="${itemGender.ifcdSeq}"/>" <c:if test="${item.kbmmGenderCd eq itemGender.ifcdOrder }">selected</c:if> ><c:out value="${itemGender.ifcdName}"/></option>	
		</c:forEach> 
</select>