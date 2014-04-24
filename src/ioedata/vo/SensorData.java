package ioedata.vo;

import java.util.Arrays;

public final class SensorData {
	private int sensorType;
	private Object value;
	private Object[] values;
	private String unit;
	
	public SensorData() {
		super();
	}
	public SensorData(int sensorType, Object value) {
		super();
		this.sensorType = sensorType;
		this.value = value;
	}
	public SensorData(int sensorType, Object[] values) {
		super();
		this.sensorType = sensorType;
		this.values = values;
	}
	public SensorData(int sensorType, Object value, String unit) {
		super();
		this.sensorType = sensorType;
		this.value = value;
		this.unit = unit;
	}
	public SensorData(int sensorType, Object[] values, String unit) {
		super();
		this.sensorType = sensorType;
		this.values = values;
		this.unit = unit;
	}
	
	public int getSensorType() {
		return sensorType;
	}
	public void setSensorType(int sensorType) {
		this.sensorType = sensorType;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public Object[] getValues() {
		return values;
	}
	public void setValues(Object[] values) {
		this.values = values;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	@Override
	public String toString() {
		return "SensorData [sensorType=" + sensorType + ", value=" + value
				+ ", values=" + Arrays.toString(values) + ", unit=" + unit
				+ "]";
	}
	
	
}
