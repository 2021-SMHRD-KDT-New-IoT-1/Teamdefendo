package Attendance;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Member.MemberVO;

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
	
	public AttendanceVO LoginTime(String id, String pw) {

		System.out.println(id + "//" + pw);
		try {
			DBcon();

			String sql = "select * FROM tbl_worker where worker_id=? and worker_pw=?";

			pstmt = con.prepareStatement(sql);

			// 4. ���ε� ���� ä���α�
			pstmt.setString(1, id);
			pstmt.setString(2, pw);

			// 5. sql�� ���� �� ��� ó��
			rs = pstmt.executeQuery();

			if (rs.next()) {
			
				
				try {
					
					DBcon();

					String sql2 = "select * FROM tbl_attendance where worker_id=?";
					pstmt = con.prepareStatement(sql2);
					pstmt.setString(1, id);
					ResultSet rs2 = pstmt.executeQuery();
					
				
					
					if (rs2.next()) {

						
						Date start_time= rs2.getDate("start_time"); 
						Date end_time= rs2.getDate("end_time"); 
						String att_type = rs2.getString("att_type");
						
						avo = new AttendanceVO(id, start_time, end_time, att_type);
						
						
						
					}
				} catch (Exception e) {
					
					e.printStackTrace();
				} finally {
					DBclose();
				}


			}

		} catch (Exception e) {

			System.out.println("�α��ν���");
			e.printStackTrace();

		} finally {

			DBclose();

		}
		
		return avo;



	}
	

	
	
}
