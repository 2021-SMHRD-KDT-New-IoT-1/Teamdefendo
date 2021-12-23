package Sensors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Attendance.AttendanceVO;

public class AlarmDAO {
	
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
   
    AlarmVO vo = null;
    ArrayList<AlarmVO> al = null;
    
    
	private void conn() {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			String db_url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String db_id = "campus_a_3_1215";
			String db_pw = "smhrd3";
			conn = DriverManager.getConnection(db_url, db_id, db_pw);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<AlarmVO> Alarm() {


		
	    
		try {
			
			conn();

			String sql = "select * from tbl_helmet";
			psmt = conn.prepareStatement(sql);
			
			rs = psmt.executeQuery();
			
			
			
			if (rs.next()) {
			
				int hM_IMPACT_SENSOR = rs.getInt("HM_IMPACT_SENSOR");
				int hM_GAS_SENSOR = rs.getInt("HM_GAS_SENSOR");
				String WORKER_ID = rs.getString("WORKER_ID");
				
				vo= new AlarmVO(hM_IMPACT_SENSOR, hM_GAS_SENSOR, WORKER_ID);
				
				
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			close();
		
		}

		return al;

	
	
	}
	

}
