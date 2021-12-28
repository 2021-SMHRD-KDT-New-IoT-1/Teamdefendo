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
	
	public int Hmregistration(String hm_id, String worker_id) {
		
		try {
			
		
			DBcon();
			System.out.print("값 확인");
			// 4. SQL문 준비
			String sql = "insert into tbl_helmet(HM_SEQ,worker_id, hm_id,HM_IMPACT_SENSOR,HM_GAS_SENSOR,LATITUDE,LONGITUDE,HM_LOCK) values(TBL_HELMET_SEQ.nextval,?,?,0,0,0,0,0)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, worker_id);
			pstmt.setString(2, hm_id);
		
			cnt = pstmt.executeUpdate();
		
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBclose();

			}

			return cnt;
			
			
			
		}
	
	public int update(String hm_id, String worker_id) {
		
		try {

			DBcon();
			
			
			String sql = "UPDATE tbl_helmet SET worker_id=? WHERE hm_id =?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, worker_id);
			pstmt.setString(2, hm_id);
		
			

			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBclose();

		}
	
		
		
		return cnt;
	}
	
		
	}
	
		


