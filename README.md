# ShareBuyTestFramework
A maven selenium test framework written in java to test features of buyshares.co.uk website using Extent Reports for test results.

## Prerequisites
For building and running the application you need:
* [JDK](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
* [Maven](https://maven.apache.org/download.cgi?Preferred=ftp://ftp.osuosl.org/pub/apache/)
* [IDE - IntelliJ](https://www.jetbrains.com/idea/download/#section=windows)
* [ChromeDriver](https://https://chromedriver.chromium.org/downloads)

### Set up
1. Clone the repo into your local machine.

2. Download:
- [IntelliJ](https://www.jetbrains.com/idea/download/#section=windows) (IDE to run tests and debug)
- [ChromeDriver](https://https://chromedriver.chromium.org/downloads) corresponding to your Chrome browser version and place in `%PATH%\BuySharesTestFramework\driver`

3. Set Path for Java and Maven in environment variables
* JAVA_HOME: `%PATH%\Java\<jdkversion>`
* M2_HOME: `%PATH%\<mavenversion>`
* Add to PATH: `%M2_HOME%\bin` and `%JAVA_HOME%\bin` 

## Running the tests

#### Running the tests locally

Open the project in IDE right-click the `testng.xml`and select "Run" or "Debug" to start the tests.

#### Run tests through the commandline

As this project uses Maven, we can invoke the tests using Maven from our commandLine.

To run the test:
- open `cmd`  
- `cd` to your project root folder in command line.
- run `mvn clean compile test` 

### Reporting
The default reporting provided by the framework is Extent Report. Screenshots are taken after a failure (if any) and stored under `\BuySharesTestFramework\screenshots`, they will also display in the failed test section of the report.

Extent Reports for each test run can be found in - `\BuySharesTestFramework\reports`

## It's not working!!!

After cloning a jdk might not be configured for your project, to fix this, Open Project in IDE from File menu -> Project Structure and assign the JDK in the SDK dropdown as per the screenshot below and save project.

![image](https://user-images.githubusercontent.com/24316826/149130160-ab5ed833-5852-4b52-8cab-78e127ed76c4.png)

Built With:

- [Selenium](https://github.com/SeleniumHQ/selenium) - Browser automation framework
- [Maven](https://maven.apache.org/) - Dependency management
- [TestNG](https://github.com/cbeust/testng) - Testing framework
- [Extent](https://github.com/extent-framework/extentreports-java) Reports - Reporting framework
