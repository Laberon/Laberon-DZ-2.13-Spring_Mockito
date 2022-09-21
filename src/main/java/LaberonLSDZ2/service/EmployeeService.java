package LaberonLSDZ2.service;

import LaberonLSDZ2.domain.Employee;

import java.util.Collection;

public interface EmployeeService {

    Employee addPerson(String firstName, String lastName, int salary, int department);

    Employee findPersons(String firstName, String lastName);

    Employee removePerson(String firstName, String lastName);

    Collection<Employee> getAll();


}
