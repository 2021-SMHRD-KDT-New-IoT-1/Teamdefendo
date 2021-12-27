package Member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AndroidJoin")
public class AndroidJoin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=utf-8");

		String id = request.getParameter("id");
		String password = request.getParameter("pw");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String dept = request.getParameter("dept");
		String check_manager = request.getParameter("check_manager");

		if (check_manager == null) {
			check_manager = "N";
		}

		MemberDAO dao = new MemberDAO();

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		int cnt = dao.Join(id, password, name, tel, dept, check_manager);

		PrintWriter out = response.getWriter();
		out.print(cnt);

		if (cnt > 0) {
			System.out.println("회원가입성공");

		} else {
			System.out.println("회원가입실패");

		}

	}

}
