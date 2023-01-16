package invaders;

import Framework.IRenderableFactory;

/**
 * IPlayer: all player behaviours must implement this.
 * 
 * @author Heir Flick 
 * @version 0.6
 */
public interface IPlayer
{
    /**
     * METHOD: Initialise fields
     * 
     * @param behaviours a reference to the IBehaviourMgr instance
     * @param thingMaker a reference to the IRenderableFactory instance
     */
    void initialise(IBehaviourMgr behaviours, IRenderableFactory thingMaker);
}
