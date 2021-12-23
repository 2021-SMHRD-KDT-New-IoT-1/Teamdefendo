package Sensors;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@WebServlet("/Alarm")
public class Alarm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		AlarmDAO dao = new AlarmDAO();
		ArrayList<AlarmVO> al = dao.Alarm();
		ArrayList<AlarmVO> al2 = null;
		for(int i =0; i<al.size(); i++) {
			if(al.get(i).getHM_GAS_SENSOR()>0 || al.get(i).getHM_IMPACT_SENSOR()>0) {
				al2.add(al.get(i));
				
			}
			
		}
		
		String result = new Gson().toJson(al2);
		PrintWriter out = response.getWriter();		
		out.print(result);
		
		// �������� �˶� ���� al2.size
		// �������� �̻� ������ al2.get(i) -> for�� ������ ?
		
	}

}
