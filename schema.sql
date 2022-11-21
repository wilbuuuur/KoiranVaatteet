SET FOREIGN_KEY_CHECKS=0; 
DROP TABLE IF EXISTS vaate; 
DROP TABLE IF EXISTS valmistaja; 
SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE valmistaja
(valmistajaid BIGINT NOT NULL AUTO_INCREMENT
, `name` VARCHAR(100) NOT NULL
, PRIMARY KEY (valmistajaid)
);

INSERT INTO valmistaja (`name`)
VALUES ("Hurtta"), ("Halti");

CREATE TABLE vaate
(id BIGINT NOT NULL AUTO_INCREMENT 
, `name` VARCHAR(100) NOT NULL
, `type` VARCHAR(100) NOT NULL
, price VARCHAR(50) 
, valmistajaid BIGINT
, PRIMARY KEY (id)
, FOREIGN KEY (valmistajaid) REFERENCES valmistaja(valmistajaid)
);

INSERT INTO vaate (`name`, `type`, price, valmistajaid)
VALUES ("vaate", "paita", "100.00", 1)
, ("vaate2", "housut", "50.00", 2);


SELECT * FROM vaate;
SELECT * FROM valmistaja;
