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


    public void startFirewall() {
        for(;;) {
            try {
                Thread.sleep(TimeUnit.SECONDS.toMillis(2));
                FirewallIncitent justNow = possibleIncidents[fate.nextInt(200) % possibleIncidents.length];
                System.out.println(justNow.name());
                notifyObservers(justNow);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
