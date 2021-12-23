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
  	ArduinoVO vo2 = dao.getSensor();
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
									<p ><%=vo2.getAttack() %></p>	
							</td>
							</tr>
							
							<tr>
							<td>
							<p>가스: </p>
									<p ><%=vo2.getAlram() %></p>
							</td>
							</tr>
							
							<tr>
							<td>
							<p>잠금: </p>
									<p ><%=vo2.getLock() %></p>
							</td>
							</tr>
							
							<tr>
							<td>
							<p>위도: </p>
									<p ><%=vo2.getLat() %></p>
							</td>
							</tr>
							
							<tr>
							<td>
							<p>경도: </p>
									<p><%=vo2.getLong() %></p>
							</td>
						</tr>
					</table>
			</div>
		</div>
	</div>
	<script type="text/javascript">
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
	</script>
</body>
</html>