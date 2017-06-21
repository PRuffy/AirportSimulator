package framework.environment;

import com.google.common.base.Objects;
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
  
  public boolean setEdgeAndNode(final String edgeId, final String departureNodeId, final String arrivingNodeId) {
    boolean _xblockexpression = false;
    {
      GraphNode node1 = new GraphNode();
      GraphNode node2 = new GraphNode();
      GraphEdge edge = new GraphEdge();
      for (final GraphNode n : this.nodeList) {
        {
          String _id = n.getId();
          boolean _equals = Objects.equal(_id, departureNodeId);
          if (_equals) {
            node1 = this.nodeList.get(this.nodeList.indexOf(n));
          }
          String _id_1 = n.getId();
          boolean _equals_1 = Objects.equal(_id_1, arrivingNodeId);
          if (_equals_1) {
            node2 = this.nodeList.get(this.nodeList.indexOf(n));
          }
        }
      }
      for (final GraphEdge e : this.edgeList) {
        String _id = e.getId();
        boolean _equals = Objects.equal(_id, edgeId);
        if (_equals) {
          edge = this.edgeList.get(this.edgeList.indexOf(e));
        }
      }
      edge.addDepartureNode(node1);
      edge.addArrivalNode(node2);
      _xblockexpression = node1.addLeavingEdge(edge);
    }
    return _xblockexpression;
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
