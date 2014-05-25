package ioedata.sensor.factory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;

import org.json.JSONException;
import org.json.JSONObject;

import ioedata.data.model.DataValue;

/**
 * Define various sensors.
 * Define sensor data collection time intervals.
 * Perform data collection actions for both single collection and continuous collection.
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
	 * Get sensor data with return type of Json String
	 */
	public JSONObject subscribeSingleJsonData(String deviceId, String deviceIp, int deviceIpPort, String sensorType){
		//System.out.println("subscribe single "+deviceIp+" "+deviceIpPort);
		String urlStr = "http://"+deviceIp+":"+deviceIpPort+"/sensorData/"+deviceId+"/"+sensorType;
		//System.out.println(urlStr);
		try {
			URL url = new URL(urlStr);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			int resCode = con.getResponseCode();
			if(resCode == 200){
				String dataTimestamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(System.currentTimeMillis());
				BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
				if(br != null){
					String response = br.readLine();
					JSONObject json = new JSONObject(response);
					json.put("sensorDataTimestamp", dataTimestamp);
					return json;
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public JSONObject[] subscribeContinuousData(String deviceId, String deviceIp, int deviceIpPort, String sensorType, int dataCollectionInterval){
		System.out.println("subscribe continuous");
		return null;
	}
}






























