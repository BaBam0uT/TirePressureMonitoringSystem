package tirepressuremonitoringsystem;

public class Alarm {
	private final double lowPressureThreshold;
	private final double highPressureThreshold;

	Sensor sensor;

	boolean alarmOn;

	public Alarm(Sensor sensor) {
		this.sensor = sensor;
		this.alarmOn = false;
		this.lowPressureThreshold = 17;
		this.highPressureThreshold = 21;
	}

	public Alarm() {
		this(new PressureSensor());
	}

	public void check() {
		double psiPressureValue = probePsiPressureValue();

		if (isNotInSafetyRange(psiPressureValue)) {
			activateAlarm();
		}
	}

	private double probePsiPressureValue() {
		double psiPressureValue = sensor.popNextPressurePsiValue();
		return psiPressureValue;
	}

	private boolean isNotInSafetyRange(double psiPressureValue) {
		return psiPressureValue < lowPressureThreshold || highPressureThreshold < psiPressureValue;
	}

	private void activateAlarm() {
		alarmOn = true;
	}

	public boolean isAlarmOn() {
		return alarmOn;
	}
}
