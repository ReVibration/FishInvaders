package invaders;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import Framework.IRenderable;
import Framework.Renderable;
import collision.ICollisionMgr;

/**
 * BehaviourMgr: a manager of a set of IBehaviours.
 * 
 * @author Marc Price 
 * @version 0.6
 * 
 */
public class BehaviourMgr implements IBehaviourMgr
{
    // instance variables:
    // DECLARE a list that holds the behaviours, call it _behaviours:
    List<IBehaviour> _behaviours;
    
    // DECLARE a reference to an ICollisionMgr, call it _collision:
    ICollisionMgr _collision;

    /**
     * Constructor for objects of class BehaviourMgr
     */
    public BehaviourMgr(ICollisionMgr collision)
    {
        // initialise instance variables:
        // _behaviours:
        _behaviours = new ArrayList<IBehaviour>();
        
        // _collision:
        _collision = collision;
    }

    /**
     * Update all IBehaviours being managed, call on each pass through the update loop
     * 
     */
    public void update()
    {
        // UPDATE all behaviours:
        Iterator bIt = _behaviours.iterator();
        while (bIt.hasNext())
        {
            IBehaviour b = (IBehaviour) bIt.next();
            
            if (!b.update())
            {
                bIt.remove();
            }
        }

    }

    /**
     * Create a new behaviour, add it to the managed list, and return a reference to it.
     *
     * @param  rqdClass the implementation type of IBehaviour to be instantiated
     * @param  token   a reference to the token that the behaviour is for
     * @param  posn     a Double[3] that gives x,y,z coords of token
     * @param  angle    a Double[3] that gives orientation of token about x,y,z
     */
    public <T extends IBehaviour> IBehaviour createBehaviour(Class<T> rqdClass, IRenderable token, double[] posn, double[] angle) throws Exception
    {
        // INSTANTIATE new Behaviour, call it 'newBehaviour':
        T newBehaviour = rqdClass.newInstance();
            
        // INITIALISE newBehaviour:
        newBehaviour.initialise(_collision, token, posn, angle);
            
        // STORE newBehaviour in _behaviours:
        _behaviours.add(newBehaviour);
        
        // RETURN newBehaviour:
        return newBehaviour;
    }


}
