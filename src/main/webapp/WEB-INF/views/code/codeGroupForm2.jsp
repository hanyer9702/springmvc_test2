<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="rb" uri="http://www.springframework.org/tags" %>

<form method="post" action="codeGroupUpdt2">
	<input type="hidden" name="ifcgSeq" value="<c:out value="${rt.ifcgSeq}"/>">
	<input type="text" name="ifcgName" placeholder="아이디" value="<c:out value="${rt.ifcgName}"/>">
	<input type="hidden" name="thisPage" id="thisPage" value="${vo.thisPage }">
	<input type="hidden" name="shOption" id="shOption" value="${vo.shOption }">
	<input type="hidden" name="shValue" id="shValue" value="${vo.shValue }">
	<input type="submit" value="제출">
</form>

<a href="codeGroupView?ifcgSeq=${rt.ifcgSeq}&thisPage=${vo.thisPage}&shOption=${vo.shOption}&shValue=${vo.shValue}">돌아가기</a>