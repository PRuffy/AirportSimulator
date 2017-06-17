package framework.environment;

import framework.environment.AgentBody;
import framework.environment.Frustum;
import framework.math.Shape2f;
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
public abstract class Body_Mover extends AgentBody {
  @Override
  @Pure
  @SyntheticMember
  public Body_Mover clone() {
    try {
      return (Body_Mover) super.clone();
    } catch (Throwable exception) {
      throw new Error(exception);
    }
  }
  
  /**
   * @param id
   * @param shape the shape of the body, considering that it is centered at the (0,0) position.
   * @param frustum the field-of-view associated to the body.
   */
  @SyntheticMember
  public Body_Mover(final UUID id, final Shape2f<?> shape, final Frustum frustum) {
    super(id, shape, frustum);
  }
  
  /**
   * @param id
   * @param shape the shape of the body, considering that it is centered at the (0,0) position.
   * @param maxLinearSpeed is the maximal linear speed.
   * @param maxLinearAcceleration is the maximal linear acceleration.
   * @param maxAngularSpeed is the maximal angular speed.
   * @param maxAngularAcceleration is the maximal angular acceleration.
   * @param frustum the field-of-view associated to the body.
   */
  @SyntheticMember
  public Body_Mover(final UUID id, final Shape2f<?> shape, final float maxLinearSpeed, final float maxLinearAcceleration, final float maxAngularSpeed, final float maxAngularAcceleration, final Frustum frustum) {
    super(id, shape, maxLinearSpeed, maxLinearAcceleration, maxAngularSpeed, maxAngularAcceleration, frustum);
  }
  
  @SyntheticMember
  private final static long serialVersionUID = 1L;
}
