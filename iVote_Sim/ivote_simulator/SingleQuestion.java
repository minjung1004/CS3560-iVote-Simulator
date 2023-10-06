package ivote_simulator;

import java.util.Set;
public class SingleQuestion implements Question {
    private String question;
    private Set<String> choices;

    public SingleQuestion(String question, Set<String> choices){
        this.question = question;
        this.choices = choices;
    }
    // Get quesiton
    @Override
    public String getQuestion() {
        return question;
    }
    // Set answer choices
    @Override
    public Set<String> getChoices() {
        return choices;
    }
    // isMultipleQ is false (this is ivote_simulator.SingleQuestion class)
    @Override
    public boolean isMultipleQ() {
        return false;
    }
}
