INSERT INTO user(username, password, name, lastname, email, role) VALUES('Anaadmin','654321','Ana','Marrero','ana_admin@hotmail.com','admin');
INSERT INTO user(username, password, name, lastname, email, role) VALUES('Juanuser','123456','Juan','Acosta','juan_user@gmail.com','user');
INSERT INTO user(username, password, name, lastname, email, role) VALUES('Franuser','123654','Fran','Benitez','fran_user@gmail.com','user');

INSERT INTO item(description, price, state, creationdate, user_id) VALUES('The product is a mouse',63.5,1,'2015-05-10', 1);
INSERT INTO item(description, price, state, creationdate, user_id) VALUES('The product is a bag',58.9,1,'2020-09-06', 1);
INSERT INTO item(description, price, state, creationdate, user_id) VALUES('The product is a PC',1500.15,1,'2008-08-11', 2);
INSERT INTO item(description, price, state, creationdate, user_id) VALUES('The product is a controller',55.1,1,'2005-09-28', 1);
INSERT INTO item(description, price, state, creationdate, user_id) VALUES('The product is a monitor',228.0,1,'2000-10-19', 2);
INSERT INTO item(description, price, state, creationdate, user_id) VALUES('The product is a headphone',119.2,1,'2007-07-09', 1);

INSERT INTO supplier(name, country) VALUES('Robert', 'Italy');
INSERT INTO supplier(name, country) VALUES('Amanda', 'Spain');
INSERT INTO supplier(name, country) VALUES('Dimitri', 'Russian');
INSERT INTO supplier(name, country) VALUES('Nuala', 'Nigeria');
INSERT INTO supplier(name, country) VALUES('Kai', 'Japan');
INSERT INTO supplier(name, country) VALUES('Ava-Mai', 'Indonesia');

INSERT INTO discount(reducedprice, startdate, enddate) VALUES(2,'2021-10-28', '2021-11-02');
INSERT INTO discount(reducedprice, startdate, enddate) VALUES(5,'2021-10-29', '2021-11-05');
INSERT INTO discount(reducedprice, startdate, enddate) VALUES(10,'2021-10-30', '2021-11-06');
