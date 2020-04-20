import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Parent extends User {

    private List<Pupil> pupils;

    public Parent(String name, LocalDate birthday, User.Role role, Pupil pupil) {
        super(name, birthday, role);
        pupils = new ArrayList<>();
        addPupil(pupil);
    }

    public List<Pupil> getPupils() {
        return pupils;
    }

    public void addPupil(Pupil pupil) {
        pupils.add(pupil);
    }
}
