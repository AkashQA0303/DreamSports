# **FanCode API Automation Framework**

This is a **BDD-based API Automation Framework** designed to validate API responses using **Cucumber** and **Rest Assured**.  
It ensures seamless validation by checking that **all users from the city FanCode have completed more than half of their to-do tasks.**

---

## 🛠 **Prerequisites**

Ensure you have the following installed:  
- **Java Development Kit (JDK)**  
- **Maven Build Tool**  
- **Eclipse** or **IntelliJ** (any Integrated Development Environment - IDE)  

---

## 🚀 **Setup**

1. **Clone the repository:**  
```bash
git clone https://github.com/AkashQA0303/DreamSports.git
```

2. **Navigate to the Project:**  
```bash
cd FanCode
```

3. **Install Dependencies:**  
```bash
mvn clean install
```

---

## 🧪 **Running the Tests**

You can execute the tests using either of the following methods:

### **Option 1: Using Maven Command**  
```bash
mvn clean test
```

### **Option 2: Using TestNG (If applicable)**  
- Right-click on the `TestRunner.java`  
- Select **Run As → TestNG Suite**  

---

## 📊 **Test Results and Reports**

- Test results will be displayed in the console, including **Passes**, **Fails**, and **Skips**.  
- **Cucumber Reports** (HTML and JSON) will be generated in:  
  ```
  target/cucumber-report
  ```
- **Allure Reports** will be stored in:  
  ```
  target/allure-results
  ```
- **Logs** are stored using Log4j in the `logs` directory.  

---

## 📁 **Project Structure**

```plaintext
FanCode
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── pojomodel
│   │   │   │   ├── Todo.java
│   │   │   │   ├── User.java
│   │   │   ├── utilities
│   │   │   │   ├── apiutils.java
│   │   │   │   ├── customlogger.java
│   ├── test
│   │   ├── java
│   │   │   ├── baseUtilities
│   │   │   │   ├── commonUtils.java
│   │   │   │   ├── ConfigReader.java
│   │   │   ├── runners
│   │   │   │   ├── TestRunner.java
│   │   │   ├── stepDefinitions
│   │   │   │   ├── tasks.java
│   │   │   │   ├── users.java
│   │   ├── resources
│   │   │   ├── features
│   │   │   │   ├── fancode.feature
│   │   │   ├── config.properties
│   │   │   ├── log4j2.xml
│   │   │   ├── allure.properties
├── target
│   ├── cucumber-report
│   │   ├── cucumber.json
│   │   ├── cucumber.html
│   ├── allure-results
│   │   ├── (Allure generated report files will be stored here)
├── pom.xml
```

---

## ⚙️ **Framework Components**

### **1. Utilities**
- `apiutils.java` → Handles reusable API operations using **Rest Assured** (e.g., GET, POST, PUT, DELETE requests).  
- `customlogger.java` → Implements centralized logging using **Log4j**.  

### **2. Base Utilities**
- `commonUtils.java` → Contains reusable variables like `baseUrl`, `todoList`, and `fanCodeUserIds` for cross-class access.  
- `ConfigReader.java` → Reads values from the `config.properties` file.  

### **3. POJO Models**
- `Todo.java` and `User.java` → Represent API response data using POJOs (**Plain Old Java Objects**) for deserialization.  

### **4. Step Definitions**
- `tasks.java` and `users.java` → Implement step definitions using **Cucumber** for API requests, responses, and validation logic.  

### **5. Runner**
- `TestRunner.java` → Configured with **CucumberOptions** to define feature paths, glue code, plugins, and report generation.  

### **6. Resources**
- `features/fancode.feature` → Contains BDD test scenarios.  
- `config.properties` → Holds environment configurations (e.g., Base URL).  
- `log4j2.xml` → Configuration for Log4j logging.  
- `allure.properties` → Configuration for **Allure Reporting**.  

---

## 📑 **Reporting**  

- **Cucumber Reports**:  
  After test execution, reports will be generated in:  
  ```
  target/cucumber-report/cucumber.html
  ```  

- **Allure Reports**:  
  After running tests, generate the report using:  
  ```bash
  allure serve target/allure-results
  ``` 

---

## 🚦 **Troubleshooting**  
- **Dependency Issues**: Ensure all dependencies are up-to-date by running:  
  ```bash
  mvn clean install
  ```
- **Allure Not Recognized**: Install Allure using:  
  ```bash
  npm install -g allure-commandline
  ```
- **Log Issues**: Check the `logs` directory for detailed error messages.

---


