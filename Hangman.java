import java.util.Scanner;

public class Hangman {
    private static final int wrongAnswerLimit = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int randomIndex = randomNumber();
        String hiddenWord = StringArrays.words[randomIndex];

        String wrongAnswerString = "";

        char[] wordArray = convertToArray(hiddenWord, true); 
        char[] hiddenWordArray = convertToArray(hiddenWord, false);
        char[] wrongAnswerArray = convertToArray(wrongAnswerString, true);

        int wrongAnswerCount = 0;

        int lettersHidden = hiddenWord.length();

        while (true) {

            System.out.println(StringArrays.gallows[wrongAnswerCount]);

            System.out.print("Word: ");
            
            if (wrongAnswerCount == wrongAnswerLimit) {
                printArray(wordArray);
            } else {
                printArray(hiddenWordArray);
            }

            
            System.out.print("\n\nMisses: ");
            printArray(wrongAnswerArray);

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
                wrongAnswerString = updateString(wrongAnswerString, guessChar);
                wrongAnswerCount++;
            }

        }

        System.out.println();
        scanner.close();
    }

    /**
     * Move these functions below
     * @return
     */

    public static int randomNumber() {
        double randomNumber = Math.random() * StringArrays.words.length;
        return (int)randomNumber;
    }

    public static char[] convertToArray(String word, boolean visible) {
        char[] wordArray = new char[word.length()];

        if (visible) {
            for (int i = 0; i < word.length(); i++) {
                wordArray[i] = word.charAt(i);    
            }
        } else {
            for (int i = 0; i < word.length(); i++) {
                wordArray[i] = '_';
            }
        }

        return wordArray;
    }

    public static void printArray(char[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
    
    public static String updateString(String original, char newLetter) {
        String newString = original + newLetter;
        return newString;
    }

}