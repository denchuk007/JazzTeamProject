package model;

import java.time.LocalDate;

public class Mark {

    private LocalDate date;
    private short value;
    private Subject subject;
    private Teacher teacher;

    public Mark(Teacher teacher, Subject subject, short value) {
        this.teacher = teacher;
        this.subject = subject;
        this.value = value;
        date = LocalDate.now();
    }

    public LocalDate getDate() {
        return date;
    }

    public short getValue() {
        return value;
    }

    public Subject getSubject() {
        return subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }
}
