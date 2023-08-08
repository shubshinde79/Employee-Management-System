package EmployeeManagementSystem;

import java.util.List;
import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);
    private static EmployeeManagementSystem ems = new EmployeeManagementSystem();

    public static void main(String[] args) {
        int choice = -1;

        while (choice != 0) {
            System.out.println("Employee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Get Employee by ID");
            System.out.println("5. Get All Employees");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    updateEmployee();
                    break;
                case 3:
                    deleteEmployee();
                    break;
                case 4:
                    getEmployeeById();
                    break;
                case 5:
                    getAllEmployees();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addEmployee() {
        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();
        System.out.print("Enter employee age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter employee designation: ");
        String designation = scanner.nextLine();
        System.out.print("Enter employee salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        Employee employee = new Employee(id, name, age, designation, salary);
        ems.addEmployee(employee);
        System.out.println("Employee added successfully.");
        System.out.println();
    }

    private static void updateEmployee() {
        System.out.print("Enter employee ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Employee employee = ems.getEmployeeById(id);
        if (employee != null) {
            System.out.print("Enter updated name: ");
            String name = scanner.nextLine();
            System.out.print("Enter updated age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            System.out.print("Enter updated designation: ");
            String designation = scanner.nextLine();
            System.out.print("Enter updated salary: ");
            double salary = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character

            Employee updatedEmployee = new Employee(id, name, age, designation, salary);
            ems.updateEmployee(updatedEmployee);
            System.out.println("Employee updated successfully.");
        } else {
            System.out.println("Employee not found with ID: " + id);
        }
        System.out.println();
    }

    private static void deleteEmployee() {
        System.out.print("Enter employee ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        ems.deleteEmployee(id);
        System.out.println("Employee deleted successfully.");
        System.out.println();
    }

    private static void getEmployeeById() {
        System.out.print("Enter employee ID to search: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Employee employee = ems.getEmployeeById(id);
        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("Employee not found with ID: " + id);
        }
        System.out.println();
    }

    private static void getAllEmployees() {
        List<Employee> employees = ems.getAllEmployees();
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            System.out.println("All Employees:");
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
        System.out.println();
    }

}
