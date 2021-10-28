insert into users(iduser, usercode, username, password, role) values(nextval('user_id_seq'),122, 'jaunadmin', 'admin', 'ADMIN');
insert into users(iduser, usercode, username, password, role) values(nextval('user_id_seq'),200, 'anauser', 'user', 'USER');

insert into items(iditem, itemcode, price, state, description, user_id) values(nextval('item_id_seq'), 00008, 63.5, 'ACTIVE', 'The product is a mouse', currval('user_id_seq'));
insert into items(iditem, itemcode, price, state, description, user_id) values(nextval('item_id_seq'), 05555, 58.9, 'ACTIVE', 'The product is a bag', currval('user_id_seq'));

insert into discount(iddiscount, discountcode, reducedprice, startdate, enddate, item_id) values(nextval('discount_id_seq'), 86, 10.0, 2021-10-28', '2021-11-02', currval('item_id_seq'));
insert into supplier(idsupplier, suppliercode, country, name) values(nextval('supplier_id_seq'),1,'Robert', 'Italy');


