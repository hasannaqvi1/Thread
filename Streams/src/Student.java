import java.util.Map;

class Student {
    private String name;
    private Map<String, Integer> subjectMarks;

    // Constructor
    public Student(String name, Map<String, Integer> subjectMarks) {
        this.name = name;
        this.subjectMarks = subjectMarks;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for subjectMarks
    public Map<String, Integer> getSubjectMarks() {
        return subjectMarks;
    }
}
