import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        int personType = 0;

        do {
            System.out.println("========== MENU ==========\n");
            System.out.println("1. Add Person");
            System.out.println("2. View List of People");
            System.out.println("3. Search Person by Email");
            System.out.println("4. Delete Person by Email");
            System.out.println("5. Show Salary Summary");
            System.out.println("6. Exit Program");

            while (true) {
                try {
                    System.out.print("Select an option: ");
                    option = scanner.nextInt();
                    scanner.nextLine();
                    if (option >= 1 && option <= 6) break;
                    else System.out.println("Please choose a number between 1 and 6.");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. You must enter a number.");
                }
            }

            switch (option) {
                case 1:
                    try {
                        BufferedWriter writer = new BufferedWriter(new FileWriter("EmployeeRegister.txt", true));
                        System.out.println("What type of person do you want to add?");
                        System.out.println("1. Employee");
                        System.out.println("2. Freelancer");
                        System.out.println("3. Manager");
                        personType = scanner.nextInt();
                        scanner.nextLine();

                        switch (personType) {
                            case 1:
                                Employee emp = new Employee();
                                System.out.println("Enter the person's name:");
                                emp.setName(scanner.nextLine());
                                System.out.println("Enter the person's email:");
                                String email = scanner.nextLine();
                                boolean exists = checkEmailExists(email);

                                if (exists) {
                                    System.out.println("⚠️ This email is already registered.");
                                    break;
                                } else {
                                    emp.setEmail(email);
                                }

                                emp.setPosition("Employee");
                                System.out.println("Enter the person's age:");
                                emp.setAge(scanner.nextInt());
                                System.out.println("Enter the person's salary:");
                                emp.setSalary(scanner.nextDouble());
                                scanner.nextLine();

                                writer.write(emp.toTextLine());
                                writer.newLine();
                                writer.close();
                                System.out.println("✅ Person saved successfully.");
                                break;

                            case 2:
                                Freelancer free = new Freelancer();
                                System.out.println("Enter the person's name:");
                                free.setName(scanner.nextLine());
                                System.out.println("Enter the person's email:");
                                String emailFree = scanner.nextLine();
                                if (checkEmailExists(emailFree)) {
                                    System.out.println("⚠️ This email is already registered.");
                                    break;
                                } else {
                                    free.setEmail(emailFree);
                                }

                                free.setPosition("Freelancer");
                                System.out.println("Enter the person's age:");
                                free.setAge(scanner.nextInt());
                                System.out.println("Enter hours worked:");
                                free.setHoursWorked(scanner.nextDouble());
                                System.out.println("Enter pay per hour:");
                                free.setHourlyRate(scanner.nextDouble());
                                scanner.nextLine();

                                writer.write(free.toTextLine());
                                writer.newLine();
                                writer.close();
                                System.out.println("✅ Person saved successfully.");
                                break;

                            case 3:
                                Manager mgr = new Manager();
                                System.out.println("Enter the person's name:");
                                mgr.setName(scanner.nextLine());
                                System.out.println("Enter the person's email:");
                                String emailMgr = scanner.nextLine();
                                if (checkEmailExists(emailMgr)) {
                                    System.out.println("⚠️ This email is already registered.");
                                    break;
                                } else {
                                    mgr.setEmail(emailMgr);
                                }

                                mgr.setPosition("Manager");
                                System.out.println("Enter the person's age:");
                                mgr.setAge(scanner.nextInt());
                                System.out.println("Enter the base salary:");
                                mgr.setSalary(scanner.nextDouble());
                                System.out.println("Enter the bonus:");
                                mgr.setBonus(scanner.nextDouble());
                                scanner.nextLine();

                                writer.write(mgr.toTextLine());
                                writer.newLine();
                                writer.close();
                                System.out.println("✅ Person saved successfully.");
                                break;

                            default:
                                System.out.println("Invalid person type.");
                                break;
                        }

                    } catch (IOException e) {
                        System.out.println("Error creating or writing to file: " + e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader("EmployeeRegister.txt"));
                        String line;
                        while ((line = reader.readLine()) != null) {
                            Person p = Person.fromTextLine(line);
                            if (p != null) {
                                System.out.println("-------------------------");
                                p.showProfile();
                                System.out.println("-------------------------");
                            } else {
                                System.out.println("⚠️ Malformed or unknown type of line");
                            }
                        }
                        reader.close();
                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader("EmployeeRegister.txt"));
                        String line;
                        boolean found = false;
                        System.out.println("Enter the email to search:");
                        String searchEmail = scanner.nextLine();
                        while ((line = reader.readLine()) != null) {
                            Person p = Person.fromTextLine(line);
                            if (p != null && p.getEmail().equalsIgnoreCase(searchEmail)) {
                                p.showProfile();
                                found = true;
                                break;
                            }
                        }
                        reader.close();
                        if (!found) System.out.println("❌ No person found with that email.");
                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader("EmployeeRegister.txt"));
                        String line;
                        ArrayList<Person> people = new ArrayList<>();
                        System.out.println("Enter the email to delete:");
                        String emailToDelete = scanner.nextLine();
                        boolean found = false;

                        while ((line = reader.readLine()) != null) {
                            Person p = Person.fromTextLine(line);
                            if (p != null && !p.getEmail().equalsIgnoreCase(emailToDelete)) {
                                people.add(p);
                            } else if (p != null) {
                                found = true;
                            }
                        }
                        reader.close();

                        if (found) {
                            BufferedWriter writer = new BufferedWriter(new FileWriter("EmployeeRegister.txt", false));
                            for (Person p : people) {
                                writer.write(p.toTextLine());
                                writer.newLine();
                            }
                            writer.close();
                            System.out.println("✅ Person deleted successfully.");
                        } else {
                            System.out.println("❌ No person found with that email.");
                        }

                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 5:
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader("EmployeeRegister.txt"));
                        String line;
                        double total = 0;

                        while ((line = reader.readLine()) != null) {
                            Person p = Person.fromTextLine(line);
                            if (p != null) total += p.calculateSalary();
                        }

                        reader.close();
                        System.out.println("💰 Total payroll amount: $" + total);

                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 6:
                    System.out.println("Closing program...");
                    break;
            }

        } while (option != 6);

        System.out.println("Thanks for using the system!");
        scanner.close();
    }

    // Helper method to avoid email duplication
    public static boolean checkEmailExists(String email) {
        try (BufferedReader reader = new BufferedReader(new FileReader("EmployeeRegister.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Person p = Person.fromTextLine(line);
                if (p != null && p.getEmail().equalsIgnoreCase(email)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("⚠️ Error checking email: " + e.getMessage());
        }
        return false;
    }
}
