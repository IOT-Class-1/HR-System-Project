package com.example.HR.service;

import com.example.HR.model.Employee;
import com.example.HR.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService { // Bu anotasyon, bu sınıfın bir servis sınıfı olduğunu belirtir.

    @Autowired // Spring bu alanı otomatik olarak inject/enjekte eder.
    private EmployeeRepository employeeRepository; // copy paste


    // CRUD'un C harfi
    public Employee hireEmployee(Employee employee){
        // Yeni bir çalışanı veritabanına JPA'den gelen 'save' metodu ile kaydeder.
        return employeeRepository.save(employee);
    }

    // CRUD' R harfi
    public List<Employee> getAllEmployees(){
        // Tüm çalışanları veritabanından "findAll" metodu ile getirir.
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id){
        // Belitilen kimlikteki çalışanı veritabanından getirir.
        return employeeRepository.findById(id);
    }

    // CRUD' U harfi
    public Employee updateEmployee(Long id, Employee employeeDetails) {
        // Belitilen kimlikte çalışanı güncelleyen metot.

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Calisan bulunamadi"));
        // orElse yani if döngüsünün else kısmı gibi düşünebiliriz. Aradığımız çalışan bulunumadığı durumlarda
        // Kullanıcıya böyle bir metin gösteriyoruz.

        employee.setName(employeeDetails.getName());
        employee.setPosition(employeeDetails.getPosition());

        return employeeRepository.save(employee);
    }

    // CRUD'un D harfi
    public void fireEmployee(Long id){
        // Belirtilen kimlikteki çalışanı silen metottur.

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Employee not found!"));

        // Silme işlemini yapan "delete" metodunu JPA repository içerisinden çağırarak kullandık.
        employeeRepository.delete(employee);
    }
}

