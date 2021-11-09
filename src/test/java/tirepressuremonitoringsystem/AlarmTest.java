package tirepressuremonitoringsystem;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class AlarmTest {

	@Test
	public void alarmOn_when_value_too_low() {
		// Arrange
		PressureSensor sensor = probe(16.0);
		
		Alarm alarm = new Alarm(sensor);

		// Act
		alarm.check();
		
		//Assert
		assertTrue(alarm.isAlarmOn());
	}
	
	@Test
	public void alarmOn_when_value_too_high() {
		// Arrange
		PressureSensor sensor = probe(22.0);
		
		Alarm alarm = new Alarm(sensor);

		// Act
		alarm.check();
		
		//Assert
		assertTrue(alarm.isAlarmOn());
	}
	
	@Test
	public void alarmOff_when_value_in_safety_range() {
		// Arrange
		PressureSensor sensor = probe(18.0);

		Alarm alarm = new Alarm(sensor);

		// Act
		alarm.check();
		
		//Assert
		assertFalse(alarm.isAlarmOn());
	}
	
	@Test
	public void alarm_stay_On_when_alarm_activate_at_once() {
		// Arrange
		PressureSensor sensor = probe(25.0,19.0);
		
		Alarm alarm = new Alarm(sensor);

		// Act
		alarm.check();
		
		//Assert
		assertTrue(alarm.isAlarmOn());
		
		
		alarm.check();
		assertTrue(alarm.isAlarmOn());


	}
	
	private PressureSensor probe(Double value, Double... values) {
		PressureSensor sensor = mock(PressureSensor.class);
		when(sensor.popNextPressurePsiValue()).thenReturn(value, values);
		return sensor;
	}

}

