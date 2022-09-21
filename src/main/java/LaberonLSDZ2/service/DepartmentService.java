package LaberonLSDZ2.service;

import LaberonLSDZ2.domain.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

    Employee maxSalary(int department);

    Employee minSalary(int department);

    List<Employee> findEmployeeByDepartment(int department);

    Map<Integer, List<Employee>> findEmployee();
}
