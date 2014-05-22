package ioedata.data.model;

import ioedata.sensor.model.SensorValue;

import java.util.ArrayList;
import java.util.Date;
/**
 * This class creates data transport objects that contain the sensor data timestamp,
 * the raw data from sensors and the respective sensor information.
 * Also, it can contain an array data information to represent a list of the past raw sensor data.
 * @author ajou
 *
 */
public final class DataValue {
	private int sensorDataSerialNum;
	private Date sensorDataTimestamp;
	private String sensorDataTimestampStr;
	private Object sensorDataValue;
	private SensorValue sensorValue;
	private String deviceId;
	private ArrayList<DataValue> sensorDataArr;
	public DataValue() {
		super();
	}
	public DataValue(int sensorDataSerialNum, Date sensorDataTimestamp,
			String sensorDataTimestampStr, Object sensorDataValue,
			SensorValue sensorValue, String deviceId) {
		super();
		this.sensorDataSerialNum = sensorDataSerialNum;
		this.sensorDataTimestamp = sensorDataTimestamp;
		this.sensorDataTimestampStr = sensorDataTimestampStr;
		this.sensorDataValue = sensorDataValue;
		this.sensorValue = sensorValue;
		this.deviceId = deviceId;
	}
	public int getSensorDataSerialNum() {
		return sensorDataSerialNum;
	}
	public void setSensorDataSerialNum(int sensorDataSerialNum) {
		this.sensorDataSerialNum = sensorDataSerialNum;
	}
	public Date getSensorDataTimestamp() {
		return sensorDataTimestamp;
	}
	public void setSensorDataTimestamp(Date sensorDataTimestamp) {
		this.sensorDataTimestamp = sensorDataTimestamp;
	}
	public String getSensorDataTimestampStr() {
		return sensorDataTimestampStr;
	}
	public void setSensorDataTimestampStr(String sensorDataTimestampStr) {
		this.sensorDataTimestampStr = sensorDataTimestampStr;
	}
	public Object getSensorDataValue() {
		return sensorDataValue;
	}
	public void setSensorDataValue(Object sensorDataValue) {
		this.sensorDataValue = sensorDataValue;
	}
	public SensorValue getSensorValue() {
		return sensorValue;
	}
	public void setSensorValue(SensorValue sensorValue) {
		this.sensorValue = sensorValue;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public ArrayList<DataValue> getSensorDataArr() {
		return sensorDataArr;
	}
	public void setSensorDataArr(ArrayList<DataValue> sensorDataArr) {
		this.sensorDataArr = sensorDataArr;
	}
	@Override
	public String toString() {
		return "DataValue [sensorDataSerialNum=" + sensorDataSerialNum
				+ ", sensorDataTimestamp=" + sensorDataTimestamp
				+ ", sensorDataTimestampStr=" + sensorDataTimestampStr
				+ ", sensorDataValue=" + sensorDataValue + ", sensorValue="
				+ sensorValue + ", deviceId=" + deviceId + ", sensorDataArr="
				+ sensorDataArr + "]";
	}

	
	
}




































