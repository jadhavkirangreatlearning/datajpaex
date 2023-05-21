package com.csi.service;

import com.csi.dao.EmployeeDaoImpl;
import com.csi.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeServiceImpl {

    @Autowired
    EmployeeDaoImpl employeeDaoImpl;

    public Employee signUp(Employee employee) {
        return employeeDaoImpl.signUp(employee);
    }

    public boolean signIn(String empEmailId, String empPassword) {


        return employeeDaoImpl.signIn(empEmailId, empPassword);
    }

    @Cacheable(value = "empId")
    public Optional<Employee> getDataById(int empId) {
        log.info("###########Trying to fetch data from DB");
        return employeeDaoImpl.getDataById(empId);
    }

    public List<Employee> getDataByName(String empName) {
        return employeeDaoImpl.getDataByName(empName);
    }

    public List<Employee> getAllData() {
        return employeeDaoImpl.getAllData();
    }

    public List<Employee> getDataByUsingAnyInput(String input) {

        return employeeDaoImpl.getDataByUsingAnyInput(input);
    }

    public Employee updateData(Employee employee) {
        return employeeDaoImpl.updateData(employee);
    }

    public void deleteDataById(int empId) {
        employeeDaoImpl.deleteDataById(empId);
    }
}
