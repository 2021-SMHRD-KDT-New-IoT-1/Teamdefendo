package Arduino;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArduinoDAO {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	private void conn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String db_url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String db_id = "campus_a_3_1215";
			String db_pw = "smhrd3";
			conn = DriverManager.getConnection(db_url, db_id, db_pw);
			
			if (conn != null) {
				System.out.println("DB 접속 성공");
			}
		
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패");
		} catch (SQLException e) {
			System.out.println("DB 접속 실패");
			e.printStackTrace();
		}
	}

	private void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArduinoVO getSensor(String hm_id) {
		ArduinoVO vo = null;
		try {
			System.out.println(hm_id);
			System.out.println("select접속 성공");
			conn();
			String sql = "select hm_impact_sensor, latitude, longitude, hm_lock, hm_gas_sensor from tbl_helmet WHERE hm_id = ?";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, hm_id);
			rs = psmt.executeQuery();

			if (rs.next()) {				
				int attack = rs.getInt(1);
				float Lat = rs.getFloat(2);
				float Long = rs.getFloat(3);
				String lock = rs.getString(4);
				int alram = rs.getInt(5);

				System.out.println(attack);
				System.out.println(alram);
				System.out.println(lock);
				System.out.println(Lat);
				System.out.println(Long);
				vo = new ArduinoVO(attack, alram, lock, Lat, Long, hm_id);
			}
			else {
				System.out.println("실패개꿀이녀");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	public ArduinoVO update(int attack, float Lat, float Long, int alram, String lock, String hm_id) {
		ArduinoVO vo = null;
		System.out.println("update접속 성공");
		try {
			conn();
			String sql = "update tbl_helmet set hm_impact_sensor = ?, latitude = ?, longitude = ?, hm_lock = ?, hm_gas_sensor = ? WHERE hm_id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, attack);
			psmt.setFloat(2, Lat);
			psmt.setFloat(3, Long);
			psmt.setString(4, lock);
			psmt.setInt(5, alram);
			psmt.setString(6, hm_id);
			psmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		vo = getSensor(hm_id);
		return vo;
	}
}
