package ioedata.data.model;


public interface DataDao {
	public DataValue getLastDataByDeviceIdSortedByTimestamp(String deviceId);
}
