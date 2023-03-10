package input;


/**
 * IInputPublisher: publishes input events to all listeners.
 * 
 * @author Marc Price 
 * @version 0.6
 */
public interface IInputPublisher
{
    /**
     * METHOD: Subscribe a new listener for input events
     *
     * @param  l   a reference to the listener that is being subscribed
     */
    public void subscribe(IInputListener l);

    /**
     * METHOD: Unsubscribe a listener
     *
     * @param  l   a reference to the listener that is being unsubscribed
     */
    public void unsubscribe(IInputListener l);

    /**
     * METHOD: Update the input publisher state - must be called on each pass through main control loop
     */
    public void update();
}
