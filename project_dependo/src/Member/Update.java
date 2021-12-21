package Member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			
			
		   	  request.setCharacterEncoding("euc-kr");
		   	  
		   	  HttpSession session = request.getSession(); 
			  String setid = (String)session.getAttribute("ID");
		   	
		      
		      String password = request.getParameter("password");
		      String name = request.getParameter("name");
		      String tel = request.getParameter("tel");
		      String dept = request.getParameter("dept");
		      
		      
				MemberDAO dao= new MemberDAO();
				int cnt = dao.Update(setid, password, name, tel, dept);
				
				
				if(cnt > 0) {
					System.out.println("수정성공");
					response.setContentType("text/html; charset=UTF-8"); 
					PrintWriter writer = response.getWriter(); 
					writer.println("<script>alert('회원정보 수정성공'); location.href='./defendo/index_before.jsp'</script>"); 
					writer.close();
					
				}else {
					System.out.println("수정실패");
					response.sendRedirect("./defendo/index_before.jsp");
				}
		     
		      
		
		
		
		
	}

}
