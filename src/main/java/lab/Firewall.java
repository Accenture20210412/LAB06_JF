package lab;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Firewall {
    private FirewallIncitent[] possibleIncidents = EnumSet.allOf(FirewallIncitent.class).toArray(new FirewallIncitent[0]);

    private Random fate = new Random();
    private List<FirewallObserver> observers = new LinkedList();

    private void notifyObservers(FirewallIncitent incitent) {
        for (FirewallObserver i : observers) {
            i.update(incitent);
        }
    }

    public void addObserver(FirewallObserver observer) {
        observers.add(observer);
    }
    public void deactivateteObserber(FirewallObserver observer) {
        observers.remove(observer);
    }


    public void startFirewall() {
        int i = 0;
        for(;;) {
            try {
                Thread.sleep(TimeUnit.SECONDS.toMillis(2));
                FirewallIncitent justNow = possibleIncidents[fate.nextInt(200) % possibleIncidents.length];
                notifyObservers(justNow);
                i++;
                if (i > 5) {
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
