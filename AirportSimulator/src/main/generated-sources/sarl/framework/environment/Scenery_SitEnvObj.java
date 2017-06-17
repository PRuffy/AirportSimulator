package framework.environment;

import framework.environment.AbstractSituatedObject;
import framework.math.Point2f;
import framework.math.Shape2f;
import io.sarl.lang.annotation.DefaultValue;
import io.sarl.lang.annotation.DefaultValueSource;
import io.sarl.lang.annotation.DefaultValueUse;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import java.util.UUID;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author promet
 */
@SarlSpecification("0.5")
@SarlElementType(8)
@SuppressWarnings("all")
public abstract class Scenery_SitEnvObj extends AbstractSituatedObject {
  @Override
  @Pure
  @SyntheticMember
  public Scenery_SitEnvObj clone() {
    try {
      return (Scenery_SitEnvObj) super.clone();
    } catch (Throwable exception) {
      throw new Error(exception);
    }
  }
  
  /**
   * @optionalparam id the identifier of the object.
   * @optionalparam shape the shape of the body, considering that it is centered at the (0,0) position.
   * @optionalparam position is the position of the object.
   */
  @SyntheticMember
  @DefaultValueUse("java.util.UUID,framework.math.Shape2f<?>,framework.math.Point2f")
  public Scenery_SitEnvObj(final UUID id, final Shape2f<?> shape) {
    super(id, shape);
  }
  
  /**
   * @param id the identifier of the object.
   * @param shape the shape of the body, considering that it is centered at the (0,0) position.
   * @param position is the position of the object.
   */
  @SyntheticMember
  @DefaultValueSource
  public Scenery_SitEnvObj(final UUID id, final Shape2f<?> shape, @DefaultValue("framework.environment.AbstractSituatedObject#NEW_0") final Point2f position) {
    super(id, shape, position);
  }
  
  /**
   * @optionalparam id the identifier of the object.
   * @optionalparam shape the shape of the body, considering that it is centered at the (0,0) position.
   * @optionalparam position is the position of the object.
   * @optionalparam name is the name of the object.
   */
  @SyntheticMember
  @DefaultValueUse("java.util.UUID,framework.math.Shape2f<?>,framework.math.Point2f,java.lang.String")
  public Scenery_SitEnvObj(final UUID id, final Shape2f<?> shape, final String name) {
    super(id, shape, name);
  }
  
  /**
   * @param id the identifier of the object.
   * @param shape the shape of the body, considering that it is centered at the (0,0) position.
   * @param x is the position of the object.
   * @param y is the position of the object.
   */
  @SyntheticMember
  public Scenery_SitEnvObj(final UUID id, final Shape2f<?> shape, final float x, final float y) {
    super(id, shape, x, y);
  }
  
  /**
   * @param id the identifier of the object.
   * @param shape the shape of the body, considering that it is centered at the (0,0) position.
   * @param position is the position of the object.
   * @param name is the name of the object.
   */
  @SyntheticMember
  @DefaultValueSource
  public Scenery_SitEnvObj(final UUID id, final Shape2f<?> shape, @DefaultValue("framework.environment.AbstractSituatedObject#NEW_1") final Point2f position, final String name) {
    super(id, shape, position, name);
  }
  
  @SyntheticMember
  private final static long serialVersionUID = 1L;
}
