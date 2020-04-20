import java.time.LocalDate;

public class Mark {

    private LocalDate date;
    private short mark;
    private Subject subject;
    private Teacher teacher;

    public Mark(Teacher teacher, Subject subject, short mark) {
        this.teacher = teacher;
        this.subject = subject;
        this.mark = mark;
        date = LocalDate.now();
    }
}
