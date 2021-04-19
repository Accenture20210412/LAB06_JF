package lab;

public class Main {

    public static void main(String[] args) {
        Firewall firewall = new Firewall();
        Logger logger = new Logger();
        RiskManager riskManager = new RiskManager();
        firewall.addObserver(logger);
        firewall.addObserver(riskManager);
        firewall.startFirewall();
        firewall.deactivateteObserber(riskManager);
        firewall.startFirewall();
        logger.displayIncidents();
    }
}
