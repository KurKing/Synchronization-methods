package classroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Student {

    private final String name;
    private List<Mark> marks = new ArrayList<>();

    public Student() {
        this.name = "Student #" + UUID.randomUUID().toString().substring(0,5);
    }

    public synchronized void put(Mark mark) {
        marks.add(mark);
    }

    public String getName() { return name; }
    public synchronized List<Mark> getMarks() { return marks; }

    @Override
    public String toString() {
        return "\n\t"+name + " {marks=" + marks +"}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
