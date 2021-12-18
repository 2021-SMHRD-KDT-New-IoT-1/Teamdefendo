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
		ResultSet rs1;
	 
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
		
		
		public int Join(String id, String password, String name, String tel,String dept, String check_manager) {
		
			
			try {
			
		
			
			System.out.println("dao Join : "+id+"/"+password+"/"+name+"/"+tel+"/"+dept+"/"+check_manager);
			
			DBcon();

			// 4. SQL문 준비
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

				// 4. 바인드 변수 채워두기
				pstmt.setString(1, id);
				
				// 5. sql문 실행 후 결과 처리
				rs = pstmt.executeQuery();
			
				if (rs.next()) {
					// 입력한 이메일을 사용할 수 없을때
					
					check =true;
					

				} else {
					// 입력한 이메일을 사용할 수 있을때
					
					check=false; 
					//초기값은 false라 안적어도 되는데 직관적으로 보기 편하게
				}
				

			} catch (Exception e) {
				
				System.out.println("로그인실패");
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

				// 4. 바인드 변수 채워두기
				pstmt.setString(1, id);
				pstmt.setString(2, pw);
				
				// 5. sql문 실행 후 결과 처리
				rs = pstmt.executeQuery();
				
				
				
				if (rs.next()) {
				
					try {
						System.out.println("11111번");

						String sql1 = "select * FROM tbl_attendance where worker_id=?";
						pstmt = con.prepareStatement(sql1);
						pstmt.setString(1, id);
						rs1 = pstmt.executeQuery();
						
						
						
						if (rs1.next()) {

							
							Date start_time= rs1.getDate("start_time"); 
							Date end_time= rs1.getDate("end_time"); 
							String att_type = rs1.getString("att_type");
							
							vo = new MemberVO(id, start_time, end_time, att_type);
							System.out.println("222222번");
						}
					} catch (Exception e) {
						
						e.printStackTrace();
					} finally {

						if (rs1 != null) {
							rs1.close();
						}

					}


				}
				

			} catch (Exception e) {
				
				System.out.println("로그인실패");
				e.printStackTrace();
				
			} finally {

				DBclose();

			}
			
			return vo;
		
			
		}
		
		
		
		
			
		public int Hmregistration(String hm_id, String worker_id) {
			
			try {
		
			
				DBcon();

				// 4. SQL문 준비
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
			
			
		
		
		
		
	
		public void StartTime(String worker_id,String start_time,String att_type) {
			

			try {
			
			
			DBcon();

			
			String sql1 = "select worker_id FROM tbl_worker where worker_id=?";
			

			pstmt = con.prepareStatement(sql1);

			// 4. 바인드 변수 채워두기
			pstmt.setString(1, worker_id);
			
			// 5. sql문 실행 후 결과 처리
			rs = pstmt.executeQuery();
			
			
			
			// 4. SQL문 준비
			String sql2 = "insert into tbl_attendance(worker_id, start_time, att_type) values(?,?,?,)";
			pstmt = con.prepareStatement(sql2);
			pstmt.setString(1, worker_id);
			pstmt.setString(2, start_time);
			pstmt.setString(3, att_type);
		
			
			cnt = pstmt.executeUpdate();
		
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBclose();

			}
	
			
		}
		
		
		public void endTime(String worker_id,String end_time,String att_type) {
			

			try {
			
			
			DBcon();

			// 4. SQL문 준비
			String sql = "update tbl_attendance(end_time, att_type) values(?,?) where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, end_time);
			pstmt.setString(2, att_type);
			pstmt.setString(3, worker_id);
		
			
			cnt = pstmt.executeUpdate();
		
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBclose();

			}
	
			
		}
		
		
		
	    
	    
	}

	

