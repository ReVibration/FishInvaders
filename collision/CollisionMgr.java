package collision;

import java.util.List;
import java.util.ArrayList;
import com.jme3.math.Vector3f;

/**
 * CollisionMgr is a simple collision manager that detects and signals a collision between two items.
 * 
 * @author Marc Price & Bartek Siwak 
 * @version 0.6 26/04/2022
 */
public class CollisionMgr implements ICollisionMgr
{
    // instance variables
    //DECLARE a reference to the ICollidable, call it _collidable:
    private List<ICollidable> _collidables;
    

    /**
     * Constructor for objects of class CollisionMgr
     */
    public CollisionMgr()
    {
        // instantiate _collidables:
        _collidables = new ArrayList<ICollidable>();
    }

    /**
     * Subscribe a collidable.
     * The collidable is any item that can collide within the world.
     * 
     * @param  collidable  a world object of type ICollidable - the collidable
     */
    public void addCollidable(ICollidable collidable)
    {
        // APPEND collidable to _collidables:
        _collidables.add(collidable);
    }
    
    /**
     * Unsubscribe a collidable.
     * The collidable is any item that can collide within the world.
     * 
     * @param  collidable  a world object of type ICollidable - the collidable
     */
    public void removeCollidable(ICollidable collidable)
    {
        // APPEND collidable to _collidables:
        _collidables.remove(collidable);
    }
    
    /**
     * Update the the manager - tell it to perform the next collision check.
     */
    public void update()
    {
        // CHECK each ICollidable against all others to see if they are colliding:
        // ITERATE through _collidables:
        for (int i=0; i<_collidables.size(); i++)
        {
            // ITERATE through remainder of _collidables:
            for (int j=i+1; j<_collidables.size(); j++)
            {
                // IF distance between the two ICollidables is less than 0.5:
                if (0.5 > _collidables.get(i).position().distance(_collidables.get(j).position()))
                {
                    // SIGNAL collision:
                    _collidables.get(j).collided();
                    _collidables.get(i).collided();
                }
            }
        }
    }
}

