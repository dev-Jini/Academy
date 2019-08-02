/* Extra Porcess */

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


update student set academy_no = ?;

update student set academy_id = 85 where st_name = '±èµ¿¼º';

select * from academy a, student s where a.academy_id = s.academy_id;

