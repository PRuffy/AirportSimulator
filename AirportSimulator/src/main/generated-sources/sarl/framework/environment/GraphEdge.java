package framework.environment;

import framework.environment.GraphNode;
import framework.math.Point2f;
import framework.math.Rectangle2f;
import framework.math.Shape2f;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import java.util.ArrayList;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author stay
 */
@SarlSpecification("0.5")
@SuppressWarnings("all")
public class GraphEdge {
  private GraphNode departureNode;
  
  private GraphNode arrivalNode;
  
  private String id;
  
  private Rectangle2f surface;
  
  private ArrayList<Shape2f<?>> staticObject;
  
  private String name;
  
  public GraphEdge() {
    this.departureNode = null;
    this.arrivalNode = null;
    this.id = null;
    this.name = null;
    this.staticObject = null;
  }
  
  public String setId(final String id) {
    return this.id = id;
  }
  
  public String setName(final String name) {
    return this.name = name;
  }
  
  public Rectangle2f defineSurface(final Point2f p1, final Point2f p2) {
    Rectangle2f _rectangle2f = new Rectangle2f(p1, p2);
    return this.surface = _rectangle2f;
  }
  
  public GraphNode addDepartureNode(final GraphNode n) {
    return this.departureNode = n;
  }
  
  public GraphNode addArrivalNode(final GraphNode n) {
    return this.arrivalNode = n;
  }
  
  public void printLeaving() {
    this.departureNode.printProperty();
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
    if (this.departureNode == null) {
      if (other.departureNode != null)
        return false;
    } else if (!this.departureNode.equals(other.departureNode))
      return false;
    if (this.arrivalNode == null) {
      if (other.arrivalNode != null)
        return false;
    } else if (!this.arrivalNode.equals(other.arrivalNode))
      return false;
    if (this.id == null) {
      if (other.id != null)
        return false;
    } else if (!this.id.equals(other.id))
      return false;
    if (this.surface == null) {
      if (other.surface != null)
        return false;
    } else if (!this.surface.equals(other.surface))
      return false;
    if (this.staticObject == null) {
      if (other.staticObject != null)
        return false;
    } else if (!this.staticObject.equals(other.staticObject))
      return false;
    if (this.name == null) {
      if (other.name != null)
        return false;
    } else if (!this.name.equals(other.name))
      return false;
    return super.equals(obj);
  }
  
  @Override
  @Pure
  @SyntheticMember
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.departureNode== null) ? 0 : this.departureNode.hashCode());
    result = prime * result + ((this.arrivalNode== null) ? 0 : this.arrivalNode.hashCode());
    result = prime * result + ((this.id== null) ? 0 : this.id.hashCode());
    result = prime * result + ((this.surface== null) ? 0 : this.surface.hashCode());
    result = prime * result + ((this.staticObject== null) ? 0 : this.staticObject.hashCode());
    result = prime * result + ((this.name== null) ? 0 : this.name.hashCode());
    return result;
  }
}
