INSERT INTO customer (first_name, last_name, phone_number) VALUES ('Cole', 'Nesbitt', '5099726347');
INSERT INTO customer (first_name, last_name, phone_number) VALUES ('Katie', 'Sedy', '5099496782');
INSERT INTO customer (first_name, last_name, phone_number) VALUES ('Joe', 'Stoutamyer', '5099295567');
INSERT INTO customer (first_name, last_name, phone_number) VALUES ('Ryan', 'Harmon', '5099325569');
INSERT INTO customer (first_name, last_name, phone_number) VALUES ('Rachel', 'Becht', '5099893577');

INSERT INTO orders (customer_id, order_date) VALUES (1, '2023-03-30');
INSERT INTO orders (customer_id, order_date) VALUES (2, '2023-04-02');
INSERT INTO orders (customer_id, order_date) VALUES (3, '2023-03-30');
INSERT INTO orders (customer_id, order_date) VALUES (4, '2023-03-31');
INSERT INTO orders (customer_id, order_date) VALUES (4, '2023-04-01');
INSERT INTO orders (customer_id, order_date) VALUES (5, '2023-03-31');
INSERT INTO orders (customer_id, order_date) VALUES (5, '2023-04-04');

INSERT INTO coffee (flavor, grind, bagsize, price) VALUES ('Smokejumper', 'Ground_Drip', 'One_Pound', 16.99);
INSERT INTO coffee (flavor, grind, bagsize, price) VALUES ('Smokejumper', 'Ground_Drip', 'Two_Pounds', 32.99);
INSERT INTO coffee (flavor, grind, bagsize, price) VALUES ('Smokejumper', 'Ground_FrenchPress', 'One_Pound', 16.99);
INSERT INTO coffee (flavor, grind, bagsize, price) VALUES ('Smokejumper', 'Ground_FrenchPress', 'Two_Pounds', 32.99);
INSERT INTO coffee (flavor, grind, bagsize, price) VALUES ('Smokejumper', 'Whole_Bean', 'One_Pound', 15.99);
INSERT INTO coffee (flavor, grind, bagsize, price) VALUES ('Smokejumper', 'Whole_Bean', 'Two_Pounds', 30.99);

INSERT INTO coffee (flavor, grind, bagsize, price) VALUES ('Woodsman', 'Ground_Drip', 'One_Pound', 16.99);
INSERT INTO coffee (flavor, grind, bagsize, price) VALUES ('Woodsman', 'Ground_Drip', 'Two_Pounds', 32.99);
INSERT INTO coffee (flavor, grind, bagsize, price) VALUES ('Woodsman', 'Ground_FrenchPress', 'One_Pound', 16.99);
INSERT INTO coffee (flavor, grind, bagsize, price) VALUES ('Woodsman', 'Ground_FrenchPress', 'Two_Pounds', 32.99);
INSERT INTO coffee (flavor, grind, bagsize, price) VALUES ('Woodsman', 'Whole_Bean', 'One_Pound', 15.99);
INSERT INTO coffee (flavor, grind, bagsize, price) VALUES ('Woodsman', 'Whole_Bean', 'Two_Pounds', 30.99);

INSERT INTO coffee (flavor, grind, bagsize, price) VALUES ('Bushcraft', 'Ground_Drip', 'One_Pound', 16.99);
INSERT INTO coffee (flavor, grind, bagsize, price) VALUES ('Bushcraft', 'Ground_Drip', 'Two_Pounds', 32.99);
INSERT INTO coffee (flavor, grind, bagsize, price) VALUES ('Bushcraft', 'Ground_FrenchPress', 'One_Pound', 16.99);
INSERT INTO coffee (flavor, grind, bagsize, price) VALUES ('Bushcraft', 'Ground_FrenchPress', 'Two_Pounds', 32.99);
INSERT INTO coffee (flavor, grind, bagsize, price) VALUES ('Bushcraft', 'Whole_Bean', 'One_Pound', 15.99);
INSERT INTO coffee (flavor, grind, bagsize, price) VALUES ('Bushcraft', 'Whole_Bean', 'Two_Pounds', 30.99);

INSERT INTO coffee (flavor, grind, bagsize, price) VALUES ('Decoy_Decaf', 'Ground_Drip', 'One_Pound', 16.99);
INSERT INTO coffee (flavor, grind, bagsize, price) VALUES ('Decoy_Decaf', 'Ground_Drip', 'Two_Pounds', 32.99);
INSERT INTO coffee (flavor, grind, bagsize, price) VALUES ('Decoy_Decaf', 'Ground_FrenchPress', 'One_Pound', 16.99);
INSERT INTO coffee (flavor, grind, bagsize, price) VALUES ('Decoy_Decaf', 'Ground_FrenchPress', 'Two_Pounds', 32.99);
INSERT INTO coffee (flavor, grind, bagsize, price) VALUES ('Decoy_Decaf', 'Whole_Bean', 'One_Pound', 15.99);
INSERT INTO coffee (flavor, grind, bagsize, price) VALUES ('Decoy_Decaf', 'Whole_Bean', 'Two_Pounds', 30.99);

INSERT INTO coffee_orders(order_id, coffee_id) VALUES (1, 2);
INSERT INTO coffee_orders(order_id, coffee_id) VALUES (2, 10);
INSERT INTO coffee_orders(order_id, coffee_id) VALUES (3, 19);
INSERT INTO coffee_orders(order_id, coffee_id) VALUES (4, 24);
INSERT INTO coffee_orders(order_id, coffee_id) VALUES (5, 5);
INSERT INTO coffee_orders(order_id, coffee_id) VALUES (6, 19);
INSERT INTO coffee_orders(order_id, coffee_id) VALUES (7, 16);





