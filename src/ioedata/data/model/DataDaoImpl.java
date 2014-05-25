package ioedata.data.model;

import ioedata.sensor.model.SensorValue;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

/**
 * This class helps access to sensor data database to manipulate data storage.
 * It implements DataDao interface.
 * @author ajou
 *
 */
@Repository
public class DataDaoImpl implements DataDao {
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate template;
	
	@Override
	public DataValue getLastDataByDeviceIdSortedByTimestamp(String deviceId) {
		return this.template.selectOne("data.getLastDataByDeviceIdSortedByTimestamp", deviceId);
	}

	@Override
	public DataValue getLastDataByDeviceIdAndSensorTypeSortedByTimestamp(
			SensorValue sensorVal) {
		return this.template.selectOne("data.getLastDataByDeviceIdAndSensorTypeSortedByTimestamp", sensorVal);
	}

	@Override
	public int insertSensorData(DataValue dataVal) {
		return this.template.insert("data.insertSensorData", dataVal);
	}

}

























