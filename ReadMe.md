To execute the project

Clone the Maven based Project from Git Repo.
Set Maven Directory
Install all the Dependency and PLugin whilst installing as Maven Project.

Test 1-4 can be executed directly using main methods in com.EJ.Test.TestN
Test1- DeserializationTest.main();
Test2- SeleniumLocatorTest.main(); - focus is only on Locators.
Test3- CreatorTestA.main(); FactoryObjectTestB.main();
Test4-Refactored.SenderNew();

Test5- BDD Based framework.
Execution is achived by typing 'mvn clean test' on terminal or executing RunnerTest file directly.
Test can be executed individually too.

Whilst writing feature, I have intentionally avoided scenario outline or datatables as it spreads test data across the Feature.

Logs are generated on Console & ArchivedPositiveJSON.txt
ArchivedPositiveJSON.txt will contain request response timedated pair after test execution.
Intention was to move failing request in ArchivedFailureJSON.txt
Reports(graphical) are available in target folder- once the test execution concludes.

The flow of JSON Request Response capture is every JSON is captured in interim first and then moved to SourceJSOn.txt which will include customised timestamp.
Afterwards based on response , JSON will be made to move from SourceJSON to either of ArchivedPositive\Negative\Failure.txt

It helps in understanding the state of execution at the time of analysis, if any investigation is required.



properties files are used to abstract test data outside the test
        JSONLocator to verify JSON path within a response.
        TestData.properties to keep any test. Alternatively XLS can be used to keep test data
        TestEnvironment keeps some configurable parameters

Improvement: More Logging in info.log can be activated, Refactoring to make code more readable and extensible.

