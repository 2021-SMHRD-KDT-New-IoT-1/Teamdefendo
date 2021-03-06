<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Course - Elements</title>
<meta charset="EUC-KR">
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
<link rel="stylesheet" href="styles/tailwind.output.css" />
<script src="https://cdn.jsdelivr.net/gh/alpinejs/alpine@v2.x.x/dist/alpine.min.js"
     defer></script>
    
     
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

					

					<div class="menu_copyright menu_mm">
						Copyright &copy;
						<script>document.write(new Date().getFullYear());
						</script>
						All rights reserved | This template is made with <i
							class="fa fa-heart" aria-hidden="true"></i> by defendo
					</div>
				</div>
			</div>
		</div>

		<!-- Home -->

		<% String id= request.getParameter("id");  %>


		<div class="home">
			<div class="home_background_container prlx_parent">
				<div class="home_background prlx"
					style="background-image: url(images/contact_background.jpg)"></div>
			</div>
			<div class="home_content" style="font-family:'SLEIGothicTTF' !important; font-size:40px;">
				<h1>Staff Management</h1>
			</div>
		</div>

		<!-- Elements -->
	<form action="../Update2" id="update2" method="post">
	
		<input type="hidden" name="id" value="<%=id%>">
		
		
		<div class="elements" style="font-family: 'Dolbomche_R' !important;">
		 <div class="container px-6 mx-auto grid" style="margin-bottom: 55px; font-family: 'Dolbomche_R' !important;">
		
		 <!-- General elements -->
           <h2 class="my-6 text-2xl text-gray-700 dark:text-gray-200" style="font-family:'SLEIGothicTTF' !important; font-size:40px;">???? ???? ????</h2>
            <div class="px-4 py-3 mb-8 bg-white rounded-lg shadow-md dark:bg-gray-800">
              <label class="block text-sm">
                <span class="text-gray-700 dark:text-gray-400">??????</span>
                <input
                  maxlength="30"
                  class="block w-full mt-1 text-sm dark:border-gray-600 dark:bg-gray-700 focus:border-purple-400 focus:outline-none focus:shadow-outline-purple dark:text-gray-300 dark:focus:shadow-outline-gray form-input"
                  name="worker_name"
                  placeholder="?????? ?????? ????????????"
                />
              </label>

			<div class="mt-4 text-sm">
              <label class="block text-sm">
                <span class="text-gray-700 dark:text-gray-400">????ID</span>
                <input
                  maxlength="30"
                  class="block w-full mt-1 text-sm dark:border-gray-600 dark:bg-gray-700 focus:border-purple-400 focus:outline-none focus:shadow-outline-purple dark:text-gray-300 dark:focus:shadow-outline-gray form-input"
                  name="worker_id"
                  placeholder="?????? ID?? ????????????"
                />
              </label>
              </div>


              <div class="mt-4 text-sm">
                <span class="text-gray-700 dark:text-gray-400">
                             ??????/?????? ????
                </span>
                <div class="mt-2">
                  <label
                    class="inline-flex items-center text-gray-600 dark:text-gray-400">
                    <input
                      type="radio"
                      class="text-purple-600 form-radio focus:border-purple-400 focus:outline-none focus:shadow-outline-purple dark:focus:shadow-outline-gray"
                      name="accountType"
                      value="N"
                    />
                    <span class="ml-2">Worker</span>
                  </label>
                  <label
                    class="inline-flex items-center ml-6 text-gray-600 dark:text-gray-400"
                  >
                    <input
                      type="radio"
                      class="text-purple-600 form-radio focus:border-purple-400 focus:outline-none focus:shadow-outline-purple dark:focus:shadow-outline-gray"
                      name="accountType"
                      value="Y"
                    />
                    <span class="ml-2">Admin</span>
                  </label>
                </div>
              </div>
              
              <br>
               <label class="block text-sm">
                <span class="text-gray-700 dark:text-gray-400">???? ?????? ???? ????</span>
                <input
                  maxlength="20"
                  class="block w-full mt-1 text-sm dark:border-gray-600 dark:bg-gray-700 focus:border-purple-400 focus:outline-none focus:shadow-outline-purple dark:text-gray-300 dark:focus:shadow-outline-gray form-input"
                  name="hm_id"
                  placeholder="??????  ???? ?????? ?????? ????????????"
                />
              </label>
              
          	<br>
                
               <label class="block text-sm">
                <span class="text-gray-700 dark:text-gray-400">???? ????</span>
                <input
                  maxlength="20"
                  class="block w-full mt-1 text-sm dark:border-gray-600 dark:bg-gray-700 focus:border-purple-400 focus:outline-none focus:shadow-outline-purple dark:text-gray-300 dark:focus:shadow-outline-gray form-input"
                  name="worker_dept"
                  placeholder="??????  ???? ?????? ????????????"
                />
              </label>
              
              
              <br><br>
              


              <div class="mt-4 text-sm" align="right">
                <input
                  class="px-4 py-2 text-sm font-medium leading-5 text-white transition-colors duration-150 bg-purple-600 border border-transparent rounded-lg active:bg-purple-600 hover:bg-purple-700 focus:outline-none focus:shadow-outline-purple"
                  type="submit" value="????????">
                           
              </div>
            </div>
		</div>

		</div>
	</from>
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
		<script src="plugins/progressbar/progressbar.min.js"></script>
		<script src="plugins/scrollTo/jquery.scrollTo.min.js"></script>
		<script src="plugins/easing/easing.js"></script>
		<script src="js/elements_custom.js"></script>
		<script src="js/all_worker_content.js"></script>
</body>
</html>