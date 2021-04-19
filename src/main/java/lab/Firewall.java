package lab;

import lombok.Getter;

import java.util.*;
import java.util.concurrent.TimeUnit;
@Getter
public class Firewall {
    private FirewallIncitent[] possibleIncidents = EnumSet.allOf(FirewallIncitent.class).toArray(new FirewallIncitent[0]);
    private Observers observers = new Observers();
    private Random fate = new Random();





    public void startFirewall() {
        int i = 0;
        for(;;) {
            try {
                Thread.sleep(TimeUnit.SECONDS.toMillis(2));
                FirewallIncitent justNow = possibleIncidents[fate.nextInt(200) % possibleIncidents.length];
                observers.notifyObservers(justNow);
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
