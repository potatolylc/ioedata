package ioedata.service.sensor.factory;

import org.json.JSONObject;

/**
 * Define various sensors
 * Define sensor data collection time intervals
 * Perform data collection actions
 * @author ajou
 *
 */
public interface Sensor {
	/*
	 * Define various sensors
	 */
	static final int TYPE_ALL = 0;
	static final int TYPE_ANALOG_SOUND = 1;
	static final int TYPE_DUST = 2;
	static final int TYPE_FLAME = 3;
	static final int TYPE_HUMIDITY = 4;
	static final int TYPE_LIGHT = 5;
	static final int TYPE_RAINDROP = 6;
	static final int TYPE_TEMPERATURE = 7;
	static final int TYPE_ACCELEROMETER = 8;
	static final int TYPE_DIGITAL_TILT = 9;
	static final int TYPE_DIGITAL_VIBRATION = 10;
	static final int TYPE_INFRARED_MOTION = 11;
	static final int TYPE_TOUCH = 12;
	
	/*
	 * Define sensor data collection time intervals
	 */
	static final int DATA_COLLECTION_INTERVAL_REAL_TIME = 0;
	static final int DATA_COLLECTION_INTERVAL_RAPID = 1;
	static final int DATA_COLLECTION_INTERVAL_MEDIUM = 2;
	static final int DATA_COLLECTION_INTERVAL_SLOW = 3;
	
	/*
	 * Get sensor type
	 */
	abstract int getSensorType();
	
	/*
	 * Get sensor data with return type of Object and Object[]
	 */
	abstract Object getSensorData(String deviceId, int sensorType, int dataCollectionInterval);
	abstract Object[] getSensorDataSet(String deviceId, int sensorType, int dataCollectionInterval);
}






























