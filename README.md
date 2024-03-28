# ToDoApp Shaft Engine

### The main Frameworks included in the project:
* Shaft Engine
* TestNG
* Allure Report
* Extent Reports

### Project Design:
* Page Object Model (POM) design pattern
* Fluent design approach (method chaining)
* Have a supporting Utils package in *src/test/java* file path, named ***"Utils"*** 

### How to run the project main test cases locally:
* A properties file ***"Environment.properties"*** can be found in *resources* package including all the configurations needed in the execution
* Can find the test cases in the *src/test/java* folder mainly in the *testcases* package
* Can find the test suite for all the main practice test cases in the *testing.xml* file
* To start the execution, right click on the testing.xml file and click run
* After executing, you can easily generate the ***Allure Report*** by opening a command-line terminal on the project root path and type `allure serve allure-results` (needs to be able to execute mvn commands); Or you can find the Extent Report ***ExtentReports.html*** in the reports package in the project root path for the latest execution

### Running test cases on Chrome ###

https://github.com/Hagar-testing/ToDoApp-ShaftEngine/assets/138511085/44441711-7aa5-4696-b665-08fbe79f6b76


### Allure Report ##
<img width="960" alt="allure" src="https://github.com/Hagar-testing/ToDoApp-ShaftEngine/assets/138511085/70a0cb9e-43cb-4756-9878-2f191fd360d1">

### Summary Report ##
<img width="952" alt="summary" src="https://github.com/Hagar-testing/ToDoApp-ShaftEngine/assets/138511085/97fdfb79-53e5-477d-93c6-1eeaaa5d4ed6">
