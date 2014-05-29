package ioedata.service.sensor.factory;

public abstract class AccelerometerSensor implements Sensor {

	@Override
	public int getSensorType() {
		// TODO Auto-generated method stub
		return Sensor.TYPE_ACCELEROMETER;
	}

}
