<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Course</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Course Project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/fontawesome-free-5.0.1/css/fontawesome-all.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/animate.css">
<link rel="stylesheet" type="text/css" href="styles/index_styles.css">
<link rel="stylesheet" type="text/css" href="styles/index_responsive.css">
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
html, body {
  background: #5079B1;
  height: 100%;
  width: 100%;
  margin: 0;
  padding: 0;
  font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
}

main {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
  position: relative;
}
main .notification {
  position: relative;
  width: 5em;
  height: 5em;
}
main .notification svg {
  width: 5em;
  height: 5em;
}
main .notification svg > path {
  fill: #FFFFFF;
}
main .notification--bell {
  animation: bell 2.2s linear infinite;
  transform-origin: 50% 0%;
}
main .notification--bellClapper {
  animation: bellClapper 2.2s 0.1s linear infinite;
}
main .notification--num {
  position: absolute;
  top: 0%;
  left: 60%;
  font-size: 2.25rem;
  border-radius: 50%;
  width: 1em;
  height: 1em;
  background-color: #FF4C13;
  border: 0px solid #5079b1;
  color: #FFFFFF;
  text-align: left;
  line-height: 1em;
  animation: notification 3.2s ease;
}

@keyframes bell {
  0%, 25%, 75%, 100% {
    transform: rotate(0deg);
  }
  40% {
    transform: rotate(2deg);
  }
  45% {
    transform: rotate(-2deg);
  }
  55% {
    transform: rotate(1deg);
  }
  60% {
    transform: rotate(-1deg);
  }
}
@keyframes bellClapper {
  0%, 25%, 75%, 100% {
    transform: translateX(0);
  }
  40% {
    transform: translateX(-0.15em);
  }
  45% {
    transform: translateX(0.15em);
  }
  55% {
    transform: translateX(-0.1em);
  }
  60% {
    transform: translateX(0.1em);
  }
}
@keyframes notification {
  0%, 25%, 75%, 100% {
    opacity: 1;
  }
  30%, 70% {
    opacity: 0;
  }
}


</style>

<div class="super_container">

   <!-- Header -->
   <header class="header d-flex flex-row">
      <div class="header_content d-flex flex-row align-items-center">
         <!-- Logo -->
         <div class="logo_container">
            <div class="logo">
               <a href="index_after.jsp"><img src="images/logode.jpg" alt=""></a>
            </div>
         </div>
		
		<%
		//현재 로그인 상태인지 판별 (vo == null -> 로그인 하지 않은 상태)	
		String id = (String)session.getAttribute("ID");
		System.out.println(id);
		%>
		
         <!-- Main Navigation -->
         <nav class="main_nav_container">
            <div class="main_nav">
               <ul class="main_nav_list">
               		<% if(id!=null){%> 
               		
               			
               	                 
               	  <li class="main_nav_item"><a href="All_Worker.jsp"><span style="font-family: 'SpoqaHanSansNeo-Medium' !important; font-size:18px;">직원 통합 관리</span></a></li>                 
                  <li class="main_nav_item"><a href="Location.jsp"><span style="font-family: 'SpoqaHanSansNeo-Medium' !important; font-size:18px;">직원 위치 확인</span></a></li>
                  <li class="main_nav_item"><a href="machine.html"><span style="font-family: 'SpoqaHanSansNeo-Medium' !important; font-size:18px;">기기등록</span></a></li>
                  <li class="main_nav_item"><a href="../Logout"><span style="font-family: 'SpoqaHanSansNeo-Medium' !important; font-size:18px;">로그아웃</span></a></li>
            
            
             <% }else{%>
               		<li class="main_nav_item"><span style="font-family: 'SpoqaHanSansNeo-Medium' !important; font-size:18px;">관리자 페이지입니다. 근로자는 정보를 볼 수 없습니다.</span></a></li>                 
               	  	<li class="main_nav_item"><a href="../Logout"><span style="font-family: 'SpoqaHanSansNeo-Medium' !important; font-size:18px;">로그아웃</span></a></li>
            
               		<%}%>
               		
            
                   </ul>
            </div>
         </nav>
      </div>
      <div class="header_side d-flex flex-row justify-content-center align-items-center">
         
         <span style="font-family: 'SpoqaHanSansNeo-Medium' !important; font-size:18px;"><%=id %>님 환영합니다.</span>
         <main rel="main">
		  <div class="notification">
		    <svg viewbox="0 0 166 197">
		      <path d="M82.8652955,196.898522 C97.8853137,196.898522 110.154225,184.733014 110.154225,169.792619 L55.4909279,169.792619 C55.4909279,184.733014 67.8452774,196.898522 82.8652955,196.898522 L82.8652955,196.898522 Z" class="notification--bellClapper"></path>
		    <path d="M146.189736,135.093562 L146.189736,82.040478 C146.189736,52.1121695 125.723173,27.9861651 97.4598237,21.2550099 L97.4598237,14.4635396 C97.4598237,6.74321823 90.6498186,0 82.8530327,0 C75.0440643,0 68.2462416,6.74321823 68.2462416,14.4635396 L68.2462416,21.2550099 C39.9707102,27.9861651 19.5163297,52.1121695 19.5163297,82.040478 L19.5163297,135.093562 L0,154.418491 L0,164.080956 L165.706065,164.080956 L165.706065,154.418491 L146.189736,135.093562 Z" class="notification--bell"></path>
		    </svg>
		    <span class="notification--num">4</span>
		  </div>
		  
		</main>
         
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
               <li class="menu_item menu_mm"><a href="#">Home</a></li>
               <li class="menu_item menu_mm"><a href="courses.html">Courses</a></li>
               <li class="menu_item menu_mm"><a href="elements.html">Elements</a></li>
               <li class="menu_item menu_mm"><a href="news.html">News</a></li>
               <li class="menu_item menu_mm"><a href="contact.html">Contact</a></li>
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

      <!-- Hero Slider -->
      <div class="hero_slider_container">
         <div class="hero_slider owl-carousel">
            
            <!-- Hero Slide -->
            <div class="hero_slide">
               <div class="hero_slide_background" style="background-image:url(images/slider_background1.jpg)"></div>
               <div class="hero_slide_container d-flex flex-column align-items-center justify-content-center">
                
               </div>
            </div>
            
            <!-- Hero Slide -->
            <div class="hero_slide">
               <div class="hero_slide_background" style="background-image:url(images/slider_background2.jpg)"></div>
               <div class="hero_slide_container d-flex flex-column align-items-center justify-content-center">
                 
               </div>
            </div>
            
            <!-- Hero Slide -->
            <div class="hero_slide">
               <div class="hero_slide_background" style="background-image:url(images/slider_background3.jpg)"></div>
               <div class="hero_slide_container d-flex flex-column align-items-center justify-content-center">
                  
               </div>
            </div>

         </div>

        
      </div>
   </div>

   

   

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
                     앱과 웹을 통한 
                     <br>노동자 통합 안전 관리 시스템
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
<script src="plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
<script src="plugins/scrollTo/jquery.scrollTo.min.js"></script>
<script src="plugins/easing/easing.js"></script>
<script src="js/custom.js"></script>

</body>
</html>