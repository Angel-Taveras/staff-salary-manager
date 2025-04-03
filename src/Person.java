public abstract class Person {

    private String name;
    private String email;
    private int age;

    public Person() {
    }

    public Person(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public abstract double calculateSalary();

    public abstract String getPosition();

    public void showProfile() {
        System.out.println("Name: " + name +
                " | Email: " + email +
                " | Age: " + age +
                " | Position: " + getPosition());
    }

    public String toTextLine() {
        return name + ";" + email + ";" + age;
    }

    public static Person fromTextLine(String line) {
        String[] parts = line.split(";");
        String position = parts[0];

        switch (position) {
            case "Employee":
                return new Employee(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4], Double.parseDouble(parts[5]));
            case "Freelancer":
                return new Freelancer(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4],
                        Double.parseDouble(parts[5]), Double.parseDouble(parts[6]));
            case "Manager":
                return new Manager(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4],
                        Double.parseDouble(parts[5]), Double.parseDouble(parts[6]));
            default:
                System.out.println("⚠️ Invalid line or unknown role");
                return null;
        }
    }
}
