create table IOESENSOR(
	sensor_type_num number primary key,
	sensor_type varchar2(100) not null,
	unit varchar2(100)
);
drop table IOESENSOR;

create table IOEENDDEVICE(
	device_serial_num number primary key,
	device_ip varchar2(100) unique not null,
	device_ip_port number not null,
	device_id varchar2(100) unique not null,
	device_password varchar2(100) not null
);
drop table IOEENDDEVICE;
delete from IOEENDDEVICE;
create sequence seq_ioeenddevice 
start with 1
increment by 1
minvalue 1
nocache;
drop sequence seq_ioeenddevice;

create table IOESENSORDATA(
	sensor_data_serial_num number primary key,
	sensor_data_timestamp date not null,
	sensor_data_value number not null,
	sensor_type_num number not null,
	device_id varchar2(100) not null,
	constraints fk_sensor_type_num foreign key(sensor_type_num) references IOESENSOR(sensor_type_num),
	constraints fk_device_id foreign key(device_id) references IOEENDDEVICE(device_id)
);
drop table IOESENSORDATA;
delete from IOESENSORDATA;
create sequence seq_ioesensordata
start with 1
increment by 1
minvalue 1
nocache;
drop sequence seq_ioesensordata;





















