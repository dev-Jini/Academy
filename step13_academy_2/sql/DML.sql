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

insert into student (st_id , st_name, gender) values(st_id.nextval, '�ּ���', 'M');
insert into student (st_id , st_name, gender) values(st_id.nextval, '������', 'F');
insert into student (st_id , st_name, gender) values(st_id.nextval, '������', 'M');
insert into student (st_id , st_name, gender) values(st_id.nextval, '������', 'M');
insert into student (st_id , st_name, gender) values(st_id.nextval, '���ο�', 'M');
insert into student (st_id , st_name, gender) values(st_id.nextval, '�۽���', 'M');
insert into student (st_id , st_name, gender) values(st_id.nextval, '������', 'M');
insert into student (st_id , st_name, gender) values(st_id.nextval, '���ػ�', 'M');
insert into student (st_id , st_name, gender) values(st_id.nextval, '������', 'F');
insert into student (st_id , st_name, gender) values(st_id.nextval, '�赿��', 'M');
insert into student (st_id , st_name, gender) values(st_id.nextval, '����', 'M');
insert into student (st_id , st_name, gender) values(st_id.nextval, '����ö', 'M');
insert into student (st_id , st_name, gender) values(st_id.nextval, '�赿��', 'M');
insert into student (st_id , st_name, gender) values(st_id.nextval, '������', 'M');
insert into student (st_id , st_name, gender) values(st_id.nextval, '������', 'F');
insert into student (st_id , st_name, gender) values(st_id.nextval, '������', 'M');
insert into student (st_id , st_name, gender) values(st_id.nextval, '�����', 'M');
insert into student (st_id , st_name, gender) values(st_id.nextval, '������', 'M');
insert into student (st_id , st_name, gender) values(st_id.nextval, '�ſ��', 'M');
insert into student (st_id , st_name, gender) values(st_id.nextval, '�ѿ켮', 'M');
insert into student (st_id , st_name, gender) values(st_id.nextval, '������', 'M');
insert into student (st_id , st_name, gender) values(st_id.nextval, '������', 'F');
insert into student (st_id , st_name, gender) values(st_id.nextval, '������', 'M');
insert into student (st_id , st_name, gender) values(st_id.nextval, '�����', 'F');
insert into student (st_id , st_name, gender) values(st_id.nextval, '������', 'F');
insert into student (st_id , st_name, gender) values(st_id.nextval, '����', 'M');
insert into student (st_id , st_name, gender) values(st_id.nextval, '�̰���', 'M');
insert into academy values(3179, 'Encore', 'http://www.en-core.com/', '02-754-7301', '����� ���ʱ� ���ʴ�� 46�� 42 ���ھ�Ÿ��', '7');

/* */

insert into subject 
	select sb_no.nextval, sb_name
	from (select distinct sb_name
			from academy where sb_name is not null) 
	where sb_name is not null;


update academy a
		set sb_no = 
					(select s.sb_no 
					from subject s
					where a.sb_name = s.sb_name);
	
ALTER TABLE academy DROP COLUMN sb_name;

update student set academy_id = 85 where st_name = '�赿��';