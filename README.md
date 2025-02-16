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

## Vision

DBOne is a Java-based library designed to provide a seamless connection to multiple databases (e.g., MySQL, PostgreSQL, MSSQL) without the need for developers to manually load drivers, construct URLs, or configure connections.

## Scope

### Core Features:
- **Database Connectivity**: Simplify connections to MySQL, PostgreSQL, MSSQL.
- **Dynamic URL Generation**: Automatically generate database URLs from configuration.
- **Security**: Encrypt and handle database passwords securely.
- **Logging**: Provide logging for database connections and queries.
- **Caching**: Cache frequent queries and their results.
- **Extensibility**: Easily extendable to add support for additional databases or reporting tools.

### Users:
DBOne is aimed at developers who want to simplify database integration and reduce repetitive boilerplate code.
