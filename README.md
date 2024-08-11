# JavaToPython

This project is a tool designed to translate simple, syntactically valid Java code into Python. It recognizes basic Java constructs such as classes, the main function, and print statements (System.out.println).

## Project Structure

- **src**: Contains the Java source code for the translation tool.
- **test**: (optional) Contains test cases to verify the translation functionality.

## Installation

1. Clone the repository
```bash
git clone https://github.com/angela924/JavaToPython.git
```
2. Navigate to the project
```bash
cd path/to/JavaToPython
```
3. Compile JavaToPython and Test
```bash
javac -d out src/main/JavaToPython.java
javac -d out -cp out src/test/Test.java
```

## Usage

1. Navigate to main
```bash
cd src/main
```
2. Store the Java code in the file named "code"
3. Navigate back to JavaToPython and run the application
```bash
cd ../..
java -cp out main.JavaToPython
```
