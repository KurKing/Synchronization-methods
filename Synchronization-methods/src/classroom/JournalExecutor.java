package classroom;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class JournalExecutor {

    public static void main(String[] args) throws InterruptedException {

        Journal journal = new Journal();

        Teacher[] teachers = new Teacher[]{
                new Teacher("Anna", true),
                new Teacher("Mark", false),
                new Teacher("Vlad", false),
                new Teacher("Inna", false)
        };

        ExecutorService pool = Executors.newFixedThreadPool(16);

        for (int week = 1; week <= 18; week++) {

            for (Group group: journal.getGroups()) {

                for (Student student : group.getStudents()) {

                    Random random = new Random();
                    int teacherIndex = random.nextInt(teachers.length);

                    pool.submit(teachers[teacherIndex].putMark(journal, group, student));
                }
            }
        }

        pool.shutdown();
        pool.awaitTermination(100L, TimeUnit.SECONDS);

        for (Group g: journal.getGroups()) {

            System.out.println(g);
        }
    }
}
