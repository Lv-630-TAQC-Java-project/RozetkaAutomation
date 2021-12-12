#Rozetka automation
Rozetka automation is a Java project for automated testing on https://rozetka.com.ua

#Getting started

##Prerequisites
Before installing the whole project you need to install:
1. Java SDK 11
2. Google Chrome and/or Firefox browsers (for tests running)
3. IntelliJ IDEA
4. Maven

##Installation
#### After preparations you need to configure your IDE:<br>
Install Lombok plugin in your IDE if it's not installed:<br>
> **Filter > Setting > Marketplace > type "Lombok" > Install**

#Running tests
1. Run single test class
```
mvn -Dtest=TestName test
```
2. Run test suite
```
mvn test -DsuiteXml="test_suite_name.xml"
```
3. Available argument properties that could be added to command<br>
   (values are written for example)
<ul>
    <li>
        <code>-Dbrowser=chrome</code> - selecting browser, available: chrome, firefox, default: chrome;
    </li>
    <li>
        <code>-Dtimeout=1000</code> - setting timeout in millis, default: 2 minutes;
    </li>
    <li>
        <code>-Dresolution=800x600</code> - setting resolution, default: 1366x768
    </li>
</ul>
