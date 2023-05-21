package com.csi.dao;

import com.csi.model.Employee;
import com.csi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class EmployeeDaoImpl {

    @Autowired
    EmployeeRepository employeeRepositoryImpl;

    public Employee signUp(Employee employee) {
        return employeeRepositoryImpl.save(employee);
    }

    public boolean signIn(String empEmailId, String empPassword) {
        boolean flag = false;

        for (Employee employee : getAllData()) {
            if (employee.getEmpEmailId().equals(empEmailId) && employee.getEmpPassword().equals(empPassword)) {
                flag = true;
            }
        }

        return flag;
    }

    public Optional<Employee> getDataById(int empId) {
        return employeeRepositoryImpl.findById(empId);
    }

    public List<Employee> getDataByName(String empName) {
        return employeeRepositoryImpl.findByEmpName(empName);
    }

    public List<Employee> getAllData() {
        return employeeRepositoryImpl.findAll();
    }

    public List<Employee> getDataByUsingAnyInput(String input) {
        // id, name, email, contact number
        // dob
        List<Employee> employeeList = new ArrayList<>();

        for (Employee employee : getAllData()) {
            if (String.valueOf(employee.getEmpId()).equals(input)
                    || employee.getEmpName().equals(input)
                    || employee.getEmpEmailId().equals(input)
                    || String.valueOf(employee.getEmpContactNumber()).equals(input)) {
                employeeList.add(employee);
            }
        }
        return employeeList;
    }

    public Employee updateData(Employee employee) {
        return employeeRepositoryImpl.save(employee);
    }

    public void deleteDataById(int empId) {
        employeeRepositoryImpl.deleteById(empId);
    }


}
