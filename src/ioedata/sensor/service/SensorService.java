package ioedata.sensor.service;

import java.util.List;

import ioedata.sensor.model.SensorValue;

public interface SensorService {
	public SensorValue getBasicSensorInfoByDeviceIdAndSensorTypeNum(String deviceId, int sensorTypeNum);
	public List<SensorValue> getBasicSensorInfoListByDeviceId(String deviceId);
}
