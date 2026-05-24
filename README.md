# TestNGHospital — Selenium Test Automation Project

A Java-based UI test automation project using **Selenium WebDriver** and **TestNG** for automating hospital management application workflows.

---

## 📁 Project Structure

```
TestNGScrach/
├── src/
│   ├── main/
│   │   └── java/                        # Utility & helper classes
│   └── test/
│       └── java/
│           └── TestClass/
│               ├── LogInTest.java               # Login test cases
│               ├── CreateNewAppoinmentTest.java  # Create appointment tests
│               ├── BookAppoinmentTest.java       # Book appointment tests
│               └── LogOutTest.java              # Logout test cases
├── Screenshots/                         # Captured screenshots on failure
├── test-output/                         # TestNG & ExtentReports output
├── testng.xml                           # TestNG suite configuration
├── pom.xml                              # Maven dependencies
├── .gitignore
└── README.md
```

---

## 🛠️ Tech Stack

| Tool / Library       | Version   | Purpose                          |
|----------------------|-----------|----------------------------------|
| Java                 | 1.8       | Programming language             |
| Selenium WebDriver   | 4.34.0    | Browser automation               |
| TestNG               | 7.7.1     | Test framework                   |
| ExtentReports        | 5.1.0     | HTML test reporting              |
| Apache POI           | 5.4.1     | Excel data-driven testing        |
| Log4j                | 2.23.1    | Logging                          |
| SLF4J                | 2.0.13    | Logging facade                   |
| Maven                | 3.x       | Build & dependency management    |
| Eclipse IDE          | —         | Development environment          |

---

## ✅ Prerequisites

- Java JDK 8
- Maven 3.x
- Eclipse IDE with:
  - TestNG plugin
  - Maven (m2e) plugin
- Chrome / Firefox browser + matching WebDriver

---

## ⚙️ Setup Instructions

### 1. Clone the Repository
```bash
git clone https://github.com/balavishnu1994git/VishnuPracticeRepo.git
cd TestNGScrach
```

### 2. Import into Eclipse
- **File → Import → Existing Maven Project**
- Browse to the cloned folder → **Finish**
- Maven will auto-download all dependencies

### 3. Verify Dependencies
Right-click project → **Maven → Update Project** → OK

---

## ▶️ Running Tests

### From Eclipse
- Right-click `testng.xml` → **Run As → TestNG Suite**

### From Command Line
```bash
mvn test
```

---

## 🧪 Test Suite — testng.xml

The suite runs **5 threads** and includes two test groups:

| Group        | Description              |
|--------------|--------------------------|
| `Regression.*` | All regression tests   |
| `sanity`     | Sanity / smoke tests     |

### Test Classes (in order):
1. `LogInTest` — Logs into the hospital application
2. `CreateNewAppoinmentTest` — Creates a new appointment
3. `BookAppoinmentTest` — Books the appointment
4. `LogOutTest` — Logs out of the application

---

## 📊 Test Reports

After execution, reports are generated at:

```
test-output/
├── index.html              ← TestNG default report
├── emailable-report.html   ← Shareable summary
└── extent-report.html      ← ExtentReports (rich HTML)

Screenshots/
└── *.png                   ← Screenshots captured on test failure
```

Open `index.html` or `extent-report.html` in a browser to view results.

---

## 📦 Key Dependencies (pom.xml)

```xml
<!-- Selenium -->
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.34.0</version>
</dependency>

<!-- TestNG -->
<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.7.1</version>
    <scope>test</scope>
</dependency>

<!-- ExtentReports -->
<dependency>
    <groupId>com.aventstack</groupId>
    <artifactId>extentreports</artifactId>
    <version>5.1.0</version>
</dependency>

<!-- Apache POI (Excel) -->
<dependency>
    <groupId>org.apache.poi</groupId>
    <artifactId>poi-ooxml</artifactId>
    <version>5.4.1</version>
</dependency>
```

---

## 🔄 CI/CD with Jenkins

This project is integrated with Jenkins:

1. Push code to GitHub → `git push origin main`
2. Jenkins pulls latest code automatically (via webhook) or manually (**Build Now**)
3. Jenkins runs `mvn test`
4. Test results appear in Jenkins dashboard

**Jenkins Project:** `MyApril20project`

---

## 🙈 .gitignore

The following are excluded from Git:
- `/target/` — compiled output
- `*.class`, `*.jar`, `*.log` — build artifacts
- `*.zip`, `*.war`, `*.ear` — package files

---

## 👤 Author

**Vishnu Balakrishnan**  
GitHub: [@balavishnu1994git](https://github.com/balavishnu1994git)
