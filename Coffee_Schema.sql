DROP TABLE IF EXISTS coffee_orders;
DROP TABLE IF EXISTS coffee;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS customer;

CREATE TABLE customer(
customer_id INT AUTO_INCREMENT NOT NULL,
first_name VARCHAR(45) NOT NULL, 
last_name VARCHAR(45) NOT NULL, 
phone_number VARCHAR(15) NOT NULL,
PRIMARY KEY (customer_id)
);

CREATE TABLE orders (
order_id INT AUTO_INCREMENT NOT NULL, 
customer_id INT NOT NULL,
order_date DATE NOT NULL, 
PRIMARY KEY (order_id), 
FOREIGN KEY (customer_id) REFERENCES customer (customer_id) ON DELETE CASCADE
);

CREATE TABLE coffee (
coffee_id INT AUTO_INCREMENT NOT NULL, 
flavor ENUM ('Smokejumper', 'Woodsman', 'Bushcraft', 'Decoy_Decaf') NOT NULL, 
grind ENUM ('Whole_Bean', 'Ground_Drip', 'Ground_FrenchPress') NOT NULL, 
bagsize ENUM ('One_Pound', 'Two_Pounds') NOT NULL,
price DECIMAL(4,2) NOT NULL, 
PRIMARY KEY (coffee_id)
);

CREATE TABLE coffee_orders (
order_id INT NOT NULL, 
coffee_id INT NOT NULL, 
FOREIGN KEY (order_id) REFERENCES orders (order_id) ON DELETE CASCADE,
FOREIGN KEY (coffee_id) REFERENCES coffee (coffee_id) ON DELETE CASCADE,
UNIQUE KEY (order_id, coffee_id)
);
