package lab;

import java.util.LinkedList;
import java.util.List;

public class Logger implements FirewallObserver {
    List<String> incidents  = new LinkedList<>();

    @Override
    public void update(FirewallIncitent incitent) {
        incidents.add(incitent.name());
    }
}
