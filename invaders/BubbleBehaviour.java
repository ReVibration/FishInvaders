package invaders;

import com.jme3.math.Vector3f;
import collision.ICollidable;

/**
 * BubbleBehaviour - implements movement behaviour for all objects taking the role of 'Bubble'.
 * 
 * @author Fred Flintstone 
 * @version 0.1
 */
public class BubbleBehaviour extends Behaviour implements ISpawnable
{
    // class variables:
    //DECLARE a double to hold the speed of movement, call it _speed:
    private static double _speed = 0.05;
    
    // instance variables:
    //DECLARE a boolean that is true when collided, call it _collided:
    private boolean _collided = false;

    /**
     * Constructor for objects of class BubbleBehaviour
     */
    public BubbleBehaviour()
    {
        // CALL super:
        super();
    }

    
    /**
     * Method to respond to a collision.
     * 
     */
    public void collided()
    {
        // SET _collided to true:
        _collided = true;
    }
    
    /***
     * Spawn the item at the given (x,y,z) coordinates
     * 
     * @param  coords    a double[3] that holds the x,y,z coordinates
     */
    public void spawn(double ...coords)
    {
        _position = coords;
        _token.position(_position);
        
    }
    
    /**
     * METHOD: update behaviour simulation for next frame.
     * Bubble just moves vertically...
     * 
     */
    public boolean update()
    {
        // CHECK if it has collided:
        if (_collided)
        {
            //RESET _position to off-screen:
            _position[0] = 10.0;
            _position[1] = 10.0;
            _position[2] = 10.0;
            
            //RESET _collided:
            _collided = false;
        }
        else
        {
            // UPDATE the position:
            _position[1] += _speed;
        }
        
        //APPLY changes to token:
        _token.position(_position);
        
        return _isAlive;
    }
}
