# Group-12-Project: Bad Mario
Bad Mario is a simiplified side scrolling platformer, which closely resembles Mario but with nowhere near the budget. Our current code repository showcases the final GUI version of the game coded in Java. 

# Getting Started
Download all .java files present in the master branch of our repository, extract them from the zip file downloaded and compile them from the command line. Finally, run BadMario.java from command line to run the the game.

The command line argument below must be used to compile the classes in the repository. 

 javac -cp .:junit-4.12.jar:hamcrest-core-1.3.jar *.java
 
In machines operating on Windows replace the colons with semi-colons.

## Prequisites 
Before running Bad Mario, an up to date version of JRE and JDK should installed on your machine. If the jfxrt library is not contained in the version of JDK installed, it should be added as an external JAR and added to the file path in the IDE being used. 

# Controls


#####Player 1


a - move left


d - move right


w/spacebar - jump up vertically


Use a combination of 'w'/spacebar and 'd' to jump up right


Use a combination of 'w'/spacebar and 'a' to jump up left


#####Player 2


j - move left


l - move right


i - jump up vertically


Use a combination of 'i' and 'l' to jump up right


Use a combination of 'i' and 'j' to jump up left


# Running Automated Tests
junit version 4.12 hamcrest core 1.3 are used for automated testing in Bad Mario. Tests are run in the character class which test for valid contructor parameter values and getter/setter method values.

    java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore <Test Class>

In machines operating on Windows replace the colons with semi-colons.


Also note that "<Test Class>" should be replaced with one of the test classes provided in the repository. 


If running tests are not necessary for the user; simply run the code below after compiling the files
     
    java BadMario

# Authors
- Yifan Chen
- Grace Heemeryck
- Sage Magsila
- Benjamin Messer
- Lauren Perera
- Dylan Wheeler
