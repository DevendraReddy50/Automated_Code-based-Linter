# Automated Java Linter (JavaParser + MongoDB)

This project is a fully automated **Java Linter** that scans `.java` files, detects issues 
(such as unused imports), and stores the results into **MongoDB**.

---

## 🚀 Features

✔ Scan any folder for Java source files  
✔ Detect unused imports (Rule 1)  
✔ Extensible design – you can add more rules easily  
✔ Save lint results to MongoDB  
✔ Clean, modular Java structure  
✔ Works from command line  

---

## 📂 Project Structure

AutomatedLinter/
│
├── src/
│   ├── Finding.java
│   ├── ImportRuleChecker.java
│   ├── LinterEngine.java
│   ├── MongoDBWriter.java
│   └── AutomatedLinter.java
│
└── README.md

---

## 📦 Requirements

1. **Java 11+**
2. **MongoDB Community Server running locally**
3. External JARs:
   - JavaParser  
   - MongoDB Java Driver  

### Download Dependencies

#### JavaParser  
https://repo1.maven.org/maven2/com/github/javaparser/javaparser-core/3.25.4/

#### MongoDB Driver  
https://repo1.maven.org/maven2/org/mongodb/mongodb-driver-sync/

---

## 🛠 How to Compile

Open terminal in project folder:
  javac -cp ".;libs/" src/.java



---

## 🧩 Extending Rules

To add more rules:

1. Create a new file in `src/`
2. Write a method returning `List<Finding>`
3. Call it in `LinterEngine`

---

## 🎯 Future Enhancements

- Detect unused variables  
- Check for Cyclomatic Complexity  
- Enforce naming conventions  
- Detect unused private methods  

---

## 🏁 Conclusion

This project helps you build a **real linting tool** using:
- JavaParser (AST Parsing)
- MongoDB (storing results)
- Clean modular OOP design

You can use it in:
✔ College projects  
✔ Code quality tools  
✔ Hackathons  
✔ Industry-level automation  

![alt text](MongoDB.jpg>)
![alt text](<OUTPUT.jpg>)