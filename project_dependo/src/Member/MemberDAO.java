package Member;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {

	

	  
	    Connection con;
	    PreparedStatement pstmt;
	    ResultSet rs;
	    int cnt;
		boolean check;
		MemberVO vo = null;
		AttendanceVO avo = null;

	 
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
		
		
		public int Join(String id, String password, String name, String tel,String dept, String check_manager) {
		
			
			try {
			
		
			
			System.out.println("dao Join : "+id+"/"+password+"/"+name+"/"+tel+"/"+dept+"/"+check_manager);
			
			DBcon();

			// 4. SQL�� �غ�
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

				// 4. ���ε� ���� ä���α�
				pstmt.setString(1, id);
				
				// 5. sql�� ���� �� ��� ó��
				rs = pstmt.executeQuery();
			
				if (rs.next()) {
					// �Է��� �̸����� ����� �� ������
					
					check =true;
					

				} else {
					// �Է��� �̸����� ����� �� ������
					
					check=false; 
					//�ʱⰪ�� false�� ����� �Ǵµ� ���������� ���� ���ϰ�
				}
				

			} catch (Exception e) {
				
				System.out.println("�α��ν���");
				e.printStackTrace();
				
			} finally {

				DBclose();

			}
			
			return check;
			
		
			
		}
		
		
		public MemberVO Login(String id,String pw) {
			
			System.out.println(id+"//"+pw);
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
					String worker_id = rs.getString("worker_id");
					String worker_pw = rs.getString("worker_pw");
					String worker_dept = rs.getString("worker_dept");
					String worker_name = rs.getString("worker_name");
					String worker_phone = rs.getString("worker_phone");
					Date worker_joindate = rs.getDate("worker_joindate");
					String admin_yesno = rs.getString("admin_yesno");
					
				
					vo = new MemberVO(worker_id, worker_pw, worker_dept, worker_name, worker_phone, worker_joindate, admin_yesno);
				
				}
				


			} catch (Exception e) {
				
				System.out.println("�α��ν���");
				e.printStackTrace();
				
			} finally {

				DBclose();

			}
			
			return vo;
		
			
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
		

	

