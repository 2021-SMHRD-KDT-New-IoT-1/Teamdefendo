package Member;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {

	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	int cnt;
	boolean check;
	MemberVO vo = null;
	MemberVO vo2 = null;
	ArrayList<MemberVO> al1 = null;
	
	
	public void DBcon() {
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			String db_url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String db_id = "campus_a_3_1215";
			String db_pw = "smhrd3";
			con = DriverManager.getConnection(db_url, db_id, db_pw);

			if (con != null) {
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

	public int Join(String id, String password, String name, String tel, String dept, String check_manager) {

		try {

		
			DBcon();

			String sql = "insert into tbl_worker(worker_id, worker_pw, worker_name, worker_phone,worker_dept, ADMIN_YESNO) values(?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			pstmt.setString(3, name);
			pstmt.setString(4, tel);
			pstmt.setString(5, dept);
			pstmt.setString(6, check_manager);

			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBclose();

		}

		return cnt;

	}

	public boolean idCheck(String id) {

		try {
			DBcon();

			String sql = "select worker_id FROM tbl_worker where worker_id=?";

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				check = true;

			} else {

				check = false;
				
			}

		} catch (Exception e) {

			System.out.println("로그인실패");
			e.printStackTrace();

		} finally {

			DBclose();

		}

		return check;

	}

	public MemberVO Login(String id, String pw) {

		try {
			DBcon();
			System.out.println(con);

			String sql = "select * FROM tbl_worker where worker_id=? and worker_pw=?";

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, id);
			pstmt.setString(2, pw);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				String worker_id = rs.getString("worker_id");
				String worker_pw = rs.getString("worker_pw");
				String worker_dept = rs.getString("worker_dept");
				String worker_name = rs.getString("worker_name");
				String worker_phone = rs.getString("worker_phone");
				String worker_joindate = rs.getString("worker_joindate");
				String admin_yesno = rs.getString("admin_yesno");

				vo = new MemberVO(worker_id, worker_pw, worker_dept, worker_name, worker_phone, worker_joindate,
						admin_yesno);

			}

		} catch (Exception e) {

			System.out.println("로그인실패");
			e.printStackTrace();

		} finally {

			DBclose();

		}

		return vo;

	}
	
	
	public MemberVO AndroidLogin(String id, String pw) {

		try {
			DBcon();
			System.out.println(con);

			String sql = "select * FROM tbl_worker where worker_id=? and worker_pw=?";

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, id);
			pstmt.setString(2, pw);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				String worker_id = rs.getString("worker_id");
				String worker_pw = rs.getString("worker_pw");
				String worker_dept = rs.getString("worker_dept");
				String worker_name = rs.getString("worker_name");
				String worker_phone = rs.getString("worker_phone");
				String worker_joindate = rs.getString("WORKER_JOINDATE");
				String admin_yesno = rs.getString("admin_yesno");

				vo = new MemberVO(worker_id, worker_pw, worker_dept, worker_name, worker_phone, worker_joindate);
			}
			

		} catch (Exception e) {

			System.out.println("로그인실패");
			e.printStackTrace();

		} finally {

			DBclose();

		}

		return vo;

	}
	
	
	

	
	public int Update(String setid,String password,String name,String tel,String dept) {
		
		
		try {

			DBcon();
			
			
			String sql = "UPDATE tbl_worker SET worker_pw=?, worker_name=?, worker_phone=?,worker_dept=? WHERE worker_id =?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, password);
			pstmt.setString(2, name);
			pstmt.setString(3, tel);
			pstmt.setString(4, dept);
			pstmt.setString(5, setid);
			

			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBclose();

		}
	
		
		
		return cnt;
	}
	
	
	
	public int delete(String WORKER_ID) {
		
		
		try {
			DBcon();
			String sql = "DELETE TBL_WORKER  WHERE WORKER_ID= ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, WORKER_ID);
			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("삭제실패");
		} finally {
			DBclose();
		}
		return cnt;
		
	}
	
	public ArrayList<MemberVO> select(String WORKER_DEPT) {
		
		al1 = new ArrayList<MemberVO>(); 
		
		try {
			DBcon();

			String sql = "select w.worker_id,w.worker_name, h.hm_lock, w.education, w.worker_joindate from tbl_helmet h,tbl_worker w where h.worker_id=w.worker_id and w.WORKER_DEPT=?";

			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, WORKER_DEPT);
			
			rs = pstmt.executeQuery();


			while (rs.next()) {

				
				String worker_name = rs.getString("worker_name");
				String hm_lock = rs.getString("hm_lock");
				String education = rs.getString("education");
				String worker_joindate = rs.getString("worker_joindate");
				String worker_id = rs.getString("worker_id");			
				
				vo2 = new MemberVO(worker_name, worker_joindate, hm_lock, education, worker_id);							
				
				al1.add(vo2);
				
			}

		} catch (Exception e) {
			System.out.println("조회실패");
			e.printStackTrace();
		} finally {
			DBclose();
		}
		return al1;
		
	}
	
	
	
	
	public ArrayList<MemberVO> selectAll() {

		al1 = new ArrayList<MemberVO>(); 
		
		try {
			DBcon();

			String sql = "select w.worker_id,w.worker_name, h.hm_lock, w.education, w.worker_joindate from tbl_helmet h,tbl_worker w where h.worker_id=w.worker_id";

			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();


			while (rs.next()) {

				
				String worker_name = rs.getString("worker_name");
				String hm_lock = rs.getString("hm_lock");
				String education = rs.getString("education");
				String worker_joindate = rs.getString("worker_joindate");
				String worker_id = rs.getString("worker_id");
			
				
				vo2 = new MemberVO(worker_name, worker_joindate, hm_lock, education, worker_id);
							
				
				al1.add(vo2);
				
			}

		} catch (Exception e) {
			System.out.println("조회실패");
			e.printStackTrace();
		} finally {
			DBclose();
		}
		return al1;
	}
	
	public int update3(String hm_id, String setid) {
		
		try {

			DBcon();
			
			
			String sql = "UPDATE tbl_helmet SET hm_id=? WHERE worker_id =?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, hm_id);		
			pstmt.setString(2, setid);
			

			cnt = cnt+ pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBclose();

		}
	
		
		
		return cnt;
		
	
	}
	
	
	public int update2(String worker_name,String worker_id,String admin_yesno,String worker_dept,String setid) {
		
		System.out.print(worker_name+ worker_id+ admin_yesno+ worker_dept+ setid);

		
		try {

			DBcon();
			
			
			String sql = "UPDATE tbl_worker SET WORKER_NAME=?, WORKER_ID=?, ADMIN_YESNO=?, WORKER_DEPT=? WHERE worker_id =?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, worker_name);
			pstmt.setString(2, worker_id);
			pstmt.setString(3, admin_yesno);
			pstmt.setString(4, worker_dept);
			pstmt.setString(5, setid);
			

			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBclose();

		}
		return cnt;
	}

	
}
