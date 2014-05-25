-- TABLE sensor types
create table IOESENSORTYPE(
	sensor_type_num number primary key,
	sensor_type varchar2(100) not null,
	unit varchar2(100)
);
drop table IOESENSORTYPE;

-- TABLE devices
create table IOEENDDEVICE(
	device_serial_num number primary key,
	device_ip varchar2(100) unique not null,
	device_ip_port number not null,
	device_id varchar2(100) unique not null,
	device_password varchar2(100) not null,
	device_timestamp date not null
);
drop table IOEENDDEVICE;
delete from IOEENDDEVICE;
create sequence seq_ioeenddevice 
start with 1
increment by 1
minvalue 1
nocache;
drop sequence seq_ioeenddevice;

-- TABLE sensors
create table IOESENSOR(
	sensor_serial_num number unique not null,
	device_id varchar2(100) not null,
	sensor_type_num number not null,
	sensor_timestamp date not null,
	constraints ioesensor_fk_device_id foreign key(device_id) references IOEENDDEVICE(device_id) on delete cascade,
	constraints ioesensor_fk_sensor_type_num foreign key(sensor_type_num) references IOESENSORTYPE(sensor_type_num),
	constraints ioesensor_fk_combined primary key(device_id, sensor_type_num)
);
drop table IOESENSOR;
delete from IOESENSOR;
create sequence seq_ioesensor
start with 1
increment by 1
minvalue 1
nocache;
drop sequence seq_ioesensor;

-- TABLE sensor data
create table IOESENSORDATA(
	sensor_data_serial_num number primary key,
	sensor_data_value number not null,
	sensor_data_timestamp date not null,
	sensor_serial_num number not null,
	constraints ioesensordata_fk_serial_num foreign key(sensor_serial_num) references IOESENSOR(sensor_serial_num) on delete cascade
);
drop table IOESENSORDATA;
delete from IOESENSORDATA;
create sequence seq_ioesensordata
start with 1
increment by 1
minvalue 1
nocache;
drop sequence seq_ioesensordata;





















