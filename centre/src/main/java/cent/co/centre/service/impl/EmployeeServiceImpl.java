package cent.co.centre.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cent.co.centre.exception.ResourceNotFoundException;
import cent.co.centre.model.employee;
import cent.co.centre.repository.EmployeeRepository;
import cent.co.centre.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService{



    private EmployeeRepository employeeRepository;
    
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }



    @Override
    public employee saveEmployee(employee employee) {
        return employeeRepository.save(employee);
    }



    @Override
    public List<employee> getAllEmployees() {
        return employeeRepository.findAll();
    }



    @Override
    public employee getEmployeeById(long id) {


        // Optional <employee> Employee = employeeRepository.findById(id);

        // if (Employee.isPresent()) {
        //     return Employee.get();
        // } else {
        //     throw new ResourceNotFoundException("Employee", "Id" , id);
        // }

        return employeeRepository.findById(id).orElseThrow(() -> 
                new ResourceNotFoundException("Employee", "Id" , id) );

    }



    @Override
    public employee updateEmployee(employee Employee, long id) {


        employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));

 
        existingEmployee.setFirstName(Employee.getFirstName());
        existingEmployee.setLastName(Employee.getLastName());
        existingEmployee.setEmail(Employee.getEmail());

        // save existing employee to DB

        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }



    @Override
    public void deleteEmployee(long id) {

        //check wheather a employee exist in a DB or not
        employeeRepository.findById(id).orElseThrow(() -> 
                            new ResourceNotFoundException("Employee", "Id" , id));


        employeeRepository.deleteById(id);
    }



    
}
