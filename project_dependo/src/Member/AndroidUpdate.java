package Member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@WebServlet("/AndroidUpdate")
public class AndroidUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		
		String setid = request.getParameter("id"); // 수정할 아이디
		String password = request.getParameter("password"); // 비번
		String name = request.getParameter("name"); // 노동자이름
		String tel = request.getParameter("tel"); // 전화번호
		String dept = request.getParameter("dept"); // 소속
		
		System.out.println("아이디 잘 들어 오나"+setid);
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.Update(setid, password, name, tel, dept);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		String result = new Gson().toJson(cnt);
		PrintWriter out = response.getWriter();
		out.print(result);

	}

}
