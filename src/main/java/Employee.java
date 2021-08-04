public class Employee {
    private String firstName;
    private String secondName;
    private String middleName;
    private String position;
    private String email;
    private String phone;
    private double salary;
    private int age;

    public Employee(String firstName, String secondName, String middleName,
                    String position, String email, String phone, double salary, int age) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        if (salary < 0) this.salary = 0;
        else this.salary = salary;

        if (age < 0) this.age = 0;
        else this.age = age;
    }

    public void printAboutEmployee() {
        System.out.println(toString());
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s, %s, %d y.o., salary - %.2f RUB.\nContact information: email - %s, phone - %s",
                secondName, firstName, middleName, position, age, salary, email, phone);
    }
}
