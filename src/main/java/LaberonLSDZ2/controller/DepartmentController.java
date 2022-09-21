package LaberonLSDZ2.controller;

import LaberonLSDZ2.domain.Employee;
import LaberonLSDZ2.service.DepartmentServiceImp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/department")
public class DepartmentController {
    private final DepartmentServiceImp departmentService;

    public DepartmentController(DepartmentServiceImp departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/max-salary")
    public Employee findMaxSalary(@RequestParam("departmentId") int department) {
        return departmentService.maxSalary(department);
    }

    @GetMapping(path = "/min-salary")
    public Employee findMinSalary(@RequestParam("departmentId") int department) {
        return departmentService.minSalary(department);
    }

    @GetMapping(path = "/all", params = "departmentId")
    public List<Employee> findEmployeeFromDepartment(@RequestParam("department") int department) {
        return departmentService.findEmployeeByDepartment(department);
    }

    @GetMapping(path = "/all")
    public Map<Integer, List<Employee>> findEmployee() {
        return departmentService.findEmployee();
    }
}
