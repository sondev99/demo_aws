package com.example.demoaws.controller;

import com.example.demoaws.modal.Employee;
import com.example.demoaws.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmployeeController {
  private final EmployeeRepository employeeRepository;

  @PostMapping("/employee")
  public Employee save(@RequestBody Employee employee) {
    return employeeRepository.save(employee);
  }
}
