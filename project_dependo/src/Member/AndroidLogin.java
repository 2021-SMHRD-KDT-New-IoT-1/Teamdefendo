package Member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/AndroidLogin")
public class AndroidLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=utf-8");

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		System.out.println("아이디:"+id+" / 비밀번호 : "+pw);
		
		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.AndroidLogin(id, pw);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		String result = new Gson().toJson(vo);
		PrintWriter out = response.getWriter();
		out.print(result);

	}

}
