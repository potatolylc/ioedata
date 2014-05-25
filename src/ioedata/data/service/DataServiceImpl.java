package ioedata.data.service;

import java.util.List;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import ioedata.data.model.DataDao;
import ioedata.data.model.DataValue;
import ioedata.device.model.DeviceValue;
import ioedata.device.service.DeviceService;
import ioedata.sensor.config.SensorManager;
import ioedata.sensor.config.TypeFormat;
import ioedata.sensor.factory.Sensor;
import ioedata.sensor.model.SensorTypeValue;
import ioedata.sensor.model.SensorValue;
import ioedata.sensor.service.SensorService;

/**
 * This class provides services about sensor data.
 * It implements DataService interface.
 * @author ajou
 *
 */
@Service
public class DataServiceImpl implements DataService {
	@Resource(name = "dataDaoImpl")
	private DataDao dataDao;
	@Resource(name = "deviceServiceImpl")
	private DeviceService deviceService;
	@Resource(name = "sensorServiceImpl")
	private SensorService sensorService;
	
	/**
	 * Methods about data access or manipulation with DB
	 */
	/*
	 * Analyze sensor types and retrieve types, and take actions according to different retrieve types.
	 * If retrieve type comes in as "latest" and sensor type as "all", it means to retrieve the latest one data value set
	 * on a specific device regardless of a sensor type; but if sensor type comes in as a specific type,
	 * then retrieve the latest data record of that type on the request device. 
	 * (non-Javadoc)
	 * @see ioedata.data.service.DataService#retrieveData(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public DataValue retrieveData(String deviceId, String sensorType, String retrieveType) {
		DataValue dataVal = null;
		if(retrieveType.equals("latest") && sensorType.equals("all")){
			dataVal = this.retrieveLatestData(deviceId);
		} else if(retrieveType.equals("latest") && !sensorType.equals("all")){
			dataVal = this.retrieveLatestDataBySensorType(deviceId, TypeFormat.sensorTypeUrlFormat(sensorType));
		}
		return dataVal;
	}

	/*
	 * Retrieve the latest data of a specific device despite of a sensor type
	 */
	private DataValue retrieveLatestData(String deviceId){
		return this.dataDao.getLastDataByDeviceIdSortedByTimestamp(deviceId);
	}
	
	/*
	 * Retrieve the latest data of a specific device and a specific sensor type on that device
	 */
	private DataValue retrieveLatestDataBySensorType(String deviceId, int sensorTypeNum){
		SensorValue sensorVal = new SensorValue(new DeviceValue(deviceId), new SensorTypeValue(sensorTypeNum));
		return this.dataDao.getLastDataByDeviceIdAndSensorTypeSortedByTimestamp(sensorVal);
	}
	
	
	/**
	 * Methods about data collection or control with Arduino
	 */
	/*
	 * Based on the requested sensor type, create a new sensor to collect data on the requested device.
	 * The dataCollectionIntervalType defines the time interval when collecting data, which is divided into 
	 * realtime - for collecting continuous data per 2 seconds,
	 * rapid - for collecting continuous data per 3 minus,
	 * medium - for collecting continuous data per 10 minus,
	 * slow - for collecting continuous data per 30 minus, and
	 * single - for collecting only one data set per request.
	 * The collected data will be stored into sensor database for future use.
	 * If successfully stored, then return TRUE value; else, return FALSE value. 
	 * (non-Javadoc)
	 * @see ioedata.data.service.DataService#collectData(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean collectData(String deviceId, String sensorType, String dataCollectionIntervalType) {
		// Get the device info by deviceId
		DeviceValue deviceInfo = this.deviceService.getBasicDeviceInfoByDeviceId(deviceId);
		if(deviceInfo != null){
			// Format String type to int type
			int sensorTypeNum = TypeFormat.sensorTypeUrlFormat(sensorType);
			int dataCollectionInterval = TypeFormat.dataCollectionIntervalFormat(dataCollectionIntervalType);
			// Get Sensor instance from SensorManager factory
			Sensor sensor = SensorManager.getSensorManager().getSensor(sensorTypeNum);
			if(dataCollectionInterval == Sensor.DATA_COLLECTION_INTERVAL_SINGLE){ // If get data for just once 
				// Get one JSON data only once
				JSONObject jsonData = sensor.subscribeSingleJsonData(deviceId, deviceInfo.getDeviceIp(), deviceInfo.getDeviceIpPort(), sensorType);
				if(sensorType.equals("all")){
					List<SensorValue> list = this.sensorService.getBasicSensorInfoListByDeviceId(deviceId);
					for(SensorValue sensorInfo: list){
						//System.out.println(sensorInfo.getSensorSerialNum()+": "+jsonData.get(TypeFormat.sensorTypeResponseJsonKeyFormat(sensorInfo.getSensorTypeValue().getSensorType()))+", "+jsonData.get("sensorDataTimestamp"));
						// Create data value object of each sensor type and insert into sensor database
						DataValue dataVal = new DataValue(jsonData.get(TypeFormat.sensorTypeResponseJsonKeyFormat(sensorInfo.getSensorTypeValue().getSensorType())), jsonData.getString("sensorDataTimestamp"), sensorInfo);
						this.dataDao.insertSensorData(dataVal);
					}
				}else{
					SensorValue sensorInfo = this.sensorService.getBasicSensorInfoByDeviceIdAndSensorTypeNum(deviceId, sensorTypeNum);
					DataValue dataVal = new DataValue(jsonData.get(TypeFormat.sensorTypeResponseJsonKeyFormat(sensorType)), jsonData.getString("sensorDataTimestamp"), new SensorValue(sensorInfo.getSensorSerialNum()));
					this.dataDao.insertSensorData(dataVal);
				}
			}else{ // If get data continuously
				// Get continuous JSON data 
				
			}
		}
		return false;
	}

	
	

}




















