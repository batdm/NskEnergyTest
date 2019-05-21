package Main;

import java.util.*;

public class Employee {
    private int id;
    private String name;
    private int age;
    private boolean is_work;
    private String department;
    private String position;

    private static Map<Integer, Employee> allEmployees = new HashMap<>();
    private static int countId = 0;
    private String[] positionArr = {"Dev", "QA", "Team lead"};


    Employee(String name, int age, String position) {
        this.name = name;
        this.age = age;
        this.position = position;

        if (!hasEmployee() && isPositionExist(position)) {
            countId++;
            this.id = countId;
            allEmployees.put(id, this);
        }
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public String getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }


    private boolean hasEmployee() {
        for (Employee e : allEmployees.values()) {
            if (e.equals(this) && e.hashCode() == this.hashCode()) {
                return true;
            }
        }
        return false;
    }

    public boolean isPositionExist(String p) {
        for (String s : positionArr) {
            if (s == p) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee e = (Employee) o;
        return age == e.age
                && Objects.equals(name, e.name)
                && position == e.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, position);
    }

    @Override
    public String toString() {
        return "Employee{"
                + " id=" + id
                + ", name='" + name
                + "', age=" + age
                + ", position='" + position
                + "'}";
    }

    public static List<Employee> getAllEmployees() {
        return new ArrayList<>(allEmployees.values());
    }

    public static List<Employee> getAllEmployees(String position) {
        List<Employee> listAllEmployees = new ArrayList<>();
        for (Employee e : allEmployees.values()) {
            if (e.position == position) {
                listAllEmployees.add(e);
            }
        }
        return listAllEmployees;
    }

    public static int getHowManyEmployees() {
        return allEmployees.size();
    }

    public static int getHowManyEmployees(String position) {
        return getAllEmployees(position).size();
    }

    public static void main(String[] args) {
        new Employee("Дмитрий", 25, "Dev");
        new Employee("Стас", 33, "QA");
        new Employee("Марина", 20, "Dev");
        new Employee("Евгений", 30, "Team lead");
        new Employee("", 0, "");
//        new Employee("Евгений", 30, "Team");
        System.out.println("Все сотрудники");
        Employee.getAllEmployees().forEach(System.out::println);
    }
}
