package invaders;

import com.jme3.math.Vector3f;
import input.IInputListener;
import collision.ICollidable;
import Framework.IRenderableFactory;
import Framework.IRenderable;

/**
 * PlayerBehaviour - implements movement behaviour for the fish taking the role of 'Player'.
 * 
 * @author Marc Price 
 * @version 0.1
 */
public class PlayerBehaviour extends Behaviour implements IInputListener, IPlayer
{
    // class variables:
    //DECLARE a double to hold the speed of movement, call it speed:
    private static double _speed = 0.05;
    
    //DECLARE a String that points to the model for a new bubble, call it _bubbleModel:
    private static String _bubbleModel = "sphere";
    
    //DECLARE a String that points to the texture for a new bubble, call it _bubbleTex:
    private static String _bubbleTex = "textures/javaFish/Bubble.png";
    
    //DECLARE a double that holds the height at which a bubble should be offset to when 'fired', call it _bubbleStartOffset:
    //(This prevents it colliding with the player token when it is fired)
    private static double _bubbleStartOffset = 0.5;
    
    // instance variables:
    // DECLARE a reference to the IBehaviourMgr, call it _behaviours:
    private IBehaviourMgr _behaviours;
    
    // DECLARE a reference to the IRenderableFactory, call it _thingMaker:
    private IRenderableFactory _thingMaker;
    
    //DECLARE reference to a bubble, call it _bubble:
    private IBehaviour _bubble;
    
    //DECLARE a boolean that is true when collided, call it _collided:
    private boolean _collided = false;
    
    // DECLARE a boolean that true when the player needs t
    
    //DECLARE a double to hold the next step change in position:
    private double _changePosn = 0.0;
    
    /**
     * Constructor for objects of class PlayerBehaviour
     */
    public PlayerBehaviour()
    {
        // CALL super:
        super();
    }
    
    
    /**
     * METHOD: Initialise fields
     * 
     * @param behaviours a reference to the IBehaviourMgr instance
     * @param thingMaker a reference to the IRenderableFactory instance
     */
    public void initialise(IBehaviourMgr behaviours, IRenderableFactory thingMaker)
    {   
        // ASSIGN behaviours to _behaviours:
        _behaviours = behaviours;
        
        // ASSIGN thingMaker to _thingMaker:
        _thingMaker = thingMaker;
        
        // CREATE the bubble that will be used as ammo:
        try
        {
            // CREATE new bubble token (off-screen):
            double[] posn = {10.0,10.0,10.0};
            double[] angle = {-90.0,90.0,0.0};
            IRenderable token = _thingMaker.createRenderable(_bubbleModel, _bubbleTex, posn, angle, 0.1);
        
            // CREATE associated behaviour:
            _bubble = _behaviours.createBehaviour(BubbleBehaviour.class, token, posn, angle);
        
            // ADD it to collision manager:
            _collision.addCollidable((ICollidable) _bubble);
        }
        catch (Exception e)
        {
            // do nothing!
        }
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
     * Player just moves horizontally...
     * 
     */
    public boolean update()
    {
        // CHECK if it has collided:
        if (_collided)
        {
            //RESET _collided:
            _collided = false;
            
            // do nothing just yet
        }

        // MOVE paddle if it is within the display limits:
        double newPosn = _position[0] + _changePosn;
        
        //if ((_position[0] > _limits[0])&&(_position[0] < _limits[1]))
        if ((newPosn > _limits[0])&&(newPosn < _limits[1]))
        {
            //CHANGE x position:
            _position[0] += _changePosn;
            _token.position(_position);
        }
                    
        //RESET _changePosn to zero:
        _changePosn = 0.0;
        
        return _isAlive;
    }


    /**
     * Method to handle a keyboard input (IInputListener)
     * 
     */
    public void onInput(int... inputVal)
    {
        // space = 57, right = 205, left = 203
        switch (inputVal[0])
        {
            case 205:   _changePosn = _speed;
                        break;
            case 203:   _changePosn = -_speed;
                        break;
            case 57:    releaseBubble();
                        break;
            default:
                        break;
        }

    }
    
    /**
     * Method to create a bubble
     * 
     */
    private void releaseBubble()
    {
        double[] posn = {_position[0], _position[1]+_bubbleStartOffset, 1.0};
        ((ISpawnable)_bubble).spawn(posn);
    }
}
