package game;

import java.util.List;
import java.util.ArrayList;

import Framework.ICoreMgr;
import Framework.IRenderableFactory;
import Framework.IRenderable;
import input.IInputPublisher;
import input.IInputListener;
import collision.ICollisionMgr;
import collision.ICollidable;
import invaders.IBehaviourMgr;
import invaders.IBehaviour;
import invaders.IPlayer;
import invaders.IEnemy;
import invaders.PlayerBehaviour;
import invaders.InvaderBehaviour;

/**
 * GameMgr: the manager class that actually runs the game.
 * 
 * @author Marc Price 
 * @version 0.6
 */
public class GameMgr implements IGameMgr
{
    // instance constants:
    //DECLARE the model name of all tokens:
    private static String _model = "models/billboard/billboard.obj";
    
    //DECLARE the texture of all invader tokens:
    private static String _invaderTexture = "textures/javaFish/PiranhaGreen.png";
    
    //DECLARE the texture of the player token:
    private static String _playerTexture = "textures/javaFish/JavaFish.png";
        
    //DECLARE the texture of the barrier token:
    private static String _barrierTexture = "textures/javaFish/Target.png";
        
    // instance variables:
    // DECLARE a reference to the keyboard handler, call it _keyinput:
    private IInputPublisher _keyInput;
        
    // DECLARE a reference to the ICoreMgr, call it _core:
    private ICoreMgr _core;
    
    //DECLARE a reference to the IBehaviourMgr, call it _behaviours:
    private IBehaviourMgr _behaviours;
        
    //DECLARE a reference to the ICollisionMgr, call it _behaviours:
    private ICollisionMgr _collision;
        
    //DECLARE a reference to the IRenderableFactory, call it _thingMaker:
    private IRenderableFactory _thingMaker;
    
    // DECLARE a boolean that signals when the simulation loop should be exited:
    private boolean endSim = false;

        
    
    /**
     * Constructor for objects of class GameMgr
     */
    public GameMgr(IInputPublisher keys, ICoreMgr core, IBehaviourMgr behaviours, ICollisionMgr collision,
                                                                                                    IRenderableFactory thingMaker)
    {
        // initialise instance variables
        // _keyinput:
        _keyInput = keys;
        
        // _core:
        _core = core;
        
        // _behaviours:
        _behaviours = behaviours;
        
        // _collision:
        _collision = collision;
        
        // _thingMaker:
        _thingMaker = thingMaker;
    }
    
    /**
     * Initialise the IGameMgr
     */
    public void initialise() throws Exception
    {
        // CREATE the environment:
        _core.createWorld();
        
        // CREATE a player...
        createPlayer();
        
        // CREATE some barriers...
        for (int x=2; x<9; x+=2)
            createBarrier((double)x, 2.0, 1.0);
        
        // CREATE some invaders...        
        for (int x=1; x<8; x++)
        {
            for (int y=7; y>3; y--)
            {
                createInvader((double)x, (double)y-0.1, 1.0);
            }
        }
    }

    /**
     * Run update loop
     */
    public void run() throws Exception
    {
        // Start simulation loop:
        while (!endSim)
        {
            // UPDATE STAGE:
            // IF: user has requested simulation loop exit (ie escape pressed):
            if (_core.world().getKey() == 1)
            {
                // SET: render loop exit condition
                endSim = true;
            }
            
            // UPDATE keyboard handler:
            _keyInput.update();
            
            // UPDATE BehaviourMgr:
            _behaviours.update();
            
            // UPDATE CollisionMgr:
            _collision.update();
            
            // UPDATE the environment
            _core.update();
        }
        
        // EXIT: cleanly by closing-down the environment:
        _core.destroyWorld();
       

    }
    
    
    /**
     * Add the player to the scene
     */
    private void createPlayer() throws Exception
    {
        // CREATE new player token:
        double[] playerLocn = {4.0, 1.0, 1.0};
        double[] angle = {90.0,-90.0,0.0};
        IRenderable token = _thingMaker.createRenderable(_model, _playerTexture, playerLocn, angle, 0.4);
                
        // CREATE associated behaviour:
        IBehaviour player = _behaviours.createBehaviour(PlayerBehaviour.class, token, playerLocn, angle);
        
        // INITIALISE player behaviour:
        ((IPlayer) player).initialise(_behaviours, _thingMaker);
        
        // SUBSCRIBE player to keyboard handler:
        _keyInput.subscribe((IInputListener) player);
        
        // ADD to collision manager:
        _collision.addCollidable((ICollidable) player);
    }
    
    /**
     * Add an invader to the scene
     * 
     */
    private void createInvader(double ...coords) throws Exception
    {
        // CREATE new player token:
        double[] angle = {-90.0,90.0,0.0};
        IRenderable token = _thingMaker.createRenderable(_model, _invaderTexture, coords, angle, 0.5);
                
        // CREATE associated behaviour:
        IBehaviour invader = _behaviours.createBehaviour(InvaderBehaviour.class, token, coords, angle);
        
        // INITIALISE invader as an enemy:
        ((IEnemy) invader).initialise(_core);
        
        // ADD to collision manager:
        _collision.addCollidable((ICollidable) invader);
    }
    
    /**
     * Add a barrier to the scene
     * 
     */
    private void createBarrier(double ...coords) throws Exception
    {
        // CREATE new player token:
        double[] angle = {0.0,90.0,0.0};
        IRenderable token = _thingMaker.createRenderable(_model, _barrierTexture, coords, angle, 0.5);
    }

}

