package ioedata.device.model;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DeviceDaoImpl implements DeviceDao {
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate template;
	
	@Override
	public DeviceValue getBasicDeviceInfoByDeviceId(String deviceId) {
		return this.template.selectOne("device.getBasicDeviceInfoByDeviceId", deviceId);
	}

}
