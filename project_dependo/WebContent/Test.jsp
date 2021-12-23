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
		<h2>Pump���� ���� ����</h2>
		<div class="panel panel-default">
			<div class="panel-heading">�������� Form</div>
			<div class="panel-body">
					<table class="table table-condensed">
						<tr>
							<td>
							<p>����: </p>
									<p ><%=vo.getAttack() %></p>	
							</td>
							</tr>
							
							<tr>
							<td>
							<p>����: </p>
									<p ><%=vo.getAlram() %></p>
							</td>
							</tr>
							
							<tr>
							<td>
							<p>���: </p>
									<p ><%=vo.getLock() %></p>
							</td>
							</tr>
							
							<tr>
							<td>
							<p>����: </p>
									<p ><%=vo.getLat() %></p>
							</td>
							</tr>
							
							<tr>
							<td>
							<p>�浵: </p>
									<p><%=vo.getLong() %></p>
							</td>
							</tr>
							
							<tr>
							<td>
							<p>��� ID: </p>
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
			type: 'get',   //get������� ���
			url : './GetAttendance',  //�̵��� jsp ���� �ּ�
			dataType:'text',   //������������ �ޱ�
			success: function(data){   //������ �ְ�ޱ� �������� ��� ������ ���

			
			
			
			},
			error:function(){   //������ �ְ�ޱⰡ �������� ��� ������ ���
				alert('����');
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
				$('#result1').html("���� : " + data.attack);
				$('#result2').html("���� : " + data.alram);
				$('#result3').html("��� : " + data.lock);
				$('#result4').html("���� : " + data.Lat);
				$('#result5').html("�浵 : " + data.Long);
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