import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Dictionary;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TestTextblock {
    @Test
    public void TextblockBasicTest()
    {
        String block = "<NER> The quick brown fox jumps over the lazy dog </NER>";
        String blockWithoutWrapping = "The quick brown fox jumps over the lazy dog";
        Textblock textblock = new Textblock(block);
        assertThat(textblock.getTextblock(), is(blockWithoutWrapping));
        assertThat(textblock.getName(), is("The quick brown"));
    }

    
    @Test
    public void testDefault()
    {
        String block = "<NER> testing the set function </NER>";
        String blockWithoutWrapping = "testing the set function";
        Textblock textblock = new Textblock();
        textblock.setTextblock(block);
        assertThat(textblock.getTextblock(), is(blockWithoutWrapping));
    }



}
