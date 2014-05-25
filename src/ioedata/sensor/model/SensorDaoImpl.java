package ioedata.sensor.model;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SensorDaoImpl implements SensorDao {
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate template;	

	@Override
	public SensorValue getBasicSensorInfoByDeviceIdAndSensorTypeNum(
			SensorValue sensorVal) {
		// TODO Auto-generated method stub
		return this.template.selectOne("sensor.getBasicSensorInfoByDeviceIdAndSensorTypeNum", sensorVal);
	}

	@Override
	public List<SensorValue> getBasicSensorInfoListByDeviceId(String deviceId) {
		// TODO Auto-generated method stub
		return this.template.selectList("sensor.getBasicSensorInfoListByDeviceId", deviceId);
	}

}





















