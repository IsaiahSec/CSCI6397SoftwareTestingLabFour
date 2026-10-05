
# CSCI 6397 Software Testing Lab Four - LibraryService

A Maven/JUnit/Mockito project implementing a test suite for the `LibraryService` class and its `checkoutResource()` method. Dependencies are mocked with Mockito and injected through `LibraryService`'s constructor. Test design uses three techniques: Equivalence Partitioning, Boundary Value Analysis, and Decision Tables. Test design is documented in the [Test Case Development](https://github.com/IsaiahSec/CSCI6397SoftwareTestingLabFour/blob/f4db5e32da8e30600f3ffb8da875eb44e7d7607f/CSCI6397SoftwareTestingLabFour%20Test%20Case%20Development%20-%20Stewart.pdf) document in the root of the repository.
## Authors

- [Tests](https://github.com/IsaiahSec/CSCI6397SoftwareTestingLabFour/tree/f4db5e32da8e30600f3ffb8da875eb44e7d7607f/src/test/java/Library): [@IsaiahSec](https://github.com/IsaiahSec)
- [Source](https://github.com/IsaiahSec/CSCI6397SoftwareTestingLabFour/tree/f4db5e32da8e30600f3ffb8da875eb44e7d7607f/src/main/java/Library): [@jbaarsch-uca](https://github.com/jbaarsch-uca)
## Prerequisites

- JDK 26
- Maven: Not required as a separate install if you're using IntelliJ IDEA, which bundles its own Maven distribution
## Installation

Clone the repository:

```bash
git clone https://github.com/IsaiahSec/CSCI6397SoftwareTestingLabFour.git
cd CSCI6397SoftwareTestingLabFour
```

Open the project in IntelliJ IDEA (or any IDE with Maven support) - it should auto-detect pom.xml and resolve dependencies automatically
## Running Tests
From the terminal (if Maven is installed and on your PATH):
```bash
mvn test
```
From IntelliJ:

- Open '[LibraryServiceTest.java](https://github.com/IsaiahSec/CSCI6397SoftwareTestingLabFour/blob/f4db5e32da8e30600f3ffb8da875eb44e7d7607f/src/test/java/Library/LibraryServiceTest.java)'
- Click the green run arrow next to the class name, or any individual '@Test' method
- Alternatively, use IntelliJ's Maven tool window and double-click the 'test' lifecycle phase
## Documentation

[CSCI6397SoftwareTestingLabFour Test Case Development - Stewart.pdf](https://github.com/IsaiahSec/CSCI6397SoftwareTestingLabFour/blob/f4db5e32da8e30600f3ffb8da875eb44e7d7607f/CSCI6397SoftwareTestingLabFour%20Test%20Case%20Development%20-%20Stewart.pdf)

All test cases correspond directly to the TCs/TCIs documented in the test development file - the test functions are named after their corresponding test case (e.g., `tc_01()`)