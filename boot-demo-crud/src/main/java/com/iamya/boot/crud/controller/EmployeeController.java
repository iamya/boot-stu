package com.iamya.boot.crud.controller;

import com.iamya.boot.crud.dao.DepartmentDao;
import com.iamya.boot.crud.dao.EmployeeDao;
import com.iamya.boot.crud.entities.Department;
import com.iamya.boot.crud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String list(Map<String, Object> map) {
        Collection<Employee> employees = employeeDao.getAll();
        map.put("emps", employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Map<String, Object> map) {

        Collection<Department> departments = departmentDao.getDepartments();
        map.put("depts", departments);

        return "emp/add";

    }

    @RequestMapping(value = "/emp", method = {RequestMethod.POST, RequestMethod.PUT})
    public String saveEmployee(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable Integer id, Map<String, Object> map) {
        Employee employee = employeeDao.get(id);
        Collection<Department> departments = departmentDao.getDepartments();
        map.put("depts", departments);
        map.put("emp", employee);
        return "emp/add";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
