public class Manager extends Person {

    private double salary;
    private double bonus;
    private String position;

    public Manager() {
        super();
    }

    public Manager(String name, String email, int age, String position, double salary, double bonus) {
        super(name, email, age);
        this.salary = salary;
        this.bonus = bonus;
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public double calculateSalary() {
        return salary + bonus;
    }

    @Override
    public String getPosition() {
        return position;
    }

    @Override
    public void showProfile() {
        super.showProfile();
        System.out.println(" | Base Salary: $" + salary + 
                           " | Bonus: $" + bonus + 
                           " | Total: $" + calculateSalary());
    }

    @Override
    public String toTextLine() {
        return "Manager;" + getName() + ";" + getEmail() + ";" + getAge() + ";" + getPosition() + ";" + salary + ";" + bonus;
    }
}
