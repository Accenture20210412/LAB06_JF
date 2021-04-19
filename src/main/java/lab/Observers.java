package lab;

import lombok.Getter;

import java.util.LinkedList;
import java.util.List;
@Getter

public class Observers {
    private List<FirewallObserver> observers = new LinkedList<>();

    public void attach(FirewallObserver newObserver) {
        observers.add(newObserver);
    }

    public void detach(FirewallObserver observer) {
        observers.remove(observer);
    }

    public void display() {
        observers.forEach(System.out::println);
    }

    public void notifyObservers(FirewallIncitent incitent) {
        for (FirewallObserver observer : observers) {
            observer.update(incitent);
        }
    }
}
