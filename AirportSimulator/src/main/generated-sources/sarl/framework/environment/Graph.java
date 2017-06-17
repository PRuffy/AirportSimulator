package framework.environment;

import framework.environment.GraphEdge;
import framework.environment.GraphNode;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import java.util.ArrayList;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author stay
 */
@SarlSpecification("0.5")
@SuppressWarnings("all")
public class Graph {
  private ArrayList<GraphNode> nodeList;
  
  private ArrayList<GraphEdge> edgeList;
  
  public Graph() {
    ArrayList<GraphNode> _arrayList = new ArrayList<GraphNode>();
    this.nodeList = _arrayList;
    ArrayList<GraphEdge> _arrayList_1 = new ArrayList<GraphEdge>();
    this.edgeList = _arrayList_1;
  }
  
  public boolean addNode(final GraphNode node) {
    return this.nodeList.add(node);
  }
  
  public boolean addEdge(final GraphEdge edge) {
    return this.edgeList.add(edge);
  }
  
  public void printNode() {
    for (final GraphNode n : this.nodeList) {
      System.out.println(n.getId());
    }
  }
  
  @Pure
  public GraphNode getNode(final String id) {
    for (final GraphNode n : this.nodeList) {
      String _id = n.getId();
      boolean _tripleEquals = (_id == id);
      if (_tripleEquals) {
        return n;
      }
    }
    return null;
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
    Graph other = (Graph) obj;
    if (this.nodeList == null) {
      if (other.nodeList != null)
        return false;
    } else if (!this.nodeList.equals(other.nodeList))
      return false;
    if (this.edgeList == null) {
      if (other.edgeList != null)
        return false;
    } else if (!this.edgeList.equals(other.edgeList))
      return false;
    return super.equals(obj);
  }
  
  @Override
  @Pure
  @SyntheticMember
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.nodeList== null) ? 0 : this.nodeList.hashCode());
    result = prime * result + ((this.edgeList== null) ? 0 : this.edgeList.hashCode());
    return result;
  }
}
