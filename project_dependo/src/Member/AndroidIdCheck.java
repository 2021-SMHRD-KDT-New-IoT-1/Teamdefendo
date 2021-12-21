package Member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AndroidIdCheck")
public class AndroidIdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		
		request.setCharacterEncoding("euc-kr");
		
		String id = request.getParameter("id");
		System.out.println(id);
		
		
		
		// ��� ��Ʈ��(���)
		PrintWriter out = response.getWriter();
		
		MemberDAO dao = new MemberDAO();
		
		boolean check = dao.idCheck(id);
		
		// ��θ� ���ؼ� ���� �����͸� ���
		out.print(check);
		
		
		
		
		
		
		
	}

}