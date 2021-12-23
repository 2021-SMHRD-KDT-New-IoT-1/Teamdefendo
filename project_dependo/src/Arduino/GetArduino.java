package Arduino;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

@WebServlet("/GetArduino")
public class GetArduino extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArduinoDAO dao = new ArduinoDAO();
		ArduinoVO vo = dao.getSensor("hm_id");
		String result = new Gson().toJson(vo);
		PrintWriter out = response.getWriter();
		out.print(result);
	}
}
