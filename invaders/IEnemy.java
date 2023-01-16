package invaders;

import Framework.ICoreMgr;

/**
 * IEnemy: all enemy behaviours must implement this.
 * 
 * @author Marc Price 
 * @version 0.6
 */
public interface IEnemy
{
    /**
     * METHOD: Initialise fields
     * 
     * @param core a reference to the ICoreMgr instancce
     */
    void initialise(ICoreMgr core);
}
