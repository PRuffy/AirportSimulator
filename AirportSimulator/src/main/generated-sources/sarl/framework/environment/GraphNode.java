package framework.environment;

import framework.environment.GraphEdge;
import framework.environment.Wall;
import framework.math.Point2f;
import framework.math.Rectangle2f;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import java.util.ArrayList;
import java.util.Objects;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author stay
 */
@SarlSpecification("0.5")
@SarlElementType(8)
@SuppressWarnings("all")
public class GraphNode {
  private ArrayList<GraphEdge> leavingEdges;
  
  private Rectangle2f surface;
  
  private ArrayList<Wall> staticObject;
  
  private String id;
  
  private String name;
  
  public GraphNode() {
    this.id = null;
    ArrayList<Wall> _arrayList = new ArrayList<Wall>();
    this.staticObject = _arrayList;
    this.surface = null;
    ArrayList<GraphEdge> _arrayList_1 = new ArrayList<GraphEdge>();
    this.leavingEdges = _arrayList_1;
    this.name = null;
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
  
  @Pure
  public String getId() {
    return this.id;
  }
  
  public boolean addLeavingEdge(final GraphEdge e) {
    return this.leavingEdges.add(e);
  }
  
  public boolean addWall(final Wall w) {
    return this.staticObject.add(w);
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
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }
    if (!Objects.equals(this.name, other.name)) {
      return false;
    }
    return super.equals(obj);
  }
  
  @Override
  @Pure
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    final int prime = 31;
    result = prime * result + Objects.hashCode(this.id);
    result = prime * result + Objects.hashCode(this.name);
    return result;
  }
}
