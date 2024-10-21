import java.util.*;
import java.util.stream.Collectors;

public class StreamExercise {

    public static void main(String[] args) {

        List<Student> studentList = Arrays.asList(
                new Student("Alice", Map.of("Maths", 85, "Science", 90, "English", 80)),
                new Student("Bob", Map.of("Maths", 78, "Science", 88, "English", 90)),
                new Student("Charlie", Map.of("Maths", 95, "Science", 85, "English", 80)),
                new Student("David", Map.of("Maths", 60, "Science", 70, "English", 65)),
                new Student("Anna", Map.of("Maths", 90, "Science", 92, "English", 88))
        );

        //get the highest average marks
        Optional<Student> op = studentList.stream()
                .max(Comparator.comparingDouble(s -> s.getSubjectMarks()
                        .values().stream()
                        .mapToInt(Integer :: intValue)
                        .average()
                        .orElse(0.0)
                ));

        System.out.println(op.get().getName());

        //get each student marked with its average marks

        Map<String, Double> averageMarks = studentList.stream()
                .collect(Collectors.toMap(
                        Student::getName,
                        student -> student.getSubjectMarks()
                                .values()
                                .stream()
                                .mapToInt(Integer::intValue)
                                .average()
                                .orElse(0.0) // Default to 0.0 if no subjects found
                ));

        // Print the average marks for each student
        averageMarks.forEach((name, avg) ->
                System.out.println(name + "'s average marks: " + avg));
        //find percentage of each student



    }
}
