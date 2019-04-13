# Group-12-Project: Bad Mario
Bad Mario is a simiplified side scrolling platformer, which closely resembles Mario but with nowhere near the budget. Our current code repository showcases the final GUI version of the game coded in Java. 

A very simple text-based version of BadMario can also be run.

# Getting Started
Download all .java files present in the master branch of our repository, extract them from the zip file downloaded. Put junit-4.12.jar and hamcrest-core-1.3.jar in this folder. Finally, compile and run BadMario.java from command line to run the the game.

The command line argument below must be used to compile the classes in the repository. 

 javac -cp .:junit-4.12.jar:hamcrest-core-1.3.jar *.java
 
In machines operating on Windows replace the colons with semi-colons.

## Prequisites 
Before running Bad Mario, an up to date version of JRE and JDK should installed on your machine. If the jfxrt library is not contained in the version of JDK installed, it should be added as an external JAR and added to the file path in the IDE being used. 

# Controls


#### Player 1


a - move left


d - move right


w/spacebar - jump up vertically


Use a combination of 'w'/spacebar and 'd' to jump up right


Use a combination of 'w'/spacebar and 'a' to jump up left


#### Player 2


j - move left


l - move right


i - jump up vertically


Use a combination of 'i' and 'l' to jump up right


Use a combination of 'i' and 'j' to jump up left


#### Text-Based Version

a - move left

d - move right

w - jump up vertically

q - jump up and to the left

e - jump up and to the right

Type in the selection and hit "enter" to move the character 'm', representing Mario. This version is single-player.


# Running Automated Tests

Junit version 4.12 hamcrest core 1.3 are used for automated testing in Bad Mario. Use the command below to run the Test Classes provided in the Repository.

    java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore <Test Class>

In machines operating on Windows replace the colons with semi-colons.


Also note that "Test Class" should be replaced with the name of one of the test classes provided in the repository. For example; java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore BlockTest 


If running tests are not necessary for the user; simply run the code below after compiling the files. 
     
    java BadMario 

# Authors
- Yifan Chen
- Grace Heemeryck
- Sage Magsila
- Benjamin Messer
- Lauren Perera
- Dylan Wheeler
