package Member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("euc-kr");
		
		String id = request.getParameter("id");
		
		MemberDAO dao = new MemberDAO();
		
		int cnt = dao.delete(id);
		
		if(cnt > 0) {
			
			System.out.println("삭제성공");
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter writer = response.getWriter(); 
			writer.println("<script>alert('삭제 성공'); location.href='./defendo/All_Worker.jsp'</script>"); 
			writer.close();
			
			
		}else {
			
			System.out.println("삭제실패");
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter writer = response.getWriter(); 
			writer.println("<script>alert('삭제 실패'); location.href='./defendo/All_Worker.jsp'</script>"); 
			writer.close();
			
		}
		
		
		
		
		
		
	}

}
