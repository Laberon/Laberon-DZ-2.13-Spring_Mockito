package LaberonLSDZ2.service;

import LaberonLSDZ2.domain.Employee;
import LaberonLSDZ2.exception.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final int LIMIT = 10;
    private final Map<String, Employee> employeeMap = new HashMap<>();

    private String getKey(String firstName, String lastname) {
        return firstName + "|" + lastname;
    }

    @Override
    public Employee addPerson(String firstName, String lastName, int salary, int department) {
        Employee employee = new Employee(
                validateName(firstName),
                validateName(lastName),
                salary, department);
        if (employeeMap.containsKey(getKey(firstName,lastName))) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employeeMap.size() < LIMIT) {
            employeeMap.put(getKey(firstName,lastName), employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException();
    }

    @Override
    public Employee findPersons(String firstName, String lastName) {
        if (!employeeMap.containsKey(getKey(firstName,lastName))) {
            throw new EmployeeNotFoundException();
        }
        return employeeMap.get(getKey(firstName,lastName));
    }

    @Override
    public Employee removePerson(String firstName, String lastName) {
        if (!employeeMap.containsKey(getKey(firstName,lastName))) {
            throw new EmployeeNotFoundException();
        }
        return employeeMap.remove(getKey(firstName,lastName));
    }

    @Override
    public Collection<Employee> getAll() {
        return Collections.unmodifiableCollection(employeeMap.values());
    }

    public String validateName(String firstName) {
        if (StringUtils.isAlpha(firstName)) {
            return StringUtils.capitalize(firstName.toLowerCase());
        }
        throw new IncorrectFirstNameException();
    }
}