package Member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@WebServlet("/Join")
public class Join extends HttpServlet {

   private static final long serialVersionUID = 1L;


   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	  request.setCharacterEncoding("utf-8");
      

      String id = request.getParameter("id");
      String password = request.getParameter("pw");
      String name = request.getParameter("name");
      String tel = request.getParameter("tel");
      String dept = request.getParameter("dept");
      String check_manager = request.getParameter("check_manager");
      
   

    
  	if(check_manager==null) {
		check_manager="N";
	}
      	
  	
    
      MemberDAO dao= new MemberDAO();
    
      int cnt = dao.Join(id, password, name, tel, dept, check_manager);
      
      PrintWriter out = response.getWriter();
      out.print(cnt);
      
      if(cnt > 0) {
         System.out.println("회원가입성공");
         response.sendRedirect("./defendo/index_before.jsp");
  
         
         
         
         
         
      }else {
         System.out.println("회원가입실패");
         response.sendRedirect("./defendo/index_before.jsp");
         
      }
      
      
      
      
   }

}
