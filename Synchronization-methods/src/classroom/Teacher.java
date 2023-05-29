package classroom;

import java.util.Random;

public class Teacher {

    private final String name;
    private final boolean isLector;

    public Teacher(String name, boolean isLector) {

        this.name = name;
        this.isLector = isLector;
    }

    public String getName() {
        return name;
    }

    public PutMarkThread putMark(Journal journal, Group group, Student student) {

        Random random = new Random();
        Mark mark = new Mark(random.nextInt(1, 100), this);

        return new PutMarkThread(mark, group, journal, student);
    }
}
