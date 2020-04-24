package model;

import java.time.LocalDate;

public class Administrator extends User {

    public Administrator(String name, LocalDate birthday, User.Role role) {
        super(name, birthday, role);
    }

    public Classroom createClassroom(short digit, String word) {
        return new Classroom(digit, word);
    }

    public Subject createSubject(String title) {
        return new Subject(title);
    }

    public Teacher createTeacher(String name, LocalDate birthday, User.Role role, Classroom classroom) {
        return new Teacher(name, birthday, role, classroom);
    }

    public Pupil createPupil(String name, LocalDate birthday, User.Role role, Classroom classroom) {
        return new Pupil(name, birthday, role, classroom);
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
}
