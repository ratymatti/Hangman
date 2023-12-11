import java.util.Scanner;

public class Hangman {
    private static final int wrongAnswerLimit = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int randomIndex = HangmanFunctions.randomNumber();
        String hiddenWord = StringArrays.words[randomIndex];

        String wrongAnswerString = "";

        char[] wordArray = HangmanFunctions.convertToArray(hiddenWord, true); 
        char[] hiddenWordArray = HangmanFunctions.convertToArray(hiddenWord, false);
        char[] wrongAnswerArray = HangmanFunctions.convertToArray(wrongAnswerString, true);

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

        System.out.println();
        scanner.close();
    }    

}