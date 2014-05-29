insert into IOESENSORDATA(sensor_data_serial_num, sensor_data_value, sensor_data_timestamp, sensor_serial_num)
values(seq_ioesensordata.nextVal, 26.7, sysdate, 1);
insert into IOESENSORDATA(sensor_data_serial_num, sensor_data_value, sensor_data_timestamp, sensor_serial_num)
values(seq_ioesensordata.nextVal, 24.5, sysdate, 1);
insert into IOESENSORDATA(sensor_data_serial_num, sensor_data_value, sensor_data_timestamp, sensor_serial_num)
values(seq_ioesensordata.nextVal, 25.3, sysdate, 1);
insert into IOESENSORDATA(sensor_data_serial_num, sensor_data_value, sensor_data_timestamp, sensor_serial_num)
values(seq_ioesensordata.nextVal, 22.2, sysdate, 1);
insert into IOESENSORDATA(sensor_data_serial_num, sensor_data_value, sensor_data_timestamp, sensor_serial_num)
values(seq_ioesensordata.nextVal, 20.2, sysdate, 1);
insert into IOESENSORDATA(sensor_data_serial_num, sensor_data_value, sensor_data_timestamp, sensor_serial_num)
values(seq_ioesensordata.nextVal, 587, sysdate, 2);
insert into IOESENSORDATA(sensor_data_serial_num, sensor_data_value, sensor_data_timestamp, sensor_serial_num)
values(seq_ioesensordata.nextVal, 642, sysdate, 2);
insert into IOESENSORDATA(sensor_data_serial_num, sensor_data_value, sensor_data_timestamp, sensor_serial_num)
values(seq_ioesensordata.nextVal, 757, sysdate, 2);
insert into IOESENSORDATA(sensor_data_serial_num, sensor_data_value, sensor_data_timestamp, sensor_serial_num)
values(seq_ioesensordata.nextVal, 456, sysdate, 2);
insert into IOESENSORDATA(sensor_data_serial_num, sensor_data_value, sensor_data_timestamp, sensor_serial_num)
values(seq_ioesensordata.nextVal, 257, sysdate, 2);

-- getLastDataByDeviceIdSortedByTimestamp
select sensor_data_serial_num, sensor_data_value, 
		sensor_data_timestamp, sensorDataTimestampStr, 
		sensor_serial_num, sensor_type_num, sensor_type, unit, device_id
from(
		select data.sensor_data_serial_num, data.sensor_data_value, data.sensor_data_timestamp, 
				to_char(data.sensor_data_timestamp, 'YYYY/MM/DD HH24:MI:SS') as sensorDataTimestampStr, 
				data.sensor_serial_num, sensor.device_id, sensor.sensor_type_num, sensortype.sensor_type, sensortype.unit
		from IOESENSORDATA data, IOESENSOR sensor, IOESENSORTYPE sensortype
		where data.sensor_serial_num=sensor.sensor_serial_num and sensor.sensor_type_num=sensortype.sensor_type_num
		order by data.sensor_data_timestamp desc
)
where device_id='insideHome' and ROWNUM=1;

-- getLastDataByDeviceIdAndSensorTypeSortedByTimestamp
select sensor_data_serial_num, sensor_data_value, 
		sensor_data_timestamp, sensorDataTimestampStr, 
		sensor_serial_num, sensor_type_num, sensor_type, unit, device_id
from(
		select data.sensor_data_serial_num, data.sensor_data_value, data.sensor_data_timestamp, 
				to_char(data.sensor_data_timestamp, 'YYYY/MM/DD HH24:MI:SS') as sensorDataTimestampStr, 
				data.sensor_serial_num, sensor.device_id, sensor.sensor_type_num, sensortype.sensor_type, sensortype.unit
		from IOESENSORDATA data, IOESENSOR sensor, IOESENSORTYPE sensortype
		where data.sensor_serial_num=sensor.sensor_serial_num and sensor.sensor_type_num=sensortype.sensor_type_num
					and sensor.sensor_type_num=7
		order by data.sensor_data_timestamp desc
)
where device_id='insideHome' and ROWNUM=1;

-- test: get date in char type
select to_char(sensor_data_timestamp, 'YYYY/MM/DD HH24:MI:SS')from IOESENSORDATA;

-- test: get data value between date and time
select sensor_data_value, to_char(sensor_data_timestamp, 'YYYY/MM/DD HH24:MI:SS') 
from IOESENSORDATA
where sensor_data_timestamp between to_date('2014-05-25 09:00:23', 'YYYY-MM-DD HH24:MI:SS') 
and to_date('2014-05-27 19:09:45', 'YYYY-MM-DD HH24:MI:SS');

-- test: get data value between date
select sensor_data_value, to_char(sensor_data_timestamp, 'YYYY/MM/DD HH24:MI:SS') 
from IOESENSORDATA
where sensor_data_timestamp between to_date('2014-05-26') and to_date('2014-05-29')+1;

-- getDataListByDeviceIdAndSensorTypeAndDateSortedByTimestamp
-- getDataListByDeviceIdAndSensorTypeAndTimeSortedByTimestamp
select sensor_data_serial_num, sensor_data_value, 
				sensor_data_timestamp, sensorDataTimestampStr, 
				sensor_serial_num, sensor_type_num, sensor_type, unit, device_id
from(
			select data.sensor_data_serial_num, data.sensor_data_value, data.sensor_data_timestamp, 
							to_char(data.sensor_data_timestamp, 'YYYY/MM/DD HH24:MI:SS') as sensorDataTimestampStr, 
							data.sensor_serial_num, sensor.device_id, sensor.sensor_type_num, sensortype.sensor_type, sensortype.unit
			from IOESENSORDATA data, IOESENSOR sensor, IOESENSORTYPE sensortype
			where sensor.device_id = 'outsideHome'
					and data.sensor_serial_num=sensor.sensor_serial_num 
					and sensor.sensor_type_num=sensortype.sensor_type_num
			order by data.sensor_data_timestamp asc
) where sensor_data_timestamp between to_date('2014-05-26') and to_date('2014-05-28')+1 ;

  where sensor_data_timestamp between to_date('2014-05-25 14:15:48', 'YYYY-MM-DD HH24:MI:SS') 
and to_date('2014-05-29 19:32:29', 'YYYY-MM-DD HH24:MI:SS');

-- getGreatestDataByDeviceIdAndSensorType
select sensor_data_value, sensor_serial_num, sensor_type_num, sensor_type, unit, device_id
from(
		select data.sensor_data_value, data.sensor_serial_num, sensor.device_id, 
					sensor.sensor_type_num, sensortype.sensor_type, sensortype.unit
		from IOESENSORDATA data, IOESENSOR sensor, IOESENSORTYPE sensortype
		where data.sensor_serial_num=sensor.sensor_serial_num and sensor.sensor_type_num=sensortype.sensor_type_num
					and sensor.sensor_type_num=5
		order by data.sensor_data_value desc
)
where device_id='outsideHome' and ROWNUM=1;

-- getLeastDataByDeviceIdAndSensorType
select sensor_data_value, sensor_serial_num, sensor_type_num, sensor_type, unit, device_id
from(
		select data.sensor_data_value, data.sensor_serial_num, sensor.device_id, 
					sensor.sensor_type_num, sensortype.sensor_type, sensortype.unit
		from IOESENSORDATA data, IOESENSOR sensor, IOESENSORTYPE sensortype
		where data.sensor_serial_num=sensor.sensor_serial_num and sensor.sensor_type_num=sensortype.sensor_type_num
					and sensor.sensor_type_num=5
		order by data.sensor_data_value asc
)
where device_id='outsideHome' and ROWNUM=1;