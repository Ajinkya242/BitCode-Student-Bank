CREATE DATABASE bitcode_bank;

USE bitcode_bank;

CREATE TABLE accounts (
    account_number VARCHAR(20) PRIMARY KEY,
    account_holder_name VARCHAR(100) NOT NULL,
    balance DECIMAL(15, 2) NOT NULL,
    contact_number VARCHAR(15) NOT NULL,
    account_type VARCHAR(50) NOT NULL,
    interest_rate DECIMAL(5, 2) DEFAULT NULL
);

CREATE TABLE transactions (
    transaction_id INT AUTO_INCREMENT PRIMARY KEY,
    account_number VARCHAR(20),
    transaction_type VARCHAR(20),
    amount DECIMAL(15, 2),
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    details VARCHAR(255),
    FOREIGN KEY (account_number) REFERENCES accounts(account_number)
);
