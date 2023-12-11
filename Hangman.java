import java.util.Scanner;

public class Hangman {
    private static final int wrongAnswerLimit = 6;

    public static void main(String[] args) {
        boolean isPlaying = true;
        Scanner scanner = new Scanner(System.in);
        

        while (isPlaying) {
            int randomIndex = HangmanFunctions.randomNumber();
            String hiddenWord = StringArrays.words[randomIndex];

            char[] wordArray = HangmanFunctions.convertToArray(hiddenWord, true); 
            char[] hiddenWordArray = HangmanFunctions.convertToArray(hiddenWord, false);
            String wrongAnswerString = "";

            int wrongAnswerCount = 0;

            int lettersHidden = hiddenWord.length();

            while (true) {

                System.out.println(StringArrays.gallows[wrongAnswerCount]);

                System.out.print("Word: ");

                if (wrongAnswerCount == wrongAnswerLimit) {
                    HangmanFunctions.printArray(wordArray);
                } else {
                    HangmanFunctions.printArray(hiddenWordArray);
                }

                char[] wrongAnswerArray = HangmanFunctions.convertToArray(wrongAnswerString, true);
                System.out.print("\n\nMisses: ");
                HangmanFunctions.printArray(wrongAnswerArray);

                System.out.print("\n\nGuess: ");

                if (lettersHidden == 0) {
                    System.out.println("\n\nYou won!");
                    break;
                }

                if (wrongAnswerCount == wrongAnswerLimit) {
                    System.out.println("\n\nYou lose!");
                    break;
                }

                char guessChar = ' ';

                while (guessChar == ' ') {
                    try {
                        String currentGuess = scanner.nextLine().toLowerCase();

                        if (currentGuess.matches("[a-z]")) {
                            guessChar = currentGuess.charAt(0);
                        } else {
                            System.out.print("Invalid input. Please enter a letter: ");
                        }

                    } catch (IndexOutOfBoundsException e) {
                        System.out.print("Invalid input. Please enter a letter: ");
                    }
                }

                int matchesFound = 0;

                for (int i = 0; i < wordArray.length; i++) {
                   if (wordArray[i] == guessChar) {
                        hiddenWordArray[i] = wordArray[i];
                        matchesFound++;
                        lettersHidden--;
                   } 
                }

                if (matchesFound == 0) {
                    wrongAnswerString = HangmanFunctions.updateString(wrongAnswerString, guessChar);
                    wrongAnswerCount++;
                }

            }

            System.out.print("\nWant to play again? (yes/no) ");

            while (isPlaying) {
                String isNewGame = scanner.nextLine().toLowerCase();

                if (isNewGame.equals("no")) {
                    isPlaying = false;
                    System.out.println("\nGoodbye!\n");
                } else if (isNewGame.equals("yes")) {
                    break;
                } else {
                    System.out.print("\nPlease enter 'yes' or 'no': " );
                }
            }
        }

        scanner.close();
    }    

}