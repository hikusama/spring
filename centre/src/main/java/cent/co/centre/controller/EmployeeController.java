package cent.co.centre.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import cent.co.centre.model.employee;
import cent.co.centre.service.EmployeeService;


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }


    // build create employee RESTAPI 
    @PostMapping()
    public ResponseEntity <employee> saveEmployee(@RequestBody employee employee){
        return new ResponseEntity<employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    //build get all employees rest api
    @GetMapping
    public List<employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }


    //build get employees by id rest api
    //http://localhost:8080/api/employees/1
    @GetMapping("{id}")
    public ResponseEntity<employee> getEmployeeById(@PathVariable("id") long employeeId){

        return new ResponseEntity<employee>(employeeService.getEmployeeById(employeeId),HttpStatus.OK);
    }



    //build update employee restAPI
    //http://localhost:8080/api/employees/1
    @PutMapping("{id}")
    public ResponseEntity<employee> updateEmployee(@PathVariable("id") long id
                                                    ,@RequestBody employee Employee){
 
    return new ResponseEntity<employee> (employeeService.updateEmployee(Employee, id), HttpStatus.OK);

    }

    // build delete Employee restAPI
    //http://localhost:8080/api/employees/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){

        employeeService.deleteEmployee(id);

        return new ResponseEntity<String>("Employee Deleted Succesfully!!.", HttpStatus.OK);
    }


}
