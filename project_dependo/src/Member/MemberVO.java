package Member;

import java.sql.Date;

public class MemberVO {
	
	String id;
	Date StartTime;
	Date endTime;
	String att_type;

	

	public MemberVO(String id, Date startTime, Date endTime, String att_type) {
		
		this.id = id;
		this.StartTime = startTime;
		this.endTime = endTime;
		this.att_type = att_type;
	}


	public String getAtt_type() {
		return att_type;
	}


	public String getId() {
		return id;
	}


	public Date getStartTime() {
		return StartTime;
	}


	public Date getEndTime() {
		return endTime;
	}
	
	
	


}
