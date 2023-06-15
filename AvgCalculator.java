import java.util.Scanner;

public class AvgCalculator {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int count = 0;

        System.out.print("[Enter 0 to stop] \nEnter numbers: \n");
        while (true) {
            int number = scanner.nextInt();

            if (number == 0) {
                break;
            }

            sum += number;
            count++;
        }
        scanner.close();

        if (count == 0) {
            System.out.print("No numbers were entered");
        }else{
            double average = (double) sum/count;
            System.out.println("Average: " + average);
        }
    }
}
