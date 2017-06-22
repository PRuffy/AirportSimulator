package framework;

import framework.GUI;
import framework.environment.WorldModel;
import framework.time.TimeManager;
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
    WorldModel environment = new WorldModel(MainProgram.WORLD_SIZE_X, MainProgram.WORLD_SIZE_Y, MainProgram.filename);
    TimeManager _timeManager = environment.getTimeManager();
    GUI gui = new GUI(MainProgram.WORLD_SIZE_X, MainProgram.WORLD_SIZE_Y, _timeManager);
    System.out.println("fin");
  }
  
  @SyntheticMember
  public MainProgram() {
    super();
  }
}
