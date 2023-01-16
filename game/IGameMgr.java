package game;


/**
 * IGameMgr: the manager class that actually runs the game.
 *
 * @author Bartek Siwak & Marc Price
 * @version 0.1 26/04/2022
 */
public interface IGameMgr
{
    /**
     * Initialise the IGameMgr
     */
     void initialise() throws Exception;
    /**
     * Run update loop
     */
     void run() throws Exception;
}
