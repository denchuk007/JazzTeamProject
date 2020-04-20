import java.time.LocalDate;
import java.util.List;

public class Teacher extends User {

    private List<Subject> subjects;
    private Classroom classroom;

    public Teacher(String name, LocalDate birthday, User.Role role, Classroom classroom) {
        super(name, birthday, role);
        this.classroom = classroom;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public Parent createParent(String name, LocalDate birthday, User.Role role, Pupil pupil) {
        return new Parent(name, birthday, role, pupil);
    }

    public Pupil createPupil(String name, LocalDate birthday, User.Role role) {
        return new Pupil(name, birthday, role, this.classroom);
    }

    public void addMark(Pupil pupil, Mark mark) {
        pupil.addMark(mark);
    }
}
