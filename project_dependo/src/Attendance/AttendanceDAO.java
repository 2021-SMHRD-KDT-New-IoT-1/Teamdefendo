package Attendance;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AttendanceDAO {
	
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	AttendanceVO avo=null;
	
	
	
	public void DBcon() {
        try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			String db_url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String db_id = "campus_a_3_1215";
			String db_pw = "smhrd3";
			con = DriverManager.getConnection(db_url, db_id, db_pw);
  
           if( con != null ) {
               System.out.println("DB 접속 성공");
           }
           
       } catch (ClassNotFoundException e) { 
           System.out.println("드라이버 로드 실패");
       } catch (SQLException e) {
           System.out.println("DB 접속 실패");
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
	

	public AttendanceVO attendance(String worker_id) {
		
   
		    
		try {
			
			DBcon();

			String sql = "select * FROM tbl_attendance where worker_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, worker_id);
			rs = pstmt.executeQuery();
			
			
			
			if (rs.next()) {

				
				Date start_time= rs.getDate("start_time"); 
				Date end_time= rs.getDate("end_time"); 
				String att_type = rs.getString("att_type");
				
				avo = new AttendanceVO(worker_id, start_time, end_time, att_type);
				
				
				
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			DBclose();
		}

		return avo;

}

	
	
	
	
}
