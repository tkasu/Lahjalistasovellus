CREATE TABLE Yllapitaja (
	kayttajatunnus varchar(30) primary key,
	salasana varchar(50) not null);

CREATE TABLE Lahjaehdotus ( 
	id SERIAL primary key,
	nimi varchar(60) not null unique,
	hinta float,
	ostoOsoite varchar(150),
	lisaaja varchar(30),
	maxVaraukset integer,
	FOREIGN KEY (lisaaja) REFERENCES Yllapitaja(kayttajatunnus));

CREATE TABLE Vieras (
	id SERIAL primary key,
	nimi varchar(60) not null,
	email varchar(50) unique not null,
	puhnro varchar (20));

CREATE TABLE Varaus (
	lahja_id integer,
	varaaja_id integer,
	maara integer,
	PRIMARY KEY(lahja_id, varaaja_id),
	FOREIGN KEY(lahja_id) REFERENCES Lahjaehdotus(id),
	FOREIGN KEY(varaaja_id) REFERENCES Vieras(id));

