import java.util.HashSet;

public class LMStub {
    private String inputtedString;
    private HashSet<String> Names;

    public LMStub(String string) {
        inputtedString = string;
        Names = new HashSet<>();
        String[] seperatedWords = string.split("\\s+");
        Names.add(seperatedWords[0]);
        Names.add(seperatedWords[1]);
        Names.add(seperatedWords[2]);

    }   
    
    
    public boolean contains(String string) {
        return Names.contains(string);
    }


    public String getName() {
        StringBuilder outputStringBuilder = new StringBuilder();
        for (String name : Names) {
            outputStringBuilder.append(name).append(" ");
        }
        String fullName = outputStringBuilder.toString();
        fullName = fullName.trim();
        return fullName;
    }    
}