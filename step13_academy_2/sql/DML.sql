insert into subject values('1', '영어회화', '어학');
insert into subject values('2', '토익', '어학');
insert into subject values('3', '중국어', '어학');
insert into subject values('4', '일본어', '어학');
insert into subject values('5', '요가', '스포츠');
insert into subject values('6', '필라테스', '스포츠');
insert into subject values('7', '크로스핏', '스포츠');
insert into subject values('8', '헬스', '스포츠');
insert into subject values('9', '복싱', '스포츠');
insert into subject values('10', '수영', '스포츠');
insert into subject values('11', '유도', '스포츠');
insert into subject values('12', '주짓수', '스포츠');
insert into subject values('13', '테니스', '스포츠');
insert into subject values('14', '탁구', '스포츠');
insert into subject values('15', '풋살', '스포츠');
insert into subject values('16', '발레', '스포츠');
insert into subject values('17', '피아노', '음악');
insert into subject values('18', '바이올린', '음악');
insert into subject values('19', '실용음악', '음악');
insert into subject values('20', '플룻', '음악');
insert into subject values('21', '기타', '음악');



insert all 
into subcademy (sb_no, academy_id) values(sb_no, academy_id) 
select sb_no, academy_id
from subject, academy
where subject.sb_name = academy.sb_name and ;