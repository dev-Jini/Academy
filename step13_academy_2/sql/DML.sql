/*subject ���� */

insert into subject values(sb_no.nextval, '����ȸȭ', '����');
insert into subject values(sb_no.nextval, '����', '����');
insert into subject values(sb_no.nextval, '�߱���', '����');
insert into subject values(sb_no.nextval, '�Ϻ���', '����');
insert into subject values(sb_no.nextval, '�䰡', '������');
insert into subject values(sb_no.nextval, '�ʶ��׽�', '������');
insert into subject values(sb_no.nextval, 'ũ�ν���', '������');
insert into subject values(sb_no.nextval, '�ｺ', '������');
insert into subject values(sb_no.nextval, '����', '������');
insert into subject values(sb_no.nextval, '����', '������');
insert into subject values(sb_no.nextval, '����', '������');
insert into subject values(sb_no.nextval, '������', '������');
insert into subject values(sb_no.nextval, '�״Ͻ�', '������');
insert into subject values(sb_no.nextval, 'Ź��', '������');
insert into subject values(sb_no.nextval, 'ǲ��', '������');
insert into subject values(sb_no.nextval, '�߷�', '������');
insert into subject values(sb_no.nextval, '�ǾƳ�', '����');
insert into subject values(sb_no.nextval, '���̿ø�', '����');
insert into subject values(sb_no.nextval, '�ǿ�����', '����');
insert into subject values(sb_no.nextval, '�÷�', '����');
insert into subject values(sb_no.nextval, '��Ÿ', '����');

/*student ���� */

insert into student (st_id , st_name, gender, phoneNo) values(st_id.nextval, '�ּ���', 'M', '01000000000');
insert into student (st_id , st_name, gender, phoneNo) values(st_id.nextval, '������', 'F', '01000000000');
insert into student (st_id , st_name, gender, phoneNo) values(st_id.nextval, '������', 'M', '01000000000');
insert into student (st_id , st_name, gender, phoneNo) values(st_id.nextval, '������', 'M', '01000000000');
insert into student (st_id , st_name, gender, phoneNo) values(st_id.nextval, '���ο�', 'M', '01000000000');
insert into student (st_id , st_name, gender, phoneNo) values(st_id.nextval, '�۽���', 'M', '01000000000');
insert into student (st_id , st_name, gender, phoneNo) values(st_id.nextval, '������', 'M', '01000000000');
insert into student (st_id , st_name, gender, phoneNo) values(st_id.nextval, '���ػ�', 'M', '01000000000');
insert into student (st_id , st_name, gender, phoneNo) values(st_id.nextval, '������', 'F', '01000000000');
insert into student (st_id , st_name, gender, phoneNo) values(st_id.nextval, '�赿��', 'M', '01000000000');
insert into student (st_id , st_name, gender, phoneNo) values(st_id.nextval, '����', 'M', '01000000000');
insert into student (st_id , st_name, gender, phoneNo) values(st_id.nextval, '����ö', 'M', '01000000000');
insert into student (st_id , st_name, gender, phoneNo) values(st_id.nextval, '�赿��', 'M', '01000000000');
insert into student (st_id , st_name, gender, phoneNo) values(st_id.nextval, '������', 'M', '01000000000');
insert into student (st_id , st_name, gender, phoneNo) values(st_id.nextval, '������', 'F', '01000000000');
insert into student (st_id , st_name, gender, phoneNo) values(st_id.nextval, '������', 'M', '01000000000');
insert into student (st_id , st_name, gender, phoneNo) values(st_id.nextval, '�����', 'M', '01000000000');
insert into student (st_id , st_name, gender, phoneNo) values(st_id.nextval, '������', 'M', '01000000000');
insert into student (st_id , st_name, gender, phoneNo) values(st_id.nextval, '�ſ��', 'M', '01000000000');
insert into student (st_id , st_name, gender, phoneNo) values(st_id.nextval, '�ѿ켮', 'M', '01000000000');
insert into student (st_id , st_name, gender, phoneNo) values(st_id.nextval, '������', 'M', '01000000000');
insert into student (st_id , st_name, gender, phoneNo) values(st_id.nextval, '������', 'F', '01000000000');
insert into student (st_id , st_name, gender, phoneNo) values(st_id.nextval, '������', 'M', '01000000000');
insert into student (st_id , st_name, gender, phoneNo) values(st_id.nextval, '�����', 'F', '01000000000');
insert into student (st_id , st_name, gender, phoneNo) values(st_id.nextval, '������', 'F', '01000000000');
insert into student (st_id , st_name, gender, phoneNo) values(st_id.nextval, '����', 'M', '01000000000');
insert into student (st_id , st_name, gender, phoneNo) values(st_id.nextval, '�̰���', 'M', '01000000000');



insert all 
into subcademy (sb_no, academy_id) values(sb_no, academy_id) 
select sb_no, academy_id
from subject, academy
where subject.sb_name = academy.sb_name and ;