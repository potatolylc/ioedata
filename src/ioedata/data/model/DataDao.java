package ioedata.data.model;

import ioedata.sensor.model.SensorValue;

public interface DataDao {
	public DataValue getLastDataByDeviceIdSortedByTimestamp(String deviceId);
	public DataValue getLastDataByDeviceIdAndSensorTypeSortedByTimestamp(SensorValue sensorVal);
	public int insertSensorData(DataValue dataVal);
}
