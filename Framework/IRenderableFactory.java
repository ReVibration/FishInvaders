package Framework;


/**
 * IRenderableFactory: implementations create displayable tokens.
 * 
 * @author Marc Price 
 * @version 0.1
 */
public interface IRenderableFactory
{
    /**
     * Create and return new IRenderable instance.
     * 
     * @param   model    specifies the 3D model to be used
     * @param   texture  specifies the texture to be used
     * @param   posn    a double[3] that gives the x,y,z location coords
     * @param   angle   a double[3] that gives the orientation about the x,y,z axes
     * @param   scale   a double that specifies the scale-factor (between 0.0 and 1.0)
     */
    IRenderable createRenderable(String model, String texture, double[] posn, double[] angle, double scale);
}
