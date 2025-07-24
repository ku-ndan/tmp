import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrudDemo {
    private static final List<Employee> employees = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public CrudDemo() {
        employees.add(new Employee(100, "abc", "abc@gmail.com", 9878675676L, true, LocalDate.of(2007, 8, 17)));
        employees.add(new Employee(101, "xyz", "xyz@gmail.com", 8798675687L, true, LocalDate.of(2003, 3, 10)));
        employees.add(new Employee(102, "mno", "mno@gmail.com", 7898563416L, false, LocalDate.of(2009, 4, 8)));
        employees.add(new Employee(103, "pqr", "pqr@gmail.com", 6898785645L, true, LocalDate.of(2006, 6, 21)));
        employees.add(new Employee(104, "lmn", "lmn@gmail.com", 8754231243L, false, LocalDate.of(2008, 9, 15)));
    }

    public static void main(String[] args) {
        new CrudDemo();
        System.out.println("---------------Welcome to Employee CRUD Program---------------");

        while (true) {
            System.out.println("\n\t1. View All Employees");
            System.out.println("\t2. View Employee by ID");
            System.out.println("\t3. View Active Employees");
            System.out.println("\t4. Add New Employee");
            System.out.println("\t5. Update an Employee");
            System.out.println("\t6. Delete an Employee");
            System.out.println("\t7. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> viewEmployees();
                case 2 -> viewEmployeeById();
                case 3 -> viewActiveEmployees();
                case 4 -> addEmployee();
                case 5 -> updateEmployee();
                case 6 -> deleteEmployee();
                case 7 -> {
                    System.out.println("Program ends here!!");
                    return;
                }
                default -> System.out.println("Invalid choice! Please select between 1-7.");
            }
        }
    }

    private static void viewEmployees() {
        System.out.println("\n*************** All Employees ***************");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }

    private static void viewActiveEmployees() {
        System.out.println("\n*************** Active Employees ***************");
        for (Employee emp : employees) {
            if (emp.isActive()) {
                System.out.println(emp);
            }
        }
    }

    private static void viewEmployeeById() {
        System.out.print("Enter ID of the employee to view: ");
        int id = scanner.nextInt();
        boolean found = false;
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                System.out.println(emp);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    private static void addEmployee() {
        System.out.println("\n*************** Adding New Employee ***************");
        Employee emp = new Employee();

        System.out.print("Enter Employee ID: ");
        emp.setId(scanner.nextInt());

        System.out.print("Enter Employee Name: ");
        emp.setName(scanner.next());

        System.out.print("Enter Employee Email: ");
        emp.setEmail(scanner.next());

        System.out.print("Enter Employee Mobile: ");
        emp.setMobile(scanner.nextLong());

        System.out.print("Is Active? [1 for Yes / 0 for No]: ");
        emp.setActive(scanner.nextInt() == 1);

        System.out.print("Enter Date of Birth [yyyy-MM-dd]: ");
        try {
            emp.setBirthDate(LocalDate.parse(scanner.next(), formatter));
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format! Setting birth date as null.");
        }

        employees.add(emp);
        System.out.println("New Employee added successfully!");
    }

    private static void updateEmployee() {
        System.out.println("\n*************** Updating Employee ***************");
        System.out.print("Enter ID of the employee to update: ");
        int id = scanner.nextInt();

        Employee existing = null;
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                existing = emp;
                break;
            }
        }

        if (existing == null) {
            System.out.println("Employee with ID " + id + " not found.");
            return;
        }

        Employee updated = new Employee();
        updated.setId(id);

        System.out.print("Enter Employee Name: ");
        updated.setName(scanner.next());

        System.out.print("Enter Employee Email: ");
        updated.setEmail(scanner.next());

        System.out.print("Enter Employee Mobile: ");
        updated.setMobile(scanner.nextLong());

        System.out.print("Is Active? [1 for Yes / 0 for No]: ");
        updated.setActive(scanner.nextInt() == 1);

        System.out.print("Enter Date of Birth [yyyy-MM-dd]: ");
        try {
            updated.setBirthDate(LocalDate.parse(scanner.next(), formatter));
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format! Keeping old birth date.");
            updated.setBirthDate(existing.getBirthDate());
        }

        employees.remove(existing);
        employees.add(updated);
        System.out.println("Employee updated successfully!");
    }

    private static void deleteEmployee() {
        System.out.println("\n*************** Deleting Employee ***************");
        System.out.print("Enter ID of the employee to delete: ");
        int id = scanner.nextInt();

        Employee toDelete = null;
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                toDelete = emp;
                break;
            }
        }

        if (toDelete != null) {
            employees.remove(toDelete);
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }
}
