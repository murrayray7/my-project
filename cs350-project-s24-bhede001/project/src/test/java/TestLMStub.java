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

public class TestLMStub {
    @Test
    public void LMStubBasicTest()
    {
        Textblock textblock = new Textblock("<NER> The quick brown fox jumps over the lazy dog </NER>");
        LMStub lm = new LMStub(textblock.getTextblock());
        assertThat(lm.contains("The"), is(true));
        assertThat(lm.contains("quick"), is(true));
        assertThat(lm.contains("brown"), is(true));
        assertThat(lm.getName(), is("The quick brown"));
    }
}
