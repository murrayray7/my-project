import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameDetector {
    // Regular expressions to match common words or phrases that might be confused with names
    private static final String[] COMMON_WORDS = { };
    
    // Method to detect names in a given sentence
    public static void detectNames(String sentence) {
        // Split the sentence into words
        String[] words = sentence.split("\\s+");        
        // Iterate through each word
        for (String word : words) {
            // Check if the word is a common word or phrase
            if (isCommonWord(word)) {
		System.out.println(word + " is a common word or phrase.");
            } else {
                // Assume it's a name for now
                System.out.println(word + " is likely a name.");
            }
        }
    }
    
    // Method to check if a word is a common word or phrase
    private static boolean isCommonWord(String word) {
        for (String common : COMMON_WORDS) {
            if (word.equalsIgnoreCase(common)) {
                return true;
            }
        }
        return false;
    }
    
}
