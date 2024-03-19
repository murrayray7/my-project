public class Textblock {

    private String inputtedTextBlock;
    private String wordsInsideTextBlock;
    private String Name;

    /*
     * Default constructor for texblock
     */
    public Textblock() {
        inputtedTextBlock="";
        wordsInsideTextBlock = "";
        Name = "";        
    }
    
    /*
     * Construct a textblock from a string of words
     */
    public Textblock(String block) {
            inputtedTextBlock=block;
            wordsInsideTextBlock = inputtedTextBlock.replaceAll("<NER>", "").replaceAll("</NER>", "");
            wordsInsideTextBlock = wordsInsideTextBlock.trim();
            LMStub LM = new LMStub(wordsInsideTextBlock);
            Name = LM.getName();
            
        }

    /*
     * Returns the words that were inside the wrapping
     */
    public String getTextblock() {
        return wordsInsideTextBlock;
    }

    /*
     * Returns the name that was identified in the LM
     */
    public String getName() {
        return Name;
    }

    /*
     * stores block in inputtedTextBlock and also sets the words inside the wrapping
     *  in wordsInsideTextBlock
     */
        public void setTextblock(String block) {
        this.inputtedTextBlock = block;
        wordsInsideTextBlock = inputtedTextBlock.replaceAll("<NER>", "").replaceAll("</NER>", "");
        wordsInsideTextBlock = wordsInsideTextBlock.trim();
    }
}
