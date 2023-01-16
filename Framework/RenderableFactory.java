package Framework;


/**
 * RenderableFactory: a class to create displayable tokens.
 * 
 * @author Marc Price 
 * @version 0.1
 */
public class RenderableFactory implements IRenderableFactory
{
    // instance variables - none
    // DECLARE a reference to the ICore, call it _core:
    ICoreMgr _core;

    /**
     * Constructor for objects of class RenderableFactory
     */
    public RenderableFactory(ICoreMgr core)
    {
        // ASSIGN _core to core:
        _core = core;
    }

    /**
     * Create and return new IRenderable instance.
     * 
     * @param   model    specifies the 3D model to be used
     * @param   texture  specifies the texture to be used
     * @param   posn    a double[3] that gives the x,y,z location coords
     * @param   angle   a double[3] that gives the orientation about the x,y,z axes
     * @param   scale   a double that specifies the scale-factor (between 0.0 and 1.0)
     */
    public IRenderable createRenderable(String model, String texture, double[] posn, double[] angle, double scale)
    {
        // CHECK parameters:
        
        // CREATE and INITIALISE the IRenderable, call it 'token':
        IRenderable token = new Renderable();
        token.initialise(model, texture, scale);
        
        // INITIALISE token's position and orientation:
        token.position(posn);
        token.orientation(angle);
        
        // ADD token to the scene:
        _core.addRenderable(token);

        // RETURN the token
        return token;
    }
}
