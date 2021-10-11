/**
 * Represents the AI that determines cannon targets/
 * @author henry
 * @version 1.0
 */
public abstract class AI {
    private boolean destructed;
    private Coordinates cannonTarget;
    private Coordinates secretHQ;
    private static final int SOME_CONSTANT = 20;
    
    /**
     * Constructs an AI with given arguments.
     * @param cannonTarget initial target that the AI is aimed at
     * @param secretHQ the location of the secret HQ
     */
    public AI(Coordinates cannonTarget, Coordinates secretHQ) {
        this.cannonTarget = cannonTarget;
        this.secretHQ = secretHQ;
    }
    
    /**
     * Swaps cannon target or self-destructs based on given conditions.
     * @param newCoords new coordinates to swap cannon target to
     * @return whether the cannon target was swapped
     */
    public boolean swapCannonTarget(Coordinates newCoords) {
        if(!destructed && !newCoords.equals(cannonTarget)) {
            if(shouldSwapCannonTarget()) {
                cannonTarget = newCoords;
                return true;
            }
            else if(shouldSelfDestruct()) {
                selfDestruct();
                return false;
            }
        }
        return false;
    }
    
    /**
     * Determines whether the cannon should change its target.
     * @return whether the cannon should change its target
     */
    public abstract boolean shouldSwapCannonTarget();
    
    /**
     * Sets destructed to false.
     */
    public void selfDestruct() {
        destructed = true;
    }
    /**
     * Determines whether the cannon should self-destruct.
     * @return whether the cannon should self-destruct
     */
    public abstract boolean shouldSelfDestruct();
    
    /**
     * @return whether the people cannon has self destructed
     */
    public boolean getDestructed() {
        return destructed;
    }
    
    /**
     * @return the coordinates of the cannon target
     */
    public Coordinates getCannonTarget() {
        return cannonTarget;
    }
    
    /**
     * @return the coordinates of the secret HQ
     */
    public Coordinates getSecretHQ() {
        return secretHQ;
    }
    
    /**
     * @return returns where the cannon is aimed at
     */
    @Override
    public String toString() {
        return "Dr. Chipotle's guacomole cannon is currently pointed at "+
                cannonTarget.toString();
    }
    
}
