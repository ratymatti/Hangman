public class HangmanFunctions {

    public static int getRandomIndex(int[] usedIndexes, int gameNumber) {
        double randomNumber = Math.random() * StringArrays.words.length;

        if (gameNumber > 1) {
            boolean isNotValidIndex = checkIndexes(usedIndexes, (int)randomNumber);

            while (isNotValidIndex) {
                randomNumber = Math.random() * StringArrays.words.length;
            
                isNotValidIndex = checkIndexes(usedIndexes, (int)randomNumber);
            }
        }

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

    public static int[] updateIndexTracking(int[] usedIndexes, int currentRandomIndex, int gameNumber) {

        if (gameNumber > 1) {
            int[] newIndexTrackingArray = new int[usedIndexes.length + 1];

            for (int i = 0; i < usedIndexes.length; i++) {
                newIndexTrackingArray[i] = usedIndexes[i];
            }

            newIndexTrackingArray[newIndexTrackingArray.length - 1] = currentRandomIndex;

            return newIndexTrackingArray;
        } else {
            usedIndexes[0] = currentRandomIndex;

            return usedIndexes;
        }
    }
}
