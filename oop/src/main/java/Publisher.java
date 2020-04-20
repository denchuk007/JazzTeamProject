import java.util.ArrayList;
import java.util.List;

public class Publisher {

    static List<Parent> subscribers = new ArrayList<>();

    public static void addParent(Parent parent) {
        subscribers.add(parent);
    }

    public static void removeParent(Parent parent) {
        subscribers.remove(parent);
    }

    public static void notifyParents(Pupil pupil, Mark mark) {
        for (Parent subscriber : Publisher.subscribers) {
            for (int i = 0; i < subscriber.getPupils().size(); i++) {
                if (subscriber.getPupils().get(i).equals(pupil)) {
                    subscriber.handleEvent(pupil, mark);
                }
            }
        }
    }
}
