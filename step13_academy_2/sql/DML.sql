insert into subject values('1', '����ȸȭ', '����');
insert into subject values('2', '����', '����');
insert into subject values('3', '�߱���', '����');
insert into subject values('4', '�Ϻ���', '����');
insert into subject values('5', '�䰡', '������');
insert into subject values('6', '�ʶ��׽�', '������');
insert into subject values('7', 'ũ�ν���', '������');
insert into subject values('8', '�ｺ', '������');
insert into subject values('9', '����', '������');
insert into subject values('10', '����', '������');
insert into subject values('11', '����', '������');
insert into subject values('12', '������', '������');
insert into subject values('13', '�״Ͻ�', '������');
insert into subject values('14', 'Ź��', '������');
insert into subject values('15', 'ǲ��', '������');
insert into subject values('16', '�߷�', '������');
insert into subject values('17', '�ǾƳ�', '����');
insert into subject values('18', '���̿ø�', '����');
insert into subject values('19', '�ǿ�����', '����');
insert into subject values('20', '�÷�', '����');
insert into subject values('21', '��Ÿ', '����');



insert all 
into subcademy (sb_no, academy_id) values(sb_no, academy_id) 
select sb_no, academy_id
from subject, academy
where subject.sb_name = academy.sb_name and ;