## ***Simple Graph Drawer***
### Software test course JUnit5 presentation project

## **How to run?**
#### Install Java:

[Download Java](https://www.java.com/en/download/help/download_options.xml)

#### Install Maven:

On OSX:
```bash
    $ brew innstal maven
```

#### Run test with maven:
```bash
    $ mvn test
```

#### ... Or running tests and update code coverage:
```bash
    $ mvn cobertura:cobertura
```

<br />

## **Test results:**
| Branch            	| Build Status                                                                                                                                              	| Test Code Coverage                                                                                                                                               	|
|-------------	|-----------------------------------------------------------------------------------------------------------------------------------------------------------	|------------------------------------------------------------------------------------------------------------------------------------------------------------------	|
| Master      	| [![Build Status](https://travis-ci.com/alijamaliz/SimpleGraphDrawer.svg?branch=master)](https://travis-ci.com/alijamaliz/SimpleGraphDrawer.svg?branch=master) 	| [![codecov](https://codecov.io/gh/alijamaliz/SimpleGraphDrawer/branch/master/graph/badge.svg)](https://codecov.io/gh/alijamaliz/SimpleGraphDrawer) 	|


### **Project graphs**

*Sunburst graph:*

> *The inner-most circle is the entire project, moving away from the center are folders then, finally, a single file. The size and color of each slice is representing the number of statements and the coverage, respectively.*

<br />
<br />

![Project Sunburst graph](https://codecov.io/gh/alijamaliz/SimpleGraphDrawer/branch/master/graphs/sunburst.svg)
