package ioedata.data.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ioedata.data.model.DataDao;
import ioedata.data.model.DataValue;
import ioedata.sensor.config.SensorManager;
import ioedata.sensor.config.TypeFormat;
import ioedata.sensor.factory.Sensor;

@Service
public class DataServiceImpl implements DataService {
	@Resource(name = "dataDaoImpl")
	private DataDao dataDao;
	
	/*
	 * Methods about data access or manipulation with DB
	 */
	@Override
	public DataValue retrieveData(String deviceId, String retrieveType) {
		DataValue dataVal = null;
		if(retrieveType.equals("latest")){
			dataVal = this.retrieveLatestData(deviceId);
		}
		return dataVal;
	}

	private DataValue retrieveLatestData(String deviceId){
		return this.dataDao.getLastDataByDeviceIdSortedByTimestamp(deviceId);
	}
	
	
	/*
	 * Methods about data collection or control with Arduino
	 */
	@Override
	public boolean collectData(String deviceId, String sensorType, String dataCollectionIntervalType) {
		// Get the device info by deviceId
		
		
		int sensorTypeNum = TypeFormat.sensorTypeFormat(sensorType);
		int dataCollectionInterval = TypeFormat.dataCollectionIntervalFormat(dataCollectionIntervalType);
		Sensor sensor = SensorManager.getSensorManager().getSensor(sensorTypeNum);
		if(dataCollectionInterval == Sensor.DATA_COLLECTION_INTERVAL_SINGLE){
			//sensor.subscribeSingleData(deviceId, deviceIp, deviceIpPort, sensorType);
		}else{
			
		}
		return false;
	}

	
	

}




















