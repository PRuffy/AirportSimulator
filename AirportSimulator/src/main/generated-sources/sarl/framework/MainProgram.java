package framework;

import framework.CreationOfEnv;
import framework.environment.Graph;
import framework.environment.QuadTree;
import framework.environment.SituatedObject;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;

/**
 * @author stay
 */
@SarlSpecification("0.5")
@SuppressWarnings("all")
public class MainProgram {
  private final static float WORLD_SIZE_X = 200f;
  
  private final static float WORLD_SIZE_Y = 200f;
  
  private final static String filename = "res/graphInfo.xml";
  
  public static void main(final String... argv) {
    Graph graph = new Graph();
    QuadTree<SituatedObject> objTree = null;
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
