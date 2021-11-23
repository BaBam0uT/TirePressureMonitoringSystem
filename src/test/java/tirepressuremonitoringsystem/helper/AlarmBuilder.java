package tirepressuremonitoringsystem.helper;

import tirepressuremonitoringsystem.Alarm;
import tirepressuremonitoringsystem.SafetyRange;
import tirepressuremonitoringsystem.Sensor;

public class AlarmBuilder {

	Sensor sensor;
	SafetyRange safetyRange;
	
	public AlarmBuilder withSensor(Sensor sensor) {
		this.sensor = sensor;
		return this;
	}
	
	public AlarmBuilder withSafetyRange(SafetyRange safetyRange) {
		this.safetyRange = safetyRange;
		return this;
	}
	
	public Alarm build() {
		return new Alarm(sensor, safetyRange);
	}

	public static AlarmBuilder anAlarm() {
		return new AlarmBuilder();
	}
}
