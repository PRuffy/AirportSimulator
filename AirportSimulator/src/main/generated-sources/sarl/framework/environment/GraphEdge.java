package framework.environment;

import framework.environment.GraphNode;
import framework.math.Point2f;
import framework.math.Rectangle2f;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author stay
 */
@SarlSpecification("0.5")
@SarlElementType(8)
@SuppressWarnings("all")
public class GraphEdge {
  private GraphNode departureNode;
  
  private GraphNode arrivalNode;
  
  private int number;
  
  private Rectangle2f surface;
  
  public GraphEdge() {
    this.departureNode = null;
    this.arrivalNode = null;
    this.surface = null;
    this.number = 0;
  }
  
  public int setNumber(final int number) {
    return this.number = number;
  }
  
  public Rectangle2f defineSurface(final Point2f p1, final Point2f p2) {
    Rectangle2f _rectangle2f = new Rectangle2f(p1, p2);
    return this.surface = _rectangle2f;
  }
  
  @Override
  @Pure
  @SyntheticMember
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    GraphEdge other = (GraphEdge) obj;
    if (other.number != this.number)
      return false;
    return super.equals(obj);
  }
  
  @Override
  @Pure
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    final int prime = 31;
    result = prime * result + this.number;
    return result;
  }
}
