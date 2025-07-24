//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

//package com.cams.day4;

//import Employee;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrudDemo {
    private static List<Employee> employees = new ArrayList();

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
        Scanner UserChoice = new Scanner(System.in);
        System.out.println("\t\t\t 1. View All Employee");
        System.out.println("\t\t\t 2. View Employee by ID");
        System.out.println("\t\t\t 3. View Active Employees");
        System.out.println("\t\t\t 4. Add New Employee");
        System.out.println("\t\t\t 5. Update an Employee");
        System.out.println("\t\t\t 6. Delete an Employee");
        System.out.println("\t\t\t 7. Exit");

        int choice = UserChoice.nextInt();
        switch(choice){
            case 1:
                System.out.println("***************All Employees***************");
                viewEmployees(employees);
                break;
            case 2:
                System.out.println("***************Employee By ID***************");
                System.out.print("Enter ID of the employee to View :");
                Scanner input1 = new Scanner(System.in);
                int id = input1.nextInt();
                viewEmployeeById(id);
                input1.close();
                break;
            case 3:
                System.out.println("***************All Active Employees***************");
                viewActiveEmployees(employees);
                break;

            case 4:
                System.out.println("***************Adding New Employee***************");
                Scanner input2 = new Scanner(System.in);
                Employee employee = new Employee();
                System.out.print("Enter Employee ID :");
                employee.setId(input2.nextInt());
                System.out.print(" Enter Employee Name :");
                employee.setName(input2.next());
                System.out.print(" Enter Employee Email :");
                employee.setEmail(input2.next());
                System.out.print(" Enter Employee Mobile :");
                employee.setMobile(input2.nextLong());
                System.out.print(" isActive [0/1] :");
                int value = input2.nextInt();
                if (value != 1) {
                    employee.setActive(false);
                } else {
                    employee.setActive(true);
                }
                System.out.print("Enter Date of Birth [YYYY-MM-DD]:");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String dateString = input2.next();
                LocalDate date = null;

                try {
                    date = LocalDate.parse(dateString, formatter);
                    System.out.println("Parsed date: " + String.valueOf(date));
                } catch (DateTimeParseException var12) {
                    System.out.println("Invalid date format. Please use yyyy-MM-dd.");
                }

                employee.setBirthDate(date);
                addEmployee(employee);
                input2.close();
                break;


            case 5:
                System.out.println("***************Updating an Employee By ID***************");
                System.out.print("Enter ID of the employee to Update :");
                Scanner input3 = new Scanner(System.in);
                id = input3.nextInt();
                Employee emp1 = new Employee();
                System.out.print(" Enter Employee Name :");
                emp1.setName(input3.next());
                System.out.print(" Enter Employee Email :");
                emp1.setEmail(input3.next());
                System.out.print(" Enter Employee Mobile :");
                emp1.setMobile(input3.nextLong());
                System.out.print(" isActive [0/1] :");
                value = input3.nextInt();
                if (value != 1) {
                    emp1.setActive(false);
                } else {
                    emp1.setActive(true);
                }

                System.out.print("Enter Date of Birth [YYYY-MM-DD]:");
                dateString = input3.next();
                date = null;

                try {
                    date = LocalDate.parse(dateString, formatter);
                    System.out.println("Parsed date: " + String.valueOf(date));
                } catch (DateTimeParseException var11) {
                    System.out.println("Invalid date format. Please use yyyy-MM-dd.");
                }

                emp1.setBirthDate(date);
                updateById(id, emp1);
                input3.close();

            case 6:
                System.out.println("***************Deleting an Employee By ID***************");
                System.out.print("Enter ID of the employee to Delete :");
                Scanner input4 = new Scanner(System.in);
                int id2 = input4.nextInt();
                deleteById(id2);
                input4.close();
                break;

            case 7:
                System.out.println("Program ends here!!");
                System.exit(0);


        }




    }

    private static void updateById(int id, Employee employee) {
        employee.setId(id);
        Employee temp = new Employee();

        for(Employee emp : employees) {
            if (emp.getId() == id) {
                temp = emp;
            }
        }

        employees.remove(temp);
        employees.add(employee);
        System.out.println("Employee with ID :" + id + " is updated!!!");
    }

    private static void deleteById(int id) {
        Employee emp1 = new Employee();

        for(Employee emp : employees) {
            if (emp.getId() == id) {
                emp1 = emp;
            }
        }

        employees.remove(emp1);
        System.out.println("Deleted Employee with ID :" + id);
    }

    public static void viewEmployees(List<Employee> employees) {
        System.out.print("ID \t Name \t Email \t\t Mobile \t BirthDate \n");

        for(Employee emp : employees) {
            PrintStream var10000 = System.out;
            int var10001 = emp.getId();
            var10000.println(var10001 + "\t" + emp.getName() + "\t" + emp.getEmail() + "\t" + emp.getMobile() + "\t" + String.valueOf(emp.getBirthDate()));
        }

    }

    public static void viewActiveEmployees(List<Employee> employees) {
        System.out.print("ID \t Name \t Email \t\t Mobile \t BirthDate \n");

        for(Employee emp : employees) {
            if (emp.isActive()) {
                PrintStream var10000 = System.out;
                int var10001 = emp.getId();
                var10000.println(var10001 + "\t" + emp.getName() + "\t" + emp.getEmail() + "\t" + emp.getMobile() + "\t" + String.valueOf(emp.getBirthDate()));
            }
        }

    }

    public static void viewEmployeeById(int id) {
        System.out.print("ID \t Name \t Email \t\t Mobile \t BirthDate \n");

        for(Employee emp : employees) {
            if (emp.getId() == id) {
                PrintStream var10000 = System.out;
                int var10001 = emp.getId();
                var10000.println(var10001 + "\t" + emp.getName() + "\t" + emp.getEmail() + "\t" + emp.getMobile() + "\t" + String.valueOf(emp.getBirthDate()));
            }
        }

    }

    public static int addEmployee(Employee emp) {
        int result = 0;
        int totalEmployees = employees.size();
        employees.add(emp);
        if (totalEmployees < employees.size()) {
            result = 1;
            System.out.println("New Employee is added Successfully!!!!");
        }

        return result;
    }
}
