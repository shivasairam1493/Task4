import java.util.ArrayList;
import java.util.Scanner;


class Employee {
    private String name;
    private int id;
    private String position;
    private double salary;

    public Employee(String name, int id, String position, double salary) {
        this.name = name;
        this.id = id;
        this.position = position;
        this.salary = salary;
    }

  
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

   
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Position: " + position);
        System.out.println("Salary: $" + salary);
    }
}


public class EmployeeManagementApp {

    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter employee name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); 

                    System.out.print("Enter employee position: ");
                    String position = scanner.nextLine();

                    System.out.print("Enter employee salary: ");
                    double salary = scanner.nextDouble();
                    scanner.nextLine(); 

                    Employee newEmployee = new Employee(name, id, position, salary);
                    employees.add(newEmployee);
                    System.out.println("Employee added successfully!");
                    break;

                case 2:
                    if (employees.isEmpty()) {
                        System.out.println("No employees to display.");
                    } else {
                        System.out.println("\nEmployee List:");
                        for (Employee emp : employees) {
                            emp.displayInfo();
                            System.out.println();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter employee ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    boolean found = false;
                    for (Employee emp : employees) {
                        if (emp.getId() == updateId) {
                            System.out.print("Enter new name: ");
                            String newName = scanner.nextLine();
                            emp.setName(newName);

                            System.out.print("Enter new position: ");
                            String newPosition = scanner.nextLine();
                            emp.setPosition(newPosition);

                            System.out.print("Enter new salary: ");
                            double newSalary = scanner.nextDouble();
                            scanner.nextLine(); 
                            emp.setSalary(newSalary);

                            System.out.println("Employee details updated!");
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Employee not found with ID: " + updateId);
                    }
                    break;

                case 4:
                    System.out.print("Enter employee ID to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();

                    boolean removed = false;
                    for (Employee emp : employees) {
                        if (emp.getId() == deleteId) {
                            employees.remove(emp);
                            System.out.println("Employee deleted successfully!");
                            removed = true;
                            break;
                        }
                    }

                    if (!removed) {
                        System.out.println("Employee not found with ID: " + deleteId);
                    }
                    break;

                case 5:
                    System.out.println("Exiting Employee Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
}

