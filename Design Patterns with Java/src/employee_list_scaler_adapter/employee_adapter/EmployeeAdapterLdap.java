package employee_list_scaler_adapter.employee_adapter;

import employee_list_scaler_adapter.employees.Employee;
import employee_list_scaler_adapter.employees.EmployeeLdap;

public class EmployeeAdapterLdap implements Employee {
    private EmployeeLdap employeeLDAP;

    public EmployeeAdapterLdap(EmployeeLdap employeeLDAP) {
        this.employeeLDAP = employeeLDAP;
    }

    @Override
    public String getId() {
        return employeeLDAP.getCn();
    }

    @Override
    public String getFirstname() {
        return employeeLDAP.getGivenName();
    }

    @Override
    public String getLastname() {
        return employeeLDAP.getSurname();
    }

    @Override
    public String getEmail() {
        return employeeLDAP.getMail();
    }
}
