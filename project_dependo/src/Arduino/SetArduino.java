package Arduino;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/SetArduino")
public class SetArduino extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int attack = Integer.parseInt(request.getParameter("attack"));
		int alram = Integer.parseInt(request.getParameter("alram"));
		float Lat = Float.valueOf(request.getParameter("r_LatF"));
		float Long = Float.valueOf(request.getParameter("r_LongF"));
		int lock = Integer.parseInt(request.getParameter("lock"));
		
		ArduinoDAO dao = new ArduinoDAO();
		ArduinoVO vo = dao.update(attack, Lat, Long, alram, lock);
		String result = new Gson().toJson(vo);
		PrintWriter out = response.getWriter();
		out.print(result);
	}
}