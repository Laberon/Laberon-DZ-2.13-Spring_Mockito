package LaberonLSDZ2.service;

import LaberonLSDZ2.domain.Employee;
import LaberonLSDZ2.exception.EmployeeAlreadyAddedException;
import LaberonLSDZ2.exception.EmployeeNotFoundException;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.*;
import static LaberonLSDZ2.EmployeeTest.*;

public class EmployeeServiceImplTest {

    private final EmployeeServiceImpl out = new EmployeeServiceImpl();

    @Test

    public void addEmployeeDontExist() {
        Employee expected = new Employee(FIRSTNAME, LASTNAME, SALARY, DEPARTMENT);
        assertEquals(0, out.getAll().size());
        assertFalse(out.getAll().contains(expected));
        Employee actual = out.addPerson(FIRSTNAME, LASTNAME, SALARY, DEPARTMENT);
        assertEquals(expected, actual);
        assertEquals(1, out.getAll().size());
        assertTrue(out.getAll().contains(expected));
    }

    @Test
    public void addThrowEmployeeExistException() {
        Employee existed = out.addPerson(FIRSTNAME, LASTNAME, SALARY, DEPARTMENT);
        assertTrue(out.getAll().contains(existed));
        assertThrows(EmployeeAlreadyAddedException.class,
                () -> out.addPerson(FIRSTNAME, LASTNAME, SALARY, DEPARTMENT));
    }

    @Test
    public void findEmployeeExist() {
        Employee existed = out.addPerson(FIRSTNAME, LASTNAME, SALARY, DEPARTMENT);
        assertEquals(existed, out.findPersons(FIRSTNAME, LASTNAME));
    }

    @Test
    public void findThrowEmployeeNotFoundException() {
        assertEquals(0, out.getAll().size());
        assertThrows(EmployeeNotFoundException.class, () -> out.findPersons(FIRSTNAME, LASTNAME));
    }

    @Test
    public void removeEmployee() {
        Employee expected = out.addPerson(FIRSTNAME, LASTNAME, SALARY, DEPARTMENT);
        assertEquals(1, out.getAll().size());
        assertTrue(out.getAll().contains(expected));
        Employee actual = out.removePerson(FIRSTNAME, LASTNAME);
        assertEquals(expected, actual);
        assertTrue(out.getAll().isEmpty());
        assertFalse(out.getAll().contains(expected));
    }

    @Test
    public void removeThrowEmployeeNotFoundException() {
        assertTrue(out.getAll().isEmpty());
        assertThrows(EmployeeNotFoundException.class, () -> out.removePerson(FIRSTNAME, LASTNAME));
    }

    @Test
    public void returnEmptyEmployee() {
        assertIterableEquals(emptyList(), out.getAll());
    }

    @Test
    public void returnEmployeeExist() {
        Employee employee1 = out.addPerson(FIRSTNAME, LASTNAME, SALARY, DEPARTMENT);
        Employee employee2 = out.addPerson(FIRSTNAME2, LASTNAME2, SALARY, DEPARTMENT);
        Collection<Employee> expected = List.of(employee1, employee2);
        Collection<Employee> actual = out.getAll();
        assertIterableEquals(expected, actual);
    }
}
