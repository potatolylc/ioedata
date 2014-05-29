package ioedata.service.sensor.factory;

public abstract class FlameSensor implements Sensor {

	@Override
	public int getSensorType() {
		// TODO Auto-generated method stub
		return Sensor.TYPE_FLAME;
	}
}
