
public class RogueAI extends AI {
    private int firewallProtection;
    private int alertLevel;
    private final int maxAlert;

    public RogueAI(int firewallProtection, int alertLevel, int maxAlert,
            Coordinates cannonTarget, Coordinates secretHQ) {
        super(cannonTarget, secretHQ);
        this.firewallProtection = firewallProtection;
        this.alertLevel = alertLevel;
        this.maxAlert = maxAlert;
    }

    public RogueAI(int firewallProtection, int maxAlert,
            Coordinates cannonTarget, Coordinates secretHQ) {
        super(cannonTarget, secretHQ);
        this.firewallProtection = firewallProtection;
        alertLevel = 0;
        this.maxAlert = maxAlert;
    }

    public RogueAI(int firewallProtection, Coordinates cannonTarget,
            Coordinates secretHQ) {
        super(cannonTarget, secretHQ);
        this.firewallProtection = firewallProtection;
        alertLevel = 0;
        maxAlert = 10;
    }

    public void lowerFirewall() {
        firewallProtection -= 2;
        alertLevel++;
    }

    public boolean shouldSwapCannonTarget() {
        return firewallProtection <= 0;
    }

    public boolean shouldSelfDestruct() {
        return alertLevel > maxAlert;
    }
    
    public int getFirewallProtection() {
        return firewallProtection;
    }
    
    public int getAlertLevel() {
        return alertLevel;
    }
    
    public int getMaxAlert() {
        return maxAlert;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", is at alert level 10 with firewall protection 5.";
    }

}
