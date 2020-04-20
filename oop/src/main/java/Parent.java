import java.time.LocalDate;
import java.util.*;

public class Parent extends User {

    private List<Pupil> pupils = new ArrayList<>();
    private List<String> notifications = new ArrayList<>();

    public Parent(String name, LocalDate birthday, User.Role role, Pupil pupil) {
        super(name, birthday, role);
        addPupil(pupil);
    }

    public List<Pupil> getPupils() {
        return pupils;
    }

    public void addPupil(Pupil pupil) {
        pupils.add(pupil);
    }

    public List<String> getNotifications() {
        return notifications;
    }

    public void handleEvent(Pupil pupil, Mark mark) {
        notifications.add("Message for " + this.getName() + " | New mark from " + pupil.getName() + ": Date(" +
                mark.getDate() + "), Subject(" + mark.getSubject().getTitle() + "), Mark(" +
                mark.getMark() + "), Teacher(" +  mark.getTeacher().getName() + ")");
    }
}
