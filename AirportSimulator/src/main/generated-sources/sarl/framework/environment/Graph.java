package framework.environment;

import framework.environment.GraphEdge;
import framework.environment.GraphNode;
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
    return super.equals(obj);
  }
  
  @Override
  @Pure
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    return result;
  }
}
