package lab;

import java.util.LinkedList;
import java.util.List;

public class Logger implements FirewallObserver {
    private List<String> incidents  = new LinkedList<>();

    public void displayIncidents() {
        incidents.forEach(System.out::println);
    }

    @Override
    public void update(FirewallIncitent incitent) {
        incidents.add(incitent.name()   );
    }
}
