package invaders;

import Framework.IRenderable;


/**
 * IBehaviourMgr: implementations manage a set of IBehaviours.
 * 
 * @author Marc Price 
 * @version 0.6
 * 
 */
public interface IBehaviourMgr
{
    /**
     * Update all IBehaviours being managed, call on each pass through the update loop
     * 
     */
    public void update();
    
    /**
     * Create a new behaviour, add it to the managed list, and return a reference to it.
     *
     * @param  rqdClass the implementation type of IBehaviour to be instantiated
     * @param  token   a reference to the token that the behaviour is for
     * @param  posn     a double[3] that gives x,y,z coords of token
     * @param  angle    a double[3] that gives orientation of token about x,y,z
     */
    <T extends IBehaviour> IBehaviour createBehaviour(Class<T> rqdClass, IRenderable token, double[] posn, double[] angle) throws Exception;
}
