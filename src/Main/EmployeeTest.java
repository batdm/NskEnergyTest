package Main;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class EmployeeTest {

    private Employee e1;
    private Employee e2;
    private Employee e3;
    private Employee e4;

    private Employee e_fail1;
    private Employee e_fail2;

    @Before
    public void setUp() throws Exception {
        e1 = new Employee("Дмитрий", 25, "Dev");
        e2 = new Employee("Стас", 33, "QA");
        e3 = new Employee("Марина", 20, "Dev");
        e4 = new Employee("Евгений", 30, "Team lead");

        e_fail1 = new Employee("", 0, "");
        e_fail2 = new Employee(null, 0, null);
    }

    @Test
    public void getAllEmployees() {
        List<Employee> expected = Employee.getAllEmployees();
        List<Employee> actual = new ArrayList<>();
        actual.add(e1);
        actual.add(e2);
        actual.add(e3);
        actual.add(e4);
//        actual.add(e_fail1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllEmployees_Dev() {
        List<Employee> expected = Employee.getAllEmployees("Dev");
        List<Employee> actual = new ArrayList<>();
        actual.add(e1);
        actual.add(e3);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getHowManyEmployees() {
        int expected = Employee.getHowManyEmployees();
        int actual = 4;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getHowManyEmployees_QA() {
        int expected = Employee.getHowManyEmployees("QA");
        int actual = 1;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void newEmployee_uncorrect_age() {
        for (Employee e : Employee.getAllEmployees()) {
            if (e.getAge() <= 0) {
                Assert.fail("Попытка создания сотрудника с не корректным возрастом");
            }
        }
    }

    @Test
    public void newEmployee_null_position() {
        for (Employee e : Employee.getAllEmployees()) {
            if (e.getPosition() == null) {
                Assert.fail("Попытка создания сотрудника с должностью = null");
            }
        }
    }
}