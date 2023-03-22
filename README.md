# README

### Practical task overview:
_Izmantojot programmēšanas valodu Java, izveido angļu alfabēta burtu frekvences vārdnīcu.
Analīzei izvēlies tekstu vismaz 1000 zīmju garumā. Risinājumā jābūt iekļautam analizētajam tekstam TXT
formātā, automatizētam testam un izpildes instrukcijai.
Uzdevuma izpildes variantu lūdzu iesniegt izmantojot https://github.com_

### Text files:
The project contains three text files. The files are located under **src/main/resources**.
Each text file contains a different character amount:
- _**text_0.txt**_ -> 1000 chars;
- _**text_1.txt**_ -> 1200 chars;
- _**text_2.txt**_ -> 1400 chars;

_All text was generated using **Blind Text Generator** tool_
[here](https://www.blindtextgenerator.com/lorem-ipsum).

### Overview

During testing, we will use all three files but for build we will only use **text_0.txt**.

### Run the project
#### Command Line
1. Move to root of the project
2. Open the terminal
3. Run: **mvn compile**
4. Run: **mvn exec:java -Dexec.mainClass=Main**

- Run the app with a file from the provided in **resources** (default: 0):
  - **mvn exec:java -Dexec.mainClass=Main -Dexec.args=<file_index (0,1,2)>**

- Run the app with a custom file from system (NEED TO SPECIFY ABSOLUTE PATH):
    - **mvn exec:java -Dexec.mainClass=Main -Dexec.args=<path_to_file>**.txt

Or run the packaged version:
1. Move to root of the project
2. Open the terminal
3. Run: **java -jar target/practical-1.0.jar**

#### IntelliJ IDEA
1. Move to root of the project
2. Open Main.java under **src/main/java**
3. Click the run button (IntelliJ IDEA top right corner)

#### Eclipse
1. Select the project
2. Right click it
3. Navigate "_Run As > Java Application_"


### Testing
1. Command Line: In root of project run: _mvn test_
2. Eclipse:
   1. Right click on **src/test/java**
   2. Select **Run as => JUint Test**
3. IntelliJ IDEA:
    1. Right click on **src/test/java**
    2. Select **Run "All tests"**


#### Marcis Andersons
##### Github Nr1: https://github.com/NamedUnknown
##### Github Nr2: https://github.com/Marchel0925
