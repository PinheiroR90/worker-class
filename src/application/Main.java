package application;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.emuns.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat dataFormat = new  SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Running application");

        System.out.println("Enter department's name:");
        String department = sc.nextLine();
        System.out.println("Enter worker data:");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Level: ");
        String level = sc.nextLine();
        System.out.print("Base salary: ");
        double baseSalary = sc.nextDouble();
        Worker worker = new Worker(name, WorkerLevel.valueOf(level),baseSalary, new Department(department));
       // System.out.println("teste departame "+ department);

        System.out.println();

        System.out.print("How many contracts to this worker?");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter contract #" + (i + 1) + " data:");
            System.out.print("Data: ");
            Date date = dataFormat.parse(sc.next());
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            System.out.print("Duration (hours):");
            int hours = sc.nextInt();
            HourContract contract = new HourContract(date, valuePerHour, hours);
            worker.addContract(contract);
        }
        System.out.println();
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.next();
        int monthF = Integer.parseInt(monthAndYear.substring(0, 2));
        int yearF = Integer.parseInt((monthAndYear.substring(3)));
        System.out.println("Name: "+worker.getName()+
                "\nDepartment: "+worker.getDepartment().getName()+
                "\nIncome for: "+monthAndYear+": "+String.format("%.2f",worker.inCome(yearF,monthF)));

        sc.close();
    }
}
