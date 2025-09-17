package employee_list_scaler_adapter;

import java.util.ArrayList;
import java.util.List;

import employee_list_scaler_adapter.employee_adapter.EmployeeAdapterCSV;
import employee_list_scaler_adapter.employee_adapter.EmployeeAdapterLdap;
import employee_list_scaler_adapter.employees.Employee;
import employee_list_scaler_adapter.employees.EmployeeCSV;
import employee_list_scaler_adapter.employees.EmployeeLdap;

public class EmployeeClient {
    public List<Employee> getEmployeeList() {
        List<Employee> employees = new ArrayList<>();
        // Employee employeeFromDB = new EmployeeDB("E001", "Alice", "Developer",
        // "alice@dev.com");
        EmployeeLdap employeeFromLDAP = new EmployeeLdap("E002", "Bob", "Manager", "bob@man.com");
        EmployeeCSV employeeFromCSV = new EmployeeCSV("314,Charlie,Analyst,charlie@anal.com");

        // We have to add the data of all the employees to the employees list
        // But it only accepts objects of type Employee

        // employees.add(employeeFromDB);
        employees.add(new EmployeeAdapterLdap(employeeFromLDAP));
        employees.add(new EmployeeAdapterCSV(employeeFromCSV));

        return employees;
    }
}
