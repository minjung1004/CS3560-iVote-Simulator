package ivote_simulator;// unqiue ID (String)
// submit an answer to iVote service
// Store student ID and their answers

import java.util.Set;
public class Student {
    private String studentID;
    private Set<String> answers;

    //Constructor for student with unique id as param
    public Student(String studentID){
        this.studentID = studentID;
    }

    //Get student unique Id.
    public String getStudentID() {
        return studentID;
    }

    //Set method for student answer
    public void setAnswers(Set<String> answers){
        this.answers = answers;
    }

    //Get student answer
    public Set<String> getAnswers(){
        return answers;
    }

}