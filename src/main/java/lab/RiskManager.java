package lab;

public class RiskManager implements FirewallObserver {

    @Override
    public void update(FirewallIncitent incitent) {
        System.out.println("Kill " + incitent.name());
    }
}
