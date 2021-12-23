package Sensors;

public class AlarmVO {

	public int HM_IMPACT_SENSOR;
	public int HM_GAS_SENSOR;
	public String WORKER_ID;
	
	public AlarmVO(int hM_IMPACT_SENSOR, int hM_GAS_SENSOR, String WORKER_ID) {
		
		this.HM_IMPACT_SENSOR = hM_IMPACT_SENSOR;
		this.HM_GAS_SENSOR = hM_GAS_SENSOR;
		this.WORKER_ID = WORKER_ID;
	}

	public int getHM_IMPACT_SENSOR() {
		return HM_IMPACT_SENSOR;
	}

	public int getHM_GAS_SENSOR() {
		return HM_GAS_SENSOR;
	}

	public String getWORKER_ID() {
		return WORKER_ID;
	}
}
