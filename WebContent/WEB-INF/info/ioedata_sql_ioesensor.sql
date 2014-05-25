insert into IOESENSOR(sensor_serial_num number, device_id, sensor_type_num, sensor_timestamp) 
values(seq_ioesensor.nextVal, 'insideHome', 7, sysdate);
insert into IOESENSOR(sensor_serial_num number, device_id, sensor_type_num, sensor_timestamp) 
values(seq_ioesensor.nextVal, 'insideHome', 5, sysdate);
insert into IOESENSOR(sensor_serial_num number, device_id, sensor_type_num, sensor_timestamp) 
values(seq_ioesensor.nextVal, 'outsideHome', 7, sysdate);
insert into IOESENSOR(sensor_serial_num number, device_id, sensor_type_num, sensor_timestamp) 
values(seq_ioesensor.nextVal, 'outsideHome', 8, sysdate);
insert into IOESENSOR(sensor_serial_num number, device_id, sensor_type_num, sensor_timestamp) 
values(seq_ioesensor.nextVal, 'outsideHome', 5, sysdate);
insert into IOESENSOR(sensor_serial_num number, device_id, sensor_type_num, sensor_timestamp) 
values(seq_ioesensor.nextVal, 'outsideHome', 2, sysdate);
insert into IOESENSOR(sensor_serial_num number, device_id, sensor_type_num, sensor_timestamp) 
values(seq_ioesensor.nextVal, 'outsideHome', 4, sysdate);


select sensor_serial_num, device_id, sensor_type_num, sensor_type
from(
	select sensor.sensor_serial_num, sensor.device_id, sensor.sensor_type_num, sensortype.sensor_type
	from IOESENSOR sensor, IOESENSORTYPE sensortype
	where sensor.sensor_type_num=sensortype.sensor_type_num
	order by sensor.sensor_serial_num asc
)
where device_id='outsideHome' and sensor.sensor_type_num=7;

