package ioedata.device.model;
/**
 * This class creates data transport objects that contain the devices' information,
 * such as the IP address, device ID and password of various devices. 
 * @author ajou
 *
 */
public class DeviceValue {
	private int deviceSerialNum;
	private String deviceIp;
	private int deviceIpPort;
	private String deviceId;
	private String devicePassword;
	public DeviceValue() {
		super();
	}
	public DeviceValue(String deviceIp, int deviceIpPort, String deviceId,
			String devicePassword) {
		super();
		this.deviceIp = deviceIp;
		this.deviceIpPort = deviceIpPort;
		this.deviceId = deviceId;
		this.devicePassword = devicePassword;
	}
	public DeviceValue(int deviceSerialNum, String deviceIp, int deviceIpPort,
			String deviceId, String devicePassword) {
		super();
		this.deviceSerialNum = deviceSerialNum;
		this.deviceIp = deviceIp;
		this.deviceIpPort = deviceIpPort;
		this.deviceId = deviceId;
		this.devicePassword = devicePassword;
	}
	@Override
	public String toString() {
		return "DeviceValue [deviceSerialNum=" + deviceSerialNum
				+ ", deviceIp=" + deviceIp + ", deviceIpPort=" + deviceIpPort
				+ ", deviceId=" + deviceId + ", devicePassword="
				+ devicePassword + "]";
	}
	
}
