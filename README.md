# Soccer League Ranking

## Requirements
=====
Java 9
Maven

## Testing :
=====
From the project root folder run : ```mvn test```

## Compiling ( and Test) : 
=====
From the project root folder run : ```mvn compile package```


## Running
=====
#### Program Arguments
File
	Takes any number of file arguments. eg ````--fr ./file1.txt --fr file2.txt --fr ../file3.txt````
String
	Takes any number of string arguments, surrounded by quotations. eg ````--sr "teamA 1, teamB 2"````

### To run :
from project root folder run : ```java -jar api/target/api-1.0-jar-with-dependencies.jar --fr <path-to-file1> --fr <path-to-file2> --sr "string-result"```

#### Notes
=====
Can also be imported into an IDE (Eclipse/Sts/IntelliJ) as a maven Project.
