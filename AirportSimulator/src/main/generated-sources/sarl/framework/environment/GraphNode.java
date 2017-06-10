package framework.environment;

import framework.environment.GraphEdge;
import framework.math.Point2f;
import framework.math.Rectangle2f;
import framework.math.Shape2f;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import java.util.ArrayList;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author stay
 */
@SarlSpecification("0.5")
@SarlElementType(8)
@SuppressWarnings("all")
public class GraphNode {
  private ArrayList<GraphEdge> arrivingEdges;
  
  private ArrayList<GraphEdge> leavingEdges;
  
  private Rectangle2f surface;
  
  private ArrayList<Shape2f<?>> staticObject;
  
  private int number;
  
  public GraphNode() {
    this.number = 0;
    this.staticObject = null;
    this.surface = null;
    this.leavingEdges = null;
    this.arrivingEdges = null;
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
    GraphNode other = (GraphNode) obj;
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
