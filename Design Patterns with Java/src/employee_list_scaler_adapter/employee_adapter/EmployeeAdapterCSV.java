package employee_list_scaler_adapter.employee_adapter;

import employee_list_scaler_adapter.employees.Employee;
import employee_list_scaler_adapter.employees.EmployeeCSV;

public class EmployeeAdapterCSV implements Employee {
    private EmployeeCSV employeeCSV;

    public EmployeeAdapterCSV(EmployeeCSV employeeCSV) {
        this.employeeCSV = employeeCSV;
    }

    @Override
    public String getId() {
        return String.valueOf(employeeCSV.getId());
    }

    @Override
    public String getFirstname() {
        return employeeCSV.getFirstname();
    }

    @Override
    public String getLastname() {
        return employeeCSV.getLastname();
    }

    @Override
    public String getEmail() {
        return employeeCSV.getEmailAddress();
    }
}
