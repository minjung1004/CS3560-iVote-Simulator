package ivote_simulator;
import java.util.*;

// auto simulate the whole process
// 1. create question type and configure answers
// 2. configure the question from ivote services
// 3. randomly generate a num students and the answers
// 4. submit al students answers to ivote service
// 5. call voting service output function to display the result
public class SimulationDriver {
    public static void main(String[] args) {
        // 1. create question type and configure answers
        // Single-choice ivote_simulator.Question
        Question SingleQuestion = new SingleQuestion("What is 1+1?",
                new HashSet<>(Arrays.asList("A. 2", "B. 11", "C. 1", "D. 0")));
        // Multiple-choise ivote_simulator.Question
        Question MultipleQuestion = new MultipleQuestion("Which of these are animals?",
                new HashSet<>(Arrays.asList("A. Elephant", "B. Butterfly", "C. Fox", "D. Wolf", "E. Ants")));

        // 5. call voting service output function to display the result
        simulateVoting(SingleQuestion);
        simulateVoting(MultipleQuestion);

    }
    private static void simulateVoting(Question question){
        // 2. configure the question from ivote serves
        VotingService votingService = new VotingService(question);

        System.out.println("Q: " + question.getQuestion());
        System.out.println("Choices: " + question.getChoices());

        // 3. randomly generate a num students and the answers
        Random random = new Random();
        // 1 - 30 students
        int studentCnt = (int)(Math.random() * 30) +1  ;
        for(int numStudent = 0; numStudent < studentCnt; numStudent++){
            // create unqiue ID for students
            UUID id = UUID.randomUUID();
            Student student = new Student(id + " ");
            Set<String> answers = new HashSet<>();
            // If multiple-choice question, allow student to input more than one choice,
            // if not only allow one answer
            int numAnswers= question.isMultipleQ() ? random.nextInt(question.getChoices().size()) + 1 :1;
            List<String> choices = new ArrayList<>(question.getChoices());
            for(int pickAnswer = 0; pickAnswer < numAnswers; pickAnswer++ ){
                // 4. Submit all students answers to ivote service
                // The answer are randomly generated
                answers.add(choices.get(random.nextInt(choices.size())));
            }
            student.setAnswers(answers);
            votingService.inputAnswer(student);
        }
        System.out.println("------------------------------------------------");
        System.out.println("Total Students: " + studentCnt);
        votingService.printStatistics();
    }
}