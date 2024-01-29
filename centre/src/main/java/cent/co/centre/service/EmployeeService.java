package cent.co.centre.service;


import java.util.List;

import cent.co.centre.model.employee;

public interface EmployeeService {
    employee saveEmployee(employee employees);

    List<employee> getAllEmployees();

    employee getEmployeeById(long id);
    employee updateEmployee(employee Employee , long id);
    void deleteEmployee(long id);
}



