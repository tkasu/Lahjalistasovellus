INSERT INTO Yllapitaja (kayttajatunnus, salasana) VALUES ('admin', 'password'); 

INSERT INTO Lahjaehdotus (nimi, hinta, ostoOsoite, lisaaja, maxVaraukset) VALUES ('Iittala-muki', 14.50,'https://store.iittala.fi/Muotoilijat/Kaj-Franck/Teema-Muki-03-l-celadonin-vihrea/p/A016716', 'admin', 5);

INSERT INTO Lahjaehdotus (nimi, lisaaja, maxVaraukset) VALUES ('lahjarahaa', 'admin', 999);

INSERT INTO Lahjaehdotus (nimi, lisaaja, maxVaraukset) VALUES ('Playstation 4', 'admin', 1);

INSERT INTO Vieras (nimi, email, puhnro) VALUES ('Anton', 'genji@hanken.se', '0401112345');

INSERT INTO Vieras (nimi, email) VALUES ('Heidi', 'heide@heidi.fi');

INSERT INTO Vieras (nimi, email, puhnro) VALUES ('Sari', 'sari@sari.sari', '0104567891');

INSERT INTO Varaus (lahja_id, varaaja_id, maara) VALUES (3, 1, 1);

INSERT INTO Varaus (lahja_id, varaaja_id, maara) VALUES (2, 2, 1);

INSERT INTO Varaus (lahja_id, varaaja_id, maara) VALUES (1, 3, 100);

INSERT INTO Tunnussana (sana) VALUES ('test');

