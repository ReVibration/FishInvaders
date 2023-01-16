package game;

import Framework.*;
import input.*;
import collision.*;
import invaders.*;

/**
 * Main is the top-level class for the FishInvaders game.
 * 
 * @author Marc Price & Bartek Siwak
 * @version 0.6
 */
public class Main
{
    // instance variables:
    // DECLARE a reference to the instance of the GameMgr, call it _game:
    private IGameMgr _game;
        

    
    /**
     * METHOD: Static Main method used for creating standalone apps
     *
     */
    public static void main(String[] args) throws Exception
    {
        Main fishInvaders = new Main();
        fishInvaders.run();
    }
    
    /**
     * Constructor for objects of class Main
     */
    public Main()
    {
        // INSTANTIATE managers:
        // Framework.ICoreMgr:
        ICoreMgr core = new CoreMgr();
        
        // Framework.IRenderableFactory:
        IRenderableFactory renderableMaker = new RenderableFactory(core);
        
        // collision.ICollisionMgr:
        ICollisionMgr collision = new CollisionMgr();
        
        // invaders.IBehaviourMgr:
        IBehaviourMgr behaviours = new BehaviourMgr(collision);
        
        // input.IInputPublisher:
        IInputPublisher keyb = new KeybHandler(core);
        
        // _game:
        _game = new GameMgr(keyb, core, behaviours, collision, renderableMaker);
    }      
    

    /**
     * METHOD: Run the simulation loop.  User presses escape to exit.
     *
     */
    public void run() throws Exception
    {
        // INITIALISE the game:
        _game.initialise();
        
        // RUN the game:
        _game.run();

    }
}
