<%@page import="Member.MemberVO"%>
<%@page import="java.util.ArrayList"%>

<%@page import="Member.MemberDAO"%>
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
								<li class="main_nav_item"><a href="All_Worker.jsp"><span style="font-family: 'SpoqaHanSansNeo-Medium' !important; font-size:18px;">직원 통합 관리</span></a></li>
								<li class="main_nav_item"><a href="Location.jsp"><span style="font-family: 'SpoqaHanSansNeo-Medium' !important; font-size:18px;">직원 위치 확인</span></a></li>
								<li class="main_nav_item"><a href="machine.html"><span style="font-family: 'SpoqaHanSansNeo-Medium' !important; font-size:18px;">기기등록</span></a></li>
								<li class="main_nav_item"><a href="../Logout"><span style="font-family: 'SpoqaHanSansNeo-Medium' !important; font-size:18px;">로그아웃</span></a></li>
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

		<div class="elements" style="font-family: 'Dolbomche_R' !important;">
		
		<!--사용자 관리-->
		<main class="h-full overflow-y-auto" >
          <div class="container px-6 mx-auto grid" style="margin-bottom: 55px; font-family: 'Dolbomche_R' !important;"">
            <h2 class="my-6 text-2xl text-gray-700 dark:text-gray-200" style="font-family:'SLEIGothicTTF' !important; font-size:40px;">직원 통합 관리</h2>
            <!-- Cards -->
            <div class="grid gap-6 mb-8 md:grid-cols-2 xl:grid-cols-4" style="padding-top: 70px;">
              <!-- Card -->
              <div class="flex items-center p-4 bg-white rounded-lg shadow-xs dark:bg-gray-800">
                <div class="p-3 mr-4 text-orange-500 bg-orange-100 rounded-full dark:text-orange-100 dark:bg-orange-500">
                  <svg class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20">
                    <path d="M13 6a3 3 0 11-6 0 3 3 0 016 0zM18 8a2 2 0 11-4 0 2 2 0 014 0zM14 15a4 4 0 00-8 0v3h8v-3zM6 8a2 2 0 11-4 0 2 2 0 014 0zM16 18v-3a5.972 5.972 0 00-.75-2.906A3.005 3.005 0 0119 15v3h-3zM4.75 12.094A5.973 5.973 0 004 15v3H1v-3a3 3 0 013.75-2.906z"
                    ></path>
                  </svg>
                </div>
                <div>
                <!-- 총 근로자 수  -->
                  <p class="mb-2 text-sm font-medium text-gray-600 dark:text-gray-400">
                                   총 근로자 수</p>
                  <p class="text-lg font-semibold text-gray-700 dark:text-gray-200">
                    6389</p>
                </div>
              </div>
              <!-- 1. Card -->
              <div class="flex items-center p-4 bg-white rounded-lg shadow-xs dark:bg-gray-800">
                <div class="p-3 mr-4 text-green-500 bg-green-100 rounded-full dark:text-green-100 dark:bg-green-500">
                  <svg class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20">
                    <path fill-rule="evenodd"
                      d="M4 4a2 2 0 00-2 2v4a2 2 0 002 2V6h10a2 2 0 00-2-2H4zm2 6a2 2 0 012-2h8a2 2 0 012 2v4a2 2 0 01-2 2H8a2 2 0 01-2-2v-4zm6 4a2 2 0 100-4 2 2 0 000 4z"
                      clip-rule="evenodd"></path>
                  </svg>
                </div>
                <!-- 안전모 턱끈&안전교육 모두 확인 된 근로자 수 -->
                <div>
                  <p class="mb-2 text-sm font-medium text-gray-600 dark:text-gray-400">
                                   총 이수자 수
                  </p>
                  <p class="text-lg font-semibold text-gray-700 dark:text-gray-200">
                    300
                  </p>
                </div>
              </div>
              <!--2. Card -->
              
              <div
                class="flex items-center p-4 bg-white rounded-lg shadow-xs dark:bg-gray-800"
              >
                <div
                  class="p-3 mr-4 text-teal-500 bg-teal-100 rounded-full dark:text-teal-100 dark:bg-teal-500"
                >
                  <svg class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20">
                    <path
                      fill-rule="evenodd"
                      d="M18 5v8a2 2 0 01-2 2h-5l-5 4v-4H4a2 2 0 01-2-2V5a2 2 0 012-2h12a2 2 0 012 2zM7 8H5v2h2V8zm2 0h2v2H9V8zm6 0h-2v2h2V8z"
                      clip-rule="evenodd"
                    ></path>
                  </svg>
                </div>
                <div>
                  <p class="mb-2 text-sm font-medium text-gray-600 dark:text-gray-400">
                                    미이수 근로자 수              
                  </p>
                  <p class="text-lg font-semibold text-gray-700 dark:text-gray-200">
                    100
                  </p>
                  </p>
                </div>
              </div>
            </div>

			<!-- 근로자 검색 -->
			<div class="px-4 py-3 mb-8 bg-white rounded-lg shadow-xs dark:bg-gray-800">
             <label class="block mt-4 text-sm">
                <span class="text-gray-700 dark:text-gray-400">근로자 검색</span>
                <div class="relative text-gray-500 focus-within:text-purple-600">
                  
                 
                  <input
                  	id="workerName" 
                    class="block w-full pr-20 mt-1 text-sm text-black dark:text-gray-300 dark:border-gray-600 dark:bg-gray-700 focus:border-purple-400 focus:outline-none focus:shadow-outline-purple dark:focus:shadow-outline-gray form-input"
                    placeholder="근로자의 이름을 입력해주세요"/>
                  <button class="absolute inset-y-0 right-0 px-4 text-sm font-medium leading-5 text-white transition-colors duration-150 bg-purple-600 border border-transparent rounded-r-md active:bg-purple-600 hover:bg-purple-700 focus:outline-none focus:shadow-outline-purple"
                  onclick="nameCheck()">
                    Search</button>
                    
                 </div>
              </label>
            </div>


            <!-- 직원 관리 Table -->
            <div class="w-full overflow-hidden rounded-lg shadow-xs">
              <div class="w-full overflow-x-auto">
                <table class="w-full whitespace-no-wrap">
                  <thead>
                    <tr class="text-xs tracking-wide text-left text-gray-500 uppercase border-b dark:border-gray-700 bg-gray-50 dark:text-gray-400 dark:bg-gray-800">
                      <th class="px-4 py-3">직원명</th>
                      <th class="px-4 py-3">안전모 턱끈 여부</th>
                      <th class="px-4 py-3">안전 교육 수료 여부</th>
                      <th class="px-4 py-3">등록 날짜</th>
                      <th class="px-4 py-3">근로자 정보 수정/삭제</th>
                    </tr>
                  </thead>
                  
                          
                          <% MemberDAO dao = new MemberDAO();
                         	
                          ArrayList<MemberVO> al1 = dao.selectAll();
                         
                          %>
                          
                          
                          <% 
                          for(int i=0; i<al1.size();i++){
                        	  %>
                  <tbody class="bg-white divide-y dark:divide-gray-700 dark:bg-gray-800" <%=al1.get(i).getWorker_name() %>>
                    <tr class="text-gray-700 dark:text-gray-400">
                      <td class="px-4 py-3">
                        <div class="flex items-center text-sm">
                          <div class="relative hidden w-8 h-8 mr-3 rounded-full md:block">
                            <img
                              class="object-cover w-full h-full rounded-full"
                              src="images/Default_Profile.png"
                              alt=""
                              loading="lazy"/>
                            <div class="absolute inset-0 rounded-full shadow-inner"
                              aria-hidden="true"></div>
                          </div>
                        	  <div class="menu00">
                          <!-- 근로자 이름 -->
                            <p class="font-semibold wname"><%=al1.get(i).getWorker_name() %></p>
                          </div>
                        </div>
                      </td >
                      <%
                      if(al1.get(i).getHm_lock().equals("Y")){ %>
                    	  <!-- 안전모 턱끈 여부 - 확인 버전 -->
                          <td class="px-4 py-3 text-xs" >
                            <span class="px-2 py-1 font-semibold leading-tight text-green-700 bg-green-100 rounded-full dark:bg-green-700 dark:text-green-100"
                            >확인</span>
                          </td>
                    	  
                   <%    }else{%>
                   
                    <!-- 안전모 턱끈 - 미확인  -->
                      <td class="px-4 py-3 text-xs" >
                        <span
                          class="px-2 py-1 font-semibold leading-tight text-red-700 bg-red-100 rounded-full dark:text-red-100 dark:bg-red-700"
                        >미확인</span>
                      </td>
                   
                	   
                 <% }
                 if(al1.get(i).getEducation().equals("Y")){%>
                	 
                	 
                	 <!-- 안전 교육 여부 - 확인 버전 -->
                      <td class="px-4 py-3 text-xs" >
                        <span class="px-2 py-1 font-semibold leading-tight text-green-700 bg-green-100 rounded-full dark:bg-green-700 dark:text-green-100"
                        >이수</span>
                      </td>
                	 
                	 
                	 
             <%    }else{%>
            	 
                      
                        <!-- 안전교육 - 미이수 -->
                      <td class="px-4 py-3 text-xs" >
                        <span
                          class="px-2 py-1 font-semibold leading-tight text-red-700 bg-red-100 rounded-full dark:text-red-100 dark:bg-red-700"
                        >미이수</span>
                      </td>
                      
                        	  
            	 
            	 
         <%    }
                 
                 %>
                        
                        
                        
                        
                        
                      <!-- 근로자 등록 일자 -->
                      <td class="px-4 py-3 text-sm" >
                        <%=al1.get(i).getWorker_joindate()  %>
                      </td>
                      <!-- 근로자 정보 수정/삭제 -->
                      <td class="px-4 py-3">
                       <div class="flex items-center space-x-4 text-sm">
                         <button class="flex items-center justify-between px-2 py-2 text-sm font-medium leading-5 text-purple-600 rounded-lg dark:text-gray-400 focus:outline-none focus:shadow-outline-gray"
                            aria-label="Edit" onclick="location.href='All_Worker_Edit.jsp?id=<%=al1.get(i).getWorker_id()%>'" >
                            <svg class="w-5 h-5"
                              aria-hidden="true"
                              fill="currentColor"
                              viewBox="0 0 20 20">
                              <path d="M13.586 3.586a2 2 0 112.828 2.828l-.793.793-2.828-2.828.793-.793zM11.379 5.793L3 14.172V17h2.828l8.38-8.379-2.83-2.828z"></path>
                            </svg>
                          </button>
                          
                          
                          <button
                            class="flex items-center justify-between px-2 py-2 text-sm font-medium leading-5 text-purple-600 rounded-lg dark:text-gray-400 focus:outline-none focus:shadow-outline-gray"
                            aria-label="Delete" onclick="if (confirm('삭제하시겠습니까?')){location.href='../Delete?id=<%=al1.get(i).getWorker_id()%>'}else{location.href=''}">
                            <svg
                              class="w-5 h-5"
                              aria-hidden="true"
                              fill="currentColor"
                              viewBox="0 0 20 20">
                              <path
                                fill-rule="evenodd"
                                d="M9 2a1 1 0 00-.894.553L7.382 4H4a1 1 0 000 2v10a2 2 0 002 2h8a2 2 0 002-2V6a1 1 0 100-2h-3.382l-.724-1.447A1 1 0 0011 2H9zM7 8a1 1 0 012 0v6a1 1 0 11-2 0V8zm5-1a1 1 0 00-1 1v6a1 1 0 102 0V8a1 1 0 00-1-1z"
                                clip-rule="evenodd"></path>
                            </svg>
                          </button>
                          </div>
                      </td>
                    </tr>
                        
                        
                        
                        	  
                     <%     } %>
                          
                          
              

                  </tbody>
                </table>
              </div>
              <div
                class="grid px-4 py-3 text-xs font-semibold tracking-wide text-gray-500 uppercase border-t dark:border-gray-700 bg-gray-50 sm:grid-cols-9 dark:text-gray-400 dark:bg-gray-800"
              >
                <span class="flex items-center col-span-3">
                  Showing 21-30 of 100
                </span>
                <span class="col-span-2"></span>
                <!-- Pagination -->
                <span class="flex col-span-4 mt-2 sm:mt-auto sm:justify-end">
                  <nav aria-label="Table navigation">
                    <ul class="inline-flex items-center">
                      <li>
                        <button
                          class="px-3 py-1 rounded-md rounded-l-lg focus:outline-none focus:shadow-outline-purple"
                          aria-label="Previous">
                          <svg
                            aria-hidden="true"
                            class="w-4 h-4 fill-current"
                            viewBox="0 0 20 20">
                            <path
                              d="M12.707 5.293a1 1 0 010 1.414L9.414 10l3.293 3.293a1 1 0 01-1.414 1.414l-4-4a1 1 0 010-1.414l4-4a1 1 0 011.414 0z"
                              clip-rule="evenodd"
                              fill-rule="evenodd"
                            ></path>
                          </svg>
                        </button>
                      </li>
                      <li>
                        <button
                          class="px-3 py-1 rounded-md focus:outline-none focus:shadow-outline-purple"
                        >
                          1
                        </button>
                      </li>
                      <li>
                        <button
                          class="px-3 py-1 rounded-md focus:outline-none focus:shadow-outline-purple"
                        >
                          2
                        </button>
                      </li>
                      <li>
                        <button
                          class="px-3 py-1 text-white transition-colors duration-150 bg-purple-600 border border-r-0 border-purple-600 rounded-md focus:outline-none focus:shadow-outline-purple"
                        >
                          3
                        </button>
                      </li>
                      <li>
                        <button
                          class="px-3 py-1 rounded-md focus:outline-none focus:shadow-outline-purple"
                        >
                          4
                        </button>
                      </li>
                      <li>
                        <span class="px-3 py-1">...</span>
                      </li>
                      <li>
                        <button
                          class="px-3 py-1 rounded-md focus:outline-none focus:shadow-outline-purple"
                        >
                          8
                        </button>
                      </li>
                      <li>
                        <button
                          class="px-3 py-1 rounded-md focus:outline-none focus:shadow-outline-purple"
                        >
                          9
                        </button>
                      </li>
                      <li>
                        <button
                          class="px-3 py-1 rounded-md rounded-r-lg focus:outline-none focus:shadow-outline-purple"
                          aria-label="Next"
                        >
                          <svg
                            class="w-4 h-4 fill-current"
                            aria-hidden="true"
                            viewBox="0 0 20 20"
                          >
                            <path
                              d="M7.293 14.707a1 1 0 010-1.414L10.586 10 7.293 6.707a1 1 0 011.414-1.414l4 4a1 1 0 010 1.414l-4 4a1 1 0 01-1.414 0z"
                              clip-rule="evenodd"
                              fill-rule="evenodd"
                            ></path>
                          </svg>
                        </button>
                      </li>
                    </ul>
                  </nav>
                </span>
              </div>
            </div>
            
             
            
            
          </div>
        </main>

			

			

		

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
		
		
		<style>
			.bar1{
				visibility : visible;
			}
			.bar2{
				visibility : hidden;
			}
			
		</style>
		<script>

		function nameCheck() {
	
			var wN=document.getElementById("workerName").value;
			var gN=document.getElementsByClassName("wname");
			
			
			$(gN).each(function(){
				if(this.innerText.indexOf(wN) == 1){
					//클래스 추가  bar1(보이게)  bar2(안보이게)
					//bar1 추가 bar2 제거
					// this.parentNode.parentNode.parentNode.parentNode.className += ' bar1';
					$(this.parentNode.parentNode.parentNode.parentNode).addClass("bar1");
					$(this.parentNode.parentNode.parentNode.parentNode).removeClass("bar2");


				}else{
					//bar2 추가 bar1제거
					// this.parentNode.parentNode.parentNode.parentNode.className += ' bar2';
					
					$(this.parentNode.parentNode.parentNode.parentNode).addClass("bar2");
					$(this.parentNode.parentNode.parentNode.parentNode).removeClass("bar1");


					
				}
			});
			
		}
		
		
		
		
		
		
		</script>
		

</body>




</html>