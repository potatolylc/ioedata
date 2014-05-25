package ioedata.data.service;

import ioedata.data.model.DataValue;

public interface DataService {
	/*
	 * Methods that are related to data access and manipulation with DB
	 */
	public DataValue retrieveData(String deviceId, String sensorType, String retrieveType);
	
	/*
	 * Methods that are related to data collection and control with Arduino
	 */
	public boolean collectData(String deviceId, String sensorType, String dataCollectionIntervalType);
}
