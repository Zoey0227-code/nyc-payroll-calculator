import java.util.Scanner;

public class PayrollCalculator {
    public static void main(String[] args) {
        System.out.println("Welcome to Zoey's NYC Payday Calculator!");

        // Create a Scanner to read keyboard input
        Scanner scanner = new Scanner(System.in);

        // Ask for the employee's name
        System.out.print("What's your name? ");
        String name = scanner.nextLine();

        System.out.println("Let's calculate your payday, " + name + "!");

        // Ask for the hourly wage
        System.out.print("What's your hourly wage? ");

        // Keep asking until the user enters a valid, nonnegative wage
        while (!scanner.hasNextDouble()) {
            System.out.print("Please enter a number, such as 22.50: ");
            scanner.next(); // Discard the invalid input
        }

        double hourlyWage = scanner.nextDouble();

        while (!Double.isFinite(hourlyWage) || hourlyWage < 0) {
            System.out.print("Please enter a finite wage of 0 or more: ");

            while (!scanner.hasNextDouble()) {
                System.out.print("Please enter a number: ");
                scanner.next();
            }

            hourlyWage = scanner.nextDouble();
        }

                // Ask for the hours worked
                System.out.print("How many total hours did you work this month? ");
            

        // Hours must be a nonnegative whole number
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a whole number, such as 160: ");
            scanner.next();
        }

        int hoursWorked = scanner.nextInt();

        while (hoursWorked < 0) {
            System.out.print("Please enter hours of 0 or more: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Please enter a whole number: ");
                scanner.next();
            }

            hoursWorked = scanner.nextInt();
        }

        // Calculate earnings and the assignment's flat 20% tax
        double grossSalary = hourlyWage * hoursWorked;
        double tax = grossSalary * 0.20;
        double netSalary = grossSalary - tax;


        // Calculate how many whole $6 coffees the net salary can buy
        double coffeePrice = 6.00;
        int coffees = (int) (netSalary / coffeePrice);

        


        // Display the payroll summary
        System.out.println("\nMonthly Payroll Summary for " + name);
        System.out.println("-----------------------------------");
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.printf("Hourly Wage: $%.2f%n", hourlyWage);
        System.out.printf("Gross Salary: $%.2f%n", grossSalary);
        System.out.printf("Taxes Deducted: $%.2f%n", tax);
        System.out.printf("Net Salary: $%.2f%n", netSalary);
        System.out.println("\nNYC Spending Power");
        System.out.println("-----------------------------------");
        System.out.println("Your monthly pay could buy " + coffees + " coffees at $6 each!");
        
        
        scanner.close();
    }
}