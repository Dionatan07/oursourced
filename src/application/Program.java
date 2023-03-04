package application;

import entities.Employee;
import entities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        List<Employee> employees = new ArrayList<>();

        System.out.print("Enter the numeber of employees: ");
        int n = input.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Employee #" + (i + 1) + " data: ");
            System.out.print("Outsourced (y/n)? ");
            char response = input.next().charAt(0);

            input.nextLine();
            System.out.print("Name: ");
            String name = input.nextLine();

            System.out.print("Hours: ");
            int hours = input.nextInt();

            System.out.print("Value per hour: ");
            double valuePerHour = input.nextDouble();

            if (response == 'n') {
                Employee employee = new Employee(name, hours, valuePerHour);
                employees.add(employee);

            } else {
                System.out.print("Additional Charge: ");
                double additionalCharge = input.nextDouble();

                Employee employee = new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge);
                employees.add(employee);
            }
        }

        System.out.println();
        System.out.println("PAYMENTS: ");
        for(Employee list : employees){
            System.out.println(list.getName() + " - $ " + String.format("%.2f" , list.payment()));
        }
    }
}
