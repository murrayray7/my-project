public class WrapPER {

    public static String wrapName(String name) {
        if (isPersonalName(name)) {
            return "<PER>" + name + "</PER>";
        }
        else {
            return name + " is NOT a valid personal name, therefore PER wrapping did not occur";
        }
    }

    private static boolean isPersonalName(String word) {
        boolean result = word.matches("[A-Za-z]+(\\s[A-Za-z]+)?");
        System.out.println("Word: " + word + ", Result: " + result);
        return result;
    }
    
    
    
    public static void main(String[] args) {
        String name = "John Doe";
        String wrappedName = wrapName(name);
        System.out.println(wrappedName);
    }
}
