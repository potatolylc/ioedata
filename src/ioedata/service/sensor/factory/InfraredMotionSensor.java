package ioedata.service.sensor.factory;

public abstract class InfraredMotionSensor implements Sensor {

	@Override
	public int getSensorType() {
		// TODO Auto-generated method stub
		return Sensor.TYPE_INFRARED_MOTION;
	}

}
