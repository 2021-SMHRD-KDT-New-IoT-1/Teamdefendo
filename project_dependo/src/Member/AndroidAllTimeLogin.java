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

import Attendance.AttendanceDAO;
import Attendance.AttendanceVO;

@WebServlet("/AndroidAllTimeLogin")
public class AndroidAllTimeLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=utf-8");

		String id = request.getParameter("id");
		
		System.out.println("¾ÆÀÌµð:"+id);
		
		AttendanceDAO dao = new AttendanceDAO();
		ArrayList<AttendanceVO> al = dao.LoginAllTime(id);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		String result = new Gson().toJson(al);
		PrintWriter out = response.getWriter();
		out.print(result);
		
	}

}
