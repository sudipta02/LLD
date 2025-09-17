package employee_list_scaler_adapter;

import java.util.List;

import employee_list_scaler_adapter.employees.Employee;

public class AdapterDemo {
    public static void main(String[] args) {
        EmployeeClient client = new EmployeeClient();

        List<Employee> employees = client.getEmployeeList();

        for (Employee emp : employees) {
            System.out.println("ID: " + emp.getId());
            System.out.println("First Name: " + emp.getFirstname());
            System.out.println("Last Name: " + emp.getLastname());
            System.out.println("Email: " + emp.getEmail());
            System.out.println("-----------------------");
        }
    }
}
