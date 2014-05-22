package ioedata.sensor.factory;

/**
 * Define various sensors
 * Define sensor data collection time intervals
 * Perform data collection actions
 * @author ajou
 *
 */
public abstract class Sensor {
	/*
	 * Define various sensors
	 */
	public static final int TYPE_ALL = 0;
	public static final int TYPE_ANALOG_SOUND = 1;
	public static final int TYPE_DUST = 2;
	public static final int TYPE_FLAME = 3;
	public static final int TYPE_HUMIDITY = 4;
	public static final int TYPE_LIGHT_BRIGHTNESS = 5;
	public static final int TYPE_RAINDROP = 6;
	public static final int TYPE_TEMPERATURE_CELSIUS = 7;
	public static final int TYPE_TEMPERATURE_FAHRENHEIT = 8;
	public static final int TYPE_ACCELEROMETER = 9;
	public static final int TYPE_DIGITAL_TILT = 10;
	public static final int TYPE_DIGITAL_VIBRATION = 11;
	public static final int TYPE_INFRARED_MOTION = 12;
	public static final int TYPE_TOUCH = 13;
	
	/*
	 * Define sensor data collection time intervals
	 */
	public static final int DATA_COLLECTION_INTERVAL_REAL_TIME = 0;
	public static final int DATA_COLLECTION_INTERVAL_RAPID = 1;
	public static final int DATA_COLLECTION_INTERVAL_MEDIUM = 2;
	public static final int DATA_COLLECTION_INTERVAL_SLOW = 3;
	public static final int DATA_COLLECTION_INTERVAL_SINGLE = 4;
	
	/*
	 * Get sensor type
	 */
	abstract int getSensorType();
	
	/*
	 * Get sensor data with return type of Number and Number[]
	 */
	public Number subscribeSingleData(String deviceId, String deviceIp, int deviceIpPort, String sensorType){
		
		return null;
	}
	public Number[] subscribeContinuousData(String deviceId, String deviceIp, int deviceIpPort, String sensorType, int dataCollectionInterval){
		
		return null;
	}
}






























