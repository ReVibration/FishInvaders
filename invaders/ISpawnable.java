package invaders;


/**
 * An ISpawnable is an object that can be 'spawned' - ie placed at a specific 'location'.
 * 
 * @author Marc Price 
 * @version 0.6
 */
public interface ISpawnable
{
    
    
    /**
     * Spawn the item at the given (x,y,z) coordinates
     * 
     * @param  coords    a double[] that holds the x,y,z coordinates
     */
    void spawn(double ...coords);
}
