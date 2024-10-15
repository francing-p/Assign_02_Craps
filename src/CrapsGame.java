import java.util.Scanner;
import java.util.Random;

public class CrapsGame {
    public static void main(String[] args) {
        // define variables + create instance of scanner and random
        Scanner in = new Scanner(System.in);
        Random dieRoll = new Random();
        String cont = "";
        do { // outer while loop -- keeps program going as long as user says 'y' or 'Y'
            int roll = dieRoll.nextInt(1, 7);
            int rollTwo = dieRoll.nextInt(1, 7);
            int sum = roll + rollTwo; // add two rolls together
            if ((sum == 2) || (sum == 3) || (sum == 12)) {
                System.out.println("You rolled a " + sum + ". Craps. You lost...");
            } else if ((sum == 7) || (sum == 11)) {
                System.out.println("You rolled a " + sum + ". Natural. You win! ");
            } else {
                System.out.println("The point is now: " + sum);
                int point = sum; // define the sum as the new point for the user
                sum = 0; // reset the sum
                while (sum!=point) { // if user doesn't get a 2, 3, 12, 7, or 11, this loop runs
                    roll = dieRoll.nextInt(1, 7);
                    rollTwo = dieRoll.nextInt(1, 7);
                    sum = roll + rollTwo;
                    if ((sum == point)) {
                        System.out.println("You rolled a " + sum + ". You win!");
                    } else if ((sum == 7)) {
                        System.out.println("You rolled a(n) " + sum + ". You lost...");
                        sum=point; // stops the while loop even though the user didn't actually meet the point
                    } else {
                        System.out.println("You got a " + sum + " and did not make the point. Trying again...");
                    }
                }
               // while(!done);
            }
            System.out.print("Would you like to play again? [Y/N] ");
            if (in.hasNextLine()) {
                cont = in.nextLine();
            }
        }
        while(cont.equalsIgnoreCase("Y")); // play again if 'y' or 'Y'
    }
}
