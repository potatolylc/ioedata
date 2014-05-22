package ioedata.sensor.config;

import ioedata.sensor.factory.Sensor;


public class TypeFormat {
	public static int sensorTypeFormat(String sensorType){
		int sensorTypeNum = -1;
		if(sensorType.equals("all")){
			sensorTypeNum = Sensor.TYPE_ALL;
		} else if(sensorType.equals("analogsound")){
			sensorTypeNum = Sensor.TYPE_ANALOG_SOUND;
		} else if(sensorType.equals("dust")){
			sensorTypeNum = Sensor.TYPE_DUST;
		} else if(sensorType.equals("flame")){
			sensorTypeNum = Sensor.TYPE_FLAME;
		} else if(sensorType.equals("humidity")){
			sensorTypeNum = Sensor.TYPE_HUMIDITY;
		} else if(sensorType.equals("lightbrightness")){
			sensorTypeNum = Sensor.TYPE_LIGHT_BRIGHTNESS;
		} else if(sensorType.equals("raindrop")){
			sensorTypeNum = Sensor.TYPE_RAINDROP;
		} else if(sensorType.equals("temperaturecelsius")){
			sensorTypeNum = Sensor.TYPE_TEMPERATURE_CELSIUS;
		} else if(sensorType.equals("temperaturefahrenheit")){
			sensorTypeNum = Sensor.TYPE_TEMPERATURE_FAHRENHEIT;
		} else if(sensorType.equals("accelerometer")){
			sensorTypeNum = Sensor.TYPE_ACCELEROMETER;
		} else if(sensorType.equals("digitaltilt")){
			sensorTypeNum = Sensor.TYPE_DIGITAL_TILT;
		} else if(sensorType.equals("digitalvibration")){
			sensorTypeNum = Sensor.TYPE_DIGITAL_VIBRATION;
		} else if(sensorType.equals("infraredmotion")){
			sensorTypeNum = Sensor.TYPE_INFRARED_MOTION;
		} else if(sensorType.equals("touch")){
			sensorTypeNum = Sensor.TYPE_TOUCH;
		}
		return sensorTypeNum;
	}
	
	public static int dataCollectionIntervalFormat(String dataCollectionIntervalType){
		int dataCollectionInterval = -1;
		if(dataCollectionIntervalType.equals("realtime"))
			dataCollectionInterval = Sensor.DATA_COLLECTION_INTERVAL_REAL_TIME;
		else if(dataCollectionIntervalType.equals("rapid"))
			dataCollectionInterval = Sensor.DATA_COLLECTION_INTERVAL_RAPID;
		else if(dataCollectionIntervalType.equals("medium"))
			dataCollectionInterval = Sensor.DATA_COLLECTION_INTERVAL_MEDIUM;
		else if(dataCollectionIntervalType.equals("slow"))
			dataCollectionInterval = Sensor.DATA_COLLECTION_INTERVAL_SLOW;
		else if(dataCollectionIntervalType.equals("single"))
			dataCollectionInterval = Sensor.DATA_COLLECTION_INTERVAL_SINGLE;
		return dataCollectionInterval;
	}
}
