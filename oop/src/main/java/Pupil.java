import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pupil extends User {

    private Classroom classroom;
    private List<Mark> marks = new ArrayList<>();

    public Pupil(String name, LocalDate birthday, Role role, Classroom classroom) {
        super(name, birthday, role);
        this.classroom = classroom;
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void addMark(Mark mark) {
        marks.add(mark);
    }
}
