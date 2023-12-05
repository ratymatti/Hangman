import java.util.Scanner;

public class Hangman {
    private static final int wrongAnswerLimit = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int randomIndex = randomNumber();
        String hiddenWord = StringArrays.words[randomIndex];

        char[] wordArray = convertToArray(hiddenWord, true); 
        char[] hiddenWordArray = convertToArray(hiddenWord, false);
        

        int wrongAnswerCount = 0;
        String wrongAnswerString = "";

        int lettersHidden = hiddenWord.length();

        while (true) {

            System.out.println(StringArrays.gallows[wrongAnswerCount]);

            System.out.print("Word: ");
            
            if (wrongAnswerCount == wrongAnswerLimit) {
                printArray(wordArray);
            } else {
                printArray(hiddenWordArray);
            }

            char[] wrongAnswerArray = convertToArray(wrongAnswerString, true);
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

            
            String currentGuess = scanner.nextLine(); // Needs validating
            char guessChar = currentGuess.charAt(0);

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