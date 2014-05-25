package ioedata.sensor.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ioedata.device.model.DeviceValue;
import ioedata.sensor.model.SensorDao;
import ioedata.sensor.model.SensorTypeValue;
import ioedata.sensor.model.SensorValue;

/**
 * This class provides services about sensors.
 * It implements SensorService interface.
 * @author ajou
 *
 */
@Service
public class SensorServiceImpl implements SensorService {
	@Resource(name = "sensorDaoImpl")
	private SensorDao sensorDao;

	@Override
	public SensorValue getBasicSensorInfoByDeviceIdAndSensorTypeNum(
			String deviceId, int sensorTypeNum) {
		return this.sensorDao.getBasicSensorInfoByDeviceIdAndSensorTypeNum(new SensorValue(new DeviceValue(deviceId), new SensorTypeValue(sensorTypeNum)));
	}

	@Override
	public List<SensorValue> getBasicSensorInfoListByDeviceId(String deviceId) {
		// TODO Auto-generated method stub
		return this.sensorDao.getBasicSensorInfoListByDeviceId(deviceId);
	}

}
























