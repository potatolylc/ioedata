package ioedata.device.service;

import ioedata.device.model.DeviceValue;

public interface DeviceService {
	public DeviceValue getBasicDeviceInfoByDeviceId(String deviceId);
}
