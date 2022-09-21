package LaberonLSDZ2.controller;


import LaberonLSDZ2.domain.Employee;
import LaberonLSDZ2.service.EmployeeServiceImpl;
import LaberonLSDZ2.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public String add(@RequestParam("name") String firstName,
                      @RequestParam("lastName") String lastName,
                      @RequestParam("salary") int salary,
                      @RequestParam("department") int department) {
        employeeService.addPerson(firstName, lastName, salary, department);
        return "Добавлен";
    }

    @GetMapping(path = "/find")
    public String find(@RequestParam("name") String firstName,
                       @RequestParam("lastName") String lastName) {
        return employeeService.findPersons(firstName, lastName).toString();
    }

    @GetMapping(path = "/remove")
    public String remove(@RequestParam("name") String firstname,
                         @RequestParam("lastName") String lastName) {
        employeeService.removePerson(firstname, lastName);
        return "Сотрудник: " + firstname + " удален";
    }

    @GetMapping(path = "/findAll")
    public Collection<Employee> find() {
        return employeeService.getAll();
    }

}
