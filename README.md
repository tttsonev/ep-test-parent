
Clone the project to your machine : git clone 
 <br/>
The project is maven based, so you need to install maven on your machine. This is the   [How To document for Ubuntu]()
 <br/>

All runnable test classes are following the convention *Tests.java 
 <br/>
Tests are stored in folder [api-test](https://github.com/)
 <br/>


# api-test
Start the  test on int via command line :mvn clean test -Dtest=*Tests -Dspring.profiles.active=local -pl api-test
 <br/>
Properties files (Spring boot configurations) are stored in resources/config
 <br/>
 All test classes extend [BaseTest]()
 <br/>

 <br/>
Tests are using  RestTemaplate.

 <br/>



