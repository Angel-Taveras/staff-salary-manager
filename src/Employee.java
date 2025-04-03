public class Employee extends Person {

    private double salary;
    private String position;

    public Employee() {
        super();
    }

    public Employee(String name, String email, int age, String position, double salary) {
        super(name, email, age);
        this.salary = salary;
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public double calculateSalary() {
        return salary;
    }

    @Override
    public String getPosition() {
        return position;
    }

    @Override
    public void showProfile() {
        super.showProfile();
        System.out.println(" | Salary: $" + salary);
    }

    @Override
    public String toTextLine() {
        return "Employee;" + getName() + ";" + getEmail() + ";" + getAge() + ";" + getPosition() + ";" + salary;
    }
}
