insert into IOESENSORDATA(sensor_data_serial_num, sensor_data_timestamp, sensor_data_value, sensor_type_num, device_id)
values(seq_ioesensordata.nextVal, sysdate, 89.9, 8, 'lylc');

-- getLastDataByDeviceIdSortedByTimestamp
select sensor_data_serial_num, sensor_data_timestamp, sensorDataTimestampStr, 
		sensor_data_value, sensor_type_num, device_id, sensor_type, unit
from(
		select data.sensor_data_serial_num, data.sensor_data_timestamp, 
				to_char(data.sensor_data_timestamp, 'YYYY/MM/DD HH24:MI:SS') as sensorDataTimestampStr, 
				data.sensor_data_value, data.sensor_type_num, data.device_id, 
				sensor.sensor_type, sensor.unit
		from IOESENSORDATA data, IOESENSOR sensor
		where data.sensor_type_num=sensor.sensor_type_num
		order by data.sensor_data_timestamp desc
)
where device_id='potato' and ROWNUM=1;

select to_char(sensor_data_timestamp, 'YYYY/MM/DD HH24:MI:SS')from IOESENSORDATA;
