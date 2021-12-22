package Attendance;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import com.sun.jmx.snmp.Timestamp;

import Member.MemberVO;

public class AttendanceDAO {
	
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	AttendanceVO avo=null;
	int cnt=0;
	
	
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

			String sql = "SELECT * FROM (SELECT * FROM tbl_attendance ORDER BY ROWNUM DESC) WHERE worker_id=? and ROWNUM = 1";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, worker_id);
			rs = pstmt.executeQuery();
			
			
			
			if (rs.next()) {
			
				String start_time= rs.getString("start_time"); 
				String end_time= rs.getString("end_time"); 
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

			// 4. 바인드 변수 채워두기
			pstmt.setString(1, id);
			pstmt.setString(2, pw);

			// 5. sql문 실행 후 결과 처리
			rs = pstmt.executeQuery();

			if (rs.next()) {
			
				
				try {
					
					DBcon();

					String sql2 = "SELECT * FROM (SELECT * FROM tbl_attendance ORDER BY ROWNUM DESC) WHERE worker_id=? and ROWNUM = 1";
					pstmt = con.prepareStatement(sql2);
					pstmt.setString(1, id);
					ResultSet rs2 = pstmt.executeQuery();
					
				
					
					if (rs2.next()) {

						
						String start_time= rs2.getString("start_time"); 
						String end_time= rs2.getString("end_time"); 
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

			System.out.println("로그인실패");
			e.printStackTrace();

		} finally {

			DBclose();

		}
		
		return avo;



	}
	

	public int StartTime(String id) {
		
		
		try {
			DBcon();

			String sql = "select * FROM tbl_attendance where worker_id=? and start_time = TO_CHAR(SYSDATE, 'YY-MM-DD')";

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();

			if (rs.next()) {
			
				
				try {
					
					DBcon();

					String sql2 = "INSERT INTO tbl_attendance (worker_id, start_time, att_type) VALUES (?, sysdate, 'N')";
					pstmt = con.prepareStatement(sql2);
					pstmt.setString(1, id);
					cnt = pstmt.executeUpdate();
					
				} catch (Exception e) {
					
					e.printStackTrace();
				} finally {
					DBclose();
				}


			}

		} catch (Exception e) {

			System.out.println("오류");
			e.printStackTrace();

		} finally {

			DBclose();

		}
		
		return cnt;


		
		
		
		
	}
	
	public int EndTime(String id) {
		

		try {
		DBcon();

		
		String sql = "UPDATE tbl_attendance SET end_time = sysdate, att_type = 'y' WHERE worker_id = ? and start_time = TO_CHAR(SYSDATE, 'YY-MM-DD')";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		cnt = pstmt.executeUpdate();
		
		
		} catch (Exception e) {

			System.out.println("오류");
			e.printStackTrace();

		} finally {

			DBclose();

		}
		
		return cnt;

		
	}
	
	
	
	
	
}
