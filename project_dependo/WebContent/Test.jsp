<%@page import="Arduino.ArduinoVO"%>
<%@page import="Arduino.ArduinoDAO"%>
<%@page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<% 	
  	ArduinoDAO dao = new ArduinoDAO();
  	ArduinoVO vo = dao.getSensor("hm_id1");
%>
	<div class="container">
		<h2>Pump모터 제어 서버</h2>
		<div class="panel panel-default">
			<div class="panel-heading">모터제어 Form</div>
			<div class="panel-body">
					<table class="table table-condensed">
						<tr>
							<td>
							<p>어택: </p>
									<p ><%=vo.getAttack() %></p>	
							</td>
							</tr>
							
							<tr>
							<td>
							<p>가스: </p>
									<p ><%=vo.getAlram() %></p>
							</td>
							</tr>
							
							<tr>
							<td>
							<p>잠금: </p>
									<p ><%=vo.getLock() %></p>
							</td>
							</tr>
							
							<tr>
							<td>
							<p>위도: </p>
									<p ><%=vo.getLat() %></p>
							</td>
							</tr>
							
							<tr>
							<td>
							<p>경도: </p>
									<p><%=vo.getLong() %></p>
							</td>
							</tr>
							
							<tr>
							<td>
							<p>헬멧 ID: </p>
									<p><%=vo.getHm_id() %></p>
							</td>
							</tr>
					</table>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	
	$(document).ready(function(){
		$.ajax({
			type: 'get',   //get방식으로 명시
			url : './GetAttendance',  //이동할 jsp 파일 주소
			dataType:'text',   //문자형식으로 받기
			success: function(data){   //데이터 주고받기 성공했을 경우 실행할 결과

			
			
			
			},
			error:function(){   //데이터 주고받기가 실패했을 경우 실행할 결과
				alert('실패');
			}
		})
	});
	
	
	
	
	
	
	/*

	
	$(function(){ 
		$.ajax({
			url : "GetArduino",
			type : "get",
			dataType : "json",
			success : function(data){
				$('#result1').html("어택 : " + data.attack);
				$('#result2').html("가스 : " + data.alram);
				$('#result3').html("잠금 : " + data.lock);
				$('#result4').html("위도 : " + data.Lat);
				$('#result5').html("경도 : " + data.Long);
			},
			error : function(){
				alert('1');
			}
		});
	});
	*/
	</script>
</body>
</html>