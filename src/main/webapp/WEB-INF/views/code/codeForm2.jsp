<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="rb" uri="http://www.springframework.org/tags" %>

<form method="post" action="codeUpdt">
	<input type="hidden" name="ifcdSeq" value="<c:out value="${rt.ifcdSeq}"/>">
	<input type="text" name="ifcdName" placeholder="아이디" value="<c:out value="${rt.ifcdName}"/>">
	<input type="submit" value="제출">
</form>
