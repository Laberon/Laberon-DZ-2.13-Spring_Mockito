package LaberonLSDZ2;

import LaberonLSDZ2.domain.Employee;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.groupingBy;

public class EmployeeTest {
    public static final String FIRSTNAME = "Tod";
    public static final String FIRSTNAME2 = "Cod";
    public static final String LASTNAME = "Fod";
    public static final String LASTNAME2 = "Pod";
    public static final int SALARY = 1000;
    public static final int MINSALARY = 100;
    public static final int DEPARTMENT = 1;
    public static final int BAD_DEPARTMENT = 2;
    public static final String key = FIRSTNAME + LASTNAME;
    public static final String key2 = FIRSTNAME2 + LASTNAME2;
    public static final Employee MIN_SALARY_EMPLOYEE = new Employee(FIRSTNAME, LASTNAME, MINSALARY, DEPARTMENT);
    public static final Employee MAX_SALARY_EMPLOYEE = new Employee(FIRSTNAME2, LASTNAME2, SALARY, DEPARTMENT);
    public static final Set<Employee> EMPLOYEES = Set.of(MIN_SALARY_EMPLOYEE, MAX_SALARY_EMPLOYEE);
    public static final Employee DIFFERENT_DEPARTMENT_EMPLOYEE = new Employee(FIRSTNAME2, LASTNAME2, SALARY, BAD_DEPARTMENT);
    public static final Set<Employee> DIFFERENT_DEPARTMENT_EMPLOYEES = Set.of(MIN_SALARY_EMPLOYEE, DIFFERENT_DEPARTMENT_EMPLOYEE);
    public static final Map<Integer, List<Employee>> DEPARTMENT_MAP = DIFFERENT_DEPARTMENT_EMPLOYEES.stream()
            .collect(groupingBy(Employee::getDepartment));
}
