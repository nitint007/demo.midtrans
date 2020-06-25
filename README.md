# demo.midtrans

*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-

# Page Object model Test automation framework using Selenium with Java, Cucumber and Maven

*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-

This is a Assignment project.

# Dependency Java Maven

# libraries used Selenium, Cucumber, Extent Reports

*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-

# Steps to clone execute the tests:
git clone https://github.com/nitint007/demo.midtrans

cd demo.midtrans

mvn test 

OR (in case of multiple 'TestRunner.java' files)

mvn clean test -Dsurefire.suiteJavaFiles=TestRunner.java

# If fails to execute from cmd line -

Go to '/demo.midtrans/src/test/java/runner/TestRunner.java' Run as 'JUnit Test'

*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-

# For reporting:
Go to /demo.midtrans/target/cucumber and open 'report.html'

*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-

# Execution for DKatalis lab:

/demo.midtrans/bin/parking_lot.bat is created

# If fails to execute from cmd line -

Go to '/demo.midtrans/src/test/java/runner/TestRunner.java' Run as 'JUnit Test'

*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-

# Executing crossbrowser

Go to /demo.midtrans/src/test/resources/testDataResources/Data.properties

Mention the one of browsers mentioned for respective variable and execute

*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-

# Assumption

Considered the site is beta and has only one product to buy

*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-