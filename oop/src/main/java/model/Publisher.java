package model;

import java.util.ArrayList;
import java.util.List;

public class Publisher implements Observed {

    private static List<Observer> subscribers = new ArrayList<>();

    private Publisher() { }
    public static final Publisher INSTANCE = new Publisher();

//    public static void addParent(Parent parent) {
//        subscribers.add(parent);
//    }
//
//    public static void removeParent(Parent parent) {
//        subscribers.remove(parent);
//    }
//
//    public static void notifyParents(Pupil pupil, Mark mark) {
//        for (Parent subscriber : Publisher.subscribers) {
//            for (int i = 0; i < subscriber.getPupils().size(); i++) {
//                if (subscriber.getPupils().get(i).equals(pupil)) {
//                    subscriber.handleEvent(pupil, mark);
//                }
//            }
//        }
//    }

    @Override
    public void addObserver(Observer observer) {
        subscribers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        subscribers.remove(observer);
    }

    @Override
    public void notifyObservers(Pupil pupil, Mark mark) {
        for (Observer observer : subscribers) {
            observer.handleEvent(pupil, mark);
        }
    }
}
