package Member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@WebServlet("/AndroidSelectAll")
public class AndroidSelectAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String WORKER_DEPT = request.getParameter("dept");
		
		
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberVO> al = dao.select(WORKER_DEPT);
				
		String result = new Gson().toJson(al);
		PrintWriter out = response.getWriter();		
		out.print(result);
		
		
	}

}
