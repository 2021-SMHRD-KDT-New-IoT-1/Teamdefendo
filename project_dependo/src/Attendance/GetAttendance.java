package Attendance;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/GetAttendance")
public class GetAttendance extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int GetAttendance = Integer.parseInt(request.getParameter("GetAttendance"));
		String worker_id = request.getParameter("worker_id");
		AttendanceDAO dao = new AttendanceDAO();
		
		
		if(GetAttendance==1) {
			
			
			int cnt1 = dao.StartTime(worker_id);
			int cnt2 = dao.EndTime(worker_id);
			if(cnt1>0) {
				System.out.println("출근 입력 완료");
			}
			if(cnt2==1) {
				System.out.println("퇴근 완료");
			}
			
		}
		
	}

}
