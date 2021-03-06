<%@page import="Member.MemberVO"%>
<%@page import="Sensors.SensorVO"%>
<%@page import="Sensors.SensorDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Course - Contact</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Course Project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/fontawesome-free-5.0.1/css/fontawesome-all.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="styles/Location_responsive.css">
<link rel="stylesheet" type="text/css" href="styles/Location_styles.css">
</head>
<body>
<style>
@font-face {
    font-family: 'SLEIGothicTTF';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2104@1.0/SLEIGothicTTF.woff') format('woff');
    font-weight: normal;
    font-style: normal;
    font-size: 35px;
}
@font-face {
    font-family: 'Dolbomche_R';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2104@1.0/Dolbomche_R.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
@font-face {
    font-family: 'SpoqaHanSansNeo-Medium';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2108@1.1/SpoqaHanSansNeo-Medium.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}

</style>

<div class="super_container">

	<!-- Header -->

	<header class="header d-flex flex-row">
		<div class="header_content d-flex flex-row align-items-center">
			<!-- Logo -->
		<div class="logo_container">
            <div class="logo">
               <a href="index_after.jsp">
               <img src="images/logode.jpg" alt="">
               </a>
            </div>
         </div>
			<!-- Main Navigation -->
			<nav class="main_nav_container">
				<div class="main_nav">
					<ul class="main_nav_list">
						<li class="main_nav_item"><a href="All_Worker.jsp"><span style="font-family: 'SpoqaHanSansNeo-Medium' !important; font-size:18px;">???? ???? ????</span></a></li>
						<li class="main_nav_item"><a href="Location.jsp"><span style="font-family: 'SpoqaHanSansNeo-Medium' !important; font-size:18px;">???? ???? ????</span></a></li>
						<li class="main_nav_item"><a href="machine.html"><span style="font-family: 'SpoqaHanSansNeo-Medium' !important; font-size:18px;">????????</span></a></li>
						<li class="main_nav_item"><a href="../Logout"><span style="font-family: 'SpoqaHanSansNeo-Medium' !important; font-size:18px;">????????</span></a></li>
					</ul>
				</div>
			</nav>
		</div>
		<div class="header_side d-flex flex-row justify-content-center align-items-center">
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
					<li class="menu_item menu_mm"><a href="elements.html">Elements</a></li>
					<li class="menu_item menu_mm"><a href="news.html">News</a></li>
					<li class="menu_item menu_mm"><a href="#">Contact</a></li>
				</ul>

				<!-- Menu Social -->
				
				<div class="menu_social_container menu_mm">
					<ul class="menu_social menu_mm">
						<li class="menu_social_item menu_mm"><a href="#"><i class="fab fa-pinterest"></i></a></li>
						<li class="menu_social_item menu_mm"><a href="#"><i class="fab fa-linkedin-in"></i></a></li>
						<li class="menu_social_item menu_mm"><a href="#"><i class="fab fa-instagram"></i></a></li>
						<li class="menu_social_item menu_mm"><a href="#"><i class="fab fa-facebook-f"></i></a></li>
						<li class="menu_social_item menu_mm"><a href="#"><i class="fab fa-twitter"></i></a></li>
					</ul>
				</div>

				<div class="menu_copyright menu_mm">Colorlib All rights reserved</div>
			</div>

		</div>

	</div>
	
	<!-- Home -->

	<div class="home">
		<div class="home_background_container prlx_parent">
			<div class="home_background prlx" style="background-image:url(images/contact_background.jpg)"></div>
		</div>
		<div class="home_content">
			<h1>Worker Location</h1>
		</div>
	</div>

	<!-- Contact -->
	<div class="contact">
	   <div class="container">
	       <div class="row">
	            <div class="col">
	              <div class="contact_form">
	                   <div class="contact_title"><span style="font-family:'SLEIGothicTTF' !important; font-size:40px;">???? ?????? ???? ????</span></div>
	                   <div id="google_map">
	                   <div class="map_container">
	                     <div id="map" style="width: 1000px;height:750px; "></div>
	                  </div>
	                  </div>
	              </div>
				</div>
			</div>

		</div>
	</div> 
	
	

	<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=7a7d85248aa9c8ee0be6cbccffea2057"></script>
	<script>
	
		<% SensorDAO Sdao = new SensorDAO();
		   ArrayList<SensorVO> gpsal = Sdao.Gps();
		   ArrayList<SensorVO> danger = new ArrayList<>();
		   ArrayList<SensorVO> safe = new ArrayList<>();
		   //  ???? ???? ???? ???? ????
		   for(SensorVO vo : gpsal){
			   if(vo.getimpact()>0 || vo.getgas()>0){
				   danger.add(vo);
			   }else{
				   safe.add(vo);
			   }
		   }
		%>
		
		var mapContainer = document.getElementById('map'), // ?????? ?????? div  
	    mapOption = { 
	        center: new kakao.maps.LatLng(35.149967, 126.919945), // ?????? ????????
	        level: 2 // ?????? ???? ????
	    };

	var map = new kakao.maps.Map(mapContainer, mapOption); // ?????? ??????????
	 
	// ?????? ?????? ?????? ?????? ?????? ???? ???? ?????????? 
	var positions = [
		<%for(int i = 0;i<gpsal.size();i++){
			SensorVO vo = gpsal.get(i);
		%>
	    {
	        content: '<div><%=vo.getWorkerPhone()%></div>', 
	        latlng: new kakao.maps.LatLng(<%=vo.getLatitude()%>,<%=vo.getLongitude()%>)
	    }<%if(i<gpsal.size()-1){%>,<%}}%>
	    
	];

	for (var i = 0; i < positions.length; i ++) {
	    // ?????? ??????????
	    var marker = new kakao.maps.Marker({
	        map: map, // ?????? ?????? ????
	        position: positions[i].latlng // ?????? ????
	    });

	    // ?????? ?????? ???????????? ?????????? 
	    var infowindow = new kakao.maps.InfoWindow({
	        content: positions[i].content // ???????????? ?????? ????
	    });

	    // ?????? mouseover ???????? mouseout ???????? ??????????
	    // ?????? ?????????? ???????? ?????? ?????????? 
	    // for?????? ???????? ?????? ???? ?????? ?????? ???????? ???????? ??????????
	    kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
	    kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
	}

	// ???????????? ???????? ???????? ?????? ?????????? 
	function makeOverListener(map, marker, infowindow) {
	    return function() {
	        infowindow.open(map, marker);
	    };
	}

	// ???????????? ???? ???????? ?????? ?????????? 
	function makeOutListener(infowindow) {
	    return function() {
	        infowindow.close();
	    };
	}
	<% for(SensorVO vo : safe){ %>
	
	
	var customOverlay = new kakao.maps.CustomOverlay({
		map: map,
		content: '<div style="padding:0 5px;background:#fff;"><%=vo.getWorkerName()%></div>', 
		position: new kakao.maps.LatLng(<%=vo.getLatitude()%>,<%=vo.getLongitude()%>), // ?????? ?????????? ?????? ????
		xAnchor: 0.5, // ???????? x ????
		yAnchor: 0 // ???????? y ????
	});
	

	<%}%>
	
	<% for(SensorVO vo : danger){%>
	var customOverlay = new kakao.maps.CustomOverlay({
		map: map,
		content: '<div style="padding:0 5px;background:red;"><%=vo.getWorkerName()%></div>', 
		position: new kakao.maps.LatLng(<%=vo.getLatitude()%>,<%=vo.getLongitude()%>), // ?????? ?????????? ?????? ????
		xAnchor: 0.5, // ???????? x ????
		yAnchor: 0 // ???????? y ????
	});
	<%}%>
	//////////////
	
		


	</script>








	<!-- Footer -->

	<footer class="footer">
		<div class="container">
		
			<!-- Footer Content -->

			<div class="footer_content">
				<div class="row">

					<!-- Footer Column - About -->
					<div class="col-lg-3 footer_col">

						<!-- Logo -->
						<div class="logo_container">
							<div class="logo">
								<img src="images/logo_man-removebg-preview.png" alt=""> 
								<span>defendo</span>
							</div>
						</div>

						<p class="footer_about_text">
							???? ???? ???? 
							<br>?????? ???? ???? ???? ??????
							<br><h3>defendo</h3>
						</p>

					</div>

					<!-- Footer Column - Contact -->

					<div class="col-lg-3 footer_col">
						<div class="footer_column_title">Contact</div>
						<div class="footer_column_content">
							<ul>
								<li class="footer_contact_item">
									<div class="footer_contact_icon">
										<img src="images/placeholder.svg" alt="https://www.flaticon.com/authors/lucy-g">
									</div>
									60, Songam-ro, Nam-gu, Gwangju
								</li>
								<li class="footer_contact_item">
									<div class="footer_contact_icon">
										<img src="images/smartphone.svg" alt="https://www.flaticon.com/authors/lucy-g">
									</div>
									062-655-3509
								</li>
								<li class="footer_contact_item">
									<div class="footer_contact_icon">
										<img src="images/envelope.svg" alt="https://www.flaticon.com/authors/lucy-g">
									</div>smhrd.or.kr
								</li>
							</ul>
						</div>
					</div>

				</div>
			</div>

			<!-- Footer Copyright -->

			<div class="footer_bar d-flex flex-column flex-sm-row align-items-center">
				<div class="footer_copyright">
					<span><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | <i class="fa fa-heart" aria-hidden="true"></i> by defendo
              </span>
				</div>
				
			</div>

		</div>
	</footer>

</div>

<script src="js/jquery-3.2.1.min.js"></script>
<script src="styles/bootstrap4/popper.js"></script>
<script src="styles/bootstrap4/bootstrap.min.js"></script>
<script src="plugins/greensock/TweenMax.min.js"></script>
<script src="plugins/greensock/TimelineMax.min.js"></script>
<script src="plugins/scrollmagic/ScrollMagic.min.js"></script>
<script src="plugins/greensock/animation.gsap.min.js"></script>
<script src="plugins/greensock/ScrollToPlugin.min.js"></script>
<script src="plugins/scrollTo/jquery.scrollTo.min.js"></script>
<!-- <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&key=AIzaSyCIwF204lFZg1y4kPSIhKaHEXMLYxxuMhA"></script>  -->
<script src="plugins/easing/easing.js"></script>
<script src="js/contact_custom.js"></script>

</body>
</html>