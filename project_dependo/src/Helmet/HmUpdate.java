package Helmet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HmUpdate")
public class HmUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String hm_id = request.getParameter("hm_id");
		String worker_id = request.getParameter("worker_id");
		
	      System.out.println(hm_id+"/"+worker_id);

		
		
		 HmDAO dao = new HmDAO();
		
	      int cnt = dao.update(hm_id, worker_id);
	      System.out.println(cnt);
	      
	      if(cnt > 0) {
	         System.out.println("Çï¸ä¼öÁ¤¼º°ø");
	     	
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter writer = response.getWriter(); 
			writer.println("<script>alert('Çï¸Ë Á¤º¸ ¼öÁ¤ ¼º°ø'); location.href='./defendo/machine.html'</script>"); 
			writer.close();
	         
	      }else {
	         System.out.println("Çï¸ä¼öÁ¤½ÇÆÐ");
	         PrintWriter writer = response.getWriter(); 
				writer.println("<script>alert('Çï¸Ë Á¤º¸ ¼öÁ¤ ½ÇÆÐ'); location.href='./defendo/machine.html'</script>"); 
				writer.close();
	      }
	      
		
		
		
		
		
	}

}
