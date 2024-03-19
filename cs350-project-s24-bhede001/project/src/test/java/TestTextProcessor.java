import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

public class TestTextProcessor {

    @Test //test if it extracted correctly
    public void test_extraction() {
        String inputText = "This is a <NER>sample text</NER> with tags.";
        String expectedText = "sample text";
        String actual = TextProcessor.extractAndStoreText(inputText);
        assertEquals(expectedText, actual);
    }
    @Test //test for missing <NER>
    public void text_missing1() {
        String inputText = "This is a sample text</NER> with tags.";
        String expectedText = null;
        String actual = TextProcessor.extractAndStoreText(inputText);
        assertEquals(expectedText, actual);
    }
    @Test //test for missing </NER>
    public void test_missing2() {
        String inputText = "This is a <NER>sample text with tags.";
        String expectedText = null;
        String actual = TextProcessor.extractAndStoreText(inputText);
        assertEquals(expectedText, actual);
    }
    @Test //test if list has the correct extracted text
    public void test_extraction_list() {
        String inputText = "<NER> This is a sample text with tags. </NER>";
        TextProcessor.extractAndStoreText(inputText);
        List<String> actual = TextProcessor.getExtractedTextList();
        String expectedText = " This is a sample text with tags. ";
        assertEquals(expectedText, actual);
    }


}