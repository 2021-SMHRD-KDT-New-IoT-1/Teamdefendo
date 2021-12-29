package Sensors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Member.MemberVO;

public class SensorDAO {
	
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
    SensorVO gpsvo = null;
    ArrayList<SensorVO> gpsal =null;
    MemberVO vo = null;
    ArrayList<SensorVO> al = new ArrayList<>();
    
    

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
	
	
	public void UpdateSensor(String hm_id , int hm_impact_sensor,int gas_sensor, float latitude,float longitude ) {
		
		
		conn();

		String sql = "update tbl_helmet set hm_impact_sensor =?,HM_GAS_SENSOR=?,latitude=?,longitude=?  where hm_id = ?";
		
		int result = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, hm_impact_sensor);
			psmt.setInt(2, gas_sensor);
			psmt.setFloat(3, latitude);
			psmt.setFloat(4, longitude);
			psmt.setString(5, hm_id);
			System.out.println("psmt 준비완료");
			result = psmt.executeUpdate();
			System.out.println("update 실행");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		
	}
	
	
	
	
	public ArrayList<SensorVO> AndroidGetSensor(String dept) {
		
		conn();
		
		String sql = "select * from tbl_helmet where worker_id=(select worker_id from tbl_worker where worker_dept=?) and (HM_GAS_SENSOR=1 or HM_IMPACT_SENSOR=1)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dept);
			rs = psmt.executeQuery();
			while (rs.next()) {
			
				String worker_id = rs.getString("worker_id");
				String hm_lock = rs.getString("HM_LOCK");
				float longitude = rs.getFloat("LONGITUDE");
				float latitude = rs.getFloat("LATITUDE");
				int hm_gas_sensor = rs.getInt("HM_GAS_SENSOR");
				int hm_impact_sensor = rs.getInt("HM_IMPACT_SENSOR");
				
				
				gpsvo = new SensorVO(latitude, longitude, hm_impact_sensor, hm_gas_sensor, worker_id, hm_lock);
				al.add(gpsvo);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return al;
	}
	
	
	
	
	public ArrayList<SensorVO> Gps() {
		
		gpsal = new ArrayList<SensorVO>();
		
		try {
		
			
			
			conn();
		
		
		// 4. SQL문 준비
		String sql = "select * from tbl_helmet";
		
		psmt = conn.prepareStatement(sql);

		rs = psmt.executeQuery();
		
		
		while (rs.next()) {

			String hm_id = rs.getString("hm_id");
			float latitude = rs.getFloat("latitude");
			float longitude = rs.getFloat("longitude");
			int hm_impact_sensor = rs.getInt("hm_impact_sensor");
			int hm_gas_sensor = rs.getInt("hm_gas_sensor");
			String worker_id = rs.getString("worker_id");
			
			
			System.out.println(hm_id);
			System.out.println(latitude);
			System.out.println(longitude);
			
			gpsvo = new SensorVO(latitude, longitude, hm_id, hm_gas_sensor, hm_impact_sensor, worker_id);
           
			gpsal.add(gpsvo);

		}
		for(SensorVO vo : gpsal ) {
			String sql2 = "select worker_dept, worker_name, worker_phone from tbl_worker where worker_id = ?";
			
			psmt = conn.prepareStatement(sql2);
			psmt.setString(1, vo.getworkerid());                                                                                              
			rs = psmt.executeQuery();
			
			
			if (rs.next()) {
				String worker_dept = rs.getString("worker_dept");
				String worker_name = rs.getString("worker_name");
				String worker_phone = rs.getString("worker_phone");
				
				
				gpsvo = new SensorVO(vo.getLatitude(),vo.getLongitude(), vo.getHm_id(), vo.getgas(), 
						vo.getimpact(), vo.getworkerid(),worker_dept, worker_name, worker_phone);
				al.add(gpsvo);
		}
		
		
		
		} 
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();

		}

		return al;
		
		
		
	}
	
	public ArrayList<SensorVO> Gps(String dept) {
		
		gpsal = new ArrayList<SensorVO>();
		
		try {					
			
			conn();
		
		
		// 4. SQL문 준비
		String sql = "select worker_id,worker_dept, worker_name, worker_phone from tbl_worker where worker_dept = ?";
		
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, dept);
		rs = psmt.executeQuery();
		
		
		while (rs.next()) {

			String worker_id = rs.getString(1);
			String worker_dept = rs.getString(2);
			String worker_name = rs.getString(3);
			String worker_phone = rs.getString(4);
			
			
			gpsvo = new SensorVO(0,0, "hm_id",0,0,worker_id,worker_dept, worker_name, worker_phone);
			
           
			gpsal.add(gpsvo);

		}
		for(SensorVO vo : gpsal ) {
			String sql2 = "select hm_impact_sensor,hm_gas_sensor,latitude,longitude,hm_id  from tbl_helmet where worker_id = ?";
			
			psmt = conn.prepareStatement(sql2);
			psmt.setString(1, vo.getworkerid());                                                                                              
			rs = psmt.executeQuery();
			
			
			if (rs.next()) {
				float latitude = rs.getFloat("latitude");
				float longitude = rs.getFloat("longitude");
				int hm_impact_sensor = rs.getInt("hm_impact_sensor");
				int hm_gas_sensor = rs.getInt("hm_gas_sensor");
				String hm_id = rs.getString("hm_id");
				
				
				gpsvo = new SensorVO(latitude,longitude, hm_id, hm_gas_sensor, 
						hm_impact_sensor, vo.getworkerid(),vo.getWorkerDept(), vo.getWorkerName(), vo.getWorkerPhone());
				al.add(gpsvo);
		}
		
		
		
		} 
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();

		}

		return al;
		
		
		
	}
	

	

	


//	public ArrayList<E> name() {
//		
//	}
}
