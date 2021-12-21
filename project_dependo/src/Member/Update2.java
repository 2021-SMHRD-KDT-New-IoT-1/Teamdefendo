package Member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Update2")
public class Update2 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	   	request.setCharacterEncoding("euc-kr");
	   	
	   	
		String worker_name=request.getParameter("worker_name");
		String worker_id=request.getParameter("worker_id");
		String admin_yesno=request.getParameter("accountType");
		String worker_dept=request.getParameter("worker_dept");
		String setid=request.getParameter("id");
		String hm_id=request.getParameter("hm_id");
		
		
			
		
		MemberDAO dao = new MemberDAO();
		
		int cnt1 = dao.update2(worker_name, worker_id, admin_yesno, worker_dept, setid);
		System.out.println("cnt1: "+cnt1);

		int cnt2 = dao.update3(hm_id, setid);
		System.out.println("cnt2: "+cnt2);

		if(cnt1 > 0 && cnt2>0) {
			
			System.out.println("수정성공");

			response.sendRedirect("./defendo/All_Worker.jsp");
			
		}else {
			System.out.println("수정실패");

			response.sendRedirect("./defendo/All_Worker.jsp");
		}
		
		
		
		
		
		
	}

}
