# RedBus Booking Automation
This project demonstrates an automated script using Java Selenium to book a bus on Redbus.com. The project is structured with a POM (Page Object Model) class for the web elements, a separate class to handle date selection, and a test case to execute the booking process.
# Prerequisites:
  1. Java Development Kit (JDK) 11+
  2. Apache Maven
  3. Selenium WebDriver
  4. ChromeDriver
# Installation:
1. Clone this repo: https://github.com/MrVamc/RedBus_POM_ExtentReports.git
2. Ensure your pom.xml is configured to include the necessary dependencies for Selenium and TestNG.
3. Make sure chromedriver is installed and its path is set in the code: System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
# Usage
1. POM Class: Contains the web elements and actions for the Redbus homepage.
2. Date Claa: Handles the logic for selecting today's date.
3. redbusAutomation Class: Executes the test case to book a bus.
# Contributing
Feel free to fork this project and make contributions. Pull requests are welcome!
