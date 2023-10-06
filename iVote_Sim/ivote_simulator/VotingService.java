package ivote_simulator;// configure with the given question type
// candidate answers
// accept submission from students
    // a student can only submit one answrs
    // if multiple submissions are reciveved from smae student, only the last submission with count
// output the stats of submission results

import java.util.Map;
import java.util.HashMap;
public class VotingService {
    private Question question;

    private Map<String, Student> students;

    public VotingService(Question question){
        this.question = question;
        // Initialize student hashmap to store student answers
        this.students = new HashMap<>();
    }

    public void inputAnswer(Student student){
        // Store student id and print out the unique id and the answer that student choose
        students.put(student.getStudentID(), student);
        System.out.println("Student ID: " +  student.getStudentID() +
                "\nAnswer(s): " + student.getAnswers());
    }

    public void printStatistics() {
        Map<String, Integer> stats = new HashMap<>();
        // Stats on the answer chosen by students
        // Use getOrDefault method in HashMap get the value mapped with specified key
        for(Student student : students.values()){
            for(String answer : student.getAnswers()){
                stats.put(answer, stats.getOrDefault(answer, 0) + 1);
            }
        }
        // Print the choices for the answer
        for(String choices : question.getChoices()) {
            System.out.println(choices + ": " + stats.getOrDefault(choices, 0));
        }
    }

}