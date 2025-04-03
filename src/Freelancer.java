public class Freelancer extends Person {

    private double hoursWorked;
    private double hourlyRate;
    private String position;

    public Freelancer() {
        super();
    }

    public Freelancer(String name, String email, int age, String position, double hoursWorked, double hourlyRate) {
        super(name, email, age);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
        this.position = position;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }

    @Override
    public String getPosition() {
        return position;
    }

    @Override
    public void showProfile() {
        super.showProfile();
        System.out.println(" | Hours Worked: " + hoursWorked + 
                           " | Hourly Rate: $" + hourlyRate + 
                           " | Total: $" + calculateSalary());
    }

    @Override
    public String toTextLine() {
        return "Freelancer;" + getName() + ";" + getEmail() + ";" + getAge() + ";" + getPosition() + ";" + hoursWorked + ";" + hourlyRate;
    }
}
