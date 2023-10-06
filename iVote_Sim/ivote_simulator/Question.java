package ivote_simulator;

import java.util.Set;
// using interface because there is two type of questions asked:
// single answer and multiple answer
public interface Question{
    // Get the question
    String getQuestion();
    // Get the choices for the answer
    Set<String> getChoices();
    // Checking if the question is single or multiple-choice question
    boolean isMultipleQ();

}
