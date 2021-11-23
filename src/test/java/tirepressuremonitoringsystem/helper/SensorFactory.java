package tirepressuremonitoringsystem.helper;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import tirepressuremonitoringsystem.PressureSensor;
import tirepressuremonitoringsystem.Sensor;

public class SensorFactory {

	public static Sensor probe(Double value, Double... values) {
		Sensor sensor = mock(PressureSensor.class);
		when(sensor.probeValue()).thenReturn(value, values);
		return sensor;
	}

}
