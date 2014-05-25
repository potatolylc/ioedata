package ioedata.device.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ioedata.device.model.DeviceDao;
import ioedata.device.model.DeviceValue;

@Service
public class DeviceServiceImpl implements DeviceService {
	@Resource(name = "deviceDaoImpl")
	DeviceDao deviceDao;

	@Override
	public DeviceValue getBasicDeviceInfoByDeviceId(String deviceId) {
		// TODO Auto-generated method stub
		return this.deviceDao.getBasicDeviceInfoByDeviceId(deviceId);
	}

}
