-- INSERT 문
insert into IOESENSOR values(1, 'TYPE_ANALOG_SOUND', null);
insert into IOESENSOR values(2, 'TYPE_DUST', 'mg/m³');
insert into IOESENSOR values(3, 'TYPE_FLAME', null);
insert into IOESENSOR values(4, 'TYPE_HUMIDITY', '%');
insert into IOESENSOR values(5, 'TYPE_LIGHT_BRIGHTNESS', null);
insert into IOESENSOR values(6, 'TYPE_RAINDROP', null);
insert into IOESENSOR values(7, 'TYPE_TEMPERATURE_CELSIUS', '℃');
insert into IOESENSOR values(8, 'TYPE_TEMPERATURE_FAHRENHEIT', '℉');
insert into IOESENSOR values(9, 'TYPE_ACCELEROMETER', null);
insert into IOESENSOR values(10, 'TYPE_DIGITAL_TILT', null);
insert into IOESENSOR values(11, 'TYPE_DIGITAL_VIBRATION', null);
insert into IOESENSOR values(12, 'TYPE_INFRARED_MOTION', null);
insert into IOESENSOR values(13, 'TYPE_TOUCH', null);

-- SELECT 문
select * from IOESENSOR 
where sensor_type_num > 0 and sensor_type_num < 14;
