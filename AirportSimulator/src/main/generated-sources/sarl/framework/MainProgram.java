package framework;

import framework.CreationOfEnv;
import framework.environment.Graph;
import framework.environment.QuadTree;
import framework.environment.SituatedObject;
import framework.math.Point2f;
import framework.math.Rectangle2f;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;

/**
 * @author stay
 */
@SarlSpecification("0.5")
@SarlElementType(8)
@SuppressWarnings("all")
public class MainProgram {
  private final static float WORLD_SIZE_X = 200f;
  
  private final static float WORLD_SIZE_Y = 200f;
  
  private final static String filename = "res/graphInfo.xml";
  
  public static void main(final String... argv) {
    Graph graph = new Graph();
    QuadTree<SituatedObject> objTree = null;
    Point2f _point2f = new Point2f(0, 0);
    Point2f _point2f_1 = new Point2f(MainProgram.WORLD_SIZE_X, MainProgram.WORLD_SIZE_Y);
    Rectangle2f _rectangle2f = new Rectangle2f(_point2f, _point2f_1);
    QuadTree<SituatedObject> _quadTree = new QuadTree<SituatedObject>(_rectangle2f);
    objTree = _quadTree;
    CreationOfEnv envInit = null;
    CreationOfEnv _creationOfEnv = new CreationOfEnv();
    envInit = _creationOfEnv;
    envInit.createGraph(MainProgram.filename, graph, objTree);
    System.out.println("fin");
  }
  
  @SyntheticMember
  public MainProgram() {
    super();
  }
}
