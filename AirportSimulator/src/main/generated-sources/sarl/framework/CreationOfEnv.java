package framework;

import framework.environment.Graph;
import framework.environment.GraphEdge;
import framework.environment.GraphNode;
import framework.environment.QuadTree;
import framework.environment.SituatedObject;
import framework.environment.Wall;
import framework.math.Point2f;
import framework.math.Rectangle2f;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import java.util.UUID;
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
@SarlElementType(8)
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
            NodeList eWall = null;
            eWall = eElement.getElementsByTagName("wall");
            int j = 0;
            for (j = 0; (j < eWall.getLength()); j++) {
              {
                Node wall = eWall.item(j);
                short _nodeType_1 = wall.getNodeType();
                boolean _tripleEquals_1 = (_nodeType_1 == Node.ELEMENT_NODE);
                if (_tripleEquals_1) {
                  NodeList eWallCoordinate = null;
                  eWallCoordinate = eElement.getElementsByTagName("coordinates");
                  Node _item_1 = eCoordinate.item(0);
                  Element eWallPoints = ((Element) _item_1);
                  Float wallX1 = Float.valueOf(eWallPoints.getElementsByTagName("xvalue").item(0).getTextContent().toString());
                  Float wallY1 = Float.valueOf(eWallPoints.getElementsByTagName("yvalue").item(0).getTextContent().toString());
                  Point2f wallPoint1 = null;
                  Point2f _point2f_2 = new Point2f((wallX1).floatValue(), (wallY1).floatValue());
                  wallPoint1 = _point2f_2;
                  Float wallX2 = Float.valueOf(eWallPoints.getElementsByTagName("xvalue").item(1).getTextContent().toString());
                  Float wallY2 = Float.valueOf(eWallPoints.getElementsByTagName("yvalue").item(1).getTextContent().toString());
                  Point2f wallPoint2 = null;
                  Point2f _point2f_3 = new Point2f((wallX2).floatValue(), (wallY2).floatValue());
                  wallPoint2 = _point2f_3;
                  UUID _randomUUID = UUID.randomUUID();
                  Rectangle2f _rectangle2f = new Rectangle2f(wallPoint1, wallPoint2);
                  Wall objWall = new Wall(_randomUUID, _rectangle2f, null, "wall");
                  graphNode.addWall(objWall);
                  objTree.add(objWall);
                }
              }
            }
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
            NodeList eWall = null;
            eWall = eElement.getElementsByTagName("wall");
            int j = 0;
            for (j = 0; (j < eWall.getLength()); j++) {
              {
                Node wall = eWall.item(j);
                short _nodeType_1 = wall.getNodeType();
                boolean _tripleEquals_1 = (_nodeType_1 == Node.ELEMENT_NODE);
                if (_tripleEquals_1) {
                  NodeList eWallCoordinate = null;
                  eWallCoordinate = eElement.getElementsByTagName("coordinates");
                  Node _item_1 = eCoordinate.item(0);
                  Element eWallPoints = ((Element) _item_1);
                  Float wallX1 = Float.valueOf(
                    eWallPoints.getElementsByTagName("xvalue").item(0).getTextContent().toString());
                  Float wallY1 = Float.valueOf(
                    eWallPoints.getElementsByTagName("yvalue").item(0).getTextContent().toString());
                  Point2f wallPoint1 = null;
                  Point2f _point2f_2 = new Point2f((wallX1).floatValue(), (wallY1).floatValue());
                  wallPoint1 = _point2f_2;
                  Float wallX2 = Float.valueOf(
                    eWallPoints.getElementsByTagName("xvalue").item(1).getTextContent().toString());
                  Float wallY2 = Float.valueOf(
                    eWallPoints.getElementsByTagName("yvalue").item(1).getTextContent().toString());
                  Point2f wallPoint2 = null;
                  Point2f _point2f_3 = new Point2f((wallX2).floatValue(), (wallY2).floatValue());
                  wallPoint2 = _point2f_3;
                  UUID _randomUUID = UUID.randomUUID();
                  Rectangle2f _rectangle2f = new Rectangle2f(wallPoint1, wallPoint2);
                  Wall objWall = new Wall(_randomUUID, _rectangle2f, null, 
                    "wall");
                  objTree.add(objWall);
                  graphEdge.addWall(objWall);
                }
              }
            }
            String departureNode = null;
            String arrivingNode = null;
            departureNode = eElement.getElementsByTagName("leaving").item(0).getTextContent();
            arrivingNode = eElement.getElementsByTagName("arriving").item(0).getTextContent();
            graph.addEdge(graphEdge);
            graph.setEdgeAndNode(graphEdge.getId(), departureNode, arrivingNode);
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
