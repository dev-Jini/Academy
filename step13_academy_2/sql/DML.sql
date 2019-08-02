/*subject 정보 */

insert into subject values(sb_no.nextval, '영어회화', '어학');
insert into subject values(sb_no.nextval, '토익', '어학');
insert into subject values(sb_no.nextval, '중국어', '어학');
insert into subject values(sb_no.nextval, '일본어', '어학');
insert into subject values(sb_no.nextval, '요가', '스포츠');
insert into subject values(sb_no.nextval, '필라테스', '스포츠');
insert into subject values(sb_no.nextval, '크로스핏', '스포츠');
insert into subject values(sb_no.nextval, '헬스', '스포츠');
insert into subject values(sb_no.nextval, '복싱', '스포츠');
insert into subject values(sb_no.nextval, '수영', '스포츠');
insert into subject values(sb_no.nextval, '유도', '스포츠');
insert into subject values(sb_no.nextval, '주짓수', '스포츠');
insert into subject values(sb_no.nextval, '테니스', '스포츠');
insert into subject values(sb_no.nextval, '탁구', '스포츠');
insert into subject values(sb_no.nextval, '풋살', '스포츠');
insert into subject values(sb_no.nextval, '발레', '스포츠');
insert into subject values(sb_no.nextval, '피아노', '음악');
insert into subject values(sb_no.nextval, '바이올린', '음악');
insert into subject values(sb_no.nextval, '실용음악', '음악');
insert into subject values(sb_no.nextval, '플룻', '음악');
insert into subject values(sb_no.nextval, '기타', '음악');

/*student 정보 */

insert into student (st_id , st_name, gender) values(st_id.nextval, '최성국', 'M');
insert into student (st_id , st_name, gender) values(st_id.nextval, '유은나', 'F');
insert into student (st_id , st_name, gender) values(st_id.nextval, '송평현', 'M');
insert into student (st_id , st_name, gender) values(st_id.nextval, '김종성', 'M');
insert into student (st_id , st_name, gender) values(st_id.nextval, '강민웅', 'M');
insert into student (st_id , st_name, gender) values(st_id.nextval, '송시찬', 'M');
insert into student (st_id , st_name, gender) values(st_id.nextval, '변영인', 'M');
insert into student (st_id , st_name, gender) values(st_id.nextval, '서해상', 'M');
insert into student (st_id , st_name, gender) values(st_id.nextval, '조현희', 'F');
insert into student (st_id , st_name, gender) values(st_id.nextval, '김동범', 'M');
insert into student (st_id , st_name, gender) values(st_id.nextval, '김경원', 'M');
insert into student (st_id , st_name, gender) values(st_id.nextval, '지인철', 'M');
insert into student (st_id , st_name, gender) values(st_id.nextval, '김동성', 'M');
insert into student (st_id , st_name, gender) values(st_id.nextval, '김진휘', 'M');
insert into student (st_id , st_name, gender) values(st_id.nextval, '이정원', 'F');
insert into student (st_id , st_name, gender) values(st_id.nextval, '박현민', 'M');
insert into student (st_id , st_name, gender) values(st_id.nextval, '김웅태', 'M');
insert into student (st_id , st_name, gender) values(st_id.nextval, '이현준', 'M');
insert into student (st_id , st_name, gender) values(st_id.nextval, '신용기', 'M');
insert into student (st_id , st_name, gender) values(st_id.nextval, '한우석', 'M');
insert into student (st_id , st_name, gender) values(st_id.nextval, '조영욱', 'M');
insert into student (st_id , st_name, gender) values(st_id.nextval, '석유진', 'F');
insert into student (st_id , st_name, gender) values(st_id.nextval, '남세영', 'M');
insert into student (st_id , st_name, gender) values(st_id.nextval, '김수경', 'F');
insert into student (st_id , st_name, gender) values(st_id.nextval, '김혜경', 'F');
insert into student (st_id , st_name, gender) values(st_id.nextval, '동빈나', 'M');
insert into student (st_id , st_name, gender) values(st_id.nextval, '이고잉', 'M');
insert into academy values(3179, 'Encore', 'http://www.en-core.com/', '02-754-7301', '서울시 서초구 서초대로 46길 42 엔코아타워', '7');

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

update student set academy_id = 85 where st_name = '김동성';