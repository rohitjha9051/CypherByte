import java.util.Random;
import javax.swing.JOptionPane;
public class GuessTheNumber {
    public static void main(String[] args) {
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int totalRounds = 3;
        int maxAttempts = 5;
        int totalScore = 0;
        JOptionPane.showMessageDialog(null, "Welcome to Guess the Number!\nYou need to guess a number between "
                + minRange + " and " + maxRange + ".\nYou have " + maxAttempts + " attempts in each round.");
        for (int round = 1; round <= totalRounds; round++) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean guessedCorrectly = false;
            JOptionPane.showMessageDialog(null, "Round " + round + ":");
            while (attempts < maxAttempts) {
                String userInput = JOptionPane.showInputDialog("Enter your guess:");
                int userGuess = Integer.parseInt(userInput);
                attempts++;
                if (userGuess == targetNumber) {
                    guessedCorrectly = true;
                    break;
                } else if (userGuess < targetNumber) {
                    JOptionPane.showMessageDialog(null, "Your guess is too low.");
                } else
                    JOptionPane.showMessageDialog(null, "Your guess is too high.");
            }
            if (guessedCorrectly) {
                int roundScore = maxAttempts - attempts + 1;
                totalScore += roundScore;
                JOptionPane.showMessageDialog(null,
                        "Congratulations! You guessed the number in " + attempts + " attempts.\nRound Score: " + roundScore);
            } else
                JOptionPane.showMessageDialog(null,
                        "Sorry, you couldn't guess the number. The correct number was: " + targetNumber);
        }
        JOptionPane.showMessageDialog(null, "Game Over!\nTotal Score: " + totalScore);
    }
}