package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Teacher extends User {

    private List<Subject> subjects = new ArrayList<>();
    private Classroom classroom;

    public Teacher(String name, LocalDate birthday, User.Role role, Classroom classroom) {
        super(name, birthday, role);
        this.classroom = classroom;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public Pupil createPupil(String name, LocalDate birthday, User.Role role) {
        return new Pupil(name, birthday, role, this.classroom);
    }

    public Parent createParent(String name, LocalDate birthday, User.Role role, Pupil pupil) {
        Parent parent = new Parent(name, birthday, role, pupil);
        Publisher.INSTANCE.addObserver(parent);
        return parent;
    }

    public void addMark(Pupil pupil, Mark mark) {
        pupil.addMark(mark);
        Publisher.INSTANCE.notifyObservers(pupil, mark);
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public void removeSubject(Subject subject) {
        subjects.remove(subject);
    }
}
