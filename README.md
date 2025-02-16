# dbone-core

DBOne-Core is a powerful and flexible Java-based library designed to simplify database connectivity for developers. It abstracts the complexity of JDBC connections, ensuring secure, optimized, and high-performance interactions with relational databases.

---

## 🚀 Features

- **Simplified Database Connectivity**: Abstracts the complexity of loading drivers, constructing URLs, and managing connections.
- **Multi-Database Support**: Works with MySQL and PostgreSQL, with future extensibility for additional databases.
- **Secure Credential Handling**: Uses AES encryption to protect sensitive credentials.
- **Optimized Query Execution**: Uses prepared statements for safety & performance.
- **Built-in Caching & Logging**: Reduces redundant queries and improves debugging with robust logging.
- **Maven-Ready JAR**: Easily integrated via Maven or Gradle in any Java project.

---
## 📂 Project Structure
```xml
/dbone-core
        │── LICENSE
        │── README.md
        │── pom.xml
        │── src/
        │   ├── main/
        │   │   ├── java/com/acender/dbone/
        │   │   │   ├── core/
        │   │   │   │   ├── connection/    # Manages database connectivity
        │   │   │   │   ├── security/      # Secure credential handling (encryption, decryption)
        │   │   │   │   ├── utils/         # Utility classes (logging, helpers, validation)
        │   │   │   │   ├── exceptions/    # Custom exception handling
        │   │   │   │   ├── cache/         # Caching mechanism for query optimization
        │   │   │   ├── model/             # ORM Models (if applicable)
        │   │   ├── resources/
        │   │   │   ├── log4j2.xml         # Logging configuration
        │   ├── test/
        │   │   ├── java/com/acender/dbone/
        │   │   │   ├── core/
        │   │   │   │   ├── connection/    # Tests for database connections
        │   │   │   │   ├── utils/         # Tests for utilities
        │   │   │   │   ├── security/      # Tests for security features
        │   │   │   │   ├── exceptions/    # Tests for exception handling
        │   │   │   │   ├── cache/         # Tests for caching
        │   │   ├── resources/             # Test resources (mock data, configurations)
```
---
## 🛠 Installation
### Maven
To use **DBOne-Core** in your project, add the following dependency to your `pom.xml`:
```xml
<dependency>
    <groupId>io.github.srujith2k</groupId>
    <artifactId>dbone-core</artifactId>
    <version>1.0.0</version>
</dependency>
```
## 📖 Usage
### 1. Establishing a Connection
```xml
import com.acender.dbone.core.connection.DBConnection;
import com.acender.dbone.core.connection.DBConnectionFactory;
DBConnection connection = DBConnectionFactory.getConnection(
    "mysql", "localhost", "3306", "testdb", "root", "encrypted_password"
);
connection.connect();
System.out.println("Connected to the database!");
```
### 2. Executing a Query
```xml
import com.acender.dbone.core.utils.QueryExecutor;
import java.sql.ResultSet;
String query = "SELECT * FROM users WHERE id = ?";
try (ResultSet resultSet = QueryExecutor.executeQuery(connection, query, 5)) {
    while (resultSet.next()) {
        System.out.println("User: " + resultSet.getString("username"));
    }
}
```
### 3. Executing an Update Query (INSERT, UPDATE, DELETE)
```xml
String updateQuery = "UPDATE users SET active = 1 WHERE id = ?";
int rowsAffected = QueryExecutor.executeUpdate(connection, updateQuery, 5);
System.out.println("Rows Updated: " + rowsAffected);
```
### 4. Closing the Connection
```xml
connection.disconnect();
System.out.println("Connection closed.");
```
## 🔒 Security: Password Encryption
- Passwords are encrypted using AES-256 before storage.
- Decryption occurs inside the connection classes before connecting to the database.
- Developers should store credentials as encrypted values.
### Storing an Encrypted Password
```xml
import com.acender.dbone.core.security.EncryptionUtils;
String encryptedPassword = EncryptionUtils.encrypt("mySecretPass123");
System.out.println("Encrypted Password: " + encryptedPassword);
```
### Environment Variable Support for Encryption Key
On Linux/Mac:
```xml
export DB_ENCRYPTION_KEY="MySuperSecureKey!"
```
On Windows (PowerShell):
```xml
$env:DB_ENCRYPTION_KEY="MySuperSecureKey!"
```
## 📝 Logging
DBOne-Core uses Log4j2 for logging. Configure your logging settings in the log4j2.xml file located in the ```xml src/main/resources/```directory:
```xml
<Configuration>
    <Appenders>
        <Console name="Console" target="SYSTEM_OUT">
            <PatternLayout pattern="%d{yyyy-MM-dd HH:mm:ss} [%t] %-5level %c{1} - %msg%n"/>
        </Console>
    </Appenders>
    <Loggers>
        <Root level="info">
            <AppenderRef ref="Console"/>
        </Root>
    </Loggers>
</Configuration>
```
## 📚 Example Project
Want a fully working example? Check out our dbone-example project!
**Clone and test it locally**:
```xml
git clone https://github.com/Srujith2k/dbone-example.git
cd dbone-example
mvn clean install
```
## 🛠 Contributing
Contributions are welcome! To contribute:
1. Fork the repository.
2. Create a feature branch (git checkout -b feature-xyz).
3. Commit your changes (git commit -m "Describe your changes").
4. Push your branch (git push origin feature-xyz).
5. Open a Pull Request.
## 📜 License
This project is licensed under the Apache License 2.0. See the [LICENSE](LICENSE) file for details.
## 📞 Contact
For questions, suggestions, or feedback:
- **Email**: srujith2k@gmail.com
- **GitHub Issues**: [Create an Issue](https://github.com/Srujith2k/dbone-core/issues)
