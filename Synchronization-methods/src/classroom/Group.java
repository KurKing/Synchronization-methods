package classroom;

import java.security.PublicKey;
import java.util.*;

public class Group {

    private final String name;
    private final Map<String, Student> students;

    public Group(String name) {

        this.name = name;

        this.students = new HashMap<>();

        for (int i = 0; i < 10; i++) {

            Student student = new Student();
            students.put(student.getName(), student);
        }
    }

    public String getName() { return name; }
    public Student getStudent(String name) { return students.get(name); }
    public Collection<Student> getStudents() { return students.values(); }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Group " + name + " { " + students.values() + " }";
    }
}
