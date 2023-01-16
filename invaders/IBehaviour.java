package invaders;

import Framework.IRenderable;
import collision.ICollisionMgr;

/**
 * IBehaviour: interface for behaviours.
 * 
 * @author Marc Price 
 * @version 0.5
 */
public interface IBehaviour
{
    /**
     * METHOD: Initialise fields of the IBehaviour
     * 
     * @param token a reference to the associated IRenderable instance
     * @param posn a double[3] that gives the x,y,z position coordinates of the associated token
     * @param angle a double[3] that gives the orientation about x,y,z axes of the associated token
     */
    void initialise(ICollisionMgr collision, IRenderable token,
                                                        double[] posn, double[] angle) throws NullPointerException;
    
    
    /**
     * METHOD: update behaviour simulation for next frame.
     * 
     * @return  a boolean - false indicates a request by this behaviour to be deleted.
     */
    boolean update();
    
    /**
     * METHOD: return true if the character is still alive, false if dead.
     * 
     * @return a boolean - false means that the character has died and needs to be deleted.
     */
    boolean isAlive();
}
