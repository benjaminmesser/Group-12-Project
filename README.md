# Group-12-Project: Bad Mario
Bad Mario is a simiplified side scrolling platformer, which closely resembles Mario but with nowhere near the budget. Our current code repository showcases both the final GUI version of the game as well as a text-based prototype used in the earlier stages of design and implementation. The game is coded in Java. 

# Getting Started
Download all .java files present in the master branch of our repository and compile them from the command line. Finally, run JavaFxGui.java from command line to run the GUI version of the game or RunGame.java for the text-based version.

The command line argument below must be used to compile the classes in the repository. 

 javac -cp .:junit-4.12.jar:hamcrest-core-1.3.jar *.java

## Prequisites 
Before running Bad Mario, an up to date version of JRE and JDK should installed on your machine. If the jfxrt library is not contained in the version of JDK installed, it should be added as an external JAR and added to the file path in the IDE being used. 

# Controls
a - move left


d - move right


w/spacebar - jump up vertically


q - jump diagonally to the left


e - jump diagonally to the right   



# Running Automated Tests
junit version 4.12 hamcrest core 1.3 are used for automated testing in Bad Mario. Tests are run in the character class which test for valid contructor parameter values and getter/setter method values.

    java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore CharacterTest



# Authors
- Yifan Chen
- Grace Heemeryck
- Sage Magsila
- Benjamin Messer
- Lauren Perera
- Dylan Wheeler
