package tirepressuremonitoringsystem;

public class Alarm {
	private SafetyRange safetyRange;
	private Sensor sensor;
	private boolean alarmOn;

	public Alarm(Sensor sensor, SafetyRange safetyRange) {
		this.sensor = sensor;
		this.alarmOn = false;
		this.safetyRange = safetyRange;
	}

	public Alarm() {
		this(new PressureSensor(), new SafetyRange(17,21));
	}

	public void check() {
		double value = probeValue();

		if (isNotInSafetyRange(value)) {
			activateAlarm();
		}
	}

	private double probeValue() {
		return sensor.probeValue();
	}

	private boolean isNotInSafetyRange(double value) {
		return safetyRange.doesNotContain(value);
	}

	private void activateAlarm() {
		alarmOn = true;
	}

	public boolean isAlarmOn() {
		return alarmOn;
	}
}
