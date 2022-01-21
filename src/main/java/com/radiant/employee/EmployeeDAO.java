package com.radiant.employee;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAO {

    private static Employees empList = new Employees();

    static
    {
        empList.getEmployeeList().add(new Employee(1, "Sri", "Arepally", "sriarepally@gmail.com"));
        empList.getEmployeeList().add(new Employee(2, "Tom", "Brady", "tombrady@gmail.com"));
        empList.getEmployeeList().add(new Employee(3, "Michael", "Jordan", "mj@gmail.com"));
    }

    public Employees getEmployees() {
        return empList;
    }

    public void addEmployee(Employee employee) {
        empList.getEmployeeList().add(employee);
    }
}
