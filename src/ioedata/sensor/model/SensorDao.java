package ioedata.sensor.model;

import java.util.List;

public interface SensorDao {
	public SensorValue getBasicSensorInfoByDeviceIdAndSensorTypeNum(SensorValue sensorVal);
	public List<SensorValue> getBasicSensorInfoListByDeviceId(String deviceId);
}
