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


@WebServlet("/AndroidIdSensor")
public class AndroidIdSensor extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("euc-kr");
		String dept = request.getParameter("dept");
		
		SensorDAO dao = new SensorDAO();
		ArrayList<SensorVO> al = dao.AndroidGetSensor(dept);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		String result = new Gson().toJson(al);

		PrintWriter out = response.getWriter();
		out.print(result); 

		
		
		
	}

}
