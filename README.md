# kpr3-coding-challenge

## Find the 100 most common three word sequences in descending order.
1. First, open the Terminal and navigate to the root directory of the project, kp3-coding-challenge.
2. From here, be sure to first compile the code with the command: `javac src/main/java/Solution.java`
3. To run the application, enter the command, `java` , the path to the Solution class,`src/main/java/Solution.java`, followed by the path to the text file of your choosing. An example would look something like this:

`java src/main/java/Solution.java src/main/resources/texts/moby-dick.txt`
4. The results should be:
```
   the sperm whale - 85
   the white whale - 71
   of the whale - 67
   etc...
```
5. To run more than one file at a time, add a space and enter the path(s) to any additional file(s) you'd like to include.

`java src/main/java/Solution.java src/main/resources/texts/moby-dick.txt src/main/resources/texts/alice-in-wonderland.txt`

## JUnit testing
1. Tests can be found within the SolutionTest Class. _src/test/java/SolutionTest_ and can be performed in a similar way
2. From the command line in the Terminal, type java, space, followed by the path to the test class listed above.

`java /src/test/java/SolutionTest.java`

## Next steps
1. Still working on getting the application to work with other languages, particularly when it comes to splitting strings using spaces as the delimiter.
2. Even though tests pass with removing single quotes, I was unable to get replaceAll to ignore removing single quotes in the separateWords method.