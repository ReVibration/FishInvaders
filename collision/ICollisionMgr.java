package collision;


/**
 * ICollisionMgr implementations detect and signal a collision between two items.
 * 
 * @author Daffy Duck 
 * @version 0.6
 */
public interface ICollisionMgr
{
    /**
     * Subscribe a collidable.
     * The collidable is any item that can collide within the world.
     * 
     * @param  collidable  a world object of type ICollidable - the collidable
     */
    void addCollidable(ICollidable collidable);
    
    /**
     * Unsubscribe a collidable.
     * The collidable is any item that can collide within the world.
     * 
     * @param  collidable  a world object of type ICollidable - the collidable
     */
    void removeCollidable(ICollidable collidable);
    
    /**
     * Update the the manager.
     */
    public void update();    
}
