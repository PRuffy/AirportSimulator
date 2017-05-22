package framework.environment;

import framework.math.Shape2f;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;

/**
 * Object on the environment.
 * 
 * @author St&eacute;phane GALLAND &lt;stephane.galland@utbm.fr&gt;
 * @version $Name$ $Revision$ $Date$
 */
@FunctionalInterface
@SarlSpecification("0.5")
@SarlElementType(9)
@SuppressWarnings("all")
public interface ShapedObject {
  /**
   * Replies the 2D shape that is representing the object.
   * The coordinates of the replied shape depends on the current
   * position of the object.
   * 
   * @return the shape of this object.
   */
  public abstract Shape2f<?> getShape();
}
