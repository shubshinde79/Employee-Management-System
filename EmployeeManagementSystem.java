package EmployeeManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManagementSystem {

	private List<Employee> employees;

    public EmployeeManagementSystem() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void updateEmployee(Employee updatedEmployee) {
        for (Employee employee : employees) {
            if (employee.getId() == updatedEmployee.getId()) {
                employee.setName(updatedEmployee.getName());
                employee.setAge(updatedEmployee.getAge());
                employee.setDesignation(updatedEmployee.getDesignation());
                employee.setSalary(updatedEmployee.getSalary());
                break;
            }
        }
    }

    public void deleteEmployee(int id) {
        Employee employeeToRemove = null;
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null) {
            employees.remove(employeeToRemove);
        }
    }

    public Employee getEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }
}


