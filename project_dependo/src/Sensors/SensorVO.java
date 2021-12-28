package Sensors;

public class SensorVO {
	
	private int mysensor;
	
	float latitude; //위도
	float longitude; // 경도
	String hm_id; // 근로자 이름
	int hm_impact_sensor;
	int hm_gas_sensor;
	String worker_id;
	String worker_dept;
	String worker_name;
	String worker_phone;
	String lock;
	
	
	
	public SensorVO(float latitude, float longitude, int hm_impact_sensor, int hm_gas_sensor, String worker_id, String lock) {
		
		this.latitude = latitude;
		this.longitude = longitude;
		this.hm_impact_sensor = hm_impact_sensor;
		this.hm_gas_sensor = hm_gas_sensor;
		this.worker_id = worker_id;
		this.lock=lock;
	}
	
	
	
	public float getLatitude() {
		return latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public String getHm_id() {
		return hm_id;
	}
	public SensorVO(float latitude, float longitude, String hm_id, int hm_impact_sensor,int hm_gas_sensor, String worker_id
			, String worker_dept, String worker_name, String worker_phone) {
		
		this.latitude = latitude;
		this.longitude = longitude;
		this.hm_id = hm_id;
		this.hm_gas_sensor = hm_gas_sensor;
		this.hm_impact_sensor = hm_impact_sensor;
		this.worker_id = worker_id;
		this.worker_dept = worker_dept;
		this.worker_name = worker_name;
		this.worker_phone = worker_phone;
	}
	public SensorVO(float latitude, float longitude, String hm_id, int hm_impact_sensor,int hm_gas_sensor, String worker_id) {
		
		this.latitude = latitude;
		this.longitude = longitude;
		this.hm_id = hm_id;
		this.hm_gas_sensor = hm_gas_sensor;
		this.hm_impact_sensor = hm_impact_sensor;
		this.worker_id = worker_id;
		
	}
	
	

	public SensorVO() {
	}

	public SensorVO(int mysensor) {
		this.mysensor = mysensor;
	}

	public int getMysensor() {
		return mysensor;
	}

	public void setMysensor(int mysensor) {
		this.mysensor = mysensor;
	}
	public int getgas() {
		return hm_gas_sensor;
	}
	public int getimpact() {
		return hm_impact_sensor;
	}
	public String getworkerid() {
		return worker_id;
	}
	public String getWorkerName() {
		return worker_name;
	}
	public String getWorkerPhone() {
		return worker_phone;
	}
	public String getWorkerDept() {
		return worker_dept;
	}

	@Override
	public String toString() {
		return "SensorVO [mysensor=" + mysensor + "]";
	}

}
