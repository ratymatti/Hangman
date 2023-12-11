public class HangmanFunctions {
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
