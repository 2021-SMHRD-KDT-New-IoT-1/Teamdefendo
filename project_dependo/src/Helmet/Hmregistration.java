package Helmet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Hmregistration")
public class Hmregistration extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String hm_id = request.getParameter("hm_id");
		String worker_id = request.getParameter("worker_id");
		

		
		
		 HmDAO dao = new HmDAO();
		
	      int cnt = dao.Hmregistration(hm_id, worker_id);
	      System.out.println(cnt);
	      
	      if(cnt > 0) {
	         System.out.println("Çï¸äµî·Ï¼º°ø");
	     	
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter writer = response.getWriter(); 
			writer.println("<script>alert('Çï¸Ë Á¤º¸ µî·Ï ¼º°ø'); location.href='./defendo/index_after.jsp'</script>"); 
			writer.close();
	         
	      }else {
	         System.out.println("Çï¸äµî·Ï½ÇÆÐ");
	         response.sendRedirect("./defendo/machine.html");
	      }
	      
		
		
		
		
		
	}

}
