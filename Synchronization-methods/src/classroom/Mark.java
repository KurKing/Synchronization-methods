package classroom;

public class Mark {

    private final int score;
    private final Teacher teacher;

    public Mark(int score, Teacher teacher) {

        this.score = score;
        this.teacher = teacher;
    }

    @Override
    public String toString() {

        return "\t{From: " + teacher.name() + " - " + score+"}";
    }
}
