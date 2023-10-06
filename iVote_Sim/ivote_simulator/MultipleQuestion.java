package ivote_simulator;

import java.util.Set;
public class MultipleQuestion implements Question {
    private String question;
    private Set<String> choices;

    public MultipleQuestion(String question, Set<String> choices){
        this.question = question;
        this.choices = choices;
    }
    // Get question
    @Override
    public String getQuestion() {
        return question;
    }
    // Set answer choices
    @Override
    public Set<String> getChoices() {
        return choices;
    }
    //isMultipleQ is true
    @Override
    public boolean isMultipleQ() {
        return true;
    }
}
