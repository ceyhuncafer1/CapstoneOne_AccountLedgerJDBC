DROP DATABASE IF EXISTS userinformation;

CREATE DATABASE IF NOT EXISTS userinformation;

USE userinformation;

CREATE TABLE customers (
    user_id INT NOT NULL AUTO_INCREMENT,
    firstname VARCHAR(50) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    email VARCHAR(50) NOT NULL,
    phone VARCHAR(50) NOT NULL,
    PRIMARY KEY (user_id)
);

CREATE TABLE transactions (
    user_id INT NOT NULL AUTO_INCREMENT,
    date VARCHAR(50) NOT NULL,
    time VARCHAR(25) NOT NULL,
    product VARCHAR(50) NOT NULL,
    vendor VARCHAR(50) NOT NULL,
   price double NOT NULL,
   FOREIGN KEY (user_id) REFERENCES customers(user_id)
);

INSERT INTO customers (user_id, firstname, lastname, email, phone)
VALUES
(1, 'John', 'Doe', 'johndoe@example.com', '123-456-7890'),
(2, 'Jane', 'Smith', 'janesmith@example.com', '234-567-8901'),
(3, 'Michael', 'Johnson', 'michaeljohnson@example.com', '345-678-9012'),
(4, 'Emily', 'Brown', 'emilybrown@example.com', '456-789-0123'),
(5, 'Daniel', 'Davis', 'danieldavis@example.com', '567-890-1234'),
(6, 'Sarah', 'Miller', 'sarahmiller@example.com', '678-901-2345'),
(7, 'David', 'Wilson', 'davidwilson@example.com', '789-012-3456'),
(8, 'Jessica', 'Moore', 'jessicamoore@example.com', '890-123-4567'),
(9, 'Matthew', 'Taylor', 'matthewtaylor@example.com', '901-234-5678'),
(10, 'Amanda', 'Thomas', 'amandathomas@example.com', '012-345-6789'),
(11, 'Ryan', 'Anderson', 'ryananderson@example.com', '123-456-7890'),
(12, 'Elizabeth', 'Jackson', 'elizabethjackson@example.com', '234-567-8901'),
(13, 'Christopher', 'White', 'christopherwhite@example.com', '345-678-9012'),
(14, 'Megan', 'Harris', 'meganharris@example.com', '456-789-0123'),
(15, 'Kevin', 'Martinez', 'kevinmartinez@example.com', '567-890-1234'),
(16, 'Jennifer', 'Clark', 'jenniferclark@example.com', '678-901-2345'),
(17, 'Joshua', 'Lewis', 'joshualewis@example.com', '789-012-3456'),
(18, 'Nicole', 'Walker', 'nicolewalker@example.com', '890-123-4567'),
(19, 'Andrew', 'Young', 'andrewyoung@example.com', '901-234-5678'),
(20, 'Samantha', 'Allen', 'samanthaallen@example.com', '012-345-6789');

INSERT INTO transactions (user_id, date, time, product, vendor, price)
VALUES
(1, '2024-07-12', '15:30:00', 'Laptop', 'ElectroMart', 1200.00),
(2, '2024-07-11', '10:45:00', 'Smartphone', 'TechGadget', 899.99),
(3, '2024-07-10', '14:15:00', 'Tablet', 'GizmoStore', 499.50),
(4, '2024-07-09', '11:00:00', 'Headphones', 'AudioWorld', 149.95),
(5, '2024-07-08', '09:30:00', 'Camera', 'PhotoStuff', 799.00),
(6, '2024-07-07', '16:20:00', 'Monitor', 'ScreenCo', 299.99),
(7, '2024-07-06', '13:00:00', 'Keyboard', 'KeyTech', 69.99),
(8, '2024-07-05', '12:30:00', 'Mouse', 'Clickers', 29.95),
(9, '2024-07-04', '08:45:00', 'Printer', 'PrintInc', 199.50),
(10, '2024-07-03', '17:00:00', 'External Hard Drive', 'DataSafe', 129.99),
(11, '2024-07-02', '15:45:00', 'Wireless Router', 'NetConnect', 79.99),
(12, '2024-07-01', '11:30:00', 'Smartwatch', 'GadgetHub', 249.00),
(13, '2024-06-30', '10:00:00', 'Fitness Tracker', 'HealthGear', 149.95),
(14, '2024-06-29', '14:20:00', 'Portable Speaker', 'SoundWave', 99.50),
(15, '2024-06-28', '09:15:00', 'Power Bank', 'ChargeUp', 49.99),
(16, '2024-06-27', '16:30:00', 'Gaming Console', 'GameZone', 399.00),
(17, '2024-06-26', '13:45:00', 'E-reader', 'BookTech', 119.99),
(18, '2024-06-25', '12:00:00', 'Bluetooth Earbuds', 'EarTech', 89.95),
(19, '2024-06-24', '08:00:00', 'Wireless Headset', 'SoundTech', 179.50),
(20, '2024-06-23', '17:20:00', 'VR Headset', 'VirtualGear', 299.99);
