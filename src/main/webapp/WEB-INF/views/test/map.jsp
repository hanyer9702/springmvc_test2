<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<html>
<head>
	<meta charset="utf-8"/>
	<title>Kakao 지도 시작하기</title>
</head>
<body>
	<!-- <div id="map" style="width:500px;height:400px;"></div> -->
	
	<div class="mb-3 col-sm-8 g-2">
	  	<label for="userZipcode" class="form-label">주소</label>
	  	<div class="input-group mb-2">
		  <input type="text" class="form-control" id="ifmaZipcode" name="ifmaZipcode" readonly>
		  <!-- <input type="text" class="form-control" id="ifmaZipcode" name="ifmaZipcode"> -->
		  <button class="btn btn-outline-secondary" type="button" id="userAddressButton" onclick="execDaumPostcode()">주소찾기</button>
		</div>
	    <input type="text" class="form-control mb-2" id="ifmaAddress1" name="ifmaAddress1" readonly>
	    <!-- <input type="text" class="form-control mb-2" id="ifmaAddress1" name="ifmaAddress1"> -->
	    <input type="text" class="form-control mb-2" id="ifmaAddress2" name="ifmaAddress2" placeholder="상세주소" required>
	    <input type="text" class="form-control" id="ifmaAddress3" name="ifmaAddress3" placeholder="참고항목">
	    <input type="text" class="form-control" id="ifmaLatArray0" name="ifmaAddress3" placeholder="위도">
	    <input type="text" class="form-control" id="ifmaLngArray0" name="ifmaAddress3" placeholder="경도">
	  </div>
	
	<!-- <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=78f7172c997f5f35677373c66d538e94"></script> -->
	<!-- <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=78f7172c997f5f35677373c66d538e94&libraries=LIBRARY"></script> -->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=78f7172c997f5f35677373c66d538e94&libraries=services"></script>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
		var container = document.getElementById('map');
		var options = {
			center: new kakao.maps.LatLng(33.450701, 126.570667),
			level: 3
		};

		
	</script>
	
	<!-- 지도 -->
	<script>
	    function execDaumPostcode() {
	        new daum.Postcode({
	            oncomplete: function(data) {
	                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
	
	                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
	                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	                var addr = ''; // 주소 변수
	                var extraAddr = ''; // 참고항목 변수
	
	                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
	                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
	                    addr = data.roadAddress;
	                } else { // 사용자가 지번 주소를 선택했을 경우(J)
	                    addr = data.jibunAddress;
	                }
	
	                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
	                if(data.userSelectedType === 'R'){
	                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                        extraAddr += data.bname;
	                    }
	                    // 건물명이 있고, 공동주택일 경우 추가한다.
	                    if(data.buildingName !== '' && data.apartment === 'Y'){
	                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                    }
	                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	                    if(extraAddr !== ''){
	                        extraAddr = ' (' + extraAddr + ')';
	                    }
	                    // 조합된 참고항목을 해당 필드에 넣는다.
	                    document.getElementById("ifmaAddress3").value = extraAddr;
	                    
	                 // 우편번호와 주소 정보를 해당 필드에 넣는다.
		                document.getElementById('ifmaZipcode').value = data.zonecode;
		                document.getElementById("ifmaAddress1").value = addr;
	                   
	                    	                    
						/* lat and lng from address s */
						
						
	        			
		        		// 주소-좌표 변환 객체를 생성
		        		var geocoder = new daum.maps.services.Geocoder();
		        		
		        		// 주소로 좌표를 검색
		        		geocoder.addressSearch(addr, function(result, status) {
		        		 
		        			// 정상적으로 검색이 완료됐으면,
		        			if (status == daum.maps.services.Status.OK) {
		        				
		        				
		        				
		        				document.getElementById("ifmaLatArray0").value=result[0].x;
		        				document.getElementById("ifmaLngArray0").value=result[0].y;
		        				
		        /* 						
		        				var coords = new daum.maps.LatLng(result[0].y, result[0].x);
		        		
		        				y = result[0].x;
		        				x = result[0].y;
		        		
		        				// 결과값으로 받은 위치를 마커로 표시합니다.
		        				var marker = new daum.maps.Marker({
		        					map: map,
		        					position: coords
		        				});
		        		
		        				// 인포윈도우로 장소에 대한 설명표시
		        				var infowindow = new daum.maps.InfoWindow({
		        					content: '<div style="width:150px;text-align:center;padding:5px 0;">좌표위치</div>'
		        				});
		        		
		        				infowindow.open(map,marker);
		        		
		        				// 지도 중심을 이동
		        				map.setCenter(coords);
		        				
		        				document.getElementById("ifmaLatArray0").value=x;
		        				document.getElementById("ifmaLngArray0").value=y;
		        */						
		        			}
		        		});
		        		/* lat and lng from address e */
	                
	                } else {
	                    document.getElementById("ifmaAddress3").value = '';
	                }
	
	                
	                // 커서를 상세주소 필드로 이동한다.
	                document.getElementById("ifmaAddress2").focus();
	                
	                /* var map = new kakao.maps.Map(container, options); */
	        		
	            }
	        }).open();
	        		
	                
	    }
	</script>
	
	<!-- 지도 -->
</body>
</html>