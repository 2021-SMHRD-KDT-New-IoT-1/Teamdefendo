package Member;

import java.sql.Date;

public class MemberVO {
	
	String worker_id;
	String worker_pw;
	String worker_dept;
	String worker_name;
	String worker_phone;
	String worker_joindate;
	String admin_yesno;
	
	String hm_lock;
	String education;
	
	
	
	
	
	
	public MemberVO(String worker_id, String worker_pw, String worker_dept, String worker_name, String worker_phone, String worker_joindate) {
		
		this.worker_id = worker_id;
		this.worker_pw = worker_pw;
		this.worker_dept = worker_dept;
		this.worker_name = worker_name;
		this.worker_phone = worker_phone;
		this.worker_joindate = worker_joindate;
	}


	public MemberVO(String worker_id, String worker_pw, String worker_dept, String worker_name, String worker_phone,
			String worker_joindate, String admin_yesno) {
		
		this.worker_id = worker_id;
		this.worker_pw = worker_pw;
		this.worker_dept = worker_dept;
		this.worker_name = worker_name;
		this.worker_phone = worker_phone;
		this.worker_joindate = worker_joindate;
		this.admin_yesno = admin_yesno;
	}
	
	public MemberVO(String worker_id, String worker_pw, String worker_dept, String worker_name, String worker_phone,
			String worker_joindate, String admin_yesno, String education) {
		
		this.worker_id = worker_id;
		this.worker_pw = worker_pw;
		this.worker_dept = worker_dept;
		this.worker_name = worker_name;
		this.worker_phone = worker_phone;
		this.worker_joindate = worker_joindate;
		this.admin_yesno = admin_yesno;
		this.education = education;
	}
	
	
	
	
	public MemberVO(String worker_id, String worker_dept, String worker_name, String worker_phone) {
		this.worker_dept = worker_dept;
		this.worker_name = worker_name;
		this.worker_phone = worker_phone;
	}
	



	public String getHm_lock() {
		return hm_lock;
	}





	public String getEducation() {
		return education;
	}





	

	public MemberVO(String worker_name, String worker_joindate, String hm_lock, String education,String worker_id) {
		
		this.worker_id = worker_id;
		this.worker_name = worker_name;
		this.worker_joindate = worker_joindate;
		this.hm_lock = hm_lock;
		this.education = education;
	}





	public String getWorker_id() {
		return worker_id;
	}

	public String getWorker_pw() {
		return worker_pw;
	}

	public String getWorker_dept() {
		return worker_dept;
	}

	public String getWorker_name() {
		return worker_name;
	}

	public String getWorker_phone() {
		return worker_phone;
	}

	public String getWorker_joindate() {
		return worker_joindate;
	}

	public String getAdmin_yesno() {
		return admin_yesno;
	}
	

}
