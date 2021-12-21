package Attendance;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SetAttendance")
public class SetAttendance extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		AttendanceDAO dao = new AttendanceDAO();
		AttendanceVO vo = dao.LoginTime(id, pw);
		
		
		if(vo!=null) {
			System.out.println("로그인 성공!");
		}else {
			System.out.println("로그인 실패!!");
		}
		
		PrintWriter out = response.getWriter();
		out.print(vo);

		
		
	}

}
