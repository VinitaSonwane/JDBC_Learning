## **JDBC Learning**🚀

This README provides an overview of how to use the JDBC (Java Database Connectivity) API to connect to a SQL database using a JDBC driver. The project demonstrates the fundamental steps for setting up a JDBC connection and executing SQL queries. 🚀

## Getting Started

These instructions will help you get a copy of the project up and running on your local machine for development and testing purposes. 🛠️

### Prerequisites

Make sure you have the following installed:

- Java Development Kit (JDK) 1.8 or higher ☕
- Integrated Development Environment (IDE) like Eclipse, IntelliJ IDEA, or a similar one 💻
- SQL database (e.g., MySQL, PostgreSQL, Oracle) installed or accessible 🗃️
- Corresponding JDBC driver for your SQL database 🚗

### Installing JDBC Driver

You need to download and add the JDBC driver for your database to your project's classpath. For example, if you are using MySQL:

1. Download the MySQL Connector/J from the [MySQL website](https://dev.mysql.com/downloads/connector/j/).
2. Add the JAR file to your project's build path.
   - In Eclipse: Right-click on the project → Build Path → Configure Build Path → Libraries → Add External JARs.
   - In IntelliJ IDEA: File → Project Structure → Libraries → + → Java → select the downloaded JAR file. 📥

### Setting Up the Database

Ensure your SQL database is running and accessible. You might need to:

- Start your SQL server (e.g., MySQL, PostgreSQL)
- Create a database/schema
- Create a user with access permissions to that database 🏗️

## Connecting to the Database

Here's a basic template to establish a connection to your SQL database using JDBC:

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main{
    public static void main(String[] agrs ){
        //Database URL
        String url = "jdbc:mysql://localhost:3306/Students";

        //Database credentials
        String username = "root";
        String password = "Vinita@123";

        //Establish the connection
        try(Connection connection = DriverManager.getConnection(url,username , password)){
            System.out.println("Connected to the database ");
            System.out.println(connection);
        }
        catch(SQLException e ){
          System.err.println("connection failed : " + e.getMessage());
        }
    }
}
