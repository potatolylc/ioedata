package ioedata.data.model;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DataDaoImpl implements DataDao {
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate template;
	
	@Override
	public DataValue getLastDataByDeviceIdSortedByTimestamp(String deviceId) {
		// TODO Auto-generated method stub
		return this.template.selectOne("data.getLastDataByDeviceIdSortedByTimestamp", deviceId);
	}

}
