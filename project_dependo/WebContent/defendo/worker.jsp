<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="Attendance.AttendanceVO"%>
<%@page import="Attendance.AttendanceDAO"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@page import="Member.MemberDAO"%>
<%@page import="Member.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Course - Elements</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Course Project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/fontawesome-free-5.0.1/css/fontawesome-all.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css"
	href="styles/All_Worker_responsive.css">
<link rel="stylesheet" type="text/css"
	href="styles/All_Worker_styles.css">

</head>
<body>
	<style>
@font-face {
	font-family: 'SLEIGothicTTF';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2104@1.0/SLEIGothicTTF.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
	font-size: 35px;
}

@font-face {
	font-family: 'Dolbomche_R';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2104@1.0/Dolbomche_R.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}

@font-face {
	font-family: 'SpoqaHanSansNeo-Medium';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2108@1.1/SpoqaHanSansNeo-Medium.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}

table.type11 {
	border-collapse: separate;
	border-spacing: 1px;
	text-align: center;
	line-height: 1.5;
	margin: 20px 10px;
}

table.type11 td {
	width: 280px;
	padding: 10px;
	vertical-align: top;
	border: 2px solid #ffb606;
	background: #ffffff;
}

table.type11 th {
	width: 280px;
	padding: 10px;
	vertical-align: top;
	border: 2px solid #ffb606;
	background: #ffffff;
}
</style>

	<div class="super_container">
		<!-- Header -->
		<header class="header d-flex flex-row">
			<div class="header_content d-flex flex-row align-items-center">
				<!-- Logo -->
				<div class="logo_container">
					<div class="logo">
						<a href="worker.jsp"> <img src="images/logode.jpg"
							alt="">
						</a>
					</div>
				</div>

			<%
			//???? ?????? ???????? ???? (vo == null -> ?????? ???? ???? ????)	
			
			String id = (String)session.getAttribute("ID");
			AttendanceDAO dao = new AttendanceDAO();
			AttendanceVO vo = dao.attendance(id);
			System.out.print(vo);
			SimpleDateFormat fm = new SimpleDateFormat("YYYY-hh-dd HH:mm:ss");
			String lateTime = " ";
			String earlyTime =" ";
			ArrayList<AttendanceVO> al = dao.LoginAllTime(id);
			System.out.print(al.get(0).getStart_time());
			if(vo!=null){
				
		
			if(vo!=null){
				if(vo.getEnd_time()!=null){
				String time2= vo.getEnd_time();
				Date early  = fm.parse(time2);
				
				if(early.getHours()<18){
					earlyTime="????";
				}else{
					earlyTime="????????";
				};
				}
			}
			
			if(vo!=null){
				String time1= vo.getStart_time();
				Date late  = fm.parse(time1);
				
				
				if(late.getHours()>8){
					lateTime="????";
				}else{
					lateTime="????????";
				}

			}

			}
			
			%>
	
			
				<!-- Main Navigation -->
				<nav class="main_nav_container">
					<div class="main_nav">
						<ul class="main_nav_list">
							<li class="main_nav_item"><a href="worker.jsp"><span
									style="font-family: 'SpoqaHanSansNeo-Medium' !important; font-size: 18px;">????
										????</span></a></li>
							<li class="main_nav_item"><a href="w_mypage.jsp"><span
									style="font-family: 'SpoqaHanSansNeo-Medium' !important; font-size: 18px;">??????????</span></a></li>
									<li class="main_nav_item"><a href="../Logout"><span style="font-family: 'SpoqaHanSansNeo-Medium' !important; font-size:18px;">????????</span></a></li>

						</ul>
					</div>
				</nav>
			</div>
			<div
				class="header_side d-flex flex-row justify-content-center align-items-center">
				<!-- <img src="images/phone-call.svg" alt=""> -->
				<span></span>
			</div>

			<!-- Hamburger -->
			<div class="hamburger_container">
				<i class="fas fa-bars trans_200"></i>
			</div>
		</header>

		<!-- Menu -->
		<div class="menu_container menu_mm">

			<!-- Menu Close Button -->
			<div class="menu_close_container">
				<div class="menu_close"></div>
			</div>

			<!-- Menu Items -->
			<div class="menu_inner menu_mm">
				<div class="menu menu_mm">
					<ul class="menu_list menu_mm">
						<li class="menu_item menu_mm"><a href="index.html">Home</a></li>
						<li class="menu_item menu_mm"><a href="#">About us</a></li>
						<li class="menu_item menu_mm"><a href="courses.html">Courses</a></li>
						<li class="menu_item menu_mm"><a href="#">Elements</a></li>
						<li class="menu_item menu_mm"><a href="news.html">News</a></li>
						<li class="menu_item menu_mm"><a href="contact.html">Contact</a></li>
					</ul>

					<!-- Menu Social -->

					<div class="menu_social_container menu_mm">
						<ul class="menu_social menu_mm">
							<li class="menu_social_item menu_mm"><a href="#"><i
									class="fab fa-pinterest"></i></a></li>
							<li class="menu_social_item menu_mm"><a href="#"><i
									class="fab fa-linkedin-in"></i></a></li>
							<li class="menu_social_item menu_mm"><a href="#"><i
									class="fab fa-instagram"></i></a></li>
							<li class="menu_social_item menu_mm"><a href="#"><i
									class="fab fa-facebook-f"></i></a></li>
							<li class="menu_social_item menu_mm"><a href="#"><i
									class="fab fa-twitter"></i></a></li>
						</ul>
					</div>

					<div class="menu_copyright menu_mm">
						<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
						Copyright &copy;
						<script>
							document.write(new Date().getFullYear());
						</script>
						All rights reserved | This template is made with <i
							class="fa fa-heart" aria-hidden="true"></i> by <a
							href="https://colorlib.com" target="_blank">Colorlib</a>
						<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
					</div>
				</div>

			</div>

		</div>

		<!-- Home -->

		<div class="home">
			<div class="home_background_container prlx_parent">
				<div class="home_background prlx"
					style="background-image: url(images/img1.jpg)"></div>
			</div>
		</div>
		<br>
		<p
			style="font-family: 'SLEIGothicTTF' !important; font-size: 30px; text-align: center;">
			<font color="black">(??)????????????????</font>
		</p>

		<!-- Buttons -->

		<div class="container">
			<div class="row">
				<div class="col">
					<table class="type11 td">
						<tbody>
							<tr>
								<td
									style="font-family: 'Dolbomche_R' !important; font-size: 25px; border: 2px solid black;"><font
									color="black">????</font></td>
								<td
									style="font-family: 'Dolbomche_R' !important; font-size: 25px;"><font
									color="black"><%if(vo!=null){ %>
									<%=vo.getStart_time().substring(11,19)%><%} %></font></td>
								<td
									style="font-family: 'Dolbomche_R' !important; font-size: 25px; background: #1A1A1A; border: 2px solid black;"><font
									color="#FFFFFF">????</font></td>
								<td
									style="font-family: 'Dolbomche_R' !important; font-size: 25px;"><font
									color="black"><%if(earlyTime!=null){%><%=earlyTime%><%} %></font></td>
							</tr>
							<tr>
								<td
									style="font-family: 'Dolbomche_R' !important; font-size: 25px; border: 2px solid #ffb606;"><font
									color="black">????</font></td>
								<td
									style="font-family: 'Dolbomche_R' !important; font-size: 25px;"><font
									color="black"><%if(lateTime!=null){ %><%=lateTime %><%} %></font></td>
								<td
									style="font-family: 'Dolbomche_R' !important; font-size: 25px; border: 2px solid black;"><font
									color="black">????</font></td>
								<td
									style="font-family: 'Dolbomche_R' !important; font-size: 25px;"><font
									color="black"><%
									if(vo!=null){ if(vo.getEnd_time()!=null){
										%><%=vo.getEnd_time().substring(11,19) %>
								<%	}}  %></font></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>


		<div class="container">
			<div class="row">
				<div class="col">
					<table class="type11 td">
						<tbody>
							<tr>
								<td
									style="font-family: 'Dolbomche_R' !important; font-size: 25px; border: 2px solid #696969; background: #696969;"><font
									color="#FFFFFF">????</font></td>
								<td
									style="font-family: 'Dolbomche_R' !important; font-size: 25px; border: 2px solid #696969; background: #696969;"><font
									color="#FFFFFF">???? ????</font></td>
								<td
									style="font-family: 'Dolbomche_R' !important; font-size: 25px;border: 2px solid #696969; background: #696969;"><font
									color="#FFFFFF">???? ????</font></td>
								<td
									style="font-family: 'Dolbomche_R' !important; font-size: 25px; border: 2px solid #696969; background: #696969;"><font
									color="#FFFFFF">???? ????</font></td>
								<td
									style="font-family: 'Dolbomche_R' !important; font-size: 25px;border: 2px solid #696969; background: #696969;"><font
									color="#FFFFFF">???? ????</font></td>
								<td
									style="font-family: 'Dolbomche_R' !important; font-size: 25px;border: 2px solid #696969; background: #696969;"><font
									color="#FFFFFF">???? ????</font></td>
							</tr>
							<%for(int i = 0; i<al.size();i++){
									AttendanceVO avo = al.get(i);
									System.out.println("1"+avo.getStart_time());
									String time4 = avo.getEnd_time();
									String earlyTime1 = "";
									if(time4.equals("")){time4 = "";}else{
									System.out.println("dlrj"+time4);
									if(Integer.parseInt(time4.substring(11,13)) <18){
										earlyTime1="????";
									}else{
										earlyTime1="????????";
									}};
									System.out.println("3"+avo.getStart_time());
									String time3= avo.getStart_time();
									System.out.println("4"+avo.getStart_time());
									
									String lateTime1 = "";
									if(Integer.parseInt(time3.substring(11,13))>8){
										lateTime1="????";
									}else{
										lateTime1="????????";
									}%>
							<tr>
								<td
									style="font-family: 'Dolbomche_R' !important; font-size: 25px; border: 2px solid #C0C0C0; background: #C0C0C0; "><font
									color="#FFFFFF"><%=avo.getStart_time().substring(0,11) %></font></td>
								<td
									style="font-family: 'Dolbomche_R' !important; font-size: 25px;border: 2px solid #C0C0C0; background: #C0C0C0;"><font
									color="#FFFFFF"><%=avo.getStart_time().substring(11,19) %></font></td>
								<td
									style="font-family: 'Dolbomche_R' !important; font-size: 25px; border: 2px solid #C0C0C0; background: #C0C0C0;"><font
									color="#FFFFFF"><%=lateTime1 %></font></td>
								<td
									style="font-family: 'Dolbomche_R' !important; font-size: 25px;border: 2px solid #C0C0C0; background: #C0C0C0;"><font
									color="#FFFFFF"><%=earlyTime1%></font></td>
								<td
									style="font-family: 'Dolbomche_R' !important; font-size: 25px;border: 2px solid #C0C0C0; background: #C0C0C0;"><font
									color="#FFFFFF"><%if(!time4.equals("")){%><%=avo.getEnd_time().substring(11,19) %><%}%>
								</font></td>
								<td
									style="font-family: 'Dolbomche_R' !important; font-size: 25px;border: 2px solid #C0C0C0; background: #C0C0C0;"><font
									color="#FFFFFF"><%if(avo.getAtt_type().equals("N")){%>????
								<%	}else{%>????<%}%></font></td>
							</tr>
							<%} %>
						</tbody>
					</table>
				</div>
			</div>
		</div>

		

	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="styles/bootstrap4/popper.js"></script>
	<script src="styles/bootstrap4/bootstrap.min.js"></script>
	<script src="plugins/greensock/TweenMax.min.js"></script>
	<script src="plugins/greensock/TimelineMax.min.js"></script>
	<script src="plugins/scrollmagic/ScrollMagic.min.js"></script>
	<script src="plugins/greensock/animation.gsap.min.js"></script>
	<script src="plugins/greensock/ScrollToPlugin.min.js"></script>
	<script src="plugins/progressbar/progressbar.min.js"></script>
	<script src="plugins/scrollTo/jquery.scrollTo.min.js"></script>
	<script src="plugins/easing/easing.js"></script>
	<script src="js/elements_custom.js"></script>
</body>
</html>