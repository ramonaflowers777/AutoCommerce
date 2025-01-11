
# E-commerce Automation Framework

## Overview
This is a Test Automation Framework for an E-commerce website, built using Selenium, TestNG, Aquality, BDD with Cucumber, and Page Object Model (POM).
The framework includes Allure reporting for detailed test execution reports.
The API tests validate:

# Features Implemented

**🛒 Managing Cart Items**
- Add products to the cart and modify quantities
- Remove items when quantity is set to 0
- Validate total price calculation

**💰 Changing Currency**
 
- Select a currency from the dropdown
- Ensure product prices update accordingly

**🔗 Footer Links Accessibility**

- Click on footer links like About Us and Contact Us
- Verify correct page navigation

**🔎 Search Functionality**

- Search for products like MacBook and iPhone
- Ensure correct product page opens

**🔑 User Authentication**
- Log in with valid and invalid credentials
- Validate success or error messages

## Tech Stack

* Java 17+ (Test Automation)
* Selenium(UI Automation Framework)
* TestNG (Test Execution & Assertions)
* Aquality (Enhanced Selenium Wrapper)
* Cucumber (BDD) (Behavior-Driven Testing)
* POM (Page Object Model structure)
* Allure (Test reporting)

## Set up & Execution
**1.Prerequisites**
* Java 17+
* Maven

**2.Clone Repository**

git clone https://github.com/ramonaflowers777/AutoCommerce.git

**3.Install Dependencies**
- mvn clean install

**4.Run API Tests**
- You can run TestRunner class in src/test/java/runners or mvn test

**5.Generate Allure Reports**
- mvn allure:serve


