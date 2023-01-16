package Framework;




/**
 * The IRenderable interfaces all properties/behaviour to display a token in an Env3D simulation.
 * 
 * @author Marc Price 
 * @version 0.5
 */
public interface IRenderable
{
    /**
     * Initialise the model, texture, and size.
     * 
     * @param  mod   a String holding the path to the model file.
     * @param  tex   a String holding the path to the texture image file.
     * @param  size  a double holding the scale of the object as a fraction (between 0.0 and 1.0).
     */
    void initialise(String mod, String tex, double size);
    
    /**
     * METHOD: Place the token at the given position within the aquarium
     *
     * @param  coords   the new position of the token as an array of three doubles.  
     */
    void position(double ...coords);
    
    /**
     * METHOD: Place the token at the given orientation within the aquarium
     *
     * @param  coords   the new orientation (x,y,z) of the token as an array of three doubles
     */
    void orientation(double ...coords);
    
    /**
     * METHOD: Scale the token by the given multiplier
     *
     * @param  scale   the new scale of the token as a double
     */
    void scale(double scale);
}

