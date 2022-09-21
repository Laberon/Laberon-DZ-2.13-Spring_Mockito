package LaberonLSDZ2.service;

import LaberonLSDZ2.exception.EmployeeNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static LaberonLSDZ2.EmployeeTest.*;
import static java.util.Collections.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImpTest {
    @Mock
    private EmployeeServiceImpl employeeService;

    @InjectMocks
    private DepartmentServiceImp out;

    @Test
    public void findMaxSalaryByDepartment() {
        when(employeeService.getAll()).thenReturn(EMPLOYEES);
        assertEquals(MAX_SALARY_EMPLOYEE, out.maxSalary(DEPARTMENT));
    }

    @Test
    public void throwEmployeeMaxSalaryEmptyEmployeeList() {
        when(employeeService.getAll()).thenReturn(emptyList());
        assertThrows(EmployeeNotFoundException.class,
                () -> out.maxSalary(DEPARTMENT));
    }

    @Test
    public void throwEmployeeMaxSalaryEmptyDepartment() {
        when(employeeService.getAll()).thenReturn(EMPLOYEES);
        assertThrows(EmployeeNotFoundException.class, () -> out.maxSalary(BAD_DEPARTMENT));
    }

    @Test
    public void findMinSalaryByDepartment() {
        when(employeeService.getAll()).thenReturn(EMPLOYEES);
        assertEquals(MIN_SALARY_EMPLOYEE, out.minSalary(DEPARTMENT));
    }

    @Test
    public void throwEmployeeMinSalaryEmptyEmployeeList() {
        when(employeeService.getAll()).thenReturn(emptyList());
        assertThrows(EmployeeNotFoundException.class,
                () -> out.minSalary(DEPARTMENT));
    }

    @Test
    public void throwEmployeeMinSalaryEmptyDepartment() {
        when(employeeService.getAll()).thenReturn(EMPLOYEES);
        assertThrows(EmployeeNotFoundException.class, () -> out.minSalary(BAD_DEPARTMENT));
    }

    @Test
    public void findEmployeeByDepartment() {
        when(employeeService.getAll()).thenReturn(DIFFERENT_DEPARTMENT_EMPLOYEES);
        assertEquals(DEPARTMENT_MAP, out.findEmployee());
    }

    @Test
    public void findEmployeeByDepartmentExist() {
        when(employeeService.getAll()).thenReturn(emptyList());
        assertEquals(emptyMap(), out.findEmployee());
    }

    @Test
    public void returnEmptyEmployeeByDepartment() {
        when(employeeService.getAll()).thenReturn(DIFFERENT_DEPARTMENT_EMPLOYEES);
        assertEquals(singletonList(MIN_SALARY_EMPLOYEE), out.findEmployeeByDepartment(DEPARTMENT));
        assertEquals(singletonList(DIFFERENT_DEPARTMENT_EMPLOYEE),out.findEmployeeByDepartment(BAD_DEPARTMENT));
    }

    @Test
    public void returnEmptyListEmployeeNotFound() {
        when(employeeService.getAll()).thenReturn(EMPLOYEES);
        assertEquals(emptyList(),out.findEmployeeByDepartment(BAD_DEPARTMENT));
    }
}
