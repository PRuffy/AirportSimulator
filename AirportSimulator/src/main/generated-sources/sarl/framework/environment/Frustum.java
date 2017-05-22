package framework.environment;

import framework.environment.SituatedObject;
import framework.math.Point2f;
import framework.math.Shape2f;
import framework.math.Vector2f;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import java.io.Serializable;
import java.util.Iterator;
import java.util.UUID;

/**
 * Define a field-of-view.
 * 
 * @author St&eacute;phane GALLAND &lt;stephane.galland@utbm.fr&gt;
 * @version $Name$ $Revision$ $Date$
 */
@SarlSpecification("0.5")
@SarlElementType(9)
@SuppressWarnings("all")
public interface Frustum extends Serializable, Cloneable {
  /**
   * Replies the identifier of the owner of this frustum.
   * 
   * @return the identifier of the frustum's owner.
   */
  public abstract UUID getOwner();
  
  /**
   * Replies a shape that is representing this frustum.
   * 
   * @param position the position of the owner of the frustum.
   * @param orientation the orientation of the owner of the frustum.
   * @return the shape.
   */
  public abstract Shape2f<?> toShape(final Point2f position, final Vector2f orientation);
  
  /**
   * Create a filtering iterator.
   * The replied iterator may filtering the objects of the given iterator.
   * 
   * @param iterator the original iterator.
   * @return the filtering iterator, or the given <code>iterator</code> if
   * there is no filtering.
   */
  public abstract <D extends SituatedObject> Iterator<D> filter(final Iterator<D> iterator);
}
