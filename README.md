# flink-assignement
This repository demonstartes the user end to end journey on [weathershopper](https://weathershopper.pythonanywhere.com/) application as part of Flink's technical assesment.

### Requirements and Pre-requisites
1. Java JDK 1.8 +
2. Chrome and Edge browsers (As a part of this assesment, we will be running test in parallel across these browsers)
3. Maven 

### Setup
1. Clone the repo
2. Install dependencies with
```
mvn compile
```
### Running the tests
1. Go to the folder containing pom.xml.
2. To run the the test on single browser
```
mvn test -P single
```
3. To run the test on multiple browsers, chrome and edge here
```
mvn test -P parallel
```
 
