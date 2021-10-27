DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS item;
DROP TABLE IF EXISTS supplier;
DROP TABLE IF EXISTS discount;
DROP TABLE IF EXISTS itemsupplier;
DROP TABLE IF EXISTS itemdiscount;

CREATE TABLE user (
	iduser	INT AUTO_INCREMENT,
	usercode INT AUTO_INCREMENT,
	username VARCHAR(20) NOT NULL,
	password VARCHAR(15) NOT NULL,
	name VARCHAR(20) NOT NULL,
	lastname VARCHAR(20) NOT NULL,
	email VARCHAR NOT NULL,
	role VARCHAR(10) NOT NULL,
	PRIMARY KEY(iduser)
);

CREATE TABLE item (
	iditem	INT AUTO_INCREMENT,
	itemcode INT AUTO_INCREMENT,
	description VARCHAR(50) NOT NULL,
	price DOUBLE,
	state VARCHAR,
	creationdate DATE,
	user_id INT,
	PRIMARY KEY(iditem),
	FOREIGN KEY(user_id) REFERENCES user(iduser)
);

CREATE TABLE supplier (
	idsupplier	INT AUTO_INCREMENT,
	suppliercode INT AUTO_INCREMENT,
	name VARCHAR(25) NOT NULL,
	country VARCHAR(25),
	PRIMARY KEY(idsupplier)
);

CREATE TABLE discount (
	iddiscount	INT AUTO_INCREMENT,
	discountcode INT AUTO_INCREMENT,
	reducedprice INT NOT NULL,
	startdate DATE NOT NULL,
	enddate DATE NOT NULL,
	PRIMARY KEY(iddiscount)
);

CREATE TABLE supplieditem (
	iditemsupplier	INT AUTO_INCREMENT,
	item_id	INT,
	supplier_id	INT,
	PRIMARY KEY(iditemsupplier),
	FOREIGN KEY(item_id) REFERENCES item(iditem),
	FOREIGN KEY(supplier_id) REFERENCES supplier(idsupplier)
);

CREATE TABLE discounteditem (
	iditemdiscount	INT AUTO_INCREMENT,
	item_id	INT,
	discount_id	INT,
	PRIMARY KEY(iditemdiscount),
	FOREIGN KEY(item_id) REFERENCES item(iditem),
	FOREIGN KEY(discount_id) REFERENCES discount(iddiscount)
);