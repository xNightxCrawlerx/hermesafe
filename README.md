# Tittle: HermeSafe

Hermesafe is a Java Maven project developed with Test Driven Development (TDD).  
All domain classes are written in English and fully tested with JUnit 5, Mockito, and JaCoCo.

---

## Milestone 1: Domain Classes and Coverage

- **RateCalculator**: Calculates shipping rates based on weight and rural surcharge.
- **InventoryManager**: Manages stock and validates operations.
- **PostalCodeValidator**: Validates postal code formats.
- **RouteOptimizer**: Determines coverage and sorts warehouses by distance.

✅ All classes are fully tested.  
✅ JaCoCo report shows **100% coverage**.

Evidence:  
![Coverage Report](docs/coverage-report.png)

---

## Milestone 2: Test Doubles with Mockito

To simulate external dependencies, I introduced **InventoryRepository** and **OrderService**:

- **InventoryRepository**: Interface representing stock operations.
- **OrderService**: Service that processes orders using the repository.

 ## Project Structure

 Hermesafe/
 ├── pom.xml
 ├── README.md
 ├── docs/
 │   └── coverage-report.png        # Evidence of JaCoCo coverage
 └── src/
     ├── main/
     │   └── java/com/hermesafe/domain/
     │       ├── RateCalculator.java
     │       ├── InventoryManager.java
     │       ├── PostalCodeValidator.java
     │       ├── RouteOptimizer.java
     │       ├── InventoryRepository.java   # Interface for repository
     │       └── OrderService.java          # Service using repository
     └── test/
         └── java/com/hermesafe/domain/
             ├── RateCalculatorTest.java
             ├── InventoryManagerTest.java
             ├── PostalCodeValidatorTest.java
             ├── RouteOptimizerTest.java
             └── OrderServiceTest.java      # Tests with Mockito
