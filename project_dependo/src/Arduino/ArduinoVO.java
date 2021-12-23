package Arduino;

public class ArduinoVO {
	private int attack;
	private float Lat;
	private float Long;
	private String lock;
	private int alram;
	private String hm_id;

	public ArduinoVO(int attack, int alram, String lock, float Lat, float Long, String hm_id) {
		this.attack = attack;
		this.Lat = Lat;
		this.Long = Long;
		this.alram = alram;
		this.lock = lock;
		this.hm_id = hm_id;
	}

	public int getAttack() {
		return attack;
	}

	public int getAlram() {
		return alram;
	}
	public String getLock() {
		return lock;
	}


	public float getLat() {
		return Lat;
	}

	public float getLong() {
		return Long;
	}

	public String getHm_id() {
		return hm_id;
	}
}
