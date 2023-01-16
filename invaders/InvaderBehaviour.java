package invaders;

import com.jme3.math.Vector3f;
import Framework.ICoreMgr;
import collision.ICollidable;

/**
 * InvaderBehaviour - implements movement behaviour for all fish taking the role of 'Invader'.
 * 
 * @author Homer Simpson 
 * @version 0.1
 */
public class InvaderBehaviour extends Behaviour implements IEnemy
{
    // class variables:
    //DECLARE a double to hold the step-size of walk movement, call it _step:
    private static final double _step = 0.1;
    
    //DECLARE an int to hold the speed of walk movement, call it _speed:
    private static final int _speed = 40;
    
    //DECLARE a double to hold the direction of horizontal movement, call it '_direction':
    private static double _direction = 1.0;
    
    
    // instance variables:
    // DECLARE a reference to an ICoreMgr, call it _core:
    ICoreMgr _core;
    
    //DECLARE an int to store a counter that implements 'walk' behaviour, call it _walkTimeer:
    private int _walkTimer = 0;
    
    //DECLARE a boolean that is true when collided, call it _collided:
    private boolean _collided = false;
    

    /**
     * Constructor for objects of class InvaderBehaviour
     */
    public InvaderBehaviour()
    {
        // CALL super:
        super();
        
    }
    
    
    /**
     * Method to provide further initialisation - must be called prior to update
     * 
     * @param core a reference to the ICoreMgr
     */
    public void initialise(ICoreMgr core)
    {
        // ASSIGN _core to core:
        _core = core;

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
    
    /**
     * METHOD: update behaviour simulation for next frame.
     * Invader just moves horizontally...
     * To do: invaders need to move down a step each time they change direction.
     * 
     */
    public boolean update()
    {
        //CHECK if it has collided with a 'wall':
        if ((_direction < 0)&&(_position[0] < _limits[0]))
        {
            _direction = 1.0;
        }
        else if ((_direction > 0)&&(_position[0] > _limits[1]))
        {
            _direction = -1.0;
        }

        
        // CHECK if it has collided with anything other than a 'wall':
        if (_collided)
        {
            //RESET _isAlive to false:
            _isAlive = false;
            
            //REMOVE _token from scene:
            _core.removeRenderable(_token);
            
            //REMOVE this from CollisionMgr:
            _collision.removeCollidable((ICollidable)this);
        }
        
        // CHECK if _walkTimer has reached _speed:
        if (_walkTimer++ > _speed)
        {
            //UPDATE the position:
            _position[0] += _step*_direction;
            _token.position(_position);
            
            //RESET _walkTimer:
            _walkTimer = 0;
        }

        return _isAlive;
    }
}
