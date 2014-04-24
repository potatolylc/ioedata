package ioedata.service.sensor.factory;

public abstract class AnalogSoundSensor implements Sensor {

	@Override
	public int getSensorType() {
		// TODO Auto-generated method stub
		return Sensor.TYPE_ANALOG_SOUND;
	}
}
