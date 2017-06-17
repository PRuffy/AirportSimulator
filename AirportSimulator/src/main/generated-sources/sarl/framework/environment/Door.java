package framework.environment;

import framework.environment.Scenery_SitEnvObj;
import framework.math.Point2f;
import framework.math.Shape2f;
import io.sarl.lang.annotation.DefaultValue;
import io.sarl.lang.annotation.DefaultValueSource;
import io.sarl.lang.annotation.DefaultValueUse;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSourceCode;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import java.util.UUID;
import org.eclipse.xtext.xbase.lib.Pure;

@SarlSpecification("0.5")
@SarlElementType(8)
@SuppressWarnings("all")
public class Door extends Scenery_SitEnvObj {
  @DefaultValueSource
  public Door(final UUID id, final Shape2f<?> shape, @DefaultValue("framework.environment.Door#NEW_0") final Point2f position, final String name) {
    super(id, shape, position, name);
  }
  
  /**
   * Default value for the parameter position
   */
  @SyntheticMember
  @SarlSourceCode("null")
  private final static Point2f $DEFAULT_VALUE$NEW_0 = null;
  
  @DefaultValueUse("java.util.UUID,framework.math.Shape2f<?>,framework.math.Point2f,java.lang.String")
  @SyntheticMember
  public Door(final UUID id, final Shape2f<?> shape, final String name) {
    this(id, shape, $DEFAULT_VALUE$NEW_0, name);
  }
  
  @Override
  @Pure
  @SyntheticMember
  public Door clone() {
    try {
      return (Door) super.clone();
    } catch (Throwable exception) {
      throw new Error(exception);
    }
  }
  
  @SyntheticMember
  private final static long serialVersionUID = 1204295124L;
}
