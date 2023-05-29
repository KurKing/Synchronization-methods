package classroom;

public class PutMarkThread implements Runnable {

    private final Mark mark;
    private final Group group;
    private final Journal journal;
    private final Student student;

    public PutMarkThread(Mark mark, Group group, Journal journal, Student student) {
        this.mark = mark;
        this.group = group;
        this.journal = journal;
        this.student = student;
    }

    @Override
    public void run() {

        journal.getGroup(group.getName())
                .getStudent(student.getName())
                .put(mark);
    }
}
