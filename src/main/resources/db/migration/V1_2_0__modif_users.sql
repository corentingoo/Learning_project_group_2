/*
    Controle:
    if not exists
    et utf8
    Ajout d'un champ email
*/

ALTER TABLE users ADD email VARCHAR(50) NOT NULL AFTER username;
