package input;


import java.util.List;
import java.util.ArrayList;
import env3d.Env;
import Framework.ICoreMgr;

/**
 * Handles Keyboard Events for specific keys.
 * 
 * @author Marc Price 
 * @version 0.6
 */
public class KeybHandler implements IInputPublisher
{
    // instance variables:
    // DECLARE a list of IInputListener to store the event listener methods, call it _listeners:
    private List<IInputListener> _listeners;    
    
    // DECLARE a reference to the ICoreMgr instance, call it _core:
    ICoreMgr _core;
    

    /**
     * Constructor for objects of class KeybHandler
     */
    public KeybHandler(ICoreMgr core)
    {
        // initialise instance variables:
        //INSTANTIATE listeners list:
        _listeners = new ArrayList<IInputListener>();
        
        //ASSIGN core to _core:
        _core = core;
    }

    /**
     * METHOD: Subscribe a new listener for keyboard events
     *
     * @param  l   a reference to the listener that is being subscribed
     */
    public void subscribe(IInputListener l)
    {
        // ADD new listener to the listeners list:
        _listeners.add(l);
    }

    /**
     * METHOD: Unsubscribe a listener
     *
     * @param  l   a reference to the listener that is being unsubscribed
     */
    public void unsubscribe(IInputListener l)
    {
        // ADD new listener to the listeners list:
        _listeners.remove(l);
    }

    /**
     * METHOD: Update the Keyboard state
     *
     */
    public void update()
    {
        // IF a key is pressed...
        int rtnVal = _core.world().getKeyDown();
        if (rtnVal > 0)
        {
            // PASS it via an event to all listeners:
            for (IInputListener l : _listeners)
                l.onInput(rtnVal);
        }
    }
}
