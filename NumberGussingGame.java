/*
 * 				TASK 1. NUMBER GUESSING GAME
 * 
 * 1. Generate a random number within a specified range, such as 1 to 100.
 * 2. Prompt the user to enter their guess for the generated number.
 * 3. Compare the user's guess with the generated number and provide feedback on whether the guess
      is correct, too high, or too low.
 * 4. Repeat steps 2 and 3 until the user guesses the correct number.
 *    You can incorporate additional details as follows:
 * 5. Limit the number of attempts the user has to guess the number.
 * 6. Add the option for multiple rounds, allowing the user to play again.
 * 7. Display the user's score, which can be based on the number of attempts taken or rounds won.
 * */

package Codsoft_Java_NumberGuessing;

import java.util.Scanner;
import java.util.Random;

public class NumberGussingGame {
	public static void main(String[] args) {

		int minRange = 1; // Minimum range for the random generator
		int maxRange = 100; // Maximum range for the random generator
		int maxAttempt = 10; // Maximum number of attempts
		int round = 0; // Number of total round a player played
		int score = 0; // Total score obtained by the player

		boolean playAgain = true; // Flag to control if the player wants to play again

		// Create a scanner to get the user input
		Scanner s = new Scanner(System.in);
		// Create random for generate random number
		Random random = new Random();

		// Start a loop for each game round
		while (playAgain) {

			// Generate a random target number
			int TargetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
			System.out.println("You're in the Number guessing Game");
			System.out.println("I've selected the random number between " + minRange + " to " + maxRange);
			System.out.println("Try to find the number within 10 chances..!!");

			// Initialize a counter for guessing attempts
			int attempt = 0;
			// Flag to track if the correct number is guessed
			boolean correctGuess = false;

			// Loop until correct guess or max attempts
			while (!correctGuess && attempt < maxAttempt) {
				System.out.println("Enter your Guess...");
				// Read the user's guess
				int userGuess = s.nextInt();
				attempt++; // Increment the attempts counter

				if (userGuess < TargetNumber) {
					System.out.println("Your guess is too low..!, Try again..");
				} else if (userGuess > TargetNumber) {
					System.out.println("Your guess is too high..!, Try again..");
				} else {
					System.out.println("Congrats.. You guessed the correct number...!!");
					// Calculate and update the player's score
					score += maxAttempt - attempt + 1;
					// Set the guessedCorrectly flag to true
					correctGuess = true;
				}

			}
			// Increment the rounds counter
			round++;
			System.out.println("Do you want to play again (yes/no)");
			// Update the playAgain flag based on the response
			playAgain = s.next().equalsIgnoreCase("yes");

		}

		// Display final game results
		System.out.println("Game over!!.. You've played " + round + " rounds and your score is " + score);
		s.close();
	}
}
