package classroom;

import java.util.*;

public class Journal {

    private Map<String, Group> groupList = new HashMap<>();

    public Journal() {

        for (int i = 1; i <= 3; i++) {

            String groupName = "IT-0"+i;

            groupList.put(groupName, new Group(groupName));
        }
    }

    public Group getGroup(String name) {
        return groupList.get(name);
    }

    public Collection<Group> getGroups() {
        return groupList.values();
    }

    public List<Student> getAllStudents() {

        List<Student> students = new ArrayList<>(30);

        for (Group group: groupList.values()) {

            for (Student student: group.getStudents()) {

                students.add(student);
            }
        }

        return students;
    }
}
