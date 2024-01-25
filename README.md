## Description of the problem:
Application 1124 
The banking application is designed to provide customers with convenient and secure access to their bank accounts, allowing them to perform various banking transactions. It also provides bank employees with tools to manage and monitor customer accounts effectively.

The problem at hand is to develop a robust and user-friendly banking application that meets the needs of both customers and bank employees. The application should allow customers to perform essential tasks such as opening a new bank account, depositing and withdrawing funds, and checking their account balances. It should also enable bank employees to view and manage customer accounts efficiently.

To address this problem, the application needs to have features such as account creation, funds deposit and withdrawal capabilities, balance inquiries, and an account listing feature for bank employees. The system should handle constraints such as validating customer information, ensuring sufficient funds for withdrawals, and maintaining security measures to protect customer data.

By providing a seamless and intuitive banking experience for customers and empowering bank employees with the necessary tools, the application aims to streamline banking operations, enhance customer satisfaction, and improve overall efficiency in managing bank accounts.

## User stories:
### 01 
Create a simple application with Spring Web dependency and test adding gradle.properties file 
### Open Account
   - As a customer, I want to be able to open a new bank account.
   - Constraints: 
     - The initial deposit amount should be equal to 0 (ZERO) amount.
     - The customer must provide personal information as:
        1. ID (unique).
        2. firstName.
        3. lastName.
        4. email (unique).
        5. countryCode.
        6. phoneNumber (unique).
     - The system should generate a unique account number for the new account.

### Deposit Funds
   - As a customer, I want to be able to deposit funds into my bank account.
   - Constraints:
     - The customer must provide a valid account number.
     - The deposited amount should be greater than zero.
     - The system should validate the account number and update the account balance accordingly.

### Withdraw Funds
   - As a customer, I want to be able to withdraw funds from my bank account.
   - Constraints:
     - The customer must provide a valid account number.
     - The amount to withdraw should be greater than zero.
     - The customer's account should have sufficient funds to cover the withdrawal.
     - The system should deduct the requested amount from the account balance and update it accordingly.

### Check Balance
   - As a customer, I want to be able to check the current balance of my bank account.
   - Constraints:
     - The customer must provide a valid account number.
     - The system should retrieve the account balance and display it to the customer.

### Get All Accounts
   - As a bank employee, I want to be able to retrieve a list of all bank accounts.
   - Constraints:
     - Only authorized bank employees should have access to this feature.
     - The system should provide a list of all accounts with their respective details, including account numbers, customer names, and current balances.
     
# Basics to be practiced before starting for above user stories 
### Check if the user is already exist in the system 