package framework.environment;

import framework.environment.Body_IOT;
import framework.environment.Frustum;
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
public class Screener extends Body_IOT {
  @DefaultValueSource
  public Screener(final UUID id, final Shape2f<?> shape, final Frustum frustum, @DefaultValue("framework.environment.Screener#NEW_0") final Point2f position, final String name) {
    super(id, shape, frustum);
    this.setName(name);
    this.setPosition(position);
  }
  
  /**
   * Default value for the parameter position
   */
  @SyntheticMember
  @SarlSourceCode("null")
  private final static Point2f $DEFAULT_VALUE$NEW_0 = null;
  
  @DefaultValueUse("java.util.UUID,framework.math.Shape2f<?>,framework.environment.Frustum,framework.math.Point2f,java.lang.String")
  @SyntheticMember
  public Screener(final UUID id, final Shape2f<?> shape, final Frustum frustum, final String name) {
    this(id, shape, frustum, $DEFAULT_VALUE$NEW_0, name);
  }
  
  @Override
  @Pure
  @SyntheticMember
  public Screener clone() {
    try {
      return (Screener) super.clone();
    } catch (Throwable exception) {
      throw new Error(exception);
    }
  }
  
  @SyntheticMember
  private final static long serialVersionUID = 1938389333L;
}
