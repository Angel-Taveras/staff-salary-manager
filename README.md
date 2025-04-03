# staff-salary-manager
Java-based employee management system using OOP principles like inheritance, polymorphism, and abstract classes. Includes file I/O for saving and retrieving employee data (employees, freelancers, and managers). Designed as a learning project.


# Employee Management System 🧑‍💼📂

This is a **Java-based Employee Management System** built using core Object-Oriented Programming (OOP) concepts such as **inheritance**, **polymorphism**, and **abstract classes**. The system supports multiple types of workers—**Employees**, **Freelancers**, and **Managers**—and handles operations such as:

- Adding new records 👤
- Viewing all people registered 📋
- Searching by email 🔍
- Deleting by email 🗑️
- Calculating total payroll 💰

All data is persisted in a text file using **Java File I/O**, enabling record management across sessions.

---

## 💡 Features

- Supports 3 roles: `Employee`, `Freelancer`, `Manager`
- Uses abstract class `Person` as a common parent
- Demonstrates real-world use of polymorphism and file handling
- Menu-driven CLI interface for user interaction
- Prevents duplicate email entries
- Stores data persistently using `.txt` files

---

## 🛠️ Technologies Used

- Java 17+
- OOP Principles (Abstract Classes, Inheritance, Polymorphism)
- File I/O (`BufferedWriter`, `BufferedReader`)
- Java Collections (`ArrayList`)

---

## 🧪 How to Use

1. Clone the repository
2. Open the project in your favorite Java IDE
3. Run `Main.java`
4. Use the menu to interact with the system

---

## 📂 File Structure

├── src/ │ ├── Main.java │ ├── Person.java (abstract) │ ├── Employee.java │ ├── Freelancer.java │ ├── Manager.java ├── RegistroEmpleado.txt (auto-generated)


---

## 🤓 Author

Built with ❤️ by [Angel Taveras] as part of a personal Java learning journey.  
Feel free to use, learn, and contribute!



