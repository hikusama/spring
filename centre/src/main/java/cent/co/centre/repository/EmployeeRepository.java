package cent.co.centre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cent.co.centre.model.employee;

public interface EmployeeRepository extends JpaRepository<employee, Long> {
    
}
