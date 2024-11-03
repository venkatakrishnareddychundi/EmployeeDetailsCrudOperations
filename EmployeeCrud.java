package com.crudoperations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee{
	
	private int id;
	private String name;
	private String department;
	private double salary;
	public Employee(int id, String name, String department, double salary) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", department=" + department + ", salary=" + salary + "]";
	}
	
}

public class EmployeeCrud {
	static List<Employee> employeeList=new ArrayList<>();
	public static void addEmployee(Scanner scanner) {
		System.out.print("Enter Employee Id: ");
		int id=scanner.nextInt();
		System.out.print("Enter Employee name: ");
		String name=scanner.next();
		System.out.print("Enter department name: ");
		String department=scanner.next();
		System.out.println("Enter Employee Salary: ");
		float salary=scanner.nextFloat();
		
		Employee newEmployee=new Employee(id,name,department,salary);
		employeeList.add(newEmployee);
		System.out.println("Employee added successfully!");
	}
	public static void viewEmployees() {
		if(employeeList.isEmpty()) {
			System.out.println("no employees to display");
		}
		else {
			System.out.println("Enployee List: ");
			for(Employee emp:employeeList) {
				System.out.println(emp);
			}
		}
	}
	public static Employee findEmployeeById(int id) {
		for(Employee emp:employeeList) {
			if(emp.getId()==id) {
				return emp;
			}
		}
		return null;
	}
	public static void updateEmployee(Scanner scanner) {
		System.out.print("Enter employee ID to update: ");
		int id=scanner.nextInt();
		Employee employeeToUpdate=findEmployeeById(id);
		if(employeeToUpdate!=null) {
			System.out.print("Enter new id: ");
			employeeToUpdate.setId(scanner.nextInt());
			System.out.print("Enter new name: ");
			employeeToUpdate.setName(scanner.next());
			System.out.print("Enter new department: ");
			employeeToUpdate.setDepartment(scanner.next());
			System.out.print("Enter new salary: ");
			employeeToUpdate.setSalary(scanner.nextFloat());
		}
		else {
			System.out.println("Employee not found with this Id");
			
		}
	}
	public static void deleteEmployee(Scanner scanner) {
		System.out.print("Enter employee id to delete: ");
		int id=scanner.nextInt();
		Employee employeeToDelete=findEmployeeById(id);
		if(employeeToDelete!=null) {
			employeeList.remove(employeeToDelete);
		}
		else {
			System.out.println("employee not found with this id");
		}
	}

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		boolean exit=false;
		while(!exit) {
			System.out.println("\nEmployee Management System:");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            
            switch(choice) {
            case 1:
            	addEmployee(scanner);
            	break;
            case 2:
            	viewEmployees();
            	break;
            case 3:
            	updateEmployee(scanner);
            	break;
            case 4:
            	deleteEmployee(scanner);
            	break;
            case 5:
            	exit=true;
            	System.out.println("Exiting...");
            	break;
            default:
            	System.out.println("Invalid option...");
            }

		}


	}

}
