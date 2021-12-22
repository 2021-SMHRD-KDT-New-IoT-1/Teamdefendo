package Arduino;

public class ArduinoVO {
	private int attack;
	private float Lat;
	private float Long;
	private int lock;
	private int alram;

	public ArduinoVO(int attack, int alram, int lock, float Lat, float Long) {
		this.attack = attack;
		this.Lat = Lat;
		this.Long = Long;
		this.alram = alram;
		this.lock = lock;
	}

	public int getAttack() {
		return attack;
	}

	public int getAlram() {
		return alram;
	}


	public int getLock() {
		return lock;
	}


	public float getLat() {
		return Lat;
	}

	public float getLong() {
		return Long;
	}
}
