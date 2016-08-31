package nyc.c4q;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean playAgain = true;
        while(playAgain == true){
            Hangman hangman = new Hangman();
            while (hangman.getMisses() < 5) {
                hangman.printCurrentWord();
                hangman.promptPlayer("Enter a letter: ");
                hangman.readLetter();
                hangman.checkLetter();
                if (hangman.guessedSuccessfully()) {
                    break;
                }
                System.out.println(Drawing.get(hangman.getMisses()));
                System.out.println("Misses -> " + hangman.getMisses());
            }
            if (hangman.guessedSuccessfully()) {
                System.out.println("Success");
            } else {
                System.out.println("The answer was " + hangman.getSecretWord());
            }
            boolean isValidInput = false;
            do {
                System.out.println("Do you want to play again?");
                String userAnswer = scanner.next();
                userAnswer = userAnswer.toLowerCase();


                if (userAnswer.equals("yes") || userAnswer.equals("y")) {
                    isValidInput = true;
                    playAgain = true;

                } else if (userAnswer.equals("no") || userAnswer.equals("n")) {
                    isValidInput = true;
                    playAgain = false;

                } else {
                    System.out.println("That is not a valid input. Please try again.");
                    isValidInput = false;
                }
            }while (isValidInput == false);

        }
    }
}
