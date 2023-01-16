package input;


/**
 * The IInputListener interface, to be implemented by all listeners.
 * 
 * @author Marc Price 
 * @version 0.6
 */
public interface IInputListener
{
    /**
     * Method to handle an input event
     * 
     */
    void onInput(int... inputVal);
}
