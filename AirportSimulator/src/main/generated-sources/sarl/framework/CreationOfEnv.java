package framework;

import framework.environment.Graph;
import framework.environment.GraphEdge;
import framework.environment.GraphNode;
import framework.environment.QuadTree;
import framework.environment.SituatedObject;
import framework.math.Point2f;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author stay
 */
@SarlSpecification("0.5")
@SuppressWarnings("all")
public class CreationOfEnv {
  public void createGraph(final String filename, final Graph graph, final QuadTree<SituatedObject> objTree) {
    try {
      DocumentBuilderFactory dbFactory = null;
      dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder dBuilder = null;
      dBuilder = dbFactory.newDocumentBuilder();
      Document doc = null;
      doc = dBuilder.parse(filename);
      doc.getDocumentElement().normalize();
      NodeList nodeList = null;
      nodeList = doc.getElementsByTagName("node");
      NodeList edgeList = null;
      edgeList = doc.getElementsByTagName("edge");
      int i = 0;
      for (i = 0; (i < nodeList.getLength()); i++) {
        {
          Node node = null;
          node = nodeList.item(i);
          short _nodeType = node.getNodeType();
          boolean _tripleEquals = (_nodeType == Node.ELEMENT_NODE);
          if (_tripleEquals) {
            GraphNode graphNode = new GraphNode();
            Element eElement = null;
            eElement = ((Element) node);
            graphNode.setId(eElement.getAttribute("id").toString());
            graphNode.setName(eElement.getElementsByTagName("name").item(0).getTextContent().toString());
            NodeList eCoordinate = null;
            eCoordinate = eElement.getElementsByTagName("coordinates");
            Node _item = eCoordinate.item(0);
            Element ePoints = ((Element) _item);
            Float x1 = Float.valueOf(ePoints.getElementsByTagName("xvalue").item(0).getTextContent().toString());
            Float y1 = Float.valueOf(ePoints.getElementsByTagName("yvalue").item(0).getTextContent().toString());
            Point2f point1 = null;
            Point2f _point2f = new Point2f((x1).floatValue(), (y1).floatValue());
            point1 = _point2f;
            Float x2 = Float.valueOf(ePoints.getElementsByTagName("xvalue").item(1).getTextContent().toString());
            Float y2 = Float.valueOf(ePoints.getElementsByTagName("yvalue").item(1).getTextContent().toString());
            Point2f point2 = null;
            Point2f _point2f_1 = new Point2f((x2).floatValue(), (y2).floatValue());
            point2 = _point2f_1;
            graphNode.defineSurface(point1, point2);
            graph.addNode(graphNode);
          }
        }
      }
      for (i = 0; (i < edgeList.getLength()); i++) {
        {
          Node edge = null;
          edge = edgeList.item(i);
          short _nodeType = edge.getNodeType();
          boolean _tripleEquals = (_nodeType == Node.ELEMENT_NODE);
          if (_tripleEquals) {
            GraphEdge graphEdge = new GraphEdge();
            Element eElement = null;
            eElement = ((Element) edge);
            graphEdge.setId(eElement.getAttribute("id").toString());
            graphEdge.setName(eElement.getElementsByTagName("name").item(0).getTextContent().toString());
            NodeList eCoordinate = null;
            eCoordinate = eElement.getElementsByTagName("coordinates");
            Node _item = eCoordinate.item(0);
            Element ePoints = ((Element) _item);
            Float x1 = Float.valueOf(ePoints.getElementsByTagName("xvalue").item(0).getTextContent().toString());
            Float y1 = Float.valueOf(ePoints.getElementsByTagName("yvalue").item(0).getTextContent().toString());
            Point2f point1 = null;
            Point2f _point2f = new Point2f((x1).floatValue(), (y1).floatValue());
            point1 = _point2f;
            Float x2 = Float.valueOf(ePoints.getElementsByTagName("xvalue").item(1).getTextContent().toString());
            Float y2 = Float.valueOf(ePoints.getElementsByTagName("yvalue").item(1).getTextContent().toString());
            Point2f point2 = null;
            Point2f _point2f_1 = new Point2f((x2).floatValue(), (y2).floatValue());
            point2 = _point2f_1;
            graphEdge.defineSurface(point1, point2);
            String departureNode = null;
            String arrivingNode = null;
            departureNode = eElement.getElementsByTagName("leaving").item(0).getTextContent();
            System.out.println(eElement.getAttribute("id"));
            System.out.println(eElement.getElementsByTagName("leaving").item(0).getTextContent());
            graphEdge.addDepartureNode(graph.getNode(departureNode));
            arrivingNode = eElement.getElementsByTagName("arriving").item(0).getTextContent();
            graphEdge.addArrivalNode(graph.getNode(arrivingNode));
            graph.addEdge(graphEdge);
          }
        }
      }
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        e.printStackTrace();
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @SyntheticMember
  public CreationOfEnv() {
    super();
  }
}
