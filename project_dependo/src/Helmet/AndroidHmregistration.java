package Helmet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/AndroidHm")
public class AndroidHmregistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String hm_id = request.getParameter("hm_id");
		String worker_id = request.getParameter("worker_id");


		HmDAO dao = new HmDAO();

		int cnt = dao.Hmregistration(hm_id, worker_id);
		System.out.println(cnt);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		String result = new Gson().toJson(cnt);

		PrintWriter out = response.getWriter();
		out.print(result); // cnt가 0> 이면 헬멧 등록 성공 아니면 실패

	}

}
