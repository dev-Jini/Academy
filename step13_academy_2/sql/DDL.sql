
/* Drop Tables */

DROP TABLE student CASCADE CONSTRAINTS;
DROP TABLE academy CASCADE CONSTRAINTS;
DROP TABLE subject CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE academy_id;
DROP SEQUENCE st_id;
DROP SEQUENCE sb_no;


/* Create Sequences */

CREATE SEQUENCE academy_id INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE st_id INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE sb_no INCREMENT BY 1 START WITH 1;


/* Create Tables */

CREATE TABLE academy
(
	academy_id number PRIMARY KEY,
	title varchar2(150 char) NOT NULL,
	sitelink varchar2(200 char),
	contact varchar2(15 char),
	address varchar2(150),
	sb_name varchar2(30) NOT NULL,
	sb_no number
);


CREATE TABLE student
(
	st_id number PRIMARY KEY,
	st_name varchar2(20 char) NOT NULL,
	gender varchar2(2 char) NOT NULL,
	academy_id number
);


CREATE TABLE subject
(
	sb_no number PRIMARY KEY,
	sb_name varchar2(30 char) NOT NULL UNIQUE
);



/* Create Foreign Keys */

ALTER TABLE student
	ADD FOREIGN KEY (academy_id)
	REFERENCES academy (academy_id)
;


ALTER TABLE academy
	ADD FOREIGN KEY (sb_no)
	REFERENCES subject (sb_no)
;













