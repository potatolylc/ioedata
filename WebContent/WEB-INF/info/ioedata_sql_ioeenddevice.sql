insert into IOEENDDEVICE(device_serial_num, device_ip, device_ip_port, device_id, device_password, device_timestamp) 
values(seq_ioeenddevice.nextVal, '192.168.0.1', 80, 'potato', '123', sysdate);
insert into IOEENDDEVICE(device_serial_num, device_ip, device_ip_port, device_id, device_password, device_timestamp) 
values(seq_ioeenddevice.nextVal, '192.168.0.0', 80, 'rachel', '123', sysdate);
insert into IOEENDDEVICE(device_serial_num, device_ip, device_ip_port, device_id, device_password, device_timestamp) 
values(seq_ioeenddevice.nextVal, '192.168.0.3', 80, 'skyler', '123', sysdate);
insert into IOEENDDEVICE(device_serial_num, device_ip, device_ip_port, device_id, device_password, device_timestamp) 
values(seq_ioeenddevice.nextVal, '192.168.0.6', 80, 'insideHome', '123', sysdate);
insert into IOEENDDEVICE(device_serial_num, device_ip, device_ip_port, device_id, device_password, device_timestamp) 
values(seq_ioeenddevice.nextVal, '192.168.0.8', 80, 'shin', '123', sysdate);
insert into IOEENDDEVICE(device_serial_num, device_ip, device_ip_port, device_id, device_password, device_timestamp) 
values(seq_ioeenddevice.nextVal, '192.168.0.9', 80, 'outsideHome', '123', sysdate);
insert into IOEENDDEVICE(device_serial_num, device_ip, device_ip_port, device_id, device_password, device_timestamp) 
values(seq_ioeenddevice.nextVal, '192.168.0.10', 80, 'lylc', '123', sysdate);

select device_serial_num, device_ip, device_ip_port, device_id, device_timestamp
from IOEENDDEVICE
where device_id = 'insideHome';
