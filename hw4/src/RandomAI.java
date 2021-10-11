import java.util.Random;
/**
 * An AI that isn't very smart with a 50/50 chance of swapping, with a 50%
 * chance to self-destruct on failure.
 * 
 * @author henry
 * @version 1.0
 */
public class RandomAI extends AI {
    private static final Random randomizer = new Random();
    
    /**
     * Constructs a RandomAI with the given arguments.
     * @param cannonTarget what target the cannon is aiming at.
     * @param secretHQ the secret HQ
     */
    public RandomAI(Coordinates cannonTarget, Coordinates secretHQ) {
        super(cannonTarget, secretHQ);
    }

    
    /**
     * @return whether the RandomAI should swap its target
     */
    @Override
    public boolean shouldSwapCannonTarget() {
       return randomizer.nextBoolean();
    }
    
    /**
     * @return whether the RandomAI should self-destruct
     */
    @Override
    public boolean shouldSelfDestruct() {
        return randomizer.nextBoolean();
    }
    
    
}
