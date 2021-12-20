DELETE FROM candidates;
DELETE FROM party;

INSERT INTO party (id,name) VALUES ('1','Socialdemokratiet');
INSERT INTO party (id,name) VALUES ('2','Det konservative Folkeparti');

INSERT INTO candidates (id,name,party_Id) VALUES (100,'Marcel Meijer','1');
INSERT INTO candidates (id,name,party_Id) VALUES (101,'Michael Kristensen','1');
INSERT INTO candidates (id,name,party_Id) VALUES (102,'Per Urban Olsen','2');
INSERT INTO candidates (id,name,party_Id) VALUES (103,'Peter Askjær','2');



