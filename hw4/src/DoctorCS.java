
public class DoctorCS {
    private AI ai;
    private String secretIdentity;
    private int jlaid;
    private boolean safe;

    public DoctorCS(AI ai, String secretIdnetity, int jlaid) {
        this.ai = ai;
        this.secretIdentity = secretIdentity;
        this.jlaid = jlaid;
        safe = false;
    }

    public AI getAI() {
        return ai;
    }

    public int getJlaid() {
        return jlaid;
    }

    public void saveTheDay() {
        if(ai instanceof RogueAI) {
            RogueAI rogue = (RogueAI) ai;
            while(rogue.getFirewallProtection()>0) {
                rogue.lowerFirewall();
            }
        }
        ai.swapCannonTarget(ai.getSecretHQ());
    }

    public String getStatus() {
        return (safe) ? "Doctor CS has saved the day"
                : "Dr. Chipotle has succeeded in his plan...";
    }

    public String toString() {
        return secretIdentity+" aka Doctor CS with JLAID: "+jlaid;
    }
}
