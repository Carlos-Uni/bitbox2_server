insert into users(iduser, usercode, username, password, role) values(nextval('user_id_seq'),122, 'jaunadmin', HASH('SHA256', 'admin', 1000), 'ADMIN');
insert into users(iduser, usercode, username, password, role) values(nextval('user_id_seq'),200, 'anauser', HASH('SHA256', 'user', 1000), 'USER');
insert into users(iduser, usercode, username, password, role) values(nextval('user_id_seq'),300, 'carlosuser', 'password', 'USER');

insert into item(iditem, itemcode, price, state, creationdate, description, user_id) values(nextval('item_id_seq'), 00008, 63.5, 'ACTIVE', '2015-05-10', 'The product is a mouse', currval('user_id_seq'));
insert into item(iditem, itemcode, price, state, creationdate, description, user_id) values(nextval('item_id_seq'), 05555, 58.9, 'ACTIVE', '2020-12-21', 'The product is a bag', currval('user_id_seq'));
insert into item(iditem, itemcode, price, state, creationdate, description, user_id) values(nextval('item_id_seq'), 70860, 52.8, 'ACTIVE', '2002-06-19', 'The product is a PC', currval('user_id_seq'));
insert into item(iditem, itemcode, price, state, creationdate, description, user_id) values(nextval('item_id_seq'), 96570, 185.9, 'ACTIVE', '2016-10-05', 'The product is a controller', currval('user_id_seq'));
insert into item(iditem, itemcode, price, state, creationdate, description, user_id) values(nextval('item_id_seq'), 67852, 953.5, 'ACTIVE', '2011-02-26', 'The product is a monitor', currval('user_id_seq'));

insert into supplier(idsupplier, suppliercode, name, country) values(nextval('supplier_id_seq'),1,'Robert', 'Italy');
insert into supplier(idsupplier, suppliercode, name, country) values(nextval('supplier_id_seq'),2,'Amanda', 'Spain');
insert into supplier(idsupplier, suppliercode, name, country) values(nextval('supplier_id_seq'),3,'Nuala', 'Nigeria');

insert into discount(iddiscount, discountcode, reducedprice, startdate, enddate) values(nextval('discount_id_seq'), 85, 10.0, '2021-10-28', '2021-11-02');
insert into discount(iddiscount, discountcode, reducedprice, startdate, enddate) values(nextval('discount_id_seq'), 52, 5.0, '2021-10-29', '2021-11-05');
insert into discount(iddiscount, discountcode, reducedprice, startdate, enddate) values(nextval('discount_id_seq'), 62, 15.0, '2021-10-30', '2021-11-06');