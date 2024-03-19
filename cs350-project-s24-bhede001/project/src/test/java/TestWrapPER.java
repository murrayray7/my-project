import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Test;;

public class TestWrapPER {

    @Test
    public void testWrapName_ValidName() {
        String name = "John Doe";
        String expected = "<PER>John Doe</PER>";
        assertThat(WrapPER.wrapName(name), is(expected));
    }

    @Test
    public void testWrapName_InvalidName() {
        String name = "John-Doe";
        String expected = "John-Doe is NOT a valid personal name, therefore PER wrapping did not occur";
        assertThat(WrapPER.wrapName(name), is(expected));
    }

    @Test
    public void testWrapName_EmptyName() {
        String name = "";
        String expected = " is NOT a valid personal name, therefore PER wrapping did not occur";
        assertThat(WrapPER.wrapName(name), is(expected));
    }

    @Test
    public void testWrapName_AllSymbols() {
        String name = "@#$%";
        String expected = "@#$% is NOT a valid personal name, therefore PER wrapping did not occur";
        assertThat(WrapPER.wrapName(name), is(expected));
    }

    @Test
    public void testWrapName_MixedName() {
        String name = "John123";
        String expected = "John123 is NOT a valid personal name, therefore PER wrapping did not occur";
        assertThat(WrapPER.wrapName(name), is(expected));
    }

    @Test
    public void testWrapName_WhitespaceName() {
        String name = "    ";
        String expected = "     is NOT a valid personal name, therefore PER wrapping did not occur";
        assertThat(WrapPER.wrapName(name), is(expected));
    }
}
