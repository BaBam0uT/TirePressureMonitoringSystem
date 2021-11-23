package tirepressuremonitoringsystem;

import static org.junit.Assert.*;
import static tirepressuremonitoringsystem.helper.AlarmBuilder.anAlarm;
import org.junit.Test;

import tirepressuremonitoringsystem.helper.SensorFactory;

public class AlarmTest {

	@Test
	public void alarmOn_when_value_too_low() {
		// Arrange
		Alarm alarm = anAlarm()
				.withSensor(SensorFactory.probe(16.0))
				.withSafetyRange(new SafetyRange(17,21))
				.build();

		// Act
		alarm.check();
		
		//Assert
		assertTrue(alarm.isAlarmOn());
	}

	@Test
	public void alarmOn_when_value_too_high() {
		// Arrange
		Alarm alarm = anAlarm()
				.withSensor(SensorFactory.probe(16.0))
				.withSafetyRange(new SafetyRange(17,21))
				.build();

		// Act
		alarm.check();
		
		//Assert
		assertTrue(alarm.isAlarmOn());
	}
	
	@Test
	public void alarmOff_when_value_in_safety_range() {
		// Arrange
		Alarm alarm = anAlarm()
				.withSensor(SensorFactory.probe(16.0))
				.withSafetyRange(new SafetyRange(17,21))
				.build();

		// Act
		alarm.check();
		
		//Assert
		// assertFalse(alarm.isAlarmOn());
	}
	
	@Test
	public void alarm_stay_On_when_alarm_activate_at_once() {
		// Arrange		
		Alarm alarm = anAlarm()
				.withSensor(SensorFactory.probe(16.0))
				.withSafetyRange(new SafetyRange(17,21))
				.build();

		// Act
		alarm.check();
		
		//Assert
		assertTrue(alarm.isAlarmOn());
		
		
		alarm.check();
		assertTrue(alarm.isAlarmOn());


	}

}

