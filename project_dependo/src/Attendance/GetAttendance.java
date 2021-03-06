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
		
		String GetAttendance = (String)request.getAttribute("GetAttendance"); 
		String hm_id =(String)request.getAttribute("hm_id");	
		
		
		
		AttendanceDAO dao = new AttendanceDAO();
		
		String worker_id = dao.name(hm_id);
		
		if(GetAttendance.equals("Y")) {
			
			
			int cnt1 = dao.StartTime(worker_id);
			if(cnt1>0) {
				System.out.println("출근 입력 완료");
			}else {
				System.out.println("출근 입력 실패");
			}
			
			
		}else if(GetAttendance.equals("N")) {
			int cnt2 = dao.EndTime(worker_id);
			if(cnt2==1) {
				System.out.println("퇴근 완료");
			}else {
				System.out.println("퇴근 입력 실패");
			}
			
			
			

		}
		
	}

}
