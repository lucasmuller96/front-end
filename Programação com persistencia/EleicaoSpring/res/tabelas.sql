create sequence partido_sq;
create sequence candidato_sq;
create sequence eleitor_sq;
create sequence voto_sq;

create table partido (
	codpar integer constraint partido_pk primary key,
	nompar varchar(40),
	sigpar varchar(10)
);

create table candidato (
	codregcan integer constraint candidato_pk primary key,
	nomcan varchar(40),
	cpfcan varchar(11),
	codpar integer constraint can_codpar_fk references partido(codpar)
);

create table eleitor (
	numtitele integer constraint eleitor_pk primary key,
	nomele varchar(40),
	nommaeele varchar(40),
	zonele integer,
	secele integer
);

create table voto (
	codregcan integer,
	numtitele integer,
	datvot timestamp default current_timestamp,
	urnvot integer,
	constraint voto_pk primary key(codregcan, numtitele, datvot)
);