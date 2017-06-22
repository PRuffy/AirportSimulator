package framework.environment;

import framework.environment.AgentBody;
import framework.environment.GraphNode;
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
public class GraphEdge {
  private GraphNode departureNode;
  
  private GraphNode arrivalNode;
  
  private String id;
  
  private Rectangle2f surface;
  
  private ArrayList<Wall> staticObject;
  
  private String name;
  
  private ArrayList<AgentBody> agentObject;
  
  public GraphEdge() {
    this.departureNode = null;
    this.arrivalNode = null;
    this.id = null;
    this.name = null;
    ArrayList<Wall> _arrayList = new ArrayList<Wall>();
    this.staticObject = _arrayList;
    ArrayList<AgentBody> _arrayList_1 = new ArrayList<AgentBody>();
    this.agentObject = _arrayList_1;
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
  
  public boolean addAgent(final AgentBody agent) {
    return this.agentObject.add(agent);
  }
  
  public boolean removeAgent(final AgentBody agent) {
    return this.agentObject.remove(agent);
  }
  
  public GraphNode addDepartureNode(final GraphNode n) {
    return this.departureNode = n;
  }
  
  public GraphNode addArrivalNode(final GraphNode n) {
    return this.arrivalNode = n;
  }
  
  @Pure
  public String getId() {
    return this.id;
  }
  
  public boolean addWall(final Wall w) {
    return this.staticObject.add(w);
  }
  
  @Pure
  public Rectangle2f getSurface() {
    return this.surface;
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
