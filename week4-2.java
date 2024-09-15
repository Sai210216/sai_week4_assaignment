import java.util.HashMap;
import java.util.Scanner;

  class Employee {
    private String name;
    private String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }
 
    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }
    
    public String toString() {
        return "Name: " + name + ", Department: " + department;
    }
}

  class EmployeeManager {
    private HashMap<Integer, Employee> employeeMap = new HashMap<>();
 
    public void addEmployee(int id, String name, String department) {
        Employee newEmployee = new Employee(name, department);
        employeeMap.put(id, newEmployee);
        System.out.println("Employee added: " + newEmployee);
    }
 
    public void getEmployee(int id) {
        if (employeeMap.containsKey(id)) {
            System.out.println("Employee found: " + employeeMap.get(id));
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }
 
    public void displayAllEmployees() {
        if (employeeMap.isEmpty()) {
            System.out.println("No employees to display.");
        } else {
            System.out.println("List of all employees:");
            for (Integer id : employeeMap.keySet()) {
                System.out.println("ID: " + id + ", " + employeeMap.get(id));
            }
        }
    }

    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Employee \n2. Get Employee by ID \n3. Display All Employees \n4. Exit \nEnter your choice:");
            
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter employee ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); 
                    System.out.print("Enter employee name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter employee department: ");
                    String department = sc.nextLine();
                    manager.addEmployee(id, name, department);
                    break;
                case 2:
                    System.out.print("Enter employee ID to retrieve: ");
                    int retrieveId = sc.nextInt();
                    manager.getEmployee(retrieveId);
                    break;
                case 3:
                    manager.displayAllEmployees();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } 
		while (choice != 4);

        
    }
}
