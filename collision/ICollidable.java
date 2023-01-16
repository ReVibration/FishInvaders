package collision;
import com.jme3.math.Vector3f;

/**
 * ICollidable: something that can collide with another.
 * 
 * @author Marc Price 
 * @version 0.6
 */
public interface ICollidable
{
    /**
     * Method to return ICollidable position as a jme3 Vector3f
     * 
     * @return        the ICollidable's position 
     */
    Vector3f position();
    
    /**
     * Method to signal a collision
     * 
     */
    void collided();
}
