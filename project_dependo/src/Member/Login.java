package Member;

import java.io.IOException;
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
		
		if(vo!=null) {
			System.out.println("vo �� �ƴ�");
		}
		
		if(id.equals("admin")&&pw.equals("admin")) {
			
			HttpSession session =request.getSession();
			
			session.setAttribute("member", id);
			
			response.sendRedirect("./defendo/index_after.jsp");
			
		}else if(vo!=null) {
			
			
			HttpSession session =request.getSession();
			session.setAttribute("member", vo);
			response.sendRedirect("./defendo/worker.html");
			
			
		}else {
			response.sendRedirect("./defendo/index_before.jsp");
		}
	
		
		
	
	}

}
