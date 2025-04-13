# Module-05---Assignment

# JavaFX + MySQL User Management GUI

This is a Java desktop application built with **JavaFX** and **MySQL** that allows users to interact with a database via a graphical interface. The app supports operations such as inserting, querying, and displaying user data, along with an admin-friendly layout and basic user image support.

## 📦 Features

- Connect to a MySQL database
- Insert new user records
- Query users by name
- Display all users in a table view
- Upload and show user profile images
- View switching between Primary and Secondary screens

## 🧰 Technologies Used

- Java 17+
- JavaFX (FXML, Controls, SceneBuilder)
- MySQL (Remote/Azure setup)
- JDBC
- CSS styling for JavaFX UI

## 🗃️ Database Schema

The `users` table is created automatically if it does not exist:

```sql
CREATE TABLE IF NOT EXISTS users (
    id INT(10) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(200) NOT NULL,
    email VARCHAR(200) NOT NULL UNIQUE,
    phone VARCHAR(200),
    address VARCHAR(200),
    password VARCHAR(200) NOT NULL
);
