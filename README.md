# JP Morgan Job Simulation
## Background Information
Your team has been tasked with building the Midas system, a high-profile initiative responsible for processing financial transactions at scale. Completing this project successfully would be a major achievement for your engineering career.

In this program, you will focus on Midas Core — the service responsible for receiving, validating, and recording financial transactions. Midas Core relies on several external systems:

Kafka to receive new transactions
A SQL database to validate and store data
A REST API to expose processed information
A teammate has already created a basic project scaffold following the system architecture. While some initial classes exist, much of the implementation is left to you. The project uses Spring Boot, which provides a powerful dependency injection framework and simplifies connecting to external infrastructure.
## Task 1 
- Set up your local development environment by installing Java 17, forking and cloning the project repository, and opening it in your IDE.
- Explore the existing project scaffold to understand how the Midas Core service is structured.
- Add the required dependencies to your Spring Boot project and update configuration files.
- Build and run the project, then verify your setup by running automated tests.

## Task 2 
- Implement a Kafka listener in Midas Core that reads from the topic defined in application.yml and deserializes each incoming message into the provided Transaction class.
- Configure your listener to use the project’s existing Spring Boot setup—no need to specify host/port, as the tests use an embedded Kafka instance.
- Run TaskTwoTests, use your debugger to inspect the first four received transactions, and record the amounts attached to each.
- Submit the list of the four transaction amounts once your listener is working correctly.

## Task 3 
- Configure Midas Core to use an H2 in-memory database through Spring Boot and JPA.
- Implement validation logic to determine whether a transaction is valid based on user IDs and account balances.
- Create a TransactionRecord JPA entity and persist valid transactions while discarding invalid ones.
- Update the sender and recipient balances when transactions are successfully processed.
- Run TaskThreeTests, inspect the final balance of the waldorf user in your debugger, and submit the rounded-down value.