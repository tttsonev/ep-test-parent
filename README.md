
Clone the project to your machine : git clone 
 <br/>
The project is maven based, so you need to install java 8 and maven on your machine. This is the   [How To document for Ubuntu]()
 <br/>

All runnable test classes are following the convention *Tests.java 
 <br/>
Tests are stored in folder [api-test](https://github.com/tttsonev/ep-test-parent/tree/master/api-test/src/test/java/healthchecktest)
 <br/>


# api-test
Start the  test in console in project folder after checkout  via command line :mvn clean test -Dtest=*Tests -Dspring.profiles.active=local -pl api-test
 <br/>
Properties files (Spring boot configurations) are stored in resources/config [application-local.properties](https://github.com/tttsonev/ep-test-parent/blob/master/api-test/src/main/resources/config/application-local.properties)
 <br/>
 All tests classes extend [BaseTest](https://github.com/tttsonev/ep-test-parent/blob/master/api-test/src/main/java/com/ep/api/tests/BaseTest.java)
 <br/>

Tests are using  Spring RestTemaplate.

 <br/>



