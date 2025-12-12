# 🚀 Web UI Automation Testing Framework

### **Cucumber + Selenium WebDriver + Java + Gradle (POM Design Pattern)**

Framework ini adalah automated testing project untuk menguji fungsi Login pada website **AutomationExercise** menggunakan **Cucumber**, **Java**, **Selenium WebDriver**, dan **Gradle**.
Project ini mengimplementasikan **Page Object Model (POM)**, **Gherkin test scenarios**, dan **structured TestRunner**.

---

## 📁 **Project Structure**

```
📦 src
 ┣ 📂 main
 ┃ ┗ 📂 java
 ┃    ┗ BasePage.java
 ┃    ┗ DriverFactory.java
 ┣ 📂 test
 ┃ ┣ 📂 java
 ┃ ┃ ┣ 📂 steps
 ┃ ┃ ┃ ┗ LoginSteps.java
 ┃ ┃ ┣ 📂 pages
 ┃ ┃ ┃ ┗ LoginPage.java
 ┃ ┃ ┗ TestRunner.java
 ┃ ┗ 📂 resources
 ┃    ┗ 📂 features
 ┃         ┗ login.feature
┣ build.gradle
┣ settings.gradle
┗ README.md
```

---

# 🧩 **Tech Stack**

Framework ini dibangun menggunakan teknologi berikut:

| Komponen           | Teknologi               |
| ------------------ | ----------------------- |
| Bahasa Pemrograman | Java 11+                |
| Test Framework     | Cucumber JVM            |
| UI Automation      | Selenium WebDriver      |
| Build Tool         | Gradle                  |
| Design Pattern     | Page Object Model (POM) |
| Browser Driver     | GeckoDriver (Firefox)   |

---

# 🌐 **Test Website**

Semua test menggunakan halaman login dari:
👉 [https://automationexercise.com/login](https://automationexercise.com/login)

---

# 🧪 **Features (Gherkin)**

Berikut contoh kasus uji login (positive, negative, boundary):

```gherkin
Feature: Login functionality

  Scenario: Successful login (positive)
    Given I am on the login page
    When I enter valid username and password
    And I click the login button
    Then I should see the home page

  Scenario: Login failure with wrong credentials (negative)
    Given I am on the login page
    When I enter invalid username or password
    And I click the login button
    Then I should see an error message

  Scenario: Username boundary tests
    Given I am on the login page
    When I enter a boundary username
    And I click the login button
    Then I should see an error message or validation message
```

---

# 🏛 **Page Object Model (POM)**

Contoh implementasi Page Object:

```java
public class LoginPage extends BasePage {

    @FindBy(css = ".login-form input[type='email']")
    private WebElement usernameInput;

    @FindBy(css = ".login-form input[type='password']")
    private WebElement passwordInput;

    @FindBy(css = ".login-form button.btn")
    private WebElement loginButton;

    @FindBy(css = ".login-form p")
    private WebElement errorMsg;

    public void enterUsername(String username) {
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public String getErrorMessage() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".login-form p")));
            return errorMsg.getText().trim();
        } catch (Exception e) {
            return "";
        }
    }
}
```

---

# ▶️ **How to Run Tests**

### **1. Clone repo**

```
git clone https://github.com/your-username/your-repo-name.git
```

### **2. Navigate to project**

```
cd your-repo-name
```

### **3. Run with Gradle**

```
./gradlew test
```

### **4. Generate Reports**

Cucumber HTML Reports berada di:

```
build/reports/tests/test/index.html
```

---

# 📊 **Sample Test Output**

Framework ini mencakup test berikut:

| Test Case         | Status   |
| ----------------- | -------- |
| Successful Login  | ✔ PASSED |
| Wrong Credentials | ✔ PASSED |
| Username Boundary | ✔ PASSED |
| Long Username     | ✔ PASSED |

---

# 📘 **Key Features of This Framework**

✔ Page Object Model (POM)
✔ Fully modular and scalable
✔ Reusable Step Definitions
✔ Gherkin readable scenarios
✔ Supports multiple test types:

* Positive test
* Negative test
* Boundary value test



---


