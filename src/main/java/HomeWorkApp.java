public class HomeWorkApp {
    public static void main(String[] args) {
        Employee[] employees;
        Employee employee1 = new Employee("Petr", "Petrov", "Petrovich",
                "qa", "test@email.ru", "+7777777777", 63890.0, 45);
        Employee employee2 = new Employee("Ivan", "Petrov", "Petrovich",
                "mobile-developer", "mobile-developer@email.ru", "+777788877777", 150000.0, 30);
        Employee employee3 = new Employee("Anna", "Ivanova", "Ivanovna",
                "support", "support@email.ru", "+77777775555", 50000.0, 32);
        Employee employee4 = new Employee("Alexandr", "Pushkin", "Sergeevich",
                "backend-developer", "backend-developer@email.ru", "+777788877756", 200000.0, 45);
        Employee employee5 = new Employee("Larisa", "Sevenova", "Alexandrovna",
                "hr", "hr@email.ru", "+77778887433", 55000.0, 25);

        employees = new Employee[]{employee1, employee2, employee3, employee4, employee5};

        for (Employee employee: employees) {
            if (employee.getAge() > 40) {
                employee.printAboutEmployee();
            }
        }
    }
}
