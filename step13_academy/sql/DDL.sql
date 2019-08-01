

/* Drop Tables */

DROP TABLE actudent CASCADE CONSTRAINTS;
DROP TABLE subcademy CASCADE CONSTRAINTS;
DROP TABLE academy CASCADE CONSTRAINTS;
DROP TABLE student CASCADE CONSTRAINTS;
DROP TABLE subject CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE academy_id;




/* Create Sequences */

CREATE SEQUENCE academy_id INCREMENT BY 1 START WITH 1;



/* Create Tables */

CREATE TABLE academy
(
	academy_id 	number PRIMARY KEY,
	title		 varchar2(50 char) NOT NULL,
	sitelink	 varchar2(200 char),
	contact		 varchar2(15 char),
	address 	varchar2(150),
	sb_name 	varchar2(30) NOT NULL
);


CREATE TABLE actudent
(
	academy_id number NOT NULL UNIQUE,
	st_id number NOT NULL UNIQUE
);


CREATE TABLE student
(
	st_id number PRIMARY KEY,
	st_name varchar2(20 char) NOT NULL,
	gender varchar2(1 char) NOT NULL,
	phoneNo number
);


CREATE TABLE subcademy
(
	sb_no number NOT NULL UNIQUE,
	academy_id number NOT NULL UNIQUE
);


CREATE TABLE subject
(
	sb_no number PRIMARY KEY,
	sb_name varchar2(30 char) NOT NULL UNIQUE,
	sb_category varchar2(10 char) NOT NULL
);



/* Create Foreign Keys */

ALTER TABLE actudent
	ADD FOREIGN KEY (academy_id)
	REFERENCES academy (academy_id)
;


ALTER TABLE subcademy
	ADD FOREIGN KEY (academy_id)
	REFERENCES academy (academy_id)
;


ALTER TABLE actudent
	ADD FOREIGN KEY (st_id)
	REFERENCES student (st_id)
;


ALTER TABLE subcademy
	ADD FOREIGN KEY (sb_no)
	REFERENCES subject (sb_no)
;



