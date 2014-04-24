package ioedata.service.sensor.factory;

import ioedata.service.sensor.factory.implemented.AllSensorsImpl;

public final class SensorManager {
	private SensorManager() {
	}

	private static SensorManager sensorManager = new SensorManager();

	public static SensorManager getSensorManager() {
		return sensorManager;
	}

	public Sensor getSensor(int sensorType) {
		Sensor sensor = null;
		if (sensorType == Sensor.TYPE_ALL) {
			sensor = new AllSensorsImpl();
		} else if (sensorType == Sensor.TYPE_ACCELEROMETER) {

		} else if (sensorType == Sensor.TYPE_ANALOG_SOUND) {

		} else if (sensorType == Sensor.TYPE_DIGITAL_TILT) {

		} else if (sensorType == Sensor.TYPE_DIGITAL_VIBRATION) {

		} else if (sensorType == Sensor.TYPE_DUST) {

		} else if (sensorType == Sensor.TYPE_FLAME) {

		} else if (sensorType == Sensor.TYPE_HUMIDITY) {

		} else if (sensorType == Sensor.TYPE_INFRARED_MOTION) {

		} else if (sensorType == Sensor.TYPE_LIGHT) {

		} else if (sensorType == Sensor.TYPE_RAINDROP) {

		} else if (sensorType == Sensor.TYPE_TEMPERATURE) {

		} else if (sensorType == Sensor.TYPE_TOUCH) {

		}
		return sensor;
	}

}
