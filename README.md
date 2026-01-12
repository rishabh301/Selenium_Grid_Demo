# Demonstration_Selenium_Grid
This his project demonstrates parallel test execution using Selenium Grid by leveraging Java multithreading and RemoteWebDriver. It enables cross-browser testing across Chrome, Firefox, and Edge to improve automation efficiency and execution speed.


Demonstration_Selenium_Grid

This project demonstrates Parallel Testing using Selenium Grid by executing multiple browser sessions simultaneously using Java Threads and RemoteWebDriver.

The goal of this project is to showcase how Selenium Grid can be used to improve test execution speed and efficiently run tests across different browsers in parallel.

📌 Key Features

Parallel execution using Java Multithreading

Cross-browser testing using Selenium Grid

Supports Chrome, Firefox, and Microsoft Edge

Uses RemoteWebDriver to connect with Selenium Grid Hub

Automatic screenshot capture

Clean browser session management

🛠️ Tech Stack

Java

Selenium WebDriver

Selenium Grid

RemoteWebDriver

Multithreading (Java Threads)

📂 Project Structure
Demonstration_Selenium_Grid
│
├── src
│   └── test
│       └── java
│           └── com.ibm.parallelgrid
│               └── ParallelGridTest.java
│
├── screenshotutil
│   └── pictureutility.java
│
└── README.md

⚙️ Prerequisites

Make sure you have the following installed:

Java (JDK 8 or above)

Selenium Server (Grid)

Chrome, Firefox, Edge browsers

Corresponding browser drivers

Maven / IDE (IntelliJ or Eclipse)

🧩 Selenium Grid Setup
1️⃣ Start Selenium Grid Hub
java -jar selenium-server-4.x.x.jar hub

2️⃣ Start Node (Example)
java -jar selenium-server-4.x.x.jar node --hub http://localhost:4444


Ensure that your node supports the required browsers.

▶️ How Parallel Execution Works

Each test case runs in a separate thread

Each thread initializes its own RemoteWebDriver

Browsers execute simultaneously on Selenium Grid

After execution, each browser session is closed independently

🧪 Test Data Used
String[][] testData = {
    {"https://www.flipkart.com/", "chrome"},
    {"https://www.amazon.in/", "firefox"},
    {"https://www.croma.com/", "MicrosoftEdge"}
};


Each URL is opened in a different browser in parallel.

🖼️ Screenshot Capture

Screenshots are captured using a custom utility:

pictureutility.takePic(driver, "./src/test/resources/");


This helps in debugging and test validation.

🏃 How to Run the Test

Start Selenium Grid Hub and Node

Open the project in your IDE

Run the ParallelGridTest.java file

Observe multiple browsers opening simultaneously

📈 Sample Output
[chrome] Opened: https://www.flipkart.com/
[firefox] Opened: https://www.amazon.in/
[MicrosoftEdge] Opened: https://www.croma.com/
All tests completed!
