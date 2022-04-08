<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="rb" uri="http://www.springframework.org/tags" %>

<link href="/infra/resources/common/jquery/jquery-ui-1.13.1.custom/jquery-ui.css" rel="stylesheet">
<link href="/infra/resources/common/_bootstrap/bootstrap-5.1.3-dist/css/bootstrap.min.css" rel="stylesheet">

<style type="text/css">
	.addScroll{
		background-color: gray;
		height: 200px;
	}
</style>

<!-- <form method="get" action="codeInst"> -->
<form method="post" action="codeInst" enctype="multipart/form-data">
	<select id="ifcgSeq" name="ifcgSeq">
		<c:forEach items="${list}" var="item" varStatus="status">	
	
			<option value="${item.ifcgSeq}"><c:out value="${item.ifcgSeq}"/> | <c:out value="${item.ifcgName}"/></option>
		
		</c:forEach>
		
	
	</select>
	<input type="text" id="abcDate" name="abcDate">

	<input type="text" name="ifcdName" placeholder="아이디">
	<!-- <input type="text" name="ifcgSeq" placeholder="시퀀스"> -->
	<!-- <input type="file" name="file"> -->
	<!-- <input type="file" name="file1"> -->
	<div>
		<label for="file0" class="form-label input-file-button btn btn-danger">이미지첨부</label>
		<input class="form-control form-control-sm" id="file0" name="file0" type="file" multiple="multiple" style="display:none;" onChange="upload(0,2);">
		<div class="addScroll">
			<ul id="ulFile0" class="list-group">
			</ul>
		</div>
	</div>
	<div>
		<label for="file1" class="form-label input-file-button btn btn-dark">파일첨부</label>
		<input class="form-control form-control-sm" id="file1" name="file1" type="file" multiple="multiple" style="display:none;" onChange="upload(1,1);">
		<div class="addScroll">
			<ul id="ulFile1" class="list-group">
			</ul>
		</div>
	</div>
	<input type="submit" value="제출">
</form>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> 
<script src="/infra/resources/common/jquery/jquery-ui-1.13.1.custom/jquery-ui.js"></script>
<script src="/infra/resources/common/_bootstrap/bootstrap-5.1.3-dist/js/bootstrap.bundle.min.js"></script>
<script src="/infra/resources/js/validation.js"></script>
<script src="/infra/resources/js/commonXdmin.js"></script>

<script type="text/javascript">
	upload = function(seq, div){
		
		$("#ulFile" + seq).children().remove();
		
		var fileCount = $("input[type=file]")[seq].files.length;
		
		if(checkUploadedTotalFileNumber(fileCount, seq) == false) {return false;}
		
		var totalFileSize;
		
		for (var i = 0; i < fileCount ; i++) {
			if(div == 1){
				if(checkUploadedAllExt($("input[type=file]")[seq].files[i].name, seq) == false) {return false;}
			} else if(div == 2) {
				if(checkUploadedImageExt($("input[type=file]")[seq].files[i].name, seq) == false) {return false;}
			} else {
				return false;
			}
			
			if(checkUploadedEachFileSize($("input[type=file]")[seq].files[i].name, seq) == false) {return false;}
			totalFileSize += $("input[type=file]")[seq].files[i].size;
		}
		
		if(checkUploadedTotalFileSize(totalFileSize, seq) === false){return false;}
		
		for(var i = 0; i< fileCount ; i++){
			addUploadLi(seq, i, $("input[type=file]")[seq].files[i].name);
		}
	}
	
	addUploadLi = function (seq, index, name){
		
		var ul_list = $("#ulFile0");
		
		li = '<li id="li_'+seq+'_'+index+'" class="list-group-item d-flex justify-content-between align-items-center">';
		li = li + name;
		li = li + '<span class="badge bg-danger rounded-pill" onClick="delLi('+seq+','+index+')"><i class="fa-solid fa-x" style="cursor: pointer;"></i></span>';
		li = li + '</li>';
		
		$("#ulFile"+seq).append(li);
	}
	
	delLi = function(seq, index){
		$("#li_"+seq+"_"+index).remove();
	}

	$(document).ready(function(){ 
		$("#abcDate").datepicker();
	});
	
	$.datepicker.setDefaults({
	    dateFormat: 'yy-mm-dd',
	    prevText: '이전 달',
	    nextText: '다음 달',
	    monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
	    monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
	    dayNames: ['일', '월', '화', '수', '목', '금', '토'],
	    dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
	    dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
	    showMonthAfterYear: true,
	    yearSuffix: '년'
	});
</script>