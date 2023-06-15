import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Payslip {
    public static void main(String[] args) {
        // Get user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Employee Name: ");
        String employeeName = scanner.nextLine();
        
        System.out.print("Rendered Hours: ");
        double renderedHours = scanner.nextDouble();
        
        System.out.print("Rate per Hour: ");
        double ratePerHour = scanner.nextDouble();
        
        System.out.print("SSS Contribution: ");
        double sssContribution = scanner.nextDouble();
        
        System.out.print("PhilHealth Contribution: ");
        double philHealthContribution = scanner.nextDouble();
        
        System.out.print("Loans: ");
        double loans = scanner.nextDouble();
        
        // Calculate the payslip values
        double grossSalary = renderedHours * ratePerHour;
        double totalDeductions = sssContribution + philHealthContribution + loans;
        double netSalary = grossSalary - totalDeductions;
        
        // Generate the payslip text
        StringBuilder payslip = new StringBuilder();
        payslip.append("==============PAYSLIP==============\n");
        payslip.append("======EMPLOYEE INFORMATION=======\n");
        payslip.append("Employee Name: ").append(employeeName).append("\n");
        payslip.append("Rendered Hours: ").append(renderedHours).append("\n");
        payslip.append("Rate per Hour: ").append(ratePerHour).append("\n");
        payslip.append("Gross Salary: ").append(formatCurrency(grossSalary)).append("\n");
        payslip.append("=============DEDUCTIONS===========\n");
        payslip.append("SSS: ").append(formatCurrency(sssContribution)).append("\n");
        payslip.append("PhilHealth: ").append(formatCurrency(philHealthContribution)).append("\n");
        payslip.append("Loans: ").append(formatCurrency(loans)).append("\n");
        payslip.append("Total Deductions: ").append(formatCurrency(totalDeductions)).append("\n");
        payslip.append("==========NET SALARY===============\n");
        payslip.append("Php. ").append(formatCurrency(netSalary)).append("\n");
        
        // Write the payslip to a text file
        try {
            FileWriter fileWriter = new FileWriter("payslip.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(payslip.toString());
            printWriter.close();
            System.out.println("Payslip generated successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        scanner.close();
    }
    
    private static String formatCurrency(double amount) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        return decimalFormat.format(amount);
    }
}
