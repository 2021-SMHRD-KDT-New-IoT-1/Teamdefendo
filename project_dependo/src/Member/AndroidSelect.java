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


@WebServlet("/AndroidSelect")
public class AndroidSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		request.setCharacterEncoding("euc-kr");
		
		String id = request.getParameter("id");
		String date = request.getParameter("date");
		
		AttendanceDAO dao = new AttendanceDAO();
		ArrayList<AttendanceVO> al =dao.AndroidLoginTime(id,date);
		
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		String result = new Gson().toJson(al);
		PrintWriter out = response.getWriter();
		out.print(result);
		
	
		
	}

}
