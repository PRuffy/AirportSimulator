package framework.environment;

import framework.environment.ShapedObject;
import framework.math.Point2f;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import java.io.Serializable;
import java.util.UUID;

/**
 * Object on the environment.
 * 
 * @author St&eacute;phane GALLAND &lt;stephane.galland@utbm.fr&gt;
 * @version $Name$ $Revision$ $Date$
 */
@SarlSpecification("0.5")
@SarlElementType(9)
@SuppressWarnings("all")
public interface SituatedObject extends ShapedObject, Cloneable, Comparable<SituatedObject> {
  /**
   * Clone the object.
   * 
   * @return the clone.
   */
  public abstract SituatedObject clone();
  
  /**
   * Replies the type of the object.
   * 
   * @return the type of the object.
   */
  public abstract Serializable getType();
  
  /**
   * Replies the identifier of the object.
   * 
   * @return the identifier of the object.
   */
  public abstract UUID getID();
  
  /**
   * Replies the name of the object.
   * 
   * The name is defined only for displaying purpose.
   * 
   * @return the name of the object.
   */
  public abstract String getName();
  
  /**
   * Replies the position of the object.
   * 
   * @return the x-coordinate of the position of this object.
   */
  public abstract float getX();
  
  /**
   * Replies the position of the object.
   * 
   * @return the y-coordinate of the position of this object.
   */
  public abstract float getY();
  
  /**
   * Replies the position of the object.
   * 
   * @return the position of the object.
   */
  public abstract Point2f getPosition();
}
