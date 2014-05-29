insert into IOEENDDEVICE(device_serial_num, device_ip, device_ip_port, device_id, device_password, device_timestamp) 
values(seq_ioeenddevice.nextVal, '192.168.1.1', 80, 'potato', 'potato', sysdate);
insert into IOEENDDEVICE(device_serial_num, device_ip, device_ip_port, device_id, device_password, device_timestamp) 
values(seq_ioeenddevice.nextVal, '192.168.1.0', 80, 'rachel', 'rachel', sysdate);
insert into IOEENDDEVICE(device_serial_num, device_ip, device_ip_port, device_id, device_password, device_timestamp) 
values(seq_ioeenddevice.nextVal, '192.168.1.3', 80, 'skyler', 'skyler', sysdate);
insert into IOEENDDEVICE(device_serial_num, device_ip, device_ip_port, device_id, device_password, device_timestamp) 
values(seq_ioeenddevice.nextVal, '192.168.1.7', 80, 'liao', 'liao', sysdate);
insert into IOEENDDEVICE(device_serial_num, device_ip, device_ip_port, device_id, device_password, device_timestamp) 
values(seq_ioeenddevice.nextVal, '192.168.1.8', 80, 'shin', 'shin', sysdate);
insert into IOEENDDEVICE(device_serial_num, device_ip, device_ip_port, device_id, device_password, device_timestamp) 
values(seq_ioeenddevice.nextVal, '192.168.0.9', 80, 'outsideHome', 'outsideHome', sysdate);
insert into IOEENDDEVICE(device_serial_num, device_ip, device_ip_port, device_id, device_password, device_timestamp) 
values(seq_ioeenddevice.nextVal, '192.168.1.10', 80, 'lylc', 'lylc', sysdate);

select device_serial_num, device_ip, device_ip_port, device_id, device_timestamp
from IOEENDDEVICE
where device_id = 'insideHome';

select count(*) from IOEENDDEVICE
where device_ip = '192.168.0.6' and device_ip_port = 80 and device_id = 'insideHome' and device_password = '123';