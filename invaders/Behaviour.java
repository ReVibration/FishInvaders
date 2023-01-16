package invaders;

import com.jme3.math.Vector3f;
import Framework.*;
import collision.*;

/**
 * Behaviour - implements invader behaviours.
 * 
 * @author Marc Price
 * @version 0.5
 */
public abstract class Behaviour implements IBehaviour, ICollidable
{
    // class constants:
    //DECLARE a double[2] to represent the left- and right- hand side of the display, call it _limits:
    protected static final double[] _limits = {0.9,9.1};
    
    // instance variables:
    // DECLARE a reference to an ICollisionMgr, call it _collision:
    protected ICollisionMgr _collision;
    
    // DECLARE a 3 element array of Doubles to store position (x,y,z) coordinates, call it _position,
    // and initialise it to 1,1,1:
    protected double[] _position = {1.0,1.0,1.0};
    
    // DECLARE a 3 element array of Doubles to store orientation (x,y,z) angles (in degrees),
    // call it _orientation, and initialise it to 0,0,0:
    protected double[] _orientation = {0.0,0.0,0.0};

    // DECLARE reference to the associated IRenderable, call it '_token':
    protected IRenderable _token;
    
    // DECLARE a boolean that is false when the instance is set to be deleted, call it '_isAlive'.
    protected boolean _isAlive = true;


    /**
     * Constructor for objects of class Behaviour
     */
    public Behaviour()
    {
    
    }
    

    /**
     * METHOD: Initialise fields of the IBehaviour
     * 
     * @param token a reference to the associated IRenderable instance
     * @param posn a double[3] that gives the x,y,z position coordinates of the associated token
     * @param angle a double[3] that gives the orientation about x,y,z axes of the associated token
     */
    public void initialise(ICollisionMgr collision, IRenderable token,
                                                            double[] posn, double[] angle) throws NullPointerException
    {
        // ASSIGN _collision to collision:
        _collision = collision;
        
        // CHECK: do nothing else if token is null:
        if (token != null)
        {
            // SET the new position:
            _position = posn;
        
            // SET the new orientation:
            _orientation = angle;
        
            // SET reference to associated token:
            _token = token;
        }
    }
    
    /**
     * METHOD: update the IBehaviour simulation for next frame - must be implemented by all subclasses.
     * 
     * @return  a boolean - false indicates a request by this behaviour to be deleted.
     * 
     */
    public abstract boolean update();
    
    /**
     * Method to return ICollidable position as a jme3 Vector3f
     * 
     * @return        the ICollidable's position 
     */
    public Vector3f position()
    {
        Vector3f rtnVal = new Vector3f((float)_position[0], (float)_position[1], (float)_position[2]);
        return rtnVal;
    }
    
    /**
     * Method to respond to a collision - must be implemented by all subclasses.
     * 
     */
    public abstract void collided();
        
    /**
     * METHOD: return true if the character is still alive, false if dead.
     * 
     * @return a boolean - false means that the character has died and needs to be deleted.
     */
    public boolean isAlive()
    {
        return _isAlive;
    }
}
