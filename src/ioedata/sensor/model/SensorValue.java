package ioedata.sensor.model;
/**
 * This class create data transport object that contain the sensor type number, 
 * sensor type and the unit of the data created from the respective sensor. 
 * @author ajou
 *
 */
public class SensorValue {
	private int sensorTypeNum;
	private String sensorType;
	private String unit;
	public SensorValue() {
		super();
	}
	public SensorValue(int sensorTypeNum, String sensorType, String unit) {
		super();
		this.sensorTypeNum = sensorTypeNum;
		this.sensorType = sensorType;
		this.unit = unit;
	}
	public int getSensorTypeNum() {
		return sensorTypeNum;
	}
	public void setSensorTypeNum(int sensorTypeNum) {
		this.sensorTypeNum = sensorTypeNum;
	}
	public String getSensorType() {
		return sensorType;
	}
	public void setSensorType(String sensorType) {
		this.sensorType = sensorType;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	@Override
	public String toString() {
		return "SensorValue [sensorTypeNum=" + sensorTypeNum + ", sensorType="
				+ sensorType + ", unit=" + unit + "]";
	}
	
}
