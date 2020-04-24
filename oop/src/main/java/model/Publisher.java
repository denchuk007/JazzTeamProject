package model;

import java.util.ArrayList;
import java.util.List;

public class Publisher implements Observed {

    private static List<Observer> subscribers = new ArrayList<>();

    private Publisher() { }
    public static final Publisher INSTANCE = new Publisher();

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
