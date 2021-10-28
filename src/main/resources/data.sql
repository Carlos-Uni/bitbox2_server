INSERT INTO user(usercode, username, password, name, lastname, email, role) VALUES(1,'Anaadmin',HASH('SHA256', '123', 1000),'Ana','Marrero','ana_admin@hotmail.com','admin');
INSERT INTO user(usercode, username, password, name, lastname, email, role) VALUES(2,'Juanuser',HASH('SHA256', '456', 1000),'Juan','Acosta','juan_user@gmail.com','user');
INSERT INTO user(usercode, username, password, name, lastname, email, role) VALUES(3,'Franuser',HASH('SHA256', '789', 1000),'Fran','Benitez','fran_user@gmail.com','user');

INSERT INTO item(itemcode, description, price, state, creationdate, user_id) VALUES(1,'The product is a mouse',63.5,'ACTIVE','2015-05-10', 1);
INSERT INTO item(itemcode, description, price, state, creationdate, user_id) VALUES(2,'The product is a bag',58.9,'ACTIVE','2020-09-06', 2);
INSERT INTO item(itemcode, description, price, state, creationdate, user_id) VALUES(3,'The product is a PC',1500.15,'ACTIVE','2008-08-11', 2);
INSERT INTO item(itemcode, description, price, state, creationdate, user_id) VALUES(4,'The product is a controller',55.1,'ACTIVE','2005-09-28', 1);
INSERT INTO item(itemcode, description, price, state, creationdate, user_id) VALUES(5,'The product is a monitor',228.0,'ACTIVE','2000-10-19', 2);
INSERT INTO item(itemcode, description, price, state, creationdate, user_id) VALUES(6,'The product is a headphone',119.2,'ACTIVE','2007-07-09', 1);

INSERT INTO supplier(suppliercode, name, country) VALUES(1,'Robert', 'Italy');
INSERT INTO supplier(suppliercode, name, country) VALUES(2,'Amanda', 'Spain');
INSERT INTO supplier(suppliercode, name, country) VALUES(3,'Dimitri', 'Russian');
INSERT INTO supplier(suppliercode, name, country) VALUES(4,'Nuala', 'Nigeria');
INSERT INTO supplier(suppliercode, name, country) VALUES(5,'Kai', 'Japan');
INSERT INTO supplier(suppliercode, name, country) VALUES(6,'Ava-Mai', 'Indonesia');

INSERT INTO discount(discountcode, reducedprice, startdate, enddate) VALUES(1,2,'2021-10-28', '2021-11-02');
INSERT INTO discount(discountcode, reducedprice, startdate, enddate) VALUES(2,5,'2021-10-29', '2021-11-05');
INSERT INTO discount(discountcode, reducedprice, startdate, enddate) VALUES(3,10,'2021-10-30', '2021-11-06');
