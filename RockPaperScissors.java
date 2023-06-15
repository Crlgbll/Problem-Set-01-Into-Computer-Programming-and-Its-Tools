import java.util.Scanner;
public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("(rock, paper, scissors) \nEnter your choice: ");
        
        String userChoice = scanner.nextLine().toLowerCase();

        String computerChoice = generateComputerChoice();

        String result = determineWinner(userChoice, computerChoice);

        System.out.print("\nYour choice: " + userChoice);
        System.out.print("\nComputer choice: " + computerChoice);
        System.out.println(result);

        
        scanner.close();
    }

    private static String generateComputerChoice(){
        int randomNum = (int) (Math.random()*3);

        String[] choices = {"rock", "paper", "scissors"};

        return choices[randomNum];
    }

    private static String determineWinner(String userChoice, String computerChoice){
        if (userChoice.equals(computerChoice)) {
            return "\n\nResult: it's a tie";
        } else if(userChoice.equals("rock")) {
            if (computerChoice.equals("paper")) {
                return "\n\nResult: You Lose \n \tComputer Win";
            }else{
                return "\n\nResult: You Win! \n \tComputer Lose";
                
            }
        }else if(userChoice.equals("paper")){
            if(computerChoice.equals("scissors")){
                return "\n\nResult: You Lose! \n \tComputer Win";
            }else{
                return "\n\nResult: You Win! \n\tComputer Lose";
            }
        }else if(userChoice.equals("scissors")){
            if (computerChoice.equals("rock")) {
                return "\n\nResult: You Lose! \n\tComputer Win";
            } else {
                return "\n\nResult: You Win \n\tComputer Lose";
            }
        }else{
            return "\n\nResult: Invalid Choice. Try Again! [rock | paper | scissors]";
        }
    }
}
