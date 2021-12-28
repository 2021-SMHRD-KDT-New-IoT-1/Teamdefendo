package Member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("euc-kr");
		
		String id =request.getParameter("id");
		String pw = request.getParameter("password");
        
		MemberDAO dao = new MemberDAO();
		MemberVO vo;
		vo=dao.Login(id,pw);
		
		
		if(vo!=null){
		if(vo.getAdmin_yesno().equals("Y")) {
			
			HttpSession session =request.getSession();
			
			session.setAttribute("ID", id);
			
			response.sendRedirect("./defendo/index_after.jsp");
			
		}else if(vo.getAdmin_yesno().equals("N")) {
			
			
			HttpSession session =request.getSession();
			session.setAttribute("ID", id);
			
			response.sendRedirect("./defendo/worker.jsp");
		
		}
		
	}
		else {
			System.out.println("로그인 실패");
			
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter writer = response.getWriter(); 
			writer.println("<script>alert('아이디,비밀번호를 확인해주세요'); location.href='./defendo/Login.html'</script>"); 
			writer.close();
			
			
		}
	
		
		
	
	}

}
