package Sensors;

public class SensorVO {
	
	private int mysensor;
	
	float latitude; //위도
	float longitude; // 경도
	String hm_id; // 근로자 이름
	int hm_impact_sensor;
	int hm_gas_sensor;
	
	
	public float getLatitude() {
		return latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public String getHm_id() {
		return hm_id;
	}
	public SensorVO(float latitude, float longitude, String hm_id, int hm_impact_sensor,int hm_gas_sensor) {
		
		this.latitude = latitude;
		this.longitude = longitude;
		this.hm_id = hm_id;
		this.hm_gas_sensor = hm_gas_sensor;
		this.hm_impact_sensor = hm_impact_sensor;
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

	@Override
	public String toString() {
		return "SensorVO [mysensor=" + mysensor + "]";
	}

}
