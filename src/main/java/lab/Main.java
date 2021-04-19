package lab;

public class Main {

    public static void main(String[] args) {
        Firewall firewall = new Firewall();
        Logger logger = new Logger();
        RiskManager riskManager = new RiskManager();
        firewall.getObservers().attach(logger);
        firewall.getObservers().attach(riskManager);
        firewall.startFirewall();
        firewall.getObservers().detach(riskManager);
        firewall.startFirewall();
        logger.displayIncidents();
    }
}
