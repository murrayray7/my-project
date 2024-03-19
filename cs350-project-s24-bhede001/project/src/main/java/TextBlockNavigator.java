import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class TextBlockNavigator {
    
    private List<String> textBlocks;

    public TextBlockNavigator() {
        textBlocks = new ArrayList<>();
    }

    public void runTextBlockNavigator(String filePath) {
        StringBuilder textBuilder = new StringBuilder();

        // Read the content of the file into the StringBuilder
        try {
            Scanner fileScanner = new Scanner(new File(filePath));
            while (fileScanner.hasNextLine()) {
                textBuilder.append(fileScanner.nextLine() + "\n");
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
            return;
        }
        
        // Convert StringBuilder to String that contains all the text from the file
        String text = textBuilder.toString();
        
        // Extracting text blocks from the string
        int start = text.indexOf("<NER>");
        while (start != -1) {
            int end = text.indexOf("</NER>", start);
            if (end != -1) {
                textBlocks.add(text.substring(start + 5, end));
                start = text.indexOf("<NER>", end);
            } else {
                // Break if there is no closing tag
                break;
            }
        }
        
        if (textBlocks.isEmpty()) {
            System.out.println("No text blocks found.");
            return;
        }

        // Navigate through the extracted text blocks
        Scanner scanner = new Scanner(System.in);
        int currentIndex = 0;

        System.out.println("Use 'n' to move to the next text block, 'p' for previous, or 'q' to quit.");

        while (true) {
            System.out.println("Current text block: " + textBlocks.get(currentIndex));
            System.out.print("Command: ");
            String command = scanner.nextLine();

            if ("n".equals(command)) {
                currentIndex = (currentIndex + 1) % textBlocks.size();
            } else if ("p".equals(command)) {
                currentIndex = (currentIndex - 1 + textBlocks.size()) % textBlocks.size();
            } else if ("q".equals(command)) {
                System.out.println("Exiting the navigator.");
                break;
            } else {
                System.out.println("Invalid command. Try again.");
            }
        }

        scanner.close();
    }
}
