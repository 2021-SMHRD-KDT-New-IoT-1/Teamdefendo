package Attendance;

import java.sql.Date;

public class AttendanceVO {
	

	String worker_id;
	Date start_time;
	Date end_time; 
	String att_type;
	
	
	
	
	public AttendanceVO(String worker_id, Date start_time, Date end_time, String att_type) {
	
		this.worker_id = worker_id;
		this.start_time = start_time;
		this.end_time = end_time;
		this.att_type = att_type;
	}
	
	public String getWorker_id() {
		return worker_id;
	}
	public Date getStart_time() {
		return start_time;
	}
	public Date getEnd_time() {
		return end_time;
	}
	public String getAtt_type() {
		return att_type;
	}
	
	
	
	

}
