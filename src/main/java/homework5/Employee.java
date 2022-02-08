package homework5;

public class Employee {
    //    1. Создать класс "Сотрудник" с полями: ФИО, должность, email телефон, зарплата, возраст.
    private final String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    //2. Конструктор класса должен заполнять эти поля при создании объекта.
    public Employee(String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
    public void printInfo() {
        System.out.printf("name: %s, position: %s, email: %s, phone: %s, salary: %d, age: %d%n", name, position, email, phone, salary, age);
    }

    public static void main(String[] args) {
        //4. Создать массив из 5 сотрудников.
        Employee[] employees = {new Employee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30),
                new Employee("Andreev Andrey", "manager", "andr@mail.ru", "8111111111", 50000, 28),
                new Employee("Marinina Marina", "director", "cool@bk.ru", "81234567890", 100000, 46),
                new Employee("Vasilev Vasiliy", "driver", "vasvas@gmail.com", "88889991122", 20000, 52),
                new Employee("Mishin Mikhail", "designer", "miha@inbox.ru", "82022020707", 40000, 41)};

        //5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
        for (Employee employee : employees) {
            if (employee.getAge() > 40) {
                employee.printInfo();
            }
        }
    }
}