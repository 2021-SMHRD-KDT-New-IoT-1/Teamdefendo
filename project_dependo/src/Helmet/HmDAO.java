package Helmet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class HmDAO {
	
	
	
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;	
	int cnt;
	
	
	public void DBcon() {
        try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			String db_url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String db_id = "campus_a_3_1215";
			String db_pw = "smhrd3";
			con = DriverManager.getConnection(db_url, db_id, db_pw);
  
           if( con != null ) {
               System.out.println("DB ���� ����");
           }
           
       } catch (ClassNotFoundException e) { 
           System.out.println("����̹� �ε� ����");
       } catch (SQLException e) {
           System.out.println("DB ���� ����");
           e.printStackTrace();
       }
   }
   
  
	public void DBclose() {

		try {
			if (rs != null) {
				rs.close();
			}

			if (pstmt != null) {
				pstmt.close();

			}
			if (con != null) {
				con.close();
			}

		} catch (Exception e2) {
			e2.printStackTrace();
		}

	}
	
	public int Hmregistration(String hm_id, String worker_id) {
		
		try {
	
		
			DBcon();

			// 4. SQL�� �غ�
			String sql = "insert into tbl_helmet_use(worker_id, hm_id) values(?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, hm_id);
			pstmt.setString(2, worker_id);
		
			cnt = pstmt.executeUpdate();
		
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBclose();

			}

			return cnt;
			
			
			
		}
		

}
