public class HangmanFunctions {

    /**
     * Function getRandomIndex
     * @param usedIndexes
     * @param gameNumber
     * @return random number as an integer
     * 
     * Inside the function:
     *  1. generates random number
     *  2. if it's not the first game, checks that number has not been used before
     *  3. returns that random number
     */

    public static int getRandomIndex(int[] usedIndexes) {
        double randomNumber = Math.random() * StringArrays.words.length;

        if (usedIndexes.length > 0) {
            boolean isNotValidIndex = checkIndexes(usedIndexes, (int)randomNumber);

            while (isNotValidIndex) {
                randomNumber = Math.random() * StringArrays.words.length;
            
                isNotValidIndex = checkIndexes(usedIndexes, (int)randomNumber);
            }
        }

        return (int)randomNumber;
    }

    /**
     * Function convertToArray
     * @param word
     * @param visible
     * @return char array
     * 
     * Inside the function:
     *  1. creates new char array
     *  2. loops through parameter string 'word' and fills char array with those letters or '_', based on parameter visible
     *  3. returns that array 
     */

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

    /**
     * Function printArray
     * @param array
     * 
     * Inside the function:
     *  Prints arrays and adds space between letters
     */

    public static void printArray(char[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    /**
     * Function updateString
     * @param original
     * @param newLetter
     * @return string
     * 
     * Inside the function:
     *  1. returns new string based on parameter string original and adds parameter char newLetter to end of it
     */
    
    public static String updateString(String original, char newLetter) {
        return original + newLetter;
    }

    /**
     * Function checkIndexes
     * @param usedIndexes
     * @param currentRandomIndex
     * @return boolean 
     * 
     * Inside the function:
     *  1. creates boolean isUsedIndex as false
     *  2. loops through array usedIndexes and checks if it contains int currentRandomIndex and sets isUsedIndex as true and breaks if it does
     *  3. returns isUsedIndex as false or true
     */
    
    public static boolean checkIndexes(int[] usedIndexes, int currentRandomIndex) {
        boolean isUsedIndex = false;

        for (int i = 0; i < usedIndexes.length; i++) {
            if (usedIndexes[i] == currentRandomIndex) {
                isUsedIndex = true;
                break;
            }
        }

        return isUsedIndex;
    }

    /**
     * Function updateIndexTracking
     * @param usedIndexes
     * @param currentRandomIndex
     * @param gameNumber
     * @return int[] array
     * 
     * Inside the function:
     *  1. if gameNumber is bigger than 1, creates newIndexTrackingArray ands fills it with values from usedIndexes and adds currentRandomIndex to end of it
     *  2. returns newIndexTrackingArray
     *  3. if it's the first game (gameNumber > 1), changes usedIndex[0] to currentRandomIndex
     *  4. returns usedIndexes
     */

    public static int[] updateIndexTracking(int[] usedIndexes, int currentRandomIndex) {

        if (usedIndexes.length > 0) {
            int[] newIndexTrackingArray = new int[usedIndexes.length + 1];

            for (int i = 0; i < usedIndexes.length; i++) {
                newIndexTrackingArray[i] = usedIndexes[i];
            }

            newIndexTrackingArray[newIndexTrackingArray.length - 1] = currentRandomIndex;

            return newIndexTrackingArray;
        } else {
            int[] newIndexTrackingArray = new int[usedIndexes.length + 1];
            
            newIndexTrackingArray[0] = currentRandomIndex;

            return newIndexTrackingArray;
        }
    }
}
